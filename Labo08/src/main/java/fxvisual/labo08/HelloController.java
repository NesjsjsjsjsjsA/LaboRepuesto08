package fxvisual.labo08;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable
{
    private double precioCarne;
    private double precioPapas;
    private double precioVegetales;
    private double precioPollo;
    private double precioFinal;

    @FXML
    private MediaPlayer mediaError;
    @FXML
    private MediaPlayer mediaWarning;
    @FXML
    private MediaPlayer mediaInformation;
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

        URL mediaUrl = getClass().getResource("/fxvisual/labo08/Sounds/error.mp3");
        Media mediaError = new Media(mediaUrl.toExternalForm());
        this.mediaError = new MediaPlayer(mediaError);

        URL media2Url = getClass().getResource("/fxvisual/labo08/Sounds/warning.mp3");
        Media mediaWarning = new Media(media2Url.toExternalForm());
        this.mediaWarning = new MediaPlayer(mediaWarning);

        URL media3url = getClass().getResource("/fxvisual/labo08/Sounds/information.mp3");
        Media mediaInformation = new Media(media3url.toExternalForm());
        this.mediaInformation = new MediaPlayer(mediaInformation);


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
                    updateFinalPrice();
            }
        });

        spnPapa.valueProperty().addListener(new ChangeListener<Integer>(){
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                precioPapas = spnPapa.getValue()*1.25f;
                lbPreciofinalpapas.setText("$"+ precioPapas);
                updateFinalPrice();
            }
        });

        spnVegetales.valueProperty().addListener(new ChangeListener<Integer>(){
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                precioVegetales = spnVegetales.getValue()*0.75f;
                lbPreciofinalvegtales.setText("$"+ precioVegetales);
                updateFinalPrice();
            }
        });

        spnPollo.valueProperty().addListener(new ChangeListener<Integer>(){
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                precioPollo = spnPollo.getValue()*1.75f;
                lbPreciofinalpollo.setText("$"+ precioPollo);
                updateFinalPrice();
            }
        });
    }

    //Metodos y funciones para actualizar datos
    
    public void updateFinalPrice()
    {
        precioFinal = precioCarne + precioPapas + precioPollo + precioVegetales;
        lbTotalpagar.setText("$"+precioFinal);
    }

    public double finalPriceDisct()
    {
        double Prescdesc = 0;
        double scale = Math.pow(10,2);

        if (rbtmEmpleado.isSelected())
        {
            Prescdesc = precioFinal*0.10f;
        }
        return Math.ceil(Prescdesc*scale)/scale;
    }

    public void Cleaning()
    {

        InformationStop();
        InformationPlay();

        txtfieldNombre.setText(" ");

        rbtmEstudiante.setSelected(false);
        rbtmEmpleado.setSelected(false);

        rbtmEfectivo.setSelected(false);
        rbtmTarjeta.setSelected(false);

        spnCarne.getValueFactory().setValue(0);
        spnPapa.getValueFactory().setValue(0);
        spnPollo.getValueFactory().setValue(0);
        spnVegetales.getValueFactory().setValue(0);

    }

    //Relacionado con los sonidos

    @FXML
    private void ErrorPlay()
    {
        mediaError.play();
    }
    @FXML
    private void WarningPlay()
    {
        mediaWarning.play();
    }
    @FXML
    private void InformationPlay()
    {
        mediaInformation.play();
    }
    @FXML
    private void ErrorStop()
    {
        mediaError.stop();
    }
    @FXML
    private void WarningStop()
    {
        mediaWarning.stop();
    }
    @FXML
    private void InformationStop()
    {
        mediaInformation.stop();
    }

    //Relacionado con los botones

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
    public void ActionSound()
    {
        InformationStop();
        InformationPlay();
    }

    //Todo lo relacionado con las ventanas

    public void VentanaEmergente()
    {
        if (txtfieldNombre.getText().length() < 7)
        {
            WarningStop();
            WarningPlay();
            AvisoWarging();
        }
        else if (!(rbtmEmpleado.isSelected() || rbtmEstudiante.isSelected()) || !(rbtmTarjeta.isSelected() || rbtmEfectivo.isSelected()) || (precioFinal == 0))
        {
            ErrorStop();
            ErrorPlay();
            AvisoError();
        }
        else
        {
            double precioFDesc = finalPriceDisct();
            InformationStop();
            InformationPlay();
            AvisoInformation(precioFDesc);
        }
    }

    public void AvisoWarging()
    {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Ten cuidado...");
        alert.setHeaderText(null);
        alert.setContentText("Debe digitar bien su nombre...");
        alert.showAndWait();
    }

    public void AvisoError()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Oh oh ALGO SALIO MAL");
        alert.setHeaderText(null);
        alert.setContentText("Debes de seleccionar algo :P...");
        alert.showAndWait();
    }

    public void AvisoInformation(double preci)
    {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);

        alerta.setTitle("Gracias por tu compra");
        alerta.setHeaderText(null);

            alerta.setContentText(
                    "Bienvenido "+txtfieldNombre.getText()
                    +"\nSubtotal : $ "+precioFinal
                    +"\nDescuento: $"+ preci
                    +"\nTotal de: $" +(precioFinal-preci)
                    +"\nTipo de cliente: "+ Buttom2()
                    +"\nForma de pago: " + Buttom()
                    +"\n Gracias por tu compra!"

            );
            alerta.showAndWait();

    }

}
