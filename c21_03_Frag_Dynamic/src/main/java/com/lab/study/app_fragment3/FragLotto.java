package com.lab.study.app_fragment3;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

public class FragLotto extends Fragment {

   private int mIntNumber;
   private int mIntColor;

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      mIntNumber = Integer.parseInt(getTag()); // 取得由MainActivity中新增FragLotto時傳入的tag值
      mIntColor = getArguments().getInt("color");
   }

   @Nullable
   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View layout = inflater.inflate(R.layout.frag_lotto, null); // ★★★★ 參數二必須是null
      TextView textView = (TextView) layout.findViewById(R.id.textView);
      textView.setTextColor(mIntColor);
      textView.setText(new Random().nextInt(mIntNumber) + "");
      return layout;
   }

}
