package com.gientech.pcm;

import com.gientech.pcm.loan.PcmLoanService;
import com.gientech.pcm.loan.PcmLoanDTO4List;
import com.gientech.pcm.loan.PcmLoanDTO4Save;
import com.gientech.pcm.loan.PcmLoanDTO4Update;
import com.gientech.pcm.loan.PcmLoanVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gientech.common.view.DataGrid;

/**
 * PcmLoan - Service 层单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PcmLoanServiceTest {

    @Autowired
    private PcmLoanService pcmLoanService;

    /**
     * 查询和分页
     */
    @Test
    public void list() {
        PcmLoanDTO4List dto = new PcmLoanDTO4List();
        dto.setPageNo(1);
        dto.setPageSize(10);

        DataGrid<PcmLoanVO> dataGrid = pcmLoanService.listPcmLoan(dto);
        if (dataGrid != null && dataGrid.getRows() != null) {
            for (int i = 0; i < dataGrid.getRows().size(); i++) {
                System.out.println("PcmLoan: " + dataGrid.getRows().get(i));
            }
        }
    }

    /**
     * 新增 PcmLoan
     */
    @Test
    public void save() {
        PcmLoanDTO4Save dto = new PcmLoanDTO4Save();
        dto.setLoanId("Test");
        dto.setCustId("Test CustId");
        dto.setEcifCustId("Test EcifCustId");
        dto.setCustName("Test CustName");
        dto.setLawOrgId("Test LawOrgId");
        dto.setProdCode("Test ProdCode");
        dto.setProdName("Test ProdName");
        dto.setLoanAcct("Test LoanAcct");
        dto.setLoanAcctName("Test LoanAcctName");
        dto.setLoanContNo("Test LoanContNo");
        dto.setVoucherNo("Test VoucherNo");
        dto.setLoanMon(1000.00);
        dto.setGrantMon(500.00);
        dto.setLoanBal(500.00);
        dto.setBadBal(200.00);
        dto.setLoanType("Test LoanType");
        dto.setLoanSts("Test LoanSts");
        dto.setStartDate("2023-07-07");
        dto.setEndDate("2024-07-07");
        dto.setRate(0.05);
        dto.setLoanTerm(12);
        dto.setLoanCurrency("CNY");
        dto.setNextRepaymentMon(100.00);
        dto.setNextRepaymentDate("2023-08-01");
        dto.setLoanFiveForm("10");
        dto.setOpenOrgNo("Test OpenOrgNo");
        dto.setMgrId("Test MgrId");
        dto.setRepayAcct("Test RepayAcct");
        dto.setRepayName("Test RepayName");
        dto.setLoanUse("Test LoanUse");
        // Set other properties

        pcmLoanService.savePcmLoan(dto);
    }

    /**
     * 修改 PcmLoan
     */
    @Test
    public void update() {
        PcmLoanDTO4Update dto = new PcmLoanDTO4Update();
        dto.setLoanId("Test");
        dto.setCustId("Updated CustId1");
        dto.setEcifCustId("Updated EcifCustId1");
        dto.setCustName("Updated CustName1");
        // Set other properties

        pcmLoanService.updatePcmLoan(dto);
    }

    /**
     * 删除 PcmLoan
     */
    @Test
    public void delete() {
        String loanIds = "Test";
        pcmLoanService.deletePcmLoan(loanIds);
    }
}