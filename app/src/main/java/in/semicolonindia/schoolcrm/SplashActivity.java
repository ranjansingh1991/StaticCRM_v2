package in.semicolonindia.schoolcrm;

import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.location.LocationListener;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import in.semicolonindia.schoolcrm.dialogs.LoginDialog;

@SuppressWarnings("ALL")
public class SplashActivity extends AppCompatActivity implements LocationListener, View.OnClickListener {

    private final int PERMISSIONS_REQUEST_LOCATION = 99;
    private ImageView imgBtnGo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                        android.Manifest.permission.ACCESS_FINE_LOCATION)) {
                    ActivityCompat.requestPermissions(this, new String[]
                            {android.Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_REQUEST_LOCATION);
                } else {
                    ActivityCompat.requestPermissions(this, new String[]
                            {android.Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSIONS_REQUEST_LOCATION);
                }
            } else {
                init();
            }
        } else {
            init();
        }
    }

    private void init() {
        final Typeface appBold = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/app_bold.ttf");
        final LinearLayout llHeader = (LinearLayout) findViewById(R.id.llHeader);
        final ImageView imgLogo = (ImageView) findViewById(R.id.imgLogo);
        final TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        imgBtnGo = (ImageView) findViewById(R.id.imgBtnGo);
        imgBtnGo.setVisibility(View.GONE);
        imgBtnGo.setOnClickListener(this);
        tvTitle.setTypeface(appBold);
        final Animation animFall = AnimationUtils.loadAnimation(this, R.anim.fall);
        final Animation animFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        final Animation animZoomIn = AnimationUtils.loadAnimation(this, R.anim.zoom_in);
        final Animation animZoomOut = AnimationUtils.loadAnimation(this, R.anim.zoom_out);
        animFall.setInterpolator((new AccelerateDecelerateInterpolator()));
        animFall.setFillAfter(true);
        llHeader.startAnimation(animFall);
        tvTitle.startAnimation(animFadeOut);
        imgBtnGo.startAnimation(animZoomOut);
        animZoomOut.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imgBtnGo.startAnimation(animZoomIn);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        animZoomIn.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                imgBtnGo.startAnimation(animZoomOut);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        showLogin();
    }

    private void showLogin() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                LoginDialog mLoginDialog = new LoginDialog(SplashActivity.this, R.style.DialogSlideAnim);
                mLoginDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mLoginDialog.getWindow().setGravity(Gravity.BOTTOM);
                mLoginDialog.setCancelable(false);
                mLoginDialog.setCanceledOnTouchOutside(false);
                mLoginDialog.show();
                imgBtnGo.setVisibility(View.VISIBLE);
            }
        }, 5000);
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST_LOCATION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {
                        Log.e("Permission", "Granted");
                        init();
                    }
                } else {
                    Toast.makeText(this, "permission denied".toUpperCase(Locale.US), Toast.LENGTH_LONG).show();
                    SplashActivity.this.finish();
                }
            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imgBtnGo:
                LoginDialog mLoginDialog = new LoginDialog(SplashActivity.this, R.style.DialogSlideAnim);
                mLoginDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mLoginDialog.getWindow().setGravity(Gravity.BOTTOM);
                mLoginDialog.setCancelable(false);
                mLoginDialog.setCanceledOnTouchOutside(false);
                mLoginDialog.show();
                break;
        }
    }
}