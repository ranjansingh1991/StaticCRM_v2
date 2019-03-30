package in.semicolonindia.schoolcrm.activities;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;

import in.semicolonindia.schoolcrm.R;
import in.semicolonindia.schoolcrm.dialogs.ProgressDialog;
import in.semicolonindia.schoolcrm.widgets.map.GoogleMapStyler;


/**
 * Created by Faraz on 03/09/2018.
 */
@SuppressWarnings("ALL")
public class MapActivity extends FragmentActivity implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, LocationListener {

    private LatLng mOrigin;
    private GoogleMap mMap;
    private double dLatitute;
    private double dLongitute;
    private GoogleApiClient mGoogleApiClient;
    private Marker mMarker;
    private LocationManager locationManager;
    private LocationListener mLocationListener;
    private ProgressDialog mProgressDialog;
    private boolean isQuicksearchExpanded = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        mProgressDialog = new ProgressDialog(MapActivity.this, getApplicationContext().
                getResources().getString(R.string.please_wait));
        mProgressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mProgressDialog.setCanceledOnTouchOutside(false);
        mProgressDialog.setCancelable(false);
        mProgressDialog.show();
        init();
    }

    private void init() {
        final Typeface appBold = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/app_bold.ttf");
        final TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        final SupportMapFragment mapFragment = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.frgMaps));
        mapFragment.getMapAsync(this);
        tvTitle.setTypeface(appBold);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String sBestProvider = locationManager.getBestProvider(criteria, true);
        Location loc = locationManager.getLastKnownLocation(sBestProvider);
        if (loc != null) {
            onLocationChanged(loc);
        } else {
            loc = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            if (loc != null)
                onLocationChanged(loc);
        }
        GoogleMapStyler googleMapStyler = new GoogleMapStyler.Builder(MapActivity.this).build();
        mMap.setMapStyle(googleMapStyler.getMapStyleOptions());
        mMap.setBuildingsEnabled(true);
        mMap.setMyLocationEnabled(true);
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        builder.include(mOrigin);
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(true);
        mMap.getUiSettings().setAllGesturesEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mProgressDialog.hide();
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        dLatitute = location.getLatitude();
        dLongitute = location.getLongitude();
        mOrigin = new LatLng(dLatitute, dLongitute);
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(mOrigin, 17.0f);
        mMap.animateCamera(cameraUpdate);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}