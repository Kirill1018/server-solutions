package serverSolutions;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import java.io.File;
import java.io.FileWriter;
/**
 * Servlet implementation class ServerSolutions
 */
@WebServlet("/serverSolutions")
public class ServerSolutions extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServerSolutions() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("serverSolutions.jsp");//redirection query from interface with realization of increasing functional abilities of server
		requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String total = request.getParameter("amount"), goal = request.getParameter("purpose");//sum & target
		File file = new File("список трат.txt");//abstract representation of file and directory pathnames
		try (FileWriter writer = new FileWriter(file, true)) {//writing text to character files using default buffer size
			String text = total + "   " + goal + "\n";//addition part of file
			writer.write(text);
			writer.flush();
		}
		catch(IOException iOException) { }
		this.doGet(request, response);
	}
}