import BlockExp.Blockchain;
class Main
{
	public static void main(String args[])
	{
		Blockchain b=new Blockchain();
		System.out.println(b.getLatestBlock().hash);
		b.addBlock(3);
		System.out.println(b.getLatestBlock().hash);
		b.addBlock(6);
		System.out.println(b.getLatestBlock().hash);
		System.out.println(b.isValid());
	}
}
