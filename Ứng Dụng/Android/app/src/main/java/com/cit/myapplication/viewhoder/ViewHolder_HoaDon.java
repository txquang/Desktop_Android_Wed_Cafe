package com.cit.myapplication.viewhoder;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cit.myapplication.R;
import com.cit.myapplication.info.Info_HoaDon;

import java.util.List;

public class ViewHolder_HoaDon extends RecyclerView.ViewHolder{

    public List<Info_HoaDon> users;
    public ImageView viewAnhSP;
    public TextView viewTenSP;
    public TextView viewGiaBan;
    public TextView viewSoLuong;
    public TextView viewThanhTien;
    public ImageButton viewXoa;
    public LinearLayout viewLinear;
    //
    protected LinearLayout item_HoaDon;
    public ViewHolder_HoaDon(@NonNull View itemView) {
        super(itemView);

        viewAnhSP = itemView.findViewById(R.id.IT_HD_Anh);
        viewTenSP = (TextView) itemView.findViewById(R.id.IT_HD_TV_Ten);
        viewGiaBan = (TextView) itemView.findViewById(R.id.IT_HD_TV_Gia);
        viewSoLuong = (TextView) itemView.findViewById(R.id.IT_HD_TV_SoLuong);
        viewThanhTien = (TextView) itemView.findViewById(R.id.IT_HD_TV_ThanhTien);
        viewXoa = itemView.findViewById(R.id.imagecancel);
        //
        viewLinear = itemView.findViewById(R.id.IT_LN_HoaDon);
    }
}
