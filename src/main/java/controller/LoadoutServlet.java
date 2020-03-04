/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.LineItem;
import data.Loadout;
import data.Weapon;
import java.io.IOException;
import java.io.PrintWriter;
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

        // create empty loadout
        Loadout loadout;
        ArrayList<LineItem> list;
        ArrayList<Weapon> weapons;

        synchronized (session) {
            loadout = (Loadout) session.getAttribute("loadout");
            weapons = (ArrayList<Weapon>) session.getAttribute("weapons");
            name = (String) session.getAttribute("name");
            weight = (String) session.getAttribute("weight");
        }

        if (loadout == null) { // if there doesn't exist a loadout from session attribute aka. first time using
            loadout = new Loadout(); // create empty loadout
        }

        if (request.getParameter("add") != null) { // add is pressed
            String addCode = request.getParameter("addCode");            
            // creating LineItem from code
            LineItem weapon = null;
            for (int i = 0; i < weapons.size(); i++) {
                if (weapons.get(i).getCode().equalsIgnoreCase(addCode)) { // if codes match
                    weapon = new LineItem(weapons.get(i), 1);
                }
            }
            loadout.addItem(weapon);
        }

        if (request.getParameter("remove") != null) {
            String removeCode = request.getParameter("removeCode");
            LineItem weapon = null;
            for (int i = 0; i < weapons.size(); i++) {
                if (weapons.get(i).getCode().equalsIgnoreCase(removeCode)) { // if codes match
                    weapon = new LineItem(weapons.get(i), 1);
                }
            }
            loadout.removeItem(weapon);
            
        }

        synchronized (session) {
            session.setAttribute("loadout", loadout);
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
