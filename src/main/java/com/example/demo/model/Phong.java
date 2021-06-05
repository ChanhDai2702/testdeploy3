package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "phong")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Phong implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maphonghoc;
	
	@Column(name = "tenphonghoc",columnDefinition = "nvarchar(225) not null")
	private String tenphonghoc;
	
	@Column(name = "toanha",columnDefinition = "nvarchar(50) not null")
	private String toanha;
	
	@Column(name = "trangthai",columnDefinition = "nvarchar(50) not null")
	private String trangthai;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lichthi_id",nullable = true,foreignKey = @ForeignKey)
	@JsonBackReference
	private LichThi lichThi;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lichhoc_id",nullable = true,foreignKey = @ForeignKey)
	@JsonBackReference
	private LichHoc lichHoc;

	public Phong() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Phong(Long maphonghoc, String tenphonghoc, String toanha, String trangthai) {
		super();
		this.maphonghoc = maphonghoc;
		this.tenphonghoc = tenphonghoc;
		this.toanha = toanha;
		this.trangthai = trangthai;
	}

	public Long getMaphonghoc() {
		return maphonghoc;
	}

	public void setMaphonghoc(Long maphonghoc) {
		this.maphonghoc = maphonghoc;
	}

	public String getTenphonghoc() {
		return tenphonghoc;
	}

	public void setTenphonghoc(String tenphonghoc) {
		this.tenphonghoc = tenphonghoc;
	}

	public String getToanha() {
		return toanha;
	}

	public void setToanha(String toanha) {
		this.toanha = toanha;
	}

	public String getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

	public LichThi getLichThi() {
		return lichThi;
	}

	public void setLichThi(LichThi lichThi) {
		this.lichThi = lichThi;
	}

	public LichHoc getLichHoc() {
		return lichHoc;
	}

	public void setLichHoc(LichHoc lichHoc) {
		this.lichHoc = lichHoc;
	}

	@Override
	public String toString() {
		return "Phong [maphonghoc=" + maphonghoc + ", tenphonghoc=" + tenphonghoc + ", toanha=" + toanha
				+ ", trangthai=" + trangthai + ", lichThi=" + lichThi + ", lichHoc=" + lichHoc + "]";
	}

	
	
}
