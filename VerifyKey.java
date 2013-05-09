import java.math.BigInteger;
import java.util.ArrayList;

public class VerifyKey {
  int cntr,rcntr,scntr;
	BigInteger p,q,g,r,s,z,w,u1,u2,y,v;
	String rtemp,stemp;
	
	ArrayList<String> hash = new ArrayList<String>();
	ArrayList<String> rval = new ArrayList<String>();
	ArrayList<String> sval = new ArrayList<String>();
	
	VerifyKey(ArrayList<String> rval1,ArrayList<String> sval1,ArrayList<String> hash1,
			BigInteger p1,BigInteger q1,BigInteger g1,BigInteger y1,int cntr1)
			{
				rval = rval1;
				sval = sval1;
				hash = hash1;
				p = p1;
				q = q1;
				g = g1;
				cntr=cntr1;
				y=y1;
				r = null; 
				s=null;
			}

	//this method verifies the signing done
	void keyverify()
	{
		for(int i = 0; i<cntr;i++)
		{
				r = new BigInteger(rval.get(i));
				s = new BigInteger(sval.get(i));
				w = s.modInverse(q);
				z = new BigInteger(hash.get(i),16); //since the hash is in hexadecimal, we convert it to biginteger 
				u1 = z.multiply(w).mod(q);	    //by giving hash.get(i),16
				u2 = r.multiply(w).mod(q);
				v = g.modPow(u1, p).multiply(y.modPow(u2, p)).mod(p).mod(q);
				if(r.compareTo(BigInteger.ZERO) == 1 && r.compareTo(q)== -1 
						&& s.compareTo(BigInteger.ZERO) == 1 && s.compareTo(q) == -1
						&& v.equals(r)) 
					System.out.println("Signature_valid");
				else
					System.out.println("Signature_invalid");
		}
	}
}
