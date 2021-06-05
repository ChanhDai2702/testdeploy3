package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.BangDiem;

public class DiemDTO {
	private String hocky;
	
	private String nienkhoa;
	
	private float dtb_10;
	
	private float dtb_4;
	
	
	private List<BangDiem> dsBangDiems;

	public DiemDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DiemDTO(String hocky, String nienkhoa, List<BangDiem> dsBangDiems) {
		super();
		this.hocky = hocky;
		this.nienkhoa = nienkhoa;
		this.dsBangDiems = dsBangDiems;
	}
	
	public float getDtb_10() {
		return dtb_10;
	}

	public void setDtb_10(float dtb_10) {
		this.dtb_10 = dtb_10;
	}
	public String getHocky() {
		return hocky;
	}

	public void setHocky(String hocky) {
		this.hocky = hocky;
	}

	public String getNienkhoa() {
		return nienkhoa;
	}

	public void setNienkhoa(String nienkhoa) {
		this.nienkhoa = nienkhoa;
	}

	public List<BangDiem> getDsBangDiems() {
		return dsBangDiems;
	}

	public void setDsBangDiems(List<BangDiem> dsBangDiems) {
		this.dsBangDiems = dsBangDiems;
	}
	

	public float getDtb_4() {
		return dtb_4;
	}

	public void setDtb_4(float dtb_4) {
		this.dtb_4 = dtb_4;
	}

	@Override
	public String toString() {
		return "DiemDTO [hocky=" + hocky + ", nienkhoa=" + nienkhoa + ", dtb_10=" + dtb_10 + ", dtb_4=" + dtb_4
				+ ", dsBangDiems=" + dsBangDiems + "]";
	}

	
}
