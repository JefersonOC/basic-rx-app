package io.github.blackfishlabs.basicrx.vm;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import io.github.blackfishlabs.basicrx.persistence.datasource.UserDataSource;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private final UserDataSource mDataSource;

    public ViewModelFactory(UserDataSource dataSource) {
        mDataSource = dataSource;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(UserViewModel.class)) {
            return (T) new UserViewModel(mDataSource);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
