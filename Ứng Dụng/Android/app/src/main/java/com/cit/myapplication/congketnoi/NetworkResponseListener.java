package com.cit.myapplication.congketnoi;

public interface NetworkResponseListener {

    //Handle When We Recevie Success Data
    void SuccessData(String data);

    //When We Received Fail Response
    void FailedData();
}
