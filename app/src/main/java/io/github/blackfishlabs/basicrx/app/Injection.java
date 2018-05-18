package io.github.blackfishlabs.basicrx.app;

import android.content.Context;

import io.github.blackfishlabs.basicrx.persistence.LocalUserDataSource;
import io.github.blackfishlabs.basicrx.persistence.database.AppDatabase;
import io.github.blackfishlabs.basicrx.persistence.datasource.UserDataSource;
import io.github.blackfishlabs.basicrx.vm.ViewModelFactory;

public class Injection {

    public static UserDataSource provideUserDataSource(Context context) {
        AppDatabase database = AppDatabase.getInstance(context);
        return new LocalUserDataSource(database.userDao());
    }

    public static ViewModelFactory provideViewModelFactory(Context context) {
        UserDataSource dataSource = provideUserDataSource(context);
        return new ViewModelFactory(dataSource);
    }
}