package com.tryserialization.tryimagezoom;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.github.chrisbanes.photoview.PhotoView;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] imageUrls = new String[]{
                "https://www.japanautosale.com/Admin/uploads/cars_images/images_800x600/JAS-3709_4_678_1608777642.png",
                "https://www.japanautosale.com/Admin/uploads/cars_images/images_800x600/JAS-3709_5_727_1608777642.png",
                "https://www.japanautosale.com/Admin/uploads/cars_images/images_800x600/JAS-3709_2_468_1608777642.png",
                "https://www.japanautosale.com/Admin/uploads/cars_images/images_800x600/JAS-3709_3_150_1608777642.png",
                "https://cdn.pixabay.com/photo/2017/10/10/15/28/butterfly-2837589_960_720.jpg"
        };
        ViewPager viewPager = findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(this, imageUrls);
        viewPager.setAdapter(adapter);
    }

    public class ViewPagerAdapter extends PagerAdapter {
        private final Context context;
        private final String[] imageUrls;

        ViewPagerAdapter(Context context, String[] imageUrls) {
            this.context = context;
            this.imageUrls = imageUrls;
        }

        @Override
        public int getCount() {
            return imageUrls.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            PhotoView imageView = new PhotoView(context);
            Picasso.get()
                    .load(imageUrls[position])
                    .into(imageView);
            container.addView(imageView);
            return imageView;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }
}