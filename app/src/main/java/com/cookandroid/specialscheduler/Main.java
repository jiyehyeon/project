package com.cookandroid.specialscheduler;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;

public class Main extends AppCompatActivity {
    ImageButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.default_layout);

        btn =(ImageButton)findViewById(R.id.menuBtn);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick (View main_menu){
                PopupMenu popup = new PopupMenu(Main.this, btn);

                MenuInflater inf = popup.getMenuInflater();
                inf.inflate(R.menu.main_menu, popup.getMenu());
                popup.show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
}
