package com.study.mapper;


import com.study.entity.Emp;
import com.study.mult.DataSource;
import com.study.mult.DataSourceType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmpMapper {

    @DataSource(value = DataSourceType.REMOTE)
    List<Emp> selectEmp();

    @DataSource(value = DataSourceType.REMOTE)
    Emp selectEmpById(Integer empno);

    @DataSource(value = DataSourceType.REMOTE)
    Integer addEmp(Emp emp);

    @DataSource(value = DataSourceType.REMOTE)
    Integer updateEmp(Emp emp);

    @DataSource(value = DataSourceType.REMOTE)
    Integer deleteEmp(Integer empno);
}
