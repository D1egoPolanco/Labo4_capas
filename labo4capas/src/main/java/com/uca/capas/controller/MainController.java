package com.uca.capas.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.domain.*;

@Controller
public class MainController {
	
	@RequestMapping("/producto")
	public ModelAndView initMain() {
		Producto producto = new Producto();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("producto", producto);
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/formProducto")
	public ModelAndView formProducto(@Valid @ModelAttribute Producto producto, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		//String msg = "Producto " + producto.getNombre() + " guardado con éxito.";
		
		if(result.hasErrors()) {
			mav.setViewName("index");
		} else {
			//mav.addObject("msg", msg);
			mav.setViewName("exito");
		}
		return mav;
	}
}