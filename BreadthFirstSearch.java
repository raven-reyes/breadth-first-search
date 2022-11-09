import java.util.Iterator;
import java.util.LinkedList;
//Java program to print BFS traversal from a given source vertex.
// The time complexity for this algorithm is O(V+E) where V is the number of Nodes
// and E is the number of edges
// The space complexity is O(V) because we are creating a linkedlist for every vertex
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
		Iterator<Integer> i = adj[s].listIterator();
		while (i.hasNext()){
		int n = i.next();
		if (!visited[n]){
		visited[n] = true;
		queue.add(n);
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

			System.out.println("BFS starting from vertex 2 is : " );
			Graph.BFS(4);
		}
	}	

