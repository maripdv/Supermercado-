/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Supermercado.service;

import com.Supermercado.entity.Frescos;
import com.Supermercado.repository.FrescosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrescosService implements IFrescosService{
    
    @Autowired
    private FrescosRepository frescosRepository;
    
    @Override
    public List<Frescos> listaFrescos() {
        return (List<Frescos>)frescosRepository.findAll(); }
}
