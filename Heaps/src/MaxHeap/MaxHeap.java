package MaxHeap;

public class MaxHeap {
	private int [] heap;
	private int heapSize;
	public MaxHeap() {};
	public MaxHeap(int[] inputArray) {
		this.heap = inputArray;
		this.heapSize = inputArray.length;
	}
	public int[] maxHeapify() {
		if (!this.isEmpty()) {
			for (int i = heapSize/2; i >=0; i--) {
				heapifyUp(i);
			}
		}
		return this.heap;
	}
	private boolean isEmpty() {
		return this.heapSize == 0;
	}
	private void heapifyUp(int i) {
		if (!indexIsInBounds(i))
			return;
		int leftChildIndex = i*2+1;
		int rightChildIndex = i*2+2;
		this.swapElementsOnMaxHeapViolation(i,leftChildIndex,rightChildIndex);
		heapifyUp(this.getParentIndex(i));
	}
	private boolean indexIsInBounds(int i) {
		return i < 0 || i >= this.heapSize;
	}
	private int setLeftChildIndex(int i) {
		if (indexIsInBounds(i*2+1))
			return i*2+1;
		else return i;
	}
	private int setRightChildIndex(int i) {
		if (indexIsInBounds(i*2+2))
			return i*2+2;
		else return i;
	} 
	private void swapElementsOnMaxHeapViolation(int parentIndex, int leftChildIndex, int rightChildIndex) {
		if (leftChildIndex > rightChildIndex) {
			if (leftChildIndex > parentIndex) {
				this.swap(parentIndex, leftChildIndex);
			}
		} else if (rightChildIndex > parentIndex) {
			this.swap(parentIndex,rightChildIndex);
		}
	}
	private void swap(int parentIndex, int swapIndex) {
		int parentValue = this.heap[parentIndex];
		this.heap[parentIndex] = this.heap[swapIndex];
		this.heap[swapIndex] = parentValue;
		//this.swapElementsOnMaxHeapViolation(parentIndex, this.setLeftChildIndex(parentIndex), this.setRightChildIndex(parentIndex));
	}
	private int getParentIndex(int i) {
		return i/2+2;
	}
}
