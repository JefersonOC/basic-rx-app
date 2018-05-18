package io.github.blackfishlabs.basicrx.persistence.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import io.github.blackfishlabs.basicrx.persistence.UserDao;
import io.github.blackfishlabs.basicrx.persistence.UserEntity;

@Database(entities = {UserEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;

    public abstract UserDao userDao();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "sample_rx_app.db")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
