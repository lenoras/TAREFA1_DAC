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
   
        if(nome=="")
            nome = "Fulano";
        
        msg = cumprimentos+nome+"! "+" São "+this.date.getHour()+" horas e "+this.date.getMinute()+" minutos.";

        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body><div class=\"container\"><div class=\"row\">");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</div></div></body>");
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
        
        if(lang==null)
            lang = "pt";
        
        if(nome=="")
            nome = "Fulano";
        
        msg = cumprimentos+nome+"! "+" São "+this.date.getHour()+" horas.";

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body><div class=\"container\"><div class=\"row\">");           
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</div></div></body>");
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
