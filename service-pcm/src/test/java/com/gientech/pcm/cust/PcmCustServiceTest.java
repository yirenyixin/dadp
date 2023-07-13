//package com.gientech.pcm.cust;
//
//import com.gientech.StartPcm;
//import com.gientech.common.BaseControllerTest;
//import com.gientech.common.view.DataGrid;
//import com.gientech.pcm.depCurr.PcmDepCurrVO;
//import com.gientech.pcm.loan.PcmLoanDTO4Update;
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = StartPcm.class)
//class PcmCustServiceTest extends BaseControllerTest {
//
//    @Autowired
//    private PcmCustService pcmCustService;
//
//    @Test
//    void saveCust() {
//        PcmCustDTO4Save pcmCustDTO4Save = new PcmCustDTO4Save();
//        pcmCustDTO4Save.setCustId("1");
//        pcmCustDTO4Save.setEcifCustId("1");
//        pcmCustDTO4Save.setCustName("1");
//        pcmCustDTO4Save.setLawOrgId("1");
//        pcmCustDTO4Save.setCertType("1");
//        pcmCustDTO4Save.setCertNo("1");
//        pcmCustDTO4Save.setCertAddr("1");
//        pcmCustService.saveCust(pcmCustDTO4Save);
//    }
//
//    @Test
//    void deleteCust() {
//        pcmCustService.deleteCust("1");
//    }
//
//    @Test
//    void updateCust() {
//        PcmCustDTO4Update dto = new PcmCustDTO4Update();
//        dto.setCustId("1689B_0001");
//        dto.setCustName("江南1");
//        // Set other properties
//        pcmCustService.updateCust(dto);
//    }
//
//    @Test
//    void listCust() {
//        PcmCustDTO4List pcmCustDTO4List = new PcmCustDTO4List();
//        pcmCustDTO4List.setPageNo(1);
//        pcmCustDTO4List.setPageSize(10);
//        System.out.println(pcmCustService.listCust(pcmCustDTO4List).getRows().get(0));
//    }
//
//    @Test
//    void listAssCust() {
//        PcmCustDTO4List dto = new PcmCustDTO4List();
//        dto.setPageNo(1);
//        dto.setPageSize(10);
////        System.out.println(pcmCustService.listAssCust(pcmCustDTO4List).getRows().get(0));
//        DataGrid<PcmCustVO> dataGrid = pcmCustService.listAssCust(dto);
//        if (dataGrid != null && dataGrid.getRows() != null) {
//            for (int i = 0; i < dataGrid.getRows().size(); i++) {
//                System.out.println("PcmCust: " + dataGrid.getRows().get(i));
//            }
//        }
//    }
//}