J4Json - JSON Library in Java
========

_A Java JSON builder - parser library._


Synopsis
---

J4Json is a simple Java library for generating / parsing JSON.
It provides a simple and yet flexible API.



Getting Started
---

If you use Maven, you can (locally) build and install the *j4json* library using standard Maven goals. 
(If you don't use Maven, then there is an ant script under `nomaven/scripts`.)
Otherwise, you can add, in your project, the following dependency:

  	<dependency>
      <groupId>org.j4json</groupId>
      <artifactId>j4json-core</artifactId>
      <version>0.9.2</version>
  	</dependency>

`J4Json` is compatible with JDK 1.7 or later.


High Level API Design
---

`J4Json` provides the basic JSON APIs for _parse()_ and _build()_.
In addition, `J4Json` provides two extra sets of APIs, which differentiate itself from other JSON libraries.


#### Configurable Parsing/Building

`J4Json` includes certain Builder (JSON generator) and Parser classes which take "policy" objects as inputs.
These policy objects can be used to customize the parsing/building operations.


#### "Partial" Parsing/Building

This is rather unique to `J4Json`.
All JSON parsers and JSON generators/builders implement parsing/building as all-or-none operations.
Given a JSON string, a parser creates an object corresponding to the JSON string.
Given an object, a builder generates a JSON string representation of the object.

On the other hand, 
`J4Json` includes APIs which can do "partial parsing" or "partial building".



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



Please refer to [the online API Docs](http://www.j4json.org/repo/apidocs/) for more information.

<!--
Please refer to [the Project wiki pages](https://gitlab.com/j4json/main/wiki/_pages) 
or [the online API Docs](http://www.j4json.org/repo/apidocs/).
-->




