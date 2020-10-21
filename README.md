# Cat Project in Python and Java
 Contains a web scraping program written in Java that scrapes the Oregon Humane Society website for cats
The scrape program makes use of the jsoup library for java to do a static download of the website that
contains all available cats to adopt from the oregon humane society. The program then outputs the information
associated with each cat such as name, age, weight, and URL for their picture.

The bash script runs this program and pipes the output into sort, which sorts the cats by weight, and then pipes
the output from sort into the python script which emails the list to me. The mail program is not my own work, I have just
included it to show how the program should function.
