package com.cit.myapplication.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cit.myapplication.Activity_HoaDon;
import com.cit.myapplication.Activity_MonAn;
import com.cit.myapplication.R;
import com.cit.myapplication.info.Info_TrangChu;
import com.cit.myapplication.viewhoder.ViewHolder_TrangChu;

import java.util.ArrayList;
import java.util.List;

public class Adapter_TrangChu extends RecyclerView.Adapter<ViewHolder_TrangChu>{

    private Context mcontext;
    private List<Info_TrangChu> mData = new ArrayList<>();
    int TrangThai;
    //
    public Adapter_TrangChu(Context mcontext, List<Info_TrangChu> mData) {
        this.mcontext = mcontext;
        this.mData = mData;
    }
    //
    @NonNull
    @Override
    public ViewHolder_TrangChu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View item= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ban,parent,false);
        ViewHolder_TrangChu viewHolder = new ViewHolder_TrangChu(item);
        return new ViewHolder_TrangChu(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder_TrangChu holder, int position) {

        final Info_TrangChu imageModel=mData.get(position);
        ViewHolder_TrangChu imageItemHolder=(ViewHolder_TrangChu) holder;
        imageItemHolder.viewTenBan.setText(imageModel.getTenBan());//ten

        TrangThai = Integer.parseInt(imageModel.getTrangThai());//ddoi int
        if ( TrangThai == 0 )
        {
            if( imageModel.getMaKhuVuc().equals("KVNT") )
                imageItemHolder.viewAnhBan.setImageResource(R.drawable.ic_table01);
            else
                imageItemHolder.viewAnhBan.setImageResource(R.drawable.ic_table00);
        }
        else
        {
            if( imageModel.getMaKhuVuc().equals("KVNT") )
                imageItemHolder.viewAnhBan.setImageResource(R.drawable.ic_table11);
            else
                imageItemHolder.viewAnhBan.setImageResource(R.drawable.ic_table10);
        }

        //sự kien
        holder.viewLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //lay ban ma ban
                SharedPreferences sharedPref = mcontext.getSharedPreferences("MyPreferences", mcontext.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("SoBan", imageModel.getMaBan().trim() );
                editor.commit();
                if( imageModel.getTrangThai().equals("0") )
                {
                    Intent intent = new Intent(mcontext, Activity_MonAn.class);
                    intent.putExtra("SoBan", imageModel.getMaBan());
                    intent.putExtra("TenBan", imageModel.getTenBan());
                    intent.putExtra("TrangThai", imageModel.getTrangThai());
                    mcontext.startActivity(intent);
                }
                else
                {
                    Intent intent = new Intent(mcontext, Activity_HoaDon.class);
                    intent.putExtra("SoBan", imageModel.getMaBan());
                    intent.putExtra("TenBan", imageModel.getTenBan());
                    intent.putExtra("TrangThai", imageModel.getTrangThai());
                    mcontext.startActivity(intent);
                }

            }
        });

    }

    @Override
    public int getItemCount() {

        return mData.size();
    }
}
