package firstlook.google.andriod_slide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class Slider_Adapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;

    public Slider_Adapter(Context context) {
        this.context = context;
    }

    public int [] slide_images ={
         R.drawable.thirdcar,
            R.drawable.eighthcar,
            R.drawable.secondcar
       };

    public String [] slide_desc = {
            "My First car I\\'m gonna buy of course it has a porche appearance obviously the best among the rest. enjoy your ride\n" +
                    "    in a comfortable and relaxed way, in  one of the best rides in the world",
            "My Second car I\\'m gonna buy of course it has a porche appearance obviously the best among the rest. enjoy your ride\n" +
                    "    in a comfortable and relaxed way, in  one of the best rides in the world",
            "My Third car I\\'m gonna buy of course it has a porche appearance obviously the best among the rest. enjoy your ride\n" +
                    "    in a comfortable and relaxed way, in  one of the best rides in the world"
    };

    public String [] slide_headings = {
         "First",
         "Second",
         "Third"
    };


    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        if (view == object) {
            return true;
        } else return false;
    }
}
