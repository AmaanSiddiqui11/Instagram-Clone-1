package com.example.insta.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.insta.data.ReelData
import com.example.insta.databinding.ReelItemBinding
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer

class ReelAdapter(private val reelList: List<ReelData>) :
    RecyclerView.Adapter<ReelAdapter.ReelViewHolder>() {
    private val exoPlayer: HashMap<Int, SimpleExoPlayer> = HashMap()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReelViewHolder {
        val binding = ReelItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ReelViewHolder(binding)
    }

    override fun getItemCount(): Int = reelList.size

    override fun onBindViewHolder(holder: ReelViewHolder, position: Int) {
        holder.bind(reelList[position])

        val currentPosition = holder.adapterPosition
        if (currentPosition != RecyclerView.NO_POSITION) {
            // Pause the previous player if it exists
            exoPlayer[currentPosition]?.pause()
            // Initialize the new player for this position
            val newPlayer = holder.getSimpleExoPlayer()
            if (newPlayer != null) {
                exoPlayer[currentPosition] = newPlayer
            }
        }
    }

    fun releaseAllPlayer() {
        exoPlayer.forEach {
            it.value.release()
        }
        exoPlayer.clear()
    }

    fun onPageChanged(position: Int) {
        if (position != RecyclerView.NO_POSITION) {
            exoPlayer[position]?.play()
        }
    }

    override fun onViewDetachedFromWindow(holder: ReelViewHolder) {
        super.onViewDetachedFromWindow(holder)
        holder.pausePlayer()  // Pause the player when the view is detached
    }

    override fun onViewRecycled(holder: ReelViewHolder) {
        super.onViewRecycled(holder)
        holder.releasePlayer()  // Release the player when the view is recycled
        val position = holder.adapterPosition
        if (position != RecyclerView.NO_POSITION) {
            exoPlayer.remove(position)   // Remove the player from the map
        }
    }

    inner class ReelViewHolder(private val binding: ReelItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var exoPlayer: SimpleExoPlayer? = null

        fun getSimpleExoPlayer(): SimpleExoPlayer? = exoPlayer

        fun bind(reelData: ReelData) {
            // Initialize ExoPlayer if not already initialized
            if (exoPlayer == null) {
                exoPlayer = SimpleExoPlayer.Builder(binding.root.context).build().apply {
                    val mediaItem = MediaItem.fromUri(reelData.videoUrl)
                    setMediaItem(mediaItem)

                    // Set the playerView
                    binding.playerView.player = this

                    // Add listener to handle playback state changes
                    addListener(object : Player.Listener {
                        override fun onPlaybackStateChanged(playbackState: Int) {
                            super.onPlaybackStateChanged(playbackState)
                            // Show or hide the progress bar based on buffering state
                            binding.progressBar.visibility = if (playbackState == Player.STATE_BUFFERING) {
                                View.VISIBLE
                            } else {
                                View.GONE
                            }
                        }
                    })

                    // Prepare the player
                    prepare()

                    // Start playback automatically
                    playWhenReady = true
                    repeatMode = SimpleExoPlayer.REPEAT_MODE_ONE
                }
            }
        }

        fun startPlayer() {
            exoPlayer?.play()
        }

        fun pausePlayer() {
            exoPlayer?.pause()
        }

        // Release player resources
        fun releasePlayer() {
            exoPlayer?.release()
            exoPlayer = null
        }
    }
}



