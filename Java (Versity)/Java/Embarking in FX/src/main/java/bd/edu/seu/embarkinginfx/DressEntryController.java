package bd.edu.seu.embarkinginfx;

import javafx.stage.FileChooser;
import javafx.scene.image.Image;

import java.io.File;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

public class DressEntryController implements Initializable {

    @FXML
    private CheckBox agreeCheckBox;

    private Set<String> usedDiscounts = new HashSet<>();


    @FXML
    private PasswordField discountField;

    @FXML
    private Label discountErrorField;

    @FXML
    private ColorPicker dressColorPicker;

    @FXML
    private TextField dressNameField;

    @FXML
    private TextArea dressTextArea;

    @FXML
    private Label detailsErrorLabel;

    @FXML
    private ChoiceBox<String> dressTypeChoiceBox;

    @FXML
    private ToggleGroup genderRadio;

    @FXML
    private Label customerErrorLabel;

    @FXML
    private ImageView imageView;
    @FXML
    private Label pictureLabel;
    private boolean isImageUploaded = false;



    @FXML
    private Slider priceSlider;
    int myPriceSliderValue;

    @FXML
    private Label myPrice;

    @FXML
    private Label priceErrorLabel;

    @FXML
    private DatePicker purchaseDatePicker;

    @FXML
    private Label dateErrorLabel;

    @FXML
    private Spinner<Integer> quantitySpinner;

    @FXML
    private ComboBox<String> sizeComboBox;

    @FXML
    private Label nameErrorLabel;

    @FXML
    private Label typeErrorLabel;

    @FXML
    private Label sizeErrorLabel;

    @FXML
    private Label colorErrorLabel;

    private String toHexCode(javafx.scene.paint.Color color) {
        return String.format("#%02X%02X%02X",
                (int)(color.getRed() * 255),
                (int)(color.getGreen() * 255),
                (int)(color.getBlue() * 255));
    }

