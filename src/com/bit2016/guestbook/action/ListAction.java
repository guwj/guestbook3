package com.bit2016.guestbook.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2016.guestbook.dao.GuestbookDao;
import com.bit2016.guestbook.vo.GuestbookVo;
import com.bit2016.web.Action;
import com.bit2016.web.util.WebUtil;

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestbookDao dao = new GuestbookDao();
		List<GuestbookVo> list = dao.getList();

		// request 범위에 모델 데이터 저장
		request.setAttribute("list", list); // list를 list라는 이름으로 request객체에
											// 넣는 작업, view에서 list를 사용할 수 있게
											// 하기 위함

		WebUtil.forward(request, response, "/WEB-INF/views/deleteform.jsp");
	}

}
