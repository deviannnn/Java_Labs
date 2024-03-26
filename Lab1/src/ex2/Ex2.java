package ex2;

import vn.edu.tdtu.ArrayHandler;
import vn.edu.tdtu.ArrayOutput;

public class Ex2
{
	public static void main(String[] args)
	{
		int a[] = {12,2,34,5,6};
		int b[] = {1,19,11,78,22,0,53};
		ArrayOutput.print(a);
		ArrayOutput.print(b);
		int c[] = ArrayHandler.merge(a,b);
		ArrayOutput.print(c);
		ArrayHandler.sort(c);
		ArrayOutput.print(c);
		ArrayOutput.write(c, "output.txt");
	}
}