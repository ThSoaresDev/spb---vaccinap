package br.ufc.vaccinapp.controller;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ufc.vaccinapp.service.VaccineService;

@RestController
@RequestMapping("/api/vaccines")
public class VaccineController {

	@Autowired
	VaccineService vaccineService;
	
	@GetMapping("/availability")
	public ResponseEntity<?> checkAvailability(@RequestParam("availability_date") String availabilityDate,
			@RequestParam("patient_name") String patientName) throws IOException, ParseException {

		String response = this.vaccineService.checkAvailability(availabilityDate, patientName);
		return ResponseEntity.ok(response);
		

	}

}
