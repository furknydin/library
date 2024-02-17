package com.example.library.service;

import com.example.library.dto.request.AuthorAddRequest;
import com.example.library.dto.response.AuthorAddResponse;
import com.example.library.dto.response.AuthorResponse;
import com.example.library.entity.Author;
import com.example.library.repository.AuthorRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    public AuthorAddResponse addAuthor(AuthorAddRequest authorAddRequest){
        AuthorAddResponse authorAddResponse = new AuthorAddResponse();
        try{
            Author author = new Author();
            author.setFirstName(authorAddRequest.getFirstName());
            author.setLastName(authorAddRequest.getLastName());

            authorRepository.save(author);

            authorAddResponse.setMessage("Author add is success");
            authorAddResponse.setStatus(HttpStatus.OK);

        }catch (Exception e){
            authorAddResponse.setMessage("Some issue is wrong");
            authorAddResponse.setStatus(HttpStatus.BAD_REQUEST);
        }
        return  authorAddResponse;
    }

    public AuthorResponse getAuthors(){
        AuthorResponse authorResponse = new AuthorResponse();
        try{
            List<Author> authors = authorRepository.findAll();
            authorResponse.setAuthors(authors);

            authorResponse.setMessage("Authors retrieve");
            authorResponse.setStatus(HttpStatus.OK);

        }catch (Exception e){
            authorResponse.setMessage("Some issue is wrong");
            authorResponse.setStatus(HttpStatus.BAD_REQUEST);
        }
        return authorResponse;
    }
}
