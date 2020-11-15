package com.example.newyorktimes.utilis

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newyorktimes.data.datamodels.ResultStories
import com.itg.newyorkapp.R

class TopStoriesAdapter (private val stories: ArrayList<ResultStories>,
                         private val  OnStoryClick : (ResultStories,Boolean)-> Unit)
    : RecyclerView.Adapter<TopStoriesAdapter.StoriesHolder>() ,  View.OnClickListener {


    override fun getItemCount(): Int {
        return stories.size
    }

    override fun onBindViewHolder(holder: TopStoriesAdapter.StoriesHolder, position: Int) {
        val itemStories = stories[position]
        holder.bind(itemStories)
        holder.favImage.setOnClickListener{
            Log.d("FROM BIND FAV", "${stories[position].title}!")
            OnStoryClick(stories[position],true)
            holder.favImage.setImageResource(R.drawable.ic_heart)
        }

        holder.itemView.setOnClickListener{
            Log.d("FROM BIND item ", "${stories[position].title}!")
            OnStoryClick(stories[position],false)
           // isFavBtn( false)
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopStoriesAdapter.StoriesHolder{
        val inflatedView =  LayoutInflater.from(parent.context).inflate(R.layout.top_story_item, parent, false)
        return StoriesHolder(inflatedView)
    }
    class StoriesHolder(v:View) : RecyclerView.ViewHolder(v)  {

        private var view : View = v
        private val storyTitle: TextView = itemView.findViewById(R.id.storyTitle)
        private val publishedDate: TextView = itemView.findViewById(R.id.published_date)
        private val storyImage: ImageView = itemView.findViewById(R.id.storyImage)
        val favImage: ImageView = itemView.findViewById(R.id.bookMark)

        fun bind(story: ResultStories) {
            itemView.apply {
                storyTitle.text = story.title
                publishedDate.text = story.published_date

                if (story.multimedia!=null) {
                        Glide.with(context)
                            .load(story.multimedia[0].url)
                            .into(storyImage)
                }
            }
        }
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }


}

interface OnItemClickListener {
    fun onItemClick(model: ResultStories?)
}