package com.example.knoxpo.myexamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

public class AddNewItemActivity extends SingleFragmentActivity implements AddNewItemFragment.Callback,ToDoListFragment.CallBackInterface{

    String check;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String aB = getIntent().getStringExtra("updateTitle");



        Toast.makeText(this, ""+aB, Toast.LENGTH_SHORT).show();

        if(aB == null)
        {
            getSupportActionBar().setTitle("Edit Item");
        }
        else
            getSupportActionBar().setTitle("Add Item");

    }

    @Override
    protected Fragment getFragment() {



        String updateTitle = getIntent().getStringExtra("updateTitle");
        boolean check = getIntent().getBooleanExtra("updateCheck",false);
        int pos = getIntent().getIntExtra("position",0);
        return AddNewItemFragment.newInstance(updateTitle,check,pos);

    }


    @Override
    public void onSaveForDelete(int position) {

        Intent intent=new Intent(AddNewItemActivity.this,ToDoListActivity.class);
        intent.putExtra("position",position);
        startActivity(intent);
    }

    @Override
    public void onSave(String title, boolean isCheck,int position) {

        Intent intent=new Intent();
        intent.putExtra("title",title);
        intent.putExtra("check",isCheck);
        intent.putExtra("updatePosition",position);
        setResult(RESULT_OK,intent);
        finish();

    }

    @Override
    public void onPassData(String himanshu) {

     check = himanshu;
    }
}
