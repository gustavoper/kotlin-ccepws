package br.com.gustavoper.ccepws.controller

import br.com.gustavoper.ccepws.model.Note
import br.com.gustavoper.ccepws.repository.NoteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("notes")
class NoteController {

    @Autowired
    lateinit var noteRepository: NoteRepository

    @GetMapping
    fun list(): List<Note>{
        return noteRepository.findAll().toList()
    }
    @PostMapping
    fun add(@RequestBody note: Note): Note {
        return noteRepository.save(note)
    }

    @PutMapping("{id}")
    fun alter(@PathVariable id: Long, @RequestBody note: Note): Note {
        if (noteRepository.existsById(id)) {
            val newNote = note.copy(id)
            return noteRepository.save(newNote)
        }

        return Note()
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id)
        }
    }

}