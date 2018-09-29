package com.example.cascer.bookingapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.ViewHolder> {

    private List<Booking> dataset;
    private Context context;
    private onClickListener onClickListener;

    public BookingAdapter(Context context, BookingAdapter.onClickListener onClickListener) {
        this.dataset = new ArrayList<>();
        this.context = context;
        this.onClickListener = onClickListener;
    }

    public Booking getItem(int position) {
        return dataset.get(position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.booking, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Booking booking = dataset.get(position);

        holder.tvClass.setText(booking.getmClass());
        holder.tvName.setText(booking.getmName());
        holder.tvPrice.setText(booking.getmPrice());
        holder.tvStation.setText(booking.getmStation());
        holder.tvTime.setText(booking.getmTime());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void addAll(List<Booking> data) {
        this.dataset.addAll(data);
        notifyDataSetChanged();
    }

    public void clear() {
        dataset.clear();
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_class)
        TextView tvClass;
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_price)
        TextView tvPrice;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_station)
        TextView tvStation;
        @BindView(R.id.btn_pesan)
        Button btnPesan;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            btnPesan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickListener.onClick(dataset.get(getAdapterPosition()));
                }
            });
        }
    }

    public interface onClickListener {
        void onClick(Booking booking);
    }
}
