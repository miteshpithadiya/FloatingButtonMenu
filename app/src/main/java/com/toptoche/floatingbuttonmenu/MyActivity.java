package com.toptoche.floatingbuttonmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.toptoche.mymodule.floatingmenulib.FloatingButtonMenu;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        FloatingButtonMenu floatingButtonMenu = (FloatingButtonMenu) findViewById(R.id.floatingMenu);

        floatingButtonMenu.addButton(android.R.drawable.ic_menu_gallery, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyActivity.this, "Gallery Selected", Toast.LENGTH_SHORT).show();
            }
        });

        floatingButtonMenu.addButton(android.R.drawable.ic_menu_camera, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MyActivity.this, "Camera Selected", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
