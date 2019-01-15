package programing.team.oskarkufel.pl.studenttools.Notatnik.ROOM;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface NoteWordDAO {

    @Insert
    public void insert(NoteWord noteWord);


    @Query("SELECT row_id FROM note_table WHERE :tytul")
    public int getID (String tytul);


    @Query("DELETE FROM note_table")
    public void deleteAll();

    @Query("SELECT * from note_table ORDER BY title_note ASC")
    public LiveData<List<NoteWord>> getAllNote();







}
