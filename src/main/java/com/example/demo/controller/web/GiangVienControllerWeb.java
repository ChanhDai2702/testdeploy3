package com.example.demo.controller.web;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.DangKyLopHocPhan;
import com.example.demo.model.HocKy;
import com.example.demo.model.LichHoc;
import com.example.demo.model.LopHocPhan;
import com.example.demo.model.MonHoc;
import com.example.demo.model.NienKhoa;
import com.example.demo.model.SinhVien;
import com.example.demo.service.GiangVienService;
import com.example.demo.service.HocKyService;
import com.example.demo.service.LopHocPhanService;
import com.example.demo.service.NienKhoaService;

@Controller
public class GiangVienControllerWeb {
	@Autowired
	private GiangVienService  giangVienService;
	
	@Autowired
	private HocKyService  hocKyService;
	
	@Autowired
	private NienKhoaService  nienKhoaService;
	
	@Autowired
	private LopHocPhanService  lopHocPhanService;
	
	@RequestMapping(value = "/danhsachlopday")
	public String getAllMH(Model model,HttpServletRequest request) {
		
		List<NienKhoa> dsNienKhoas = nienKhoaService.getAllNienKhoa();
		List<LopHocPhan> dslHocPhans = lopHocPhanService.getAllLHPByGVID(123l);
		
		model.addAttribute("listlhp", dslHocPhans);
		model.addAttribute("listNienKhoa", dsNienKhoas);
		return "dslhp_giangday";	
	}
	
	@RequestMapping(value = "/getlichday_hk")
	public String getlichday_hk(Model model,HttpServletRequest request) {
		long idnienkhoa =Long.valueOf(request.getParameter("HKnienKhoa"));
		System.out.println(idnienkhoa);
		List<LopHocPhan> dslHocPhans = lopHocPhanService.getAllLHPbyidGVandNK(123l, idnienkhoa);
		List<NienKhoa> dsNienKhoas = nienKhoaService.getAllNienKhoa();
		
		NienKhoa nk = nienKhoaService.getNienKhoaByID(idnienkhoa);
		
		if(idnienkhoa==0) {
			dslHocPhans = lopHocPhanService.getAllLHPByGVID(123l);
		}
		
		model.addAttribute("nk", nk);
		model.addAttribute("listlhp", dslHocPhans);
		model.addAttribute("listNienKhoa", dsNienKhoas);
		return "dslhp_giangday";	
	}
	
	@RequestMapping(value = "/danhsachSV", method = RequestMethod.GET)  
	public String editUser(@RequestParam("idlhp") Long Id, Model model) {  
		
		LopHocPhan lopHocPhan = lopHocPhanService.getLHPbyID(Id);
		model.addAttribute("lhp", lopHocPhan);
		return "dssvdklhp";  
	}  
}
