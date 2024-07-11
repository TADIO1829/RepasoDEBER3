import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;
import java.sql.*;

public class Estudiantes {
    public JPanel panel1;
    public JTextArea IngresoNombre;
    public JTextField textField1;
    public JTextArea IngresoCedula;
    public JTextField textField2;
    public JButton cedulaButton;
    public JButton nombreButton;
    public JLabel busqueda;

    public Estudiantes() {
        cedulaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    String url = "jdbc:mysql://localhost:3306/estudiantes2024a";
                    String user = "root";
                    String password = "2004";

                    try (Connection connection = DriverManager.getConnection(url, user, password)) {
                        System.out.println("Conectado a la base de datos");
                        String query = "SELECT * FROM estudiantes WHERE cedula='" + textField2.getText() + "'";

                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery(query);

                        if (resultSet.next()) {
                            String nombre = resultSet.getString("nombre");
                            String cedula = resultSet.getString("cedula");
                            double bimestreUno = resultSet.getInt("b1");
                            double bimestreDos = resultSet.getInt("b2");

                            double sumaBimestres = bimestreUno + bimestreDos;
                            double promedio = sumaBimestres / 2;

                            busqueda.setText("<html>Nombre del estudiante: " + nombre + "<br>" +
                                    "Cedula: " + cedula + "<br>" +
                                    "Nota 1: " + bimestreUno + "<br>" +
                                    "Nota 2: " + bimestreDos + "<br>" +
                                    "Promedio: " + promedio + "</html>");
                        } else {
                            busqueda.setText("Estudiante no encontrado");
                        }
                    } catch (SQLException ex) {
                        System.out.println("Error al ejecutar la consulta: " + ex.getMessage());
                    }
                }


        });


        textField2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        nombreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url = "jdbc:mysql://localhost:3306/estudiantes2024a";
                String user = "root";
                String password = "2004";

                try (Connection connection = DriverManager.getConnection(url, user, password)) {
                    System.out.println("Conectado a la base de datos");
                    String query = "SELECT * FROM estudiantes WHERE nombre='" + textField1.getText() + "'";

                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery(query);

                    if (resultSet.next()) {
                        String nombre = resultSet.getString("nombre");
                        String cedula = resultSet.getString("cedula");
                        double  bimestreUno = resultSet.getInt("b1");
                        double bimestreDos = resultSet.getInt("b2");

                        double sumaBimestres = bimestreUno + bimestreDos;
                        double promedio = sumaBimestres / 2;

                        busqueda.setText("<html>Nombre del estudiante: " + nombre + "<br>" +
                                "Cedula: " + cedula + "<br>" +
                                "Nota 1: " + bimestreUno + "<br>" +
                                "Nota 2: " + bimestreDos + "<br>" +
                                "Promedio: " + promedio + "</html>");
                    } else {
                        busqueda.setText("Estudiante no encontrado");
                    }
                } catch (SQLException ex) {
                    System.out.println("Error al ejecutar los datos!." + ex.getMessage());
                }
            }
        });
    }
}
