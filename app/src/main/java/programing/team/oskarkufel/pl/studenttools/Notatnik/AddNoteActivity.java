package programing.team.oskarkufel.pl.studenttools.Notatnik;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import programing.team.oskarkufel.pl.studenttools.R;

public class AddNoteActivity extends AppCompatActivity {

    public static final int NEW_WORD_ACTIVITY_REQUEST_CODE = 1;
    public static final String EXTRA_REPLY_TITLE = "com.example.android.wordlistsql.REPLY_TITLE";
    public static final String EXTRA_REPLY_NOTE = "com.example.android.wordlistsql.REPLY_NOTE";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        final EditText editTextTitle = (EditText) findViewById(R.id.edit_text_title) ;
        final EditText editTextNote = (EditText) findViewById(R.id.edit_text_note) ;

        FloatingActionButton fab = findViewById(R.id.floating_action_button_save_note);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(editTextTitle.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String titleNote = editTextTitle.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY_TITLE, titleNote);
                    String note = editTextNote.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY_NOTE,note);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();


            }
        });

    }
}
