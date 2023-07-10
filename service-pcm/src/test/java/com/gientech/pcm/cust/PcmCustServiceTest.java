package com.gientech.pcm.cust;

import com.gientech.common.BaseControllerTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class PcmCustServiceTest extends BaseControllerTest {

    @Autowired
    private PcmCustService pcmCustService;

    @Test
    void saveCust() {
        PcmCustDTO4Save pcmCustDTO4Save = new PcmCustDTO4Save();
        pcmCustDTO4Save.setCustId("1");
        pcmCustDTO4Save.setEcifCustId("1");
        pcmCustDTO4Save.setCustName("1");
        pcmCustDTO4Save.setLawOrgId("1");
        pcmCustDTO4Save.setCertType("1");
        pcmCustDTO4Save.setCertNo("1");
        pcmCustDTO4Save.setCertAddr("1");
        pcmCustService.saveCust(pcmCustDTO4Save);
    }

    @Test
    void deleteCust() {
        pcmCustService.deleteCust("1");
    }

    @Test
    void updateCust() {
    }

    @Test
    void listCust() {
        PcmCustDTO4List pcmCustDTO4List = new PcmCustDTO4List();
        pcmCustDTO4List.setPageNo(1);
        pcmCustDTO4List.setPageSize(10);
        System.out.println(pcmCustService.listCust(pcmCustDTO4List).getRows().get(0));
    }
}