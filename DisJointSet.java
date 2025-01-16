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
        nn.parent=n;// Path Compression
        return n;
    }
    public void union(int v1,int v2){
        Node n1=map.get(v1);
        Node n2=map.get(v2);
        Node rn1=find(n1);
        Node rn2=find(n2);
        //union by rank
        if(rn1.rank==rn2.rank){
            rn1.parent=rn2;
            rn2.rank+=1;
        }
        else if(rn1.rank>rn2.rank){
            rn2.parent=rn1;
        }
        else{
            rn1.parent=rn2;
        }
    }
}