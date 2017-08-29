package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;


public class Controller implements Initializable {

	@FXML
	private Label label;

	@FXML
	private JFXComboBox<String> comboCurrency;

	@FXML
	private JFXComboBox<String> comboFreq;

	private Model model;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		model = new Model();
		comboCurrency.getItems().addAll(CurrencyPair.getAllSymbol_exp());
		comboFreq.getItems().addAll("1秒", "2秒", "3秒", "5秒", "10秒");
	}

	@FXML
	public void comboFreqSelected(ActionEvent evt) {
		String str = comboFreq.getValue();
		int freq = Integer.parseInt(str.substring(0, str.length()-1))*1000;
		model.setFreq(freq);
	}

	@FXML
	public void comboCurrencySelected(ActionEvent evt) {
		model.setCurrency_pair(CurrencyPair.toEnum(comboCurrency.getValue()));
		model.setPrice(label);
	}
}
