package in.semicolonindia.schoolcrm.activities;

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.AppCompatRadioButton;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListPopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;

import in.semicolonindia.schoolcrm.BaseActivity;
import in.semicolonindia.schoolcrm.R;
import in.semicolonindia.schoolcrm.dialogs.ChangePasswordDialog;
import in.semicolonindia.schoolcrm.dialogs.ShowUserPicDialog;
import in.semicolonindia.schoolcrm.widgets.civ.CircleImageView;

/**
 * Created by Faraz on 03/01/2018.
 */
@SuppressWarnings("ALL")
public class ProfileActivity extends BaseActivity implements AdapterView.OnItemClickListener, DatePickerDialog.OnDateSetListener {

    private CircleImageView civUser;
    private ImageButton imgBtnChangePic;
    private ImageButton imgBtnBack;
    private ImageButton imgBtnGo;
    private Button btnPasswordChange;
    private Button btnDOBChange;
    private TextInputLayout tilEmail;
    private TextInputLayout tilPassword;
    private TextInputLayout tilDOB;
    private EditText etFullName;
    private EditText etEmail;
    private EditText etPassword;
    private EditText etMobileNo;
    private EditText etDOB;
    private EditText etFullAddress;
    private TextView tvGender;
    private AppCompatRadioButton rbMale;
    private AppCompatRadioButton rbFemale;
    private ListPopupWindow listPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getLayoutInflater().inflate(R.layout.activity_profile, contentFrame);

        init();
    }

    private void init() {
        fabMsg.setVisibility(View.GONE);
        final Typeface appRegular = Typeface.createFromAsset(getApplicationContext().getAssets(), "fonts/app_regular.ttf");
        final RelativeLayout rlUserPicParent = (RelativeLayout) findViewById(R.id.rlUserPicParent);
        civUser = (CircleImageView) findViewById(R.id.civUser);
        imgBtnChangePic = (ImageButton) findViewById(R.id.imgBtnChangePic);
        imgBtnBack = (ImageButton) findViewById(R.id.imgBtnBack);
        imgBtnGo = (ImageButton) findViewById(R.id.imgBtnGo);
        btnPasswordChange = (Button) findViewById(R.id.btnPasswordChange);
        btnDOBChange = (Button) findViewById(R.id.btnDOBChange);
        tilEmail = (TextInputLayout) findViewById(R.id.tilEmail);
        tilPassword = (TextInputLayout) findViewById(R.id.tilPassword);
        tilDOB = (TextInputLayout) findViewById(R.id.tilDOB);
        etFullName = (EditText) findViewById(R.id.etFullName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etMobileNo = (EditText) findViewById(R.id.etMobileNo);
        etDOB = (EditText) findViewById(R.id.etDOB);
        etFullAddress = (EditText) findViewById(R.id.etFullAddress);
        tvGender = (TextView) findViewById(R.id.tvGender);
        rbMale = (AppCompatRadioButton) findViewById(R.id.rbMale);
        rbFemale = (AppCompatRadioButton) findViewById(R.id.rbFemale);

        imgBtnChangePic.bringToFront();
        rlUserPicParent.invalidate();
        etFullName.setTypeface(appRegular);
        etEmail.setTypeface(appRegular);
        etPassword.setTypeface(appRegular);
        etMobileNo.setTypeface(appRegular);
        etDOB.setTypeface(appRegular);
        etFullAddress.setTypeface(appRegular);
        tvGender.setTypeface(appRegular);
        rbMale.setTypeface(appRegular);
        rbFemale.setTypeface(appRegular);
        btnPasswordChange.setTypeface(appRegular);
        btnDOBChange.setTypeface(appRegular);

        civUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowUserPicDialog mShowUserPicDialog = new ShowUserPicDialog(ProfileActivity.this,
                        R.style.DialogSlideAnim, civUser.getDrawable());
                mShowUserPicDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mShowUserPicDialog.getWindow().setGravity(Gravity.BOTTOM);
                mShowUserPicDialog.setCancelable(true);
                mShowUserPicDialog.setCanceledOnTouchOutside(false);
                mShowUserPicDialog.show();
            }
        });

        imgBtnChangePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] subNames = {"Open Camera", "Choose from Gallery"};
                listPopupWindow = new ListPopupWindow(ProfileActivity.this);
                listPopupWindow.setAdapter(new ArrayAdapter(ProfileActivity.this,
                        R.layout.pop_up_menu_item, subNames));
                listPopupWindow.setAnchorView(imgBtnChangePic);
                listPopupWindow.setWidth(380);
                listPopupWindow.setHeight(102 * subNames.length);
                listPopupWindow.setModal(true);
                listPopupWindow.setOnItemClickListener(ProfileActivity.this);
                listPopupWindow.show();
            }
        });

        etPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "hh", Toast.LENGTH_LONG).show();
            }
        });

        imgBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnPasswordChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChangePasswordDialog mChangePasswordDialog = new ChangePasswordDialog(ProfileActivity.this, R.style.DialogSlideAnim);
                mChangePasswordDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                mChangePasswordDialog.getWindow().setGravity(Gravity.BOTTOM);
                mChangePasswordDialog.setCancelable(false);
                mChangePasswordDialog.setCanceledOnTouchOutside(false);
                mChangePasswordDialog.show();
            }
        });

        btnDOBChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar now = Calendar.getInstance();
                DatePickerDialog dpd = DatePickerDialog.newInstance(
                        ProfileActivity.this,
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                dpd.setThemeDark(false);
                dpd.show(getFragmentManager(), "Datepickerdialog");
                dpd.setMaxDate(Calendar.getInstance());
                Calendar min = Calendar.getInstance();
                min.set(Calendar.MONTH, Calendar.JANUARY);
                min.set(Calendar.DAY_OF_MONTH, 1);
                min.set(Calendar.YEAR, (now.get(Calendar.MONTH) - 100));
                dpd.setMinDate(min);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        listPopupWindow.dismiss();
    }

    @Override
    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
        etDOB.setText(dayOfMonth + "-" + (++monthOfYear) + "-" + year);
    }
}