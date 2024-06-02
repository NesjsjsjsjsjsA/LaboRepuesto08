package fxvisual.labo08;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable
{
    private float precioCarne;
    private float precioPapas;
    private float precioVegetales;
    private float precioPollo;
    private float precioFinal;
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
    private Label lbPreciofinalpollo;
    @FXML
    private Label lbTotalpagar;
    @FXML
    private Label lbPreciofinalcarne;
    @FXML
    private Label lbPreciofinalpapas;
    @FXML
    private Label lbPreciofinalvegtales;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        SpinnerValueFactory<Integer> valorCarne = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0);
        SpinnerValueFactory<Integer> valorPollo = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0);
        SpinnerValueFactory<Integer> valorPapa = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0);
        SpinnerValueFactory<Integer> valorVegetales = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,10,0);

        valorCarne.setValue(0);
        valorPollo.setValue(0);
        valorPapa.setValue(0);
        valorVegetales.setValue(0);

        spnCarne.setValueFactory(valorCarne);
        spnPollo.setValueFactory(valorPollo);
        spnPapa.setValueFactory(valorPapa);
        spnVegetales.setValueFactory(valorVegetales);


        spnCarne.valueProperty().addListener(new ChangeListener<Integer>(){
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                precioCarne = spnCarne.getValue()*2.25f;
                lbPreciofinalcarne.setText("$"+ precioCarne);
                actualizarTitak();
            }
        });

        spnPapa.valueProperty().addListener(new ChangeListener<Integer>(){
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                precioPapas = spnPapa.getValue()*1.25f;
                lbPreciofinalpapas.setText("$"+ precioPapas);
                actualizarTitak();
            }
        });

        spnVegetales.valueProperty().addListener(new ChangeListener<Integer>(){
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                precioVegetales = spnVegetales.getValue()*0.75f;
                lbPreciofinalvegtales.setText("$"+ precioVegetales);
                actualizarTitak();
            }
        });

        spnPollo.valueProperty().addListener(new ChangeListener<Integer>(){
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                precioPollo = spnPollo.getValue()*1.75f;
                lbPreciofinalpollo.setText("$"+ precioPollo);
                actualizarTitak();
            }
        });



    }

    public void actualizarTitak()
    {
        precioFinal = precioCarne + precioPapas;
        lbTotalpagar.setText("$"+precioFinal);
    }

    public void VentanaEmergente()
    {
        if (txtfieldNombre.getText().length() < 7)
        {
            AvisoError();
        }
        else if (TotalPago()== 0)
        {
            AvisoWarging();
        }
        else
        {
            AvisoInformation();
        }
    }

    public double TotalPago()
    {
        return spnVegetales.getValue()+spnPollo.getValue()+spnCarne.getValue()+spnPapa.getValue();
    }

    public void AvisoWarging()
    {

        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Advertencia");
        alert.setHeaderText(null);
        alert.setContentText("Debes de seleccionar algo :p");
        alert.showAndWait();
    }

    public void AvisoError()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("El nombre no cumple con lo establecido");
        alert.showAndWait();
    }


    public void AvisoInformation()
    {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);

        alerta.setTitle("Informacion");
        alerta.setHeaderText(null);

            alerta.setContentText("Bienvenido "+txtfieldNombre.getText());

            alerta.showAndWait();

    }

    public void LimpiarBarra()
    {
        txtfieldNombre.setText(" ");
        rbtmEfectivo.setSelected(false);
        rbtmEstudiante.setSelected(false);
        rbtmEmpleado.setSelected(false);
        rbtmTarjeta.setSelected(false);

        spnCarne.getValueFactory().setValue(0);
        spnPapa.getValueFactory().setValue(0);
        spnPollo.getValueFactory().setValue(0);
        spnVegetales.getValueFactory().setValue(0);

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

}
