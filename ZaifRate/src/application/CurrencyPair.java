package application;

import java.util.ArrayList;

public enum CurrencyPair {
	BTC_JPY(Currency.BTC, Currency.JPY),
	XEM_JPY(Currency.XEM, Currency.JPY),
	MONA_JPY(Currency.MONA, Currency.JPY),
	BCH_JPY(Currency.BCH, Currency.JPY),
	XEM_BTC(Currency.XEM, Currency.BTC),
	MONA_BTC(Currency.MONA, Currency.BTC),
	BCH_BTC(Currency.BCH, Currency.BTC),
	ZAIF_JPY(Currency.ZAIF, Currency.JPY),
	XCP_JPY(Currency.XCP, Currency.JPY),
	BITCRYSTALS_JPY(Currency.BITCRYSTALS, Currency.JPY),
	SJCX_JPY(Currency.SJCX, Currency.JPY),
	FSCC_JPY(Currency.FSCC, Currency.JPY),
	PEPECASH_JPY(Currency.PEPECASH, Currency.JPY),
	CICC_JPY(Currency.CICC, Currency.JPY),
	NCXC_JPY(Currency.NCXC, Currency.JPY),
	ZAIF_BTC(Currency.ZAIF, Currency.BTC),
	XCP_BTC(Currency.XCP, Currency.BTC),
	BITCRYSTALS_BTC(Currency.BITCRYSTALS, Currency.BTC),
	SJCX_BTC(Currency.SJCX, Currency.BTC),
	FSCC_BTC(Currency.FSCC, Currency.BTC),
	PEPECASH_BTC(Currency.PEPECASH, Currency.BTC),
	CICC_BTC(Currency.CICC, Currency.BTC),
	NCXC_BTC(Currency.NCXC, Currency.BTC)
	;

	final private String symbol;
	final private String symbol_exp;

	private CurrencyPair(Currency i1, Currency i2) {
		this.symbol = i1.getSymbol() + "_" + i2.getSymbol();
		this.symbol_exp = (i1.getSymbol() + "/" + i2.getSymbol()).toUpperCase();
	}

	public String getSymbol() {
		return symbol;
	}

	public String getSymbol_exp() {
		return symbol_exp;
	}


	public static ArrayList<String> getAllSymbol_exp(){
		ArrayList<String> allSymbols = new ArrayList<>();
		for(CurrencyPair val :CurrencyPair.values()) {
			allSymbols.add(val.getSymbol_exp());
		}
		return allSymbols;
	}

	public static CurrencyPair toEnum(String symbol_exp) {
		System.out.println(symbol_exp.replace("/", "_"));
		return CurrencyPair.valueOf(symbol_exp.replace("/", "_"));
	}

}
