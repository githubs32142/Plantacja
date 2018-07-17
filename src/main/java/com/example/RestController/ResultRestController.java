package com.example.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Employee;
import com.example.model.Field;
import com.example.model.RestResult;
import com.example.model.Result;
import com.example.model.Tariff;
import com.example.service.EmployeeService;
import com.example.service.FieldService;
import com.example.service.ResultService;
import com.example.service.TariffService;

@RestController
@RequestMapping(value="/api/")
public class ResultRestController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	TariffService tariffService;
	
	@Autowired
	FieldService fieldService;

	@Autowired
	ResultService resultService;
	
	@RequestMapping(value="add/{idEmployee}/field/{idField}/tariff/{idTariff}",
			 method=RequestMethod.POST)
	public String save(@RequestBody Result result,@PathVariable("idEmployee") int idEmployee,
			@PathVariable("idField") int idField, @PathVariable("idTariff") int idTariff	) {
		Employee employee=employeeService.getById(idEmployee);
		Tariff tariff=tariffService.findOne(idTariff);
		Field field = fieldService.findOneById(idField);
		result.setTariff(tariff);
		result.setField(field);
		result.getEmployees().add(employee);
		result.setId(resultService.getMaxId()+1);
	    resultService.save(result,field,tariff);
	    employee.getResults().add(result);
		employeeService.save(employee);
		return "ok";
	}
	@RequestMapping(value = "getResult/startDate/{startDate}/endDate/{endDate}",
			method=RequestMethod.GET,
			produces= {MimeTypeUtils.APPLICATION_JSON_VALUE}
			)
	public ResponseEntity<List<RestResult>> getResource(@PathVariable("startDate") String startDate,@PathVariable("endDate") String endDate) {
		System.out.println(startDate.toString());
		System.out.println(endDate.toString());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date starD=formatter.parse(startDate);
			Date endD=formatter.parse(endDate);
			List<RestResult> restResult = new ArrayList<>();
			List<Result> list=resultService.findResultBetween(starD, endD);
			list.stream().forEach((t)->{
				t.getEmployees().forEach((f)->{
					restResult.add(new RestResult(t.getId(),
							f.getName(),
							f.getSurName(),
							t.getTariff().getNameTariff(),
							t.getField().getfieldName(),
							t.getTariff().getRate(),
							t.getAmount(),
							f.getId()));
				});
			});
			//System.out.println(list.get(0).getEmployees().size());
			ResponseEntity<List<RestResult>> re = new ResponseEntity<>(restResult,HttpStatus.OK);
			return re;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
}
