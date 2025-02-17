package maven.demo;

public class Main {
	public static void main ( String [ ] args )
	{
		DAO dao = new DAO ( );
		
		if ( dao.conectar ( ) )
		{
			System.out.println ( "Conexão Bem Sucedida!" );
			
			Veiculo veiculo01 = new Veiculo ( 1, "Gol", 12999.99, 2012 );
			
			if ( dao.inserirVeiculo ( veiculo01 ) )
			{
				System.out.println ( "Veiculo Adicionado" );
			}
		}
	}
}
