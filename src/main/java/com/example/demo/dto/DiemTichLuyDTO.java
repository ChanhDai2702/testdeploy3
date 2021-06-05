package com.example.demo.dto;

public class DiemTichLuyDTO {
	private  float dtl_10;
	private  float dtl_4;
	public DiemTichLuyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DiemTichLuyDTO(float dtl_10, float dtl_4) {
		super();
		this.dtl_10 = dtl_10;
		this.dtl_4 = dtl_4;
	}
	public float getDtl_10() {
		return dtl_10;
	}
	public void setDtl_10(float dtl_10) {
		this.dtl_10 = dtl_10;
	}
	public float getDtl_4() {
		return dtl_4;
	}
	public void setDtl_4(float dtl_4) {
		this.dtl_4 = dtl_4;
	}
	@Override
	public String toString() {
		return "DiemTichLuyDTO [dtl_10=" + dtl_10 + ", dtl_4=" + dtl_4 + "]";
	}
	
	
	
}
