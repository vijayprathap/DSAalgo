import java.math.BigInteger;
import java.io.*;
import java.util.*;
public class signature {
  /*compiling instructions
	  after using javac, compile the file as java signature <"name of file"
	*/
	private static BigInteger x; 
	static boolean invalidflag;
	//checks if the the tuples p,q,g are valid	
	private void isvalid(BigInteger a,BigInteger b,BigInteger c) 
	{	
		if( c.isProbablePrime(80) && b.isProbablePrime(80) && c.bitLength() == 1024 && 	 	//probability that the given big integer
			b.bitLength() == 160 && c.subtract(BigInteger.ONE).mod(b).equals(BigInteger.ZERO) && 	// is prime is 1-2^(-80)
				a.modPow(b, c).equals(BigInteger.ONE) && a.compareTo(BigInteger.ONE) >0)
			System.out.println("valid_group");
		else
		{
			invalidflag = true;
			System.out.println("invalid_group");
		}
	}
	
	public static void main(String[] args) {
		boolean genkey = false, sign = false, verify = false,valid = false;
		BigInteger p = null,q = null,g = null,y = null;
		String p1=null,q1=null,g1=null,x1,y1,d,r1=null,s1=null;
		int n = 0,cntr=0;
		signature s = new signature();
		InputStreamReader i = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(i);
		ArrayList<String> hash = new ArrayList<String>();
		ArrayList<String> rval = new ArrayList<String>();
		ArrayList<String> sval = new ArrayList<String>();
		String line;
		try{
		while((line=br.readLine())!= null)		//gets input from user and checks for matches with characters given
		{
			if(line.contains("p"))
			{
				p1 = line.substring(2,line.length());
				p = new BigInteger(p1);
			}
			if(line.contains("q"))
			{
				q1 = line.substring(2,line.length());
				q = new BigInteger(q1);
			}
			if(line.contains("g="))
			{
				g1 = line.substring(2,line.length());
				g = new BigInteger(g1);
				
			}
			if(p1!=null && q1!=null && g1!=null)
			{
				valid = true;	
			}
			if(line.contains("genkey"))
			{
				genkey = true;
			}
			if(line.contains("n="))
			{
				String n1 = line.substring(2,line.length());
				n = Integer.parseInt(n1);
			}
			if(line.contains("sign"))
			{
				sign = true;
			}
			if(line.contains("x="))
			{
				x1 = line.substring(2,line.length());
				x = new BigInteger(x1);
			}
			if(line.contains("y="))
			{
				y1 = line.substring(2,line.length());
				y = new BigInteger(y1);
			}
			if(line.contains("D="))
			{
				cntr++;
				d = line.substring(2, line.length());
				hash.add(d);
			}
			if(line.contains("r="))
			{
				r1 = line.substring(2, line.length());
				rval.add(r1);
			}
			if(line.contains("s="))
			{
				s1 = line.substring(2,line.length());	
				sval.add(s1);
			}
			if(line.contains("verify"))
				verify = true;
		}
		}
		catch (IOException e){
			System.err.println("illegal input" +e);
		}

		GenerateKey j = new GenerateKey(n,g,q,p);
		SignKey sk = new SignKey(x,g,p,q,hash,cntr);
		VerifyKey vk = new VerifyKey(rval,sval,hash,p,q,g,y,cntr);
		if(valid)
			s.isvalid(g, q, p);  
		if(genkey && !invalidflag)  
			j.genkey();	     
		if(sign)
			sk.keysign();
		if(verify)
			vk.keyverify();
	}
}
