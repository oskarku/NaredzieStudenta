package programing.team.oskarkufel.pl.studenttools.Notatnik;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import programing.team.oskarkufel.pl.studenttools.Notatnik.ROOM.NoteWord;
import programing.team.oskarkufel.pl.studenttools.R;

public class NoteActivity extends AppCompatActivity {
    private NoteViewModel mNoteViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        setTitle("StudentTool Notatnik");



            FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.flooating_action_button_add_note);
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(NoteActivity.this, AddNoteActivity.class);
                    startActivityForResult(intent, NEW_WORD_ACTIVITY_REQUEST_CODE);;
                }
            });

            RecyclerView recyclerView = findViewById(R.id.recycrel_view);
            final NoteListAdapter adapter = new NoteListAdapter(this);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));






        mNoteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        mNoteViewModel.getAllWords().observe(this, new Observer<List<NoteWord>>() {
            @Override
            public void onChanged(@Nullable final List<NoteWord> words) {
                // Update the cached copy of the words in the adapter.
                adapter.setWords(words);
            }
        });




    }



    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_WORD_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            NoteWord noteWord = new NoteWord(data.getStringExtra(AddNoteActivity.EXTRA_REPLY_TITLE),data.getStringExtra(AddNoteActivity.EXTRA_REPLY_NOTE));
            mNoteViewModel.insert(noteWord);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "Nie zapisałem notatki",
                    Toast.LENGTH_LONG).show();
        }
    }


    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
}
