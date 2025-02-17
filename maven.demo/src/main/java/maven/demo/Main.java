package maven.demo;

import java.util.Scanner;

public class Main 
{
    public static void main ( String [ ] Args ) 
    {
        DAO dao = new DAO ( );
        Scanner scanner = new Scanner ( System.in );

        if ( ! dao.conectar ( ) ) 
        {
            System.out.println ( "Falha ao conectar ao banco de dados." );
            return ;
        }
        System.out.println ( "Conexão bem-sucedida!" );

        while ( true ) 
        {
            System.out.println ( "\nEscolha uma opção:" );
            System.out.println ( "1- Inserir Veículo" );
            System.out.println ( "2- Listar Veículos" );
            System.out.println ( "3- Atualizar Veículo" );
            System.out.println ( "4- Deletar Veículo" );
            System.out.println ( "5- Sair" );
            int opcao = scanner.nextInt ( );
            scanner.nextLine ( );

            switch ( opcao ) 
            {
                case 1:
                    System.out.println ( "Inserir Veículo:" );
                    System.out.print ( "ID: " );
                    int idInserir = scanner.nextInt ( );
                    scanner.nextLine ( );
                    System.out.print ( "Nome: " );
                    String nomeInserir = scanner.nextLine ( );
                    System.out.print ( "Preço: " );
                    double precoInserir = scanner.nextDouble ( );
                    System.out.print ( "Ano: " );
                    int anoInserir = scanner.nextInt ( );
                    Veiculo veiculoInserir = new Veiculo ( idInserir, nomeInserir, precoInserir, anoInserir );
                    if ( dao.inserirVeiculo ( veiculoInserir ) ) 
                    {
                        System.out.println ( "Veículo inserido com sucesso!" ) ;
                    } else 
                    	{
                        	System.out.println ( "Falha ao inserir o veículo." );
                    	}
                    break;

                case 2:
                    System.out.println ( "Listando veículos:" );
                    Veiculo [ ] veiculos = dao.getVeiculos ( );
                    if ( veiculos != null && veiculos.length > 0 ) 
                    {
                        for ( Veiculo veiculo : veiculos ) 
                        {
                            System.out.println ( "ID: " + veiculo.get_Id ( ) + ", Nome: " + veiculo.get_Name ( ) +
                                               ", Preço: " + veiculo.get_Preco ( ) + ", Ano: " + veiculo.get_Ano ( ) );
                        }
                    } else 
                    	{
                        	System.out.println ( "Nenhum veículo encontrado." );
                    	}
                    break;

                case 3:
                    System.out.println ( "Atualizar Veículo:" );
                    System.out.print ( "ID do veículo a ser atualizado: " );
                    int idAtualizar = scanner.nextInt ( );
                    scanner.nextLine ( );
                    System.out.print ( "Novo Nome: " );
                    String nomeAtualizar = scanner.nextLine ( );
                    System.out.print ( "Novo Preço: " );
                    double precoAtualizar = scanner.nextDouble ( );
                    System.out.print ( "Novo Ano: " );
                    int anoAtualizar = scanner.nextInt ( );
                    Veiculo veiculoAtualizar = new Veiculo ( idAtualizar, nomeAtualizar, precoAtualizar, anoAtualizar );
                    if ( dao.atualizarVeiculo ( veiculoAtualizar ) ) 
                    {
                        System.out.println ( "Veículo atualizado com sucesso!" );
                    } else 
                    	{
                        	System.out.println ( "Falha ao atualizar o veículo." );
                    	}
                    break;

                case 4:
                    System.out.println ( "Deletar Veículo:" );
                    System.out.print ( "ID do veículo a ser deletado: " );
                    int idDeletar = scanner.nextInt ( );
                    if ( dao.deletarVeiculo ( idDeletar ) ) 
                    {
                        System.out.println ( "Veículo deletado com sucesso!" );
                    } else 
                    	{
                        	System.out.println ( "Falha ao deletar o veículo." );
                    	}
                    break;

                case 5:
                    System.out.println ( "Saindo..." );
                    scanner.close ( );
                    return;

                default:
                    System.out.println ( "Opção inválida! Tente novamente." );
                    break;
            }
        }
    }
}
