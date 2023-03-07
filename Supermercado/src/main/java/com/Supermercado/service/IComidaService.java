/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Supermercado.service;

import com.Supermercado.entity.Comida;
import java.util.List;


public interface IComidaService {
    public List<Comida> listarComida();
    public Comida getComidaById (long id);
    public void guardarComida (Comida comida);
    public void deleteComida (long id);
}
