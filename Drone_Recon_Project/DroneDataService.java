package com.dronerecon.ws;



import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*; 
import java.util.*;
import java.security.SecureRandom;

// Classes for reading web service.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

/**
 *
 * @author Your Name Here :-)
 */
public class DroneDataService extends HttpServlet{


    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json;charset=utf-8");
        response.addHeader("Access-Control-Allow-Origin", "*");

        PrintWriter out = response.getWriter();

        // ##############################
        // 1. Get params passed in.

        // Get the following parameters from the request object and put them into strings:
        // area_id
        String areaid=request.getParameter("area_id");
        // tilex
        String tilex=request.getParameter("tilex");
        int itilex=Integer.parseInt(tilex);
        // tiley
         String tiley=request.getParameter("tiley");
        int itiley=Integer.parseInt(tiley);
        // totalcols
        String totalcols=request.getParameter("totalcols");
        int itotalcols=Integer.parseInt(totalcols);
        // totalrows
         String totalrows=request.getParameter("totalrows");
        int itotalrows=Integer.parseInt(totalrows);
        //r
        String red=request.getParameter("r");
        //g
        String green=request.getParameter("g");
        // ##############################
        String sServiceReturnJson="";    
        try {
              
            // Call weather API.
            //http://127.0.0.1:8080/dronereconportal/PortalDBService?area_id=1&tilex=1&tiley=1&r=1&g=1
            URL url = new URL("http://127.0.0.1:8080/dronereconportal/PortalDBService?area_id="+areaid+"&tilex="+itilex+"&tiley="+itiley+"&r="+red+"&g="+green);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String strTemp = "";
            while (null != (strTemp = br.readLine())) {
                    sServiceReturnJson += strTemp;
            }
            }catch (Exception ex) {
            ex.printStackTrace();
        }
        


        // ##############################
        // 2. Default value of beginning direction.
        String sDirection="right";
        // Set a string called sDirection to "right".
        // ##############################



        // ##############################
        // 3. Calculate next drone move.
        
        // Determine next tile to move to.
        // Base this on current x and y.
        // Change sDirection if necessary.
        // Drone must serpentine from top left of grid back and forth down.
        // If rows are done, change sDirection to "stop".
        // check if on even row
        if(itiley % 2==0){
            
            //check if tilex is last
            if(itilex!=itotalcols-1){
                itilex++;
            // (if those doesnt work, add sDirection="right";)
            //this is when the drone is done with the current row.    
            }else{
                
                itiley++;
                sDirection="left";
            }
            
            }else{
            
            //check if end of row while its going to the left
            if(itilex!=0){
                itilex--;
            sDirection="left";
            
            }else{
             itiley++;
             sDirection="right";
                }
            //check if dron is end of grid
            if(itiley==itotalrows){
                sDirection="stop";
            }
        }
        // ##############################



        // ##############################
        // 4. Format & Return JSON string to caller.

        /* Return via out.println() a JSON string like this:
        {"area_id":"[area id from above]", "nextTileX":"[next tile x]", "nextTileY":"[next tile y]", "direction":"[direction string from above]"}
        */
        
        out.println("{\"area_id\":\""+areaid+"\","+
                "\"nextTileX\":\""+itilex+"\","+
                 "\"nextTileY\":\""+itiley+"\","+
                  "\"direction\":\""+sDirection+"\"}");
        // ##############################

    
    }
}

