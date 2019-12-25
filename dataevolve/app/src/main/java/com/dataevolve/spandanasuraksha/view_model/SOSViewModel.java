package com.dataevolve.spandanasuraksha.view_model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.dataevolve.spandanasuraksha.model.SosRequest;
import com.dataevolve.spandanasuraksha.model.SosRespones;
import com.dataevolve.spandanasuraksha.repository.SosRepository;

public class SOSViewModel extends AndroidViewModel {

    private SosRepository sosRepository;
    private LiveData<SosRespones> sosResponesLiveData;
    public SOSViewModel(@NonNull Application application) {
        super(application);
        sosRepository=new SosRepository();
    }
    public LiveData<SosRespones> getOtpResponseLiveData(SosRequest sosRequest,String token,String number) {
        this.sosResponesLiveData = sosRepository.sendSosRequest(sosRequest,token,number);
        return sosResponesLiveData;
    }
}
