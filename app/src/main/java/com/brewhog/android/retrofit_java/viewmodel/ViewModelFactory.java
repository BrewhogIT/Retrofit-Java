package com.brewhog.android.retrofit_java.viewmodel;

import com.brewhog.android.retrofit_java.adapters.AnekdotAdapter;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private AnekdotAdapter mAdapter;

    public ViewModelFactory(AnekdotAdapter adapter) {
        mAdapter = adapter;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == AnekdotsViewModel.class){
            return (T) new AnekdotsViewModel(mAdapter);
        }

        return null;
    }
}
