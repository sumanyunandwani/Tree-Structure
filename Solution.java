import java.util.*;
import java.text.*;

//ID is a class for the HashSet in java. It includes id, value,Owner's Name.

class ID
{
	int id;
	float val;
	String own_name;
	
	//Constructor Calling
	
	public ID(int idd, float vall, String ss)
	{
		id = idd;
		val = vall;
		own_name = ss;
	}
}

//This is the node class consisting of all the variables listed in the question.

class Node
{
	Date timestamp;
	String data;
	int nodeNumber;
	float value;
	String nodeId;
	Node left;
	Node right;
	Node father;
	HashSet<ID> set = new HashSet<ID>();

	//Initializing all the variables. Not used constructor as child's quantity is not defined
 
	public void initialize(Date dat, int id, float val, String own_name,int nodeNO,String unique)
	{
		this.value = val;
		this.nodeId = unique;
		this.nodeNumber = nodeNO;
		this.timestamp = dat;
		this.data = "abcdefghijk"+id+"abcdefghijk"+val+"abcdefghijk"+own_name;
		ID as = new ID(id,val,own_name);
		this.set.add(as);
		this.left = null;
		this.right = null;	
	}

	//Adding the new nodes in the tree using this pointer in java.

	public int add(Node abc)
	{
		if(this.left == null)
		{
			this.left = abc;
			abc.father = this;
		}
		else if(this.right == null)
		{
			if(this.value >= this.right.value + abc.value)
			{
				this.right = abc;
			}
		}
		else
		{
			if(this.left.value>= abc.value)
			{
				this.left.left = abc;
				abc.father = this.left;
			}
			else
			{
				this.right.left = abc;
				abc.father = this.right;		 	
			}
			return 1;
		}
		return 0;
	}	
}

//Main class for the program

public class Solution
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int i=-1;
		try{
		
		//Scanning all the elements of the Root element and then asking for the child.

		System.out.println("Enter the Genesis Node Details : ");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dat = formatter.parse("2012-12-24");
		System.out.println("Owner ID : ");
		int id = scan.nextInt();
		String s = scan.nextLine();
		System.out.println("Value : ");
		float val = scan.nextFloat();
		s = scan.nextLine();
		System.out.println("Owner Name : ");
		String own_name = scan.nextLine();
		s = "abcdefghijklmnopqrstuvwxyzabcde"+i;
		Node parent = new Node();
		parent.initialize(dat,id,val,own_name,i,s);
		parent.father = null;
		System.out.println("Want to add records ? (0 : NO/1 :YES)");
		int check = scan.nextInt();
		s = scan.nextLine();
		i++;
		Node[] child = new Node[10];
		int jk = 0;
		
		//Loop for adding children in this data structure.
		
		while(check == 1)
		{

			//Scanning the details of the Node.

			System.out.println("Enter the Node Details : ");
			dat = formatter.parse("2012-12-24");
			System.out.println("Owner ID : ");
			id = scan.nextInt();
			s = scan.nextLine();
			System.out.println("Value : ");
			val = scan.nextFloat();
			s = scan.nextLine();
			System.out.println("Owner Name : ");
			own_name = scan.nextLine();
			s = "abcdefghijklmnopqrstuvwxyzabcde"+i;
			child[i].initialize(dat,id,val,own_name,i,s);

			//Checking if the parent node consisits of 2 nodes or not

			if(jk == 0)	
				jk = parent.add(child[i]);
			else
				jk = child[0].add(child[i]);
			
						
			System.out.println("Total nodes : "+(i+2));
			System.out.println("Height of the tree"+(i+2)/2);

			//Asking for another Child.

			System.out.println("Want to add records ? (0 : NO/1 :YES)");
			check = scan.nextInt();
			i++;
		}}catch(Exception e){}
	}
}