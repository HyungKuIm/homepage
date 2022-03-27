package com.oraclejava.homepage.repository;

import java.util.List;

import com.oraclejava.homepage.dto.Jusorok;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JusorokMapper {
    List<Jusorok> selectList();
}
