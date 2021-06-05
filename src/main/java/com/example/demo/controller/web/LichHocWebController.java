package com.example.demo.controller.web;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.w3c.dom.ls.LSInput;

import com.example.demo.dto.LichHocDTO;
import com.example.demo.dto.NgayTrongTuanDTO;
import com.example.demo.model.LichHoc;
import com.example.demo.service.ThoiGianHocService;

@Controller
public class LichHocWebController {
	static int ngayxemlich = 0;
	static List<String> listThu = Arrays.asList("Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7", "Chủ nhật");

	@Autowired
	private ThoiGianHocService lichHocService;

	@GetMapping(value = "lichhoc")
	private String GetLH(Model model, Principal principal) throws Exception {
		ngayxemlich = 0;

		List<LichHocDTO> dsLichHocDTOs = new ArrayList<LichHocDTO>();

		// Định dạng lịch
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		/// Lấy lịch học từ DB
		List<LichHoc> dslh = lichHocService.getLichHocBySVID(17051131l);

		Date date = new Date();
		model.addAttribute("date", LocalDate.now());

		// Lấy lịch trong tuần
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DAY_OF_WEEK, ngayxemlich);
		List<String> days = new ArrayList<String>();
		int delta = -now.get(GregorianCalendar.DAY_OF_WEEK) + 2; // add 2 if your week start on monday

		now.add(Calendar.DAY_OF_MONTH, delta);
		List<NgayTrongTuanDTO> tuanDTOs = new ArrayList<NgayTrongTuanDTO>();
		for (int i = 0; i < 7; i++) {
			days.add(format.format(now.getTime()));
			now.add(Calendar.DAY_OF_MONTH, 1);
			NgayTrongTuanDTO dto = new NgayTrongTuanDTO();
			dto.setNgay(days.get(i));
			dto.setThu(listThu.get(i));
			tuanDTOs.add(dto);
		}

		for (int i = 0; i < dslh.size(); i++) {
			for (int j = 0; j < days.size(); j++) {
				if (days.get(j).equalsIgnoreCase(format.format(dslh.get(i).getNgayhoc()))) {
					LichHocDTO dto = new LichHocDTO();
					dto.setNgayhoc(days.get(j));
					dto.setTenmon(dslh.get(i).getLophocPhan().getMonHoc().getTenmon());
					dto.setTenlophp(dslh.get(i).getLophocPhan().getTenlophp());
					dto.setMalhp(String.valueOf(dslh.get(i).getLophocPhan().getMalophp()));
					dto.setTenGV(dslh.get(i).getLophocPhan().getGiangvien().getTengv());
					dto.setTietbatdau(dslh.get(i).getTiethocbatdau());
					dto.setTietketthuc(dslh.get(i).getTiethocketthuc());
					dsLichHocDTOs.add(dto);
				}
			}
		}

