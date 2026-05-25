package org.example.goit_java_dev_hw_14.controller;

import org.example.goit_java_dev_hw_14.entity.Note;
import org.example.goit_java_dev_hw_14.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/note")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
        if (noteService.listAll().isEmpty()) {
            Note note1 = new Note();
            note1.setTitle("Купить продукты");
            note1.setContent("Молоко, хлеб, сыр, яйца");
            noteService.add(note1);

            Note note2 = new Note();
            note2.setTitle("Spring Boot");
            note2.setContent("Изучить Thymeleaf и контроллеры");
            noteService.add(note2);
        }
    }

    @GetMapping("/list")
    public ModelAndView listNotes() {
        ModelAndView modelAndView = new ModelAndView("note/list");
        modelAndView.addObject("notes", noteService.listAll());
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteNote(@RequestParam("id") long id) {
        noteService.deleteById(id);
        return "redirect:/note/list";
    }

    @GetMapping("/edit")
    public ModelAndView editPage(@RequestParam("id") long id) {
        ModelAndView modelAndView = new ModelAndView("note/edit");
        modelAndView.addObject("note", noteService.getById(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    public String saveUpdate(@ModelAttribute Note note) {
        noteService.update(note);
        return "redirect:/note/list";
    }
}