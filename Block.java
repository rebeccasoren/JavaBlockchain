package BlockExp;

import java.util.*;
import java.security.MessageDigest;
import java.math.BigInteger;

public class Block
{
	public int index;
	public String hash;
	public String phash;
	public int data; 
	/* data can be of datatype
	But for simplicity purposes it is kept as int 
	Feel free to expriment*/ 
	public Block(int index,String phash,int data)
	{
		this.index=index;
		this.phash=phash;
		this.data=data;
		this.hash=this.calculateHash();
	}
	public String calculateHash()
	{
		/*this part ould be switched with any other ecoding algorithm*/
		String hashtext=new String();
		String h=index+phash+(data/23);
		try
		{
			MessageDigest md=MessageDigest.getInstance("SHA-256");
			byte[] encodedhash=md.digest(h.getBytes());
			BigInteger no=new BigInteger(1,encodedhash);
			hashtext=no.toString(16);
			while(hashtext.length()<32)
				hashtext="0"+hashtext;
		}
		catch(Exception e)
		{

		}
		finally
		{
			return hashtext;
		}
	}
}
