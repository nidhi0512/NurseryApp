package in.co.whiznet.nurseryapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   public static MediaPlayer mediaPlayer;
    ImageView image;
    ImageView vol;
   public static boolean isMusicon=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.t);
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
        }

    }
    protected void onPause() {
        MainActivity.mediaPlayer.start();
        super.onPause();

    }
    @Override
    protected void onResume() {
        super.onResume();
        //if (MainActivity.mediaPlayer.isPlaying()) {
          //  MainActivity.mediaPlayer.pause();
       // }
    }

    public void next(View v) {
        if (v.getId() == R.id.image) {
            startActivity(new Intent(MainActivity.this, Detailss.class));
        } else if (v.getId() == R.id.image2) {
            startActivity(new Intent(MainActivity.this, Quiz.class));
        } else
            startActivity(new Intent(MainActivity.this, About.class));
    }
    public void volume(View v) {
        vol= (ImageView)findViewById(v.getId());
        if (isMusicon) {
            isMusicon=false;
            vol.setImageResource(R.drawable.ic_volume_off_black_24dp);
            MainActivity.mediaPlayer.pause();
        }
        else
        {
            isMusicon=true;
            vol.setImageResource(R.drawable.ic_volume_up_black_24dp);
            MainActivity.mediaPlayer.start();
    }
    }
}