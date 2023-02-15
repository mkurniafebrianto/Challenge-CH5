package com.example.gamesuit.landingpage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.viewpager.widget.ViewPager
import com.example.gamesuit.databinding.ActivityLandingPageBinding
import com.example.gamesuit.landingpage.fragment.FirstLandingPageFragment
import com.example.gamesuit.landingpage.fragment.SecondLandingPageFragment
import com.example.gamesuit.landingpage.fragment.ThirdLandingPageFragment

class LandingPageActivity : AppCompatActivity() {

    private val binding: ActivityLandingPageBinding by lazy {
        ActivityLandingPageBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val firstLandingPageFragment = FirstLandingPageFragment()
        val secondLandingPageFragment = SecondLandingPageFragment()
        val thirdLandingPageFragment = ThirdLandingPageFragment()

        val landingAdapter = LandingPagerAdapter(
            fragmentManager = supportFragmentManager,
            firstLandingPageFragment,
            secondLandingPageFragment,
            thirdLandingPageFragment
        )

        binding.vpLandingPage.adapter = landingAdapter
        binding.dotIndicator.attachTo(binding.vpLandingPage)

    }
}