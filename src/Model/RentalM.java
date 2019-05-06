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
public class RentalM {
    
    private ReservationM reservation;
    private LocalDate returnDate;

    public RentalM(ReservationM reservation, LocalDate returnDate) {
        this.reservation = reservation;
        this.returnDate = returnDate;
    }

    public ReservationM getReservation() {
        return reservation;
    }

    public void setReservation(ReservationM reservation) {
        this.reservation = reservation;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
    
    
    
}
