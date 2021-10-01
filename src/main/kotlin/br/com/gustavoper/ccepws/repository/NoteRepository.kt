package br.com.gustavoper.ccepws.repository

import br.com.gustavoper.ccepws.model.Note
import org.springframework.data.repository.CrudRepository

interface NoteRepository : CrudRepository<Note, Long>
