package io.github.blackfishlabs.basicrx.persistence;

import io.github.blackfishlabs.basicrx.persistence.datasource.UserDataSource;
import io.reactivex.Flowable;

public class LocalUserDataSource implements UserDataSource {

    private final UserDao mUserDao;

    public LocalUserDataSource(UserDao userDao) {
        mUserDao = userDao;
    }

    @Override
    public Flowable<UserEntity> getUser() {
        return mUserDao.getUser();
    }

    @Override
    public void insertOrUpdateUser(UserEntity user) {
        mUserDao.insertUser(user);
    }

    @Override
    public void deleteAllUsers() {
        mUserDao.deleteAllUsers();
    }
}
