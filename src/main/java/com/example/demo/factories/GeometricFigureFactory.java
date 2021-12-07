package com.example.demo.factories;

import com.example.demo.enums.Type;
import com.example.demo.interfaces.GeometricFigure;

public class GeometricFigureFactory {
	private double width,height,base,radius;
	public GeometricFigure createFigure(Type type) {
		GeometricFigure figure=null;
		switch (type) {
		case CIRCLE:
			figure = new Circle(this.radius);
			break;
		case TRIANGLE:
			figure = new Triangle(this.base,this.height);
			break;
		case SQUARE:
			figure = new Square(this.width);
			break;
		}
		return figure;
	}
	public GeometricFigureFactory setWidth(double width) {
		this.width=width;
		return this;
	}
	
	public GeometricFigureFactory setHeight(double height) {
		this.height=height;
		return this;
	}
	public GeometricFigureFactory setBase(double base) {
		this.base=base;
		return this;
	}
	
	public GeometricFigureFactory setRadius(double radius) {
		this.radius=radius;
		return this;
	}
}
