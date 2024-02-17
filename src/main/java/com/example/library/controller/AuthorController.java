package com.example.library.controller;

import com.example.library.dto.request.AuthorAddRequest;
import com.example.library.dto.response.AuthorAddResponse;
import com.example.library.dto.response.AuthorResponse;
import com.example.library.service.AuthorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("/add")
    public AuthorAddResponse addAuthor (@RequestBody AuthorAddRequest authorAddRequest){
        return authorService.addAuthor(authorAddRequest);
    }

    @PostMapping("/retrieve-authors")
    public AuthorResponse getAuthors(){
        return authorService.getAuthors();
    }
}
