package programing.team.oskarkufel.pl.studenttools.Notatnik.ROOM;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class NoteReposetory {


    private NoteWordDAO mNoteWordDao;
    private LiveData<List<NoteWord>> mAllWords;

    public NoteReposetory(Application application) {
        NoteRoomDatabase db = NoteRoomDatabase.getDatabase(application);
        mNoteWordDao =  db.noteDao();
        mAllWords = mNoteWordDao.getAllNote();
    }

    public LiveData<List<NoteWord>> getAllNote() {
        return mAllWords;
    }


    public void insert (NoteWord note) {
        new insertAsyncTask(mNoteWordDao).execute(note);
    }

    private static class insertAsyncTask extends AsyncTask<NoteWord, Void, Void> {

        private NoteWordDAO mAsyncTaskDao;

        insertAsyncTask(NoteWordDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final NoteWord... params) {
            mAsyncTaskDao.insert(params[0]);
            params[0].setId(mAsyncTaskDao.getID(params[0].getNTytul()));
            return null;
        }
    }
}
