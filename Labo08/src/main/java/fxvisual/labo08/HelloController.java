package fxvisual.labo08;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable
{

    @FXML
    private Spinner<Integer> spnCarne;
    @FXML
    private Spinner<Integer> spnPollo;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        SpinnerValueFactory<Integer> valorCarne = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10);
        SpinnerValueFactory<Integer> valorPollo = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10);

        valorCarne.setValue(0);
        valorPollo.setValue(0);

        spnCarne.setValueFactory(valorCarne);


        ToggleGroup tipoCliente = new ToggleGroup();

        ToggleGroup tipoPago = new ToggleGroup();

    }
    


}
