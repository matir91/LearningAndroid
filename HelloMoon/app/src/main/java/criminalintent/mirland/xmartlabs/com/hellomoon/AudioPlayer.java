package criminalintent.mirland.xmartlabs.com.hellomoon;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;

import java.io.IOException;

/**
 * Created by mirland on 23/07/15.
 */
public class AudioPlayer {
    public MediaPlayer mMediaPlayer;

    public void stop() {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
            mMediaPlayer = null;
        }
    }

    public void play(final Context context) {
        stop();

        mMediaPlayer = MediaPlayer.create(context, R.raw.one_small_step);

//        mMediaPlayer  = new MediaPlayer();
//        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
//        mMediaPlayer.setDataSource(context, R.raw.one_small_step);
//


        mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stop();
            }
        });
        mMediaPlayer.start();
    }

    public void pause() {
        if (mMediaPlayer != null)
            mMediaPlayer.pause();
    }

    public void resume(Context context) {
        if (mMediaPlayer == null) {
            play(context);
        } else {
            mMediaPlayer.start();
        }
    }


}