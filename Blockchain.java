package BlockExp;
import BlockExp.Block;
import java.util.*;
public class Blockchain
{
	public ArrayList<Block> chain=new ArrayList<Block>();
	public Blockchain()
	{
		chain.add(createGenesis());
	}
	public Block createGenesis()
	{
		Block newBlock=new Block(0,"G",0);
		return newBlock;
	}
	public Block getLatestBlock()
	{
		Block latestBlock=chain.get(chain.size()-1);
		return latestBlock;
	}
	public void addBlock(int data)
	{
		int newindex=getLatestBlock().index+1;
		String prevhash=getLatestBlock().hash;
		Block n=new Block(newindex,prevhash,data);
		chain.add(n);
	}
	public boolean isValid()
	{
		int flag=0;
		for(int i=1;i<this.chain.size();i++)
		{
			Block currentBlock=chain.get(i);
			Block previousBlock=chain.get(i-1);
			if(currentBlock.phash!=previousBlock.hash)
			{
				flag++;
			}
			String c_hash=currentBlock.hash;
			String c_recalc=currentBlock.calculateHash();
			if(c_hash.compareTo(c_recalc)!=0)
			{
				flag++;
			}
		}
		if(flag>0)
			return false;
		else
			return true;
	}
}

