package com.webank.wedatasphere.dss.visualis.auth;

import edp.davinci.core.common.ResultMap;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SandboxRefuseImpl implements SandboxRefuse {

    private String SANDBOX_REFUSE_SLOGAN = "[Sandbox environment cannot be modified!] 沙箱环境不允许修改！";


    @Override
    public ResponseEntity sandboxEditableRefuse() {
        ResultMap resultMap = new ResultMap();
        resultMap = new ResultMap().fail().message(SANDBOX_REFUSE_SLOGAN);
        return ResponseEntity.ok(resultMap);
    }
}
