# Adapter design pattern

This pattern is used to allow two incompatible interfaces to collaborate.

For example, if we have a plug which has 3 pins and needs 10 unit of power per second and we have a switch which has only 2 pins and delivers 100 unit of power per second. To make them work together we needs an adapter which will connnect our plug to our switch and converts 100 unit/sec to 10 unit/sec.
If we have two interfaces which has different input and output types, then we can use same adapter concept to make them work together.

## Example

We were using youtube library to convert videos into XML format, then from that XML content we used to extract useful information using a analytics library. We were using following version of libraries.

1. YouTube (1.x)
2. AnalyticsService (1.x)

To improve some performance related issues AnalyticsService has upgraded its functionality which is available in version (2.x), We need to upgrade analytics library to the latest version and make our code compatible with it.

### Observation

As we observed we were using following function of analytics library (1.x) to get important information from the XML code:

```java
    List<String> extractDataPoints(XMLData data){
        // code for data extraction
    }
```

But now in version 2.x signature of this method has been changes as following:

```java
    List<String> extractDataPoints(JSONData data){
        // code for data extraction
    }
```

Now, this analytics library works with json data instead of xml data.

At client side we are using `AnalyticsService` interface and calling `extractDataPoints` function, out client side code looks like this with analytics library 1.x .

```java
    AnalyticsService analyticsService = new AnalyticsServiceImpl();
    YoutubeService youtubeService = new YoutubeServiceImpl();
    VideoService videoService = new VideoServiceImpl();

    // find video by id from our internal video service.
    VideoContent video = videoSerivce.getVideoById(1);

    // get xmlData from the video content using youtube service.
    XMLData xmlData = youtubeService.getXMLData(video);

    // extract data points from the xml data using analytics library 1.x
    List<String> dataPoints = analyticsService.extractDataPoints(xmlData);
```

After upgrading our analytics library version from 1.x to 2.x, now `extractDataPoints` function requires data in `JSONdata` format.
But, youtube service returns data in XML format so now we have to change data from xml to json at our client side.

### Solution

#### Without using adapter pattern -

We can solve this problem without using any specific pattern. We just need to change our data from xml to json at our client side code like below example.

```java
    AnalyticsService analyticsService = new AnalyticsServiceImpl();
    YoutubeService youtubeService = new YoutubeServiceImpl();
    VideoService videoService = new VideoServiceImpl();

    // find video by id from our internal video service.
    VideoContent video = videoSerivce.getVideoById(1);

    // get xmlData from the video content using youtube service.
    XMLData xmlData = youtubeService.getXMLData(video);

    // clean xml data and change it to the json format.
    XMLData cleanedXmlData = utils.cleanData(xmlData);
    XMLData filteredXmlData = utils.filterata(xmlData);
    JSONData jsonData = utils.convertXmlToJSONData(filteredXmlData);

    // extract data points from the xml data using analytics library 1.x
    List<String> dataPoints = analyticsService.extractDataPoints(jsonData);
```

While this approach can potentially address our problem, it may not be considered an optimal solution due to its suboptiomal design. We have tightly coupled our client code with the conversion logic, which could be seperated into another file or class for better organization and maintainability.

Here, adapter pattern comes into picture which will help us solving our problem without coupling conversion code to the client.

#### Using Adapter design pattern -

We can create an adapter interface `AnalyticsAdapter` and an implementation of it `AnalyticsAdapterImpl` which will contain our converion code also. It will be having a same method named `extractDataPoints` with same signature as it is currently present in our code.

After applying adapter class into our client code, our client looks like follwing:

```java
    AnalyticsAdapter analyticsAdapter = new AnalyticsAdapterImpl();
    YoutubeService youtubeService = new YoutubeServiceImpl();
    VideoService videoService = new VideoServiceImpl();

    // find video by id from our internal video service.
    VideoContent video = videoSerivce.getVideoById(1);

    // get xmlData from the video content using youtube service.
    XMLData xmlData = youtubeService.getXMLData(video);

    // extract data points from the xml data using analytics library 1.x
    List<String> dataPoints = analyticsAdapter.extractDataPoints(jsonData);
```

While creating adapter pattern there are two approaches, class adapter and object adapter. However, both these approaches produce same result.

- Class Adapter - This pattern uses `java inheritance`, adapter class extends target class.
- Object Adapter - This patter uses `java composition`, adapter class has a target class object. 

##### Implement `AnalyticsAdapter` using class adapter pattern -

We can create a new adapter interface. Then, we can create an implementation class of this adapter interface which will extends our target implementation class as a parent/super class.

```java
    interface AnalyticsAdapter{
        List<String> extractDataPoints(XMLData data);
    }


    class AnalyticsAdapterImpl extends AnalyticsServiceImpl implements AnalyticsAdapter{
        
        /**
         * Cleans xml data and prepare it into JSON format, so we can use it in analytics service.
         * @param data XMLData from which important data to be extracted.
         * @return List<String> extracted data points from analytics service
         */
        @Override
        List<String> extractDataPoints(XMLData data){

            // cleans and filter xml data
            XMLData cleanedXmlData = utils.cleanData(xmlData);
            XMLData filteredXmlData = utils.filterata(xmlData);
            
            // convert xml data into json format
            JSONData jsonData = utils.convertXmlToJSONData(filteredXmlData);
            
            // extract important data points by using AnalyticsService
            return super.extractDataPoints(jsonData);
        }

    }
```

##### Implement `AnalyticsAdapter` using object adapter pattern -

We can create a new interface which will define our desired methods. Then, we can create an implementation class which will have an object of `AnalyticsService` which will be use for extract important data from json data.

```java
    interface AnalyticsAdapter{
        List<String> extractDataPoints(XMLData data);
    }


    class AnalyticsAdapterImpl implements AnalyticsAdapter{

        private AnalyticsService analyticsService = new AnalyticsServiceImpl();
        
        /**
         * Cleans xml data and prepares it into JSON format, so we can use it in analytics service.
         * @param data XMLData from which important data to be extracted.
         * @return List<String> extracted data points from analytics service
         */
        @Override
        List<String> extractDataPoints(XMLData data){

            // cleans and filter xml data
            XMLData cleanedXmlData = utils.cleanData(xmlData);
            XMLData filteredXmlData = utils.filterata(xmlData);
            
            // convert xml data into json format
            JSONData jsonData = utils.convertXmlToJSONData(filteredXmlData);
            
            // extract important data points by using AnalyticsService
            return analyticsService.extractDataPoints(jsonData);
        }

    }
```