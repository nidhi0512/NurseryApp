package in.co.whiznet.nurseryapp;
import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;


public class DetailFragment extends Fragment implements View.OnClickListener{
    private static final String LIST = "alphalist";
    Context context;
    TextView txt;
    TextView txt1;
    TextView txt2;
    ImageView img;
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    Alphamodal alphadata;
    Animation anim;
    TextToSpeech tts;

    public DetailFragment() {
        }

    public static DetailFragment newInstance(Alphamodal datalist) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(LIST,(Serializable) datalist);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            alphadata =(Alphamodal) getArguments().getSerializable(LIST);
        }
       }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        img = (ImageView) view.findViewById(R.id.alphaimage);
        img1=(ImageView)view.findViewById(R.id.opt1);
        img2=(ImageView)view.findViewById(R.id.opt2);
        img3=(ImageView)view.findViewById(R.id.opt3);
        img4=(ImageView)view.findViewById(R.id.opt4);
        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);

        tts=new TextToSpeech(getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

            }
        });
        txt = (TextView) view.findViewById(R.id.alphatextcapital);
        txt.setText(alphadata.getCapitalcaps());
        txt1=(TextView)view.findViewById(R.id.alphatextsmall);
        txt1.setText(alphadata.getSmallcaps());
        txt2=(TextView)view.findViewById(R.id.alphafor);
        txt2.setText(alphadata.getAlphafor());
        Picasso.with(getContext()).load(alphadata.getImage1()).into(img);
        Picasso.with(getContext()).load(alphadata.getImage2()).into(img1);
        Picasso.with(getContext()).load(alphadata.getImage3()).into(img2);
        Picasso.with(getContext()).load(alphadata.getImage4()).into(img3);
        Picasso.with(getContext()).load(alphadata.getImage5()).into(img4);
        anim= AnimationUtils.loadAnimation(getContext(),R.anim.bounce);
        img.setAnimation(anim);
        return view;
    }
    @Override
    public void onClick(View v) {

             if (v.getId()==R.id.opt1)
          {
              int prev=alphadata.getImage1();
              String txt = alphadata.getAlphafor();
              alphadata.setImage1(alphadata.getImage2());
              alphadata.setAlphafor(alphadata.getAlphafor2());
              alphadata.setImage2(prev);
              alphadata.setAlphafor2(txt);
              img.setImageResource(alphadata.getImage1());
              img.setAnimation(anim);
              img1.setImageResource(alphadata.getImage2());
              txt2.setText(alphadata.getAlphafor());
              String txt1=alphadata.getCapitalcaps()+"   For   "+alphadata.getAlphafor();
              tts.speak(txt1,TextToSpeech.QUEUE_FLUSH,null);
          }
        else if (v.getId()==R.id.opt2)
          {
              int prev=alphadata.getImage1();
              String txt=alphadata.getAlphafor();
              alphadata.setImage1(alphadata.getImage3());
              alphadata.setAlphafor(alphadata.getAlphafor3());
              alphadata.setImage3(prev);
              alphadata.setAlphafor3(txt);
              img.setImageResource(alphadata.getImage1());
              img.setAnimation(anim);
              img2.setImageResource(alphadata.getImage3());
              txt2.setText(alphadata.getAlphafor());
              String txt2=alphadata.getCapitalcaps()+"    for    "+alphadata.getAlphafor();
              tts.speak(txt2,TextToSpeech.QUEUE_FLUSH,null);
          }

          else if (v.getId()==R.id.opt3)
          {
              int prev=alphadata.getImage1();
              String txt=alphadata.getAlphafor();
              alphadata.setImage1(alphadata.getImage4());
              alphadata.setAlphafor(alphadata.getAlphafor4());
              alphadata.setImage4(prev);
              alphadata.setAlphafor4(txt);
              img.setImageResource(alphadata.getImage1());
              img.setAnimation(anim);
              img3.setImageResource(alphadata.getImage4());
              txt2.setText(alphadata.getAlphafor());
              String txt3=alphadata.getCapitalcaps()+"    for     "+alphadata.getAlphafor();
              tts.speak(txt3,TextToSpeech.QUEUE_FLUSH,null);
          }
          else if (v.getId()==R.id.opt4)
          {
                 int prev=alphadata.getImage1();
                 String txt=alphadata.getAlphafor();
                 alphadata.setImage1(alphadata.getImage5());
                 alphadata.setAlphafor(alphadata.getAlphafor5());
                 alphadata.setImage5(prev);
                 alphadata.setAlphafor5(txt);
                 img.setImageResource(alphadata.getImage1());
                 img.setAnimation(anim);
                 img4.setImageResource(alphadata.getImage5());
                 txt2.setText(alphadata.getAlphafor());
                 String txt4=alphadata.getCapitalcaps()+"   for    "+alphadata.getAlphafor();
                 tts.speak(txt4,TextToSpeech.QUEUE_FLUSH,null);
          }
    }
}
