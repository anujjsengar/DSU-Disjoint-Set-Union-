import java.util.*;

public class Kruskal_Algorithm{
    HashMap<Integer,HashMap<Integer,Integer>> graph;
    public Kruskal_Algorithm(int v){
        this.graph=new HashMap<>();
        for(int i=0;i<=v;i++){
            graph.put(i,new HashMap<>());
        }
    }
    public void AddEdge(int v1,int v2,int cost){
        graph.get(v1).put(v2,cost);
        graph.get(v2).put(v1,cost);
    }
    public class EdgePair{
        int e1;
        int e2;
        int cost;
        EdgePair(int e1,int e2,int cost){
            this.e1=e1;
            this.e2=e2;
            this.cost=cost;
        }
    }
    public List<EdgePair> getAllEdge(){
        List<EdgePair> list=new ArrayList<>();
        for(int e1:graph.keySet()){
            for(int e2:graph.get(e1).keySet()){
                int cost=graph.get(e1).get(e2);
                list.add(new EdgePair(e1, e2, cost));
            }
        }
        return list;
    }
    public void Kruskal(){
        List<EdgePair> list=getAllEdge();
            Collections.sort(list,new Comparator<EdgePair>() {
                @Override
                public int compare(EdgePair o1,EdgePair o2){
                    return o1.cost-o2.cost;
                }
            });
            DisJointSet DSU=new DisJointSet();
            for(int v:graph.keySet()){
                DSU.Create(v);
            }
            int ans=0;
            for(EdgePair e:list){
                int re1=DSU.find(e.e1);
                int re2=DSU.find(e.e2);
                if(re1==re2){
                    System.out.println("cycle");
                }
                else{
                    DSU.union(re1, re2);
                    ans+=e.cost;
                }
            }
            System.out.println(ans);
    }
    public static  void main(String srgs[]){
            Kruskal_Algorithm pa = new Kruskal_Algorithm(7);
            pa.AddEdge(1, 2, 4);
            pa.AddEdge(1, 4, 7);
            pa.AddEdge(2, 3, 2);
            pa.AddEdge(4, 3, 5);
            pa.AddEdge(4, 5, 1);
            pa.AddEdge(6, 5, 3);
            pa.AddEdge(7, 5, 7);
            pa.AddEdge(7, 6, 2);
            
    }
}