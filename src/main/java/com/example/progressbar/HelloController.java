package com.example.progressbar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class HelloController {
    public ProgressBar Progressbar;
    @FXML
    private Label welcomeText;


    public void OnStartClick(ActionEvent actionEvent) {
        int[] prodotti = {10, 10, 10};

        Cliente cliente = new Cliente(prodotti);
        Thread thread1 = new Thread(cliente);
        Thread thread2 = new Thread(cliente);
        Thread thread3 = new Thread(cliente);

        thread1.setName("com.example.progressbar.Cliente 1");
        thread2.setName("com.example.progressbar.Cliente 2");
        thread3.setName("com.example.progressbar.Cliente 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}