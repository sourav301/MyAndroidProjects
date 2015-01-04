package iPhone;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class controller
 */
@WebServlet("/controller")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public controller() {
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session =  request.getSession(true);
		
		System.out.println("Get Request From - "+request.getLocalAddr()+"\nRequesting For "+request.getParameter("requestpage"));
		PrintWriter w = response.getWriter();
		
		if(request.getParameter("requestpage").equals("home")){
			response.sendRedirect("index.jsp");
		}
		
		if(request.getParameter("requestpage").equals("login")){
			String user = request.getParameter("name");
			String pass = request.getParameter("password");
			int flag =MySqlAccess.checkLogin(user,pass);
			if(flag==1){
//				HttpSession session = request.getSession(true);
				session.setAttribute("username", user);
				response.sendRedirect("uploadfile.jsp");
			}
			else{
				response.sendRedirect("authenticationFailure.html");
			}
				
		}
		else if(request.getParameter("requestpage").equals("createuser")){
			response.sendRedirect("createAccount.html");
		}
		else if(request.getParameter("requestpage").equals("createaccount")){
			w.print("New Account");
			String user = request.getParameter("name");
			String pass = request.getParameter("password");
			int flag = MySqlAccess.createAccount(user,pass);
			if(flag==1){
				response.sendRedirect("userExists.html");
			}
			else{
				session.setAttribute("status", "created");
				response.sendRedirect("index.jsp");
			}
		}
		else if(request.getParameter("requestpage").equals("logout")){
			System.out.println("Session Invalidated");
			session.invalidate();
			response.sendRedirect("index.jsp");
		}
		else if(request.getParameter("requestpage").equals("homepage")){
			
			response.sendRedirect("index.jsp");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Post request from "+request.getLocalAddr());
		
		if(request.getParameter("requestpage").equals("uploadcontacts")){
			
			System.out.println("Session Started");
//			response.getWriter().print("SUCCESS");
			String contacts = request.getParameter("contacts");
			System.out.println("Contacts="+contacts);
			int newContact = XmlParse.parsethexml(request);
			response.getWriter().print(newContact);
			
		}
		else if (request.getParameter("requestpage").equals("downloadcontacts")){
			HttpSession session = request.getSession();
			String contacts=MySqlAccess.getContacts(session);
			System.out.println(contacts);
			response.getWriter().print(contacts);
			
		}
		
		
		
//		response.sendRedirect("index.jsp");
	}

}
