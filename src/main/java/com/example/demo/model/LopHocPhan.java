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
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.val;




@Entity(name = "lophocphan")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class LopHocPhan implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "malophocphan")
	private Long malophp;
	
	@Column(name = "tenlopocphan",columnDefinition = "nvarchar(225) not null")
	private String tenlophp;
	
	@Column(name = "siso",nullable = true)
	private int siso;
	
	@Column(name = "hocphi")
	private float hocphi;
	
	@Column(name = "trangthai",columnDefinition = "nvarchar(225) not null")
	private String trangthai;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="nienkhoa_id",nullable = true,foreignKey = @ForeignKey)
	@JsonBackReference
	private NienKhoa nienkhoa;
	
	@Column(name = "hocky",columnDefinition = "nvarchar(225) not null")
	private String hocky;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "monhoc_id",nullable = false,foreignKey = @ForeignKey)
	@JsonBackReference
	private MonHoc monHoc;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "giangvien_id",nullable = false,foreignKey = @ForeignKey)
	
	private GiangVien giangVien;
	
	@OneToMany(mappedBy = "lophocPhan",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<LichHoc> dsLichHoc;
	
	
	
	@OneToMany(mappedBy = "dangkylophocphan",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<DangKyLopHocPhan> dsDanKyLopHocPhans;
	
	public Long getMalophp() {
		return malophp;
	}
	public void setMalophp(Long malophp) {
		this.malophp = malophp;
	}
	public String getTenlophp() {
		return tenlophp;
	}
	public void setTenlophp(String tenlophp) {
		this.tenlophp = tenlophp;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	public MonHoc getMonHoc() {
		return monHoc;
	}
	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}
	public GiangVien getGiangvien() {
		return giangVien;
	}
	public void setGiangvien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}
	public int getSiso() {
		return siso;
	}
	public void setSiso(int siso) {
		this.siso = siso;
	}
	public LopHocPhan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LopHocPhan(Long malophp, String tenlophp, int siso, float hocphi, String trangthai, NienKhoa nienkhoa,
			String hocky) {
		super();
		this.malophp = malophp;
		this.tenlophp = tenlophp;
		this.siso = siso;
		this.hocphi = hocphi;
		this.trangthai = trangthai;
		this.nienkhoa = nienkhoa;
		this.hocky = hocky;
	}
	public float getHocphi() {
		return hocphi;
	}
	public void setHocphi(float hocphi) {
		this.hocphi = hocphi;
	}
	public NienKhoa getNienkhoa() {
		return nienkhoa;
	}
	public void setNienkhoa(NienKhoa nienkhoa) {
		this.nienkhoa = nienkhoa;
	}
	public String getHocky() {
		return hocky;
	}
	public void setHocky(String hocky) {
		this.hocky = hocky;
	}
	public GiangVien getGiangVien() {
		return giangVien;
	}
	public void setGiangVien(GiangVien giangVien) {
		this.giangVien = giangVien;
	}
	public List<LichHoc> getDsLichHoc() {
		return dsLichHoc;
	}
	public void setDsLichHoc(List<LichHoc> dsLichHoc) {
		this.dsLichHoc = dsLichHoc;
	}
	public List<DangKyLopHocPhan> getDsDanKyLopHocPhans() {
		return dsDanKyLopHocPhans;
	}
	public void setDsDanKyLopHocPhans(List<DangKyLopHocPhan> dsDanKyLopHocPhans) {
		this.dsDanKyLopHocPhans = dsDanKyLopHocPhans;
	}
	
	
	
	
//	@OneToMany(mappedBy = "dangkylophocphan",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	private List<DangKyLopHocPhan> dangKyLopHocPhans;
}
