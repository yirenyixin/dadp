package com.gientech.pcm.userRel;

import com.gientech.StartPcm;
import com.gientech.common.BaseControllerTest;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartPcm.class)
class PcmUserRelServiceTest extends BaseControllerTest {

    @Autowired
    PcmUserRelService pcmUserRelService;
    @Test
    void saveUserRel() {
        PcmUserRelDTO4Save pcmUserRelDTO4Save = new PcmUserRelDTO4Save();
        pcmUserRelDTO4Save.setUserRelId("1");
        pcmUserRelDTO4Save.setCustId("1");
        pcmUserRelDTO4Save.setLawOrgId("1");
        pcmUserRelDTO4Save.setEcifCustId("1");
        pcmUserRelDTO4Save.setCustName("11");
        pcmUserRelService.saveUserRel(pcmUserRelDTO4Save);
    }

    @Test
    void deleteUserRel() {
    }

    @Test
    void updateUserRel() {
    }

    @Test
    void listUserRel() {
        PcmUserRelDTO4List pcmUserRelDTO4List = new PcmUserRelDTO4List();
        pcmUserRelDTO4List.setPageNo(1);
        pcmUserRelDTO4List.setPageSize(10);
        pcmUserRelDTO4List.setBelongMgrId("0001");
        System.out.println(pcmUserRelService.listUserRel(pcmUserRelDTO4List));
    }
}