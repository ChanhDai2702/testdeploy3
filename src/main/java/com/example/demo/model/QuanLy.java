package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "quanly")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class QuanLy implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "maquanly")
	private Long maql;
	
	@Column(name = "tenquanly",columnDefinition = "nvarchar(225) not null")
	private String tenql;
	@Column(name = "email",columnDefinition = "text")
	private String email;
	@Column(name = "sodienthoai",columnDefinition = "text")
	private String sdt;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "taikhoan_QL", nullable = false)
	@JsonBackReference
	private TaiKhoan taiKhoan;

	public QuanLy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuanLy(Long maql, String tenql, String email, String sdt) {
		super();
		this.maql = maql;
		this.tenql = tenql;
		this.email = email;
		this.sdt = sdt;
	}

	public Long getMaql() {
		return maql;
	}

	public void setMaql(Long maql) {
		this.maql = maql;
	}

	public String getTenql() {
		return tenql;
	}

	public void setTenql(String tenql) {
		this.tenql = tenql;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "QuanLy [maql=" + maql + ", tenql=" + tenql + ", email=" + email + ", sdt=" + sdt + ", taiKhoan="
				+ taiKhoan + "]";
	}
	
	
}
