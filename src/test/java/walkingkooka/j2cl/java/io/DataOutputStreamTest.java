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

package walkingkooka.j2cl.java.io;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public final class DataOutputStreamTest extends JavaIoTestCase<DataOutputStream> {

    @Test
    public void tesWriteBoolean() throws Exception {
        final boolean[] values = new boolean[]{false, true, false, true};

        final ByteArrayOutputStream jdkBytesOutput = new ByteArrayOutputStream();
        final java.io.DataOutputStream jdk = new java.io.DataOutputStream(jdkBytesOutput);

        final ByteArrayOutputStream emulBytesOutput = new ByteArrayOutputStream();
        final DataOutputStream emul = new DataOutputStream(emulBytesOutput);

        for (final boolean value : values) {
            jdk.writeBoolean(value);
            emul.writeBoolean(value);
        }
        jdk.flush();
        emul.flush();

        assertEquals(jdk.size(), emul.size());

        final java.io.DataInputStream jdkInput = newJdk(jdkBytesOutput);
        final DataInputStream emulInput = newEmul(emulBytesOutput);

        for (final boolean value : values) {
            assertEquals(value, jdkInput.readBoolean());
            assertEquals(value, emulInput.readBoolean());
        }
    }

    @Test
    public void tesWriteByte() throws Exception {
        final byte[] values = new byte[]{0, 1, Byte.MAX_VALUE, Byte.MIN_VALUE};

        final ByteArrayOutputStream jdkBytesOutput = new ByteArrayOutputStream();
        final java.io.DataOutputStream jdk = new java.io.DataOutputStream(jdkBytesOutput);

        final ByteArrayOutputStream emulBytesOutput = new ByteArrayOutputStream();
        final DataOutputStream emul = new DataOutputStream(emulBytesOutput);

        for (final byte value : values) {
            jdk.writeByte(value);
            emul.writeByte(value);
        }
        jdk.flush();
        emul.flush();

        assertEquals(jdk.size(), emul.size());

        final java.io.DataInputStream jdkInput = newJdk(jdkBytesOutput);
        final DataInputStream emulInput = newEmul(emulBytesOutput);

        for (final byte value : values) {
            assertEquals(value, jdkInput.readByte());
            assertEquals(value, emulInput.readByte());
        }
    }

    @Test
    public void tesWriteBytes() throws Exception {
        final String[] values = new String[]{"A", "bc", "1234567890"};

        final ByteArrayOutputStream jdkBytesOutput = new ByteArrayOutputStream();
        final java.io.DataOutputStream jdk = new java.io.DataOutputStream(jdkBytesOutput);

        final ByteArrayOutputStream emulBytesOutput = new ByteArrayOutputStream();
        final DataOutputStream emul = new DataOutputStream(emulBytesOutput);

        for (final String value : values) {
            jdk.writeBytes(value);
            emul.writeBytes(value);
        }
        jdk.flush();
        emul.flush();

        assertEquals(jdk.size(), emul.size());
        assertArrayEquals(jdkBytesOutput.toByteArray(), emulBytesOutput.toByteArray());
    }

    @Test
    public void tesWriteChar() throws Exception {
        final char[] values = "ABCdef".toCharArray();

        final ByteArrayOutputStream jdkBytesOutput = new ByteArrayOutputStream();
        final java.io.DataOutputStream jdk = new java.io.DataOutputStream(jdkBytesOutput);

        final ByteArrayOutputStream emulBytesOutput = new ByteArrayOutputStream();
        final DataOutputStream emul = new DataOutputStream(emulBytesOutput);

        for (final char value : values) {
            jdk.writeChar(value);
            emul.writeChar(value);
        }
        jdk.flush();
        emul.flush();

        assertEquals(jdk.size(), emul.size());

        final java.io.DataInputStream jdkInput = newJdk(jdkBytesOutput);
        final DataInputStream emulInput = newEmul(emulBytesOutput);

        for (final char value : values) {
            assertEquals(value, jdkInput.readChar());
            assertEquals(value, emulInput.readChar());
        }
    }

    @Test
    public void tesWriteChars() throws Exception {
        final String[] values = new String[]{"A", "bc", "1234567890"};

        final ByteArrayOutputStream jdkBytesOutput = new ByteArrayOutputStream();
        final java.io.DataOutputStream jdk = new java.io.DataOutputStream(jdkBytesOutput);

        final ByteArrayOutputStream emulBytesOutput = new ByteArrayOutputStream();
        final DataOutputStream emul = new DataOutputStream(emulBytesOutput);

        for (final String value : values) {
            jdk.writeChars(value);
            emul.writeChars(value);
        }
        jdk.flush();
        emul.flush();

        assertEquals(jdk.size(), emul.size());
        assertArrayEquals(jdkBytesOutput.toByteArray(), emulBytesOutput.toByteArray());
    }

    @Test
    public void tesWriteDouble() throws Exception {
        final double[] values = new double[]{0, 1, 2.5, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.NaN};

        final ByteArrayOutputStream jdkBytesOutput = new ByteArrayOutputStream();
        final java.io.DataOutputStream jdk = new java.io.DataOutputStream(jdkBytesOutput);

        final ByteArrayOutputStream emulBytesOutput = new ByteArrayOutputStream();
        final DataOutputStream emul = new DataOutputStream(emulBytesOutput);

        for (final double value : values) {
            jdk.writeDouble(value);
            emul.writeDouble(value);
        }
        jdk.flush();
        emul.flush();

        assertEquals(jdk.size(), emul.size());

        final java.io.DataInputStream jdkInput = newJdk(jdkBytesOutput);
        final DataInputStream emulInput = newEmul(emulBytesOutput);

        for (final double value : values) {
            assertEquals(value, jdkInput.readDouble());
            assertEquals(value, emulInput.readDouble());
        }
    }

    @Test
    public void tesWriteFloat() throws Exception {
        final float[] values = new float[]{0, 1, 2.5f, Float.POSITIVE_INFINITY, Float.NEGATIVE_INFINITY, Float.NaN};

        final ByteArrayOutputStream jdkBytesOutput = new ByteArrayOutputStream();
        final java.io.DataOutputStream jdk = new java.io.DataOutputStream(jdkBytesOutput);

        final ByteArrayOutputStream emulBytesOutput = new ByteArrayOutputStream();
        final DataOutputStream emul = new DataOutputStream(emulBytesOutput);

        for (final float value : values) {
            jdk.writeFloat(value);
            emul.writeFloat(value);
        }
        jdk.flush();
        emul.flush();

        assertEquals(jdk.size(), emul.size());

        final java.io.DataInputStream jdkInput = newJdk(jdkBytesOutput);
        final DataInputStream emulInput = newEmul(emulBytesOutput);

        for (final float value : values) {
            assertEquals(value, jdkInput.readFloat());
            assertEquals(value, emulInput.readFloat());
        }
    }

    @Test
    public void tesWriteInt() throws Exception {
        final int[] values = new int[]{0, 1, 2, Integer.MAX_VALUE, Integer.MIN_VALUE};

        final ByteArrayOutputStream jdkBytesOutput = new ByteArrayOutputStream();
        final java.io.DataOutputStream jdk = new java.io.DataOutputStream(jdkBytesOutput);

        final ByteArrayOutputStream emulBytesOutput = new ByteArrayOutputStream();
        final DataOutputStream emul = new DataOutputStream(emulBytesOutput);

        for (final int value : values) {
            jdk.writeInt(value);
            emul.writeInt(value);
        }
        jdk.flush();
        emul.flush();

        assertEquals(jdk.size(), emul.size());

        final java.io.DataInputStream jdkInput = newJdk(jdkBytesOutput);
        final DataInputStream emulInput = newEmul(emulBytesOutput);

        for (final int value : values) {
            assertEquals(value, jdkInput.readInt());
            assertEquals(value, emulInput.readInt());
        }
    }

    @Test
    public void tesWriteLong() throws Exception {
        final long[] values = new long[]{0, 1, Long.MAX_VALUE, Long.MIN_VALUE};

        final ByteArrayOutputStream jdkLongsOutput = new ByteArrayOutputStream();
        final java.io.DataOutputStream jdk = new java.io.DataOutputStream(jdkLongsOutput);

        final ByteArrayOutputStream emulLongsOutput = new ByteArrayOutputStream();
        final DataOutputStream emul = new DataOutputStream(emulLongsOutput);

        for (final long value : values) {
            jdk.writeLong(value);
            emul.writeLong(value);
        }
        jdk.flush();
        emul.flush();

        assertEquals(jdk.size(), emul.size());

        final java.io.DataInputStream jdkInput = newJdk(jdkLongsOutput);
        final DataInputStream emulInput = newEmul(emulLongsOutput);

        for (final long value : values) {
            assertEquals(value, jdkInput.readLong());
            assertEquals(value, emulInput.readLong());
        }
    }

    @Test
    public void tesWriteShort() throws Exception {
        final short[] values = new short[]{0, 1, Short.MAX_VALUE, Short.MIN_VALUE};

        final ByteArrayOutputStream jdkShortsOutput = new ByteArrayOutputStream();
        final java.io.DataOutputStream jdk = new java.io.DataOutputStream(jdkShortsOutput);

        final ByteArrayOutputStream emulShortsOutput = new ByteArrayOutputStream();
        final DataOutputStream emul = new DataOutputStream(emulShortsOutput);

        for (final short value : values) {
            jdk.writeShort(value);
            emul.writeShort(value);
        }
        jdk.flush();
        emul.flush();

        assertEquals(jdk.size(), emul.size());

        final java.io.DataInputStream jdkInput = newJdk(jdkShortsOutput);
        final DataInputStream emulInput = newEmul(emulShortsOutput);

        for (final short value : values) {
            assertEquals(value, jdkInput.readShort());
            assertEquals(value, emulInput.readShort());
        }
    }

    @Test
    public void tesWriteUTFs() throws Exception {
        final String[] values = new String[]{"A", "bc", "1234567890"};

        final ByteArrayOutputStream jdkBytesOutput = new ByteArrayOutputStream();
        final java.io.DataOutputStream jdk = new java.io.DataOutputStream(jdkBytesOutput);

        final ByteArrayOutputStream emulBytesOutput = new ByteArrayOutputStream();
        final DataOutputStream emul = new DataOutputStream(emulBytesOutput);

        for (final String value : values) {
            jdk.writeUTF(value);
            emul.writeUTF(value);
        }
        jdk.flush();
        emul.flush();

        assertEquals(jdk.size(), emul.size());

        final java.io.DataInputStream jdkInput = newJdk(jdkBytesOutput);
        final DataInputStream emulInput = newEmul(emulBytesOutput);

        for (final String value : values) {
            assertEquals(value, jdkInput.readUTF());
            assertEquals(value, emulInput.readUTF());
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
    public Class<DataOutputStream> type() {
        return DataOutputStream.class;
    }
}
