package com.margaritalashina.mytrainingprojectmobiledev.ui.onboarding

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.margaritalashina.mytrainingprojectmobiledev.R
import com.margaritalashina.mytrainingprojectmobiledev.databinding.FragmentOnboardingBinding
import com.margaritalashina.mytrainingprojectmobiledev.onboardingTextAdapterDelegate
import com.margaritalashina.mytrainingprojectmobiledev.ui.base.BaseFragment
import dev.chrisbanes.insetter.applyInsetter

class OnboardingFragment : BaseFragment(R.layout.fragment_onboarding) {

    private val viewBinding by viewBinding(FragmentOnboardingBinding::bind)
    private var player: ExoPlayer? = null
    private var isVolume: Boolean = false

//    private var timer: Timer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        player = SimpleExoPlayer.Builder(requireContext()).build().apply {
            addMediaItem(MediaItem.fromUri("asset:///onboarding.mp4"))
            repeatMode = Player.REPEAT_MODE_ALL
            prepare()
        }
        isVolume = savedInstanceState?.getBoolean("isVolume") ?: false
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.volumeControlButton.applyInsetter {
            type(statusBars = true) { margin() }
        }
        viewBinding.playerView.player = player
        // произойдет установка адаптера во viewPager
        viewBinding.viewPager.setTextPages()
        viewBinding.viewPager.attachDots(viewBinding.onboaringTextTabLayout)
        // setOnClickListener позволяет установить лямбду, которая будет вызвана, когда пользователь нажимает на кнопку
        viewBinding.signInButton.setOnClickListener {
            findNavController().navigate(R.id.action_onboardingFragment_to_signInFragment)
        }
        viewBinding.signUpButton.setOnClickListener {
            findNavController().navigate(R.id.action_onboardingFragment_to_signUpFragment)
        }

        changeVolume(isVolume)
        viewBinding.volumeControlButton.setOnClickListener {
            changeVolume(!isVolume)
        }

//        startTimer()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putBoolean("isVolume", isVolume)
    }

//    private fun startTimer() {
//        timer = Timer().apply {
//            scheduleAtFixedRate(scrollTask(), 5000, 5000)
//        }
//    }

//    private fun scrollTask() = object : TimerTask() {
//        override fun run() {
//            activity?.runOnUiThread {
//                viewBinding.viewPager.apply {
//                    val numberOfItems = adapter?.itemCount ?: 1
//                    setCurrentItem((currentItem + 1) % numberOfItems, true)
//                }
//            }
//        }
//    }

    private fun changeVolume(setOn: Boolean) {
        if (setOn) {
            player?.volume = 1F
            isVolume = true
            viewBinding.volumeControlButton.setImageResource(R.drawable.ic_volume_up_white_24dp)
        } else {
            player?.volume = 0F
            isVolume = false
            viewBinding.volumeControlButton.setImageResource(R.drawable.ic_volume_off_white_24dp)
        }
    }

    override fun onResume() {
        super.onResume()
        player?.play()
    }

    override fun onPause() {
        super.onPause()
        player?.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        player?.release()
    }

    private fun ViewPager2.setTextPages() {
        adapter =
            ListDelegationAdapter(onboardingTextAdapterDelegate()).apply {
                items =
                    listOf(
                        getString(R.string.onboarding_view_pager_text_1),
                        getString(R.string.onboarding_view_pager_text_2),
                        getString(R.string.onboarding_view_pager_text_3)
                    )
            }
    }

    private fun ViewPager2.attachDots(tabLayout: TabLayout) {
        TabLayoutMediator(tabLayout, this) { _, _ -> }.attach()
    }
}