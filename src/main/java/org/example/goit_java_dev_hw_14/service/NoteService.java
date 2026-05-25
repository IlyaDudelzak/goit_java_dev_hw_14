package org.example.goit_java_dev_hw_14.service;

import org.example.goit_java_dev_hw_14.entity.Note;
import java.util.List;

public interface NoteService {
    List<Note> listAll();
    Note add(Note note);
    void deleteById(long id);
    void update(Note note);
    Note getById(long id);
}