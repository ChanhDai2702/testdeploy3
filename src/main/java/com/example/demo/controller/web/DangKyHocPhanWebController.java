package com.example.demo.controller.web;

import java.security.Principal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
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
import com.example.demo.service.DangKyLopHocPhanService;
import com.example.demo.service.GiangVienService;
import com.example.demo.service.HocKyService;
import com.example.demo.service.LopHocPhanService;
import com.example.demo.service.MonHocService;
import com.example.demo.service.NienKhoaService;
import com.example.demo.service.SinhVienService;
import com.example.demo.service.ThoiGianHocService;

@Controller
public class DangKyHocPhanWebController {
	public static int abc = 0;
	@Autowired
	private MonHocService monHocService;
	
	@Autowired
	private LopHocPhanService lopHocPhanService;
	@Autowired
	private SinhVienService sinhVienService;
	@Autowired
	private DangKyLopHocPhanService dangKyHPService;
	@Autowired
	private ThoiGianHocService lichHocService;
	@Autowired
	private GiangVienService giangvienService;
	@Autowired
	private MonHocService monhocService;
	@Autowired
	private HocKyService hockyService;
	@Autowired
	private NienKhoaService nienKhoaService;
	
	@ModelAttribute
	private void getAttribute(Model model,HttpServletRequest request, Principal principal) {
		SinhVien sv = null;
		if(principal==null) {
			 sv=sinhVienService.getSVbyID(17083471l);
		}else {
			 sv=sinhVienService.getSVbyID(Long.valueOf(principal.getName()));
		}
		
		List<MonHoc> dsmh=monHocService.getAllMonHoc();
		Long hkdefault=0L;
		HocKy hocky=hockyService.getAllHocKyByIdNienKhoa(hkdefault);
		if(request.getParameter("HKnienKhoa")!=null) {
			hocky=hockyService.getAllHocKyByIdNienKhoa(Long.valueOf(request.getParameter("HKnienKhoa")));
			System.out.println(hocky);
			List<MonHoc> dsmhByHocKi=monhocService.getMhByHocKi(hocky.getId());
			model.addAttribute("dsmhByHocKi",dsmhByHocKi);
			model.addAttribute("lastselected",Long.valueOf(request.getParameter("HKnienKhoa")));
			List<DangKyLopHocPhan> listSVDKHPByNK=dangKyHPService.getAllLHPBYSVIDandNienKhoa(Long.valueOf(sv.getMasv()), Long.valueOf(request.getParameter("HKnienKhoa")));
			model.addAttribute("listSVDKHPByNK",listSVDKHPByNK);
			
			List<MonHoc> listMHSVDK=monhocService.getMHBySVIDandNienKhoa(Long.valueOf(sv.getMasv()),Long.valueOf(request.getParameter("HKnienKhoa")));
			model.addAttribute("listMHSVDK",listMHSVDK);
			List<LichHoc> lichhocSV=lichHocService.getLichHocBySVIDandNK(Long.valueOf(sv.getMasv()), Long.valueOf(request.getParameter("HKnienKhoa")));
			model.addAttribute("lichhocSV",lichhocSV);
		}
	
		
		
		model.addAttribute("check",request.getAttribute("chon"));
		model.addAttribute("sv", sv);
		model.addAttribute("mh", dsmh);
		model.addAttribute("check", request.getParameter("chon"));
		//lop hoc phan list
		Long mhdefault=0L;
		List<LopHocPhan> dslhp = lopHocPhanService.getAllLHPByMonHoc(mhdefault);
		if(request.getParameter("chon")!=null) {
			dslhp = lopHocPhanService.getAllLHPByMonHocAndNK(Long.valueOf(request.getParameter("chon")), Long.valueOf(request.getParameter("HKnienKhoa")));
		}
		
		model.addAttribute("lophoc",dslhp);
		LopHocPhan lhp=lopHocPhanService.getLHPbyID(0L);
		if(request.getParameter("chonLHP")!=null) {
			lhp=lopHocPhanService.getLHPbyID(Long.valueOf(request.getParameter("chonLHP")));
			List<LichHoc> listLH=lichHocService.getLichHocByLHPID(Long.valueOf(request.getParameter("chonLHP")));
			System.out.println(lhp.getDsDanKyLopHocPhans().size());
			model.addAttribute("lhp",lhp);
			model.addAttribute("lichhoc",listLH);
			model.addAttribute("checkLHP",request.getParameter("chonLHP"));
			
		}
		
		
	
		List<HocKy> listHocKy=hockyService.getAllHocKy();
		model.addAttribute("listHocKy",listHocKy);
		
		List<NienKhoa> listNienKhoa=nienKhoaService.getAllNienKhoa();
		model.addAttribute("listNienKhoa",listNienKhoa);
	}
	
