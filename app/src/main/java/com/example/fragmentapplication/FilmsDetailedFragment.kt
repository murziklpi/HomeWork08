package com.example.fragmentapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FilmsDetailedFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_films_detailed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (view as TextView).text = arguments?.getString(EXTRA_TITLE, "")
    }

    companion object {
        const val TAG = "NewsDetailedFragment"

        const val EXTRA_TITLE = "EXTRA_TITLE"

        fun newInstance(newsTitle: String) : FilmsDetailedFragment {
            val fragment = FilmsDetailedFragment()

            val bundle = Bundle()
            bundle.putString(EXTRA_TITLE, newsTitle)

            fragment.arguments = bundle

            return fragment
        }
    }
}