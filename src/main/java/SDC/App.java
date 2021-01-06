package SDC;


public class App {
	
	public static void main(String[] args) {
		Excel excel;
		Model model;
		
		try {
			excel = new Excel(args[0],0,1);
			model = new Model(excel.getContent());
			model.writeFoundPrimeNumbers();
		}
		catch (java.lang.ArrayIndexOutOfBoundsException e) {System.out.println("Input argument is empty.");}
		catch (java.io.FileNotFoundException e) {System.out.println("File is not found.");}
		catch (Exception e) {System.out.println("Another error:\n" + e);}
	}
	
}

