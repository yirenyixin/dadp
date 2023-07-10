package com.gientech.pcm;

import com.gientech.common.view.DataGrid;
import com.gientech.pcm.depCurr.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * PcmDepCurr - Service 层单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PcmDepCurrServiceTest {

    @Autowired
    private PcmDepCurrService pcmDepCurrService;

    /**
     * 查询和分页
     */
    @Test
    public void list() {
        PcmDepCurrDTO4List dto = new PcmDepCurrDTO4List();
        dto.setPageNo(1);
        dto.setPageSize(10);

        DataGrid<PcmDepCurrVO> dataGrid = pcmDepCurrService.listPcmDepCurr(dto);
        if (dataGrid != null && dataGrid.getRows() != null) {
            for (int i = 0; i < dataGrid.getRows().size(); i++) {
                System.out.println("PcmDepCurr: " + dataGrid.getRows().get(i));
            }
        }
    }

    /**
     * 新增 PcmDepCurr
     */
    @Test
    public void save() {
        PcmDepCurrDTO4Save dto = new PcmDepCurrDTO4Save();
        dto.setDepCurrId("Test");
        dto.setCustId("Test CustId");
        dto.setEcifCustId("Test EcifCustId");
        dto.setCustName("Test CustName");
        dto.setLawOrgId("Test LawOrgId");
        dto.setProdCode("Test ProdCode");
        dto.setProdName("Test ProdName");
        dto.setAcctNo("Test AcctNo");
        dto.setCurrNo("Test CurrNo");
        dto.setBal(1000.00);
        dto.setAcctSts("Test AcctSts");
        dto.setOpenOrgNo("Test OpenOrgNo");
        dto.setStartDt("20230707");
        dto.setVoucherNo("Test VoucherNo");
        dto.setSubAcctNo("Test SubAcctNo");
        dto.setCurrentBal(500.00);
        // Set other properties

        pcmDepCurrService.savePcmDepCurr(dto);
    }

    /**
     * 修改 PcmDepCurr
     */
    @Test
    public void update() {
        PcmDepCurrDTO4Update dto = new PcmDepCurrDTO4Update();
        dto.setDepCurrId("Test");
        dto.setCustId("Updated CustId1");
        dto.setEcifCustId("Updated EcifCustId1");
        dto.setCustName("Updated CustName1");
        // Set other properties

        pcmDepCurrService.updatePcmDepCurr(dto);
    }

    /**
     * 删除 PcmDepCurr
     */
    @Test
    public void delete() {
        String depCurrIds = "Test";
        pcmDepCurrService.deletePcmDepCurr(depCurrIds);
    }
}