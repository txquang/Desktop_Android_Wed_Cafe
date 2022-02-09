package com.cit.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.cit.myapplication.adapter.Adapter_TrangChu;
import com.cit.myapplication.congketnoi.NetworkResponseListener_TrangChu;
import com.cit.myapplication.info.Info_TrangChu;
import com.cit.myapplication.ketnoi.Task_TrangChu;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class Activity_TrangChu extends AppCompatActivity implements NetworkResponseListener_TrangChu {

    private RecyclerView RC_TC;
    private CardView CV_NgoaiTroi, CV_TrongNha;
    private ProgressBar progressBar;
    String URL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trangchu);
        AnhXa();
        //Recy();

        URL = "http://"+getString(R.string.DiaChi)+"/LARAVEL/public/api/BanPhong";
        Task_TrangChu task_trangChu = new Task_TrangChu(Activity_TrangChu.this, URL);
        task_trangChu.execute();
    }
    //them load lai trang
    @Override
    public void onRestart() {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }

    @Override
    public void SuccessData(String data) {

        try
        {
            List<Info_TrangChu> info_trangChu =new ArrayList<>();
            JSONArray jsonArray = new JSONArray(data);
            for (int i=0;i<jsonArray.length();i++)
            {
                info_trangChu.add(
                        new Info_TrangChu(
                                jsonArray.getJSONObject(i).getString("SoBan"),
                                jsonArray.getJSONObject(i).getString("MaKV"),
                                jsonArray.getJSONObject(i).getString("TenBan"),
                                jsonArray.getJSONObject(i).getString("NoUse")
                        )
                );
            }
            Adapter_TrangChu imageItemAdapter=new Adapter_TrangChu(this,info_trangChu);
            RC_TC.setLayoutManager(new GridLayoutManager(this,3));
            RC_TC.setAdapter(imageItemAdapter);
        }
        catch (JSONException e){
            e.printStackTrace();
        }

        progressBar.setVisibility(View.GONE);
    }

    @SuppressLint("WrongConstant")
    @Override
    public void FailedData() {
        Toast.makeText(this, "Vui Lòng Kiểm Tra IP Máy Tính: "+getString(R.string.DiaChi), 20000).show();
    }
    public void AnhXa()
    {
        //RC_BP = findViewById(R.id.RC_BP);
        progressBar= findViewById(R.id.progress);
        RC_TC = findViewById(R.id.RC_TC);
        CV_NgoaiTroi = findViewById(R.id.DM_CV_NgoaiTroi);
        CV_TrongNha = findViewById(R.id.DM_CV_TrongNha);

        CV_NgoaiTroi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Activity_TrangChu.this, Activity_KhuVuc.class );
                intent.putExtra("MaKV", "KVNT");
                intent.putExtra("TenKV","Khu Vực Ngoài Trời");
                intent.putExtra("AnhKV",1);
                Activity_TrangChu.this.startActivity(intent);
                //startActivity( new Intent(Activity_TrangChu.this, Activity_DonHang.class));
            }
        });
        CV_TrongNha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( Activity_TrangChu.this, Activity_KhuVuc.class );
                intent.putExtra("MaKV", "KVTP");
                intent.putExtra("TenKV","Khu Vực Trong Nhà");
                intent.putExtra("AnhKV",2);
                Activity_TrangChu.this.startActivity(intent);
            }
        });
    }
}
