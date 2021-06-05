package com.example.demo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.dto.LichDTO;
import com.example.demo.dto.NgayTrongTuanDTO;
import com.example.demo.service.SinhVienService;
import com.example.demo.service.impl.SinhVienImpl;

public class Test {
	
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		LocalDate localDate = LocalDate.now();
		
	
		Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		System.out.println(date);
		
		LichDTO lichDTO = new LichDTO();
		lichDTO.setNgay(new Date());
		
		
		System.out.println(lichDTO);
	}
	
}
