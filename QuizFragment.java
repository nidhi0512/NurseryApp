package in.co.whiznet.nurseryapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class QuizFragment extends Fragment implements View.OnClickListener{
    private static final String LIST1="quizlist";
    private static final String TRUEANS="trueans";
    ImageView next;
    ImageView previous;
    TextView text1;
    TextView text2;
    TextView text3;
    TextView text4;
    TextView text5;
    TextView text6;
    TextView text7;
    ImageView img1;
    ImageView img2;
    ImageView img3;
    ImageView img4;
    QuizModal quizdata;
    int trueansposition;
    int clickedposition;
    Animation  animation;
    View view;
    public QuizFragment() {
        // Required empty public constructor
    }

    public static QuizFragment newInstance(QuizModal quizModal,int trueansposition) {
        QuizFragment fragment = new QuizFragment();
        Bundle args = new Bundle();
        args.putSerializable(LIST1,(Serializable) quizModal);
        args.putInt(TRUEANS,trueansposition);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
           quizdata =(QuizModal) getArguments().getSerializable(LIST1);
           trueansposition=getArguments().getInt(TRUEANS);
        }
    }
    ImageView imgtrue;

    BottomSheetBehavior bottomSheetBehavior;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_quiz2, container, false);
        imgtrue=(ImageView)view.findViewById(R.id.correctresult);
        text1 = (TextView)view.findViewById(R.id.txt1);
        text2 = (TextView)view.findViewById(R.id.txt2);
        text3=(TextView)view.findViewById(R.id.txt3);
        text4=(TextView)view.findViewById(R.id.txt4);
        text5=(TextView)view.findViewById(R.id.txt5);
        text6=(TextView)view.findViewById(R.id.txt6);
        text7=(TextView)view.findViewById(R.id.txt7);
        img1=(ImageView)view.findViewById(R.id.img1);
        img2=(ImageView)view.findViewById(R.id.img2);
        img3=(ImageView)view.findViewById(R.id.img3);
        img4=(ImageView)view.findViewById(R.id.img4);
        text1.setText(quizdata.getAlphabet());
        text2.setText(quizdata.getAlphabet());
        text4.setText(quizdata.getImage1().getText());
        text5.setText(quizdata.getImage2().getText());
        text6.setText(quizdata.getImage3().getText());
        text7.setText(quizdata.getImage4().getText());
        img1.setImageResource(quizdata.getImage1().getImages());
        img2.setImageResource(quizdata.getImage2().getImages());
        img3.setImageResource(quizdata.getImage3().getImages());
        img4.setImageResource(quizdata.getImage4().getImages());
        if(trueansposition==1){
            img1.setImageResource(quizdata.getTrueans().getImages());
            text4.setText(quizdata.getTrueans().getText());
        }else if(trueansposition==2){
            img2.setImageResource(quizdata.getTrueans().getImages());
            text5.setText(quizdata.getTrueans().getText());
        }else if(trueansposition==3){
            img3.setImageResource(quizdata.getTrueans().getImages());
            text6.setText(quizdata.getTrueans().getText());
        }else if (trueansposition==4){
            img4.setImageResource(quizdata.getTrueans().getImages());
            text7.setText(quizdata.getTrueans().getText());
        }
        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if(Quiz.mediaPlayer.isPlaying()){
            Quiz.mediaPlayer.stop();
             }
     animation = AnimationUtils.loadAnimation(getContext(),R.anim.bounce);
        img1.setBackground(null);
        img2.setBackground(null);
        img3.setBackground(null);
        img4.setBackground(null);
        if(view.getId()==R.id.img1){
            clickedposition=1;
            img1.setAnimation(animation);

        }else if(view.getId()==R.id.img2){
            clickedposition=2;
            img2.setAnimation(animation);
        }else if(view.getId()==R.id.img3){
            clickedposition=3;
            img3.setAnimation(animation);
        }else if(view.getId()==R.id.img4){
            clickedposition=4;
            img4.setAnimation(animation);

        }

        imgtrue.setVisibility(View.GONE);
        if(clickedposition==trueansposition){
            imgtrue.setVisibility(View.VISIBLE);
            this.view.findViewById(view.getId()).setBackground(getResources().getDrawable(R.drawable.rectangle,null));
           Quiz.mediaPlayer=MediaPlayer.create(getContext(),R.raw.c);
              if (Quiz.isSoundon)
               Quiz.mediaPlayer.start();

        }else {

           Quiz.mediaPlayer=MediaPlayer.create(getContext(),R.raw.f);
            this.view.findViewById(view.getId()).setBackground(getResources().getDrawable(R.drawable.rectanglered,null));
            if (Quiz.isSoundon)
            Quiz.mediaPlayer.start();

        }
    }
}