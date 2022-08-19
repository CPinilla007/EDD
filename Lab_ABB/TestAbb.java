public class TestAbb {


	public static void main(String[] args) {
		Abb a = new Abb();
		a.Insertar(10);
		a.Insertar(8);
		a.Insertar(12);
		a.Insertar(4);
		a.Insertar(-8);

		a.Imprimir();
		
		System.out.println(" EL complemento es : " + a.Complemento());	// True
		a.Eliminar(-8);
		System.out.println(" EL complemento es : " + a.Complemento());	// False
		
	}

}
