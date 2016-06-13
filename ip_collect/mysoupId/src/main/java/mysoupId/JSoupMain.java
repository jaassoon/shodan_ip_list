package mysoupId;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupMain {

	public static void main(String[] args) {
		String sMode="";
		if (args.length > 0) {
			sMode =args[0];//"href";
		}
		try {
			File input = null;
			String fileFullName;
			if (args.length > 1) {
			    	fileFullName = args[1];
			        input = new File(fileFullName);
			        System.exit(1);
			}else{
				input = new File("/Users/jason/Documents/Dropbox/Public/dlink/index.html");
			}
			
			Document doc = Jsoup.parse(input, "UTF-8", "");
			//default mode
			if(sMode.equals("")){
			Elements masthead = doc.select("div.ip");
			Iterator iterator =masthead.iterator();
			while(iterator.hasNext()) {
				Element el = (Element) iterator.next();
				Element href=el.select("a[href]").first();
				//href.childNode(0);
				
				System.out.println(href.childNode(0));
				}
			}else if(sMode.equalsIgnoreCase("href")){
				Elements masthead = doc.select("div.ip");
				Iterator iterator =masthead.iterator();
				while(iterator.hasNext()) {
					Element el = (Element) iterator.next();
					Element href=el.select("a[href]").first();
//					href.childNode(0);
					String[] sTmp=href.attr("href").split(":");
					String ip=sTmp[1].substring(2, sTmp[1].length());
					System.out.println(ip);
					}
			}
			String s="";
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
