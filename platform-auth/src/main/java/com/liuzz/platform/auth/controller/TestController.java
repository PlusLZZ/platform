package com.liuzz.platform.auth.controller;

import com.liuzz.platform.api.common.sys.SysUser;
import com.liuzz.platform.common.domain.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/test01")
    public R<?> test01(){
        return R.success(new SysUser());
    }

}
