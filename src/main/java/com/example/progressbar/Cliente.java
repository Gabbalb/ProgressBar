package com.example.progressbar;

import java.util.Random;

public class Cliente implements Runnable {
    private int[] prodotti;
    private Random rand;

    public Cliente(int[] prodotti) {
        this.prodotti = prodotti;
        this.rand = new Random();
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                int index = rand.nextInt(prodotti.length);
                if (prodotti[index] > 0) {
                    prodotti[index]--;
                    String colorCode = "\u001B[0m";
                    switch (index) {
                        case 0:
                            colorCode = "\u001B[31m"; // rosso
                            break;
                        case 1:
                            colorCode = "\u001B[32m"; // verde
                            break;
                        case 2:
                            colorCode = "\u001B[33m"; // giallo
                            break;
                    }
                    System.out.println(colorCode + "Prodotto " + index + ": " + prodotti[index] + " " + Thread.currentThread().getName() + "\u001B[0m");
                    if (prodotti[index] == 5) {
                        System.out.println("\u001B[31mIN TERMINAZIONE\u001B[0m");
                    }
                    if (prodotti[index] == 0) {
                        System.out.println("\u001B[31mTERMINATO\u001B[0m");
                        break;
                    }
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}