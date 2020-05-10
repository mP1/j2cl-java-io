[![Build Status](https://travis-ci.com/mP1/j2cl-java-io.svg?branch=master)](https://travis-ci.com/mP1/j2cl-java-io.svg?branch=master)
[![Coverage Status](https://coveralls.io/repos/github/mP1/j2cl-java-io/badge.svg?branch=master)](https://coveralls.io/github/mP1/j2cl-java-io?branch=master)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/mP1/j2cl-java-io.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/mP1/j2cl-java-io/context:java)
[![Total alerts](https://img.shields.io/lgtm/alerts/g/mP1/j2cl-java-io.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/mP1/j2cl-java-io/alerts/)



# java.io for j2cl

The following source have been copied from the Apache Harmony project with minor changes. The most significant change
is the replacement of calls to `Messages` to fetch exception messages from a properties file, with the actual String literal.

- DataInput
- DataInputStream
- DataOutput
- DataOutputStream
- EOFException
- PushbackInputStream
- UTFDataFormatException

This assumes the above classes are not available in `com.vertispan.j2cl:jre`.



## walkingkooka.j2cl.java.io

Utilities particularly useful for creating binary data represented as a `java.lang.String` for later consumption in javascript as a `java.io.DataInput`.

- [StringDataInputDataOutput](https://github.com/mP1/j2cl-java-io/blob/master/src/main/java/walkingkooka/j2cl/java/io/string/StringDataInputDataOutput.java) Factory for both `StringDataInput` and `StringDataOutput` instances.
- [StringDataInput](https://github.com/mP1/j2cl-java-io/blob/master/src/main/java/walkingkooka/j2cl/java/io/string/StringDataInput.java) Consumes the `java.lang.String` produced by `StringDataOutput`.
- [StringDataOutput](https://github.com/mP1/j2cl-java-io/blob/master/src/main/java/walkingkooka/j2cl/java/io/string/StringDataOutput.java) Useful to create a `java.lang.String` within an annotation processor.

This package is not shaded and remains at its original package name.



### Transpiling

The `j2cl-maven-plugin` will shade the source during the transpile phase, so `walkingkooka.j2cl.java.io`
is available to the runtime as `java.io`. 



### Serialization

Serialization is not supported, and all support classes and forms including magic methods such as `writeReplace` are removed.



## Getting the source

You can either download the source using the "ZIP" button at the top
of the github page, or you can make a clone using git:

```
git clone git://github.com/mP1/j2cl-java-io.git
```
