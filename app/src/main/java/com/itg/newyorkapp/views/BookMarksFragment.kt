package com.itg.newyorkapp.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import com.example.newyorktimes.data.datamodels.ResultStories
import com.example.newyorktimes.utilis.BookMarksAdapter
import com.example.newyorktimes.viewmodels.CommunicatorViewModel
import com.itg.newyorkapp.R
import java.lang.reflect.Array


class BookMarksFragment : Fragment() {

    private lateinit var bookMarksList: GridView
    lateinit var bookMarksAdapter: BookMarksAdapter

    companion object {
        lateinit var stories: ArrayList<ResultStories>
    }

    init {
        stories = arrayListOf()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_book_marks, container, false)
        initViews(rootView)
        fetchBookMak()
        return rootView
    }


    private fun initViews(rootView: View) {
        bookMarksList = rootView.findViewById(R.id.bookMarkList)
        bookMarksAdapter = BookMarksAdapter(requireContext(), stories)
        bookMarksList.adapter = bookMarksAdapter
    }


    private fun fetchBookMak(){
        ViewModelProviders.of(requireActivity()).get(CommunicatorViewModel::class.java)
            .getMessageContainerA().observe(viewLifecycleOwner
            ) {
                Log.d("BOOK MARKKK from this", "${it.title}!")
                   // stories.toMutableList().add(it)
                    stories.add(it)
                    bookMarksAdapter.notifyDataSetChanged()
                    Log.d("LIST NOIW IS ", "${stories.size}!")
            }

    }
}
