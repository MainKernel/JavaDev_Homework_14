package services;

import models.Note;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import repositories.NoteDao;
import utils.DataBase;


class NoteServiceTest {
    private final NoteService service = new NoteService(new NoteDao(new DataBase()));

    @Test
    void add() {
        //Setup
        Note note = new Note();
        note.setContent("Test content");
        note.setTitle("Test title");

        service.add(note);
        Note note1 = service.getById(note.getId()).orElse(null);

        //Assertion
        Assertions.assertEquals(note, note1);
    }

    @Test
    void update() {
        //Setup
        Note note = new Note();
        note.setContent("Test content");
        note.setTitle("Test title");

        service.add(note);
        note.setTitle("test title 2");
        service.update(note);
        Note note1 = service.getById(note.getId()).orElse(null);

        //Assertion
        assert note1 != null;
        Assertions.assertEquals(note.getTitle(), note1.getTitle());
    }

    @Test
    void deleteById() {
        //Setup
        Note note = new Note();
        note.setContent("Test content");
        note.setTitle("Test title");

        service.add(note);
        service.deleteById(note.getId());
        Note note1 = service.getById(note.getId()).orElse(null);

        //Assertion
        Assertions.assertNull(note1);
    }

    @Test
    void getById() {
        //Setup
        Note note = new Note();
        note.setContent("Test content");
        note.setTitle("Test title");
        service.add(note);
        Note note1 = service.getById(note.getId()).orElse(null);

        //Assertion
        Assertions.assertEquals(note, note1);
    }

    @Test
    void listAll() {
        //Setup
        Note note = new Note();
        note.setContent("Test content");
        note.setTitle("Test title");

        int expected = service.listAll().size() + 1;
        service.add(note);
        int actual = service.listAll().size();

        //Assertion
        Assertions.assertEquals(expected, actual);
    }
}