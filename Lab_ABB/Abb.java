import java.util.LinkedList;

public class Abb {
	class NodoAbb {
		int elemento;
		NodoAbb lchild;
		NodoAbb rchild;

		NodoAbb(int elemento, NodoAbb lchild, NodoAbb rchild) {
			this.elemento = elemento;
			this.lchild = lchild;
			this.rchild = rchild;
		}

		void Print() {
			System.out.println(elemento);
		}
	}

	private NodoAbb laRaiz;

	public Abb() {
		laRaiz = null;
	}

	public boolean Complemento() {
		return comple(laRaiz);
	}

	private boolean comple(NodoAbb n) {
            
            LinkedList<Integer> elementos =inOrden(n); 
            for (Integer i : elementos) {
                if(i<0){
                    if(elementos.contains(-i)){
                        return true;
                    }
                }
            }
            
		return false;
	}
        
        public LinkedList inOrden(NodoAbb n){       
            LinkedList<Integer> a = new LinkedList<>();
            if(n==null){return a;}
            a.addAll(inOrden(n.lchild));
            a.add(n.elemento);
            a.addAll(inOrden(n.rchild));
            
            return a;
        }
	public void Insertar(int elemento) {
		laRaiz = InsertaenAbb(laRaiz, elemento);
	}
	
	private NodoAbb InsertaenAbb(NodoAbb nodo, int elemento) {
		if (nodo == null)
			return new NodoAbb(elemento, null, null);
		else if (elemento < nodo.elemento)
			nodo.lchild = InsertaenAbb(nodo.lchild, elemento);
		else
			nodo.rchild = InsertaenAbb(nodo.rchild, elemento);
		return nodo;
	}
	
	public void Eliminar(int elemento) {
		laRaiz = EliminaenAbb(laRaiz, elemento);
	}
	
	private NodoAbb EliminaenAbb(NodoAbb nodo, int elemento) {
		if (nodo.elemento == elemento) {
			if (nodo.lchild == null && nodo.rchild == null)
				return null;
			else if (nodo.lchild == null)
				return nodo.rchild;
			else if (nodo.rchild == null)
				return nodo.lchild;
			else {
				nodo.elemento = MayorElemento(nodo.lchild);
				nodo.lchild = EliminaenAbb(nodo.lchild, nodo.elemento);
			}
		} else if (nodo.elemento > elemento)
			nodo.lchild = EliminaenAbb(nodo.lchild, elemento);
		else
			nodo.rchild = EliminaenAbb(nodo.rchild, elemento);
		return nodo;
	}

	private int MayorElemento(NodoAbb nodo) {
		if (nodo.rchild == null)
			return nodo.elemento;
		else
			return MayorElemento(nodo.rchild);
	}

	public void Imprimir() {
		ImprimeAbb(laRaiz, " ");
	}

	private void ImprimeAbb(NodoAbb n, String tab) {
		if (n != null) {
			System.out.println(tab + n.elemento);
			ImprimeAbb(n.lchild, tab + "  ");
			ImprimeAbb(n.rchild, tab + "  ");
		}
	}

}
