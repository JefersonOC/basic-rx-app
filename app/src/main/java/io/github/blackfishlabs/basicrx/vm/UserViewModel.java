package io.github.blackfishlabs.basicrx.vm;

import android.arch.lifecycle.ViewModel;

import io.github.blackfishlabs.basicrx.persistence.UserEntity;
import io.github.blackfishlabs.basicrx.persistence.datasource.UserDataSource;
import io.reactivex.Completable;
import io.reactivex.Flowable;

public class UserViewModel extends ViewModel {

    private final UserDataSource mDataSource;

    private UserEntity mUser;

    public UserViewModel(UserDataSource dataSource) {
        mDataSource = dataSource;
    }


    public Flowable<String> getUserName() {
        return mDataSource.getUser()
                .map(user -> {
                    mUser = user;
                    return user.getUserName();
                });

    }

    public Completable updateUserName(final String userName) {
        return Completable.fromAction(() -> {
            mUser = mUser == null
                    ? new UserEntity(userName)
                    : new UserEntity(mUser.getId(), userName);

            mDataSource.insertOrUpdateUser(mUser);
        });
    }
}
