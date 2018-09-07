package com.accenture.naajiyahsoobratty.moFaim.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.accenture.naajiyahsoobratty.moFaim.Activities.Dashboard;
import com.accenture.naajiyahsoobratty.moFaim.Activities.MenuList;
import com.accenture.naajiyahsoobratty.moFaim.Entities.Restaurant;
import com.accenture.naajiyahsoobratty.mopasfaim.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    private ArrayList<Restaurant> restaurantList = new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter(ArrayList<Restaurant> restaurantList, Context context) {
        this.restaurantList = restaurantList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_items, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Log.d(TAG, "OnBindViewHolder: .called.");
        final int p = position;
        holder.imageName.setText(restaurantList.get(position).getRestaurant_name());
        holder.restaurant_location.setText(restaurantList.get(position).getRestarant_location());

        int resId = context.getResources().getIdentifier(restaurantList.get(position).getRestaurant_image(), "drawable", context.getPackageName());
        holder.image.setImageResource(resId);
        holder.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + restaurantList.get(p).getRestarant_phoneNo()));
                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                context.startActivity(intent);
            }
        });

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"onClick: Clicked on:"+restaurantList.get(p).getRestaurant_name());
                Toast.makeText(context,restaurantList.get(p).getRestaurant_name(),Toast.LENGTH_SHORT).show();

                Intent toMenuListActivity = new Intent(context, MenuList.class);
                toMenuListActivity.putExtra("RESTAURANT",restaurantList.get(p).getRestaurant_id());
                context.startActivity(toMenuListActivity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurantList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView imageName;
        TextView restaurant_location;
        RelativeLayout parentLayout;
        Button call;



        public ViewHolder(View itemView) {
            super(itemView);

            image=itemView.findViewById(R.id.image);
            imageName=itemView.findViewById(R.id.image_name);
            parentLayout=itemView.findViewById(R.id.parent_layout);
            restaurant_location=itemView.findViewById(R.id.restaurant_location);
            call=itemView.findViewById(R.id.button_call);

        }

    }

}
