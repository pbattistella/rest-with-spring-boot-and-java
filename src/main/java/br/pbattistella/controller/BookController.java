package br.pbattistella.controller;

import br.pbattistella.data.vo.v1.BookVO;
import br.pbattistella.data.vo.v1.PersonVO;
import br.pbattistella.data.vo.v2.PersonVOV2;
import br.pbattistella.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BookVO> findAll() {
        return bookService.findAll();
    }

    @GetMapping(value = "/v1/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BookVO findById(@PathVariable Long id){
        return bookService.findById(id);
    }

    @PostMapping(value="/v1", consumes = MediaType.APPLICATION_JSON_VALUE,
                produces = MediaType.APPLICATION_JSON_VALUE)
    public BookVO create(@RequestBody BookVO book){
        return bookService.create(book);
    }

    @PutMapping(value = "/v1/{id}", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE )
    public BookVO update(@PathVariable Long id, @RequestBody BookVO book){
        return bookService.update(id, book);
    }

    @DeleteMapping(value = "/v1/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
