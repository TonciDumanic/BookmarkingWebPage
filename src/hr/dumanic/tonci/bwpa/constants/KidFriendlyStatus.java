package hr.dumanic.tonci.bwpa.constants;

public enum KidFriendlyStatus {
	

APPROVED("approved"),
REJECTED("rejected"),
UNKNOWN("unknown");

KidFriendlyStatus(String string) {
	this.value = string;
}

private String value;

public String getValue() {
	return this.value;
}
}
