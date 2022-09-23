import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class PiezasyProveedores {
	static String user="Oriol";
	static String password="Oriol101";
	static String bd="Ejercicio18_6";
	static String url="jdbc:mysql://localhost:3306/"+bd;
	public static void main(String[] args){
		Connection connexion=null;
		
		try {
			String s=url;
			connexion=DriverManager.getConnection(s, user, password);
			if (connexion != null) {
			System.out.println("Conexion a mibase satisfacoria");
			Statement st;
			st=connexion.createStatement();
			st.executeUpdate("CREATE TABLE Piezas ("+"Codigo INT, "+"Nombre NVARCHAR(100), "+"PRIMARY KEY(Codigo))");
			st.executeUpdate("CREATE TABLE Proveedores ("+"id char(4), "+"Nombre NVARCHAR(100), "+"PRIMARY KEY(id))");
			st.executeUpdate("create table suministra(" + "codigopiezas int not null," + "idproveedor char(4) not null,"
					+ "precio int," + "primary key(codigopiezas,idproveedor)," + "key(codigopiezas),"
					+ "foreign key(codigopiezas)" + "references piezas(codigo)," + "key(idproveedor),"
					+ "foreign key(idproveedor)" + "references proveedores(id))");
			st.executeUpdate("INSERT INTO Piezas VALUE " + "(1,'Martillo')," + "(2,'Metal')," + "(3,'Tuerca'),"
				+ "(4,'Madera')," + "(5,'Espadrapo')," + "(6,'Cinta Americana')," + "(7,'Cinta Adhesiva')," + "(8,'SuperGlue'),"
				+ "(9,'Caja')," + "(10,'Sierra')");
			st.executeUpdate("INSERT INTO Proveedores VALUE" + "('ABC','Ferreteries Aubert')," + "('ABD','Ferreterias PACO'),"
					+ "('ABE','Ferreterias Juan')," + "('ABF','Ferreterias Tarragona')," + "('ABG','Barcelona'),"
					+ "('ABH','Ferreterias Reus')," + "('ABI','Hospital Sant Pau')," + "('ABJ','Club Tennis'),"
					+ "('ABK','Hospital Vall Hebron')," + "('ABL','Universitat del CAmp')");
			st.executeUpdate("INSERT INTO suministra VALUE" + "(1,'ABC',50)," + "(2,'ABD',65)," + "(3,'ABE',40),"
				+ "(4,'ABF',15)," + "(5,'ABG',70)," + "(6,'ABH',85)," + "(7,'ABI',35)," + "(8,'ABJ',74),"
				+ "(9,'ABK',10)," + "(10,'ABL',40)");
			System.out.println("Taulas creadas");
			}
			Properties datos = new Properties();
			datos.put("user", user);
			datos.put("password", password);
			

		}catch (SQLException e) {
			System.out.println("Error en la conexión, verifique, su usuario y password o el nombre de la base a la que intenta conectarse");
					e.printStackTrace();

		}
		
	} 

		
	}
	

