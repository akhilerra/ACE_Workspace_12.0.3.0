package Package;

public class Ryzen implements Cpu {

	@Override
	public String GetInfo(String processor, String msize, String ssd) {
		String info = ("Processor = "+ processor + "\n" + "Memory = " + msize + "\n" + "RAM = " + ssd);
		return info;
	}

}
