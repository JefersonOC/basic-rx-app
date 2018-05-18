package io.github.blackfishlabs.basicrx.persistence.datasource;

import io.github.blackfishlabs.basicrx.persistence.UserEntity;
import io.reactivex.Flowable;

public interface UserDataSource {

    Flowable<UserEntity> getUser();

    void insertOrUpdateUser(UserEntity user);

    void deleteAllUsers();
}
