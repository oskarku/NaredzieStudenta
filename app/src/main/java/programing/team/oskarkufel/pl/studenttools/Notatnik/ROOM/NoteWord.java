package programing.team.oskarkufel.pl.studenttools.Notatnik.ROOM;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "note_table")
public class NoteWord {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "row_id")
    private int id=0;

    @ColumnInfo(name = "title_note")
    private String nTytul;

    @ColumnInfo(name = "note")
    private String nNotatka;

    public NoteWord ( String nTytul, String nNotatka){
        this.nTytul = nTytul;
        this.nNotatka = nNotatka;


    }

    @NonNull
    public int getId() {
        return id;
    }

    public void setnTytul(String nTytul) {
        this.nTytul = nTytul;
    }

    public void setnNotatka(String nNotatka) {
        this.nNotatka = nNotatka;
    }


    public String getNTytul() {
        return nTytul;
    }

    public String getNNotatka() {
        return nNotatka;
    }

    public void setId(int idd){
        this.id=idd;
    }



}
