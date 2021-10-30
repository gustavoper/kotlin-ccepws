package br.com.gustavoper.ccepws.controller

import br.com.gustavoper.ccepws.model.LinkItemResponse
import br.com.gustavoper.ccepws.model.LinkResponse
import br.com.gustavoper.ccepws.model.LinksResponse
import br.com.gustavoper.ccepws.model.Note
import br.com.gustavoper.ccepws.repository.NoteRepository
import net.bytebuddy.dynamic.scaffold.MethodGraph
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.Collections.*
import kotlin.collections.HashMap

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


    @GetMapping("links-s")
    fun links_simple() : HashMap<String, Any> {

        val contextParent = HashMap<String, Any>()
        contextParent.put("start", LinkItemResponse("/start"))
        contextParent.put("build", LinkItemResponse("/build"))

        val context = HashMap<String, Any>()
        context.put("data", contextParent)

        return context
    }




    @GetMapping("links")
    fun links() : LinkResponse {


        return LinkResponse(
            _links = LinksResponse(
                name = "qqq",
                urls = listOf(LinkItemResponse("/start"))
            )
        )
        /**

        return LinkResponse(
            _links = LinksResponse(
                listOf(
                    LinksResponse(
                    "start",
                        urls = listOf(
                            LinkItemResponse("/barrasatart")
                        )
                    ),
                    LinksResponse(
                        "delete",
                        urls = listOf(
                            LinkItemResponse("/delete")
                        )
                    ),
            )
        ))**/

        /**return LinkResponse(
            _links =  LinkedList<LinksResponse>(
                listOf(
                    LinksResponse(
                        name = "start"
                    ),
                    LinksResponse(
                        name = "teste"
                    )
                )
            )
        )**/
    }


    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) {
        if (noteRepository.existsById(id)) {
            noteRepository.deleteById(id)
        }
    }

}