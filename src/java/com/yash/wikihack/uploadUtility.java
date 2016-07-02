/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yash.wikihack;

import info.bliki.html.HTML2WikiConverter;
import info.bliki.html.wikipedia.ToWikipedia;
import java.io.IOException;
import static java.lang.System.out;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.TreeMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author yash
 */
public class uploadUtility {
    public static String uploadUtil(String URL) throws IOException{
        System.setProperty("jsse.enableSNIExtension", "false"); 
                 Document init = Jsoup.connect(URL).validateTLSCertificates(false).timeout(0).get();
                 Elements elems=init.select("a[href*=showall=1&limitstart=]");
                 System.out.println(elems+"Outtt: "+elems.html());
                 String domain = "https://marathivishwakosh.maharashtra.gov.in";
                 
                 String finUrl;
                 
                 if(!elems.isEmpty())
                    finUrl= domain+(elems.get(0)).attr("href");
                 else
                     finUrl = URL;
                 
        HTML2WikiConverter conv = new HTML2WikiConverter();
         
         //Cleaning of HTML
         
         Document doc = Jsoup.connect(finUrl).validateTLSCertificates(false).timeout(0).get();
         Elements elements = doc.getElementsByClass("item-page");
         Elements pTags = elements.select("p");
         
                 
         pTags.select("img").remove();
         pTags.select("a").remove();
         
//         String result = pTags.html();
         
         //Conversion to Wiki
         
         conv.setInputHTML(pTags.html());
         String result = conv.toWiki(new ToWikipedia());
         return result;
    }
    
    public static String khandCrawler(String khandNumber) throws IOException{
        System.setProperty("jsse.enableSNIExtension", "false");
        
        String baseURL = "https://marathivishwakosh.maharashtra.gov.in/";
        String khandURL = "https://marathivishwakosh.maharashtra.gov.in/khandas/khand";
        String finalURL = khandURL + khandNumber + "/";
        
        System.out.println("Final URL: " + finalURL);
        
        Document doc = Jsoup.connect(finalURL).validateTLSCertificates(false).timeout(0).get();
        Elements suchiDivs = doc.select("table").select("p").select("a");
        
       // HashMap<String, String> linkList = new HashMap<>();
        String result ="";
        for(Element suchiDiv : suchiDivs) {
//            linkList.put(suchiDiv.html(), suchiDiv.attr("href"));
            result+=suchiDiv.html()+":<a href=\"upload.jsp?url="+ URLEncoder.encode(suchiDiv.attr("href"), "UTF-8") +"&title="+suchiDiv.html() +" \">Upload</a><br/>";
            
        }
        
        return result;
    }
}
