package proyectocard.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "card")
public class CardModel {

    @Id
    @Column(unique = true, nullable = false)
    private Long card_number;

    private int cvv;

    @Column(length = 2)
    private String expiration_month;

    @Column(length = 4)
    private String expiration_year;

    @Column(length = 100)
    private String email;

    @Column(length = 24)
    private String token;

    public CardModel() {
    }

    public CardModel(Long card_number, int cvv, String expiration_month, String expiration_year, String email,
            String token) {
        this.card_number = card_number;
        this.cvv = cvv;
        this.expiration_month = expiration_month;
        this.expiration_year = expiration_year;
        this.email = email;
        this.token = token;
    }

    public Long getCard_number() {
        return card_number;
    }

    public void setCard_number(Long card_number) {
        this.card_number = card_number;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getExpiration_month() {
        return expiration_month;
    }

    public void setExpiration_month(String expiration_month) {
        this.expiration_month = expiration_month;
    }

    public String getExpiration_year() {
        return expiration_year;
    }

    public void setExpiration_year(String expiration_year) {
        this.expiration_year = expiration_year;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String generarTotken() {

        String caracteres = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        String token = "pk_test_";

        for (int i = 0; i < 16; i++) {
            int numero = (int) (Math.random() * caracteres.length());
            token = token + caracteres.substring(numero, numero + 1);
        }

        return token;
    }

}
