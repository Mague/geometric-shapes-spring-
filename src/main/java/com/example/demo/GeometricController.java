package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.GeometricFigureEntity;
import com.example.demo.enums.Type;
import com.example.demo.factories.GeometricFigureFactory;
import com.example.demo.interfaces.GeometricFigure;
import com.example.demo.repositories.GeometricFigureRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GeometricController {
	List<GeometricFigure> figures=new ArrayList<GeometricFigure>();
	
	@Autowired
	private GeometricFigureRepository figuresRepository;
	
	@GetMapping("/geometric/all")
	public List<GeometricFigureEntity> getFigures(){
		return (List<GeometricFigureEntity>) figuresRepository.findAll();
	}
	
	@PostMapping("/geometric/add")
	public GeometricFigure geometricAdd(@RequestBody GeometricFigureEntity body) {
		GeometricFigure figure = null;
		System.out.println(body.getType());
		/*if(body.getType().toLowerCase().equalsIgnoreCase("circle")) {
			figure=new GeometricFigureFactory().setRadius(body.getRadius()).createFigure(Type.CIRCLE);
		}*/
		switch (body.getType().toLowerCase()) {
		case "circle":
			figure = new GeometricFigureFactory().setRadius(body.getRadius()).createFigure(Type.CIRCLE);
			break;
		case "triangle":
			figure = new GeometricFigureFactory().setBase(body.getBase()).setHeight(body.getBase()).createFigure(Type.TRIANGLE);
			break;
		case "square":
			figure = new GeometricFigureFactory().setWidth(body.getWidth()).createFigure(Type.SQUARE);
			break;
		}
		figuresRepository.save(body);
		//figures.add(figure);
		return figure;

		//return ResponseEntity.ok(HttpStatus.OK);
	}
	@DeleteMapping("/geometric/delete")
	public ResponseEntity remove(@RequestParam Long id) {
		figuresRepository.deleteById(id);
		return ResponseEntity.ok(HttpStatus.OK);
	}
}