		model.addAttribute("ngaytrongtuan", tuanDTOs);
		model.addAttribute("lichhoc", dsLichHocDTOs);
		return "test";

	}

	@PostMapping(value = "ngay")
	private String test(Model model, HttpServletRequest request) {

		LocalDate localDate = LocalDate.parse(request.getParameter("ngay"));

		model.addAttribute("date", localDate);

		ngayxemlich = 0;

		List<LichHocDTO> dsLichHocDTOs = new ArrayList<LichHocDTO>();

		// Định dạng lịch
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		/// Lấy lịch học từ DB
		List<LichHoc> dslh = lichHocService.getLichHocBySVID(17051131l);

		Date date = new Date();
		ZoneId systemTimeZone = ZoneId.systemDefault();
		ZonedDateTime zonedDateTime = localDate.atStartOfDay(systemTimeZone);
		date = Date.from(zonedDateTime.toInstant());

		// Lấy lịch trong tuần
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.DAY_OF_WEEK,  -1);
		List<String> days = new ArrayList<String>();
		int delta = -now.get(GregorianCalendar.DAY_OF_WEEK) + 2; // add 2 if your week start on monday

		now.add(Calendar.DAY_OF_MONTH, delta);
		List<NgayTrongTuanDTO> tuanDTOs = new ArrayList<NgayTrongTuanDTO>();
		for (int i = 0; i < 7; i++) {
			days.add(format.format(now.getTime()));
			now.add(Calendar.DAY_OF_MONTH, 1);
			NgayTrongTuanDTO dto = new NgayTrongTuanDTO();
			dto.setNgay(days.get(i));
			dto.setThu(listThu.get(i));
			tuanDTOs.add(dto);
		}

		for (int i = 0; i < dslh.size(); i++) {
			for (int j = 0; j < days.size(); j++) {
				if (days.get(j).equalsIgnoreCase(format.format(dslh.get(i).getNgayhoc()))) {
					LichHocDTO dto = new LichHocDTO();
					dto.setNgayhoc(days.get(j));
					dto.setTenmon(dslh.get(i).getLophocPhan().getMonHoc().getTenmon());
					dto.setTenlophp(dslh.get(i).getLophocPhan().getTenlophp());
					dto.setMalhp(String.valueOf(dslh.get(i).getLophocPhan().getMalophp()));
					dto.setTenGV(dslh.get(i).getLophocPhan().getGiangvien().getTengv());
					dto.setTietbatdau(dslh.get(i).getTiethocbatdau());
					dto.setTietketthuc(dslh.get(i).getTiethocketthuc());
					dsLichHocDTOs.add(dto);
				}
			}
		}

		model.addAttribute("ngaytrongtuan", tuanDTOs);
		model.addAttribute("lichhoc", dsLichHocDTOs);

		return "test";

	}

	@GetMapping(value = "lui")
	private String GetLHLui(Model model, HttpServletRequest request) {
	

		// Định dạng lịch
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		ngayxemlich = ngayxemlich - 7;

		List<LichHocDTO> dsLichHocDTOs = new ArrayList<LichHocDTO>();

		/// Lấy lịch học từ DB
		List<LichHoc> dslh = lichHocService.getLichHocBySVID(17051131l);
		
		LocalDate localDateNgay = LocalDate.parse(request.getParameter("ngay"));
		Date date = new Date();
		ZoneId systemTimeZone = ZoneId.systemDefault();
		ZonedDateTime zonedDateTime = localDateNgay.atStartOfDay(systemTimeZone);
		date = Date.from(zonedDateTime.toInstant());

		// Lấy lịch trong tuần
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.DAY_OF_WEEK, ngayxemlich);
		List<String> days = new ArrayList<String>();
		int delta = -now.get(GregorianCalendar.DAY_OF_WEEK) + 2; // add 2 if your week start on monday

		now.add(Calendar.DAY_OF_MONTH, delta);
		List<NgayTrongTuanDTO> tuanDTOs = new ArrayList<NgayTrongTuanDTO>();
		for (int i = 0; i < 7; i++) {
			days.add(format.format(now.getTime()));
			now.add(Calendar.DAY_OF_MONTH, 1);
			NgayTrongTuanDTO dto = new NgayTrongTuanDTO();
			dto.setNgay(days.get(i));
			dto.setThu(listThu.get(i));
			tuanDTOs.add(dto);
		}

		for (int i = 0; i < dslh.size(); i++) {
			for (int j = 0; j < days.size(); j++) {
				if (days.get(j).equalsIgnoreCase(format.format(dslh.get(i).getNgayhoc()))) {
					LichHocDTO dto = new LichHocDTO();
					dto.setNgayhoc(days.get(j));
					dto.setTenmon(dslh.get(i).getLophocPhan().getMonHoc().getTenmon());
					dto.setTenlophp(dslh.get(i).getLophocPhan().getTenlophp());
					dto.setMalhp(String.valueOf(dslh.get(i).getLophocPhan().getMalophp()));
					dto.setTenGV(dslh.get(i).getLophocPhan().getGiangvien().getTengv());
					dto.setTietbatdau(dslh.get(i).getTiethocbatdau());
					dto.setTietketthuc(dslh.get(i).getTiethocketthuc());
					dsLichHocDTOs.add(dto);
				}
			}
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate localDate = LocalDate.parse(tuanDTOs.get(0).getNgay(),formatter);
		
		model.addAttribute("date", localDate);
		model.addAttribute("ngaytrongtuan", tuanDTOs);
		model.addAttribute("lichhoc", dsLichHocDTOs);
		return "test";

	}

	@GetMapping(value = "toi")
	private String GetLHToi(Model model,  HttpServletRequest request) {
		System.out.println("luiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		ngayxemlich = ngayxemlich + 7;

		List<LichHocDTO> dsLichHocDTOs = new ArrayList<LichHocDTO>();

		// Định dạng lịch
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		/// Lấy lịch học từ DB
		List<LichHoc> dslh = lichHocService.getLichHocBySVID(17051131l);

		LocalDate localDateNgay = LocalDate.parse(request.getParameter("ngay"));
		Date date = new Date();
		ZoneId systemTimeZone = ZoneId.systemDefault();
		ZonedDateTime zonedDateTime = localDateNgay.atStartOfDay(systemTimeZone);
		date = Date.from(zonedDateTime.toInstant());

		// Lấy lịch trong tuần
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.DAY_OF_WEEK, ngayxemlich);
		List<String> days = new ArrayList<String>();
		int delta = -now.get(GregorianCalendar.DAY_OF_WEEK) + 2; // add 2 if your week start on monday

		now.add(Calendar.DAY_OF_MONTH, delta);
		List<NgayTrongTuanDTO> tuanDTOs = new ArrayList<NgayTrongTuanDTO>();
		for (int i = 0; i < 7; i++) {
			days.add(format.format(now.getTime()));
			now.add(Calendar.DAY_OF_MONTH, 1);
			NgayTrongTuanDTO dto = new NgayTrongTuanDTO();
			dto.setNgay(days.get(i));
			dto.setThu(listThu.get(i));
			tuanDTOs.add(dto);
		}

		for (int i = 0; i < dslh.size(); i++) {
			for (int j = 0; j < days.size(); j++) {
				if (days.get(j).equalsIgnoreCase(format.format(dslh.get(i).getNgayhoc()))) {
					LichHocDTO dto = new LichHocDTO();
					dto.setNgayhoc(days.get(j));
					dto.setTenmon(dslh.get(i).getLophocPhan().getMonHoc().getTenmon());
					dto.setTenlophp(dslh.get(i).getLophocPhan().getTenlophp());
					dto.setMalhp(String.valueOf(dslh.get(i).getLophocPhan().getMalophp()));
					dto.setTenGV(dslh.get(i).getLophocPhan().getGiangvien().getTengv());
					dto.setTietbatdau(dslh.get(i).getTiethocbatdau());
					dto.setTietketthuc(dslh.get(i).getTiethocketthuc());
					dsLichHocDTOs.add(dto);
				}
			}
		}
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		LocalDate localDate = LocalDate.parse(tuanDTOs.get(0).getNgay(),formatter);
		model.addAttribute("date", localDate);
		model.addAttribute("ngaytrongtuan", tuanDTOs);
		model.addAttribute("lichhoc", dsLichHocDTOs);
		return "test";

	}

}
