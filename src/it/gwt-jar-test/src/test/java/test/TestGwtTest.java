package test;

import com.google.gwt.junit.client.GWTTestCase;

import walkingkooka.j2cl.java.io.string.StringDataInputDataOutput;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;

public class TestGwtTest extends GWTTestCase {

    @Override
    public String getModuleName() {
        return "test.Test";
    }

    public void testAssertEquals() {
        assertEquals(
                1,
                1
        );
    }

    public void testStringDataOutputStringDataInput() throws Exception {
        final StringBuilder written = new StringBuilder();

        final DataOutput out = StringDataInputDataOutput.output(written::append);
        out.writeBoolean(true);
        out.writeInt(5);
        out.writeDouble(6.75);
        out.writeUTF("abc,123");

        final DataInput in = StringDataInputDataOutput.input(written.toString());

        assertEquals("readBoolean", true, in.readBoolean());
        assertEquals("readInt", 5, in.readInt());
        assertEquals("readDouble", 6.75, in.readDouble(), 0.1);
        assertEquals("readUTF", "abc,123", in.readUTF());
    }

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
                    assertEquals(booleanValue, dataInput.readBoolean());

                    assertEquals(byteValue, dataInput.readByte());

                    assertEquals(charValue, dataInput.readChar());

                    assertEquals("readDouble", doubleValue, dataInput.readDouble(), 0.1);
                    assertEquals("readFloat", floatValue, dataInput.readFloat(), 0.1f);

                    assertEquals("readInt", intValue, dataInput.readInt());
                    assertEquals("readLong", longValue, dataInput.readLong());
                    assertEquals("readShort", shortValue, dataInput.readShort());

                    assertEquals("readUTF", string, dataInput.readUTF());
                }
            }
        }
    }
}
