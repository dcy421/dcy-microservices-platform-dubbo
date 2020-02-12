package com.dcy.dubbo.consumer.service;

import com.dcy.db.base.controller.BaseController;
import com.dcy.dubbo.provider.dto.UserDTO;
import com.dcy.dubbo.provider.model.SysUserInfo;
import com.dcy.dubbo.provider.service.ISysUserInfoService;
import io.swagger.annotations.Api;
import org.apache.dubbo.config.annotation.Reference;
import org.dromara.soul.client.common.annotation.SoulClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author dcy
 * @since 2019-09-06
 */
@RestController
@RequestMapping("/user")
@Api(value = "SysUserInfoController", tags = {"用户操作接口"})
public class SysUserInfoController extends BaseController<ISysUserInfoService, SysUserInfo> {


    @Reference(mock = "true")
    private ISysUserInfoService iSysUserInfoService;

    @SoulClient(path = "/user/sayHello", desc = "测试")
    @GetMapping("/sayHello")
    public String sayHello(String name) {
        return iSysUserInfoService.sayHello(name);
    }

    @GetMapping("/list")
    public List<SysUserInfo> list() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("adddd");
        userDTO.setPassword("2222");
        return iSysUserInfoService.findByUser(userDTO);
    }
}
