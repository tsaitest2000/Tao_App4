package com.lab.study.app_fragment3;

import android.app.FragmentTransaction;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

   private Context context;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      setSupportActionBar(toolbar);
      context = this;
      FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
      fab.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            // 從這裡開始撰寫 =======================================================================
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            FragLotto fragLotto = new FragLotto();

            Bundle bundle = new Bundle();
            bundle.putInt("color", Color.argb(255, new Random().nextInt(256), new Random().nextInt(256), new Random().nextInt(256)));
            fragLotto.setArguments(bundle); // Fragment帶參數的方法二

            ft.add(R.id.layout_container, fragLotto, "10"); // Fragment帶參數的方法一
            ft.addToBackStack(null);
            ft.commit();
         }
      });
   }
   // Fragment帶參數的方法一：setTag()：只能放單一資料，而且是字串String
   // Fragment帶參數的方法二：Bundle：可以放複合資料，如同菜籃

   @Override
   public boolean onCreateOptionsMenu(Menu menu) {
      getMenuInflater().inflate(R.menu.menu_main, menu);
      return true;
   }

   @Override
   public boolean onOptionsItemSelected(MenuItem item) {
      int id = item.getItemId();
      if (id == R.id.back) {
         getFragmentManager().popBackStack();
         return true;
      }
      return super.onOptionsItemSelected(item);
   }

   // 功能設計：+鈕新增, back menu item退現, back按鈕離開應用程式 → 覆寫此方法直接finish離開應用程式
   // 若不覆寫此方法，則按下back按鈕時會執行"退現" → 不符合我們的設計思維 也可以由keyCode進行判斷
   @Override
   public void onBackPressed() {
      finish();
   }

}
