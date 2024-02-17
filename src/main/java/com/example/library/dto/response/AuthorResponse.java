package com.example.library.dto.response;

import com.example.library.entity.Author;
import com.example.library.util.ApiResponse;

import java.util.List;

public class AuthorResponse extends ApiResponse {
    private List<Author> authors;

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}
