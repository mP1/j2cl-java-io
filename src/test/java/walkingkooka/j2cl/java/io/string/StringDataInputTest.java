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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public final class StringDataInputTest implements ClassTesting2<StringDataInput>, ToStringTesting<StringDataInput> {

    @Test
    public void testNullSourceFails() {
        assertThrows(NullPointerException.class, () -> StringDataInput.with(null));
    }

    @Test
    public void testReadBoolean() throws IOException {
        this.checkEquals(false, StringDataInput.with("0").readBoolean());
    }

    @Test
    public void testReadBoolean2() throws IOException {
        this.checkEquals(true, StringDataInput.with("1").readBoolean());
    }

    @Test
    public void testReadByte() throws IOException {
        this.checkEquals((byte) 0, StringDataInput.with("00").readByte());
    }

    @Test
    public void testReadByte2() throws IOException {
        this.checkEquals((byte) 1, StringDataInput.with("01").readByte());
    }

    @Test
    public void testReadByte3() throws IOException {
        this.checkEquals((byte) -1, StringDataInput.with("-1").readByte());
    }

    @Test
    public void testReadSeveralBytes() throws IOException {
        final StringDataInput data = StringDataInput.with("1,2,3");
        this.checkEquals((byte) 1, data.readByte());
        this.checkEquals((byte) 2, data.readByte());
        this.checkEquals((byte) 3, data.readByte());
    }

    @Test
    public void testReadUnsignedByte() throws IOException {
        this.checkEquals((byte) 0, (byte) StringDataInput.with("00").readUnsignedByte());
    }

    @Test
    public void testReadUnsignedByte2() throws IOException {
        this.checkEquals((byte) 1, (byte) StringDataInput.with("1").readUnsignedByte());
    }

    @Test
    public void testReadUnsignedByte3() throws IOException {
        this.checkEquals(0xff, StringDataInput.with("255").readUnsignedByte());
    }

    @Test
    public void testReadSeveralUnsignedBytes() throws IOException {
        final StringDataInput data = StringDataInput.with("1,2,3");
        this.checkEquals(1, data.readUnsignedByte());
        this.checkEquals(2, data.readUnsignedByte());
        this.checkEquals(3, data.readUnsignedByte());
    }

    @Test
    public void testReadUnsignedByteFails() {
        assertThrows(IOException.class, () -> StringDataInput.with("-1").readUnsignedByte());
    }

    @Test
    public void testReadUnsignedByteFails2() {
        assertThrows(IOException.class, () -> StringDataInput.with("256").readUnsignedByte());
    }

    @Test
    public void testReadShort() throws IOException {
        this.checkEquals((short) 0, StringDataInput.with("0").readShort());
    }

    @Test
    public void testReadShort2() throws IOException {
        this.checkEquals((short) 1, StringDataInput.with("1").readShort());
    }

    @Test
    public void testReadShort3() throws IOException {
        this.checkEquals((short) 123, StringDataInput.with("123").readShort());
    }

    @Test
    public void testReadSeveralShorts() throws IOException {
        final StringDataInput data = StringDataInput.with("1,2,3");
        this.checkEquals((short) 1, data.readShort());
        this.checkEquals((short) 2, data.readShort());
        this.checkEquals((short) 3, data.readShort());
    }

    @Test
    public void testReadUnsignedShortFails() {
        assertThrows(IOException.class, () -> StringDataInput.with("-1").readUnsignedShort());
    }

    @Test
    public void testReadUnsignedShortFails2() {
        assertThrows(IOException.class, () -> StringDataInput.with("65537").readUnsignedShort());
    }

    @Test
    public void testReadUnsignedShort() throws IOException {
        this.checkEquals(0, StringDataInput.with("0").readUnsignedShort());
    }

    @Test
    public void testReadUnsignedShort2() throws IOException {
        this.checkEquals(1, StringDataInput.with("1").readUnsignedShort());
    }

    @Test
    public void testReadUnsignedShort3() throws IOException {
        this.checkEquals(0xffff, StringDataInput.with("" + 0xffff).readUnsignedShort());
    }

    @Test
    public void testReadSeveralUnsignedShort() throws IOException {
        final StringDataInput data = StringDataInput.with("1,2,3");
        this.checkEquals(1, data.readUnsignedByte());
        this.checkEquals(2, data.readUnsignedByte());
        this.checkEquals(3, data.readUnsignedByte());
    }

    @Test
    public void testReadInt() throws IOException {
        this.checkEquals((int) 0, StringDataInput.with("0").readInt());
    }

    @Test
    public void testReadInt2() throws IOException {
        this.checkEquals(1, StringDataInput.with("00000001").readInt());
    }

    @Test
    public void testReadInt3() throws IOException {
        this.checkEquals(123, StringDataInput.with("123").readInt());
    }

    @Test
    public void testReadSeveralInts() throws IOException {
        final StringDataInput data = StringDataInput.with("1,2,3");
        this.checkEquals(1, data.readInt());
        this.checkEquals(2, data.readInt());
        this.checkEquals(3, data.readInt());
    }

    @Test
    public void testReadLong() throws IOException {
        this.checkEquals(0L, StringDataInput.with("0").readLong());
    }

    @Test
    public void testReadLong2() throws IOException {
        this.checkEquals(1L, StringDataInput.with("1").readLong());
    }

    @Test
    public void testReadLong3() throws IOException {
        this.checkEquals((long) 123, StringDataInput.with("123").readLong());
    }

    @Test
    public void testReadSeveralLongs() throws IOException {
        final StringDataInput data = StringDataInput.with("1,2,3");
        this.checkEquals(1L, data.readLong());
        this.checkEquals(2L, data.readLong());
        this.checkEquals(3L, data.readLong());
    }

    @Test
    public void testReadFloat() throws IOException {
        assertEquals(.125f, StringDataInput.with("0.125").readFloat(), 0.1f);
    }

    @Test
    public void testReadSeveralFloats() throws IOException {
        final StringDataInput data = StringDataInput.with("1,2,3.5");
        assertEquals(1f, data.readFloat(), 0.1f);
        assertEquals(2f, data.readFloat(), 0.1f);
        assertEquals(3.5f, data.readFloat(), 0.1f);
    }

    @Test
    public void testReadDouble() throws IOException {
        assertEquals(.125, StringDataInput.with("0.125").readDouble(), 0.1);
    }

    @Test
    public void testReadSeveralDoubles() throws IOException {
        final StringDataInput data = StringDataInput.with("1,2,3.5");
        assertEquals(1, data.readDouble(), 0.1);
        assertEquals(2, data.readDouble(), 0.1);
        assertEquals(3.5, data.readDouble(), 0.1);
    }

    @Test
    public void testReadChar() throws IOException {
        this.checkEquals('A', StringDataInput.with("A").readChar());
    }

    @Test
    public void testReadSeveralChars() throws IOException {
        final StringDataInput data = StringDataInput.with("ab,");
        this.checkEquals('a', data.readChar());
        this.checkEquals('b', data.readChar());
        this.checkEquals(',', data.readChar());
    }

    @Test
    public void testReadUTFEmpty() throws IOException {
        this.checkEquals("", StringDataInput.with("").readUTF());
    }

    @Test
    public void testReadUTF() throws IOException {
        this.checkEquals("A", StringDataInput.with("A").readUTF());
    }

    @Test
    public void testReadUTF2() throws IOException {
        this.checkEquals("ABC123", StringDataInput.with("ABC123").readUTF());
    }

    @Test
    public void testReadUTFWithEscaped() throws IOException {
        this.checkEquals("ABC,123", StringDataInput.with("ABC\\,123").readUTF());
    }

    @Test
    public void testReadSeveralUTFs() throws IOException {
        final StringDataInput data = StringDataInput.with("a,,bcd\\,efg");
        this.checkEquals("a", data.readUTF());
        this.checkEquals("", data.readUTF());
        this.checkEquals("bcd,efg", data.readUTF());
    }

    @Test
    public void testToString() {
        final String source = "abc123";
        this.toStringAndCheck(StringDataInput.with(source), source);
    }

    @Test
    public void testToStringAfterReads() throws Exception {
        final String source = "11abc123";
        final StringDataInput data = StringDataInput.with(source);
        data.readBoolean();
        data.readBoolean();
        this.toStringAndCheck(data, "abc123");
    }

    @Test
    public void testToStringWhenEmpty() throws Exception {
        final String source = "11";
        final StringDataInput data = StringDataInput.with(source);
        data.readBoolean();
        data.readBoolean();
        this.toStringAndCheck(data, "");
    }

    // ClassTesting2....................................................................................................

    @Override
    public Class<StringDataInput> type() {
        return StringDataInput.class;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.PACKAGE_PRIVATE;
    }
}