	@RequestMapping(value = "/dkLHPChoSV")
	public String getAllMH(Model model,HttpServletRequest request) {
		
		return "dkhpsv";	
	}
	
	
	@RequestMapping(value = "/getLHPByMonHoc")
	public String getLHPByMonHoc(Model model,HttpServletRequest request) {
		
		return "dkhpsv";
		
	}
	@RequestMapping(value = "/getLHPByMonHoc",method = RequestMethod.POST,params = "action=Đăng kí học phần")
	public String getLHP(Model model,HttpServletRequest request,@Valid @ModelAttribute("lhp")LopHocPhan lhp,@Valid @ModelAttribute("sv")SinhVien sv) {
		
		System.out.println(lhp.getMalophp());
		DangKyLopHocPhan dklhp=new DangKyLopHocPhan();
		dklhp.setSinhvien(sv);
		dklhp.setDangkylophocphan(lhp);
		LocalDate localdate=LocalDate.now();
		ZoneId timezone=ZoneId.systemDefault();
		ZonedDateTime zoneddatetime=localdate.atStartOfDay(timezone);
		Date date=Date.from(zoneddatetime.toInstant());
		dklhp.setNgaydangky(date);
		dklhp.setTrangthaihocphi("Chưa Thu");
		
		List<DangKyLopHocPhan> listdkhp=new ArrayList<DangKyLopHocPhan>();
		listdkhp=dangKyHPService.getAllDKHP();
		System.out.println(lhp.getMonHoc().getMamonhoc());
		for(int i=0;i<listdkhp.size();i++) {
			System.out.println(listdkhp.get(i).getDangkylophocphan().getMonHoc().getMamonhoc());
			if(lhp.getMonHoc().getMamonhoc().equals(listdkhp.get(i).getDangkylophocphan().getMonHoc().getMamonhoc())) {
				if(listdkhp.get(i).getTrangthaisinhvienmonhoc().equalsIgnoreCase("Hoàn thành")) {
					dklhp.setTrangthaisinhvienmonhoc("Đăng ký học cải thiện");
					System.out.println("ok");
					break;
				}else if(listdkhp.get(i).getTrangthaisinhvienmonhoc().equals("Rớt môn")) {
					dklhp.setTrangthaisinhvienmonhoc("Đăng ký học lại");
					System.out.println("học lại");
					break;
				}
				else {
					dklhp.setTrangthaisinhvienmonhoc("Đăng ký mới");
					System.out.println("học mới");
					break;
				}
			}else {
				dklhp.setTrangthaisinhvienmonhoc("Đăng ký mới");
				System.out.println("học mới");
				break;
			}
			
		}
			
		dklhp.setNienKhoaDK(nienKhoaService.getNienKhoaByID(Long.valueOf(request.getParameter("HKnienKhoa"))));
		dangKyHPService.addDKHP(dklhp);
		
		System.out.println(Long.valueOf(request.getParameter("HKnienKhoa"))+"okokokoko");
		
		return "redirect:/getLHPByMonHoc";
		
	}

	


}
