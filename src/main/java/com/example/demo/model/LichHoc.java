package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity(name = "lichhoc")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class LichHoc implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mathoigianhoc;
	
	@Column(name = "ngayhoc")
	private Date ngayhoc;
	@Column(name="ngayhoctrongtuan")
	private int ngayhoctrongtuan;

	@Column(name = "tiethocbatdau")
	private int tiethocbatdau;
	
	@Column(name = "tiethocketthuc")
	private int tiethocketthuc;
	@Column(name = "loailich",columnDefinition = "nvarchar(225)")
	private String loailich;
	
	@Column(name = "trangthai",columnDefinition = "nvarchar(225)")
	private String trangthai;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lophocphan_id",nullable = false,foreignKey = @ForeignKey)
	@JsonBackReference
	private LopHocPhan lophocPhan;
	
//	@OneToMany(mappedBy = "thoigianhoc",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	private List<LopHocPhan> lophocphan;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "phong_id",nullable = true,foreignKey = @ForeignKey)
	@JsonBackReference
	private Phong phong;

	public String getLoailich() {
		return loailich;
	}
	public void setLoailich(String loailich) {
		this.loailich = loailich;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}
	public Phong getPhong() {
		return phong;
	}
	public void setPhong(Phong phong) {
		this.phong = phong;
	}
	public LichHoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNgayhoctrongtuan() {
		return ngayhoctrongtuan;
	}

	public void setNgayhoctrongtuan(int ngayhoctrongtuan) {
		this.ngayhoctrongtuan = ngayhoc.getDay();
	}
	public LichHoc(Long mathoigianhoc, Date ngayhoc, int tiethocbatdau, int tiethocketthuc) {
		super();
		this.mathoigianhoc = mathoigianhoc;
		this.ngayhoc = ngayhoc;
		this.tiethocbatdau = tiethocbatdau;
		this.tiethocketthuc = tiethocketthuc;
	}

	public Long getMathoigianhoc() {
		return mathoigianhoc;
	}

	public void setMathoigianhoc(Long mathoigianhoc) {
		this.mathoigianhoc = mathoigianhoc;
	}

	public Date getNgayhoc() {
		return ngayhoc;
	}

	public void setNgayhoc(Date ngayhoc) {
		this.ngayhoc = ngayhoc;
	}

	public int getTiethocbatdau() {
		return tiethocbatdau;
	}

	public void setTiethocbatdau(int tiethocbatdau) {
		this.tiethocbatdau = tiethocbatdau;
	}

	public int getTiethocketthuc() {
		return tiethocketthuc;
	}

	public void setTiethocketthuc(int tiethocketthuc) {
		this.tiethocketthuc = tiethocketthuc;
	}

	public LopHocPhan getLophocPhan() {
		return lophocPhan;
	}

	public void setLophocPhan(LopHocPhan lophocPhan) {
		this.lophocPhan = lophocPhan;
	}
	@Override
	public String toString() {
		return "LichHoc [mathoigianhoc=" + mathoigianhoc + ", ngayhoc=" + ngayhoc + ", ngayhoctrongtuan="
				+ ngayhoctrongtuan + ", tiethocbatdau=" + tiethocbatdau + ", tiethocketthuc=" + tiethocketthuc
				+ ", loailich=" + loailich + ", trangthai=" + trangthai + ", lophocPhan=" + lophocPhan + ", phong="
				+ phong + "]";
	}



	
	
}
