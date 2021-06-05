package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.LopHocPhan;
import com.example.demo.repository.LopHocPhanRepository;
import com.example.demo.service.LopHocPhanService;
@Service
public class LopHocPhanImpl implements LopHocPhanService{
	@Autowired
	LopHocPhanRepository lophocphanrep;
	@Override
	public boolean addLHP(LopHocPhan lhp) {
		// TODO Auto-generated method stub
		try {
			if(lhp!=null) {
				lophocphanrep.save(lhp);
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editLHP(LopHocPhan lhp) {
		// TODO Auto-generated method stub
		try {
			if(lhp!=null) {
				lophocphanrep.save(lhp);
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removebyIdLHP(Long id) {
		// TODO Auto-generated method stub
		try {
			if(!id.equals("")) {
				lophocphanrep.deleteById(id);
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception\
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean removebyTenLHP(String name) {
		// TODO Auto-generated method stub
		try {
			if(!name.equals("")) {
				lophocphanrep.deleteLHPByTenLHP(name);
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception\
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<LopHocPhan> getAllLHP() {
		// TODO Auto-generated method stub
		return lophocphanrep.findAll();
	}

	@Override
	public LopHocPhan getLHPbyID(Long id) {
		// TODO Auto-generated method stub
		return lophocphanrep.getLHPbyID(id);
	}

	@Override
	public LopHocPhan getLHPbyName(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<LopHocPhan> getAllLHPByMonHoc(Long id) {
		// TODO Auto-generated method stub
		
		return lophocphanrep.getAllLHPByMonHoc(id);
	}

	@Override
	public LopHocPhan getLHPNullValue() {
		// TODO Auto-generated method stub
		return lophocphanrep.getLHPNullValue();
	}

	@Override
	public List<LopHocPhan> getAllLHPBySVID(Long id) {
		// TODO Auto-generated method stub
		return lophocphanrep.getAllLHPBySVID(id);
	}

	@Override
	public List<LopHocPhan> getAllLHPByMonHocAndNK(Long id, Long idNienKhoa) {
		// TODO Auto-generated method stub
		return lophocphanrep.getAllLHPByMonHocAndNK(id, idNienKhoa);
	}

	@Override
	public List<LopHocPhan> getAllLHPByGVID(Long id) {
		// TODO Auto-generated method stub
		return lophocphanrep.getAllLHPByGVID(id);
	}

	@Override
	public List<LopHocPhan> getAllLHPbyidGVandNK(long idgv, long idnk) {
		// TODO Auto-generated method stub
		return lophocphanrep.getAllLHPbyidGVandNK(idgv, idnk);
	}

}
