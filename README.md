mytest
======

The project is based on Apache Maven.

The entry point is the class mytest.Main.

The class provides for both the cases you need to use an http proxy or not.

---------------
Usage:
Main.main(<queryString>) 
or 
Main.main(<queryString>, <httpProxyHost>, <httpProxyPort>)
---------------

The result is store in "result.csv" file.

Inside the code there are 4 steps to accomplish the task:

- clean result file (to clear previous usage)

- get Http resource using input query string

- parse json to csv

- write csv to file


It is used an abstractFactory pattern to create instances of concrete classes to whom to delegate these steps.

The frameworks used are Apache's HttpClient and Google's Json.Simple.

Finally a JUnit class is used to unit test:  mytest.MyTestJUnit. 






