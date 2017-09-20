import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
/**
 * Node used in tree structures to contain text from Wiki Comment
 * Allows multiple children per node.
 * @author Vinay
 *
 * @param <T>
 */

public class Node<T> {
    private List<Node<T>> children = new ArrayList<Node<T>>();
    private Node<T> parent = null;
    private T data = null;

    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> parent) {
        this.data = data;
        this.parent = parent;
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public void addChild(T data) {
        Node<T> child = new Node<T>(data);
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(Node<T> child) {
        child.setParent(this);
        this.children.add(child);
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean addElement(Node element,Node parent){
      Node<T> current = this;
      Deque<Node<T>> stack = new ArrayDeque<Node<T>>();
      if(!current.isLeaf()){
    	  for(Node<T> ch:current.getChildren()){
    		  stack.add(ch);
    	  }	
      }  

      while(!current.getData().equals((parent.getData())) && !stack.isEmpty()){
      	  current=stack.poll();
      	  if(!current.isLeaf()){
      		  for(Node<T> ch:current.getChildren()){
      			stack.push(ch);
      		  }
      	  }
      }

      if(current.getData().equals(parent.getData())){
    	  current.addChild(element);
    	  return true;
      }
      else{
    	  return false;
      }
      
      
     }

    public boolean isRoot() {
        return (this.parent == null);
    }

    public boolean isLeaf() {
        if(this.children.size() == 0) 
            return true;
        else 
            return false;
    }

    public void removeParent() {
        this.parent = null;
    }
}
