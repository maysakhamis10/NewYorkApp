package com.itg.newyorkapp.views

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import com.bumptech.glide.Glide
import com.example.newyorktimes.viewmodels.CommunicatorViewModel

import com.itg.newyorkapp.R

/**
 * A simple [Fragment] subclass.
 */
class DetailsStory : Fragment() {


    lateinit var  storyImage : ImageView
    lateinit var  storyTitle : TextView
    lateinit var  published_date : TextView
    lateinit var  abstract_artical : TextView
    lateinit var  artical_link : TextView




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_details_story, container, false)

        initViews(rootView)
        fetchBookMak()
        return rootView
    }

    private fun initViews(rootView: View) {
        storyImage = rootView.findViewById(R.id.storyImage)
        storyTitle = rootView.findViewById(R.id.storyTitle)
        published_date = rootView.findViewById(R.id.published_date)
        abstract_artical = rootView.findViewById(R.id.abstract_artical)
        artical_link = rootView.findViewById(R.id.artical_link)

    }

    private fun fetchBookMak(){
        ViewModelProviders.of(requireActivity()).get(CommunicatorViewModel::class.java)
            .getMessageContainerB().observe(viewLifecycleOwner) {
                storyTitle.text = it.title
                published_date.text = it.published_date
                abstract_artical.text = it.abstract
                artical_link.text = it.url
                if (it.multimedia!=null) {
                    Glide.with(this)
                        .load(it.multimedia[0].url)
                        .into(storyImage)
                }
            }
    }

}
