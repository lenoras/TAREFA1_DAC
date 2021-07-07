/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author viter com modificações de Lenora Schwaitzer
 */
@WebServlet("/alomundo")
public class HelloServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LocalDateTime date = LocalDateTime.now();
   
  /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      
    	String msg = "";
        
        String lang = request.getParameter("lang");
        String nome = request.getParameter("nome");
        String cumprimentos = this.cumprimentos(lang);
        String horas = this.horas(lang);
   
        if(nome=="")
            nome = "Fulano";
        
        msg = cumprimentos+nome+"! "+horas;

        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\n"
            		+ "    ");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head><br><div class=\"container\"><div class=\"row\"><div class=\"col-md-9 ms-md-auto\"><br>");
            out.println("<h1><p class=\"text-danger\">Servlet HelloServlet</p></h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</div></div></div><script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n"
            		+ "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n"
            		+ "    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n"
            		+ "    </body>");
            out.println("</html>");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msg = "";
        
        String lang = request.getParameter("lang");
        String nome = request.getParameter("nome");
        String cumprimentos = this.cumprimentos(lang);
        String horas = this.horas(lang);
        
        if(nome=="")
            nome = "Fulano";
        
        msg = cumprimentos+nome+"! "+horas;
        
        if(lang==null)
            lang = "pt";

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\n"
            		+ "    ");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head><br><div class=\"container\"><div class=\"row\"><div class=\"col-md-9 ms-md-auto\"><br>");           
            out.println("<h1><p class=\"text-danger\">Servlet HelloServlet</p></h1>");
            out.println("<p>" + msg + "</p>");
            out.println("<a href=\".index.html\" class=\"badge badge-light\">" + "Retorna" + "</a>");
            out.println("</div></div></div><script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n"
            		+ "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n"
            		+ "    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n"
            		+ "    </body>");
            out.println("</html>");
        }
    }
    
    public String cumprimentos (String lang) {
    	String mensagem = "";
    	
        if(lang==null)
            lang = "pt";
    	switch (lang){
			case "pt":
				
				if(this.date.getHour() >= 6 && this.date.getHour() <=12) {
					mensagem = " Bom dia, ";
	}			else if (this.date.getHour() > 12 && this.date.getHour() <=18) {
					mensagem = " Boa tarde, ";
	}			else { 
					mensagem = " Boa noite, ";
	}
				break;
			case "en":
				if(this.date.getHour() >= 6 && this.date.getHour() <=12) {
					mensagem = " Good morning, ";
	}			else if (this.date.getHour() > 12 && this.date.getHour() <=18) {
					mensagem = " Good afternoon,";
	}			else {
					mensagem = " Good evening, ";
	}
			break;
			case "fr":
				if(this.date.getHour() >= 6 && this.date.getHour() <=12) {
					mensagem = "Bonjour, ";
	}			else if (this.date.getHour() > 12 && this.date.getHour() <=18) {
					mensagem = " Bonne après-midi, ";
	}			else {
					mensagem = " Bonne soirée, ";	
	}
			break;
			case "de":
				if(this.date.getHour() >= 6 && this.date.getHour() <=12) {
					mensagem = "Guten Morgen, ";
	}			else if (this.date.getHour() > 12 && this.date.getHour() <=18) {
					mensagem = " guten Nachmittag, ";
	}			else {
					mensagem = " Guten Abend, ";	
	}
			break;
			case "es":
				if(this.date.getHour() >= 6 && this.date.getHour() <=12) {
					mensagem = "Buenos días, ";
	}			else if (this.date.getHour() > 12 && this.date.getHour() <=18) {
					mensagem = " Buenas tardes, ";
	}			else {
					mensagem = " Buenas noches, ";	
	}
			break;
			case "it":
				if(this.date.getHour() >= 6 && this.date.getHour() <=12) {
					mensagem = "Buongiorno, ";
	}			else if (this.date.getHour() > 12 && this.date.getHour() <=18) {
					mensagem = " Buon pomeriggio, ";
	}			else {
					mensagem = " Buonasera, ";	
	}
			break;
			default:
				mensagem = "erro";
				break;
}
		return mensagem;
    	}
    
    public String horas (String lang) {
    	String mensagem = "";
    	
        if(lang==null)
            lang = "pt";
    	switch (lang){
			case "pt":
					mensagem = " São "+this.date.getHour()+" horas e "+this.date.getMinute()+" minutos.";
				break;
			case "en":
				mensagem = " It's "+this.date.getHour()+" hours and "+this.date.getMinute()+" minutes.";
				break;
			case "fr":
				mensagem = " Il es "+this.date.getHour()+" heures et "+this.date.getMinute()+" minutes.";
				break;
			case "de":
				mensagem = " Es sind "+this.date.getHour()+" Stunden und "+this.date.getMinute()+" Minuten.";
				break;
			case "es":
				mensagem = " Son "+this.date.getHour()+" horas y "+this.date.getMinute()+" minutos.";
				break;
			case "it":
				mensagem = " Sono "+this.date.getHour()+" ore e "+this.date.getMinute()+" minuti.";
				break;
			default:
				mensagem = "erro";
				break;
}
		return mensagem;
    	}
    

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
