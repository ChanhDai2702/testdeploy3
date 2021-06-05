package com.example.demo.model;

import java.io.Serializable;


import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name = "giangvien")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class GiangVien implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@Column(name = "magiangvien")
	private Long magv;
	
	@Column(name = "tengiangvien",columnDefinition = "nvarchar(225) not null")
	private String tengv;
	
	@Column(name = "gioitinh",columnDefinition = "nvarchar(50) not null")
	private String gioitinh;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ngaysinh", columnDefinition = "DATETIME NOT NULL default '1900-01-01T00:00:00.000'")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngaysinh;
	
	@Column(name = "hocvi",columnDefinition = "nvarchar(225) not null")
	private String hocvi;
	
	@Column(name = "diachi",columnDefinition = "nvarchar(225)")
	private String diachi;
	
	@Column(name = "sodienthoai",columnDefinition = "text")
	private String sdt;
	
	@Column(name = "email",columnDefinition = "text")
	private String email;
	
	@Column(name = "chucvu",columnDefinition = "nvarchar(50)")
	private String chucvu;
	
	@Column(name = "trangthai",columnDefinition = "nvarchar(50) not null")
	private String trangThai;
	
	@Column(name = "hinhanh",columnDefinition = "text")
	private String hinhanh;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "taikhoan", nullable = false)
	@JsonBackReference(value = "taikhoan-giangvien")
	private TaiKhoan taiKhoan;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "chuyennganh_id", nullable = false,foreignKey = @ForeignKey)
	@JsonBackReference(value = "chuyennganh-giangvien")
	private ChuyenNganh chuyenNganh;
	
	@OneToMany(mappedBy = "giangVien",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonBackReference
	private List<LopHocPhan> dsLopHocPhan;


	public GiangVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GiangVien(Long magv, String tengv, String gioitinh, Date ngaysinh, String hocvi, String diachi, String sdt,
			String email, String chucvu, String trangThai, String hinhanh) {
		super();
		this.magv = magv;
		this.tengv = tengv;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
		this.hocvi = hocvi;
		this.diachi = diachi;
		this.sdt = sdt;
		this.email = email;
		this.chucvu = chucvu;
		this.trangThai = trangThai;
		this.hinhanh = hinhanh;
	}

	public Long getMagv() {
		return magv;
	}

	public void setMagv(Long magv) {
		this.magv = magv;
	}

	public String getTengv() {
		return tengv;
	}

	public void setTengv(String tengv) {
		this.tengv = tengv;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public String getHocvi() {
		return hocvi;
	}

	public void setHocvi(String hocvi) {
		this.hocvi = hocvi;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getChucvu() {
		return chucvu;
	}

	public void setChucvu(String chucvu) {
		this.chucvu = chucvu;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}

	public String getHinhanh() {
		return hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public ChuyenNganh getChuyenNganh() {
		return chuyenNganh;
	}

	public void setChuyenNganh(ChuyenNganh chuyenNganh) {
		this.chuyenNganh = chuyenNganh;
	}

	public List<LopHocPhan> getDsLopHocPhan() {
		return dsLopHocPhan;
	}

	public void setDsLopHocPhan(List<LopHocPhan> dsLopHocPhan) {
		this.dsLopHocPhan = dsLopHocPhan;
	}

	@Override
	public String toString() {
		return "GiangVien [magv=" + magv + ", tengv=" + tengv + ", gioitinh=" + gioitinh + ", ngaysinh=" + ngaysinh
				+ ", hocvi=" + hocvi + ", diachi=" + diachi + ", sdt=" + sdt + ", email=" + email + ", chucvu=" + chucvu
				+ ", trangThai=" + trangThai + ", hinhanh=" + hinhanh + ", taiKhoan=" + taiKhoan + ", chuyenNganh="
				+ chuyenNganh + ", dsLopHocPhan=" + dsLopHocPhan + "]";
	}
	
	
}
