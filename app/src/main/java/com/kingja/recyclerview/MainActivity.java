package com.kingja.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Data> datas = new ArrayList<>();
    private int[] imgarr={R.mipmap.image_mycar,R.mipmap.image_mycare,R.mipmap.image_myhouse,
            R.mipmap.image_myintermediary,R.mipmap.image_myrental,R.mipmap.image_mystore};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < imgarr.length; i++) {
            datas.add(new Data("Item"+i,imgarr[i]));
        }

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        final MoveableAdapter adapter = new MoveableAdapter(this, datas);
        rv.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseRvAdaper.OnItemClickListener<Data>() {
            @Override
            public void onItemClick(Data data, int position) {
                Toast.makeText(MainActivity.this,"Item: "+position,Toast.LENGTH_SHORT).show();
            }
        });

        //用外观模式来包装
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(adapter);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(rv);
    }
}
