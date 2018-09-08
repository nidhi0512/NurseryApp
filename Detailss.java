package in.co.whiznet.nurseryapp;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Detailss extends AppCompatActivity implements TextToSpeech.OnInitListener {
    ViewPager vp;
    TextToSpeech tts;
    List<Alphamodal> datalist=new ArrayList<>();
    ImageView next;
    ImageView previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_detailss);
        vp = (ViewPager) findViewById(R.id.view1);
        next = (ImageView) findViewById(R.id.next);
        previous = (ImageView) findViewById(R.id.previous);
        createDataList();
        tts = new TextToSpeech(this, this);
        vp.setAdapter(new DetailPagerAdapter(getSupportFragmentManager(), datalist));
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position <26) {
                    String txt = datalist.get(position).getCapitalcaps() + " for " + datalist.get(position).getAlphafor();
                    tts.speak(txt, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
    public void jump(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.previous:
                vp.setCurrentItem(vp.getCurrentItem() - 1, true);
                break;
            case R.id.next:
                vp.setCurrentItem(vp.getCurrentItem() + 1, true);
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

    }
    @Override
    protected void onResume() {
        super.onResume();
        if (MainActivity.isMusicon) {
            MainActivity.mediaPlayer.start();
        }
    }
    private void createDataList(){
        datalist.clear();
        datalist.add(new Alphamodal("A","a","Apple",R.drawable.apple,"Aeroplane",R.drawable.aero,"Ape",R.drawable.ape,"Axe",R.drawable.axe,"ant",R.drawable.ant));
        datalist.add(new Alphamodal("B","b","ball",R.drawable.ball,"balloon",R.drawable.balloon ,"bear",R.drawable.bear ,"bird",R.drawable.bird ,"book",R.drawable.books ));
        datalist.add(new Alphamodal("C","c","cat",R.drawable.cat ,"carrot",R.drawable.carrot ,"car",R.drawable.car ,"camel",R.drawable.camel ,"cake",R.drawable.cake ));
        datalist.add(new Alphamodal("D","d","dog",R.drawable.dog ,"doll",R.drawable.doll ,"deer",R.drawable.deer ,"drum",R.drawable.drum ,"duck",R.drawable.duck ));
        datalist.add(new Alphamodal("E","e","elephant",R.drawable.elephant ,"eyes",R.drawable.eyes ,"egg",R.drawable.egg ,"earth",R.drawable.earth ,"eagle",R.drawable.eagle ));
        datalist.add(new Alphamodal("F","f","flag",R.drawable.flag ,"fish",R.drawable.fish ,"frog",R.drawable.frog ,"flower",R.drawable.flower ,"fruit",R.drawable.fruit ));
        datalist.add(new Alphamodal("G","g","gun",R.drawable.gun ,"giraffe",R.drawable.girraffe ,"grass",R.drawable.grass ,"grapes",R.drawable.grapes ,"girl",R.drawable.girl ));
        datalist.add(new Alphamodal("H","h","house",R.drawable.house ,"hair",R.drawable.hair,"helicopter",R.drawable.helicopter ,"hen",R.drawable.hen ,"horse",R.drawable.horse ));
        datalist.add(new Alphamodal("I","i","ice cream",R.drawable.icecream ,"iron",R.drawable.iron ,"insect",R.drawable.insect ,"inkpot",R.drawable.inkpot ,"igloo",R.drawable.igloo ));
        datalist.add(new Alphamodal("J","j","jug",R.drawable.jug ,"jacket",R.drawable.jacket ,"jewellery",R.drawable.jewellery ,"jeep",R.drawable.jeep ,"jam",R.drawable.jam ));
        datalist.add(new Alphamodal("K","k","kite",R.drawable.kite ,"koala",R.drawable.koala ,"kitten",R.drawable.kitten ,"kangaroo",R.drawable.kangaroo ,"king",R.drawable.king ));
        datalist.add(new Alphamodal("L","l","lion",R.drawable.lion ,"leaf",R.drawable.leaf ,"lotus",R.drawable.lotus ,"lamp",R.drawable.lamp ,"lemon",R.drawable.lemon ));
        datalist.add(new Alphamodal("M","m","mango",R.drawable.mango ,"monkey",R.drawable.monkey ,"moon",R.drawable.moon ,"mouse",R.drawable.mouse ,"man",R.drawable.man ));
        datalist.add(new Alphamodal("N","n","nest",R.drawable.nest ,"nose",R.drawable.nose ,"news paper",R.drawable.newspaper ,"nurse",R.drawable.nurse ,"nail",R.drawable.nail ));
        datalist.add(new Alphamodal("O","o","owl",R.drawable.owl ,"oval",R.drawable.oval ,"orange",R.drawable.orange ,"onion",R.drawable.onion ,"octopus",R.drawable.octopus ));
        datalist.add(new Alphamodal("P","p","pen",R.drawable.pen ,"phone",R.drawable.phone ,"penguin",R.drawable.penguin ,"pig",R.drawable.pig ,"plant",R.drawable.plant));
        datalist.add(new Alphamodal("Q","q","queen",R.drawable.queen ,"quetzal",R.drawable.quetzal ,"quilt",R.drawable.quilt ,"question",R.drawable.question ,"quail",R.drawable.quail ));
        datalist.add(new Alphamodal("R","r","rose",R.drawable.rose ,"rat",R.drawable.rat ,"raccoon",R.drawable.raccoon ,"rainbow",R.drawable.rainbow ,"rabbit",R.drawable.rabbit ));
        datalist.add(new Alphamodal("S","s","sun",R.drawable.sun ,"shoe",R.drawable.shoe ,"sky",R.drawable.sky ,"star",R.drawable.star ,"snake",R.drawable.snake ));
        datalist.add(new Alphamodal("T","t","tiger",R.drawable.tiger ,"tongue",R.drawable.tongue ,"tent",R.drawable.tent ,"table",R.drawable.table ,"tree",R.drawable.tree ));
        datalist.add(new Alphamodal("U","u","umbrella",R.drawable.umbrella ,"unicorn",R.drawable.unicorn ,"uniform",R.drawable.uniform,"universe",R.drawable.universe ,"utensil",R.drawable.utensil ));
        datalist.add(new Alphamodal("V","v","van",R.drawable.van ,"vulture",R.drawable.vulture ,"volcano",R.drawable.volcano,"violin",R.drawable.violin,"vegetable",R.drawable.vegetable ));
        datalist.add(new Alphamodal("W","w","whale",R.drawable.whale ,"water",R.drawable.water ,"watermelon",R.drawable.watermelon ,"wolf",R.drawable.wolf,"world",R.drawable.world));
        datalist.add(new Alphamodal("X","x","xray",R.drawable.xray ,"xylophone",R.drawable.xylophone ,"xmas tree",R.drawable.xmas ,"xylem",R.drawable.xylem ,"xenon",R.drawable.xenon ));
        datalist.add(new Alphamodal("Y","y","yak",R.drawable.yak ,"yacht",R.drawable.yacht ,"yarn",R.drawable.yarn ,"yoyo",R.drawable.yoyo ,"yawn",R.drawable.yawn ));
        datalist.add(new Alphamodal("Z","z","zebra",R.drawable.zebra ,"zigzag",R.drawable.zigzag ,"zip",R.drawable.zip ,"zoo",R.drawable.zoo ,"zero",R.drawable.zero));

    }
    @Override
    public void onInit(int i) {
        tts.speak("A for Apple",TextToSpeech.QUEUE_FLUSH,null);
    }

    public void home(View v){
        finish();
       // startActivity(new Intent(Detailss.this,MainActivity.class));
    }

}

