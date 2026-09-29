package com.example.launchedeffectstarter

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SongsViewModel : ViewModel() {
    var artist: String = ""
        set(value) {
            field = value
            liveArtist.value = value
        }

    val liveArtist = MutableLiveData<String>(artist)
}