package me.banto.tp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

/**
 * Entité permettant de faire persister le compteur qui incrémente/décrémente.
 * C'est une entité unique, son identifiant est 1 et ne change jamais.
 * 
 * @author Antoine BALIEU
 */
@Data
@Entity
public class Metrics {
    @Id
    @GeneratedValue
    private final int id = 1;

    private int counter;

    public int increaseCounter() {
        return ++counter;
    }

    public int decreaseCounter() {
        return --counter;
    }
}
