/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Supermercado.controller;

import com.Supermercado.entity.Comida;
import com.Supermercado.entity.Frescos;
import com.Supermercado.service.IComidaService;
import com.Supermercado.service.IFrescosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author mpaul
 */
@Controller
public class ComidaController {
    
    @Autowired
    private IComidaService comidaService;
    
    @Autowired
    private IFrescosService frescosService;
    
    @GetMapping("/comida")
    public String index(Model model) {
        List<Comida> listaComida = comidaService.listarComida();
        model.addAttribute("titulo", "Tabla Comida");
        model.addAttribute("comida", listaComida);
        return "comida";
          
    }
    
    @GetMapping("/comidaN")
    public String crearComida (Model model) {
        List<Frescos> listaFrescos = frescosService.listaFrescos();
        model.addAttribute("comida", new Comida());
        model.addAttribute("frescos", listaFrescos);
        return "crear";
    }
    
    @GetMapping ("/delete/{id}")
    public String eliminarComida (@PathVariable ("id") Long idComida){
        comidaService.deleteComida(idComida);
        return "redirect:/comida";
    }
    
    @PostMapping ("/save")
    public String guardarComida (@ModelAttribute Comida comida){
        comidaService.guardarComida(comida);
        return "redirect:/comida";
        
    }
    
    @GetMapping ("/editComida/{id}")
    public String editarComida (@PathVariable("id") Long idComida, Model model){
        Comida comida = comidaService.getComidaById(idComida);
        List<Frescos> listaFrescos = frescosService.listaFrescos();
        model.addAttribute("comida", comida);
        model.addAttribute("frescos", listaFrescos);
        return "crear";
        
    }
}
