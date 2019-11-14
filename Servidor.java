import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] users = new String[4];
		users[0] = "joao";
		users[1] = "ana";
		users[2] = "bertho";
		users[3] = "diva";

		Pilha[] mensagens = new Pilha[4];


		try {
			ServerSocket ss = new ServerSocket( 5002 );
			
			while (true)
			{

				System.out.println( "Servidor aguardando um cliente ...");
				Socket t = ss.accept(); // bloqueia até receber pedido de conexão do cliente
				System.out.println( "Servidor: conexao feita");

				DataInputStream entrada = new DataInputStream( t.getInputStream());

				Trabalhador trab = new Trabalhador(t , mensagens , users);
				trab.start();

			}
			
			//ss.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
