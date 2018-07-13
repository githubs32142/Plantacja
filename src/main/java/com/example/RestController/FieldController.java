package com.example.RestController;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Field;
import com.example.model.Tariff;
import com.example.service.FieldService;
import com.example.service.TariffService;



@RestController
@RequestMapping("/api/field")
public class FieldController {
	
	@Autowired
	FieldService service;
	@Autowired
	TariffService tService;
	
	@RequestMapping(value = "all/{allField}",
			method=RequestMethod.GET,
			produces= {MimeTypeUtils.APPLICATION_JSON_VALUE}
			)
	public ResponseEntity<List<Field>> getResource(@PathVariable("allField") long id) {
		try {
			List<Field> field =service.findByIdProvider(id);
			field.stream().forEach(new Consumer<Field>() {

				@Override
				public void accept(Field t) {
					t.setProvider(null);
					t.setTariffs(null);
				}
			});
			ResponseEntity<List<Field>> re = new ResponseEntity<>(field,HttpStatus.OK);
			return re;
		}catch(Exception ex){
			return new ResponseEntity<List<Field>>(HttpStatus.BAD_REQUEST);
		}
		
	}
	@RequestMapping(value = "delete/{idField}", method=RequestMethod.DELETE )
	public String deleteField(@PathVariable("idField") int id) {
				service.deleteField(id);
				String s= "OK";
				return s;
	
	}
	
	@RequestMapping(value = "deleteTariff/{idTariff}/field/{idField}", method=RequestMethod.DELETE )
	public String deleteTariff(@PathVariable("idTariff") int idTariff, @PathVariable("idField") long idField) {
		Field field= service.findOneById(idField);
		Tariff tariff= tService.findOne(idTariff);
		field.getTariffs().remove(tariff);
		service.save(field);
		//tService.delete(idTariff);
		String s= "OK";
			return s;
	
	}
	
	@RequestMapping(value = "add", method=RequestMethod.POST)
	public @ResponseBody String addFielldAndTariff(@RequestBody Tariff tariff, @RequestParam(value = "id") long id) {	
		tariff.setId((tService.getMaxId()+1));
		tService.save(tariff,service.findOneById(id));
		service.saveTarrif(tariff, id);	
		return "ok";
	
	}
	
	@RequestMapping(value = "/{idField}",
			method=RequestMethod.GET,
			produces= {MimeTypeUtils.APPLICATION_JSON_VALUE}
			)
	public ResponseEntity<List<Tariff>> getData (@PathVariable long idField) {
		List<Tariff> list =tService.getListTariff(idField);
	 list.stream().forEach(new Consumer<Tariff>() {
		 public void accept(Tariff t) {
			 t.setFields(null);
		 };
	});
		ResponseEntity<List<Tariff>> re = new ResponseEntity<>(list,HttpStatus.OK);
		return re;		
	}
	
	
}
