package com.example.demo.factories;

import com.example.demo.interfaces.GeometricFigure;

public class Square implements GeometricFigure {
	private Double width;
	private String type;
	public Square(double width) {
		this.width=width;
		this.type="Square";
	}
	@Override
	public Double getSurface() {
		return 4*this.width;
	}

	@Override
	public Double getBase() {
		return null;
	}

	@Override
	public Double getHeight() {
		return this.width;
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
