/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.LineItem;
import data.Weapon;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author andrei
 */
public class LoadoutServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
      
        HttpSession session = request.getSession();
        String name;
        String weight;
        
        //Loadout loadout = new Loadout();
        ArrayList<LineItem> list;
        ArrayList<Weapon> weapons;
        synchronized (session) {
            list = (ArrayList<LineItem>)session.getAttribute("list");
            weapons = (ArrayList<Weapon>)session.getAttribute("weapons");
            name = (String)session.getAttribute("name");
            weight = (String)session.getAttribute("weight");
        }
        
        
        
        if (list == null){
            list = new ArrayList<>();
            for (Weapon weapon : weapons) {
                list.add(new LineItem(weapon,0));
            }
        }
        if (request.getParameter("add") != null){
            String code = request.getParameter("add");
            for(LineItem item : list){
                if (item.getWeapon().getCode().equalsIgnoreCase(code)){
                    item.setQuantity(item.getQuantity()+1);
                }
            }
        }
        if (request.getParameter("remove") != null){
            String code = request.getParameter("remove");
            for(LineItem item : list){
                if (item.getWeapon().getCode().equalsIgnoreCase(code)){
                    item.setQuantity(item.getQuantity()-1);
                }
            }
        }
        
        

        synchronized (session) {
            session.setAttribute("list", list);
        }
        getServletContext().getRequestDispatcher("/loadout.jsp").forward(request, response);
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
