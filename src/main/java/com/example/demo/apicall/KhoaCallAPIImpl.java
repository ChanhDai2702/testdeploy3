package com.example.demo.apicall;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Khoa;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KhoaCallAPIImpl {
	private List<Khoa> listKhoa=new ArrayList<Khoa>();
	public void getAllKhoa() {
		KhoaCallAPI khoaAPI=APIClient.getClient().create(KhoaCallAPI.class);
		khoaAPI.getAllKhoa().enqueue(new Callback<List<Khoa>>() {
			
			@Override
			public void onResponse(Call<List<Khoa>> call, Response<List<Khoa>> response) {
				// TODO Auto-generated method stub
				for(Khoa khoa:response.body()) {
					listKhoa = response.body();
				}
			}
			
			@Override
			public void onFailure(Call<List<Khoa>> call, Throwable t) {
				// TODO Auto-generated method stub
				System.out.println("lỗi");
			}
		});
	}
}
