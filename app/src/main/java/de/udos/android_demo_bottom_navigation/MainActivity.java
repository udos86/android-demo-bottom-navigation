package de.udos.android_demo_bottom_navigation;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        final FragmentManager fragmentManager = getSupportFragmentManager();
        final Fragment currentFragment = fragmentManager.findFragmentById(R.id.containerContentFragment);
        final Fragment nextFragment;

        switch (item.getItemId()) {

            case R.id.one:

                nextFragment = new ContentFragment1();
                break;

            case R.id.two:

                nextFragment = new ContentFragment2();
                break;

            case R.id.three:

                nextFragment = new ContentFragment3();
                break;

            default:

                nextFragment = null;
                break;
        }

        if (currentFragment == null || (currentFragment.getClass() != nextFragment.getClass())) {

            fragmentManager
                    .beginTransaction()
                    .replace(R.id.containerContentFragment, nextFragment)
                    .addToBackStack(null)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();
        }

        return false;
    }
}
