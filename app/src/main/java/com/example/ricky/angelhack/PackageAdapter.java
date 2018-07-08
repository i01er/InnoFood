package com.example.ricky.angelhack;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import java.util.List;



public class PackageAdapter extends RecyclerView.Adapter<PackageAdapter.PackageViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the Packages in a list
    private List<Package> PackageList;
    private ClickListener clicklistener = null;

    //getting the context and Package list with constructor
    public PackageAdapter(Context mCtx, List<Package> PackageList) {
        this.mCtx = mCtx;
        this.PackageList = PackageList;
    }

    @Override
    public PackageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout, null);
        return new PackageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PackageViewHolder holder, int position) {
        //getting the Package of the specified position
        Package Package = PackageList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(Package.getTitle());
        holder.textViewMain.setText(Package.getMain());
        holder.textViewSeason.setText(String.valueOf(Package.getSeason()));
        holder.textViewBody.setText(String.valueOf(Package.getBody()));

        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(Package.getImage()));

    }


    @Override
    public int getItemCount() {
        return PackageList.size();
    }


    class PackageViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewMain, textViewSeason, textViewBody;
        ImageView imageView;
        RelativeLayout main;

        public PackageViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewMain = itemView.findViewById(R.id.textViewMain);
            textViewSeason = itemView.findViewById(R.id.textViewSeason);
            textViewBody = itemView.findViewById(R.id.textViewBody);
            imageView = itemView.findViewById(R.id.imageView);

            main = (RelativeLayout) itemView.findViewById(R.id.result);
            main.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //Toast.makeText(view.getContext(), "Position:" + Integer.toString(getPosition()), Toast.LENGTH_SHORT).show();

                    if(clicklistener !=null){
                        clicklistener.itemClicked(v,getAdapterPosition());
                    }
                }
            });

        }
    }

    public void setClickListener(ClickListener clickListener){
        this.clicklistener = clickListener;
    }


}

