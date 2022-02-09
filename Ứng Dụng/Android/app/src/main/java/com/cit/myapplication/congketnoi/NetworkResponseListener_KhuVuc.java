package com.cit.myapplication.congketnoi;

public interface NetworkResponseListener_KhuVuc {

    //Handle When We Recevie Success Data
    void SuccessData(String data);

    //When We Received Fail Response
    void FailedData();
}
