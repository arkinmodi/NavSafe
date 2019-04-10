import java.io.IOException;

public class SortIntersectionDropDown {
	
	public static Comparable<Intersection> auxiliary[]; //Auxiliary array for merging

	// Merges left and right halves for merge sort
	private static void merge(Comparable[] x, int low, int mid, int high) {
		int i = low, j = mid + 1;
		for (int k = low; k <= high; k++)
			auxiliary[k] = x[k];
		for (int k = low; k <= high; k++)
			if (i > mid)
				x[k] = auxiliary[j++];
			else if (j > high)
				x[k] = auxiliary[i++];
			else if (less(auxiliary[j], auxiliary[i]))
				x[k] = auxiliary[j++];
			else
				x[k] = auxiliary[i++];
	}

	// Less func. for Comparable objects
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	/**
	 * top-down merge sort using Comparable
	 * 
	 * The algorithm was written with reference to the course textbook.
	 * 
	 * @param x - the input array containing products that need to be sorted.
	 * @param n - the size of the input array
	 */

	public static void sort(Comparable[] x, int n) {
		auxiliary = new Comparable[n];
		sortMergeTD(x, 0, n - 1);
	}

	private static void sortMergeTD(Comparable[] x, int low, int high) {
		// Sorts x from index low to high
		if (high <= low)
			return;
		int mid = low + (high - low) / 2;
		// Right half
		sortMergeTD(x, mid + 1, high);
		// Left half
		sortMergeTD(x, low, mid); // error - check here
		// Merge sorted left and right
		merge(x, low, mid, high);
	}
	
	//Uncomment to test
//	public static void main(String[] args) throws IOException {
//		Intersection[] intersections = ReadIntersections.read();
//		
//		sort(intersections, intersections.length);
//		
//		System.out.println(intersections[intersections.length-6]);
//		System.out.println(intersections[intersections.length-5]);
//		System.out.println(intersections[intersections.length-4]);
//		System.out.println(intersections[intersections.length-3]);
//		System.out.println(intersections[intersections.length-2]);
//		System.out.println(intersections[intersections.length-1]);
//		
//	}
}
