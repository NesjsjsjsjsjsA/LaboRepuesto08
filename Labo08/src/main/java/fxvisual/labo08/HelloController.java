package fxvisual.labo08;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable
{

    @FXML
    private Spinner<Integer> spnVegetales;
    @FXML
    private Spinner<Integer> spnCarne;
    @FXML
    private Spinner<Integer> spnPollo;
    @FXML
    private Spinner<Integer> spnPapa;
    @FXML
    private TextField txtfieldNombre;
    @FXML
    private Button btmComprar;
    @FXML
    private Button btmLimpiar;
    @FXML
    private RadioButton rbtmTarjeta;
    @FXML
    private RadioButton rbtmEfectivo;
    @FXML
    private RadioButton rbtmEmpleado;
    @FXML
    private RadioButton rbtmEstudiante;
    @FXML
    private ToggleGroup Pagos;
    @FXML
    private ToggleGroup Cliente;
    @FXML
    private Label lbPreciobasePapas;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        SpinnerValueFactory<Integer> valorCarne = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10);
        SpinnerValueFactory<Integer> valorPollo = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10);
        SpinnerValueFactory<Integer> valorPapa = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10);
        SpinnerValueFactory<Integer> valorVegetales = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10);

        valorCarne.setValue(0);
        valorPollo.setValue(0);
        valorPapa.setValue(0);
        valorVegetales.setValue(0);

        spnCarne.setValueFactory(valorCarne);
        spnPollo.setValueFactory(valorPollo);
        spnPapa.setValueFactory(valorPapa);
        spnVegetales.setValueFactory(valorVegetales);

    }

    public void AvisoMensajeComprar()
    {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);

        alerta.setTitle("Informacion");
        alerta.setHeaderText(null);

            alerta.setContentText(
                    "Bienvenido "+txtfieldNombre.getText() +
                            "\nTipo de cliente: "+Buttom2()+
                            "\nSubtotal: "+
                            "\nDescuento: "+Descuento()+
                            "\nTotal: "+
                            "\nForma de pago: " + Buttom()

            );

            alerta.showAndWait();

    }

    public void LimpiarBarra()
    {
        txtfieldNombre.setText(" ");
        rbtmEfectivo.setSelected(false);
        rbtmEstudiante.setSelected(false);
        rbtmEmpleado.setSelected(false);
        rbtmTarjeta.setSelected(false);
    }

    public String Buttom()
    {
        RadioButton selectOption = (RadioButton) Pagos.getSelectedToggle();
        return selectOption.getText();
    }

    public String Buttom2()
    {
        RadioButton selectOption = (RadioButton) Cliente.getSelectedToggle();
        return selectOption.getText();
    }
    public double Descuento()
    {
        double desc = 0;

        if (rbtmEmpleado.isSelected())
        {
            desc = 0.05;
        }
        if (rbtmEstudiante.isSelected())
        {
            desc = 0.10;
        }

        return desc;
    }



}
