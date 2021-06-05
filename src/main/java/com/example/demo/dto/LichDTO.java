package com.example.demo.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class LichDTO {
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ngay;

	public LichDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LichDTO(Date ngay) {
		super();
		this.ngay = ngay;
	}

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}

	@Override
	public String toString() {
		return "LichDTO [ngay=" + ngay + "]";
	}
	
	
}
