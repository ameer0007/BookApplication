package com.example.bookapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import Model.Constants;
import adapter.TitleAdapter;
import myinterface.TitleClickListener;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="MainActivity";
    private Context mContext;
    private ArrayList<String> titleList;
    private RecyclerView recyclerView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContext=MainActivity.this;
        titleList=new ArrayList<>();
        titleList.add(Constants.TITLEA);
        titleList.add(Constants.TITLEB);
        titleList.add(Constants.TITLEC);
        titleList.add(Constants.TITLED);
        titleList.add(Constants.TITLEE);

        recyclerView =findViewById(R.id.recycle_view1);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager=new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false);
recyclerView.setLayoutManager(layoutManager);
        TitleAdapter titleAdapter= new TitleAdapter(mContext, titleList, new TitleClickListener() {
            @Override
            public void onItemClick(View itemview, int position) {
              //  Toast.makeText(mContext,"Title clicker Position"+position,Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("titles",titleList.get(position));
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(titleAdapter);
    }
}
