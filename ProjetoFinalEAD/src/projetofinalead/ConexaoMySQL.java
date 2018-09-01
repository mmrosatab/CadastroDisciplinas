//MUDE AQUI E COLOQUE O PACOTE DE ACORDO COM O SEU PROJETO
//DICA: OLHE O PACKAGE QUE OUTRA CLASSE DO SEU PROJETO EST� E COLOQUE O MESMO!
package projetofinalead;

//Classes necessárias para uso de Banco de dados //
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConexaoMySQL {

    private static ConexaoMySQL instance = null;
    private Connection connection = null;
    

    private ConexaoMySQL() {
        try {
            
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            
            String serverName = "127.0.0.1";    
            
            //nesta linha estar� o nome do seu banco de dados. Olhe no workbench
            //o nome do banco. Caso voce tenha criado o modelo no workbench e n�o
            //tenha modificado o nome do banco, o nome padr�o � "mydb". 
            String dbName = "DisciplinasDB" ;        
            String url = "jdbc:mysql://" + 
                    serverName + "/" + 
                    dbName;
            
            //ajuste o username e password de acordo com o que voce utiliza para 
            //acessar o banco
            String username = "root";             
            String password = "password";      
            
            connection = DriverManager.getConnection(url,
                    username, password);
              
            if (connection != null) {
                System.out.println("STATUS--->Conectado "
                        + "com sucesso!");
            } else {
                System.err.println("STATUS--->Não foi "
                        + "possivel realizar conexão");
            }
            connection.setAutoCommit(true);
        } catch (ClassNotFoundException e) {  
            
            System.out.println("O driver expecificado"
                    + " nao foi encontrado.");
        } catch (SQLException e) {
            
            System.out.println("Nao foi possivel"
                    + " conectar ao Banco de Dados.");
            e.printStackTrace();
        }
        }

    public static ConexaoMySQL getInstance() {
        if (instance == null) {
            instance = new ConexaoMySQL();
        }
        return instance;
    }

    public java.sql.Connection getConnection() {
        return connection;
    }

    
}