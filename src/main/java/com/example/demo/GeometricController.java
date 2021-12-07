package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.daos.GeometricFigureRepository;
import com.example.demo.entities.GeometricFigureEntity;
import com.example.demo.enums.Type;
import com.example.demo.factories.GeometricFigureFactory;
import com.example.demo.interfaces.GeometricFigure;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GeometricController {
	List<GeometricFigure> figures=new ArrayList<GeometricFigure>();
	static GeometricFigureFactory geometricFigureFactoryInstance= new GeometricFigureFactory();
	@Autowired
	private GeometricFigureRepository figuresRepository;
	
	@GetMapping("/geometric/all")
	public List<GeometricFigureEntity> getFigures(){
		return (List<GeometricFigureEntity>) figuresRepository.findAll();
	}
	
	@PostMapping("/geometric/add")
	public GeometricFigure geometricAdd(@RequestBody GeometricFigureEntity body) {
		GeometricFigure figure = null ;
		System.out.println(body.getType());
		/*if(body.getType().toLowerCase().equalsIgnoreCase("circle")) {
			figure=new GeometricFigureFactory().setRadius(body.getRadius()).createFigure(Type.CIRCLE);
		}*/
		switch (body.getType().toLowerCase()) {
		case "circle":
			figure = geometricFigureFactoryInstance.setRadius(body.getRadius()).createFigure(Type.CIRCLE);
			body.setDiameter(figure.getDiameter());
			break;
		case "triangle":
			figure = geometricFigureFactoryInstance.setBase(body.getBase()).setHeight(body.getHeight()).createFigure(Type.TRIANGLE);
			body.setSurface(figure.getSurface());
			break;
		case "square":
			figure = geometricFigureFactoryInstance.setWidth(body.getWidth()).createFigure(Type.SQUARE);
			body.setSurface(figure.getSurface());
			break;
		}
		figuresRepository.save(body);
		return figure;
	}
	@PutMapping("/geometric/update/{id}")
	public ResponseEntity update(@PathVariable("id") long id, @RequestBody GeometricFigureEntity body) {
		GeometricFigureEntity newData= new GeometricFigureEntity();
		GeometricFigure figure = null ;
		String type = body.getType().toLowerCase();
		if(type.equals("circle")) {
			figure = geometricFigureFactoryInstance.setRadius(body.getRadius()).createFigure(Type.CIRCLE);
			newData.setDiameter(figure.getDiameter());
			newData.setRadius(body.getRadius());
			
		}else if(type.equals("square")) {
			figure = geometricFigureFactoryInstance.setWidth(body.getWidth()).createFigure(Type.SQUARE);
			newData.setSurface(figure.getSurface());
			newData.setWidth(body.getWidth());
			
		}else if(type.equals("triangle")) {
			figure = geometricFigureFactoryInstance.setBase(body.getBase()).setHeight(body.getHeight()).createFigure(Type.TRIANGLE);
			newData.setBase(body.getBase());
			newData.setHeight(body.getHeight());
			newData.setSurface(figure.getSurface());
		}
		newData.setType(type);
		newData.setId(body.getId());
		if(figuresRepository.save(newData) != null) {
			return ResponseEntity.status(HttpStatus.OK).body(newData);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	@GetMapping("/geometric/{id}")
	public ResponseEntity getById(@PathVariable("id") long id) {
		
		Optional<GeometricFigureEntity> tempFigure = figuresRepository.findById(id);
		
		if(tempFigure != null) {
			return ResponseEntity.status(HttpStatus.OK).body(tempFigure);
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}		
	}
	@DeleteMapping("/geometric/delete/{id}")
	public ResponseEntity remove(@PathVariable Long id) {
		figuresRepository.deleteById(id);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
}

