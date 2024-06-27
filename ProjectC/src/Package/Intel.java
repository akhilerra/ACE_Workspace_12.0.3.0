package Package;

public class Intel implements Cpu{
	
	public String GetInfo(String processor, String msize, String ssd) {
		String info = ("Processor = "+ processor + "\n" + "Memory = " + msize + "\n" + "RAM = " + ssd);
		return info;
	}
}
