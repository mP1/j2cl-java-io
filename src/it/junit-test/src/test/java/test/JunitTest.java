/*
 * Copyright © 2020 Miroslav Pokorny
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package test;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Assert;
import org.junit.Test;
import walkingkooka.j2cl.java.io.string.StringDataInputDataOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;

@J2clTestInput(JunitTest.class)
public class JunitTest {

    @Test
    public void testStringDataOutputStringDataInput() throws Exception {
        final StringBuilder written = new StringBuilder();

        final DataOutput out = StringDataInputDataOutput.output(written::append);
        out.writeBoolean(true);
        out.writeInt(5);
        out.writeDouble(6.75);
        out.writeUTF("abc,123");

        final DataInput in = StringDataInputDataOutput.input(written.toString());

        Assert.assertEquals("readBoolean", true, in.readBoolean());
        Assert.assertEquals("readInt", 5, in.readInt());
        Assert.assertEquals("readDouble", 6.75, in.readDouble(), 0.1);
        Assert.assertEquals("readUTF", "abc,123", in.readUTF());
    }

    @Test
    public void testWriteDataOutputReadDataInput() throws Exception {
        final boolean booleanValue = true;

        final byte byteValue = 1;

        final char charValue = 'A';

        final double doubleValue = 2.5;
        final float floatValue = 3.5f;
        final int intValue = Integer.MAX_VALUE;
        final long longValue = Long.MAX_VALUE;
        final short shortValue = Short.MAX_VALUE;

        final String string = "utf-string-XYZ789";

        try (final ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            try (final DataOutputStream dataOutput = new DataOutputStream(out)) {
                dataOutput.writeBoolean(booleanValue);

                dataOutput.writeByte(byteValue);

                dataOutput.writeChar(charValue);

                dataOutput.writeDouble(doubleValue);
                dataOutput.writeFloat(floatValue);

                dataOutput.writeInt(intValue);
                dataOutput.writeLong(longValue);
                dataOutput.writeShort(shortValue);

                dataOutput.writeUTF(string);

                dataOutput.flush();
            }

            out.flush();

            try (final ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray())) {
                try (final DataInputStream dataInput = new DataInputStream(in)) {
                    Assert.assertEquals(booleanValue, dataInput.readBoolean());

                    Assert.assertEquals(byteValue, dataInput.readByte());

                    Assert.assertEquals(charValue, dataInput.readChar());

                    Assert.assertEquals("readDouble", doubleValue, dataInput.readDouble(), 0.1);
                    Assert.assertEquals("readFloat", floatValue, dataInput.readFloat(), 0.1f);

                    Assert.assertEquals("readInt", intValue, dataInput.readInt());
                    Assert.assertEquals("readLong", longValue, dataInput.readLong());
                    Assert.assertEquals("readShort", shortValue, dataInput.readShort());

                    Assert.assertEquals("readUTF", string, dataInput.readUTF());
                }
            }
        }
    }
}
