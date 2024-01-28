package com.mandiri.ciso.MandiriCiso.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class PettyCash {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String transaksi;
    private String jenis_transaksi;
    private Long nominal;
    private Date tanggal;

    protected PettyCash() {}

    public PettyCash(String transaksi, String jenis_transaksi, Long nominal, Date tanggal) {
        this.transaksi = transaksi;
        this.jenis_transaksi = jenis_transaksi;
        this.nominal = nominal;
        this.tanggal = tanggal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(String transaksi) {
        this.transaksi = transaksi;
    }

    public String getJenis_transaksi() {
        return jenis_transaksi;
    }

    public void setJenis_transaksi(String jenis_transaksi) {
        this.jenis_transaksi = jenis_transaksi;
    }

    public Long getNominal() {
        return nominal;
    }

    public void setNominal(Long nominal) {
        this.nominal = nominal;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    @Override
    public String toString() {
        return "PettyCash{" +
                "id=" + id +
                ", transaksi='" + transaksi + '\'' +
                ", jenis_transaksi='" + jenis_transaksi + '\'' +
                ", nominal=" + nominal +
                ", tanggal=" + tanggal +
                '}';
    }

}
