
import java.util.*;
public class KeywordList {
	
	private LinkedList<Keyword> lst;
	
	public KeywordList(){
		this.lst = new LinkedList<Keyword>();
		
	}
	public void add(Keyword keyword){
		// 1. add keyword to proper index base on its count . DECENDING SORT BY COUNT AND WEIGHT
		// Smaller count placed in the front. If equal, smaller weight is placed in the front.

		
		
		lst.add(keyword);
		// printKeywordList(lst) : check if elements are sorted 
		//	printKeywordList(lst);
	}
	public void outputIndex(int i){ 
		if(i > lst.size()){
		    System.out.println("InvalidOperation");
		    return;
		}
		
		LinkedList<Keyword> results = new LinkedList<>();
		Keyword k = lst.get(i);		    
		results.add(k);		    		
		printKeywordList(results);
	}
		
	public void outputCount(int c){
		// 2. output all keywords whose keyword is equal to c
	}
	
	public void outputHas(String pattern){
		LinkedList<Keyword> results = new LinkedList<>();
		for(int i = 0; i < lst.size(); i++){
		    Keyword k = lst.get(i);
		    if(k.name.contains(pattern)){
		    	results.add(k);
		    }
		}
		if(results.isEmpty()){
		    System.out.println("NotFound");
		}else{
		    printKeywordList(results);
		}
	}
	
	public void outputName(String pattern){
		
		LinkedList<Keyword> results = new LinkedList<>();
		for(int i = 0; i < lst.size(); i++){
		    Keyword k = lst.get(i);
		    if(k.name.equals(pattern)){
		    	results.add(k);
		    }
		}
		if(results.isEmpty()){
		    System.out.println("NotFound");
		}else{
		    printKeywordList(results);
		}
	}
	
	public void outputFirstN(int n){
		if(n > lst.size()){
		    System.out.println("InvalidOperation");
		    return;
		}
		String result ="";
		for(int i = 0; i < n; i++){
		    Keyword k = lst.get(i);
		    result = result + k + " ";
		}
		System.out.println(result);
	}
	
	public void outputScore(){
		float results = 0;
		for(int i = 0; i < lst.size(); i++){
		    Keyword k = lst.get(i);
		    results += k.weight * k.count;
		}
		
		System.out.println(results);
	}
	
	public void deleteIndex(int i){
		if(i>=lst.size()){
		    return;
		}	
		lst.remove(i);
	}

	public void deleteCount(int c){
		// 3. remove nodes that the count is equal to c
		
	}

	public void deleteHas(String pattern){
		// 4. remove nodes that the name contains input name

	}
	
	public void deleteName(String name){
		// 5. remove nodes that the name is equal to input name
		
		}
		
	}
	
	public void deleteFirstN(int n){
		//6. remove first n nodes
	

	}
	
	public void deleteAll(){
		lst = new LinkedList<Keyword>();
	}
		
	private void printKeywordList(LinkedList<Keyword> kLst){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < kLst.size(); i++){
			Keyword k = kLst.get(i);
			if(i > 0) sb.append(" ");
			sb.append(k.toString());
		}
		System.out.println(sb.toString());
	}
}



