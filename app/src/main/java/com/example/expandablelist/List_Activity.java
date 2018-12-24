package com.example.expandablelist;


import android.annotation.SuppressLint;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.expandablelist.bean.TypeBean;
import com.example.expandablelist.holder.TypeHolder;
import com.yu.bundles.extended.recyclerview.ExtendedHolder;
import com.yu.bundles.extended.recyclerview.ExtendedHolderFactory;
import com.yu.bundles.extended.recyclerview.ExtendedNode;
import com.yu.bundles.extended.recyclerview.ExtendedRecyclerViewBuilder;
import com.yu.bundles.extended.recyclerview.ExtendedRecyclerViewHelper;

import java.util.ArrayList;
import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.Toast;

public class List_Activity extends android.support.v4.app.Fragment {
    private ArrayList<ExtendedNode> roots = new ArrayList<>();
    private SwipeRefreshLayout swipeRefresh;

    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_list_,container,false);
        swipeRefresh=(SwipeRefreshLayout)view.findViewById(R.id.listActivity_swipe_refresh);
        swipeRefresh.setColorSchemeColors(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });
        //--------------------------------------------------------------------------------------------------//
        final ArrayList<ExtendedNode> initList = getInitData();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        final ExtendedRecyclerViewHelper extendedRecyclerViewHelper = ExtendedRecyclerViewBuilder.build(recyclerView)
                .init(initList, new ExtendedHolderFactory() {
                    @Override
                    public ExtendedHolder getHolder(ExtendedRecyclerViewHelper helper, ViewGroup parent, int viewType) {
                        if(viewType!=-1) {
                            View viewview=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_holder, parent, false);
                            final TypeHolder holder=new TypeHolder(helper, viewview);
                            return holder;
                        }
                        return null;
                    }
                })
                .setEnableExtended(true)
                .complete();
        return view;
    }
    //------------------------------------------------------------------------------------------
    private ArrayList<ExtendedNode> getInitData(){
        roots.add(new ExtendedNode<>(new TypeBean(0,1), false));
        ArrayList<ExtendedNode> sons = roots.get(0).addSons(getTypeNodes(1,2)).getSons();
        sons = sons.get(0).addSons(getTypeNodes(1,3)).getSons();
        sons = sons.get(0).addSons(getTypeNodes(1,4)).getSons();
        sons.get(0).addSons(getTypeNodes(1,5));

        roots.add(new ExtendedNode<>(new TypeBean(1,1), false));
        sons = roots.get(1).addSons(getTypeNodes(2,2)).getSons();
        sons.get(0).addSons(getTypeNodes(1,3));
        sons.get(1).addSons(getTypeNodes(2,3));

        roots.add(new ExtendedNode<>(new TypeBean(2,1), false));
        sons = roots.get(2).addSons(getTypeNodes(3,2)).getSons();
        sons.get(1).addSons(getTypeNodes(3,3));

        roots.add(new ExtendedNode<>(new TypeBean(3,1), false));
        sons = roots.get(3).addSons(getTypeNodes(4,2)).getSons();
        sons.get(1).addSons(getTypeNodes(3,3));
        sons.get(3).addSons(getTypeNodes(3,3));
        sons = sons.get(0).addSons(getTypeNodes(1,3)).getSons();
        sons.get(0).addSons(getTypeNodes(2,4));

        return roots;
    }
    /*
    private ArrayList<ExtendedNode> getType2Nodes(int count){
        ArrayList<ExtendedNode> list = new ArrayList<>();
        for (int i=0; i<count; i++){
            list.add(new ExtendedNode<>(new Type2Bean(i), true));
        }
        return list;
    }

    private ArrayList<ExtendedNode> getType3Nodes(int count){
        ArrayList<ExtendedNode> list = new ArrayList<>();
        for (int i=0; i<count; i++){
            list.add(new ExtendedNode<>(new Type3Bean(i), true));
        }
        return list;
    }

    private ArrayList<ExtendedNode> getType4Nodes(int count){
        ArrayList<ExtendedNode> list = new ArrayList<>();
        for (int i=0; i<count; i++){
            list.add(new ExtendedNode<>(new Type4Bean(i), true));
        }
        return list;
    }*/
    private ArrayList<ExtendedNode> getTypeNodes(int count,int leibie){
        ArrayList<ExtendedNode> list = new ArrayList<>();
        for (int i=0; i<count; i++){
            list.add(new ExtendedNode<>(new TypeBean(i,leibie), true));
        }
        return list;
    }

}
