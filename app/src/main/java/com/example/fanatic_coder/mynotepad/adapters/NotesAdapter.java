package com.example.fanatic_coder.mynotepad.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fanatic_coder.mynotepad.R;
import com.example.fanatic_coder.mynotepad.model.Note;
import com.example.fanatic_coder.mynotepad.utils.NoteUtils;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteHolder>{

    private ArrayList<Note> notes;

    public NotesAdapter(ArrayList<Note> notes) {
        this.notes = notes;
    }

    //method onCreateViewHolder is called when a new view is created
    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_layout,parent, false);
        return new NoteHolder(v);
    }

    //method onBindViewHolder displays data at specified position
    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Note note = getNote(position);
        if(note != null) {
            holder.noteTitle.setText(note.getWriteText());
            holder.noteDate.setText(NoteUtils.dateFromLong(note.getNoteDate()));
        }
    }

    //method getNote gets the notes position
    private Note getNote (int position) {
        return notes.get(position);
    }

    //method getItemCount gets how many notes will be created
    @Override
    public int getItemCount() {
        return notes.size();
    }

    class NoteHolder extends RecyclerView.ViewHolder{
        TextView noteTitle, noteDate;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
