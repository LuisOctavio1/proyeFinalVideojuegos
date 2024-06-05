/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mygame;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;

/**
 *
 * @author PC NASUA
 */
public interface Enemigo {
    public void avanzar(Vector3f posicionObjetivo, float tpf);
    public int atacar();
    public void detenerse();
    public void cambiarObjetivo();
    public void acciones(float tpf);
    public Node getEnemigo();
}
