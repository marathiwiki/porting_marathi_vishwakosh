<%-- 
    Document   : upload
    Created on : 24 Jun, 2016, 8:25:46 PM
    Author     : yash
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.TreeMap"%>
<%@page import="com.yash.wikihack.Network_local"%>
<%@page import="com.yash.wikihack.uploadUtility"%>
<%@page import="javax.security.auth.login.FailedLoginException"%>
<%@page import="java.util.List"%>
<%@page import="info.bliki.api.Page"%>
<%@page import="info.bliki.api.query.Query"%>
<%@page import="info.bliki.api.Connector"%>
<%@page import="info.bliki.api.User"%>
<%@page import="info.bliki.html.wikipedia.ToWikipedia"%>
<%@page import="org.jsoup.Jsoup"%>
<%@page import="org.jsoup.nodes.Document"%>
<%@page import="org.jsoup.select.Elements"%>
<%@page import="info.bliki.html.HTML2WikiConverter"%>
<%@page import="com.yash.wikihack.WikiLibrary"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1></h1>
        
        <%
            String url = (String)request.getParameter("url");
            
            String title = (String)request.getParameter("title");
            out.print(url);
            out.print(title);
             Network_local networkObj = new Network_local();
              String domain = "https://marathivishwakosh.maharashtra.gov.in";
              String finUrl= domain+url;
              
              String resultWiki=uploadUtility.uploadUtil(finUrl);
              
              
              
              
              
              String userName = "test"; String passWord = "123456";
              networkObj.login(userName, passWord);      
                     
              
              
               String token = networkObj.getEditToken();
                networkObj.makeEdit(title, resultWiki, token);
              
            %>
    </body>
</html>
