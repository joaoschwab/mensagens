import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Cliente {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ID = 0; // id = posicao na list
		Scanner input = new Scanner(System.in);

		// abre conexão com o servidor
		try {
			Socket s = new Socket("127.0.0.1", 5002);
			System.out.println( "Cliente: conexao feita" );
			
			DataOutputStream saida = new DataOutputStream( s.getOutputStream());

			System.out.println("Para quem voce quer mandar essa mensagem :");
			int id_destinatario = input.nextInt();
			System.out.println("Informe a mensagem: ");
			input = new Scanner(System.in);
			String mensagem = input.nextLine();
			String consolidado = ID + "/" + id_destinatario + "/" + mensagem;
			saida.writeUTF(consolidado);

			
			//DataInputStream entrada = new DataInputStream( s.getInputStream());
			
			//String resultado = entrada.readUTF();
			//float resultado = entrada.readFloat(); // pode?
			//System.out.println( "resultado = " + resultado );
			
			//float resto = entrada.readFloat();
			//System.out.println( "resto = " + resto );
			
			s.close(); // encerra a conexao com o servidor
			System.out.println( "Cliente: conexao encerrada");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
