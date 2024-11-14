import java.util.PriorityQueue;

public class KeywordHeap
{
	private PriorityQueue<Keyword> heap;

	public KeywordHeap()
	{
		this.heap = new PriorityQueue<Keyword>(10, new KeywordComparator());
	}

	public void add(Keyword k)
	{
		heap.offer(k);
	}

	public void peek()
	{
		1.//Define peek
	}

	public void removeMin()
	{
		// YOUR TURN
		// 2. remove minimal element and print it

	}

	public void output()
	{
		// YOUR TURN
		// 3. print the output in order and remove all element
		StringBuilder sb = new StringBuilder();
		Keyword k;

		System.out.println(sb.toString());
	}
}
