package com.gientech.ppm;



import com.gientech.ppm.prod.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gientech.common.view.DataGrid;

/**
 * PpmProd - Service 层单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
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
        dto.setProdId("Test");
        dto.setProdName("Test ProdName");
        dto.setKindId("Test KindId");
        dto.setProdStatus("Test ProdStatus");
        dto.setProDescribe("Test ProDescribe");
        dto.setDoFlow("Test DoFlow");
        dto.setMarketDiscourse("Test MarketDiscourse");
        dto.setProdFeature("Test ProdFeature");
        // Set other properties

        ppmProdService.savePpmProd(dto);
    }

    /**
     * 修改 PpmProd
     */
    @Test
    public void update() {
        PpmProdDTO4Update dto = new PpmProdDTO4Update();
        dto.setProdId("Test");
        dto.setProdName("Updated ProdName");
        dto.setKindId("Updated KindId");
        dto.setProdStatus("Updated ProdStatus");
        // Set other properties

        ppmProdService.updatePpmProd(dto);
    }

    /**
     * 删除 PpmProd
     */
    @Test
    public void delete() {
        String prodId = "Test";
        ppmProdService.deletePpmProd(prodId);
    }
}