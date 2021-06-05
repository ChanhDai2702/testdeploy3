package com.example.demo.dto;

public class LichHocDTO {
	private String tenmon;
	private String tenlophp;
	private String malhp;
	private int tietbatdau;
	private int tietketthuc;
	private String tenGV;
	private String Phong;
	private String ngayhoc;
	private String loailich;
	private String trangthai;
	
	public LichHocDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LichHocDTO(String tenmon, String tenlophp, String malhp, int tietbatdau, int tietketthuc, String tenGV,
			String phong) {
		super();
		this.tenmon = tenmon;
		this.tenlophp = tenlophp;
		this.malhp = malhp;
		this.tietbatdau = tietbatdau;
		this.tietketthuc = tietketthuc;
		this.tenGV = tenGV;
		Phong = phong;
	}
	public String getTenmon() {
		return tenmon;
	}
	public void setTenmon(String tenmon) {
		this.tenmon = tenmon;
	}
	public String getTenlophp() {
		return tenlophp;
	}
	public void setTenlophp(String tenlophp) {
		this.tenlophp = tenlophp;
	}
	public String getMalhp() {
		return malhp;
	}
	public void setMalhp(String malhp) {
		this.malhp = malhp;
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
	public String getTenGV() {
		return tenGV;
	}
	public void setTenGV(String tenGV) {
		this.tenGV = tenGV;
	}
	public String getPhong() {
		return Phong;
	}
	public void setPhong(String phong) {
		Phong = phong;
	}
	
	public String getNgayhoc() {
		return ngayhoc;
	}
	public void setNgayhoc(String ngayhoc) {
		this.ngayhoc = ngayhoc;
	}
	
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
	@Override
	public String toString() {
		return "LichHocDTO [tenmon=" + tenmon + ", tenlophp=" + tenlophp + ", malhp=" + malhp + ", tietbatdau="
				+ tietbatdau + ", tietketthuc=" + tietketthuc + ", tenGV=" + tenGV + ", Phong=" + Phong + ", ngayhoc="
				+ ngayhoc + "]";
	}
	
	
}
