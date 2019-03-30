package in.semicolonindia.schoolcrm.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;
import android.view.View;

import in.semicolonindia.schoolcrm.BaseActivity;
import in.semicolonindia.schoolcrm.R;
import in.semicolonindia.schoolcrm.fragments.FragmentBookShelf;
import in.semicolonindia.schoolcrm.fragments.FragmentLibHome;
import in.semicolonindia.schoolcrm.fragments.FragmentLibNotification;
import in.semicolonindia.schoolcrm.fragments.FragmentPDFs;
import in.semicolonindia.schoolcrm.fragments.FragmentVideos;
import in.semicolonindia.schoolcrm.utils.BottomNavigationViewHelper;

public class LibraryActivity extends BaseActivity {

    private FragmentManager mFragmentManager = getSupportFragmentManager();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mFragmentManager.beginTransaction().replace(R.id.container_lib, new FragmentLibHome()).commit();
                    return true;
                case R.id.navigation_pdf:
                    mFragmentManager.beginTransaction().replace(R.id.container_lib, new FragmentPDFs()).commit();
                    return true;
                case R.id.navigation_video:
                    mFragmentManager.beginTransaction().replace(R.id.container_lib, new FragmentVideos()).commit();
                    return true;
                case R.id.navigation_book_shelf:
                    mFragmentManager.beginTransaction().replace(R.id.container_lib, new FragmentBookShelf()).commit();
                    return true;
                case R.id.navigation_notification:
                    mFragmentManager.beginTransaction().replace(R.id.container_lib, new FragmentLibNotification()).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLayoutInflater().inflate(R.layout.activity_library, contentFrame);

        init();
    }

    private void init() {
        fabMsg.setVisibility(View.GONE);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        BottomNavigationViewHelper.disableShiftMode(navigation);
        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction().replace(R.id.container_lib, new FragmentLibHome()).commit();
    }
}
