package programing.team.oskarkufel.pl.studenttools.Notatnik.ROOM;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;


@Database(entities = {NoteWord.class}, version = 1)
public abstract class NoteRoomDatabase extends RoomDatabase {
    public abstract NoteWordDAO noteDao();

    private static volatile NoteRoomDatabase INSTANCE;

    static NoteRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (NoteRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            NoteRoomDatabase.class, "note_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }



}
