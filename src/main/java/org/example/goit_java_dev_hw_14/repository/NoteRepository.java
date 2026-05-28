package org.example.goit_java_dev_hw_14.repository;

import org.example.goit_java_dev_hw_14.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}