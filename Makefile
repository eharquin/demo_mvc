JFLAGS = -sourcepath src -cp build -d build -implicit:none
SRC = src/fr/utc/demo_mvc/
BLD = build/fr/utc/demo_mvc/
JC = javac -Xlint
JV = java

MAIN = -cp "build" fr.utc.demo_mvc.Main


$(BLD)Main.class: $(SRC)Main.java $(BLD)View.class $(BLD)Model.class $(BLD)Controller.class $(BLD)ColorFileReader.class
	$(JC) $(JFLAGS) $<

$(BLD)View.class: $(SRC)View.java 
	$(JC) $(JFLAGS) $<

$(BLD)Model.class: $(SRC)Model.java
	$(JC) $(JFLAGS) $<

$(BLD)ColorFileReader.class: $(SRC)ColorFileReader.java
	$(JC) $(JFLAGS) $<

$(BLD)Controller.class: $(SRC)Controller.java $(BLD)Model.class
	$(JC) $(JFLAGS) $<


clean:
	$(RM) $(BLD)*.class

run:
	$(JV) $(MAIN)