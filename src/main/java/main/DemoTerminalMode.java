/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author arief
 */

import model.BMI;

public class DemoTerminalMode {
    public static void main(String[] args) {
        BMI data = new BMI("Budi", "Pria", 65, 170);
        System.out.println("Nama        : " + data.getNama());
        System.out.printf("Nilai BMI   : %.2f\n", data.hitungBMI());
        System.out.println("Kategori    : " + data.getKategori());
        System.out.println("Berat Ideal : " + data.getRentangBeratIdeal());
    }
}
