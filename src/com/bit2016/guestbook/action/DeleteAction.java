package com.bit2016.guestbook.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2016.guestbook.dao.GuestbookDao;
import com.bit2016.guestbook.vo.GuestbookVo;
import com.bit2016.web.Action;
import com.bit2016.web.util.WebUtil;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// delete 구현
		String no = request.getParameter("no");
		String pass = request.getParameter("pass");

		GuestbookVo vo = new GuestbookVo();
		vo.setNo(Long.parseLong(no));
		vo.setPassword(pass);

		GuestbookDao dao = new GuestbookDao();
		dao.delete(vo);

		WebUtil.redirect(request, response, "/guestbook2/gb");
	}

}
