package in.co.whiznet.nurseryapp;


import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

public class DetailPagerAdapter extends FragmentPagerAdapter implements TextToSpeech.OnInitListener {
    List<Alphamodal> data;

    public DetailPagerAdapter(FragmentManager fm, List<Alphamodal> data) {
        super(fm);
        this.data=data;
    }

    @Override
    public Fragment getItem(int position) {
        Log.d("position",position+"");
        if (position==26){

            return ScoreFragment.newInstance("","");
        }
        return DetailFragment.newInstance(data.get(position));
    }

    @Override
    public int getCount() {
        return 27;
    }

    @Override
    public void onInit(int i) {

    }
}
