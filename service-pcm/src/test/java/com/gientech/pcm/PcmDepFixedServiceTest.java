package com.gientech.pcm;


import com.gientech.common.view.DataGrid;
import com.gientech.pcm.depFixed.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * PcmDepFixed - Service 层单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PcmDepFixedServiceTest {

    @Autowired
    private PcmDepFixedService pcmDepFixedService;

    /**
     * 查询和分页
     */
    @Test
    public void list() {
        PcmDepFixedDTO4List dto = new PcmDepFixedDTO4List();
        dto.setPageNo(1);
        dto.setPageSize(10);

        DataGrid<PcmDepFixedVO> dataGrid = pcmDepFixedService.listPcmDepFixed(dto);
        if (dataGrid != null && dataGrid.getRows() != null) {
            for (int i = 0; i < dataGrid.getRows().size(); i++) {
                System.out.println("PcmDepFixed: " + dataGrid.getRows().get(i));
            }
        }
    }

    /**
     * 新增 PcmDepFixed
     */
    @Test
    public void save() {
        PcmDepFixedDTO4Save dto = new PcmDepFixedDTO4Save();
        dto.setDepFixedId("Test");
        dto.setCustId("Test CustId");
        dto.setCustName("Test CustName");
        dto.setAcctNo("test AcctNo");
        dto.setCurrNo("Test CurrNo");
        // Set other properties

        pcmDepFixedService.savePcmDepFixed(dto);
    }

    /**
     * 修改 PcmDepFixed
     */
    @Test
    public void update() {
        PcmDepFixedDTO4Update dto = new PcmDepFixedDTO4Update();
        dto.setDepFixedId("Test");
        dto.setCustId("Updated CustId1");
        dto.setCustName("Updated CustName1");
        // Set other properties
//        dto.setVer(1);

        pcmDepFixedService.updatePcmDepFixed(dto);
    }

    /**
     * 删除 PcmDepFixed
     */
    @Test
    public void delete() {
        String depFixedIds = "Test";
        pcmDepFixedService.deletePcmDepFixed(depFixedIds);
    }
}