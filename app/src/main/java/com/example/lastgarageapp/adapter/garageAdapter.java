package com.example.lastgarageapp.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.lastgarageapp.R;
import com.example.lastgarageapp.conversation;
import com.example.lastgarageapp.edit_garage;
import com.example.lastgarageapp.home_page;
import com.example.lastgarageapp.itemClasses.garageItem;
import com.example.lastgarageapp.login;
import com.example.lastgarageapp.my_singleton;
import com.example.lastgarageapp.personal_page;
import com.example.lastgarageapp.url_serverName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class garageAdapter extends RecyclerView.Adapter<garageAdapter.garageViewHolder> {

    private ArrayList<garageItem> myGarageItem;
    private LayoutInflater mInflater;
    Context con;
    home_page h;

    public garageAdapter(Context context, ArrayList<garageItem> myGarageItem) {
        this.myGarageItem = myGarageItem;
        this.con=context;
        this.mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public garageAdapter.garageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= mInflater.inflate(R.layout.activity_garage_status_list_item,parent,false);
        garageAdapter.garageViewHolder holder =new garageAdapter.garageViewHolder(view);
        return holder;
    }


    @Override
    public void onBindViewHolder(garageAdapter.garageViewHolder holder, int position) {
        garageItem g = myGarageItem.get(position);
        holder.cityName.setText(g.getCityName());
        holder.adminName.setText(g.getAdminName());
        holder.location.setText(g.getLocation());
        holder.fromHoure.setText(g.getFromHoure());
        holder.toHoure.setText(g.getToHoure());

        if(login.s_id==null){
            holder.iconDelet.setVisibility(View.GONE);
        }

        holder.iconDelet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(con);
                alert.setTitle("تأكيد الحذف");
                alert.setMessage("هل تريد تأكيد الحذف؟");

                alert.setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Toast.makeText(line_status_list_item.this, "تم الحذف",Toast.LENGTH_SHORT).show();


                        String url = url_serverName.serverName + "deleteIcongarage.php";
                        StringRequest stringRequest2 = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Toast.makeText(con, response, Toast.LENGTH_SHORT).show();
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(con, error.getMessage() + "", Toast.LENGTH_SHORT).show();
                                error.printStackTrace();
                            }
                        }) {
                            @Override
                            protected Map<String, String> getParams() {
                                Map<String, String> params = new HashMap<>();

                                params.put("garage_name", holder.cityName.getText().toString());


                                return params;
                            }
                        };
                        my_singleton.getInstance(con).addToRequestQueue(stringRequest2);

                    }


                });
                alert.setNegativeButton("لا", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Toast.makeText(line_status_list_item.this, "تم التراجع",Toast.LENGTH_SHORT).show();
                    }
                });
                alert.create().show();
            }
        });
    }

    @Override
    public int getItemCount() {
        //how many items in my list
        return myGarageItem.size();
    }

    public class garageViewHolder extends RecyclerView.ViewHolder{
        TextView cityName, adminName, location, toHoure, fromHoure;
        TextView iconDelet;
        Spinner sour;


        public garageViewHolder(@NonNull View itemView) {
            super(itemView);
            cityName=itemView.findViewById(R.id.garageItem_cityName);
            adminName=itemView.findViewById(R.id.garageItem_adminName);
            location=itemView.findViewById(R.id.garageItem_locationValue);
            toHoure=itemView.findViewById(R.id.garageItem_toHoure);
            fromHoure=itemView.findViewById(R.id.garageItem_FromHoure);
            iconDelet=itemView.findViewById(R.id.garageItem_deleteIcon);
            sour = itemView.findViewById(R.id.homePage_source);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    home_page.getInstance().MoveFromGarageToLine(cityName.getText().toString());

                }
            });



        }
    }
}
