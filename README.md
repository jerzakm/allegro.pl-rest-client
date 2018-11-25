## Introduction

Opinionated Java wrapper for allegro.pl REST API created to practice my documentation and Java skills and fill specific use cases in my other projects.

All requests use Apache HttpClient: https://hc.apache.org/httpcomponents-client-ga/

It's included in the library and you'll have to provide it to execute queries

    //Configure your own client, the following is deprecated
    
    HttpClient httpClient = new DefaultHttpClient();
        
    Foo bar = new Foo().execute(httpClient);    



### Features: 
* Authentication for device apps
* Performing offer search (/offers/listing)

### Roadmap:
* Categories structure and parameters (/sale/categories/)
* Modifying prices and shipping rates of current offers (/sale/)
* Creating new offers (/sale/) 
* Other resources as needed