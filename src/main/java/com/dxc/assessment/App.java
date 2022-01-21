package com.dxc.assessment;

import java.sql.SQLException;
import java.util.List;
import com.dxc.assessment.dao.AuthorDao;
import com.dxc.assessment.modal.Author;

public class App {
    public static void main(String[] args) {
        findAllAuthors();
    }

    static void findAllAuthors() {

        AuthorDao dao = new AuthorDao();
        try {
            List<Author> authors = dao.findAll();
            if (authors.size() == 0) {
                System.out.println("No authors found");
                return;
            }
            authors.forEach(a -> System.out.println(a));
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

    }

    static void createAuthors() {
        Author HaniChicn = new Author(1, "Hani", "chicn", "horror", "hani@abc.com");
        Author HariOrwell = new Author(2, "hari", "Orwell", "comedy", "hari@gbc.com");

        List<Author> Authors = List.of(HaniChicn, HariOrwell);
        AuthorDao authorDao = new AuthorDao();

        Authors.forEach(au -> {
            try {
                int rows = authorDao.save(au);
                System.out.println("Rows affected: " + rows);
            } catch (SQLException e) {
                e.printStackTrace();
                System.err.println(e.getMessage());
            }
        });
    }
}