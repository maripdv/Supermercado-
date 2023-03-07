/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Supermercado.service;

import com.Supermercado.entity.Comida;
import com.Supermercado.repository.ComidaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ComidaService implements IComidaService{
    
    @Autowired
    private ComidaRepository comidaRepository;
    
    
    @Override
    public List<Comida> listarComida() {
        return (List<Comida>)comidaRepository.findAll();
    }
    
    @Override
    public Comida getComidaById(long id) {
        return comidaRepository.findById(id).orElse(null);
    }
    
    @Override
    public void guardarComida(Comida comida) {
        comidaRepository.save(comida);
    }
    
    @Override
    public void deleteComida(long id) {
        comidaRepository.deleteById(id);
    }
}
