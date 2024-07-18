package org.myProjects.bookshelf.service;

import jakarta.transaction.Transactional;
import org.myProjects.bookshelf.repository.BookRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;


@Service
@Transactional
public class TextService {

    private final BookRepository repository;
    @Value("${server.storage}")
    private String storage;

    public TextService (BookRepository repository) {
        this.repository = repository;
    }

    public String getText (Integer bookId) {
        String path = storage + "\\" + bookId + "\\" + repository.findSourceById(bookId);
        String bookText = readText(path);
        int startBody = bookText.indexOf("<body>");
        int endBody = bookText.lastIndexOf("</body>");
        return bookText.substring(startBody, endBody + 7);
    }

    // Метод для чтения содержимого текстового файла, извлечения данных и записи в переменную String
    private static String readText(String filePath) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(filePath)))) {
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
