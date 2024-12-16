import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class Main
{
	public static void main(String[] args) throws IOException{
		//root node
		WebPage rootPage = new WebPage("http://soslab.nccu.edu.tw/Welcome.html", "Soslab");		
		WebTree tree = new WebTree(rootPage);
		
		generateChildren(tree.root, 1);
		System.out.println("Children generated. Please enter keywords as usual.");
		
		Scanner scanner = new Scanner(System.in);

		while (scanner.hasNextLine()){
			int numOfKeywords = scanner.nextInt();
			ArrayList<Keyword> keywords = new ArrayList<Keyword>();

			for (int i = 0; i < numOfKeywords; i++){
				String name = scanner.next();
				double weight = scanner.nextDouble();
				Keyword k = new Keyword(name, weight);
				keywords.add(k);
			}

			tree.setPostOrderScore(keywords);
			tree.eularPrintTree();
		}
		scanner.close();
	}
	
	private static String fetchContent(String urlStr)
	{
		try {
			URL url = new URL(urlStr);
			URLConnection conn = url.openConnection();
			conn.setConnectTimeout(3000);
			InputStream in = conn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			String retVal = "";

			String line = null;

			while ((line = br.readLine()) != null)
			{
				retVal = retVal + line + "\n";
			}

			return retVal;
		} catch(Exception e) { //If something goes wrong, return empty string. Page will be skipped, tree won't branch out from this site. Site will receive score 0
			return "";
		}
	}
	
	private static void generateChildren(WebNode parent, int depth) {
		if (depth >= 4) {
			return;
		}
		String content = fetchContent(parent.webPage.url);
		Pattern pattern = Pattern.compile("href=\\\"(http://[^\\\"]+)\\\"", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(content);
		
		int i = 0;
		while (matcher.find()) {
			i++;
			if(i >= 10) {
				break;
			}
			parent.addChild(new WebNode(new WebPage(matcher.group(1), String.valueOf(matcher.group(1)))));
		}
		for(WebNode child : parent.children) {
			generateChildren(child, depth+1);
		}
	}

}