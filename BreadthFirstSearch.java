import java.util.Iterator;
import java.util.LinkedList;
//Java program to print BFS traversal from a given source vertex.
public class BreadthFirstSearch {
		int V; // No. of vertices
	   LinkedList<Integer> adj[]; //Adjacency List using linkedlist
		@SuppressWarnings({ "unchecked", "rawtypes" })
		// Constructor
		BreadthFirstSearch(int V){
			this.V = V;
			adj = new LinkedList[V];
			for (int i=0; i<V; i++) // an iteration  for
				adj[i] = new LinkedList(); // creating a linkd list for every vertex
		}

// adding edges to the undirected graph
	   public void addEdge(int i,int j)
		{
			adj[i].add(j); //adding edges from vertex i to vertex j
			adj[j].add(i); //adding edges from vertex j to vertex i
		}
// The time complexity for this algorithm is O(V+E) where V is the number of Nodes we will visit during execution of this algorithm
//and E is the number of edges incident to a given vertex v(we are checking or looping over all the edges of every vertex)	
// the auxilliary space is O(V) because of the extra space of visited array we have created of size V 
// the space the algorithm needs to run is O(V) because at worst case we are holding V vertices in the queue
// therefore , the total space complexity for this algorithm is O(V) + O(V) for auxilliary space hence O(V + V);
// print BFS traversal from a given source s 
		public void BFS(int s){
// A boolean visited array is used  to mark the visited vertices.Iniatially mark all the vertices 
//as unvisited. set default to false
		boolean visited[] = new boolean[V];
			// Create a queue for BFS traversal
		LinkedList<Integer> queue = new LinkedList<Integer>();
			// Mark the current node as visited and enqueue it
		visited[s]=true;
		queue.add(s);
		while (queue.size() != 0)
			{
				// Dequeue the head vertex/ front vertex  from queue and print it
		s = queue.poll();
		System.out.print(s+" ");

			// Get all adjacent vertices of the dequeued vertex s/head vertex/ front vertex 
		    // If a adjacent vertex has not been visited, then mark it  visited and enqueue it
		Iterator<Integer> i = adj[s].listIterator(); // It is a java iterator that is used to traverse all types of lists including 
		                                             // arraylists , linkedlists , queues, stacks etc
			                                     // listIterator extends the iterator interface of the collections framework
			                                     // Its cursor always lies between the previous and next elements
			                                     // the previous() will return to the previous elements and the next() will return to the next element                                   
		while (i.hasNext()){ //while this linkedlist has a chain of elements/ adjacent vertices i  to the head vertex s,
			             // iterate over them using the listIterator
		int n = i.next(); // store next adjacent vertex i in a variable n 
		if (!visited[n]){  // check if this vertex is visited or not. If not visited 
		visited[n] = true;  // mark it as visited 
		queue.add(n);       // add it to the queue , repeat this process until all the adjacent vertices of s are added to the queue
		}
		}
			
		}
		}

		// Driver method to
		public static void main(String args[])
		{
			BreadthFirstSearch Graph = new BreadthFirstSearch(6);

			Graph .addEdge(0, 1);
			Graph .addEdge(0, 2);
			Graph .addEdge(1, 2);
			Graph .addEdge(2, 0);
			Graph .addEdge(2, 3);
			Graph .addEdge(3, 3);
			Graph. addEdge(3, 4);
			Graph. addEdge(4, 4);
			Graph. addEdge(4, 2);
			Graph. addEdge(5, 1);
			Graph. addEdge(5, 4);
			Graph. addEdge(5, 3);

			System.out.println("BFS starting from vertex 4 is : " );
			Graph.BFS(4);
		}
	}	

