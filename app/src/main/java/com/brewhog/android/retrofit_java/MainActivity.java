package com.brewhog.android.retrofit_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.brewhog.android.retrofit_java.adapters.AnekdotAdapter;
import com.brewhog.android.retrofit_java.pojo.Anekdot;
import com.brewhog.android.retrofit_java.viewmodel.AnekdotsViewModel;
import com.brewhog.android.retrofit_java.viewmodel.ViewModelFactory;
import com.brewhog.android.retrofit_java.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Anekdot> mAnekdots = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AnekdotAdapter adapter = new AnekdotAdapter(mAnekdots);
        ViewModelFactory factory = new ViewModelFactory(adapter);
        AnekdotsViewModel viewModel = new ViewModelProvider(this,factory).get(AnekdotsViewModel.class);

        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainBinding.setViewModel(viewModel);
    }
}
