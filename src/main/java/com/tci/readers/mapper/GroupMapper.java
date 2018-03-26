package com.tci.readers.mapper;

import com.tci.readers.model.Group;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GroupMapper {
    @Select("select * from incident_group")
    @Results(value={
            @Result(column = "reader_id", property = "reader_id"),
            @Result(column = "group_name", property = "group_name"),
            @Result(column =  "group_id", property =  "group_id")
    }
    )
    List<Group> query();

    @Select("select * from incident_group where reader_id = #{reader_id}")
    @Results(value={
            @Result(column = "reader_id", property = "reader_id"),
            @Result(column = "group_name", property = "group_name")
    })
    Group queryById(@Param("reader_id") String reader_id);
}
