package com.app.controllers;


import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.IVendor;
import com.app.pojos.Vendor;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IVendor dao;

	@GetMapping("/login")
	public String ShowLogin() {
		return "/user/login";
	}

	@PostMapping("/login")
	public String loginValidate(@RequestParam String email, @RequestParam String password,HttpSession hs,Model map) {
		try {
			System.out.println(email + " " + password);
			Vendor v = dao.validate(email, password);
			System.out.println(v.toString());
			if (v != null) {
				System.out.println("hii");
				hs.setAttribute("vendor", v);
				map.addAttribute("status","valid login");
				return "redirect:/user/list";
			}
		} catch (RuntimeException r) {
			System.out.println("err in login");
			// map.addAttribute("status","invalid login plz try again");
			return "redirect:/user/login";
		}
		return "/user/login";

	
	}

	@GetMapping("/register")
	public String showRegisterForm() {

		return "/user/register";
	}

	@PostMapping("/register")
	public String processRegister(@RequestParam String email, @RequestParam String name, @RequestParam String password,
			@RequestParam String role, @RequestParam String mno,
			@RequestParam double amt,@RequestParam Date dt, 
			@RequestParam String city,
			Model map) {

		/*
		 * public Vendor(String name, String email, String password, String role, String
		 * city, String phoneno, Date reg_date, double amt)
		 */
		Vendor v = new Vendor(name, email, password, role, city, mno,dt, amt);
		String s = dao.AddVendor(v);
		if (s != null) {
			map.addAttribute("status", s);
			return "redirect:/user/login";
		}
		map.addAttribute("status", s);
		return "/user/register";

	}

	@GetMapping("/list")
	public String VendorList(Model map) {
		System.out.println("in list");
		map.addAttribute("list", dao.listVendor());
		return "/user/list";
	}
	@GetMapping("/update")
	public String updateVendor(@RequestParam int id,HttpSession hs)
	{
		hs.setAttribute("id", id);
		return "/user/update";
	}
	@PostMapping("/update")
	public String update(@RequestParam String city,HttpSession hs)
	{
		int id=(int) hs.getAttribute("id");
		dao.update(id, city);
		System.out.println("in update");
		return "redirect:/user/list";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam int id)
	{
		
		dao.delete(id);
		return "redirect:/user/list";
	}

}
