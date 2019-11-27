package polinema.ac.id.dtsapp.data;

import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;

import java.lang.ref.WeakReference;

public class DatabaseTask extends AsyncTask<Object, Void, Void> {

    //Room database butuh Context
    private WeakReference<Context> databaseContex; //Dimasukkan WeakReference<> untuk Mencegah kebocoran memory

    //Activity yang ingin menjalankan operasi database di background secara asynchronous
    private DatabaseTaskEventListener eventListener;

    //Hasil dari operasi yang selesai dilakukan
    private Object operationResult;

    public DatabaseTask(Context databaseContext, DatabaseTaskEventListener eventListener)
    {
        this.databaseContex = new WeakReference<>(databaseContext);
        this.eventListener = eventListener;
    }

    //operasi yang dijalankan di background secara Asynchronous
    @Override
    protected Void doInBackground(Object... objects) {
        // Mendapatkan instance database asynchronous dari AppDbProvider
        RoomDatabase database = AppDbProvider.getAsynchronousInstance(this.databaseContex.get());

        // Melemparkan instance database tadi ke event listener untuk diambil DAO-nya nanti
        this.operationResult = this.eventListener.runDatabaseOperation(database, objects);

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid){
        super.onPostExecute(aVoid);

        // Memberitahukan ke event listener bahwasanya operasi yang dilakukan di-background telah selesai
        this.eventListener.onDatabaseOperationFinished(this.operationResult);
    }
}
