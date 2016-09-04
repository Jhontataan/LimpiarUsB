package limpiarusb;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;
public class Formulario extends JFrame {

    public JPanel pnlContenedor;
    public JLabel lblSeleccion;
    public JComboBox cmbUnidades;
    public JButton btnLimpiar;
    public File Unidades[] = File.listRoots();
    public String Unidad;

    public Formulario() {
        this.setTitle("LimpiarUsB");
        this.setResizable(false);
        this.setSize(390, 150);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        CargarComponentes();
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TomarValor();
                String salida = null;
                String comando = "cmd /c " + Unidad + " && Attrib -r -a -s -h /s /d *.*";

                try{
                    
                    Process proceso = Runtime.getRuntime().exec(comando);
                    InputStreamReader entrada = new InputStreamReader(proceso.getInputStream());
                    BufferedReader stdInput = new BufferedReader(entrada);

                } catch (IOException ae) {
                    System.out.println("Excepción: ");
                }
            }
        });

    }

    private void TomarValor() {
        Unidad = (cmbUnidades.getSelectedItem().toString()).substring(0, (cmbUnidades.getSelectedItem().toString()).length() - 1);
    }

    private void CargarComponentes() {

        pnlContenedor = new JPanel();
        lblSeleccion = new JLabel("Selecciona la unidad que deseas limpiar:");
        cmbUnidades = new JComboBox(Unidades);
        btnLimpiar = new JButton("Limpiar");

        setContentPane(pnlContenedor);
        pnlContenedor.setLayout(null);

        pnlContenedor.add(lblSeleccion);
        pnlContenedor.add(cmbUnidades);
        pnlContenedor.add(btnLimpiar);

        lblSeleccion.reshape(20, 20, 250, 20);
        cmbUnidades.reshape(270, 20, 100, 20);
        btnLimpiar.reshape(20, 60, 350, 40);

    }

}
