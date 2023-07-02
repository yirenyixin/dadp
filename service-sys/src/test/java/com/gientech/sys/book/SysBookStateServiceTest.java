package com.gientech.sys.book;

import com.gientech.sys.bookState.SysBookStateDTO4List;
import com.gientech.sys.bookState.SysBookStateDTO4Save;
import com.gientech.sys.bookState.SysBookStateService;
import com.gientech.sys.bookState.SysBookStateVO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gientech.common.view.DataGrid;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysBookStateServiceTest {

    @Autowired
    private SysBookStateService sysBookStateService;

    @Test
    public void list() {
        SysBookStateDTO4List dto = new SysBookStateDTO4List();
//        dto.setBookId("1");
        dto.setPageNo(1);
        dto.setPageSize(10);

        DataGrid<SysBookStateVO> dataGrid = sysBookStateService.listBookStates(dto);
        if (dataGrid != null && dataGrid.getRows() != null) {
            for (int i = 0; i < dataGrid.getRows().size(); i++) {
                System.out.println("Book State: " + dataGrid.getRows().get(i));
            }
        }
    }

    @Test
    public void save() {
        SysBookStateDTO4Save dto = new SysBookStateDTO4Save();
        dto.setBookId("Test");
        dto.setRoleId("Test Role");

        sysBookStateService.saveBookState(dto);
    }

    @Test
    public void delete() {
        String bookIds = "Test";
        sysBookStateService.deleteBookState(bookIds);
    }
}
