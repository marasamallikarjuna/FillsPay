package com.dataevolve.spandanasuraksha.view;

import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProviders;

import com.dataevolve.spandanasuraksha.R;
import com.dataevolve.spandanasuraksha.model.SosRequest;
import com.dataevolve.spandanasuraksha.prefe.AppLocationService;
import com.dataevolve.spandanasuraksha.prefe.LocationTrack;
import com.dataevolve.spandanasuraksha.view_model.LoginViewModel;
import com.dataevolve.spandanasuraksha.view_model.SOSViewModel;
import com.gigamole.library.PulseView;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class SosActivity extends BaseActivity {

    PulseView pulseView;
    int counter=5;
    Button cancleButton;
    AppLocationService appLocationService;
    LocationTrack locationTrack;
    String incidentLocation,district,state;

    SOSViewModel sosViewModel;
    double longitude=0;
    double latitude=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sos_main);
        pulseView = (PulseView)findViewById(R.id.pv);
        cancleButton=findViewById(R.id.get_sos_btn);
        pulseView.startPulse();

        sosViewModel= ViewModelProviders.of(this).get(SOSViewModel.class);

        getLocation();

        cancleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    private void updateTimer() {
        new CountDownTimer(5000, 1000){
            public void onTick(long millisUntilFinished){
                cancleButton.setText("Cancel SOS "+String.valueOf(counter)+" Sec");
                counter--;
            }
            public  void onFinish(){
                cancleButton.setText("Sending SOS...");
                counter=5;
                cancleButton.setEnabled(false);
                sendSOSData();
            }
        }.start();
    }

    private void sendSOSData() {
        SosRequest sosRequest=new SosRequest();
        sosRequest.setType("EMERGENCY_SOS");
        sosRequest.setIncidentId("");
        sosRequest.setMobileNo(""+_preferencesHelper.getCurrentUserId());
        sosRequest.setVictimName("velcharan");
        sosRequest.setVictimAddress("test");
        sosRequest.setAge("26");
        sosRequest.setGender("M");
        sosRequest.setDateTime("05/12/2019 14:12:40");
        sosRequest.setEventDesc("Test Event from CDAC");
        sosRequest.setLatitude(latitude);
        sosRequest.setLongitude(longitude);
        sosRequest.setGpsPacketTime("0");
        sosRequest.setIncidentLocation(incidentLocation);
        sosRequest.setDistrict(district);
        sosRequest.setState(state);
        sosViewModel.getOtpResponseLiveData(sosRequest,_preferencesHelper.getAccessToken(),
                ""+_preferencesHelper.getCurrentUserId()).observe(this,sosRespones -> {
                    if (sosRespones.getPayLoad()!=null){
                        cancleButton.setText("SOS Sent Successfully");
                        cancleButton.setEnabled(true);
                        Toast.makeText(getApplicationContext(),sosRespones.getPayLoad(), Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"SOS Failed at Server Side", Toast.LENGTH_SHORT).show();
                    }
        });
    }

    private void getLocation() {
        locationTrack = new LocationTrack(SosActivity.this);
        if (locationTrack.canGetLocation()) {
             longitude = locationTrack.getLongitude();
             latitude = locationTrack.getLatitude();
            try {
                Geocoder geoCoder = new Geocoder(getApplicationContext(), Locale.getDefault());
                StringBuilder builder = new StringBuilder();
                List<Address> address = geoCoder.getFromLocation(latitude, longitude, 1);
                try{
                    if (!address.isEmpty()){
                        incidentLocation=address.get(0).getLocality()+","+address.get(0).getSubLocality();
                        district=address.get(0).getSubAdminArea();
                        state=address.get(0).getAdminArea();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            } catch (IOException e) {
                // Handle IOException
                e.printStackTrace();
            } catch (NullPointerException e) {
                // Handle NullPointerException
                e.printStackTrace();
            }
            if (longitude==0){
                getLocation();
            }else{
                updateTimer();
            }
        } else {
            locationTrack.showSettingsAlert();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
           // getLocation();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            locationTrack.stopListener();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
