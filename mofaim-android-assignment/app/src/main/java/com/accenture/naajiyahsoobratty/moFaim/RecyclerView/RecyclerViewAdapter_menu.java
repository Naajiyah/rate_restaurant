package com.accenture.naajiyahsoobratty.moFaim.RecyclerView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.accenture.naajiyahsoobratty.moFaim.Entities.Menu;
import com.accenture.naajiyahsoobratty.moFaim.Entities.Restaurant;
import com.accenture.naajiyahsoobratty.mopasfaim.R;

import java.util.ArrayList;

public class RecyclerViewAdapter_menu extends RecyclerView.Adapter<RecyclerViewAdapter_menu.ViewHolder>{

    private static final String TAG="RecyclerViewAd_menu";

    private ArrayList<Menu> menuList=new ArrayList<>();
    private Context context;

    public RecyclerViewAdapter_menu(ArrayList<Menu> menuList, Context context) {
        this.menuList = menuList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_menu_list_items,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Log.d(TAG,"OnBindViewHolder: .called.");
        final int p=position;
        holder.menu_name.setText(menuList.get(position).getMenuName());
        holder.menu_price.setText(menuList.get(position).getPrice().toString());

        int menu_id = context.getResources().getIdentifier(menuList.get(position).getImage(),"drawable",context.getPackageName());
        holder.image.setImageResource(menu_id);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"onClick: Clicked on:"+menuList.get(p).getMenuName());
                Toast.makeText(context,menuList.get(p).getMenuName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView menu_name;
        TextView menu_price;
        RelativeLayout parentLayout;


        public ViewHolder(View itemView) {
            super(itemView);

            image=itemView.findViewById(R.id.imageMenu);
            menu_name=itemView.findViewById(R.id.menu_name);
            menu_price=itemView.findViewById(R.id.menu_price);
            parentLayout=itemView.findViewById(R.id.parent_menuLayout);
        }

    }
}
