package com.t.meditationapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.t.meditationapp.ModelClasses.GetVoiceData;
import com.t.meditationapp.R;

import java.util.List;

public class VoiceAdapter extends RecyclerView.Adapter<VoiceAdapter.ItemView> {
    List<GetVoiceData> voiceData;
    Context context;

    public VoiceAdapter(List<GetVoiceData> voiceData, Context context) {
        this.voiceData = voiceData;
        this.context=context;
    }

    @NonNull
    @Override
    public ItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.voice_data_item,parent,false);
        return new ItemView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemView holder, final int position) {
        holder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position == 0){
                    holder.ll.setBackgroundResource(R.mipmap.alice_bg);
                    ll_tiff_bg.setBackgroundResource(R.mipmap.signup_fb_bg);
                    ll_kevin_bg.setBackgroundResource(R.mipmap.blue_curve_bg);
                }
                if (position == 1){
                    ll_alice_bg.setBackgroundResource(R.mipmap.alice_bg_two);
                    ll_tiff_bg.setBackgroundResource(R.mipmap.signup_fb_bg_two);
                    ll_kevin_bg.setBackgroundResource(R.mipmap.blue_curve_bg);
                }
                if (position == 2){
                    ll_alice_bg.setBackgroundResource(R.mipmap.alice_bg_two);
                    ll_tiff_bg.setBackgroundResource(R.mipmap.signup_fb_bg);
                    ll_kevin_bg.setBackgroundResource(R.mipmap.blue_curve_bg_two);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return voiceData.size();
    }

    public class ItemView extends RecyclerView.ViewHolder {
        LinearLayout ll;

        public ItemView(@NonNull View itemView) {
            super(itemView);
            ll = itemView.findViewById(R.id.ll_alice_bg_rv);

        }
    }
}
