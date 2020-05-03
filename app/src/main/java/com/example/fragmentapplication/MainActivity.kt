package com.example.fragmentapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.otus.otusfragmentsnew.recyclerTwo.FilmsItem

class MainActivity : AppCompatActivity(), FilmsListFragment.OnNewsClickListener {
    override fun onNewsClick(item: FilmsItem) {
        openNewsDetailed(item)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, FilmsListFragment(), FilmsListFragment.TAG)
            .commit()

        /*findViewById<View>(R.id.showDetailsBtn).setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, NewsDetailedFragment(), NewsDetailedFragment.TAG)
                .addToBackStack(null)
                .commit()
        }*/
    }

    fun openNewsDetailed(item: FilmsItem) {
        Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentContainer, FilmsDetailedFragment.newInstance(item.title), FilmsDetailedFragment.TAG)
            .addToBackStack(null)
            .commit()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            finish()
        }
    }
}

