package hr.dumanic.tonci.bwpa.constants;

public enum BookGenre {

ART("art"),
BIOGRAPHY("biography"),
CHILDREN("children"),
FICTION("fiction"),
HISTORY("history"),
MYSTERY("mystery"),
PHILOSOPHY("philosophy"),
RELIGION("religion"),
ROMANCE("romance"),
SELF_HELP("self_help"),
TECHNICAL("technical");
	


BookGenre(String name) {
	this.name = name;
	
}

private String name;

public String getName() {
	return this.name;
	
}

}
