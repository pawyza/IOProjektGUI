/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDate;

/**
 *
 * @author Kuba
 */
public class ReservationM {
    
   private String clientID;
   private String number;
   private String dateStart;
   private String dateEnd;
   private String recordID;
   private String title;

    public ReservationM(String clientID, String numberCol, String dateStart, String dateEnd, String recordID, String title) {
        this.clientID = clientID;
        this.number = numberCol;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.recordID = recordID;
        this.title = title;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getNumberCol() {
        return number;
    }

    public void setNumberCol(String numberCol) {
        this.number = numberCol;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getRecordID() {
        return recordID;
    }

    public void setRecordID(String recordID) {
        this.recordID = recordID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
   
    
    
}
