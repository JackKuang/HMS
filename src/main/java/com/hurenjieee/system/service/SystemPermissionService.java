package com.hurenjieee.system.service;

import java.util.List;
import java.util.Map;

import com.hurenjieee.core.BaseService;
import com.hurenjieee.system.entity.SystemPermission;

public interface SystemPermissionService extends BaseService<SystemPermission> {

    public List<Map> getPermission(String userId);
    
}
