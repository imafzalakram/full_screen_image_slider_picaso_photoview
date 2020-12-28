# full_screen_image_slider_picaso_photoview

In this project, i have merged [Picaso](https://github.com/square/picasso) &  [PhotoView](https://github.com/chrisbanes/PhotoView) libraries to make a simple app to show remote images with sliding, double-tap & Pinch to Zoom effects using ViewPager & PhotoView respectively. 




### 1.  Add dependencies into build.gradle (app module) 

```
implementation 'androidx.annotation:annotation:1.1.0'
implementation 'com.squareup.picasso:picasso:2.71828'
implementation 'com.github.chrisbanes:PhotoView:2.0.0'

```
you can find latest versions of picaso on [this](https://github.com/square/picasso) &  [this](https://github.com/chrisbanes/PhotoView)


### 2.  Add this code into your xml file
```
   <androidx.viewpager.widget.ViewPager
        android:id="@+id/viewpager"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```


### 3.  Create a PagerAdapter to bind remote images 

```

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
    
```

### 4.  Add this code into your MainActivity

```
String[] imageUrls = new String[]{
      "https://cdn.pixabay.com/photo/2016/11/11/23/34/cat-1817970_960_720.jpg",
      "https://cdn.pixabay.com/photo/2017/12/21/12/26/glowworm-3031704_960_720.jpg",
      "https://cdn.pixabay.com/photo/2017/12/24/09/09/road-3036620_960_720.jpg",
      "https://cdn.pixabay.com/photo/2017/11/07/00/07/fantasy-2925250_960_720.jpg",
      "https://cdn.pixabay.com/photo/2017/10/10/15/28/butterfly-2837589_960_720.jpg"
    };
        
ViewPager viewPager = findViewById(R.id.viewpager);
ViewPagerAdapter adapter = new ViewPagerAdapter(this, imageUrls);
viewPager.setAdapter(adapter);

```

### 5. Add permission in AndroidManifest.xml

```
    <uses-permission android:name="android.permission.INTERNET" />

```

And that's it :)
