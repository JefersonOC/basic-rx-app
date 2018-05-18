package io.github.blackfishlabs.basicrx.persistence;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import io.reactivex.Flowable;

@Dao
public interface UserDao {

    @Query("SELECT * FROM Users LIMIT 1")
    Flowable<UserEntity> getUser();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertUser(UserEntity user);

    @Query("DELETE FROM Users")
    void deleteAllUsers();
}
