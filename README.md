<html>
<body>

<h2>Problem 1 :
https://docs.google.com/document/d/1SpCG_ACuzhi0JF6PmOyZfxBSao-oYS1Nw9iIABwe1xc/edit
</h2>

<h2> Solution: </h2>

<p>
In Yodlee We had used Proprietary Yodlee SDK APIs which was wrapper APIs for IE DOM elements.
Now I have access to those APIs so I have to find out equivalent libraries to manipulate DOM elements / simulate headless browser behaviour.

I have quickly evaluated Jsoup , HTML unit and Selelinum.
I am using selenium for this implementation.

</p>


<code>
1) checkout the code from github
$ pwd
/home/yarish
$ git clone https://github.com/yarish/scraper-selenium.git
$ cd scraper-selenium 
$ mvn clean install
$ cd target 
$ java -jar scraper-selenium-jar-with-dependencies.jar <URL>
</code>
</body>
</html>
