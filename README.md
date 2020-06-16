[![Build Status](https://travis-ci.com/mP1/j2cl-java-io.svg?branch=master)](https://travis-ci.com/mP1/j2cl-java-io.svg?branch=master)
[![Coverage Status](https://coveralls.io/repos/github/mP1/j2cl-java-io/badge.svg?branch=master)](https://coveralls.io/github/mP1/j2cl-java-io?branch=master)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/mP1/j2cl-java-io.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/mP1/j2cl-java-io/context:java)
[![Total alerts](https://img.shields.io/lgtm/alerts/g/mP1/j2cl-java-io.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/mP1/j2cl-java-io/alerts/)
[![J2CL compatible](https://img.shields.io/badge/J2CL-compatible-brightgreen.svg)](https://github.com/mP1/j2cl-central)



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

- The package `walkingkooka.j2cl.java.io` is shaded to `java.io`.



### StringDataInput

- implements `java.io.DataInput`
- Reads data from a `java.lang.String` previous written by `StringDataOutput`
- This class is not shaded



#### Methods

- `readFully` throws `UnsupportedOperationException`
- `readLine` throws `UnsupportedOperationException`
- `readUTF` never returns `null`
- `skipBytes` throws `UnsupportedOperationException`



### StringDataOutput

- implements `java.io.DataOutput`
- Writes a `java.lang.String` which can be consumed by `StringDataOutput`
- This class is not shaded




#### Methods

- `write(byte[])` throws `UnsupportedOperationException`
- `write(byte[], int, int)` throws `UnsupportedOperationException`
- `writeChars` null throws `NullPointerException`
- `writeUTF` null throws `NullPointerException`



## Getting the source

You can either download the source using the "ZIP" button at the top
of the github page, or you can make a clone using git:

```
git clone git://github.com/mP1/j2cl-java-io.git
```
