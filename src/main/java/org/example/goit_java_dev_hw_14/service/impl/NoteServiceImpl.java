package org.example.goit_java_dev_hw_14.service.impl;

import org.example.goit_java_dev_hw_14.entity.Note;
import org.example.goit_java_dev_hw_14.repository.NoteRepository;
import org.example.goit_java_dev_hw_14.service.NoteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public List<Note> listAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note add(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public void deleteById(long id) {
        if (!noteRepository.existsById(id)) {
            throw new NoSuchElementException("Note with id " + id + " not found");
        }
        noteRepository.deleteById(id);
    }

    @Override
    public void update(Note note) {
        if (!noteRepository.existsById(note.getId())) {
            throw new NoSuchElementException("Note with id " + note.getId() + " not found");
        }
        noteRepository.save(note);
    }

    @Override
    public Note getById(long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Note with id " + id + " not found"));
    }
}