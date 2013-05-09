import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;

public class SignKey {
  BigInteger x,g,p,q,r,s,z,k;
	int cntr;
	ArrayList<String> hash = new ArrayList<String>();
	SecureRandom rnd = new SecureRandom();
	SignKey(BigInteger x1,BigInteger g1,BigInteger p1,BigInteger q1,ArrayList<String> hash1,int cntr1)
	{
		x=x1;
		g=g1;
		p=p1;
		q=q1;
		hash = hash1;
		cntr = cntr1;
	}

	//this method performs the signing operation
	void keysign()
	{
		do
		{
			for(int i = 0; i < cntr; i++)
			{
				k = new BigInteger(160,rnd);    
				while(k.compareTo(q)>=0)			 
					k = new BigInteger(160,rnd);
				k.abs();
				r = g.modPow(k, p).mod(q);
				z = new BigInteger(hash.get(i),16); //since the hash is in hexadecimal, we convert it to biginteger 
				s = k.modInverse(q).multiply(z.add(x.multiply(r)).mod(q)).mod(q); //by giving hash.get(i),16
				System.out.println("r="+r);
		        	System.out.println("s="+s);
			}
		}
		while(r==BigInteger.ZERO || s==BigInteger.ZERO);
	}
}
