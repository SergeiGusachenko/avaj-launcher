#!bin/sh
javac -d . src/com/academyplus/**/*.java
java -cp . com.academyplus.vehicles.Main $@
