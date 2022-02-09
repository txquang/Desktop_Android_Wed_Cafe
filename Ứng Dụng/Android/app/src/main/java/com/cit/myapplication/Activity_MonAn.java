package com.cit.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.cit.myapplication.adapter.Adapter_MonAn;
import com.cit.myapplication.congketnoi.NetworkResponseListener_MonAn;
import com.cit.myapplication.info.Info_MonAn;
import com.cit.myapplication.info.Info_TrangChu;
import com.cit.myapplication.ketnoi.Task_MonAn;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class Activity_MonAn extends AppCompatActivity implements NetworkResponseListener_MonAn {

    private RecyclerView RC_MA;
    private CardView CV_Cafe, CV_MonAn, CV_Nuocuong, CV_Khac;
    private ProgressBar progressBar;
    String URL;
    JSONArray JS_MonAn = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monan);

        AnhXa();

        URL = "http://"+getString(R.string.DiaChi)+"/LARAVEL/public/api/MonAn";
        Task_MonAn task_monAn = new Task_MonAn(Activity_MonAn.this, URL);
        if ( JS_MonAn == null)
            task_monAn.execute();

    }



    @Override
    public void SuccessData(String data) {//lay mon an
        try {
            JS_MonAn = new JSONArray(data);
            //mặt địnhlod cf truoc
            LoadMonAn("MNCF");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("WrongConstant")
    @Override
    public void FailedData() {
        Toast.makeText(this, "Mon An"+getString(R.string.DiaChi), 20000).show();
    }
    private void AnhXa() {

        progressBar= findViewById(R.id.progress);
        RC_MA = findViewById(R.id.RC_MA);
        CV_Cafe = findViewById(R.id.DM_CV_Cafe);
        CV_MonAn = findViewById(R.id.DM_CV_MonAn);
        CV_Nuocuong = findViewById(R.id.DM_CV_NuocUong);
        CV_Khac = findViewById(R.id.DM_CV_Khac);

        CV_Cafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadMonAn("MNCF");
            }
        });
        CV_MonAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadMonAn("MNAU");
            }
        });
        CV_Nuocuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadMonAn("MNNU");
            }
        });
        CV_Khac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoadMonAn("MNDV");
            }
        });
    }
    private void LoadMonAn(String MaNhom)
    {
        if( JS_MonAn != null)
        {
            List<Info_MonAn> info_monAn =new ArrayList<>();
            for (int i=0; i<JS_MonAn.length(); i++)
            {
                try
                {
                    if( JS_MonAn.getJSONObject(i).getString("MaNhom").equals(MaNhom) )
                    {
                        info_monAn.add(
                                new Info_MonAn(
                                        JS_MonAn.getJSONObject(i).getString("MaSP"),
                                        JS_MonAn.getJSONObject(i).getString("TenSP"),
                                        JS_MonAn.getJSONObject(i).getString("MaDVT"),
                                        JS_MonAn.getJSONObject(i).getString("SLDK"),
                                        JS_MonAn.getJSONObject(i).getString("GTDK"),
                                        JS_MonAn.getJSONObject(i).getString("MaNhom"),
                                        JS_MonAn.getJSONObject(i).getString("TenNhom")
                                )
                        );
                    }

                    Adapter_MonAn imageItemAdapter=new Adapter_MonAn(this,info_monAn);
                    RC_MA.setLayoutManager(new LinearLayoutManager(this));
                    RC_MA.setAdapter(imageItemAdapter);

                    progressBar.setVisibility(View.GONE);//
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
