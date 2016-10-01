package com.lab.study.app_fragment4;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ChartFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_chart, null);
        ImageView imageView = (ImageView) layout.findViewById(R.id.imageView);
        Picasso.with(getActivity()).load("https://tw.quote.finance.yahoo.net/quote/charts/%23001.gif").into(imageView);
        return layout;

    }

}