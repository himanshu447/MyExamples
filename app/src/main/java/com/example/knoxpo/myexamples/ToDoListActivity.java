package com.example.knoxpo.myexamples;

import android.support.v4.app.Fragment;

public class ToDoListActivity extends SingleFragmentActivity  {


    @Override
    protected Fragment getFragment() {

        int pos =getIntent().getIntExtra("position",0);

        return ToDoListFragment.newInstance(pos);

    }


}
