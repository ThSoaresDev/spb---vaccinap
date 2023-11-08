package br.ufc.vaccinapp.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import br.ufc.vaccinapp.gateway.SUSGateway;

@Service
public class VaccineService {

	@Autowired
	SUSGateway susGateway;

	public String checkAvailability(String availabilityDate, String patientName)
			throws FileNotFoundException, IOException, ParseException {
		JSONObject jsonObject = this.susGateway.vaccineConsultation(availabilityDate);
		Long amount = (Long) jsonObject.get("amount");
		return amount > 0 ? "Sim! Estão disponíveis " + amount + " vacinas!" : "Nenhuma vacina disponível!";
	}

}
