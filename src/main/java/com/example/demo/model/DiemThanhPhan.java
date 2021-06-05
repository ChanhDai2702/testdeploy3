package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name = "diemthanhphan")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "mamonhoc")
public class DiemThanhPhan implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long machitietdiem;
	private String tendiem;
	private float diem;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bangdiem",nullable = false,foreignKey = @ForeignKey)

	private BangDiem  bangDiem;

	public DiemThanhPhan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DiemThanhPhan(Long machitietdiem, String tendiem, float diem) {
		super();
		this.machitietdiem = machitietdiem;
		this.tendiem = tendiem;
		this.diem = diem;
	}

	public Long getMachitietdiem() {
		return machitietdiem;
	}

	public void setMachitietdiem(Long machitietdiem) {
		this.machitietdiem = machitietdiem;
	}

	public String getTendiem() {
		return tendiem;
	}

	public void setTendiem(String tendiem) {
		this.tendiem = tendiem;
	}

	public float getDiem() {
		return diem;
	}

	public void setDiem(float diem) {
		this.diem = diem;
	}

	public BangDiem getBangDiem() {
		return bangDiem;
	}

	public void setBangDiem(BangDiem bangDiem) {
		this.bangDiem = bangDiem;
	}

	@Override
	public String toString() {
		return "DiemThanhPhan [machitietdiem=" + machitietdiem + ", tendiem=" + tendiem + ", diem=" + diem
				+ ", bangDiem=" + bangDiem + "]";
	}
	
	
}
