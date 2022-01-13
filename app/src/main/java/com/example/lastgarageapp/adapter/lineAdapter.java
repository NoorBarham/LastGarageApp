package com.example.lastgarageapp.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.example.lastgarageapp.add_driver;
import com.example.lastgarageapp.edit_line;
import com.example.lastgarageapp.home_page;
import com.example.lastgarageapp.itemClasses.lineItem;
import com.example.lastgarageapp.line_status_list_item;
import com.example.lastgarageapp.login;
import com.example.lastgarageapp.my_singleton;
import com.example.lastgarageapp.url_serverName;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class lineAdapter extends RecyclerView.Adapter<lineAdapter.lineViewHolder> {
    private ArrayList<lineItem> myLineItem;
    Context con;



    public lineAdapter(Context context, ArrayList<lineItem> myLineItem) {
        this.myLineItem = myLineItem;
        this.con = context;

    }

    @NonNull
    @Override
    public lineAdapter.lineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_line_status_list_item, parent, false);
        lineAdapter.lineViewHolder holder = new lineAdapter.lineViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(lineAdapter.lineViewHolder holder, int position) {
        lineItem l = myLineItem.get(position);
        holder.lineFare.setText(l.getLineFare());
        holder.noOfCars.setText(l.getNoOfCar());
        holder.garage1.setText(l.getGarage1());
        holder.garage2.setText(l.getGarage2());

        if(login.s_id!=null){

            String url = url_serverName.serverName + "isAdminOrDriver.php";
            StringRequest myStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject object = new JSONObject(response);
                        JSONArray jsonArray = object.getJSONArray("A_D");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject reader = jsonArray.getJSONObject(i);
                            String check = reader.getString("check");
                            if(check.equals("d")){
                              holder.iconDelete.setVisibility(View.GONE);
                            }else{

                            }

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(con, error.getMessage() + "", Toast.LENGTH_SHORT).show();
                    error.printStackTrace();
                }
            }){
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> myMap = new HashMap<>();
                    myMap.put("s_id", login.s_id);
                    return myMap;
                }
            };
            my_singleton.getInstance(con).addToRequestQueue(myStringRequest);
        }
        else{
            holder.iconDelete.setVisibility(View.GONE);
        }

        holder.iconDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(con);
                alert.setTitle("تأكيد الحذف");
                alert.setMessage("هل تريد تأكيد الحذف؟");

                alert.setPositiveButton("نعم", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                       // Toast.makeText(line_status_list_item.this, "تم الحذف",Toast.LENGTH_SHORT).show();


                            String url = url_serverName.serverName + "deleteIconline.php";
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

                                    params.put("garage1", holder.garage1.getText().toString());
                                    params.put("garage2", holder.garage2.getText().toString());


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
     return myLineItem.size();
    }


    public class lineViewHolder extends RecyclerView.ViewHolder {
        TextView lineFare, noOfCars, garage1,garage2;
        TextView iconDelete;


        public lineViewHolder(@NonNull View itemView) {
            super(itemView);
            lineFare = itemView.findViewById(R.id.lineItem_lineFare);
            noOfCars = itemView.findViewById(R.id.lineItem_noOfCar);
            garage1= itemView.findViewById(R.id.lineItem_garage1);
            garage2= itemView.findViewById(R.id.lineItem_garage2);
            iconDelete = itemView.findViewById(R.id.lineItem_deleteIcon);



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                 //   Toast.makeText(con, garageAdapter.sourcenotequalgarage1 + "", Toast.LENGTH_SHORT).show();

                //    if(garage1.getText().toString().compareTo(garageAdapter.sourcenotequalgarage1)==0) {

                        home_page.getInstance().MoveFromLineToCar(garage1.getText().toString(), garage2.getText().toString());
                 //   }

                  // else{
                      home_page.getInstance().MoveFromLineToCar(garage2.getText().toString(), garage1.getText().toString());
                 //  }

                }
            });



        }

    }




}
