package com.lab.study.app_fragment4;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

public class LottoFragment extends Fragment {
    private int number;
    private int color;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        number = Integer.parseInt(getTag());
        color = getArguments().getInt("color");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_lotto, null);
        TextView textView = (TextView) layout.findViewById(R.id.textView);
        textView.setTextColor(color);
        textView.setText(new Random().nextInt(number) + "");
        return layout;
    }
}
