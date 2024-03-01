package utils;


import models.Note;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public  class DataBase {
    private static Long id = 0L;
    private static final List<Note> DATABASE = new ArrayList<>();

    public DataBase() {

    }

    public void persist(Note note){
        note.setId(id);
        id++;
        DATABASE.add(note);
    }

    public List<Note> findAll() {
        return new ArrayList<>(DATABASE);
    }

    public Note findById(Long id){
        for (Note note : DATABASE) {
            if (note.getId().equals(id)) {
                return note;
            }
        }
        return null;
    }


    public void remove(Long id) {
        for (int i = 0; i < DATABASE.size(); i++) {
            Note note = DATABASE.get(i);
            if(note.getId().equals(id)){
                DATABASE.remove(note);
            }
        }
    }

    public void merge(Note note) {
        for (Note note1 : DATABASE) {
            if (Objects.equals(note.getId(), note1.getId())) {
                note1.setContent(note.getContent());
                note1.setTitle(note.getTitle());
            }
        }
    }


}
