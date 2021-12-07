package com.example.demo.factories;

import com.example.demo.interfaces.GeometricFigure;

public class Triangle implements GeometricFigure {
	private double base;
	private double height;
	private String type;
	public Triangle(double base,double height) {
		this.base=base;
		this.height=height;
		this.type="Triangle";
	}
	@Override
	public Double getSurface() {
		return 0.5*this.base*this.height;
	}

	@Override
	public Double getBase() {
		return this.base;
	}

	@Override
	public Double getHeight() {
		return this.height;
	}

	@Override
	public Double getDiameter() {
		return null;
	}

	@Override
	public String getTypeOfGeometricFigure() {
		return this.type;
	}

}
