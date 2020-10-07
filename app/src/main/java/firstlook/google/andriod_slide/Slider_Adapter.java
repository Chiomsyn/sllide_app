package firstlook.google.andriod_slide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

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

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.slide_layout, container,false);

        ImageView slideImageView = view.findViewById(R.id.slide_image);
        TextView slideHeading = view.findViewById(R.id.slide_Heading);
        TextView slideDescription = view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_desc[position]);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RelativeLayout)object);
    }
}
