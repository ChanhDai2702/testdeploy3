package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity(name = "chuyennganh")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "manganh")
public class ChuyenNganh implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "manganh")
	private Long manganh;
	
	@Column(name = "tennganh",columnDefinition = "nvarchar(50)")
	private String tennganh;
	
	@Column(name = "sotinchi")
	private int sotinchi;
	
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "khoa_id", nullable = false,foreignKey = @ForeignKey)

	private Khoa khoa;
	
	@OneToMany(mappedBy = "chuyenNganh",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonManagedReference(value = "chuyennganh-lophoc")
	private List<LopHoc> dslopHoc;
	
	@OneToMany(mappedBy = "chuyenNganh",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonManagedReference(value = "chuyennganh-giangvien")
	private List<GiangVien> dsGiangVien;


	public ChuyenNganh() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChuyenNganh(Long manganh, String tennganh, int sotinchi) {
		super();
		this.manganh = manganh;
		this.tennganh = tennganh;
		this.sotinchi = sotinchi;
	}

	public Long getManganh() {
		return manganh;
	}

	public void setManganh(Long manganh) {
		this.manganh = manganh;
	}

	public String getTennganh() {
		return tennganh;
	}

	public void setTennganh(String tennganh) {
		this.tennganh = tennganh;
	}

	public int getSotinchi() {
		return sotinchi;
	}

	public void setSotinchi(int sotinchi) {
		this.sotinchi = sotinchi;
	}

	public Khoa getKhoa() {
		return khoa;
	}

	public void setKhoa(Khoa khoa) {
		this.khoa = khoa;
	}

	public List<LopHoc> getDslopHoc() {
		return dslopHoc;
	}

	public void setDslopHoc(List<LopHoc> dslopHoc) {
		this.dslopHoc = dslopHoc;
	}

	public List<GiangVien> getDsGiangVien() {
		return dsGiangVien;
	}

	public void setDsGiangVien(List<GiangVien> dsGiangVien) {
		this.dsGiangVien = dsGiangVien;
	}

	@Override
	public String toString() {
		return "ChuyenNganh [manganh=" + manganh + ", tennganh=" + tennganh + ", sotinchi=" + sotinchi + ", khoa="
				+ khoa + ", dslopHoc=" + dslopHoc + ", dsGiangVien=" + dsGiangVien + "]";
	}
	
	
	

}
