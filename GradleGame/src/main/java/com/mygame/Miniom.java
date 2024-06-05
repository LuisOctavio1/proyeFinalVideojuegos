/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mygame;

import com.jme3.animation.AnimChannel;
import com.jme3.animation.AnimControl;
import com.jme3.animation.LoopMode;
import com.jme3.asset.AssetManager;
import com.jme3.light.DirectionalLight;
import com.jme3.math.Vector3f;
import com.jme3.scene.Node;

/**
 *
 * @author PC NASUA
 */
public class Miniom implements Enemigo{
    int vida;
    private Node enemigo;
    private AnimChannel channel;
    private AnimControl control;
    float velocidad;
    float tiempoDesdeUltimoAtaque;
    int daño;
    
    public Miniom(AssetManager assetManager, Vector3f posicionInicial){
        vida = 100;
        velocidad = (float) 5;
         DirectionalLight dl = new DirectionalLight();
        dl.setDirection(new Vector3f(20, 20, 20).normalizeLocal());
        enemigo = (Node) assetManager.loadModel("Models/Oto/OtoOldAnim.j3o");
        enemigo.setLocalScale(.75f);
        enemigo.setLocalTranslation(posicionInicial);
        control = enemigo.getControl(AnimControl.class);
        channel = control.createChannel();
        daño = 25;
        
        
    }

    @Override
    public void avanzar(Vector3f posicionObjetivo, float tpf) {
        Vector3f direccion = posicionObjetivo.subtract(enemigo.getLocalTranslation()).normalize();
        Vector3f nuevaPosicion = enemigo.getLocalTranslation().add(direccion.mult(velocidad * tpf));
        enemigo.setLocalTranslation(nuevaPosicion);
        if (!"Walk".equals(channel.getAnimationName())) {
            channel.setAnim("Walk");
            channel.setLoopMode(LoopMode.Loop);
            channel.setSpeed(1f);
        }
    }

    @Override
    public int atacar() {
         if (!"push".equals(channel.getAnimationName())) {
            channel.setAnim("push");
            channel.setLoopMode(LoopMode.Loop);
            channel.setSpeed(1f);
        }
        return daño;
    }

    @Override
    public void detenerse() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void cambiarObjetivo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void acciones(float tpf) {
        tiempoDesdeUltimoAtaque += tpf;
        if (enemigo != null && enemigo.getLocalTranslation().distance(new Vector3f(55, 4, -24)) > 1.0f) {
            avanzar(new Vector3f(55, 4, -24), tpf);   
        }else{
            if (tiempoDesdeUltimoAtaque >= 2.0f) { 
            atacar();
            tiempoDesdeUltimoAtaque = 0f; 
        }
        }
    }
    
    public Node getEnemigo() {
        return enemigo;
    }
}
    

