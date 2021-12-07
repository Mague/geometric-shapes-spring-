package com.example.demo.factories;
import  com.example.demo.interfaces.GeometricFigure;

public class Circle implements GeometricFigure  {
	private final double radius;
	private final String type;
	public Circle(double radius) {
		this.type="Circle";
		this.radius=radius;
	}
	//superficie; base; altura; diámetro
	@Override
	public Double getSurface() {
		return Math.PI*(this.radius*this.radius);
	}

	@Override
	public Double getBase() {
		return null;
	}

	@Override
	public Double getHeight() {
		return null;
	}

	@Override
	public Double getDiameter() {
		return (this.radius*this.radius);
	}

	@Override
	public String getTypeOfGeometricFigure() {
		return this.type;
	}
	
	public double getRadius() {
		return radius;
	}
	public String getType() {
		return type;
	}
}
