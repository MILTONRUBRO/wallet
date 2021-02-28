package com.devmos.wallet.util;

public enum TypeEnum {
	EN("ENTRADA"),
	SD("SAIDA");
	
	private final String value;

	private TypeEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public static TypeEnum getEnum(String value) {
		for(TypeEnum typeEnum : values()) {
			if(value.equals(typeEnum.getValue())) {
				return typeEnum;
			}
		}
		return null;
	}

}
