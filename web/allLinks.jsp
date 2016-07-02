<%-- 
    Document   : allLinks
    Created on : Jun 26, 2016, 5:25:01 PM
    Author     : rishabh
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
        <title>All Links</title>
    </head>
    <body>
        <h1 class="w3-light-grey w3-black w3-container">Crawled Links</h1>
        
         <% 
//                WikiLibrary wikiObj = new WikiLibrary("en.wikipedia.org");
//                Network_local networkObj = new Network_local();
//                HTML2WikiConverter conv = new HTML2WikiConverter();
                //conv.setInputHTML("<b>hello<em>world</em></b>");
//                String result = conv.toWiki(new ToWikipedia());
//                out.println(result+"<br/>");
                
//                Document doc = Jsoup.connect("http://en.wikipedia.org/").get();
//                Elements newsHeadlines = doc.select("#mp-itn b a");
                
//                out.println(newsHeadlines.toString());   
//                String domain = "https://marathivishwakosh.maharashtra.gov.in/";
//                String constantURL = "https://marathivishwakosh.maharashtra.gov.in/khandas/khand";
//                String appendData = "1";
//                String finalURL = constantURL + appendData;
                
//                System.setProperty("jsse.enableSNIExtension", "false");

//                Document doc = Jsoup.connect("https://marathivishwakosh.maharashtra.gov.in/khandas/khand1/index.php/23-2015-02-10-05-12-54/1-2015-09-08-11-05-07?showall=1&limitstart=").validateTLSCertificates(false).get();
//                
                
//                String userName = "yashtest"; String passWord = "yash1234";
//                networkObj.login(userName, passWord);
//                try {
//                    wikiObj.login(userName, passWord);
//                } catch(FailedLoginException ex) {
//                    out.println("Login Failed: " + ex.getMessage());
//                }
                
//                String khandURL = "https://marathivishwakosh.maharashtra.gov.in/khandas/khand" + "1" + "/";
//                Document doc = Jsoup.connect("https://marathivishwakosh.maharashtra.gov.in/khandas/khand1/").validateTLSCertificates(false).timeout(36000).get();
//                Elements suchiDivs = doc.getElementsByClass("accordionfaqitem");
//                out.println("The size is: " + suchiDivs.size());
                
//                out.println(uploadUtility.khandCrawler("1"));

//                  TreeMap<String, String> linkList = uploadUtility.khandCrawler("1");
                  
//                  

//                 out.println(uploadUtility.khandCrawler("3"));
                  
//                    System.setProperty("jsse.enableSNIExtension", "false");
//        
//                    String baseURL = "https://marathivishwakosh.maharashtra.gov.in/";
//                    String khandURL = "https://marathivishwakosh.maharashtra.gov.in/khandas/khand";
//                    String finalURL = khandURL + "1" + "/";
//
//                    System.out.println("Final URL: " + finalURL);
//
//                    Document doc = Jsoup.connect(finalURL).validateTLSCertificates(false).timeout(0).get();
//                    Elements suchiDivs = doc.select("table").select("p").select("a");

//                    for(int i=0; i < suchiDivs.size(); i++) {
//                        out.println("The values are: " + suchiDivs.get(i).html() + " : " + suchiDivs.get(i).attr("href") + "<br>");
//                    }

                  //HashMap<String, String> links = new HashMap<>();
                  //links = uploadUtility.khandCrawler("1");
                  
             String num = (String)request.getParameter("enter");
                  out.print(uploadUtility.khandCrawler(num));
                  
                
//                  Iterator it = links.entrySet().iterator();
//                    while (it.hasNext()) {
//                        Map.Entry pair = (Map.Entry)it.next();
//                        out.println(pair.getKey() + " = " + pair.getValue());
//                        it.remove(); // avoids a ConcurrentModificationException
//                    }
    
//                String resultWiki = uploadUtility.uploadUtil("https://marathivishwakosh.maharashtra.gov.in/khandas/khand1/index.php/23-2015-02-10-05-12-54/1-2015-09-08-11-05-07?showall=1&limitstart=");
//                out.println(resultWiki);
//                String token = networkObj.getEditToken();
//                networkObj.makeEdit("User:Yashtest", "This has been changed!" + resultWiki, token);
//                try {
//                    wikiObj.edit("User:Yashtest", resultWiki, "This is test summary!");
//                } catch(Exception ex) {
//                    out.println("Exception Thrown!" + ex.getMessage());
//                }

//                HTML2WikiConverter conv = new HTML2WikiConverter();
//                conv.setInputHTML("<b>hello<em>world</em></b>");
//                String result = conv.toWiki(new ToWikipedia());
//                out.println(result);
                
        %>
        
    </body>
</html>
