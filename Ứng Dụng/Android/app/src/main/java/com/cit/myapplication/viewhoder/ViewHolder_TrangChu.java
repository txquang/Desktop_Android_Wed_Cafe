package com.cit.myapplication.viewhoder;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cit.myapplication.R;
import com.cit.myapplication.info.Info_TrangChu;

import java.util.List;

public class ViewHolder_TrangChu extends RecyclerView.ViewHolder{

    public List<Info_TrangChu> users;
    public ImageView viewAnhBan;
    public Button viewTenBan;
    public LinearLayout viewLinear;
    //
    protected LinearLayout item_BanPhong;
    public ViewHolder_TrangChu(@NonNull View itemView) {
        super(itemView);

        viewAnhBan = itemView.findViewById(R.id.IT_BP_IV_Anh);
        viewTenBan = (Button) itemView.findViewById(R.id.IT_BP_BT_TenBan);
        //
        viewLinear = itemView.findViewById(R.id.IT_BP_LN);
    }
}
