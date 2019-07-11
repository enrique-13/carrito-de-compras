package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ServletValidar", urlPatterns = {"/ServletValidar"})
public class ServletValidar extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        switch (path) {
            case "/ServletValidar":
                validar(request, response);
                break;

        }

    }

    protected void validar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        HttpSession sesion = request.getSession();
        
        String sUsuario = request.getParameter("usuario");
        String sClave = request.getParameter("clave");

        String email = (String) sesion.getAttribute("miEmail");
        String password = (String) sesion.getAttribute("miPassword");

        if (email.equals(sUsuario) && password.equals(sClave)) {
            response.sendRedirect("micuenta.jsp");
        } else {
            response.sendRedirect("index.jsp");
            out.println("<script>alert('Usuario o contraseña incorrectos');</script>");
        }

    }
    /* protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        HttpSession sesion = request.getSession();
        String sUsuario = request.getParameter("usuario");
        String sClave = request.getParameter("clave");
        
        if (sesion.getAttribute("email").equals(sUsuario) && sesion.getAttribute("password").equals(sClave)) {
            response.sendRedirect("micuenta.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
     */
}