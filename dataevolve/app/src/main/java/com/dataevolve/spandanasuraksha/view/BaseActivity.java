package com.dataevolve.spandanasuraksha.view;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.dataevolve.spandanasuraksha.R;
import com.dataevolve.spandanasuraksha.prefe.AppPreferencesHelper;
import com.dataevolve.spandanasuraksha.prefe.MarshMallowPermission;

import java.util.ArrayList;

public class BaseActivity extends AppCompatActivity {

    Intent intent;

    private ProgressDialog _dialog;
    AppPreferencesHelper _preferencesHelper;
    public ArrayList<String> permissionsToRequest;
    public ArrayList<String> permissionsRejected = new ArrayList<>();
    public ArrayList<String> permissions = new ArrayList<>();
    public final static int ALL_PERMISSIONS_RESULT = 101;

    MarshMallowPermission marshMallowPermission;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _dialog = new ProgressDialog(BaseActivity.this);
        _preferencesHelper=new AppPreferencesHelper(this,"Spandana");
    }


    public void showProgress(){
        _dialog.show();
        _dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        _dialog.setContentView(R.layout.progress);
        _dialog.setCancelable(false);
    }


    public void stopProgress() {
        if (_dialog.isShowing()){
            _dialog.dismiss();
        }
    }

    public boolean numberValidate(String number) {
        final String regrex = "^(\\+91[\\-\\s]?)?[0]?(91)?[6789]\\d{9}$";
        if (number.matches(regrex))
        {
            ///Toast.makeText(getApplicationContext(),"valid mobile number",Toast.LENGTH_SHORT).show();
            return true;
        }
        else
        {
           // Toast.makeText(getApplicationContext(),"Invalid mobile number",Toast.LENGTH_SHORT).show();
            return false;
        }
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
