

Problem 1 :
https://docs.google.com/document/d/1SpCG_ACuzhi0JF6PmOyZfxBSao-oYS1Nw9iIABwe1xc/edit

Solution: 

In Yodlee We had used Proprietary Yodlee SDK APIs which was wrapper APIs for IE DOM elements.\n
Now I have access to those APIs so I have to find out equivalent libraries to manipulate DOM elements / simulate headless browser behaviour. \n

I have quickly evaluated Jsoup , HTML unit and Selelinum. \n
I am using selenium for this implementation.\n


1) checkout the code from github\n
$ pwd\n
/home/yarish\n
$ git clone https://github.com/yarish/scraper-selenium.git\n
$ cd scraper-selenium \n
$ mvn clean install\n
$ cd target \n
$ java -jar scraper-selenium-jar-with-dependencies.jar <URL>\n


