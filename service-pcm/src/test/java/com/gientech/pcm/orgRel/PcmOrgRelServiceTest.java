package com.gientech.pcm.orgRel;

import com.gientech.common.BaseControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class PcmOrgRelServiceTest extends BaseControllerTest {
    @Autowired
    PcmOrgRelService pcmOrgRelService;

    @Test
    void saveOrgRel() {
        PcmOrgRelDTO4Save pcmOrgRelDTO4Save = new PcmOrgRelDTO4Save();
        pcmOrgRelDTO4Save.setOrgRelId("11");
        pcmOrgRelService.saveOrgRel(pcmOrgRelDTO4Save);

    }

    @Test
    void deleteOrgRel() {
        pcmOrgRelService.deleteOrgRel("11");
    }

    @Test
    void updateOrgRel() {
    }

    @Test
    void listOrgRel() {
        PcmOrgRelDTO4List pcmOrgRelDTO4List = new PcmOrgRelDTO4List();
        pcmOrgRelDTO4List.setPageNo(1);
        pcmOrgRelDTO4List.setPageSize(10);
        System.out.println(pcmOrgRelService.listOrgRel(pcmOrgRelDTO4List));
    }
}