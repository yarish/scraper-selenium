<html>
<body>

<h2>Problem 1 :</h2>
https://docs.google.com/document/d/1SpCG_ACuzhi0JF6PmOyZfxBSao-oYS1Nw9iIABwe1xc/edit


<h2> Solution: </h2>

In Yodlee We had used Proprietary Yodlee SDK APIs which was wrapper APIs for IE DOM elements.
Now I have NO access to those APIs !! </br>
so I have to find out equivalent libraries to manipulate DOM elements / simulate headless browser behaviour. </br>
I have quickly evaluated Jsoup , HTML unit and Selelinum.</br>
I am using selenium for this implementation.</br>
</p>


<p>
1) checkout the code from github</br>
$ pwd </br>
/home/yarish</br>
$ git clone https://github.com/yarish/scraper-selenium.git</br>
$ cd scraper-selenium </br>
$ mvn clean install</br>
$ cd target </br>
$ java -jar scraper-selenium-jar-with-dependencies.jar <URL></br>
</p>
</body>
</html>


Test cases :
1) missing URL param in the command line 
2) whether URL is valid ?
3) product does not exists anymore ! 
4) annoying popup comes - advertisements / promos !!
5) 

