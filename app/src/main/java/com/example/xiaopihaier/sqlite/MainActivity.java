package com.example.xiaopihaier.sqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //定义增删改查四个按钮
    Button add,delete,modify,query;

    //定义四个输入框按钮
    EditText add_edi,delete_edi,modify_edi,query_edi;

    //定义结果显示控件
    TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentView();
    }

    private void IntentView() {

        //增加输入框
        add_edi= (EditText) findViewById(R.id.add_edi);

        //增加按钮监听事件
        add= (Button) findViewById(R.id.add);
        add.setOnClickListener(this);

        //删除输入框
        delete_edi= (EditText) findViewById(R.id.add_edi);

        //删除按钮监听事件
        delete= (Button) findViewById(R.id.delete);
        delete.setOnClickListener(this);

        //修改输入框
        modify_edi= (EditText) findViewById(R.id.modify_edi);

        //修改按钮监听事件
        modify= (Button) findViewById(R.id.modify);
        modify.setOnClickListener(this);

        //查询输入框
        query_edi= (EditText) findViewById(R.id.query_edi);

        //查询按钮监听事件
        query= (Button) findViewById(R.id.query);
        query.setOnClickListener(this);

        //结果显示
        Result= (TextView) findViewById(R.id.Result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //点击增加按钮
            case R.id.add:
                //执行添加数据操作

                break;

            //点击删除按钮
            case R.id.delete:
                //执行删除数据操作

                break;

            //点击修改按钮
            case R.id.modify:
                //执行修改数据操作

                break;

            //点击查询按钮
            case R.id.query:
                //执行查询数据的操作

                break;
        }
    }
}
