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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity(name = "sinhvien")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class SinhVien implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "masinhvien")
	private Long masv;
	
	@Column(name = "tensv",columnDefinition = "nvarchar(50) not null")
	private String tensv;
	
	@Column(name = "gioitinh",columnDefinition = "nvarchar(50) not null")
	private String gioitinh;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "ngaysinh", columnDefinition = "DATETIME NOT NULL default '1900-01-01T'")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngaysinh;
	
	@Column(name = "diachi",columnDefinition = "nvarchar(225)")
	private String diachi;
	
	@Column(name = "sodienthoai",columnDefinition = "text")
	private	String sdt;
	
	@Column(name = "email",columnDefinition = "text")
	private String email;
	
	@Column(name = "dantoc",columnDefinition = "nvarchar(50)")
	private String dantoc;
	
	@Column(name = "trangthai",columnDefinition = "nvarchar(50) not null")
	private String trangthai;
	
	@Column(name = "hinhanh",columnDefinition = "nvarchar(50)")
	private String hinhanh;
	
	@Column(name="tonghocphi", nullable = true)
	private double tonghocphi;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "taikhoan_SV", nullable = false)
	@JsonBackReference
	private TaiKhoan taiKhoan;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "lophoc_SV",nullable = false,foreignKey = @ForeignKey)
	@JsonBackReference
	private LopHoc lopHoc;
	
	@OneToMany(mappedBy = "sinhVien",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<BangDiem> dsBangDiem;
	
	public Long getMasv() {
		return masv;
	}
	public void setMasv(Long masv) {
		this.masv = masv;
	}
	public String getTensv() {
		return tensv;
	}
	public void setTensv(String tensv) {
		this.tensv = tensv;
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
	public String getDantoc() {
		return dantoc;
	}
	public void setDantoc(String dantoc) {
		this.dantoc = dantoc;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	public String getHinhanh() {
		return hinhanh;
	}
	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}
	public TaiKhoan getTaikhoans() {
		return taiKhoan;
	}
	public void setTaikhoans(TaiKhoan taikhoans) {
		this.taiKhoan = taikhoans;
	}
	public LopHoc getLopHoc() {
		return lopHoc;
	}
	public void setLopHoc(LopHoc lopHoc) {
		this.lopHoc = lopHoc;
	}
	public double getTonghocphi() {
		return tonghocphi;
	}
	public void setTonghocphi(double tonghocphi) {
		this.tonghocphi = tonghocphi;
	}
	
	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}
	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}
	public List<BangDiem> getDsBangDiem() {
		return dsBangDiem;
	}
	public void setDsBangDiem(List<BangDiem> dsBangDiem) {
		this.dsBangDiem = dsBangDiem;
	}
	public SinhVien(Long masv, String tensv, String gioitinh, Date ngaysinh, String diachi, String sdt, String email,
			String dantoc, String trangthai, String hinhanh, double tonghocphi) {
		super();
		this.masv = masv;
		this.tensv = tensv;
		this.gioitinh = gioitinh;
		this.ngaysinh = ngaysinh;
		this.diachi = diachi;
		this.sdt = sdt;
		this.email = email;
		this.dantoc = dantoc;
		this.trangthai = trangthai;
		this.hinhanh = hinhanh;
		this.tonghocphi = tonghocphi;
	}
	public SinhVien() {
		super();
		
	}
	@Override
	public String toString() {
		return "SinhVien [masv=" + masv + ", tensv=" + tensv + ", gioitinh=" + gioitinh + ", ngaysinh=" + ngaysinh
				+ ", diachi=" + diachi + ", sdt=" + sdt + ", email=" + email + ", dantoc=" + dantoc + ", trangthai="
				+ trangthai + ", hinhanh=" + hinhanh + ", tonghocphi=" + tonghocphi + ", taiKhoan=" + taiKhoan
				+ ", lopHoc=" + lopHoc + ", dsBangDiem=" + dsBangDiem + "]";
	}
	
	
}
