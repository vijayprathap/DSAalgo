import java.math.BigInteger;
import java.security.SecureRandom;

public class GenerateKey {
  int n;
	BigInteger g,p,q;
	SecureRandom rnd = new SecureRandom();
	GenerateKey(int n1,BigInteger g1,BigInteger q1,BigInteger p1)
	{
		n = n1;
		g = g1;
		q = q1;
		p = p1;
	}
	//this method generates n number of x,y key pairs
	void genkey()
	{
		for(int i = 0;i<n;i++)
		{
			BigInteger x = new BigInteger(160,rnd);    
			while(x.compareTo(q)>=0) 
			{
				x = new BigInteger(160,rnd);
			}
			System.out.println("x="+x.abs());
			BigInteger y = g.modPow(x, p);
			System.out.println("y="+y);
		}
	}
	

}
