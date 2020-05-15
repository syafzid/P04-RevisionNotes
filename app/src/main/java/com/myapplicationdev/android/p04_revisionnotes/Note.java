package com.myapplicationdev.android.p04_revisionnotes;

public class Note {
    private int id;
    private String noteContent;
    private int stars;

    public Note(int id, String noteContent, int stars) {
        this.id = id;
        this.noteContent = noteContent;
    }

    public int getId() {
        return id;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public int getStars() {
        return stars;
    }
}