    @FXML
    public void initialize() {
        // Hide error when user starts typing
        dressNameField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.trim().isEmpty()) {
                nameErrorLabel.setVisible(false);
            }
            });

        // Dress type validation
        dressTypeChoiceBox.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                typeErrorLabel.setVisible(false);
            }
        });

        // Size validation
        sizeComboBox.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                sizeErrorLabel.setVisible(false);
            }
        });

        dressColorPicker.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                colorErrorLabel.setVisible(false);
            }
        });

        priceSlider.valueProperty().addListener((obs, oldVal, newVal) -> {
            double price = newVal.doubleValue();
            if (price >= 500) {
                priceErrorLabel.setVisible(false);
            }
        });

        dressTextArea.textProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.length() > 50) {
                dressTextArea.setText(oldValue); // prevent further typing
                detailsErrorLabel.setText("Maximum 50 characters allowed.");
                detailsErrorLabel.setStyle("-fx-text-fill: red;");
                detailsErrorLabel.setVisible(true);
            } else {
                detailsErrorLabel.setVisible(false);
            }
        });

        purchaseDatePicker.valueProperty().addListener((obs, oldDate, newDate) -> {
            if (newDate != null && newDate.isBefore(java.time.LocalDate.now())) {
                dateErrorLabel.setText("Date can't be future date.");
                dateErrorLabel.setStyle("-fx-text-fill: red;");
                dateErrorLabel.setVisible(true);
            } else {
                dateErrorLabel.setVisible(false);
            }
        });

        // Initialize Spinner (quantitySpinner)
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 1);
        quantitySpinner.setValueFactory(valueFactory);

        genderRadio.selectedToggleProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                customerErrorLabel.setVisible(false);
            }
        });

    }


    @FXML
    void saveEvent(ActionEvent event) {
        boolean isValid = true;

        // Validate dress name
        String dressName = dressNameField.getText().trim();
        if (dressName.isEmpty()) {
            nameErrorLabel.setText("Dress name is required.");
            nameErrorLabel.setVisible(true);
            isValid = false;
        } else {
            nameErrorLabel.setVisible(false);
        }
        // Dress Type

        String dressType = dressTypeChoiceBox.getValue();

        if (dressTypeChoiceBox.getValue() == null) {
            typeErrorLabel.setText("Dress type is required.");
            typeErrorLabel.setStyle("-fx-text-fill: red;");
            typeErrorLabel.setVisible(true);
            isValid = false;
        } else {
            typeErrorLabel.setVisible(false);
        }

        // Size

        String size = sizeComboBox.getValue();

        if (sizeComboBox.getValue() == null) {
            sizeErrorLabel.setText("Available size is required.");
            sizeErrorLabel.setStyle("-fx-text-fill: red;");
            sizeErrorLabel.setVisible(true);
            isValid = false;
        } else{
            sizeErrorLabel.setVisible(false);
        }

        // Color
        if (dressColorPicker.getValue() == null) {
            colorErrorLabel.setText("Dress color is required.");
            colorErrorLabel.setStyle("-fx-text-fill: red;");
            colorErrorLabel.setVisible(true);
            isValid = false;
        } else {
            colorErrorLabel.setVisible(false);
            String selectedColorHex = toHexCode(dressColorPicker.getValue());
        }

        // price slider
        double price = priceSlider.getValue();

        if (price < 500) {
            priceErrorLabel.setText("Price cannot be less than 500.");
            priceErrorLabel.setStyle("-fx-text-fill: red;");
            priceErrorLabel.setVisible(true);
            isValid = false;
        } else {
            priceErrorLabel.setVisible(false);
        }

        int myPrice = myPriceSliderValue;


        //dress details
        String details = dressTextArea.getText().trim();
        if (details.length() > 50) {
            detailsErrorLabel.setText("Description cannot exceed 50 characters.");
            detailsErrorLabel.setVisible(true);
            isValid = false;
        } else {
            detailsErrorLabel.setVisible(false);
        }

        // date
        LocalDate selectedDate = purchaseDatePicker.getValue();

        if (selectedDate == null) {
            dateErrorLabel.setText("Purchase date is required.");
            dateErrorLabel.setStyle("-fx-text-fill: red;");
            dateErrorLabel.setVisible(true);
            isValid = false;
        } else if (selectedDate.isBefore(LocalDate.now())) {
            dateErrorLabel.setText("Past date is not allowed.");
            dateErrorLabel.setStyle("-fx-text-fill: red;");
            dateErrorLabel.setVisible(true);
            isValid = false;
        } else {
            dateErrorLabel.setVisible(false);
        }

        // spinner
        int quantity = quantitySpinner.getValue();

        // discount
        String discountInput = discountField.getText();

        if (!discountInput.isEmpty()) {
            if (usedDiscounts.contains(discountInput)) {
                discountErrorField.setText("This discount has already been used.");
                discountErrorField.setStyle("-fx-text-fill: red;");
                discountErrorField.setVisible(true);
                isValid = false;
            } else {
                discountErrorField.setVisible(false);
                usedDiscounts.add(discountInput);
            }
        } else {
            discountErrorField.setVisible(false); // no error if left empty
        }

        // radiobutton
        Toggle selectedGender = genderRadio.getSelectedToggle();
        String gender = null;

        if (selectedGender == null) {
            customerErrorLabel.setText("Targeted customer is required.");
            customerErrorLabel.setVisible(true);
            isValid = false;
        } else {
            customerErrorLabel.setVisible(false);
            RadioButton selectedRadioButton = (RadioButton) genderRadio.getSelectedToggle();
            gender = selectedRadioButton.getText();
        }
        RadioButton selectedToggle = (RadioButton) genderRadio.getSelectedToggle();
        String genderFunction = selectedToggle.getText();


        // checkbox
        boolean agree = agreeCheckBox.isSelected();

        // picture
        if (!isImageUploaded) {
            pictureLabel.setText("Dress image is required.");
            pictureLabel.setStyle("-fx-text-fill: red;");
            pictureLabel.setVisible(true);
            isValid = false;
        } else {
            pictureLabel.setVisible(false);
        }



        System.out.println(dressName + "\n" + dressType + "\n" + size + "\n" + toHexCode(dressColorPicker.getValue()) + "\n" + myPrice + "\n"
                + details + "\n" + selectedDate + "\n" + quantity + "\n" + genderFunction);
    }

    @FXML
    void uploadEvent(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select Dress Image");

        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
        );

        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            imageView.setImage(image);
            imageView.setPreserveRatio(true);
            isImageUploaded = true; // ✅ set flag
            pictureLabel.setVisible(false); // ✅ hide error if image is uploaded
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("I am called");

        ObservableList<String> dressTypesObserableList = FXCollections.observableArrayList();
        dressTypesObserableList.addAll("Hoodie", "Sweater", "T-Shirt", "Jacket", "Pants");
        dressTypeChoiceBox.setItems(dressTypesObserableList);

        ObservableList<String> sizesObserableList = FXCollections.observableArrayList();
        sizesObserableList.addAll( "M", "L", "XL", "XXL");
        sizeComboBox.setItems(sizesObserableList);

        priceSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                myPriceSliderValue = (int) priceSlider.getValue();
                myPrice.setText(Integer.toString(myPriceSliderValue));
            }
        });

        priceSlider.valueProperty().addListener((observableValue, number, t1) -> {
            myPriceSliderValue = (int) priceSlider.getValue();
            myPrice.setText(Integer.toString(myPriceSliderValue));
        });


        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 1);
        quantitySpinner.setValueFactory(valueFactory);

        discountField.textProperty().addListener((observable, oldValue, newValue) -> {
            discountErrorField.setVisible(false);
        });

    }

    @FXML
    void showListEvent(ActionEvent event) {
        System.out.println("Redirect to show list scene.");
        HelloApplication.changeScene("list");

    }

}
