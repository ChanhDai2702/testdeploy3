package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

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
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity(name = "dangkyhocphan")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DangKyLopHocPhan implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long madangkyhocphan;
	
	@Column(name = "ngaydangky")
	private Date ngaydangky;
	
	@Column(name = "trangthaisinhvienmonhoc",columnDefinition = "nvarchar(50) not null")
	private String trangthaisinhvienmonhoc;
	
	@Column(name = "trangthaihocphi",columnDefinition = "nvarchar(50) not null")
	private String trangthaihocphi;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sinhvien_id",nullable = false,foreignKey = @ForeignKey)
	private SinhVien sinhvien;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name ="lophocphan_id",nullable = false,foreignKey = @ForeignKey)
	@JsonBackReference
	private LopHocPhan dangkylophocphan;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="nienkhoa_id",nullable = true,foreignKey = @ForeignKey)
	private NienKhoa nienKhoaDK;
	
	public DangKyLopHocPhan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DangKyLopHocPhan(Long madangkyhocphan, Date ngaydangky, String trangthaisinhvienmonhoc,
			String trangthaihocphi, LopHocPhan dangkylophocphan) {
		super();
		this.madangkyhocphan = madangkyhocphan;
		this.ngaydangky = ngaydangky;
		this.trangthaisinhvienmonhoc = trangthaisinhvienmonhoc;
		this.trangthaihocphi = trangthaihocphi;
		this.dangkylophocphan = dangkylophocphan;
	}
	
	public DangKyLopHocPhan(Long madangkyhocphan, Date ngaydangky, String trangthaisinhvienmonhoc,
			String trangthaihocphi, SinhVien sinhvien, LopHocPhan dangkylophocphan) {
		super();
		this.madangkyhocphan = madangkyhocphan;
		this.ngaydangky = ngaydangky;
		this.trangthaisinhvienmonhoc = trangthaisinhvienmonhoc;
		this.trangthaihocphi = trangthaihocphi;
		this.sinhvien = sinhvien;
		this.dangkylophocphan = dangkylophocphan;
	}

	public Long getMadangkyhocphan() {
		return madangkyhocphan;
	}

	public void setMadangkyhocphan(Long madangkyhocphan) {
		this.madangkyhocphan = madangkyhocphan;
	}

	public Date getNgaydangky() {
		return ngaydangky;
	}

	public void setNgaydangky(Date ngaydangky) {
		this.ngaydangky = ngaydangky;
	}

	public String getTrangthaisinhvienmonhoc() {
		return trangthaisinhvienmonhoc;
	}

	public void setTrangthaisinhvienmonhoc(String trangthaisinhvienmonhoc) {
		this.trangthaisinhvienmonhoc = trangthaisinhvienmonhoc;
	}

	public String getTrangthaihocphi() {
		return trangthaihocphi;
	}

	public void setTrangthaihocphi(String trangthaihocphi) {
		this.trangthaihocphi = trangthaihocphi;
	}

	public SinhVien getSinhvien() {
		return sinhvien;
	}

	public void setSinhvien(SinhVien sinhvien) {
		this.sinhvien = sinhvien;
	}

	public LopHocPhan getDangkylophocphan() {
		return dangkylophocphan;
	}

	public void setDangkylophocphan(LopHocPhan dangkylophocphan) {
		this.dangkylophocphan = dangkylophocphan;
	}

	public NienKhoa getNienKhoaDK() {
		return nienKhoaDK;
	}

	public void setNienKhoaDK(NienKhoa nienKhoaDK) {
		this.nienKhoaDK = nienKhoaDK;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "DangKyLopHocPhan [madangkyhocphan=" + madangkyhocphan + ", ngaydangky=" + ngaydangky
				+ ", trangthaisinhvienmonhoc=" + trangthaisinhvienmonhoc + ", trangthaihocphi=" + trangthaihocphi
				+ ", sinhvien=" + sinhvien + ", dangkylophocphan=" + dangkylophocphan + "]";
	}
	
	
	
}
