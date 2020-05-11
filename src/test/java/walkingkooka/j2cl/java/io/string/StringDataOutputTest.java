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

package walkingkooka.j2cl.java.io.string;

import org.junit.jupiter.api.Test;
import walkingkooka.ToStringTesting;
import walkingkooka.reflect.ClassTesting2;
import walkingkooka.reflect.JavaVisibility;

import java.io.IOException;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public final class StringDataOutputTest implements ClassTesting2<StringDataOutput>, ToStringTesting<StringDataOutput> {

    @Test
    public void testNullConsumerFails() {
        assertThrows(NullPointerException.class, () -> StringDataOutput.with(null));
    }

    @Test
    public void testWriteBoolean() {
        this.writeAndCheck((sdo) -> sdo.writeBoolean(false), "0");
    }

    @Test
    public void testWriteBoolean2() {
        this.writeAndCheck((sdo) -> sdo.writeBoolean(true), "1");
    }

    @Test
    public void testWriteSeveralBooleans() {
        this.writeAndCheck((sdo) -> {
            sdo.writeBoolean(true);
            sdo.writeBoolean(false);
            sdo.writeBoolean(true);
        }, "101");
    }

    @Test
    public void testWriteByte() {
        this.writeAndCheck((sdo) -> sdo.writeByte((byte) 0), "0");
    }

    @Test
    public void testWriteByte2() {
        this.writeAndCheck((sdo) -> sdo.writeByte((byte) 255), "-1");
    }

    @Test
    public void testWriteByte3() {
        this.writeAndCheck((sdo) -> sdo.writeByte((byte) 1), "1");
    }

    @Test
    public void testWriteSeveralBytes() {
        this.writeAndCheck((sdo) -> {
            sdo.writeByte((byte) 1);
            sdo.writeByte((byte) 2);
            sdo.writeByte((byte) 34);
        }, "1,2,34");
    }

    @Test
    public void testWriteShort() {
        this.writeAndCheck((sdo) -> sdo.writeShort((short) 0), "0");
    }

    @Test
    public void testWriteShort2() {
        this.writeAndCheck((sdo) -> sdo.writeShort((short) 123), "123");
    }

    @Test
    public void testWriteShort3() {
        this.writeAndCheck((sdo) -> sdo.writeShort((short) 1), "1");
    }

    @Test
    public void testWriteSeveralShorts() {
        this.writeAndCheck((sdo) -> {
            sdo.writeShort((short) 1);
            sdo.writeShort((short) 2);
            sdo.writeShort((short) 34);
        }, "1,2,34");
    }

    @Test
    public void testWriteInt() {
        this.writeAndCheck((sdo) -> sdo.writeInt((int) 0), "0");
    }

    @Test
    public void testWriteInt2() {
        this.writeAndCheck((sdo) -> sdo.writeInt(-2), "-2");
    }

    @Test
    public void testWriteInt3() {
        this.writeAndCheck((sdo) -> sdo.writeInt(1), "1");
    }

    @Test
    public void testWriteSeveralInts() {
        this.writeAndCheck((sdo) -> {
            sdo.writeInt(1);
            sdo.writeInt(2);
            sdo.writeInt(34);
        }, "1,2,34");
    }

    @Test
    public void testWriteLong() {
        this.writeAndCheck((sdo) -> sdo.writeLong(0), "0");
    }

    @Test
    public void testWriteLong2() {
        this.writeAndCheck((sdo) -> sdo.writeLong(-2), "-2");
    }

    @Test
    public void testWriteLong3() {
        this.writeAndCheck((sdo) -> sdo.writeLong(1), "1");
    }

    @Test
    public void testWriteSeveralLongs() {
        this.writeAndCheck((sdo) -> {
            sdo.writeLong(1L);
            sdo.writeLong(2L);
            sdo.writeLong(34L);
        }, "1,2,34");
    }

    @Test
    public void testWriteFloat() {
        this.writeAndCheck((sdo) -> sdo.writeFloat(1.25f), "1.25");
    }

    @Test
    public void testWriteSeveralFloats() {
        this.writeAndCheck((sdo) -> {
            sdo.writeFloat(1);
            sdo.writeFloat(2);
            sdo.writeFloat(34.5f);
        }, "1,2,34.5");
    }

    @Test
    public void testWriteDouble() {
        this.writeAndCheck((sdo) -> sdo.writeDouble(1.25), "1.25");
    }

    @Test
    public void testWriteSeveralDoubles() {
        this.writeAndCheck((sdo) -> {
            sdo.writeDouble(1);
            sdo.writeDouble(2);
            sdo.writeDouble(34.5);
        }, "1,2,34.5");
    }

    @Test
    public void testWriteChar() {
        this.writeAndCheck((sdo) -> sdo.writeChar('A'), "A");
    }

    @Test
    public void testWriteCharBackslash() {
        this.writeAndCheck((sdo) -> sdo.writeChar('\\'), "\\");
    }

    @Test
    public void testWriteCharComma() {
        this.writeAndCheck((sdo) -> sdo.writeChar(','), ",");
    }

    @Test
    public void testWriteCharTab() {
        this.writeAndCheck((sdo) -> sdo.writeChar('\t'), "\t");
    }

    @Test
    public void testWriteSeveralChars() {
        this.writeAndCheck((sdo) -> {
            sdo.writeChar('A');
            sdo.writeChar('B');
            sdo.writeChar('C');
        }, "ABC");
    }

    @Test
    public void testWriteAllChars() throws IOException {
        final StringBuilder b = new StringBuilder();
        final StringDataOutput out = StringDataOutput.with(b::append);
        final StringBuilder expected = new StringBuilder();

        for (int i = 0; i <= 127; i++) {
            final char c = (char) i;
            out.writeChar(c);
            expected.append(c);
        }

        assertEquals(expected.toString(), b.toString());
    }

    private final static String STRING = "abc123";

    @Test
    public void testWriteBytes() {
        this.writeAndCheck((sdo) -> sdo.writeBytes(STRING), STRING);
    }

    @Test
    public void testWriteChars() {
        this.writeAndCheck((sdo) -> sdo.writeChars(STRING), STRING);
    }

    @Test
    public void testWriteUTFNullFails() {
        assertThrows(NullPointerException.class, () -> StringDataOutput.with((s) -> {
            throw new UnsupportedOperationException();
        }).writeUTF(null));
    }

    @Test
    public void testWriteUTF() {
        this.writeAndCheck((sdo) -> sdo.writeUTF(STRING), STRING);
    }

    @Test
    public void testWriteSeveralUTF() {
        this.writeAndCheck((sdo) -> {
            sdo.writeUTF("A");
            sdo.writeUTF("B");
            sdo.writeUTF("C");
        }, "A,B,C");
    }

    @Test
    public void testWriteSeveralUTF2() {
        this.writeAndCheck((sdo) -> {
            sdo.writeUTF("A");
            sdo.writeUTF("\\");
            sdo.writeUTF("C");
        }, "A,\\\\,C");
    }

    @Test
    public void testWriteSeveralUTF3() {
        this.writeAndCheck((sdo) -> {
            sdo.writeUTF("A");
            sdo.writeUTF(",");
            sdo.writeUTF("C");
        }, "A,\\,,C");
    }

    @Test
    public void testWriteBooleanString() {
        this.writeAndCheck((sdo) -> {
            sdo.writeBoolean(true);
            sdo.writeBoolean(false);
            sdo.writeUTF("abc");
        }, "10abc");
    }

    @Test
    public void testWriteCharString() {
        this.writeAndCheck((sdo) -> {
            sdo.writeChar('A');
            sdo.writeChar('B');
            sdo.writeUTF("xyz");
        }, "ABxyz");
    }

    private void writeAndCheck(final Consumer<StringDataOutput> dataOutput, final String expected) {
        final StringBuilder text = new StringBuilder();
        final StringDataOutput stringDataOutput = StringDataOutput.with(text::append);
        dataOutput.accept(stringDataOutput);
        assertEquals(expected, text.toString());
    }

    @Test
    public void testToString() {
        final Consumer<String> out = (s) -> {
        };
        this.toStringAndCheck(StringDataOutput.with(out), out.toString());
    }


    // ClassTesting2....................................................................................................

    @Override
    public Class<StringDataOutput> type() {
        return StringDataOutput.class;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PACKAGE_PRIVATE;
    }
}
