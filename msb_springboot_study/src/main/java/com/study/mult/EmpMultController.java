package com.study.mult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpMultController {

    @GetMapping("/selectEmp")
    @DataSource(value = DataSourceType.REMOTE)
    public String selectEmp(){
        return "ok";
    }

}