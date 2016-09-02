package com.valdioveliu.valdio.mobileadsexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Valdio Veliu on 16-08-30.
 */
public class NativeFragment extends Fragment {

    public NativeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_native, container, false);
        //toolbar icon
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.nativeToolbar);
        toolbar.setNavigationIcon(android.R.drawable.ic_delete);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .remove(NativeFragment.this)
                        .commit();
            }
        });
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initRecyclerView();
    }

    private void initRecyclerView() {
        //Create dummy data for RecyclerView
        int listSize = 50;
        int ITEM = 0;
        int NATIVE_AD = 1;
        List<Data> data = new ArrayList<>();
        int[] viewTypes = new int[listSize];
        for (int i = 0; i < listSize; i++) {
            data.add(new Data());
            //insert native ads once in five items
            if (i > 1 && i % 5 == 0) {
                viewTypes[i] = NATIVE_AD;
            } else {
                viewTypes[i] = ITEM;
            }
        }
        RecyclerView recyclerView = (RecyclerView) getActivity().findViewById(R.id.recyclerview);
        RV_Adapter adapter = new RV_Adapter(data, viewTypes);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


}
