package bazadanych;


import org.springframework.stereotype.Controller;

import javax.persistence.*;

@Entity
@Table(name="KsiazkaTelefoniczna")
public class Osoba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "IMIE")
    private String imie;

    @Column(name = "NAZWISKO")
    private String nazwisko;


    @Column(name="NUMER")
    private String telefon;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "OPIS", length = 2048)
    private String opis;

    @Transient
    boolean  nowy;

    public Osoba(String imie, String nazwisko, String telefon, String email, String opis, boolean nowy) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
        this.email = email;
        this.opis = opis;
        this.nowy = nowy;
    }

    public Osoba(Integer id, String imie, String nazwisko, String telefon, String email, String opis, boolean nowy) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.telefon = telefon;
        this.email = email;
        this.opis = opis;
        this.nowy = nowy;
    }

    public Osoba() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public boolean isNowy() {
        return nowy;
    }

    public void setNowy(boolean nowy) {
        this.nowy = nowy;
    }

    @Override
    public String toString() {
        return "Osoba{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", telefon='" + telefon + '\'' +
                ", email='" + email + '\'' +
                ", opis='" + opis + '\'' +
                ", nowy=" + nowy +
                '}';
    }
}

