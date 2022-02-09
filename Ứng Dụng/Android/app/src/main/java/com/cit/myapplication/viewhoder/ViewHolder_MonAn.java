package com.cit.myapplication.viewhoder;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cit.myapplication.R;
import com.cit.myapplication.info.Info_MonAn;
import com.cit.myapplication.info.Info_TrangChu;

import java.util.List;

public class ViewHolder_MonAn extends RecyclerView.ViewHolder{

    public List<Info_MonAn> users;
    public ImageView viewAnhMA;
    public TextView viewTenMA, viewLoaiMA, viewGiaView, viewSoLuong;
    public LinearLayout viewLinear;
    //
    protected LinearLayout item_BanPhong;
    public ViewHolder_MonAn(@NonNull View itemView) {
        super(itemView);

        viewAnhMA = itemView.findViewById(R.id.IT_MA_IM_Anh);
        viewTenMA = itemView.findViewById(R.id.IT_MA_TV_Ten);
        viewLoaiMA = itemView.findViewById(R.id.IT_MA_TV_TheLoai);
        viewGiaView = itemView.findViewById(R.id.IT_MA_TV_Gia);
        viewSoLuong = itemView.findViewById(R.id.IT_MA_TV_SL);
        //
        viewLinear = itemView.findViewById(R.id.IT_MA_Linear);
    }
}
