package hr.dumanic.tonci.bwpa.constants;

public enum Gender {
	 MALE(0),
	FEMALE(1),
	OTHER(2);

	private int value;
	
	private Gender(int gender) { 
		this.value = gender;
	}
	
	public int getValue() {
		return value;
	}
	
}
