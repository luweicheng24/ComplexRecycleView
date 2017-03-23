package com.gsww.www.complexrecycleview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecycleView;
    private List<OneTypeBean> oneList;
    private List<TwoTypeBean> twoeList;
    private MyAdapter adapter;
    private Toolbar mToolBar;
    private int[] images_1 = {R.drawable.food_1, R.drawable.food_2, R.drawable.food_3,
            R.drawable.food_4, R.drawable.food_5, R.drawable.food_6,};

    private int[] images_2 = {R.drawable.girl_3, R.drawable.girl_4, R.drawable.girl_5,
            R.drawable.girl_8, R.drawable.girl_7, R.drawable.girl_6,
            R.drawable.girl_2, R.drawable.girl_1, R.drawable.girl_9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        initData();
    }

    private void initData() {

        adapter = new MyAdapter(this, oneList, twoeList);oneList = new ArrayList<>();
        twoeList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            oneList.add(new OneTypeBean("中华美食", images_1[i % 6], "独特的西北特色"));
        }
        for (int i = 0; i < 9; i++) {
            twoeList.add(new TwoTypeBean("[ 女人装 ]", images_2[i % 9]));
        }
        GridLayoutManager gm = new GridLayoutManager(this, 2);
        gm.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                 switch(adapter.getItemViewType(position)){
                     case 1:

                         return 2;
                     case 2:

                         return 1;
                 }
                return 0;
            }
        });
        mRecycleView.setLayoutManager(gm);
        mRecycleView.setAdapter(adapter);
    }

    private void initView() {
        mRecycleView = (RecyclerView) findViewById(R.id.mRecycleView);
        mToolBar = (Toolbar)findViewById(R.id.mToolBar);
        setSupportActionBar(mToolBar);

    }

    /**
     * toolbar返回图标监听
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
