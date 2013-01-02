/**
 * org.satriaprayoga.jacs.server
 */
package org.satriaprayoga.jacs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * AcsServlet.java
 * @author GILANG SATRIA PRAYOGA
 */
public abstract class AcsServlet extends HttpServlet{
	private static final long serialVersionUID = -6423473880224069493L;
	
	protected abstract void process(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		process(req, resp);
	}

}
