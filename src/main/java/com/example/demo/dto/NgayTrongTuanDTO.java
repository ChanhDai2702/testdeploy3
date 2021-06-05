package com.example.demo.dto;

public class NgayTrongTuanDTO {
	private String Thu;
	private String Ngay;
	public NgayTrongTuanDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NgayTrongTuanDTO(String thu, String ngay) {
		super();
		Thu = thu;
		Ngay = ngay;
	}
	public String getThu() {
		return Thu;
	}
	public void setThu(String thu) {
		Thu = thu;
	}
	public String getNgay() {
		return Ngay;
	}
	public void setNgay(String ngay) {
		Ngay = ngay;
	}
	@Override
	public String toString() {
		return "NgayTrongTuanDTO [Thu=" + Thu + ", Ngay=" + Ngay + "]";
	}
	
	
}
