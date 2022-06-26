package com.example.comsumerApp.modeller.Partner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/partner")
public class PartnerController {
    private final PartnerService partnerService;

    @Autowired
    public PartnerController(PartnerService partnerService) {
        this.partnerService = partnerService;
    }

    @GetMapping
    public List<Partner> getPartner() {
        return partnerService.getPartner();
    }

    @PostMapping("create")
    public void registerNewPartner(@RequestBody Partner partner) {
        partnerService.addNewPartner(partner);
    }

    @DeleteMapping(path = "delete/{Id}")
    public void deletePartner(@PathVariable("Id") Long partnerID) {
        partnerService.deleteProduct(partnerID);
    }

}
