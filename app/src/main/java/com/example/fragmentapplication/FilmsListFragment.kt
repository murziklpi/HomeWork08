package com.example.fragmentapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.otus.otusfragmentsnew.recyclerTwo.FilmsAdapter
import com.otus.otusfragmentsnew.recyclerTwo.FilmsItem
import java.lang.Exception

class FilmsListFragment : Fragment() {
    var listener: OnNewsClickListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        retainInstance = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_films_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<RecyclerView>(R.id.recyclerView).adapter = FilmsAdapter(
            LayoutInflater.from(context),
            listOf(
                FilmsItem("@drawable/boy", "@strings/boy"),
                FilmsItem("@drawable/girl", "@strings/girl"),
                FilmsItem("@drawable/car", "@strings/car")
            )
        ) { listener?.onNewsClick(it) }

        //(activity as MainActivity).openNewsDetailed()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (activity is OnNewsClickListener) {
            listener = activity as OnNewsClickListener
        } else {
            throw Exception("Activity must implement OnNewsClickListener")
        }

        Log.d(TAG, "onActivityCreated")
    }

    companion object {
        const val TAG = "NewsListFragment"
    }

    interface OnNewsClickListener {
        fun onNewsClick(item: FilmsItem)
    }
}