/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author Kuba
 */
public class ClientM {
    
    private List<ReservationM> reservations;
    private String numberCard;
    private String login;
    private int number;
    private String password;

    public ClientM(List<ReservationM> reservations, String numberCard, String login, int number, String password) {
        this.reservations = reservations;
        this.numberCard = numberCard;
        this.login = login;
        this.number = number;
        this.password = password;
    }

    public ClientM(String numberCard, String login, int number, String password) {
        this.numberCard = numberCard;
        this.login = login;
        this.number = number;
        this.password = password;
    }
    
    public List<ReservationM> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationM> reservations) {
        this.reservations = reservations;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
       @Override
    public String toString() {
        String client = number+ " "+ login+" " + numberCard + "\n";
      
        return client + "\n";
    }
}
