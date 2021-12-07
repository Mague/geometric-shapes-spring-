package com.example.demo.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GeometricFigureEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	private Double width;
	private Double height;
	private Double base;
	private Double radius;
	private String type;
	
	/**
	 * @return the type
	 */
	public long getId() {
		return id;
	}
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the width
	 */
	public Double getWidth() {
		return width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(double width) {
		this.width = width;
	}
	/**
	 * @return the height
	 */
	public Double getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}
	/**
	 * @return the radius
	 */
	public Double getRadius() {
		return radius;
	}
	/**
	 * @param radius the radius to set
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}
	/**
	 * @return the base
	 */
	public Double getBase() {
		return base;
	}
	/**
	 * @param base the base to set
	 */
	public void setBase(double base) {
		this.base = base;
	}
}
