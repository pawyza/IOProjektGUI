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
public class RecordM {
    
    
    private int number;
    private TitleRecordM titleRecord;
    private ArrayList<ReservationM> reservations = new ArrayList();

    public RecordM(int number, TitleRecordM titleRecord, ArrayList<ReservationM> reservations) {
        this.number = number;
        this.titleRecord = titleRecord;
        this.reservations = reservations;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public TitleRecordM getTitleRecord() {
        return titleRecord;
    }

    public void setTitleRecord(TitleRecordM titleRecord) {
        this.titleRecord = titleRecord;
    }

    public ArrayList<ReservationM> getReservations() {
        return reservations;
    }

    public void setReservations(ArrayList<ReservationM> reservations) {
        this.reservations = reservations;
    }
    
    
}
