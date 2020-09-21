package com.ahmed.adel.services;

import java.util.List;

import com.ahmed.adel.model.NewsType;

public interface NewsTypeService {
	
	public List<NewsType> getAllNewsType(Integer pageNo, Integer pageSize);

}
