/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author arief
 */

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.BMI;

public class BMIController {
   @FXML private TextField txtNama;
    @FXML private RadioButton rbPria;
    @FXML private RadioButton rbWanita;
    @FXML private TextField txtBerat;
    @FXML private TextField txtTinggi;
    @FXML private VBox boxHasil;
    @FXML private Label lblEmoji;
    @FXML private Label lblHasilBmi;
    @FXML private Label lblKategori;
    @FXML private Label lblIdeal;
    @FXML private Label lblSaran;

    @FXML
    private void handleHitungBmi(ActionEvent event) {
        try {
            String nama = txtNama.getText().trim().isEmpty() ? "Teman" : txtNama.getText().trim();
            String gender = rbPria.isSelected() ? "Pria" : "Wanita";
            double berat = Double.parseDouble(txtBerat.getText());
            double tinggi = Double.parseDouble(txtTinggi.getText());

            if (berat <= 0 || tinggi <= 0) {
                lblEmoji.setText("⚠️");
                lblHasilBmi.setText("Berat & Tinggi harus > 0!");
                return;
            }

            BMI bmiModel = new BMI(nama, gender, berat, tinggi);
            double nilai = bmiModel.hitungBMI();
            String kategori = bmiModel.getKategori();

            lblHasilBmi.setText(String.format("Halo %s (%s), BMI: %.2f", bmiModel.getNama(), bmiModel.getGender(), nilai));
            lblKategori.setText("Kategori: " + kategori);
            lblIdeal.setText("Target Berat Ideal: " + bmiModel.getRentangBeratIdeal());
            lblSaran.setText(bmiModel.getSaranKesehatan());

            // Ubah emoji & warna background kartu sesuai kategori
            if (nilai < 18.5) {
                lblEmoji.setText("🍽️");
                boxHasil.setStyle("-fx-background-color: #FEFCBF; -fx-background-radius: 12; -fx-padding: 15; -fx-border-color: #D69E2E; -fx-border-radius: 12;");
            } else if (nilai < 25.0) {
                lblEmoji.setText("🌟");
                boxHasil.setStyle("-fx-background-color: #C6F6D5; -fx-background-radius: 12; -fx-padding: 15; -fx-border-color: #38A169; -fx-border-radius: 12;");
            } else if (nilai < 30.0) {
                lblEmoji.setText("🏃");
                boxHasil.setStyle("-fx-background-color: #FEEBC8; -fx-background-radius: 12; -fx-padding: 15; -fx-border-color: #DD6B20; -fx-border-radius: 12;");
            } else {
                lblEmoji.setText("💪");
                boxHasil.setStyle("-fx-background-color: #FED7D7; -fx-background-radius: 12; -fx-padding: 15; -fx-border-color: #E53E3E; -fx-border-radius: 12;");
            }

        } catch (NumberFormatException e) {
            lblEmoji.setText("❌");
            lblHasilBmi.setText("Masukkan angka yang valid!");
            lblKategori.setText("Contoh berat: 60, tinggi: 170");
            lblIdeal.setText("-");
            lblSaran.setText("Gunakan titik (.) jika memakai desimal.");
        }
    }

    @FXML
    private void handleReset(ActionEvent event) {
        txtNama.clear();
        txtBerat.clear();
        txtTinggi.clear();
        rbPria.setSelected(true);
        lblEmoji.setText("😊");
        lblHasilBmi.setText("Nilai BMI: -");
        lblKategori.setText("Kategori: -");
        lblIdeal.setText("Berat Ideal: -");
        lblSaran.setText("Silakan masukkan data Anda di atas.");
        boxHasil.setStyle("-fx-background-color: #FFFFFF; -fx-background-radius: 12; -fx-padding: 15; -fx-border-color: #CBD5E0; -fx-border-radius: 12;");
    }

    @FXML
    private void kembaliKeHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/view/home.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
