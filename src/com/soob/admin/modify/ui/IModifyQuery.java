package com.soob.admin.modify.ui;

import com.soob.main.vo.BookVO;

public interface IModifyQuery {
	
	public void modify(BookVO book, int menu, int searchNo, String str);
}
