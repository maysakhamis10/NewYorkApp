package com.itg.newyorkapp.views

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newyorktimes.data.apis.ApiHelper
import com.example.newyorktimes.data.apis.ResponseStatus
import com.example.newyorktimes.data.apis.RetrofitBuilder
import com.example.newyorktimes.data.datamodels.ResultStories
import com.example.newyorktimes.utilis.TopStoriesAdapter
import com.example.newyorktimes.viewmodels.CommunicatorViewModel
import com.example.newyorktimes.viewmodels.MainViewModel
import com.example.newyorktimes.viewmodels.ViewModelFactory
import com.github.ybq.android.spinkit.SpinKitView
import com.itg.newyorkapp.R

class NewFeedsFragment : Fragment() {

    private lateinit var viewModel: MainViewModel
    private lateinit var storiesRecyclerView: RecyclerView
    private lateinit var storiesAdapter: TopStoriesAdapter
    private lateinit var progressBar: SpinKitView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initViewModel()
        viewModelCallBack()
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_new_feeds, container, false)
        initViews(view)
        initViewModel()
        viewModelCallBack()
        return view
    }

    private fun initViews(view: View) {

        storiesRecyclerView = view.findViewById(R.id.topStoriesList)
        progressBar = view.findViewById(R.id.progressBar)
        storiesRecyclerView.layoutManager = LinearLayoutManager(context)

    }


    private fun initViewModel() {
        viewModel = ViewModelProviders.of(
            this,
            ViewModelFactory(ApiHelper(RetrofitBuilder().apiService))
        ).get(MainViewModel::class.java)
    }

    private fun viewModelCallBack() {

        viewModel.fetchTopStoriesLiveData().observe(viewLifecycleOwner) {
            it.let { resource ->
                when (resource.status) {


                    ResponseStatus.SUCCESS -> {
                        resource.data?.let { topStories ->
                            storiesRecyclerView.visibility = View.VISIBLE
                            progressBar.visibility = View.GONE
                            populateStoriesList(topStories.results)
                        }
                    }
                    ResponseStatus.ERROR -> {
                        storiesRecyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                    }
                    ResponseStatus.LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        storiesRecyclerView.visibility = View.GONE
                    }
                }
            }
        }


    }

    private fun populateStoriesList(stories: ArrayList<ResultStories>) {
        storiesAdapter = TopStoriesAdapter(stories) { selectedStoryObject, isFavBtnClickFlag ->
            onItemClickMethod(isFavBtnClickFlag, selectedStoryObject)
        }
        storiesRecyclerView.adapter = storiesAdapter
    }

    //implement on item click listener of recycelview
    private fun onItemClickMethod(isFavBtnClick: Boolean, selectedOne: ResultStories) {
        //add to bookmark list
        if (isFavBtnClick){
            Log.d("BOOK before it", "${selectedOne.title}!")
            ViewModelProviders.of(requireActivity()).get(CommunicatorViewModel::class.java)
                .sendMessageToA(selectedOne)
        }
        //open details screen
        else{
            ViewModelProviders.of(requireActivity()).get(CommunicatorViewModel::class.java)
                .sendMessageToB(selectedOne)
            val fragmentB = DetailsStory()
            activity?.getSupportFragmentManager()?.beginTransaction()
                ?.replace(R.id.content, fragmentB, "DetailsStory")
                ?.commit()
        }
    }


}