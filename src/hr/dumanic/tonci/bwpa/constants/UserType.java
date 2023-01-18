package hr.dumanic.tonci.bwpa.constants;

public enum UserType {

	
	USER("user"),
	EDITOR("editor"),
	CHIEF_EDITOR("chiefeditor");
	
	UserType(String string) {
		this.value = string;
	}
	
	private String value;
	
		
	public String getValue() {
		return this.value;
	}
}

