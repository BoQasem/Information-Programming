import java.util.*;

public class Graph {
    ArrayList<ArrayList<Node>> allList;  

    Graph(){
        allList = new ArrayList<>(); 
    }

    void addNode(Node node){
        ArrayList<Node> currList = new ArrayList<>(); 
        currList.add(node); 
        allList.add(currList); 
    }

    void addEdge(int src, int dst){
        ArrayList<Node> currList = allList.get(src);
        Node firstNodeDst = allList.get(dst).get(0); 
        currList.add(firstNodeDst);  
    }

    boolean checkEdge(int src, int dst){
        ArrayList<Node> currList = allList.get(src); 
        Node firstNodeDst = allList.get(dst).get(0); 

        for(int i=0; i<currList.size(); i++){
            if(currList.get(i) == firstNodeDst)
                return true; 
        }
        return false;
    }

    void print(){
        for(int i=0; i<allList.size(); i++){
            for(int j=0; j<allList.get(i).size(); j++){
                System.out.print(allList.get(i).get(j).data + " -> "); 
            }
            System.out.println(); 
        }
    }
}
    