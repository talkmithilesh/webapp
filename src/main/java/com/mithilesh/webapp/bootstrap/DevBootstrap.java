package com.mithilesh.webapp.bootstrap;


import com.mithilesh.webapp.model.Author;
import com.mithilesh.webapp.model.Book;
import com.mithilesh.webapp.model.Publisher;
import com.mithilesh.webapp.repositories.AuthorRepository;
import com.mithilesh.webapp.repositories.BookRepository;
import com.mithilesh.webapp.repositories.PublisherRespository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRespository publisherRespository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRespository publisherRespository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRespository = publisherRespository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author mithilesh = new Author("Mithilesh", "Kumar");
        Publisher bsbs = new Publisher("bsbs", "New Delhi");
        Book firstBook = new Book("My First book", "12345", bsbs);
        mithilesh.getBooks().add(firstBook);
        firstBook.getAuthors().add(mithilesh);
        firstBook.setPublisher(bsbs);

        authorRepository.save(mithilesh);
        publisherRespository.save(bsbs);
        bookRepository.save(firstBook);

        Author tRaja = new Author("T", "Raja");
        Publisher hindustan = new Publisher("Hindustan", "Chennai");
        Book c = new Book("c", "67347", hindustan);
        tRaja.getBooks().add(c);
        c.getAuthors().add(tRaja);
        c.setPublisher(hindustan);

        authorRepository.save(tRaja);
        publisherRespository.save(hindustan);
        bookRepository.save(c);
    }

}
