package in.co.whiznet.nurseryapp;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Quiz extends AppCompatActivity {



    ViewPager vp1;
    public static MediaPlayer mediaPlayer;
   public static boolean isSoundon=true;
    List<QuizModal> datalist1=new ArrayList<>();
    List<String> alphalist=new ArrayList<>();
    HashMap<Integer,TextModal> images=new HashMap<Integer, TextModal>();
    ImageView next;
    ImageView previous;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_quiz);
        vp1 = (ViewPager) findViewById(R.id.view2);
        next = (ImageView) findViewById(R.id.next);
        mediaPlayer=MediaPlayer.create(this,R.raw.f);
        mediaPlayer=MediaPlayer.create(this,R.raw.c);
        previous = (ImageView) findViewById(R.id.previous);
        setImages();
        setAlphaData();
        setQuizData();

        final HorizontalScrollView scrollView = (HorizontalScrollView) findViewById(R.id.scroll_view);
        final ImageView imageView = (ImageView) findViewById(R.id.background);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vp1.setCurrentItem(vp1.getCurrentItem()-1, true);
                  }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vp1.setCurrentItem(vp1.getCurrentItem() + 1, true);

            }
        });


        vp1.setAdapter(new QuizPagerAdapter(getSupportFragmentManager(), datalist1));
        vp1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int x = (int) ((vp1.getWidth() * position + positionOffsetPixels) * computeFactor());
                scrollView.scrollTo(x, 0);

                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }

            private float computeFactor() {
                return (imageView.getWidth() - vp1.getWidth()) /
                        (float) (vp1.getWidth() * (vp1.getAdapter().getCount() - 1));
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (MainActivity.isMusicon) {
            MainActivity.mediaPlayer.pause();
        }
        if (Quiz.mediaPlayer.isPlaying()){
            Quiz.mediaPlayer.stop();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (MainActivity.isMusicon) {
            MainActivity.mediaPlayer.start();
        }
    }
    private void setAlphaData() {
        alphalist.add("a");
        alphalist.add("b");
        alphalist.add("c");
        alphalist.add("d");
        alphalist.add("e");
        alphalist.add("f");
        alphalist.add("g");
        alphalist.add("h");
        alphalist.add("i");
        alphalist.add("j");
        alphalist.add("k");
        alphalist.add("l");
        alphalist.add("m");
        alphalist.add("n");
        alphalist.add("o");
        alphalist.add("p");
        alphalist.add("q");
        alphalist.add("r");
        alphalist.add("s");
        alphalist.add("t");
        alphalist.add("u");
        alphalist.add("v");
        alphalist.add("w");
        alphalist.add("x");
        alphalist.add("y");
        alphalist.add("z");
    }

    private void setQuizData() {

        int position=0;
        QuizModal quizModal;

        for(int i=0;i<26;i++){
            position=i;

            quizModal=new QuizModal();
            quizModal.setAlphabet(alphalist.get(position));
            quizModal.setTrueans(images.get(position));

            if(position<6){
                position=position+7;
            }
            if(position>20){
                position=position-7;
            }
            quizModal.setImage1(images.get(position+1));//Integer.valueOf(position+3)));
            quizModal.setImage2(images.get(position+3));//Integer.valueOf(position-2)));
            quizModal.setImage3(images.get(position-3));//Integer.valueOf(position+1)));
            quizModal.setImage4(images.get(position-2));//Integer.valueOf(position-1)));
            datalist1.add(quizModal);
        }
    }

    private void setImages() {
        images.put(0,new TextModal(R.drawable.apple,"apple"));
        images.put(1,new TextModal(R.drawable.ball,"ball"));
        images.put(2,new TextModal(R.drawable.cat,"cat"));
        images.put(3,new TextModal(R.drawable.doll,"doll"));
        images.put(4,new TextModal(R.drawable.elephant,"elephant"));
        images.put(5,new TextModal(R.drawable.flag,"flag"));
        images.put(6,new TextModal(R.drawable.gun,"gun"));
        images.put(7,new TextModal(R.drawable.house,"house"));
        images.put(8,new TextModal(R.drawable.icecream,"ice cream"));
        images.put(9,new TextModal(R.drawable.jug,"jug"));
        images.put(10,new TextModal(R.drawable.kite,"kite"));
        images.put(11,new TextModal(R.drawable.lion,"lion"));
        images.put(12,new TextModal(R.drawable.mango,"mango"));
        images.put(13,new TextModal(R.drawable.nest,"nest"));
        images.put(14,new TextModal(R.drawable.owl,"owl"));
        images.put(15,new TextModal(R.drawable.pen,"pen"));
        images.put(16,new TextModal(R.drawable.queen,"queen"));
        images.put(17,new TextModal(R.drawable.rose,"rose"));
        images.put(18,new TextModal(R.drawable.sun,"sun"));
        images.put(19,new TextModal(R.drawable.tiger,"tiger"));
        images.put(20,new TextModal(R.drawable.umbrella,"umbrella"));
        images.put(21,new TextModal(R.drawable.van,"van"));
        images.put(22,new TextModal(R.drawable.whale,"whale"));
        images.put(23,new TextModal(R.drawable.xray,"x-ray"));
        images.put(24,new TextModal(R.drawable.yak,"yak"));
        images.put(25,new TextModal(R.drawable.zebra,"zebra"));

    }
    public  void mute(View v) {
        ImageView mute = (ImageView) findViewById(R.id.mute);
        if (isSoundon) {
            isSoundon = false;
            MainActivity.isMusicon=false;
            mute.setImageResource(R.drawable.ic_mussic);
            Quiz.mediaPlayer.stop();
            MainActivity.mediaPlayer.pause();
        } else {
            isSoundon = true;
            MainActivity.isMusicon=true;
            mute.setImageResource(R.drawable.ic_music);
            Quiz.mediaPlayer.stop();
            MainActivity.mediaPlayer.start();
        }
    }
    public void home(View v){
        finish();
        //startActivity(new Intent(Quiz.this,MainActivity.class));
    }
}