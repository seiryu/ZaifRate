package application;

public enum Currency {
	JPY("jpy",1),
	BTC("btc",2),
	XEM("xem",3),
	MONA("mona",4),
	BCH("bch",5),
	ZAIF("zaif",6),
	XCP("xcp",7),
	BITCRYSTALS("bitcrystals",8),
	SJCX("sjcx",9),
	FSCC("fscc",10),
	PEPECASH("pepecash",11),
	CICC("cicc",12),
	NCXC("ncxc",13);

	final public String symbol;
	final public int id;

	private Currency(String i_symbol,int i_id){
		this.symbol = i_symbol;
		this.id = i_id;
	}

	public int getId() {
		return id;
	}

	public String getSymbol() {
		return symbol;
	}
	
	public boolean isToken() {
		return getId() > 5;
	}
}
