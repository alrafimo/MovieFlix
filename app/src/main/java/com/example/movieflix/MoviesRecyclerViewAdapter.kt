package com.example.movieflix

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieflix.R.id




class MoviesRecyclerViewAdapter (
    private val mov: List<Movies>,
    private val mListener: OnListFragmentInteractionListener?
)
    : RecyclerView.Adapter<MoviesRecyclerViewAdapter.MovieViewHolder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movies_fragment, parent, false)
        return MovieViewHolder(view)
    }
    /**
     * This inner class lets us refer to all the different View elements
     * (Yes, the same ones as in the XML layout files!)
     */

    inner class MovieViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        var mItem: Movies? = null
        val movieTitle: TextView = mView.findViewById<View>(id.title) as TextView
        val movieImage: ImageView = mView.findViewById<ImageView>(id.poster) as ImageView
        val movieDescription: TextView = mView.findViewById<View>(id.overview) as TextView



        override fun toString(): String {
            return movieTitle.toString() + " '" + movieDescription.text + "'"
        }
    }


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val mov = mov[position]

        holder.mItem = mov
        holder.movieTitle.text = mov.title
        holder.movieDescription.text = mov.description

        Glide.with(holder.mView)
            .load("https://image.tmdb.org/t/p/w500/"+mov.movieImageUrl)
            .centerInside()
            .into(holder.movieImage)



    }

    override fun getItemCount(): Int {
        return mov.size
    }
}