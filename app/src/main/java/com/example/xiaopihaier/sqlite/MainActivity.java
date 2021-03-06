package com.example.xiaopihaier.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //定义增删改查四个按钮
    Button add,delete,modify,query;

    //定义四个输入框按钮
    EditText add_edi,delete_edi,modify_edi,query_edi;

    //创建数据库
    mySQLhelper dbHelper;

    //数据列表
    ListView Result_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper=new mySQLhelper(this,"SQL.db",null,1);


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

        //数据显示
        Result_list= (ListView) findViewById(R.id.Result_list);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //点击增加按钮
            case R.id.add:
                //创建一个可写数据库,并执行添加数据操作
                SQLiteDatabase db_add=dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();
                //组装数据
                values.put("info",add_edi.getText().toString().trim());
                //插入数据到表中
                db_add.insert("table_name",null,values);
                //关闭数据库
                db_add.close();
                break;

            //点击删除按钮
            case R.id.delete:
                //创建一个可写数据库,并执行删除数据操作
                SQLiteDatabase db_delete=dbHelper.getWritableDatabase();
                //删除数据
                db_delete.delete("info","id=?",new String[]{"12"});
                //关闭数据库
                db_delete.close();
                break;

            //点击修改按钮
            case R.id.modify:
                //创建一个可写数据库,并执行修改数据操作
                SQLiteDatabase db_modify=dbHelper.getWritableDatabase();
                //修改数据
                //db_mo
                break;

            //点击查询按钮
            case R.id.query:
                //创建一个可读数据库,并执行查询数据的操作
                SQLiteDatabase db_query=dbHelper.getReadableDatabase();
                //查询info表所有数据
                Cursor cursor=db_query.query("table_name",null,null,null,null,null,null);
                if (cursor.moveToFirst()) {
                    do {
                        //遍历cursor对象,取出数据并显示
                        String id=cursor.getString(cursor.getColumnIndex("id"));
                        String info=cursor.getString(cursor.getColumnIndex("info"));
                    }while (cursor.moveToNext());
                }
                cursor.close();
                break;
        }
    }
}
