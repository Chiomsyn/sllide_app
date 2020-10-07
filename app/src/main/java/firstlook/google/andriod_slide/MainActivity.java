package firstlook.google.andriod_slide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private ViewPager mslideViewPager;
private LinearLayout mDotLayout;
private Slider_Adapter sliderAdapter;
private TextView[] mdots;
private Button mNxtBtn;
private Button mPrevBtn;
private int mcurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mslideViewPager = findViewById(R.id.slideViewPager);
        mDotLayout = findViewById(R.id.dotsLayout);
        mNxtBtn = findViewById(R.id.nxt_btn);
        mPrevBtn = findViewById(R.id.prev_btn);

        sliderAdapter = new Slider_Adapter(this);
        mslideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);
        mslideViewPager.addOnPageChangeListener(viewListener);

       mNxtBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               mslideViewPager.setCurrentItem(mcurrentPage + 1);
           }
       });

       mPrevBtn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               mslideViewPager.setCurrentItem(mcurrentPage - 1);
           }
       });
    }

    public void addDotsIndicator(int position){
        mdots = new TextView[3];
        //To prevent the creation of multiple dots
        mDotLayout.removeAllViews();

        for(int i = 0; i < mdots.length; i++){

            mdots[i] = new TextView(this);
            mdots[i].setText(Html.fromHtml("&#8226;"));
            mdots[i].setTextSize(35);
            mdots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            mDotLayout.addView(mdots[i]);
        }

        if(mdots.length > 0){
            mdots[position].setTextColor(getResources().getColor(R.color.colorWhite));
        }
    }

    ViewPager.OnPageChangeListener viewListener =new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

                addDotsIndicator(position);

                mcurrentPage = position;

                if(position == 0){
                    mNxtBtn.setEnabled(true);
                    mPrevBtn.setEnabled(false);
                    mPrevBtn.setVisibility(View.INVISIBLE);

                    mNxtBtn.setText("Next");
                    mPrevBtn.setText("");
                }else if(position == mdots.length - 1){
                    mNxtBtn.setEnabled(true);
                    mPrevBtn.setEnabled(true);
                    mPrevBtn.setVisibility(View.VISIBLE);

                    mNxtBtn.setText("Finish");
                    mPrevBtn.setText("Back");
                }else{
                    mNxtBtn.setEnabled(true);
                    mPrevBtn.setEnabled(true);
                    mPrevBtn.setVisibility(View.VISIBLE);

                    mNxtBtn.setText("Next");
                    mPrevBtn.setText("Back");
                }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
