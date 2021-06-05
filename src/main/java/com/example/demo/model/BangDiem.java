package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name = "bangdiem")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "mabangdiem")
public class BangDiem implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long mabangdiem;
	
	@Column(name = "trangthai",columnDefinition = "nvarchar(50) not null")
	private String trangthai;
	
	@Column(name = "tk1")
	private Float tk1;
	
	@Column(name = "tk2")
	private Float tk2;
	
	@Column(name = "tk3")
	private Float tk3;
	
	@Column(name = "tk4")
	private Float tk4;
	
	@Column(name = "tk5")
	private Float tk5;
	
	@Column(name = "giuaky")
	private Float giuaky;
	
	@Column(name = "cuoiky")
	private Float cuoiky;
	
	@Column(name = "dtb_10")
	private Float dtb_10;
	
	@Column(name = "dtb_4")
	private Float dtb_4;
	
	@Column(name = "dtb_chu")
	private String dtb_chu;
	
	@Column(name = "xeploai")
	private String xeploai;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lophocphan_id",nullable = false,foreignKey = @ForeignKey)
	private LopHocPhan lopHocPhan;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sinhvien_id",nullable = false,foreignKey = @ForeignKey)
	private SinhVien sinhVien;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "monhoc_id",nullable = false,foreignKey = @ForeignKey)
	private MonHoc monHoc;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nienkhoa_id",nullable = true,foreignKey = @ForeignKey)
	private NienKhoa nienkhoa;
	
	


	public NienKhoa getNienkhoa() {
		return nienkhoa;
	}



	public void setNienkhoa(NienKhoa nienkhoa) {
		this.nienkhoa = nienkhoa;
	}



	public BangDiem() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public BangDiem(Long mabangdiem, String trangthai, Float tk1, Float tk2, Float tk3, Float tk4, Float tk5,
			Float giuaky, Float cuoiky, Float dtb_10, Float dtb_4, String dtb_chu, String xeploai) {
		super();
		this.mabangdiem = mabangdiem;
		this.trangthai = trangthai;
		this.tk1 = tk1;
		this.tk2 = tk2;
		this.tk3 = tk3;
		this.tk4 = tk4;
		this.tk5 = tk5;
		this.giuaky = giuaky;
		this.cuoiky = cuoiky;
		this.dtb_10 = dtb_10;
		this.dtb_4 = dtb_4;
		this.dtb_chu = dtb_chu;
		this.xeploai = xeploai;
	}



	public Float getTk1() {
		return tk1;
	}



	public void setTk1(Float tk1) {
		this.tk1 = tk1;
	}



	public Float getTk2() {
		return tk2;
	}



	public void setTk2(Float tk2) {
		this.tk2 = tk2;
	}



	public Float getTk3() {
		return tk3;
	}



	public void setTk3(Float tk3) {
		this.tk3 = tk3;
	}



	public Float getTk4() {
		return tk4;
	}



	public void setTk4(Float tk4) {
		this.tk4 = tk4;
	}



	public Float getTk5() {
		return tk5;
	}



	public void setTk5(Float tk5) {
		this.tk5 = tk5;
	}



	public Float getGiuaky() {
		return giuaky;
	}



	public void setGiuaky(Float giuaky) {
		this.giuaky = giuaky;
	}



	public Float getCuoiky() {
		return cuoiky;
	}



	public void setCuoiky(Float cuoiky) {
		this.cuoiky = cuoiky;
	}



	public Float getDtb_10() {
		return dtb_10;
	}



	public void setDtb_10(Float dtb_10) {
		this.dtb_10 = dtb_10;
	}



	public Float getDtb_4() {
		return dtb_4;
	}



	public void setDtb_4(Float dtb_10) {
		this.dtb_4 = (dtb_10*4)/10;
	}



	public String getDtb_chu() {
		return dtb_chu;
	}



	public void setDtb_chu(String dtb_chu) {
		this.dtb_chu = dtb_chu;
	}



	public String getXeploai() {
		return xeploai;
	}



	public void setXeploai(String xeploai) {
		this.xeploai = xeploai;
	}



	public LopHocPhan getLopHocPhan() {
		return lopHocPhan;
	}



	public void setLopHocPhan(LopHocPhan lopHocPhan) {
		this.lopHocPhan = lopHocPhan;
	}



	public SinhVien getSinhVien() {
		return sinhVien;
	}



	public void setSinhVien(SinhVien sinhVien) {
		this.sinhVien = sinhVien;
	}



	public MonHoc getMonHoc() {
		return monHoc;
	}



	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}



	public Long getMabangdiem() {
		return mabangdiem;
	}

	public void setMabangdiem(Long mabangdiem) {
		this.mabangdiem = mabangdiem;
	}



	public String getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

	public LopHocPhan getLophocphan() {
		return lopHocPhan;
	}

	public void setLophocphan(LopHocPhan lophocphan) {
		this.lopHocPhan = lophocphan;
	}



	@Override
	public String toString() {
		return "BangDiem [mabangdiem=" + mabangdiem + ", trangthai=" + trangthai + ", tk1=" + tk1 + ", tk2=" + tk2
				+ ", tk3=" + tk3 + ", tk4=" + tk4 + ", tk5=" + tk5 + ", giuaky=" + giuaky + ", cuoiky=" + cuoiky
				+ ", dtb_10=" + dtb_10 + ", dtb_4=" + dtb_4 + ", dtb_chu=" + dtb_chu + ", xeploai=" + xeploai
				+ ", lopHocPhan=" + lopHocPhan + ", sinhVien=" + sinhVien +  ", nienkhoa=" + nienkhoa + "]";
	}





	
	
}
