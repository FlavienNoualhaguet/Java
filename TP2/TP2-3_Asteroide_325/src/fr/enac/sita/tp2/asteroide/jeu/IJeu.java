/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fr.enac.sita.tp2.asteroide.jeu;

/**
 *
 * @author noualhfl
 */
public interface IJeu {
    public String jouerUnCoup();
    public Integer arbitrer(String coup1, String coup2);
    public String getNom();
}
