package com.metrocoding.pdfapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.metrocoding.pdfapp.Home.Home;
import com.metrocoding.pdfapp.R;
import com.metrocoding.pdfapp.databinding.ActivityNightmodeBinding;

public class Nightmode extends AppCompatActivity {

    ActivityNightmodeBinding binding;
    Animation fabOpen, fabclose , rotare_faw, rotate_back;
    boolean isOpen = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNightmodeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        pdf_view_night();

        // Animation

        fabOpen = AnimationUtils.loadAnimation(this , R.anim.fab_anim);
        fabclose = AnimationUtils.loadAnimation(this , R.anim.fab_close);
        rotare_faw = AnimationUtils.loadAnimation(this , R.anim.rotate_faword);
        rotate_back = AnimationUtils.loadAnimation(this , R.anim.backword_anim);




        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                animaFab();
            }
        });




        binding.home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext() , Home.class);
                startActivity(intent);
            }
        });

        binding.horzan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pdf_view_horiz();
            }
        });


        binding.night.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pdf_view_night();
            }
        });
    }





    private void pdf_view_night()
    {



        binding.pdfView.fromAsset("app.pdf")
                .pages(0, 2, 1, 3, 3, 3) // all pages are displayed by default
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                // allows to draw something on the current page, usually visible in the middle of the screen
                // allows to draw something on all pages, separately for every page. Called only for visible pages// called after document is loaded and starts to be rendered
                // called after document is rendered for the first time
                // called on single tap, return true if handled, false to toggle scroll handle visibility
                .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                .password(null)
                .scrollHandle(new DefaultScrollHandle(Nightmode.this))
                .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                // spacing between pages in dp. To define spacing color, set view background
                .spacing(0)
                .autoSpacing(false) // add dynamic spacing to fit each page on its own on the screen
                .pageFitPolicy(FitPolicy.WIDTH) // mode to fit pages in the view
                .fitEachPage(false) // fit each page to the view, else smaller pages are scaled relative to largest page.
                .pageSnap(false) // snap pages to screen boundaries
                .pageFling(false) // make a fling change only a single page like ViewPager
                .nightMode(true) // toggle night mode
                .load();
    }


    private void animaFab()
    {

        if(isOpen)
        {
            binding.fab.startAnimation(rotare_faw);
            binding.night.startAnimation(fabclose);
            binding.nightText.startAnimation(fabclose);
            binding.horzan.startAnimation(fabclose);
            binding.horzanText.startAnimation(fabclose);
            binding.home.startAnimation(fabclose);
            binding.homeText.startAnimation(fabclose);
            binding.night.setClickable(false);
            binding.nightText.setClickable(false);
            binding.horzan.setClickable(false);
            binding.horzanText.setClickable(false);
            binding.home.setClickable(false);
            binding.homeText.setClickable(false);



            isOpen=false;




        }

        else
        {
            binding.fab.startAnimation(rotate_back);
            binding.night.startAnimation(fabOpen);
            binding.nightText.startAnimation(fabOpen);
            binding.horzan.startAnimation(fabOpen);
            binding.horzanText.startAnimation(fabOpen);

            binding.home.startAnimation(fabOpen);
            binding.homeText.startAnimation(fabOpen);
            binding.night.setClickable(true);
            binding.nightText.setClickable(true);
            binding.horzan.setClickable(true);
            binding.horzanText.setClickable(true);
            binding.home.setClickable(true);
            binding.homeText.setClickable(true);


            isOpen=true;

        }
    }

    private void pdf_view_horiz()
    {



        binding.pdfView.fromAsset("app.pdf")
                .pages(0, 2, 1, 3, 3, 3) // all pages are displayed by default
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(false)
                .enableDoubletap(true)
                .defaultPage(0)
                // allows to draw something on the current page, usually visible in the middle of the screen
                // allows to draw something on all pages, separately for every page. Called only for visible pages// called after document is loaded and starts to be rendered
                // called after document is rendered for the first time
                // called on single tap, return true if handled, false to toggle scroll handle visibility
                .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                .password(null)
                .scrollHandle(new DefaultScrollHandle(Nightmode.this))
                .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                // spacing between pages in dp. To define spacing color, set view background
                .spacing(0)
                .autoSpacing(false) // add dynamic spacing to fit each page on its own on the screen
                .pageFitPolicy(FitPolicy.WIDTH) // mode to fit pages in the view
                .fitEachPage(false) // fit each page to the view, else smaller pages are scaled relative to largest page.
                .pageSnap(false) // snap pages to screen boundaries
                .pageFling(false) // make a fling change only a single page like ViewPager
                .nightMode(false) // toggle night mode
                .load();
    }



}