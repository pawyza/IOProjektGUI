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
    
    private RecordM record;
    private ClientM client;
    private int number;
    private LocalDate date;
    private RentalM rental;

    public ReservationM(RecordM record, ClientM client, int number, LocalDate date, RentalM rental) {
        this.record = record;
        this.client = client;
        this.number = number;
        this.date = date;
        this.rental = rental;
    }

    public RecordM getRecord() {
        return record;
    }

    public void setRecord(RecordM record) {
        this.record = record;
    }

    public ClientM getClient() {
        return client;
    }

    public void setClient(ClientM client) {
        this.client = client;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public RentalM getRental() {
        return rental;
    }

    public void setRental(RentalM rental) {
        this.rental = rental;
    }
    
    
}
