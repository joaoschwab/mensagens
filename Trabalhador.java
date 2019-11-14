import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;


public class Trabalhador extends Thread {
	
	private Socket t;
	private String[] users;
	private Pilha[] mensagens;
	
	public Trabalhador( Socket t, Pilha[] p, String[] users)
	{
		this.t = t;
		this.mensagens  = p;
		this.users = users;
	}
	
	public void run()
	{
		try
		{

			DataInputStream entrada = new DataInputStream( t.getInputStream());
			DataOutputStream saida = new DataOutputStream( t.getOutputStream());
			
			String dados = entrada.readUTF();
			String array[] = new String[3];
			array = dados.split("/");
			System.out.println(dados);
			mensagens[Integer.parseInt(array[1])].empilha("Mensagem de :" + users[Integer.parseInt(array[0])] + " / " + "Mensagem: " + array[2]);

			Thread.sleep( 5000 ); // dorme 5 segundos
			
			//double produto = k * f;
			//float produto = k * f;
			//System.out.println( "produto = " + produto );
			System.out.println("mensagem enviada!");
			//saida.writeFloat( produto );
			
			t.close();
			System.out.println( "Servidor: conexao encerrada");
		}
		catch( Exception e )
		{
			System.out.println( e );
		}
		
	}

}
