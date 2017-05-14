package id.sch.smktelkom_mlg.privateassignment.xirpl330.mymovie;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class MyIntro extends AppIntro {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addSlide(AppIntroFragment.newInstance("MyMovie",
                "Cari daftar film dari berbagai kategori",
                R.drawable.a3,
                Color.parseColor("#ffbf00")));

        addSlide(AppIntroFragment.newInstance("MyMovie",
                "Lihat film terpopuler saat ini",
                R.drawable.a1,
                Color.parseColor("#e6ac00")));


        addSlide(AppIntroFragment.newInstance("MyMovie",
                "Lihat cukup dari hp, dimana saja, dan kapan saja",
                R.drawable.a2,
                Color.parseColor("#997300")));

        showStatusBar(false);
        setBarColor(Color.parseColor("#00ffffff"));
        setSeparatorColor(Color.parseColor("#00ffffff"));
    }

    @Override
    public void onDonePressed() {
        startActivity(new Intent(MyIntro.this, MainActivity.class));
        finish();
    }

    @Override
    public void onSkipPressed(Fragment currentFragment) {
        startActivity(new Intent(MyIntro.this, MainActivity.class));
        Toast.makeText(MyIntro.this, "On Skip Clicked", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onSlideChanged() {
        Toast.makeText(MyIntro.this, "On Slide Clicked", Toast.LENGTH_SHORT).show();

    }
}
