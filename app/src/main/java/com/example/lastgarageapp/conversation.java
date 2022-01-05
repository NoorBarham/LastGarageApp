package com.example.lastgarageapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.lastgarageapp.adapter.messageAdapter;
import com.example.lastgarageapp.itemClasses.messageItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class conversation extends AppCompatActivity {

    private ArrayList<messageItem> chatArray = new ArrayList<>();
    public static String chat_id=null;
    public static String static_receiver_name ="";
    ImageView send_icon, backIcon;
    TextView addMessage, receiverName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        receiverName =findViewById(R.id.conversation_receiverName);
        addMessage =findViewById(R.id.conversation_addText);
        send_icon = findViewById(R.id.conversation_send_icon);
        backIcon =findViewById(R.id.conversation_backIcon);
        RecyclerView myRecyclerView = findViewById(R.id.converRecyView);

        myRecyclerView.setLayoutManager(new LinearLayoutManager(conversation.this));
        receiverName.setText(conversation.static_receiver_name);

        backIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        send_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_message();
            }
        });
    }
    private void add_message(){
        String message_text=addMessage.getText().toString();
        if (addMessage.getText().length() == 0) {
            Toast.makeText(getBaseContext(), "لا يمكنك إرسال رسالة فارغة", Toast.LENGTH_SHORT).show();
        } else {
            String url = url_serverName.serverName + "addMessage.php";
            StringRequest myStringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getBaseContext(), error.getMessage() + "", Toast.LENGTH_SHORT).show();
                    error.printStackTrace();
                }
            }) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> myMap = new HashMap<>();
                    myMap.put("receiver_name", conversation.static_receiver_name);
                    myMap.put("chat_id", conversation.chat_id);
                    myMap.put("message_text", message_text);
                    myMap.put("s_id", login.s_id);
                    return myMap;
                }
            };
            my_singleton.getInstance(conversation.this).addToRequestQueue(myStringRequest);
        }
        addMessage.setText("");
    }
}