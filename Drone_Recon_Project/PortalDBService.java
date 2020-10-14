package com.dronerecon.ws;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*; 

public class PortalDBService extends HttpServlet{

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=utf-8");
        response.addHeader("Access-Control-Allow-Origin", "*");

        PrintWriter out = response.getWriter();

		// ############
		// Get 5 parameter values from the request object (these are passed in from part 1 code).
		// "area_id" : String type
                String areaId=request.getParameter("area_id");
		// "tilex" : int type (Reference part 1 of Project 2 for converting string to int).
                String tilex=request.getParameter("tilex");
                int itilex=Integer.parseInt(tilex);
		// "tiley"
                String tiley=request.getParameter("tiley");
                int itiley=Integer.parseInt(tiley);
		// "r"
                String r=request.getParameter("r");
                int red=Integer.parseInt(r);
		// "g"n
                String g=request.getParameter("g");
                int green=Integer.parseInt(g);
		// ############


		// ############
		// Instantiate a DBManager instance.
                DBManager oDBManager= new DBManager();
		// ############

        // Set DB location (Currently uses current DB file name and adds direct path from C drive before it).
        oDBManager.DBLocation = System.getProperty("catalina.base") + "\\webapps\\dronereconportal\\db\\" +
            oDBManager.DBLocation;

		// ############
		// Call insertAreaGridTile on db manager object and pass the 5 values from above
                oDBManager.insertAreaGridTile(areaId, itilex, itiley, red, green);
                // ############


        // Response with confirmation of DB record written.
        out.println("{\"success\":true}");
    }
}

