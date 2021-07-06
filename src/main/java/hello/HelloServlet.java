/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

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

        String cumprimentos = this.cumprimentos("lang");
        String lang = request.getParameter("lang");
        String nome = request.getParameter("nome");
        
        if(nome=="")
            nome = "Fulano";
        
        if(lang==null)
            lang = "pt";
        switch(lang){
            case "pt":
                msg = "Alô, ";
                break;
            case "en":
                msg = "Hello, ";
                break;
            case "fr":
                msg = "Bonjour, ";
                break;
            case "de":
                msg = "Hallo, ";
                break;
            case "es":
                msg= "¡Hola!, ";
                break;
            case "it":
                msg= "Ciao, ";
                break;  
        }
        msg = msg+nome+"! "+cumprimentos+" São "+this.date.getHour();

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
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
    public String cumprimentos (String lang) {
    	String mensagem = "";
    	
        if(lang==null)
            lang = "pt";
    	switch (lang){
			case "pt":
				if(this.date.getHour() >= 6 && this.date.getHour() <=12) {
					mensagem = " Bom dia!";
	}			else if (this.date.getHour() > 12 && this.date.getHour() <=18) {
					mensagem = " Boa tarde!";
	}			else {
					mensagem = " Boa noite!";
	}
				break;
			case "en":
				if(this.date.getHour() >= 6 && this.date.getHour() <=12) {
					mensagem = " Good morning!";
	}			else if (this.date.getHour() > 12 && this.date.getHour() <=18) {
					mensagem = " Good afternoon!";
	}			else {
					mensagem = " Good evening!";
	}
			break;
			case "fr":
				if(this.date.getHour() >= 6 && this.date.getHour() <=12) {
					mensagem = "";
	}			else if (this.date.getHour() > 12 && this.date.getHour() <=18) {
					mensagem = " Bonne après-mmidi!";
	}			else {
					mensagem = " Bonne soirée!";	
	}
			break;
			case "de":
				if(this.date.getHour() >= 6 && this.date.getHour() <=12) {
					mensagem = "Guten Morgen!";
	}			else if (this.date.getHour() > 12 && this.date.getHour() <=18) {
					mensagem = " guten Nachmittag!";
	}			else {
					mensagem = " Guten Abend!";	
	}
			break;
			case "es":
				if(this.date.getHour() >= 6 && this.date.getHour() <=12) {
					mensagem = "Buenos días!";
	}			else if (this.date.getHour() > 12 && this.date.getHour() <=18) {
					mensagem = " Buenas tardes!";
	}			else {
					mensagem = " Buenas noches!";	
	}
			break;
			case "it":
				if(this.date.getHour() >= 6 && this.date.getHour() <=12) {
					mensagem = "Buongiorno!";
	}			else if (this.date.getHour() > 12 && this.date.getHour() <=18) {
					mensagem = " Buon pomeriggio!";
	}			else {
					mensagem = " Buonasera!";	
	}
			break;
			default:
				mensagem = "erro";
				break;
}
		return mensagem;
    	}
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String msg = "";
        
        String lang = request.getParameter("lang");
        String nome = request.getParameter("nome");
        String cumprimentos = this.cumprimentos(lang);
        
        if(lang=="")
            lang = "pt";
        switch(lang){
            case "pt":
                msg = "Alô, ";
                break;
            case "en":
                msg = "Hello, ";
                break;
            case "fr":
                msg = "Bonjour, ";
                break;
            case "es":
                msg = "Hallo, ";
                break;
            case "de":
                msg = "Hallo, ";
                break;
        }
        
        if(nome==null)
            nome = "Fulano";
        
        msg = msg+nome+"! "+cumprimentos+" São "+this.date.getHour();

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet HelloServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HelloServlet</h1>");
            out.println("<p>" + msg + "</p>");
            out.println("</body>");
            out.println("</html>");
        }
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
