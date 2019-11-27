package polinema.ac.id.dtsapp.data;

import android.arch.persistence.room.RoomDatabase;

public interface DatabaseTaskEventListener {
    Object runDatabaseOperation(RoomDatabase database, Object... params);
    void onDatabaseOperationFinished(Object... results);
}
