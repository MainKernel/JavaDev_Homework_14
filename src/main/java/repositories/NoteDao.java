package repositories;

import interfaces.cruds.Create;
import interfaces.cruds.Delete;
import interfaces.cruds.Read;
import interfaces.cruds.Update;
import models.Note;
import utils.DataBase;

import java.util.List;
import java.util.Optional;

public class NoteDao implements Create<Note>, Read<Note, Long>, Update<Note>, Delete<Long> {

    private final DataBase dataBase = DataBase.getINSTANCE();

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
