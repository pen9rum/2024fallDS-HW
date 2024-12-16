
import java.io.*;

public class Main {
	public static void main(String args[]) throws IOException {
		BufferedReader buf = new BufferedReader(new InputStreamReader(System.in)); 
		System.out.print("Please enter your weight(kg) and height(cm): "); 
		String text = buf.readLine(); 
		String[] data = text.split(" ");
		double res = getBMI(data);
		String dia = getDiagnosis(res);
		System.out.println(dia + " BMI: " + res);
	}
	
	public static double getBMI(String[] data) {
		// 1. calculate the bmi 
		// result bmi = weight(kg) / (height(m) * height(m))
		double weight = Integer.parseInt(data[0]);
		double height = Integer.parseInt(data[1]);
		double bmi =  weight/ Math.pow(height/100,2);
		return bmi;
	}
	
	public static String getDiagnosis(double bmi) {
		// 2. give comments depending on bmi
		if (bmi >= 30) return "You are not in shape. Actually, you are not even close.";
		if (bmi >= 26) return "To be honest, you are not in shape.";
		if (bmi >= 20) return "You are in shape.";
		return "You are under shape.";
	}
}
