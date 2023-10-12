package br.pbattistella.service;

import br.pbattistella.controller.Book;
import br.pbattistella.data.vo.v1.BookVO;
import br.pbattistella.exceptions.ResourceNotFoundException;
import br.pbattistella.mapper.DozerMapper;
import br.pbattistella.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class BookServiceImpl implements BookService {

    private Logger logger = Logger.getLogger(BookService.class.getName());

    @Autowired
    BookRepository repository;
    @Override
    public List<BookVO> findAll() {
        logger.info("Finding all books!");
        return DozerMapper.parseListObjects(repository.findAll(), BookVO.class);
    }

    @Override
    public BookVO findById(Long id) {
        logger.info("Finding one book!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        return DozerMapper.parseObject(entity, BookVO.class);
    }

    @Override
    public BookVO create(BookVO book) {

        if (book == null) throw new ResourceNotFoundException("Object not found");

        logger.info("Creating one book!");

        var entity = DozerMapper.parseObject(book, Book.class);
        return DozerMapper.parseObject(repository.save(entity), BookVO.class);
    }

    @Override
    public BookVO update(Long id, BookVO book) {
        if (book == null) throw new ResourceNotFoundException("Object not found");

        logger.info("Updating one book!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        entity.setAuthor(book.getAuthor());
        entity.setLaunchDate(book.getLaunchDate());
        entity.setPrice(book.getPrice());
        entity.setTitle(book.getTitle());

        return DozerMapper.parseObject(repository.save(entity), BookVO.class);
    }

    @Override
    public void delete(Long id) {
        logger.info("Deleting one book!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        repository.delete(entity);
    }
}
