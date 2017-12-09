import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * Custom tree implementation to allow nodes to have multiple children
 * to accurately model thread conversation structures.
 * @author Vinay
 * The 'addElement' method requires you to provide the parent node in addition to the current node (that you want to add to the tree)
 * so that the current node is added as a child to the appropriate node.
 * The 'traverse' method uses a Depth First Search (Pre-Order traversing) method to retrive nodes.
 *
 */

public class Tree<T> {
	
    private Node<T> root;
    private String identifier;
    
    public Tree(Node<T> root,String identifier) {
        this.root=root;
        this.identifier=identifier;
    }
    
    public Node<T> getRoot(){
    	return this.root;
    }
    
    public String getIdentifier(){
    	return this.identifier;
    }
    

    @SuppressWarnings({ "unchecked", "rawtypes" })
	public void addElement(Node element,Node parent){
      Node<T> current = this.root;
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
      }
      
     }
    
    
	public String traverse(Node<T> node) {
		if(node == null) return null;
		T s=node.getData();
		String output=s.toString();
		List<Node<T>> children = node.getChildren();
		for(Node<T> t:children){
			output=output+" "+traverse(t);
		}
		return output;
    }

}
