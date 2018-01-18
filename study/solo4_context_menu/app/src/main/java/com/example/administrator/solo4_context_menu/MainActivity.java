package com.example.administrator.solo4_context_menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout baseLayout;
    private Button       btn1      ;
    private Button       btn2      ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Context_Menu");

        baseLayout = findViewById(R.id.baseLayout);
        btn1       = findViewById(R.id.btn1);
        registerForContextMenu(btn1);
        btn2       = findViewById(R.id.btn2);
        registerForContextMenu(btn2);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater mInflater = getMenuInflater();

        if (v == btn1){
            menu.setHeaderTitle("Background_Color_Change");

            mInflater.inflate(R.menu.menu1,menu);
        }
        if (v == btn2){
            mInflater.inflate(R.menu.menu2,menu);
        }
    }
}
