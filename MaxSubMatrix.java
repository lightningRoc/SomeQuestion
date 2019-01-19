import java.util.Stack;

/**
 * give a matrix and the elements' value are 1 or 0
 * return the maximum subMatrix's area if all the subMatrix's elements are 1
 * @author PC
 *
 */

public class MaxSubMatrix {
	
	public static int maxSize(int[][] rec)
	{
		if(rec==null||rec.length==0||rec[0].length==0)
		{
			return 0;
		}
		
		int res=0;
		int[] aux=new int[rec[0].length];
		for(int i=0;i<aux.length;i++)
		{
			aux[i]=0;
		}
		
		for(int i=0;i<rec.length;i++)
		{
			for(int j=0;j<rec[0].length;j++)
			{
				aux[j]= rec[i][j]==0? 0:aux[j]+1;
			}
			res=Math.max(res, auxMax(aux));
			
		}
		
		return res;
	}
	
	public static int auxMax(int[] aux)
	{
		if(aux==null||aux.length==0)
		{
			return 0;
		}
		
		int res=0;
		Stack<Integer> auxStack=new Stack<Integer>();
		for(int i=0;i<aux.length;i++)
		{
			while(!auxStack.isEmpty()&&aux[i]<=aux[auxStack.peek()])
			{
				int j=auxStack.pop();
				int k=auxStack.isEmpty()? -1:auxStack.peek();
				int curArea=(i-k-1)*aux[j];
				res=Math.max(res, curArea);
			}
			auxStack.push(i);
		}
		while(!auxStack.isEmpty())
		{
			int j=auxStack.pop();
			int k=auxStack.isEmpty()? -1:auxStack.peek();
			int curArea=(aux.length-k-1)*aux[j];
			res=Math.max(res, curArea);
		}
		
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//test data
		int[][] test= {{1,0,1,1},{1,1,1,1},{1,1,1,0}};
		System.out.println(MaxSubMatrix.maxSize(test));
	}

}
