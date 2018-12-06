package com.example.jing.litepal;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.WorkerThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;
import org.litepal.exceptions.DataSupportException;
import org.litepal.tablemanager.Connector;

import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;

public class MainActivity extends AppCompatActivity {
    private static final String TAG="MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ThreadPoolExecutor executor=new ScheduledThreadPoolExecutor(4);
        executor.shutdownNow();

        Button button=findViewById(R.id.create_database);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Connector.getDatabase();
                SQLiteDatabase sqLiteDatabase=LitePal.getDatabase();
            }
        });

        Button button1=findViewById(R.id.add_book);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book=new Book("laoshe",20,1000,"dahai","beiyou");

                book.save();
            }
        });

        Button updateButton=findViewById(R.id.update_book);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book=new Book("laoshe",20,1000,"dahai","beiyou");
                book.save();
                book.setAuthor("lushu");
                book.save();
            }
        });
        Button updateButton2=findViewById(R.id.update_book2);
        updateButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book=new Book();
                book.setPrice(99);
                book.setPress("nanjing");
                book.setToDefault("page");
                book.updateAll("author = ?","laoshe");
            }
        });
        Button deleteButton=findViewById(R.id.delete_book);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.deleteAll(Book.class,"price<?","99");
            }
        });

        Button queryButton=findViewById(R.id.query_book);
        queryButton.setOnClickListener((v)->{
                List<Book> books=LitePal.select("author","press").where("page>?","0")
                        .order("page").limit(2).find(Book.class);
                for (Book book:books){
                    Log.d(TAG, "onClick: "+book+"---"+book.getAuthor()+book.getPress()+book.getName());
                }
                LitePal.findBySQL();
        });
//        queryButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                List<Book> books=LitePal.select("author","press").where("page>?","0")
//                        .order("page").limit(2).find(Book.class);
//                for (Book book:books){
//                    Log.d(TAG, "onClick: "+book+"---"+book.getAuthor()+book.getPress()+book.getName());
//                }
//                LitePal.findBySQL();
//            }
//        });
    }
}
