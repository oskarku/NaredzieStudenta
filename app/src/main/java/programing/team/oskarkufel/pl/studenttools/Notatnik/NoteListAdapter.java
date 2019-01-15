package programing.team.oskarkufel.pl.studenttools.Notatnik;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import programing.team.oskarkufel.pl.studenttools.Notatnik.ROOM.NoteWord;
import programing.team.oskarkufel.pl.studenttools.R;

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.NoteViewHolder> {

    class NoteViewHolder extends RecyclerView.ViewHolder {
        private final TextView titleNoteItemView;
        private final TextView noteNoteItemView;

        private NoteViewHolder(View itemView) {
            super(itemView);
            titleNoteItemView = (TextView) itemView.findViewById(R.id.textViewNote);
            noteNoteItemView = (TextView) itemView.findViewById(R.id.textViewTitle);

            
            
        }
    }

    private final LayoutInflater mInflater;
    private List<NoteWord> mWords; // Cached copy of words

    NoteListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new NoteViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        if (mWords != null) {
            NoteWord current = mWords.get(position);
            holder.titleNoteItemView.setText(current.getNTytul());
            holder.noteNoteItemView.setText(current.getNNotatka());
        } else {
            // Covers the case of data not being ready yet.
            holder.titleNoteItemView.setText("No Title");
            holder.noteNoteItemView.setText("No Note");
        }
    }

    void setWords(List<NoteWord> noteWords){
        mWords = noteWords;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mWords != null)
            return mWords.size();
        else return 0;
    }




}
