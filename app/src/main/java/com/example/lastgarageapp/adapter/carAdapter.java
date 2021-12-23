package com.example.lastgarageapp.adapter;


import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
import com.example.lastgarageapp.itemClasses.carItem;
import com.example.lastgarageapp.my_singleton;
import com.example.lastgarageapp.url_serverName;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class carAdapter extends RecyclerView.Adapter<carAdapter.carViewHolder> {
    ArrayList<carItem> myCarItem;
    Context con;

    public carAdapter(Context context, ArrayList<carItem> myCarItem) {
        this.myCarItem = myCarItem;
        this.con = context;
    }

    @NonNull
    @Override
    public carViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_car_status_list_item, parent, false);
        carViewHolder holder = new carViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull carViewHolder holder, int position) {
        carItem c = myCarItem.get(position);
        holder.carNumber.setText(c.getCarNumber());
        holder.nameDriver.setText(c.getDriverName());

        if(c.getAvailability().equals("0")){
            holder.availability.setText("غير متاحة");
            holder.arrivalLayout.setVisibility(View.VISIBLE);
        }else if(c.getAvailability().equals("1")){
            holder.availability.setText("متاحة");
            holder.arrivalLayout.setVisibility(View.GONE);
        }

        holder.noOfPassenger.setText(c.getNoOfPassenger());
        holder.capacity.setText(c.getCapacity());
        holder.arrivalTime.setText(c.getArrivalTime());

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


                        String url = url_serverName.serverName + "deleteIconcar.php";
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

                                params.put("car_id", holder.carNumber.getText().toString());


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
        return myCarItem.size();
    }

    public class carViewHolder extends RecyclerView.ViewHolder {
        TextView carNumber,nameDriver, availability, noOfPassenger, capacity, arrivalTime;
        TextView iconDelet;
        LinearLayout arrivalLayout;

        public carViewHolder(@NonNull View itemView) {
            super(itemView);
            carNumber=itemView.findViewById(R.id.carItem_carNumber);
            nameDriver = itemView.findViewById(R.id.carItem_driverName);
            availability = itemView.findViewById(R.id.carItem_availabilty);
            noOfPassenger = itemView.findViewById(R.id.carItem_noOfPassenger);
            capacity = itemView.findViewById(R.id.carItem_capacity);
            arrivalTime = itemView.findViewById(R.id.carItem_arrivalTime);
            iconDelet = itemView.findViewById(R.id.carItem_deleteIcon);
            arrivalLayout = itemView.findViewById(R.id.carItem_arrivalLayout);


        }

    }
}