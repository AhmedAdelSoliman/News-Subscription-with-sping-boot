package com.ahmed.adel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ahmed.adel.model.NewsType;

@Repository
public interface NewsTypeRepository extends
                     PagingAndSortingRepository<NewsType, Integer> {

}
