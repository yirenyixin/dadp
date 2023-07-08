package com.gientech.pcm;

//import com.gientech.pcm.prodown.PcmProdOwnService;
//import com.gientech.pcm.prodown.PcmProdOwnDTO;
//import com.gientech.pcm.prodown.PcmProdOwnVO;
import com.gientech.pcm.prodOwn.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gientech.common.view.DataGrid;

/**
 * PcmProdOwn - Service 层单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PcmProdOwnServiceTest {

    @Autowired
    private PcmProdOwnService pcmProdOwnService;

    /**
     * 查询和分页
     */
    @Test
    public void list() {
        PcmProdOwnDTO4List dto = new PcmProdOwnDTO4List();
        dto.setPageNo(1);
        dto.setPageSize(10);

        DataGrid<PcmProdOwnVO> dataGrid = pcmProdOwnService.listPcmProdOwn(dto);
        if (dataGrid != null && dataGrid.getRows() != null) {
            for (int i = 0; i < dataGrid.getRows().size(); i++) {
                System.out.println("PcmProdOwn: " + dataGrid.getRows().get(i));
            }
        }
    }

    /**
     * 新增 PcmProdOwn
     */
    @Test
    public void save() {
        PcmProdOwnDTO4Save dto = new PcmProdOwnDTO4Save();
        dto.setProdOwnId("Test");
        dto.setCustId("Test CustId");
        dto.setLawOrgId("Test LawOrgId");
        dto.setEcifCustId("Test EcifCustId");
        dto.setIsDep("1");
        dto.setIsFixedDep("0");
        dto.setIsLoan("1");
        dto.setIsWealth("0");
        dto.setDepBal(1000.00);
        dto.setFixedDepBal(500.00);
        dto.setLoanBal(500.00);
        dto.setWealthBal(0.00);
        // Set other properties

        pcmProdOwnService.savePcmProdOwn(dto);
    }

    /**
     * 修改 PcmProdOwn
     */
    @Test
    public void update() {
        PcmProdOwnDTO4Update dto = new PcmProdOwnDTO4Update();
        dto.setProdOwnId("Test");
        dto.setCustId("111");
        dto.setLawOrgId("Updated LawOrgId1");
        // Set other properties

        pcmProdOwnService.updatePcmProdOwn(dto);
    }

    /**
     * 删除 PcmProdOwn
     */
    @Test
    public void delete() {
        String prodOwnIds = "Test";
        pcmProdOwnService.deletePcmProdOwn(prodOwnIds);
    }
}