package com.android.aravindhsenthil.stackup.UI;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.android.aravindhsenthil.stackup.Core.ListBean;
import com.android.aravindhsenthil.stackup.Core.OnClickInterface;
import com.android.aravindhsenthil.stackup.Core.RecyclerViewAdapter;
import com.android.aravindhsenthil.stackup.R;

import java.util.ArrayList;

public class StackUPLauncherActivity extends AppCompatActivity implements OnClickInterface {
    private RecyclerView mRecyclerView;
    private ArrayList<ListBean> mListBean = new ArrayList<>();
    private ListBean bean;
    private RecyclerViewAdapter mRecyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        mRecyclerViewAdapter = new RecyclerViewAdapter(mListBean, this);
        mRecyclerView = (RecyclerView) findViewById(R.id.rcview);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        prepareList();
    }

    private void prepareList() {
        bean = new ListBean();
        bean.setmName("Aravindh");
        bean.setmTitle("Good boy");
        mListBean.add(bean);

        bean = new ListBean();
        bean.setmName("Sachin");
        bean.setmTitle("Fraud");
        mListBean.add(bean);
        mRecyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onRestoreInstanceState(savedInstanceState, persistentState);
    }

    @Override
    public void Click(int position, View view) {
        Toast.makeText(getApplicationContext(), "position" + position, Toast.LENGTH_LONG).show();
    }
}
