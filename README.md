# movie-finder-selenium
<b>Selenium WebDriver Automated Movie Finder<\b> \
<i>Chrome WebDriver MovieFinder , using Selenium WebElement and Driver.<\i> \
Info about movie is extracted via HTML class attribute value (By.ByClassname("<classname of needed element>"));\
Selenium functionality allows to search for children elements in WebElement.
For example,\
<b>WebElement firstElem = driver.findElement(By.ByCssSelector("#id > div li[class="info"));
..now we can search in firstElem 
WebElement secondElemInFirstElem = firstElem.findElement(By.ByXpath("/[@id]/div//li[@class='info']"));<\b>
