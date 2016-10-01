package com.lab.study.app_fragment2;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class FragChart extends Fragment {

   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
   }

   @Nullable
   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      View layout = inflater.inflate(R.layout.frag_chart, container);
      ImageView imageView = (ImageView) layout.findViewById(R.id.imageView);
      Picasso.with(getActivity()).load("https://tw.quote.finance.yahoo.net/quote/charts/%23001.gif").into(imageView);
      return layout;
   }

}