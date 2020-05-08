package com.example.soundpoolex1

import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var soundpool: SoundPool? = null
    var song1: Int? = null
    var song2: Int? = null
    var song3: Int? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            soundpool = SoundPool.Builder()
                .setMaxStreams(3)
                .setAudioAttributes(
                    AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_UNKNOWN)
                        .setContentType(AudioAttributes.CONTENT_TYPE_UNKNOWN).build()
                )
                .build()
        } else {
            soundpool = SoundPool(3, AudioManager.STREAM_MUSIC, 0)
        }

        song1 = soundpool!!.load(this, R.raw.a, 0)
        song2 = soundpool!!.load(this, R.raw.b, 0)
        song3 = soundpool!!.load(this, R.raw.c, 0)

    }


    fun play(v: View) {
        when (v.id) {
            R.id.song1 -> soundpool!!.play(song1!!, 2F, 2F, 1, -1, 1F)
            R.id.song2 -> soundpool!!.play(song2!!, 2F, 2F, 2, -1, 1F)
            R.id.song3 -> soundpool!!.play(song3!!, 2F, 2F, 3, -1, 1F)
            R.id.stopall -> soundpool!!.autoPause()//.pause(streamId)
        }
    }
}
