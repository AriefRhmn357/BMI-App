/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author arief
 */
public class BMI {
   private String nama;
    private String gender;
    private double beratBadan; // kg
    private double tinggiBadan; // cm

    public BMI(String nama, String gender, double beratBadan, double tinggiBadan) {
        this.nama = nama;
        this.gender = gender;
        this.beratBadan = beratBadan;
        this.tinggiBadan = tinggiBadan;
    }

    public String getNama() { return nama; }
    public String getGender() { return gender; }
    public double getBeratBadan() { return beratBadan; }
    public double getTinggiBadan() { return tinggiBadan; }

    public double hitungBMI() {
        double tinggiMeter = tinggiBadan / 100.0;
        return beratBadan / (tinggiMeter * tinggiMeter);
    }

    public String getKategori() {
        double bmi = hitungBMI();
        if (bmi < 18.5) {
            return "Kurus (Underweight)";
        } else if (bmi < 25.0) {
            return "Normal (Ideal)";
        } else if (bmi < 30.0) {
            return "Gemuk (Overweight)";
        } else {
            return "Obesitas";
        }
    }

    public String getRentangBeratIdeal() {
        double tinggiMeter = tinggiBadan / 100.0;
        double minIdeal = 18.5 * (tinggiMeter * tinggiMeter);
        double maxIdeal = 24.9 * (tinggiMeter * tinggiMeter);
        return String.format("%.1f kg - %.1f kg", minIdeal, maxIdeal);
    }

    public String getSaranKesehatan() {
        double bmi = hitungBMI();
        if (bmi < 18.5) {
            return "Perbanyak asupan nutrisi & protein ya!";
        } else if (bmi < 25.0) {
            return "Keren! Pertahankan pola makan & olahraga rutin.";
        } else if (bmi < 30.0) {
            return "Yuk kurangi makanan manis & mulai olahraga ringan!";
        } else {
            return "Disarankan mengatur pola diet sehat & rutin berolahraga.";
        }
    }
}
