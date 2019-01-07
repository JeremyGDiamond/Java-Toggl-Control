# Java-Toggl-Control

Toggl is a web service for time tracking. [You can find it here.](https://toggl.com/) It has many applications in the worlds of business and education. There reports framework is unmatched, their feature rich ecosystem hooks in very well with other applications, and their rest api is extremely extensive. However all of there front end interfaces are unintuitive, time consuming and poorly optimized for my workflow. Their android app is particularly known to be horrible.

I set out to create my own interface using the api in the java base library. This approach was chosen as the result would be portable to not only the target platform of android but any desktop or future web version I may need.

## Classes

### Test_Main.java

Simply a driver for testing the functionality of the other classes.

### Universal_JSON_Body_Http_Methods.java

A class containing functions that perform basic http methods for interacting with a rest api that makes use of json objects. This specifically only makes use of native java libraries. All other posted solutions online made use of the apache library which was deprecated out of android support in as of java 10. I was surprised to find this was not a common application of java.

#### Universal_Get

Takes in a url, a username, and a password, as strings. Encodes the username and the password as a Base 64 string for a basic authentication. Sends a http get to the url with the encoded authentication and returns the response as a string.

#### Universal_Put

Takes in a url, a json object, a username, and a password as strings. Encodes the username and the password as a Base 64 string for a basic authentication. Sends a http put to the url with the encoded authentication and returns the response as a string.

#### Universal_Post

Takes in a url, a json object, a username, and a password as strings. Encodes the username and the password as a Base 64 string for a basic authentication. Formats connection parameters to handle the json body. Converts the json body to utf-8. Sends a http post to the url with the encoded authentication and json body. Returns the response as a string.

#### Notes
This will likely end up being split into its own package at some point as the functionality is extremely flexible. The class currently does not contain all http methods as they are not yet needed for any of my projects.

### togglProject.java
An adt for project id numbers, names and an ArrayList of descriptions. When constructed a placeholder description, “time well spent", is added to the ArrayList. This functionality will later be replaced.  

### togglAccount.java
The main driving class of the backend where all of the timer control functionality is housed.
Local data is your api token as a hard coded string, and an ArrayList of togglProject objects. This ArrayList must be populated via the readAllProjects method with the projects on your account according to the api. This is not done at construction to leave room open for other data population methods in the future.

#### currentTimer

#### stopCurrent

#### readAllProjects

#### startATimer

## Use
Adding the class files to any other java project enables starting and stopping timers. In togglAccount.java modify the uName variable to your api token found in the settings of the toggl website. If you don’t do this the errors are unintelligible.

