package com.example.demo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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



import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity(name = "monhoc")


@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MonHoc implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name = "mamonhoc")
	private Long mamonhoc;
	
	@Column(name = "tenmonhoc",columnDefinition = "nvarchar(50) not null")
	private String tenmon;
	
	@Column(name = "trangthai",columnDefinition = "nvarchar(50) not null")
	private String trangthai;
	
	@Column(name = "sotinchi")
	private int sotinchi;
	
	@OneToOne
	@JoinColumn(name = "montienquyet_id",nullable = true)
	@JsonBackReference
	private MonHoc monhoc;
	
//	@ManyToOne(fetch =FetchType.EAGER)
//	@Column(name = "monhoctienquyet",nullable = true	)
//	private MonHoc monhoctienquyet;	
	


	@OneToMany(mappedBy = "monhoc",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonManagedReference
	private Set<MonHoc> dsMonHoc = new HashSet<>();
//	
//	private MonHoc monHoc;
	
//	@ManyToOne(fetch =FetchType.EAGER)
//	@JoinColumn(name = "chuyennganh_mon",nullable = false, foreignKey = @ForeignKey)
//	private ChuyenNganh chuyenNganh;

//	@OneToMany(mappedBy = "monHoc",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
//	private List<LopHocPhan> lopHocPhans;
	
	@OneToMany(mappedBy = "monHoc",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<LopHocPhan> dsLopHocPhan;
	
	@OneToMany(mappedBy = "monHoc",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JsonManagedReference
	private List<BangDiem> bangDiems;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "hocky_id",nullable = true,foreignKey = @ForeignKey)
	private HocKy hocky;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="chuyennganh_id",nullable = true,foreignKey = @ForeignKey)
	private ChuyenNganh chuyenNganh;
	
	public MonHoc getMonhoc() {
		return monhoc;
	}

	public void setMonhoc(MonHoc monhoc) {
		this.monhoc = monhoc;
	}

	public Set<MonHoc> getDsMonHoc() {
		return dsMonHoc;
	}

	public void setDsMonHoc(Set<MonHoc> dsMonHoc) {
		this.dsMonHoc = dsMonHoc;
	}
	
	public List<LopHocPhan> getDsLopHocPhan() {
		return dsLopHocPhan;
	}

	public void setDsLopHocPhan(List<LopHocPhan> dsLopHocPhan) {
		this.dsLopHocPhan = dsLopHocPhan;
	}

	public List<BangDiem> getBangDiems() {
		return bangDiems;
	}

	public void setBangDiems(List<BangDiem> bangDiems) {
		this.bangDiems = bangDiems;
	}

	public Long getMamonhoc() {
		return mamonhoc;
	}

	public MonHoc(Long mamonhoc, String tenmon, String trangthai, int sotinchi) {
	super();
	this.mamonhoc = mamonhoc;
	this.tenmon = tenmon;
	this.trangthai = trangthai;
	this.sotinchi = sotinchi;
}

	public MonHoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setMamonhoc(Long mamonhoc) {
		this.mamonhoc = mamonhoc;
	}

	public String getTenmon() {
		return tenmon;
	}

	public void setTenmon(String tenmon) {
		this.tenmon = tenmon;
	}

	public String getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

	public int getSotinchi() {
		return sotinchi;
	}

	public void setSotinchi(int sotinchi) {
		this.sotinchi = sotinchi;
	}

	
	

	
	
}
