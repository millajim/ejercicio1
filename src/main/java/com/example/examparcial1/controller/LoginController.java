/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.examparcial1.controller;

import com.example.examparcial1.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login"; 
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Usuario usuario, Model model) {
        if ("admin".equals(usuario.getUsername()) && "admin".equals(usuario.getPassword())) {
            return "success";
        } else {
            model.addAttribute("mensajeError", "Usuario o contraseña incorrectos.");
            return "error"; 
        }
    }
}
