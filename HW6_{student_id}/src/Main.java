import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

public class Main
{
	public static void main(String[] args) throws IOException{
		//root node
		WebPage rootPage = new WebPage("http://soslab.nccu.edu.tw/Welcome.html", "Soslab");		
		WebTree tree = new WebTree(rootPage);
		//build childnode
		tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Publications.html","Publication")));
		tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Projects.html","Projects")));
		tree.root.children.get(1).addChild(new WebNode(new WebPage("https://vlab.cs.ucsb.edu/stranger/", "Stranger")));
		tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Members.html", "MEMBER")));
		tree.root.addChild(new WebNode(new WebPage("http://soslab.nccu.edu.tw/Courses.html","Course")));
		// This website has something wrong, ignore it.
		
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

}