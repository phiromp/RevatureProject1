package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.util.ConnectionFactory;

@SuppressWarnings("serial")
public class TableServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in the table do get");
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>All HEROS</title>");
		out.println("<link href=\"https://fonts.googleapis.com/css?family=Roboto:300,400,500,700\" rel=\"stylesheet\">\r\n" + 
				"    <link rel=\"stylesheet\" href=\"https://use.fontawesome.com/releases/v5.4.1/css/all.css\">");
		out.println("<style>");
		out.println(".icon {");
		out.println("font-size: 110px;");
		out.println("display: flex;");
		out.println("justify-content: center;");
		out.println("}");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<center><h1>All HEROS</h1>");
		out.println("<div class='icon'>");
		out.println("<i class='fas fa-user-circle'></i>");
		out.println("</div>");
		String sql = "select s.hero_name, s.true_identity, a.super_type \r\n" + 
					"	from project1.superhuman s left join superhuman_alignment a\r\n" + 
					"	on s.alignmentid = a.alignmentid ;";

		ResultSet rs = ConnectionFactory.getResultSet(sql);

		out.println("</center>");
		out.println("<div class='container' style='background-color: #D0C806; align=center;'>");
		out.println("<span><a href='Register'> | | Add Super Human | </a></span>");
		out.println("<span><a href='Remove'> | Remove Super Human | </a></span>");
		out.println("<span><a href='Update'> | Update Super Human | | </a></span>");
        out.println("</div>");
        out.println("<TABLE BORDER><TR style='font-size:24px;'><TH>Super Human<TH>True Identity<TH>Human Type</TR>");
        try {
			while(rs.next()) {
			    out.format("<TR ALIGN=LEFT><TD>%s<TD>%s<TD>%s%n", rs.getString(1), rs.getString(2), rs.getString(3) );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        out.println("</TABLE>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	    
	}

}


