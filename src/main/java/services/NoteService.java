package services;

import interfaces.Crud;
import models.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.NoteDao;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService implements Crud<Note, Long> {
    private final NoteDao dao;

    @Autowired
    public NoteService(NoteDao dao) {
        this.dao = dao;
    }

    @Override
    public void add(Note note) {
        if (noteBaseValidation(note)) {
            dao.add(note);
        }
    }

    @Override
    public void update(Note note) {
        if (noteFullValidation(note)) {
            dao.update(note);
        }
    }

    @Override
    public void deleteById(Long aLong) {
        dao.deleteById(aLong);
    }

    @Override
    public Optional<Note> getById(Long aLong) {
        return dao.getById(aLong);
    }

    @Override
    public List<Note> listAll() {
        return dao.listAll();
    }


    private boolean noteBaseValidation(Note note) {
        return note != null && note.getContent() != null && note.getTitle() != null;
    }

    private boolean noteFullValidation(Note note) {
        return note != null && note.getContent() != null && note.getTitle() != null && note.getId() != null;
    }
}
