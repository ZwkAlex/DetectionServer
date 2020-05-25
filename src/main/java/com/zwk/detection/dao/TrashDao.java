package com.zwk.detection.dao;

import com.zwk.detection.entity.TrashEntity;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface TrashDao{
    @Select("SELECT * FROM trash_class WHERE id = #{id}")
    TrashEntity getById(@Param("id")  Long id);
    @Select("SELECT name_CN  FROM trash_class WHERE id = #{id}")
    String getNameCNById(Long id);
}
