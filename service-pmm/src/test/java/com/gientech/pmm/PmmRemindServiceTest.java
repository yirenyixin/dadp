package com.gientech.pmm;

import com.gientech.StartPmm;
import com.gientech.common.view.DataGrid;
import com.gientech.pmm.remind.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * PmmRemind - Service 层单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartPmm.class)
public class PmmRemindServiceTest {

    @Autowired
    private PmmRemindService pmmRemindService;

    /**
     * 查询和分页
     */
    @Test
    public void list() {
        PmmRemindDTO4List dto = new PmmRemindDTO4List();
        dto.setPageNo(1);
        dto.setPageSize(10);

        DataGrid<PmmRemindVO> dataGrid = pmmRemindService.listRemind(dto);
        if (dataGrid != null && dataGrid.getRows() != null) {
            for (int i = 0; i < dataGrid.getRows().size(); i++) {
                System.out.println("PmmRemind: " + dataGrid.getRows().get(i));
            }
        }
    }

    /**
     * 新增 PmmRemind
     */
    @Test
    public void save() {
        PmmRemindDTO4Save dto = new PmmRemindDTO4Save();
//        dto.setRemindId();
//        dto.setRemindTempId("Test");
        dto.setReceiverUserId("Test");
        dto.setEventType("11101");
        dto.setEventSmallType("1110101");
        dto.setValidDay(3);
        dto.setRemindContent("客户9836K_6354的理财产品稳利安盈理财还有10天到期");
        Date date=new Date();

        dto.setCreateDate(date);
        // Set other properties

        pmmRemindService.saveRemind(dto);
    }

    /**
     * 修改 PmmRemind
     */
    @Test
    public void update() {
        PmmRemindDTO4Update dto = new PmmRemindDTO4Update();
//        dto.setRemindId();
        dto.setReceiverUserId("Test");
        dto.setEventType("11101");
        dto.setEventSmallType("1110101");
//        dto.setThresholdMon(2000);
        // Set other properties

        pmmRemindService.updateRemind(dto);
    }

    /**
     * 删除 PmmRemind
     */
    @Test
    public void delete() {
        String remindTempIds = "Test";
        pmmRemindService.deleteRemind(remindTempIds);
    }
}