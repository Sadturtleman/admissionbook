package com.sadturtleman.model;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Croller {
    
    public String[][] crollWeb(){
        String url = "http://www.edujin.co.kr/news/articleList.html?page=1&total=279&sc_section_code=&sc_sub_section_code=S2N213&sc_serial_code=&sc_area=&sc_level=&sc_article_type=&sc_view_level=&sc_sdate=&sc_edate=&sc_serial_number=&sc_word=&box_idxno=&sc_multi_code=&sc_is_image=&sc_is_movie=&sc_user_name=&sc_order_by=E";

        try {
            Document doc = Jsoup.connect(url).get();
            Elements elements = doc.select("#section-list > ul > li");
            String[][] arr = new String[elements.size()][2];

            for (int i = 0; i < elements.size(); i++){
                arr[i] = getschoolinfo(elements.first());
                elements = elements.next();
            }
            return arr;

        } catch (IOException e) {
            return null;
        }
    }
    
    private String getSchoolurl(String url){
        return "http://www.edujin.co.kr" + url;
    }

    // [years, schoolname, schoolexamurl]
    private String[] getschoolinfo(Element element){
        return new String[]{
            element.select("h4").text().split(" ")[0],
            element.select("h4").text().split(" ")[1],
            getSchoolurl(element.select("h4 > a").attr("href"))                                                                                                                                                                                                                                                                                       
        };
    }
}
