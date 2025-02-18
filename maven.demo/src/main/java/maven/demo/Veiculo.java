package maven.demo;

public class Veiculo {
	private String nome;
	private int id;
	private Double preco;
	private int ano;
	
	public Veiculo ( )
	{
		this.id = 0;
		this.nome = "";
		this.preco = 0.0;
		this.ano = 0;
	}
	
	public Veiculo ( int id_, String nome_, Double preco_, int ano_ )
	{
		this.id = id_;
		this.nome = nome_;
		this.preco = preco_;
		this.ano = ano_;
	}
	
	public int get_Id ( )
	{
		return id;
	}
	
	public void set_Id ( int id_ )
	{
		this.id = id_;
	}
	
	public String get_Name ( )
	{
		return nome;
	}
	
	public void set_Name ( String nome_ )
	{
		this.nome = nome_;
	}
	
	public Double get_Preco ( )
	{
		return preco;
	}
	
	public void set_Preco ( double preco_ )
	{
		this.preco = preco_;
	}
	
	public int get_Ano ( )
	{
		return ano;
	}
	
	public void set_Ano ( int ano_ )
	{
		this.ano = ano_;
	}
	
}
