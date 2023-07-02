package com.gientech.sys.book;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gientech.common.view.DataGrid;

/**
 * 图书管理 - Service 层单元测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysBookServiceTest {

    @Autowired
    private SysBookService sysBookService;

    /**
     * 查询和分页
     */
    @Test
    public void list() {
        SysBookDTO4List dto = new SysBookDTO4List();
        dto.setPageNo(1);
        dto.setPageSize(10);

        DataGrid<SysBookVO> dataGrid = sysBookService.listBooks(dto);
        if (dataGrid != null && dataGrid.getRows() != null) {
            for (int i = 0; i < dataGrid.getRows().size(); i++) {
                System.out.println("Book: " + dataGrid.getRows().get(i));
            }
        }
    }

    /**
     * 新增图书
     */
    @Test
    public void save() {
        SysBookDTO4Save dto = new SysBookDTO4Save();
        dto.setBookId("Test");
        dto.setBookName("Test Book");
        dto.setAuthor("Test Author");
        dto.setRole("Updated role");
        dto.setRoleId("Updated roleid");

        sysBookService.saveBook(dto);
    }

    /**
     * 修改图书
     */
    @Test
    public void update() {
        SysBookDTO4Update dto = new SysBookDTO4Update();
        dto.setBookId("Test");
        dto.setBookName("Updated Book");
        dto.setAuthor("Updated Author");
        dto.setRole("Updated role");
        dto.setRoleId("Updated roleid");
        dto.setVer(1);

        sysBookService.updateBook(dto);
    }

    /**
     * 删除图书
     */
    @Test
    public void delete() {
        String bookIds = "Test";
        sysBookService.deleteBook(bookIds);
    }
}
