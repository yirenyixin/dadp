package com.gientech.pmm;

import com.gientech.StartPmm;
import com.gientech.common.view.DataGrid;
import com.gientech.pmm.remindTemp.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * PmmRemindTemp - Service 层单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartPmm.class)
public class PmmRemindTempServiceTest {

    @Autowired
    private PmmRemindTempService pmmRemindTempService;

    /**
     * 查询和分页
     */
    @Test
    public void list() {
        PmmRemindTempDTO4List dto = new PmmRemindTempDTO4List();
        dto.setPageNo(1);
        dto.setPageSize(10);

        DataGrid<PmmRemindTempVO> dataGrid = pmmRemindTempService.listRemind(dto);
        if (dataGrid != null && dataGrid.getRows() != null) {
            for (int i = 0; i < dataGrid.getRows().size(); i++) {
                System.out.println("PmmRemindTemp: " + dataGrid.getRows().get(i));
            }
        }
    }

    /**
     * 新增 PmmRemindTemp
     */
    @Test
    public void save() {
        PmmRemindTempDTO4Save dto = new PmmRemindTempDTO4Save();
        // dto.setRemindTempId();
        dto.setEventType("11101");
        dto.setEventSmallType("1110101");
        dto.setThresholdMon(1000);
        dto.setDayNum(5);
        dto.setRemindRoleId("Test");
        dto.setIsOk("1");
        dto.setValidDay(3);
        // Set other properties

        pmmRemindTempService.saveRemindTemp(dto);
    }

    /**
     * 修改 PmmRemindTemp
     */
    @Test
    public void update() {
        PmmRemindTempDTO4Update dto = new PmmRemindTempDTO4Update();
        // dto.setRemindTempId();
        dto.setEventType("11101");
        dto.setEventSmallType("1110101");
        dto.setThresholdMon(2000);
        dto.setDayNum(7);
        // Set other properties

        pmmRemindTempService.updateReminTemp(dto);
    }

    /**
     * 删除 PmmRemindTemp
     */
    @Test
    public void delete() {
        String remindTempIds = "Test";
        pmmRemindTempService.deleteRemindTemp(remindTempIds);
    }
}