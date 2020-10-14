<html>

<body>

<%@ page import="com.dronerecon.ws.AreaGridTile" %>

<%@ page import="com.dronerecon.ws.DBManager" %>
<%@ page import="java.util.ArrayList"%>
<% String areaID=request.getParameter("area_id");%>
<% DBManager dbmanager= new DBManager(); %>
<%dbmanager.DBLocation = System.getProperty("catalina.base") +"\\webapps\\dronereconportal\\db\\" + dbmanager.DBLocation; %>
<% ArrayList<AreaGridTile> oTiles =dbmanager.readAreaGridTiles(areaID);%>
<% int temp=0; %>
<% int xcorred=0; %>
<% int ycorred=0; %>
<% for(int i=0; i<oTiles.size();i++){
	if(oTiles.get(i).r>temp){
		temp=oTiles.get(i).r;
		xcorred=oTiles.get(i).x;
		ycorred=oTiles.get(i).y;
	}
		
}%>
<p> Highest red value is at: <%out.println(xcorred+","+ycorred);%> <p/>

<% int xcorgreen=0; %>
<% int ycorgreen=0; %>
<% for(int i=0; i<oTiles.size();i++){
	if(oTiles.get(i).g>temp){
		temp=oTiles.get(i).g;
		xcorgreen=oTiles.get(i).x;
		ycorgreen=oTiles.get(i).y;
	} 
		
}%>
<p> Highest green value is at: <%out.println(xcorgreen+","+ycorgreen);%> <p/>


<body/>

<html/>
 