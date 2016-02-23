![logo](res/invitrode.svg) 

A Java/Android library to generate random english pronounceable words based on a collection of constructed bi-grams.

[![MIT License](http://img.shields.io/badge/license-MIT-green.svg) ](https://github.com/maximeroussy/invitrode/license.md)[![Jitpack Release](https://jitpack.io/v/maximeroussy/invitrode.svg)](https://jitpack.io/#maximeroussy/invitrode)

##Summary
This is a lightweight and focused library. The Java class currently only includes 6 methods. More features are planned that will obviously add to the method count in the future. 

This library can be used in an infinite amount of ways:
- generate initial passwords for your user based applications   
- suggest character names in your games
- find a unique name for your child
- the list goes on...

##Usage
Using the library is extremely simple.

Simply create a RandomWord object:
```java
RandomWord myWordGenerator = new RandomWord();
```
And use the getNewWord method to generate a new random word on demand:
```java
String myNewWord = myWordGenerator.getNewWord(int lengthOfWord);
```

##Downloads
###Gradle (preferred):

Add the jitpack repository:

```gradle
    repositories {
        maven { url "https://jitpack.io" }
    }

    dependencies {
        compile 'com.github.maximeroussy:invitrode:1.0.9'
    }
```

###Maven:

Then add the Maven dependency:

```xml
	<repository>
	    <id>jitpack.io</id>
	    <url>https://jitpack.io</url>
	</repository>
	
	<dependency>
	    <groupId>com.github.maximeroussy</groupId>
	    <artifactId>invitrode</artifactId>
	    <version>1.0.8</version>
	</dependency>
```

###Manual:

The alternative method is downloading the [latest JAR](https://github.com/maximeroussy/invitrode/archive/1.0.9.zip)  to include yourself in your projects.

##Inspiration & Credits
Bi-gram source and general concept based on [Scrollback's generate.js](https://github.com/scrollback/scrollback/blob/master/lib/generate.js)  & described in [this blog post](https://www.hackerearth.com/notes/random-pronouncable-text-generator/)  by Aravind. This is a Java adaptation that will be further developed as a functional and feature rich random word generator.

##License
The MIT License (MIT)

Copyright (c) 2016 Maxime Roussy

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
