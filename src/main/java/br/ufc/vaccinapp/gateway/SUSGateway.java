package br.ufc.vaccinapp.gateway;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

@Component
public class SUSGateway {

	public JSONObject vaccineConsultation(String availabilityDate)
			throws FileNotFoundException, IOException, ParseException {

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(new ClassPathResource("vaccines.json").getFile()));
		JSONArray jsonArray = (JSONArray) obj;
		for (Object object : jsonArray) {
			JSONObject jsonObject = (JSONObject) object;
			String date = (String) jsonObject.get("date");
			if (date.equals(availabilityDate)) {
				return jsonObject;
			}
		}
		return null;
	}
}
