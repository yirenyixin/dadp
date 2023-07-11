package com.gientech.pcm;

import com.gientech.common.view.DataGrid;
import com.gientech.pcm.wealth.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author cjm
 * @date 2023/7/7 20:02
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PcmWealthServiceTest {

    @Autowired
    private PcmWealthService pcmWealthService;

    /**
     * 新增
     */
    @Test
    public void save(){
        PcmWealthDTO4Save pcmWealthDTO4Save = new PcmWealthDTO4Save();
        //pcmWealthDTO4Save.setWealthId("1");
        pcmWealthDTO4Save.setCustId("2");
        pcmWealthDTO4Save.setEcifCustId("3");
        pcmWealthDTO4Save.setCustName("cjm");
        pcmWealthDTO4Save.setOpenOrgId("666");
        pcmWealthDTO4Save.setProdCode("777");
        pcmWealthService.saveWealth(pcmWealthDTO4Save);
    }

    /**
     * 删除
     */
    @Test
    public void delete(){
        String wealthId = "1";
        pcmWealthService.deleteWealth(wealthId);
    }

    /**
     * 修改
     */
    @Test
    public void update(){
        PcmWealthDTO4Update pcmWealthDTO4Update = new PcmWealthDTO4Update();
        pcmWealthDTO4Update.setWealthId("1");
        pcmWealthDTO4Update.setCustName("wxy");
        pcmWealthService.updateWealth(pcmWealthDTO4Update);
    }

    /**
     * 查
     */
    @Test
    public void list(){
        PcmWealthDTO4List pcmWealthDTO4List = new PcmWealthDTO4List();
        pcmWealthDTO4List.setPageNo(1);
        pcmWealthDTO4List.setPageSize(10);

        DataGrid<PcmWealthVO> dataGrid = pcmWealthService.listWealth(pcmWealthDTO4List);
        if(dataGrid != null && dataGrid.getRows() != null){
            for(int i = 0; i < dataGrid.getRows().size(); i++){
                System.out.println("niuniuniuniu" + dataGrid.getRows().get(i));
            }
        }
    }




}