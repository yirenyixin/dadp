package com.gientech.ppm;

import com.gientech.StartPpm;
import com.gientech.common.view.DataGrid;
import com.gientech.ppm.prod.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * PpmProd - Service 层单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StartPpm.class)
public class PpmProdServiceTest {

    @Autowired
    private PpmProdService ppmProdService;

    /**
     * 查询和分页
     */
    @Test
    public void list() {
        PpmProdDTO4List dto = new PpmProdDTO4List();
        dto.setPageNo(1);
        dto.setPageSize(10);
        dto.setProdId("A0001");
        DataGrid<PpmProdVO> dataGrid = ppmProdService.listPpmProd(dto);
        if (dataGrid != null && dataGrid.getRows() != null) {
            for (int i = 0; i < dataGrid.getRows().size(); i++) {
                System.out.println("PpmProd: " + dataGrid.getRows().get(i));
            }
        }
    }

    /**
     * 新增 PpmProd
     */
    @Test
    public void save() {
        PpmProdDTO4Save dto = new PpmProdDTO4Save();
        dto.setProdId("A0001");
        dto.setProdName("Test ProdName");
        dto.setKindId("Test KindId");
        dto.setProdStatus("1");
        dto.setProDescribe("Test ProDescribe");
        dto.setDoFlow("Test DoFlow");
        dto.setMarketDiscourse("Test MarketDiscourse");
        dto.setProdFeature("dep");
        // Set other properties

        ppmProdService.savePpmProd(dto);
    }

    /**
     * 修改 PpmProd
     */
    @Test
    public void update() {
        PpmProdDTO4Update dto = new PpmProdDTO4Update();
        dto.setProdId("A0001");
        dto.setProdName("Updated ProdName1");
        dto.setKindId("Updated KindId1");
        // Set other properties

        ppmProdService.updatePpmProd(dto);
    }

    /**
     * 删除 PpmProd
     */
    @Test
    public void delete() {
        String prodIds = "A0001";
        ppmProdService.deletePpmProd(prodIds);
    }
}