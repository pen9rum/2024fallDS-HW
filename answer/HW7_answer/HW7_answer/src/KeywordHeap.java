import java.util.PriorityQueue;

public class KeywordHeap {
	private PriorityQueue<Keyword> heap;

	public KeywordHeap() {
		this.heap = new PriorityQueue<Keyword>(10, new KeywordComparator());
	}

	public void add(Keyword k) {
		heap.offer(k);
	}

	public void peek() {
		// 1.Define peek
		if (heap.isEmpty()) {
			System.out.println("InvalidOperation");
		} else {
			System.out.println(heap.peek());
		}
	}

	public void removeMin() {
		// YOUR TURN
		// 2. remove minimal element and print it
		if (heap.isEmpty()) {
			System.out.println("InvalidOperation");
		} else {
			System.out.println(heap.poll());
		}

	}

	public void output() {
		// YOUR TURN
		// 3. print the output in order and remove all element
		if (heap.isEmpty()) {
			System.out.println("InvalidOperation");
		} else {
			PriorityQueue<Keyword> tempHeap = new PriorityQueue<>(heap);
			StringBuilder sb = new StringBuilder();
			while (!tempHeap.isEmpty()) {
				sb.append(tempHeap.poll().toString() + " ");
			}
			System.out.println(sb.toString());
		}
	}
}
