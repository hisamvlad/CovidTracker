package com.avecoder.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.avecoder.models.Location;
import com.avecoder.services.VirusDataService;

@Controller 
public class HomeController {

	@Autowired
	VirusDataService virusDataService;
	
	@GetMapping("/")
	public String home(Model model) {
		List<Location> allStats = virusDataService.getAllStats();
		int totalCasesWorldwide = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
		model.addAttribute("locationStatistics", allStats);
		model.addAttribute("totalCasesWorldwide", totalCasesWorldwide);
		return "home";
	}
}
