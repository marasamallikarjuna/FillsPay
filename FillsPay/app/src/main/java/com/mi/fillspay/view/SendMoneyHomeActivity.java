package com.mi.fillspay.view;

import android.os.Bundle;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.mi.fillspay.R;
import com.mi.fillspay.adapter.CircleLayoutManager;
import com.mi.fillspay.adapter.SampleAdapter;

public class SendMoneyHomeActivity extends AppCompatActivity {

    ViewGroup root;
    RecyclerView list;

    private CircleLayoutManager layoutManager;
    private SampleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_money_main);

        root = (ViewGroup)findViewById(R.id.root);
        list = (RecyclerView)findViewById(R.id.recycler_view);

        adapter = new SampleAdapter(this);
        final int radius = (int) getResources().getDimension(R.dimen.list_radius);
        final int peek = (int) getResources().getDimension(R.dimen.list_peek);
        layoutManager = new CircleLayoutManager(this,
                CircleLayoutManager.Gravity.START,
                CircleLayoutManager.Orientation.VERTICAL,
                radius,
                peek,
                true);

        list.setLayoutManager(layoutManager);
        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }


}