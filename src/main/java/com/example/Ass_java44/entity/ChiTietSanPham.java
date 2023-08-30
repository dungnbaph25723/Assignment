package com.example.Ass_java44.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name="ChiTietSP")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietSanPham {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    @Column(name="Id")
    private UUID id;

    @JoinColumn(name="IdSP")
    @ManyToOne
    private SanPham sanPham;

    @JoinColumn(name="IdNsx")
    @ManyToOne
    private NSX nsx;

    @JoinColumn(name="IdMauSac")
    @ManyToOne
    private MauSac mauSac;

    @JoinColumn(name="IdDongSP")
    @ManyToOne
    private DongSP dongSP;

    @Column(name="NamBH")
    private int namBH;

    @Column(name="MoTa")
    private String moTa;

    @Column(name = "SoLuongTon")
    private int soLuongTon;

    @Column(name="GiaNhap")
    private float giaNhap;

    @Column(name = "GiaBan")
    private float giaBan;

}
