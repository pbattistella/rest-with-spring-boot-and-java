package br.pbattistella.service;

import br.pbattistella.data.vo.v1.BookVO;

import java.util.List;

public interface BookService {

    public List<BookVO> findAll();
    public BookVO findById(Long id);
    public BookVO create(BookVO book);
    public BookVO update(Long id, BookVO book);
    public void delete(Long id);
}
