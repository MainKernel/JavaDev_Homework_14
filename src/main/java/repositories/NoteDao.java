package repositories;

import interfaces.Crud;
import models.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utils.DataBase;

import java.util.List;
import java.util.Optional;
@Service
public class NoteDao implements Crud<Note, Long> {

    private final DataBase dataBase;
    @Autowired
    public NoteDao(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    @Override
    public void add(Note note) {
        dataBase.persist(note);
    }

    @Override
    public void update(Note note) {
        dataBase.merge(note);
    }

    @Override
    public void deleteById(Long aLong) {
        dataBase.remove(aLong);
    }

    @Override
    public Optional<Note> getById(Long aLong) {
        return Optional.ofNullable(dataBase.findById(aLong));
    }

    @Override
    public List<Note> listAll() {
        return dataBase.findAll();
    }
}
