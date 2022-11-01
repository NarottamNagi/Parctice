package com.example.securityApp.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.securityApp.dao.FlatRepository;
import com.example.securityApp.model.FlatEntity;
import com.example.securityApp.service.FlatService;

@Controller
@RequestMapping("/")
public class FlatController {
	
	@Autowired
	private FlatService flatService;
	
	
	@RequestMapping("/")
	public String home(Model model)
	{
		FlatEntity entity = new FlatEntity();
		model.addAttribute("flatentity",entity);
		return "index";
		
	}
	
	@RequestMapping("/visiterreg")
	public String registration(@RequestParam("flatOwnerName") String flatOwnerName,@RequestParam("entryDate") String entryDate, 
			@RequestParam("exitDate") String exitDate,
			@RequestParam("flatnumber") String flatnumber, @RequestParam("image") MultipartFile multipartFile) throws ParseException
	{
		System.out.println(flatOwnerName);
		FlatEntity entity = new FlatEntity();
		entity.setLastName(flatOwnerName);
		entity.setEntryDate(new SimpleDateFormat("YYYY-MM-DD").parse(entryDate));
		entity.setEntryDate(new SimpleDateFormat("YYYY-MM-DD").parse(exitDate));
		entity.setFlatnumber(flatnumber);
		FlatEntity savedFlatEntity =  flatService.add(entity, multipartFile);
		if(savedFlatEntity!=null)
			return "success";
		else
			return "redirect:/";
	}

}
