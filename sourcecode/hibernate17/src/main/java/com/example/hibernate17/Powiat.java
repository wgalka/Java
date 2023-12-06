package com.example.hibernate17;


import jakarta.persistence.*;

@Entity
@Table(name = "POWIAT")
public class Powiat {
    @Id
    @Column(name = "id_powiatu", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_powiatu;

    @Column(name = "nazwa_powiatu")
    String nazwa_powiatu;

    public Powiat(String nazwa_powiatu) {
        this.nazwa_powiatu = nazwa_powiatu;
    }

    public Powiat() {}

    public Long getId_powiatu() {
        return id_powiatu;
    }

    public void setId_powiatu(Long id_powiatu) {
        this.id_powiatu = id_powiatu;
    }

    public String getNazwa_powiatu() {
        return nazwa_powiatu;
    }

    public void setNazwa_powiatu(String nazwa_powiatu) {
        this.nazwa_powiatu = nazwa_powiatu;
    }

    @Override
    public String toString() {
        return "Powiat{" +
                "id_powiatu=" + id_powiatu +
                ", nazwa_powiatu='" + nazwa_powiatu + '\'' +
                '}';
    }
}

