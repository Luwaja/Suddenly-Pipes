::@echo offq
javac Game.java View.java Controller.java Model.java Pipe.java
if %errorlevel% neq 0 (
	echo There was an error; exiting now.	
) else (
	echo Compiled correctly!  Running Game...
	java Game	
)
