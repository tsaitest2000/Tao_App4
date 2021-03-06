package com.lab.study.app_fragment2;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.math.BigDecimal;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;

public class FragStock extends Fragment {

   private TextView textView;

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
   }

   @Nullable
   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View layout = inflater.inflate(R.layout.frag_stock, container);
      textView = (TextView) layout.findViewById(R.id.textView);
      return layout;
   }

   @Override
   public void onStart() {
      super.onStart();
      new RunWork().start();
   }

   class RunWork extends Thread {

      private Stock stock;
      private BigDecimal price;

      Runnable runnable = new Runnable() {
         @Override
         public void run() {
            textView.setText(price + "");
         }
      };

      public void run() {
         try {
            stock = YahooFinance.get("^TWII");
            price = stock.getQuote().getPrice();
            getActivity().runOnUiThread(runnable); // ★★ getActivity()就會得到Activity
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
   }

}
