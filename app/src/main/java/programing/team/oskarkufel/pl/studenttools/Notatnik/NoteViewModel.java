package programing.team.oskarkufel.pl.studenttools.Notatnik;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import programing.team.oskarkufel.pl.studenttools.Notatnik.ROOM.NoteReposetory;
import programing.team.oskarkufel.pl.studenttools.Notatnik.ROOM.NoteWord;

public class NoteViewModel extends AndroidViewModel {

    private NoteReposetory mRepository;

    private LiveData<List<NoteWord>> mAllWords;




    public NoteViewModel(@NonNull Application application) {
        super(application);

        mRepository = new NoteReposetory(application);
        mAllWords = mRepository.getAllNote();

    }



   public LiveData<List<NoteWord>> getAllWords() { return mAllWords; }

    public void insert(NoteWord noteWord) { mRepository.insert(noteWord); }
}
