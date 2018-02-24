package in.zappy.kashiftask;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;


/*
RecyclerView adapter for viewing notes list
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private final String TAG = getClass().getSimpleName();
    private Context context;
    private ArrayList<String> foodList;

    public MyAdapter(Activity context, ArrayList<String> foodList) {
        this.context = context;
        this.foodList = foodList;

        Log.d(TAG, "size=" + foodList.size());
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.food_row, viewGroup, false);

        return new MyViewHolder(itemView);
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        RelativeLayout rootLayout;
        ImageView ivFoodImage;
        TextView tvTitle;

        public MyViewHolder(View itemLayoutView) {
            super(itemLayoutView);

            rootLayout = (RelativeLayout) itemLayoutView.findViewById(R.id.rl_listRow);
            ivFoodImage = (ImageView) itemLayoutView.findViewById(R.id.iv_bgImg);
            tvTitle = (TextView) itemLayoutView.findViewById(R.id.tv_name);

        }
    }


    @Override
    public void onBindViewHolder(MyViewHolder viewHolder, final int position) {

        viewHolder.tvTitle.setText(foodList.get(position));

        if (foodList.get(position).equals("Pizza")) {
            viewHolder.ivFoodImage.setImageResource(R.drawable.pizza);
        } else if (foodList.get(position).equals("Burger")) {
            viewHolder.ivFoodImage.setImageResource(R.drawable.burger);
        } else if (foodList.get(position).equals("Pasta")) {
            viewHolder.ivFoodImage.setImageResource(R.drawable.pasta);
        }

        viewHolder.rootLayout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent intent = new Intent( context, AddFoodActivity.class );
                intent.putExtra( "foodType", foodList.get(position) );
                context.startActivity( intent );

            }
        });

    }


}//end
