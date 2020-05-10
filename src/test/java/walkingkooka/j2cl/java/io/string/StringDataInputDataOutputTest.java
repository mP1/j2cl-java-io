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
import walkingkooka.collect.list.Lists;
import walkingkooka.reflect.JavaVisibility;
import walkingkooka.reflect.PublicStaticHelperTesting;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public final class StringDataInputDataOutputTest implements PublicStaticHelperTesting<StringDataInputDataOutput> {

    @Test
    public void testWriteByteReadByte() throws IOException {
        final StringBuilder b = new StringBuilder();
        final StringDataOutput out = StringDataOutput.with(b::append);
        final List<Byte> written = Lists.array();

        for (int i = Byte.MIN_VALUE; i <= Byte.MAX_VALUE; i++) {
            final byte v = (byte) i;
            out.writeByte(v);
            written.add(v);
        }

        final List<Byte> read = Lists.array();
        final StringDataInput input = StringDataInput.with(b.toString());

        for (int i = Byte.MIN_VALUE; i <= Byte.MAX_VALUE; i++) {
            read.add(input.readByte());
        }

        assertEquals(written, read);
    }

    @Test
    public void testWriteShortReadShort() throws IOException {
        final StringBuilder b = new StringBuilder();
        final StringDataOutput out = StringDataOutput.with(b::append);
        final List<Short> written = Lists.array();

        for (int i = Short.MIN_VALUE; i <= Short.MAX_VALUE; i++) {
            final short v = (short) i;
            out.writeShort(v);
            written.add(v);
        }

        final List<Short> read = Lists.array();
        final StringDataInput input = StringDataInput.with(b.toString());

        for (int i = Short.MIN_VALUE; i <= Short.MAX_VALUE; i++) {
            read.add(input.readShort());
        }

        assertEquals(written, read);
    }

    @Test
    public void testWriteIntReadInt() throws IOException {
        final StringBuilder b = new StringBuilder();
        final StringDataOutput out = StringDataOutput.with(b::append);
        final List<Integer> written = Lists.array();

        for (long i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i+= Short.MAX_VALUE) {
            final int v = (int)i;
            out.writeInt(v);
            written.add(v);
        }

        final List<Integer> read = Lists.array();
        final StringDataInput input = StringDataInput.with(b.toString());

        for (long i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i+= Short.MAX_VALUE) {
            read.add(input.readInt());
        }

        assertEquals(written, read);
    }

    @Test
    public void testWriteCharReadChar() throws IOException {
        final StringBuilder b = new StringBuilder();
        final StringDataOutput out = StringDataOutput.with(b::append);
        final List<Character> written = Lists.array();

        for (int i = Character.MIN_VALUE; i <= Character.MAX_VALUE; i++) {
            final char v = (char) i;
            out.writeChar(v);
            written.add(v);
        }

        final List<Character> read = Lists.array();
        final StringDataInput input = StringDataInput.with(b.toString());

        for (int i = Character.MIN_VALUE; i <= Character.MAX_VALUE; i++) {
            read.add(input.readChar());
        }

        assertEquals(written, read);
    }

    @Test
    public void testWriteStringReadString() throws IOException {
        final StringBuilder b = new StringBuilder();
        final StringDataOutput out = StringDataOutput.with(b::append);
        final List<String> written = Lists.array();

        for (int i = 'a'; i <= 'z'; i++) {
            final String s = Character.valueOf((char) i).toString();
            out.writeUTF(s);
            written.add(s);
        }

        final List<String> read = Lists.array();
        final StringDataInput input = StringDataInput.with(b.toString());

        for (int i = 'a'; i <= 'z'; i++) {
            read.add(input.readUTF());
        }

        assertEquals(written.toString(), read.toString());
    }

    @Test
    public void testWriteStringReadString2() throws IOException {
        final StringBuilder b = new StringBuilder();
        final StringDataOutput out = StringDataOutput.with(b::append);
        final List<String> written = Lists.array();

        for (int i = Character.MIN_VALUE; i <= 'z'; i++) {
            final String s = Character.valueOf((char) i).toString();
            out.writeUTF(s);
            written.add(s);
        }

        final List<String> read = Lists.array();
        final StringDataInput input = StringDataInput.with(b.toString());

        for (int i = Character.MIN_VALUE; i <= 'z'; i++) {
            read.add(input.readUTF());
        }

        assertEquals(written.toString(), read.toString());
    }

    @Test
    public void testWriteBooleanCharIntStringRountrip() throws IOException {
        final StringBuilder b = new StringBuilder();
        final StringDataOutput out = StringDataOutput.with(b::append);

        for(int i = 0; i < 3; i++) {
            out.writeBoolean(true);
            out.writeChar('A');
            out.writeInt(123);
            out.writeUTF("XYZ");
        }

        final StringDataInput input = StringDataInput.with(b.toString());

        for(int i = 0; i < 3; i++) {
            assertEquals(true, input.readBoolean());
            assertEquals('A', input.readChar());
            assertEquals(123, input.readInt());
            assertEquals("XYZ", input.readUTF());
        }
    }

    @Override
    public Class<StringDataInputDataOutput> type() {
        return StringDataInputDataOutput.class;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PUBLIC;
    }

    @Override
    public boolean canHavePublicTypes(final Method method) {
        return false;
    }
}
