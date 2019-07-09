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
	public Block(int index,String phash,int data)
	{
		this.index=index;
		this.phash=phash;
		this.data=data;
		this.hash=this.calculateHash();
	}
	public String calculateHash()
	{
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
