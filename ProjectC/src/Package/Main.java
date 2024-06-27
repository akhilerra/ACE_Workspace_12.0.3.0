package Package;

public class Main {

	public static void main(String[] args) {
		Cpu jannPC = new Intel();
		Cpu akhilPC = new Ryzen();
		
		String janninfo = jannPC.GetInfo("Intel", "8gb", "128gb");
		System.out.println(janninfo);
		String akhilinfo = akhilPC.GetInfo("Ryzen", "16gb", "256gb");
		System.out.println(akhilinfo);
	}
}
