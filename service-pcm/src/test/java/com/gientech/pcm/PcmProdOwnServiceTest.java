package com.gientech.pcm;

import com.gientech.StartPcm;
import com.gientech.common.view.DataGrid;
import com.gientech.pcm.prodOwn.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartPcm.class)
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
        dto.setCustId("1689B_0001");
//        dto.setProdOwnId("536486ab207a11eea53c6c24087ba410");
//        dto.setLawOrgId("TestLawOrgId");
        // Set other search criteria

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
        dto.setProdOwnId("TestProdOwnId");
        dto.setCustId("TestCustId");
        dto.setLawOrgId("TestLawOrgId");
        dto.setEcifCustId("TestEcifCustId");
        dto.setIsDep("1");
        dto.setIsFixedDep("1");
        dto.setIsLoan("1");
        dto.setIsWealth("1");
//        dto.setDepBal(BigDecimal.valueOf(1000.0));
//        dto.setFixedDepBal(BigDecimal.valueOf(5000.0));
//        dto.setLoanBal(BigDecimal.valueOf(20000.0));
//        dto.setWealthBal(BigDecimal.valueOf(100000.0));
        // Set other properties

        pcmProdOwnService.savePcmProdOwn(dto);
    }

    /**
     * 修改 PcmProdOwn
     */
    @Test
    public void update() {
        PcmProdOwnDTO4Update dto = new PcmProdOwnDTO4Update();
        dto.setProdOwnId("TestProdOwnId");
        dto.setCustId("TestCustId");
        dto.setLawOrgId("TestLawOrgId");
        dto.setEcifCustId("TestEcifCustId");
        dto.setIsDep("0");
        dto.setIsFixedDep("1");
        dto.setIsLoan("0");
        dto.setIsWealth("1");
//        dto.setDepBal(BigDecimal.valueOf(0.0));
//        dto.setFixedDepBal(BigDecimal.valueOf(6000.0));
//        dto.setLoanBal(BigDecimal.valueOf(0.0));
//        dto.setWealthBal(BigDecimal.valueOf(150000.0));
        // Set other properties

        pcmProdOwnService.updatePcmProdOwn(dto);
    }

    /**
     * 删除 PcmProdOwn
     */
    @Test
    public void delete() {
        String prodOwnId = "TestProdOwnId";
        pcmProdOwnService.deletePcmProdOwn(prodOwnId);
    }
}