package com.example.demo.apicall;

import java.util.List;

import com.example.demo.model.Khoa;

import retrofit2.Call;
import retrofit2.http.GET;

public interface KhoaCallAPI {
	@GET("dskhoa")
	Call<List<Khoa>> getAllKhoa();
}
