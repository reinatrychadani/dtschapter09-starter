package polinema.ac.id.dtsapp.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class DTSAppDatabase extends RoomDatabase
{
    public abstract UserDao userDao();
}
