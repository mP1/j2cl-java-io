/*
 * Copyright 2019 Miroslav Pokorny (github.com/mP1)
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
 *
 */

package walkingkooka.javaioj2cl.java.io;

import org.junit.jupiter.api.Test;
import walkingkooka.reflect.ClassTesting2;
import walkingkooka.reflect.JavaVisibility;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public final class DataInputStreamTest extends JavaIoTestCase<DataInputStream> {

    @Override
    public void testAllConstructorsVisibility() {
    }

    @Test
    public void testReadBoolean() throws Exception {
        final boolean[] values = new boolean[]{false, true, false, true};
        final ByteArrayOutputStream bytesOutput = new ByteArrayOutputStream();
        final java.io.DataOutputStream dataOutput = new java.io.DataOutputStream(bytesOutput);

        for (final boolean value : values) {
            dataOutput.writeBoolean(value);
        }
        dataOutput.flush();

        final java.io.DataInputStream jdk = newJdk(bytesOutput);
        final DataInputStream emul = newEmul(bytesOutput);

        for (final boolean value : values) {
            assertEquals(value, jdk.readBoolean());
            assertEquals(value, emul.readBoolean());
        }
    }

    @Test
    public void testReadByte() throws Exception {
        final byte[] values = new byte[]{0, 1, Byte.MAX_VALUE, Byte.MIN_VALUE};
        final ByteArrayOutputStream bytesOutput = new ByteArrayOutputStream();
        final java.io.DataOutputStream dataOutput = new java.io.DataOutputStream(bytesOutput);

        for (final byte value : values) {
            dataOutput.writeByte(value);
        }
        dataOutput.flush();

        final java.io.DataInputStream jdk = newJdk(bytesOutput);
        final DataInputStream emul = newEmul(bytesOutput);

        for (final byte value : values) {
            assertEquals(value, jdk.readByte());
            assertEquals(value, emul.readByte());
        }
    }

    @Test
    public void testReadChar() throws Exception {
        final char[] values = "ABCdef".toCharArray();
        final ByteArrayOutputStream bytesOutput = new ByteArrayOutputStream();
        final java.io.DataOutputStream dataOutput = new java.io.DataOutputStream(bytesOutput);

        for (final char value : values) {
            dataOutput.writeChar(value);
        }
        dataOutput.flush();

        final java.io.DataInputStream jdk = newJdk(bytesOutput);
        final DataInputStream emul = newEmul(bytesOutput);

        for (final char value : values) {
            assertEquals(value, jdk.readChar());
            assertEquals(value, emul.readChar());
        }
    }

    @Test
    public void testReadDouble() throws Exception {
        final double[] values = new double[]{0, 1, 2.5, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN};
        final ByteArrayOutputStream bytesOutput = new ByteArrayOutputStream();
        final java.io.DataOutputStream dataOutput = new java.io.DataOutputStream(bytesOutput);

        for (final double value : values) {
            dataOutput.writeDouble(value);
        }
        dataOutput.flush();

        final java.io.DataInputStream jdk = newJdk(bytesOutput);
        final DataInputStream emul = newEmul(bytesOutput);

        for (final double value : values) {
            assertEquals(value, jdk.readDouble());
            assertEquals(value, emul.readDouble());
        }
    }

    @Test
    public void testReadFloat() throws Exception {
        final float[] values = new float[]{0, 1, 2.5f, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN};
        final ByteArrayOutputStream bytesOutput = new ByteArrayOutputStream();
        final java.io.DataOutputStream dataOutput = new java.io.DataOutputStream(bytesOutput);

        for (final float value : values) {
            dataOutput.writeFloat(value);
        }
        dataOutput.flush();

        final java.io.DataInputStream jdk = newJdk(bytesOutput);
        final DataInputStream emul = newEmul(bytesOutput);

        for (final float value : values) {
            assertEquals(value, jdk.readFloat());
            assertEquals(value, emul.readFloat());
        }
    }

    @Test
    public void testReadFully() throws Exception {
        final byte[] values = new byte[]{0, 1, Byte.MAX_VALUE, Byte.MIN_VALUE};
        final ByteArrayOutputStream bytesOutput = new ByteArrayOutputStream();
        final java.io.DataOutputStream dataOutput = new java.io.DataOutputStream(bytesOutput);

        for (final byte value : values) {
            dataOutput.writeByte(value);
        }
        dataOutput.flush();

        final java.io.DataInputStream jdk = newJdk(bytesOutput);
        final DataInputStream emul = newEmul(bytesOutput);

        {
            final byte[] buffer = new byte[values.length];
            jdk.readFully(buffer);
            assertArrayEquals(values, buffer);
        }
        {
            final byte[] buffer = new byte[values.length];
            emul.readFully(buffer);
            assertArrayEquals(values, buffer);
        }
    }

    @Test
    public void testReadFullyOffsetLength() throws Exception {
        final byte[] values = new byte[]{0, 1, Byte.MAX_VALUE, Byte.MIN_VALUE};
        final ByteArrayOutputStream bytesOutput = new ByteArrayOutputStream();
        final java.io.DataOutputStream dataOutput = new java.io.DataOutputStream(bytesOutput);

        for (final byte value : values) {
            dataOutput.writeByte(value);
        }
        dataOutput.flush();

        final java.io.DataInputStream jdk = newJdk(bytesOutput);
        final DataInputStream emul = newEmul(bytesOutput);

        {
            final byte[] buffer = new byte[values.length];
            jdk.readFully(buffer, 0, values.length);
            assertArrayEquals(values, buffer);
        }
        {
            final byte[] buffer = new byte[values.length];
            emul.readFully(buffer, 0, values.length);
            assertArrayEquals(values, buffer);
        }
    }

    @Test
    public void testReadInt() throws Exception {
        final int[] values = new int[]{0, 1, 2, Integer.MAX_VALUE, Integer.MIN_VALUE};
        final ByteArrayOutputStream bytesOutput = new ByteArrayOutputStream();
        final java.io.DataOutputStream dataOutput = new java.io.DataOutputStream(bytesOutput);

        for (final int value : values) {
            dataOutput.writeInt(value);
        }
        dataOutput.flush();

        final java.io.DataInputStream jdk = newJdk(bytesOutput);
        final DataInputStream emul = newEmul(bytesOutput);

        for (final int value : values) {
            assertEquals(value, jdk.readInt());
            assertEquals(value, emul.readInt());
        }
    }

    @Test
    public void testReadLong() throws Exception {
        final long[] values = new long[]{0, 1, 2, Long.MAX_VALUE, Long.MIN_VALUE};
        final ByteArrayOutputStream bytesOutput = new ByteArrayOutputStream();
        final java.io.DataOutputStream dataOutput = new java.io.DataOutputStream(bytesOutput);

        for (final long value : values) {
            dataOutput.writeLong(value);
        }
        dataOutput.flush();

        final java.io.DataInputStream jdk = newJdk(bytesOutput);
        final DataInputStream emul = newEmul(bytesOutput);

        for (final long value : values) {
            assertEquals(value, jdk.readLong());
            assertEquals(value, emul.readLong());
        }
    }

    @Test
    public void testReadShort() throws Exception {
        final short[] values = new short[]{0, 1, 2, Short.MAX_VALUE, Short.MIN_VALUE};
        final ByteArrayOutputStream bytesOutput = new ByteArrayOutputStream();
        final java.io.DataOutputStream dataOutput = new java.io.DataOutputStream(bytesOutput);

        for (final short value : values) {
            dataOutput.writeShort(value);
        }
        dataOutput.flush();

        final java.io.DataInputStream jdk = newJdk(bytesOutput);
        final DataInputStream emul = newEmul(bytesOutput);

        for (final short value : values) {
            assertEquals(value, jdk.readShort());
            assertEquals(value, emul.readShort());
        }
    }

    @Test
    public void testReadUnsignedByte() throws Exception {
        final byte[] values = new byte[]{0, 1, 2, (byte) 0xff};
        final ByteArrayOutputStream bytesOutput = new ByteArrayOutputStream();
        final java.io.DataOutputStream dataOutput = new java.io.DataOutputStream(bytesOutput);

        for (final byte value : values) {
            dataOutput.writeByte(value);
        }
        dataOutput.flush();

        final java.io.DataInputStream jdk = newJdk(bytesOutput);
        final DataInputStream emul = newEmul(bytesOutput);

        for (final byte value : values) {
            assertEquals(0xff & value, jdk.readUnsignedByte());
            assertEquals(0xff & value, emul.readUnsignedByte());
        }
    }

    @Test
    public void testReadUnsignedShort() throws Exception {
        final short[] values = new short[]{0, 1, 2, (short) 0xffff};
        final ByteArrayOutputStream shortsOutput = new ByteArrayOutputStream();
        final java.io.DataOutputStream dataOutput = new java.io.DataOutputStream(shortsOutput);

        for (final short value : values) {
            dataOutput.writeShort(value);
        }
        dataOutput.flush();

        final java.io.DataInputStream jdk = newJdk(shortsOutput);
        final DataInputStream emul = newEmul(shortsOutput);

        for (final short value : values) {
            assertEquals(0xffff & value, jdk.readUnsignedShort());
            assertEquals(0xffff & value, emul.readUnsignedShort());
        }
    }

    @Test
    public void testReadUTF() throws Exception {
        final String[] values = new String[]{"A", "bc", "1234567890"};
        final ByteArrayOutputStream shortsOutput = new ByteArrayOutputStream();
        final java.io.DataOutputStream dataOutput = new java.io.DataOutputStream(shortsOutput);

        for (final String value : values) {
            dataOutput.writeUTF(value);
        }
        dataOutput.flush();

        final java.io.DataInputStream jdk = newJdk(shortsOutput);
        final DataInputStream emul = newEmul(shortsOutput);

        for (final String value : values) {
            assertEquals(value, jdk.readUTF());
            assertEquals(value, emul.readUTF());
        }
    }

    @Test
    public void testReadUTFDataInput() throws Exception {
        final String[] values = new String[]{"A", "bc", "1234567890"};
        final ByteArrayOutputStream shortsOutput = new ByteArrayOutputStream();
        final java.io.DataOutputStream dataOutput = new java.io.DataOutputStream(shortsOutput);

        for (final String value : values) {
            dataOutput.writeUTF(value);
        }
        dataOutput.flush();

        final java.io.DataInputStream jdk = newJdk(shortsOutput);
        final DataInputStream emul = newEmul(shortsOutput);

        for (final String value : values) {
            assertEquals(value, java.io.DataInputStream.readUTF(jdk));
            assertEquals(value, DataInputStream.readUTF(emul));
        }
    }

    @Test
    public void testSkipBytes() throws Exception {
        final byte[] values = new byte[]{0, 1, 2, 3, 4, 5, 6, 7};
        final ByteArrayOutputStream bytesOutput = new ByteArrayOutputStream();
        final java.io.DataOutputStream dataOutput = new java.io.DataOutputStream(bytesOutput);

        for (final byte value : values) {
            dataOutput.writeByte(value);
        }
        dataOutput.flush();

        final java.io.DataInputStream jdk = newJdk(bytesOutput);
        final DataInputStream emul = newEmul(bytesOutput);

        final int skip = 5;

        jdk.skipBytes(skip);
        emul.skipBytes(skip);

        int i = 0;
        for (final byte value : values) {
            if (i++ < skip) {
                continue;
            }
            assertEquals(value, jdk.readByte());
            assertEquals(value, emul.readByte());
        }
    }

    private java.io.DataInputStream newJdk(final ByteArrayOutputStream output) {
        return new java.io.DataInputStream(new ByteArrayInputStream(output.toByteArray()));
    }

    private DataInputStream newEmul(final ByteArrayOutputStream output) {
        return new DataInputStream(new ByteArrayInputStream(output.toByteArray()));
    }

    // ClassTesting2....................................................................................................

    @Override
    public Class<DataInputStream> type() {
        return DataInputStream.class;
    }

    @Override
    Class<?> jdkType() {
        return java.io.DataInputStream.class;
    }
}
