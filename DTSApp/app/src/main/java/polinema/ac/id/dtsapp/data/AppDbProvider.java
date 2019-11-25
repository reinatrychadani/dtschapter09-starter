package polinema.ac.id.dtsapp.data;

import android.arch.persistence.room.Room;
import android.content.Context;

public class AppDbProvider {

    private static DTSAppDatabase instance;

    public static DTSAppDatabase getInstance(Context context)
    {
        if(AppDbProvider.instance == null)
        {
            AppDbProvider.instance = Room.databaseBuilder(
                    context, DTSAppDatabase.class, "dtsapp.db").allowMainThreadQueries().build();
        }

        return AppDbProvider.instance;
    }
}
