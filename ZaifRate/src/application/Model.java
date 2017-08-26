package application;

import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class Model {
	private ObjectMapper mapper;
	private String currency_pair;
	private int freq;
	Thread thread;

	public Model() {
		// TODO 自動生成されたコンストラクター・スタブ
		mapper = new ObjectMapper();
		freq = 2000;
	}

	public void setCurrency_pair(String currency_pair) {
		if(currency_pair.equals("BCY/JPY")) {
			this.currency_pair = "bitcrystals_jpy";
		} else if (currency_pair.equals("BCY/BTC")) {
			this.currency_pair = "bitcrystals_btc";
		}else {
			this.currency_pair = currency_pair.toLowerCase().replace("/", "_");
		}
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}

	public void setPrice(Label label){
		if(currency_pair == null) {
			label.setText("通貨ペアを選択してください");
			return;
		}

		Task<Boolean> task = new Task<Boolean>(){
		    @Override
		    protected Boolean call() throws Exception {
		    	float last_price = 0;
		    	try {
					while(true) {
						Price response;
						String color;
						response = mapper.readValue( new URL("https://api.zaif.jp/api/1/last_price/"+currency_pair), Price.class);
						if(response.getLast_price() > last_price) {
							color = "#1E88E5";
						}else if (response.getLast_price() < last_price) {
							color = "#E53935";
						}else {
							color = "#212121";
						}
						last_price = response.getLast_price();
						Platform.runLater(() -> {label.setText(Float.toString(response.getLast_price()));
												 label.setTextFill(Color.web(color)); });
						Thread.sleep(freq);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
		    	return true;
		    }
		};

		Thread thread = new Thread( task );
		thread.setDaemon( true );
		thread.start();
	}
}

class Price{
	private float last_price;

	public void setLast_price(float last_price) {
		this.last_price = last_price;
	}

	public float getLast_price() {
		return last_price;
	}
}