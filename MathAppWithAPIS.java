
package com.mycompany.mathappwithapis;

import com.opencsv.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class MathAppWithAPIS {
    public static void main(String[] args) {
        // Solicitar datos del usuario
        String userId = JOptionPane.showInputDialog("Ingrese su ID:");
        String password = JOptionPane.showInputDialog("Ingrese su contraseña:");
        String name = JOptionPane.showInputDialog("Ingrese su nombre:");
        String email = JOptionPane.showInputDialog("Ingrese su correo electrónico:");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad:"));
        String nationality = JOptionPane.showInputDialog("Ingrese su nacionalidad:");

        // Guardar datos del usuario en un archivo CSV
        saveUserData(userId, password, name, email, age, nationality);
        
        // Selección de área de matemáticas
        String[] options = {"Álgebra", "Criba de Eratóstenes", "Aritmética"};
        int choice = JOptionPane.showOptionDialog(null, "Seleccione un área de matemáticas:", "Temas", 
                                                  JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, 
                                                  null, options, options[0]);
        
        String videoUrl = getVideoUrl(choice);
        openVideo(videoUrl);
        
        // Mostrar ejercicio de práctica
        showPracticeExercise(choice);
        
        // Test de evaluación
        showTest(choice);
    }

    private static void saveUserData(String userId, String password, String name, String email, int age, String nationality) {
        try (FileWriter writer = new FileWriter("users.csv", true);
             CSVWriter csvWriter = new CSVWriter(writer)) {
            String[] userData = {userId, password, name, email, String.valueOf(age), nationality};
            csvWriter.writeNext(userData);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar los datos del usuario.");
        }
    }

    private static String getVideoUrl(int choice) {
        switch (choice) {
            case 0: return "https://www.youtube.com/watch?v=zsVHjJpbFIA&t=2s";
            case 1: return "https://www.youtube.com/watch?v=0Xoa9bFlAEs";
            case 2: return "https://www.youtube.com/watch?v=KT0R9UQ3S-4";
            default: return "";
        }
    }

    private static void openVideo(String url) {
        try {
            Desktop.getDesktop().browse(new java.net.URI(url));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo abrir el video.");
        }
    }

    private static void showPracticeExercise(int choice) {
        String exercise = switch (choice) {
            case 0 -> "Resuelve la ecuación: 2x + 5 = 15";
            case 1 -> "El 54 es un número primo";
            case 2 -> "Realiza la división de 125 ÷ 5:";
            default -> "";
        };
        JOptionPane.showMessageDialog(null, "Ejercicio de práctica: " + exercise);
    }

    private static void showTest(int choice) {
        String question = switch (choice) {
            case 0 -> "¿Cuánto vale x en la ecuación 3x - 7 = 8? (Escribe solo el número)";
            case 1 -> "¿Cuántos números primos hay entre 1 y 150?";
            case 2 -> "Resuelva: 48 ÷ 6";
            default -> "";
        };

        String answer = JOptionPane.showInputDialog(question);
        JOptionPane.showMessageDialog(null, "Gracias por completar el test!");
    }
}
