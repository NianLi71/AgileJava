
Download junit3.8.1 from https://mvnrepository.com/artifact/junit/junit/3.8.1

```bash
javac -cp :$HOME/Documents/Codes/Java-Tools/lib/junit-3.8.1.jar StudentTest.java
java -cp .:$HOME/Documents/Codes/Java-Tools/lib/junit-3.8.1.jar junit.awtui.TestRunner StudentTest
```

Run all tests without package:
```bash
javac -cp :$HOME/Documents/Codes/Java-Tools/lib/junit-3.8.1.jar AllTests.java;\
java -cp .:$HOME/Documents/Codes/Java-Tools/lib/junit-3.8.1.jar junit.awtui.TestRunner AllTests
```

Within package:
```bash
javac -cp :$HOME/Documents/Codes/Java-Tools/lib/junit-3.8.1.jar studentinfo/*.java
java -cp .:$HOME/Documents/Codes/Java-Tools/lib/junit-3.8.1.jar junit.awtui.TestRunner studentinfo.AllTests
```