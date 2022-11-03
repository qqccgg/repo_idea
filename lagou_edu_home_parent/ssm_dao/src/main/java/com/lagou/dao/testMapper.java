package com.lagou.dao;

import com.lagou.domain.test;
        import org.apache.ibatis.annotations.Select;
        import org.springframework.stereotype.Repository;

        import java.util.List;


public interface testMapper {
    @Select("SELECT * FROM test")
    public List<test> findall();
}
