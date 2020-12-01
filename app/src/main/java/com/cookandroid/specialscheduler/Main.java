package com.cookandroid.specialscheduler;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;
import java.util.Calendar;

public class Main extends Activity {
    ImageButton menuBtn;
    ImageButton settingBtn;
    View setSemesterDialog;
    int startYear, startMonth, startDay, endYear, endMonth, endDay;
    DatePicker semStartPicker, semEndPicker;
    TextView startHr, startMin, endHr, endMin;

    ArrayList<TodoList> todoList;
    ArrayList<LectureList> lectureList;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.default_layout);

        menuBtn = (ImageButton) findViewById(R.id.menuBtn);
        registerForContextMenu(menuBtn);
        settingBtn = (ImageButton) findViewById(R.id.settingBtn);
        registerForContextMenu(settingBtn);

        semStartPicker = (DatePicker) findViewById(R.id.semesterStart);
        semEndPicker = (DatePicker) findViewById(R.id.semesterEnd);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater mInflater = getMenuInflater();
        if (v == settingBtn) {
            menu.setHeaderTitle("설정");
            mInflater.inflate(R.menu.settings, menu);
        }
        if (v == menuBtn) {
            menu.setHeaderTitle("설정");
            mInflater.inflate(R.menu.main_menu, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.setSemester:
                Calendar cal = Calendar.getInstance();
                setSemesterDialog = (View) View.inflate(Main.this, R.layout.set_semester, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(Main.this);
                dlg.setTitle("학기 설정");
                dlg.setView(setSemesterDialog);
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startYear = semStartPicker.getYear();
                        startMonth = semStartPicker.getMonth();
                        startMonth = semStartPicker.getDayOfMonth();
                    }
                });
                dlg.setNegativeButton("취소", null);
                dlg.show();
                return true;
            case R.id.setTimeTable:
                return true;
        }
        return super.onContextItemSelected(item);
    }
}
