package inmemdb.structures;

public class BinaryNode <T> {
	
	private T Hizq;
	private T Hder;
	private T value;
	
	public BinaryNode(T value) {
		this.value = value;
		
	}
	
	public T getHizq() {
		
		return Hizq;
	}
	
	public T getHder() {
		return Hder;
	}
	
	public void setHizq(T Hizq) {
		this.Hizq = Hizq;
		
	}
	
	public void setHder(T Hder) {
		this.Hder = Hder;
		
	}
	
	public T getData() {
		return value;
		
	}
	
	/**
	 * 
	 * @param value to remove
	 * @param parent of the node
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean remove(int value, BinaryNode parent) {
		
        if (value < (int) this.value) {//El valor a borrar es menor que el valor del nodo
              if (Hizq != null)//Node has at least one child
                    return ((BinaryNode) Hizq).remove(value, this);
              else//Node is a leaf
                    return false;
        } 
        
        else if (value > (int) this.value) {//Value is bigger than node's value
              if (Hder != null)//Node has at least one child
                    return ((BinaryNode) Hder).remove(value, this);
              else//Node is a leaf
                    return false;
        } 
        
        else {//Last node or it has the value
              if (Hizq != null && Hizq != null) {//Node still has children
                    this.value = (T) ((BinaryNode) Hder).minValue();//Get smaller value to use as new node
                    ((BinaryNode) Hder).remove((int) this.value, this);
                    
              }
              
              else if (parent.Hizq == this) {//Node is the same as left child of the parent
                    parent.Hizq = (Hizq != null) ? Hizq : Hder;
              }
              
              else if (parent.Hder == this) {//Node is the same as right child of the parent
                    parent.Hder = (Hder != null) ? Hizq : Hder;
              }
              
              return true;
        }
  }

	public T minValue() {
        if (Hizq == null)
              return value;
        else
              return (T) ((BinaryNode) Hizq).minValue();
	}
}
