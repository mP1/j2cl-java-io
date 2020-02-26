[![Build Status](https://travis-ci.com/mP1/java-io-j2cl.svg?branch=master)](https://travis-ci.com/mP1/java-io-j2cl.svg?branch=master)
[![Coverage Status](https://coveralls.io/repos/github/mP1/java-io-j2cl/badge.svg?branch=master)](https://coveralls.io/github/mP1/java-io-j2cl?branch=master)

# java.io j2cl

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



### Transpiling

The `j2cl-maven-plugin` will repackage the source during the transpile phase, so `walkingkooka.javaioj2cl.java.io`
is available to the runtime as `java.io`. 



### Serialization

Serialization is not supported, and all support classes and forms including magic methods such as `writeReplace` are removed.



## Getting the source

You can either download the source using the "ZIP" button at the top
of the github page, or you can make a clone using git:

```
git clone git://github.com/mP1/java-io-j2cl.git
```
