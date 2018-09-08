package in.co.whiznet.nurseryapp;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import static android.media.CamcorderProfile.get;

public class QuizPagerAdapter extends FragmentPagerAdapter {
    List<QuizModal>data1;
    int[] answers={2,4,1,3,1,2,3,1,2,3,1,4,1,2,3,2,1,2,3,2,1,2,3,2,3,2,1};
    TextToSpeech tts;
    public QuizPagerAdapter(FragmentManager fm,List<QuizModal> data1) {
        super(fm);
        this.data1=data1;
    }

    @Override
    public Fragment getItem(int position) {
        if(position==26){
            return ScoreFragment.newInstance("","");

        }
        return  QuizFragment.newInstance(data1.get(position),answers[position]);
    }
    @Override
    public int getCount() {
        return 27;
    }
}
