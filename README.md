MiniJSON for Java
========

A minimal JSON builder - parser in Java.


Note (April 3rd, 2015)
---

_I started this project with many ideas. Although it was originally meant to be "minimal", the library grew over time and it included many novel and interesting features that were not generally found in other JSON libraries. This project is still work in progress. Due to personal reasons, however, I've been using C# (not Java) as my primary coding language these days, and it's rather unlikely that I'll "finish" this project any time soon. One good thing about open source projects like this is that if anybody wants it, they have full access to the source code. I appreciate your interests in this project, and I apologize for "not finishing" it. I hope the cosebase in this repo can be a basis for your own parser/serializer for JSON. (Note that "partial" parsing/building, for instance, can be rather useful in many use cases once you realize what it does.) Meanwhile, I've just started a new project to "port" the MiniJSON library to the C# programming language, if anybody's interested. You can find the project on CodePlex:_

* [Holo JSON Parser and Serializer in C#](http://holojson.codeplex.com/)


---


Synopsis
---

MiniJSON is a simple Java library for generating / parsing JSON.
It provides a simple and yet flexible API.



Getting Started
---

If you use Maven, you can (locally) build and install the *minijson* library using standard Maven goals. 
(If you don't use Maven, then there is an ant script under `nomaven/scripts`.)
Otherwise, you can add, in your project, the following dependency:

  	<dependency>
      <groupId>org.aerysoft.minijson</groupId>
      <artifactId>minijson-core</artifactId>
      <version>0.9.2</version>
  	</dependency>

`MiniJson` is compatible with JDK 1.6 or later.


High Level API Design
---

`MiniJSON` provides the basic JSON APIs for _parse()_ and _build()_.
In addition, `MiniJSON` provides two extra sets of APIs, which differentiate itself from other JSON libraries.


#### Configurable Parsing/Building

`MiniJSON` includes certain Builder (JSON generator) and Parser classes which take "policy" objects as inputs.
These policy objects can be used to customize the parsing/building operations.


#### "Partial" Parsing/Building

This is rather unique to `MiniJSON`.
All JSON parsers and JSON generators/builders implement parsing/building as all-or-none operations.
Given a JSON string, a parser creates an object corresponding to the JSON string.
Given an object, a builder generates a JSON string representation of the object.

On the other hand, 
`MiniJSON` includes APIs which can do "partial parsing" or "partial building".



API
---

#### High Level APIs

At the highest/simplest level, simple wrapper classes,
`MiniJsonParser` and `MiniJsonBuilder`, can be used to parse/build JSON.

    JsonParser miniParser = new MiniJsonParser();
    String json = "{\"a\":\"b\"}";
    Object obj = miniParser.parse(json);

    JsonBuilder miniBuilder = new MiniJsonBuilder();
    Object obj = ...;
    String json = miniBuilder.build(obj, 4);

Alternatively, high-level JSON Object/Array wrappers, 
`MiniJsonObject` and `MiniJsonArray`, can be used to parse/build JSON.

    Map<String,Object> obj1 = ...;
    JsonObject miniObject1 = new MiniJsonObject(obj1);
    String json1 = miniObject1.toJsonString();

    String json2 = ...;
    JsonObject miniObject2 = new MiniJsonObject(json2);
    Object obj2 = miniObject2.toJsonStructure();


#### Full Parser/Builder APIs

(TBD)


#### "Partial" Parser/Builder APIs

(TBD)



Please refer to [the online API Docs](http://www.minijson.org/repo/apidocs/) for more information.

<!--
Please refer to [the Project wiki pages](https://github.com/harrywye/minijson/wiki/_pages) 
or [the online API Docs](http://www.minijson.org/repo/apidocs/).
-->




