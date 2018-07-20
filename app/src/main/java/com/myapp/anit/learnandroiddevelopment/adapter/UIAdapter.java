package com.myapp.anit.learnandroiddevelopment.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.myapp.anit.learnandroiddevelopment.R;
import com.myapp.anit.learnandroiddevelopment.model.UIWidgets;

import java.util.ArrayList;

public class UIAdapter extends RecyclerView.Adapter<UIAdapter.ViewHolder> {
    Context context;
    ArrayList<UIWidgets> list;

    public UIAdapter(Context context, ArrayList<UIWidgets> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.row_view,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        viewHolder.textView.setText(list.get(i).getName());
        viewHolder.imageView.setBackgroundResource(list.get(i).getImg());
        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                viewHolder.linearLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.colorGreen));
                if (onItemClickedListener != null) {
                    onItemClickedListener.onItemClick(viewHolder.textView.getText().toString());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        LinearLayout linearLayout;
        TextView textView;
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textV);
            imageView = (ImageView) itemView.findViewById(R.id.imageV);
            linearLayout= (LinearLayout) itemView.findViewById(R.id.linear);
        }
    }

    public interface OnItemClickedListener {
        void onItemClick(String name);
    }

    private OnItemClickedListener onItemClickedListener;

    public void setOnItemClickedListener(OnItemClickedListener onItemClickedListener) {
        this.onItemClickedListener = onItemClickedListener;
    }
}
