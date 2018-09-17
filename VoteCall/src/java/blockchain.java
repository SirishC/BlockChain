/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.GsonBuilder;
import java.util.*;

/**
 *
 * @author sirish
 */
@WebServlet(urlPatterns = {"/blockchain"})
public class blockchain extends HttpServlet {
    

      /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static ArrayList<Block> blockchain = new ArrayList<Block>();
    public static boolean isCheck(){
        Block currentBlock;
        Block PreviousBlock;

        for(int i=1 ;i< blockchain.size();i++){
            currentBlock = blockchain.get(i);
            PreviousBlock = blockchain.get(i-1);
            if(!currentBlock.PreviousHash.equals(PreviousBlock.Hash)){
                return false;
            }
        }
     return  true;
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            blockchain.add(new Block("Genesis Block !","0"));
            
            String data = request.getParameter("voteres");
            blockchain.add(new Block(data, blockchain.get(blockchain.size() - 1).Hash));
            String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet blockchain</title>");            
            out.println("</head>");
            out.println("<body>");
            if(isCheck())
                out.println("Chain Status : Safe <br>");
            else
                out.println("Chain Status : Broken! <br> ");
            out.println(blockchainJson);
            out.println("</body>");
            out.println("</html>");
        }
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
