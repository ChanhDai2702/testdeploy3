package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity(name = "lichthi")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LichThi implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mathoigianthi;
	
	private Date ngayThi;
	private int tietbatdau;
	private int tietketthuc;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lophocphan_id",nullable = false,foreignKey = @ForeignKey)
	@JsonBackReference
	private LopHocPhan lophocPhan;
	
	@OneToMany(mappedBy = "lichHoc",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<Phong> lichHoc;

	public LichThi() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LichThi(Long mathoigianthi, Date ngayThi, int tietbatdau, int tietketthuc) {
		super();
		this.mathoigianthi = mathoigianthi;
		this.ngayThi = ngayThi;
		this.tietbatdau = tietbatdau;
		this.tietketthuc = tietketthuc;
	}

	public Long getMathoigianthi() {
		return mathoigianthi;
	}

	public void setMathoigianthi(Long mathoigianthi) {
		this.mathoigianthi = mathoigianthi;
	}

	public Date getNgayThi() {
		return ngayThi;
	}

	public void setNgayThi(Date ngayThi) {
		this.ngayThi = ngayThi;
	}

	public int getTietbatdau() {
		return tietbatdau;
	}

	public void setTietbatdau(int tietbatdau) {
		this.tietbatdau = tietbatdau;
	}

	public int getTietketthuc() {
		return tietketthuc;
	}

	public void setTietketthuc(int tietketthuc) {
		this.tietketthuc = tietketthuc;
	}

	public LopHocPhan getLophocPhan() {
		return lophocPhan;
	}

	public void setLophocPhan(LopHocPhan lophocPhan) {
		this.lophocPhan = lophocPhan;
	}

	public List<Phong> getLichHoc() {
		return lichHoc;
	}

	public void setLichHoc(List<Phong> lichHoc) {
		this.lichHoc = lichHoc;
	}

	@Override
	public String toString() {
		return "LichThi [mathoigianthi=" + mathoigianthi + ", ngayThi=" + ngayThi + ", tietbatdau=" + tietbatdau
				+ ", tietketthuc=" + tietketthuc + ", lophocPhan=" + lophocPhan + ", lichHoc=" + lichHoc + "]";
	}
	
}
