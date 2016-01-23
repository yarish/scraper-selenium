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
<h3>Download / View Screencast from youtube </h3>
https://youtu.be/jC06z8uRCJ0  </br> 

Download runnable jar and log files from google drive</br>
https://goo.gl/MdXRBQ ,19.2 MB fat jar with all dependencies</br>

</br>
Directly run from command line</br>
<code>
$ java -jar scraper-selenium-jar-with-dependencies.jar https://www.shoppersstop.com/haute-curry-women-cotton-anarkali-printed-churidar-suit/p-9758640
</code>
</br>
<code>
$ java -jar scraper-selenium-jar-with-dependencies.jar https://www.shoppersstop.com/kaya-pigmentation-reducing-complex-get-rs-500-off-on-kaya-products-for-rs-2490-/p-9787102
</code>
</br>
</br>
download the last run log file
https://goo.gl/vGvVyZ    

<h3>compile from source </h3>

1) checkout the code from github</br>
<code>$ pwd </code></br>
/home/yarish</br>
<code>$ git clone https://github.com/yarish/scraper-selenium.git</code></br>
or directly download as zip https://github.com/yarish/scraper-selenium/archive/master.zip</br> 
<code>$ cd scraper-selenium </code></br>
<code>$ mvn clean install</code></br>
<code>$ cd target </code></br>
<code>$ java -jar scraper-selenium-jar-with-dependencies.jar https://www.shoppersstop.com/haute-curry-women-cotton-anarkali-printed-churidar-suit/p-9758640 </code> </br>
<code>
$ java -jar scraper-selenium-jar-with-dependencies.jar https://www.shoppersstop.com/kaya-pigmentation-reducing-complex-get-rs-500-off-on-kaya-products-for-rs-2490-/p-9787102
</code></br>
</p>


<p>
Test cases handled :</br> 
1) missing URL param in the command line </br> 
2) whether URL is valid ?</br>
3) what if the product does not exists anymore !</br> 
4) annoying popup comes - advertisements / promos !!</br>
</p>
</body>
</html>