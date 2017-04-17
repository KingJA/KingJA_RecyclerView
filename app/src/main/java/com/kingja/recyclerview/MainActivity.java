package com.kingja.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Data> datas = new ArrayList<>();
    private int[] imgarr = {R.mipmap.image_mycar, R.mipmap.image_mycare, R.mipmap.image_myhouse,
            R.mipmap.image_myintermediary, R.mipmap.image_myrental};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < imgarr.length; i++) {
            datas.add(new Data("Item" + i, imgarr[i]));
        }

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);
        final MoveableAdapter adapter = new MoveableAdapter(this, datas);
//        final NormalAdapter adapter = new NormalAdapter(this, datas);

        adapter.setOnItemClickListener(new BaseRvAdaper.OnItemClickListener<Data>() {
            @Override
            public void onItemClick(Data data, int position) {
                Toast.makeText(MainActivity.this, "Item: " + position, Toast.LENGTH_SHORT).show();
            }
        });

//        //用外观模式来包装
        new RecyclerViewHelper.Builder(this)
                .setCallbackAdapter(adapter)
                .setLayoutStyle(LayoutHelper.LayoutStyle.VERTICAL_LIST)
                .setDividerHeight(1)
                .setSwipeable(true)
                .setDragable(true)
                .setDividerColor(0xff00ff00)
                .build()
                .attachToRecyclerView(rv);
    }
}
