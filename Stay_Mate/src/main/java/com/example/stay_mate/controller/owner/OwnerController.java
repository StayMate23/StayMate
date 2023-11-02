package com.example.stay_mate.controller.owner;

import com.example.stay_mate.service.owner.OwnerAdminService;
import com.example.stay_mate.service.owner.OwnerService;
import org.springframework.stereotype.Controller;

@Controller
public class OwnerController {
    public final OwnerService ownerService;
    public final OwnerAdminService ownerAdminService;

    public OwnerController(OwnerService ownerService, OwnerAdminService ownerAdminService) {
        this.ownerService = ownerService;
        this.ownerAdminService = ownerAdminService;
    }
}
