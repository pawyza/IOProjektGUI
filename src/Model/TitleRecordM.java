/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Kuba
 */
public class TitleRecordM {
    
    private String title;
    private String author;
    private String id;
    private ArrayList<RecordM> records= new ArrayList();
    private RecordM record;
    private String genre;
    private String cast;

    public TitleRecordM(String title, String author, String id, RecordM record, String genre, String cast) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.record = record;
        this.genre = genre;
        this.cast = cast;
    }

    public TitleRecordM(String id, String title, String author, String genre, String cast) {
        this.title = title;
        this.author = author;
        this.id = id;
        this.genre = genre;
        this.cast = cast;
    }

    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<RecordM> getRecords() {
        return records;
    }

    public void setRecords(ArrayList<RecordM> records) {
        this.records = records;
    }

    public RecordM getRecord() {
        return record;
    }

    public void setRecord(RecordM record) {
        this.record = record;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }
    
      @Override
    public String toString() {
        String help = "Title: " + getTitle();
        help += " Author: " + getAuthor();
        return help;
    }
}
