import java.util.*;

public class Dijskra_Algorithm {
    HashMap<Integer,HashMap<Integer,Integer>> graph;
    public Dijskra_Algorithm(int v){
        this.graph=new HashMap<>();
        for(int i=0;i<=v;i++){
            graph.put(i,new HashMap<>());
        }
    }
    public void AddEdge(int v1,int v2,int cost){
        graph.get(v1).put(v2,cost);
        graph.get(v2).put(v1,cost);
    }
    public class Dijskra_Node{
        int vtx;
        String path;
        int cost;
        Dijskra_Node(int vtx,String path,int cost){
            this.vtx=vtx;
            this.cost=cost;
            this.path=path;
        }
        @Override
        public String toString(){
        return vtx+"  "+path+" @ "+cost;
    }
    }
    public void Dijskra(int src){
        HashSet<Integer> visited=new HashSet<>();
        PriorityQueue<Dijskra_Node> pq=new PriorityQueue<>(new Comparator<Dijskra_Node>() {
            @Override
                public int compare(Dijskra_Node o1,Dijskra_Node o2){
                    return o1.cost-o2.cost;
                }
        });
        pq.add(new Dijskra_Node(src, ""+src, 0));
        while(!pq.isEmpty()){
            Dijskra_Node curr=pq.poll();
            if(visited.contains(curr.vtx)){
                continue;
            }
            visited.add(curr.vtx);
            System.out.println(curr.toString());
            for(int neigh:graph.get(curr.vtx).keySet()){
                if(!visited.contains(neigh)){
                    int cost=graph.get(curr.vtx).get(neigh);
                    pq.add(new Dijskra_Node(neigh,curr.path+neigh,curr.cost+cost));
                }
            }
        }
    }
    public static  void main(String srgs[]){
        Dijskra_Algorithm pa = new Dijskra_Algorithm(7);
        pa.AddEdge(1, 2, 4);
        pa.AddEdge(1, 4, 7);
        pa.AddEdge(2, 3, 2);
        pa.AddEdge(4, 3, 5);
        pa.AddEdge(4, 5, 1);
        pa.AddEdge(6, 5, 3);
        pa.AddEdge(7, 5, 7);
        pa.AddEdge(7, 6, 2);
        pa.Dijskra(1);
}
}
