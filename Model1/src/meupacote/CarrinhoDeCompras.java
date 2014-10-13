package meupacote;

import java.util.Vector;

import javax.annotation.ManagedBean;

@ManagedBean
public class CarrinhoDeCompras {
	
	Vector<String> v;
	String cmd=null;
	
	public CarrinhoDeCompras() {
		v=new Vector<String>();
	}
	
	private void add(String[] objs){
		for(int i=0;i<objs.length;i++){
			v.addElement(objs[i]);
		}
	}
	
	private void remove(String[] objs){
		for(int i=0;i<objs.length;i++){
			v.removeElement(objs[i]);
		}
	}
	
	public void setCmd(String s){
		cmd=s;
	}
	
	public String[] getProds(){
		String[] s=new String[v.size()];
		v.copyInto(s);
		return s;
	}
	
	public void process(String[] prods){
		if(prods!=null && cmd!=null){
			if(cmd.equals("add")){
				add(prods);
			} else {
				remove(prods);
			}
			reset();
		}
	}
	
	private void reset(){
		cmd=null;
	}

}
