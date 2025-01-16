import java.util.HashMap;

public class DisJointSet{
    class Node{
        int vtx;
        int rank;
        Node parent;
    }
    private HashMap<Integer,Node> map=new HashMap<>();
    public void Create(int v){
        Node nn=new Node();
        nn.vtx=v;
        nn.parent=nn;
        nn.rank=0;
        map.put(v, nn);

    }
    public int find(int v){
        Node nn=map.get(v);
        return find(nn).vtx;
    }
    private Node find(Node nn){
        if(nn==nn.parent){
            return nn;
        }
        Node n=find(nn.parent);
        return n;
    }
    public void union(int v1,int v2){
        
    }
}