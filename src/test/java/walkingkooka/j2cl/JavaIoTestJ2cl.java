/*
 * Copyright 2020 Miroslav Pokorny (github.com/mP1)
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

package walkingkooka.j2cl;

import com.google.j2cl.junit.apt.J2clTestInput;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

import static org.junit.Assert.assertEquals;

@J2clTestInput(JavaIoTestJ2cl.class)
public class JavaIoTestJ2cl {
    @Test
    public void testJreJavaTimeLocalDateTimeWasShaded() throws Exception {
        try (final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            try (final DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream)) {
                dataOutputStream.writeBoolean(true);
                dataOutputStream.writeByte(1);
                dataOutputStream.writeInt(2);
                dataOutputStream.writeDouble(3.5);
                dataOutputStream.writeUTF("abc456");

                dataOutputStream.flush();

                try (final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray())) {
                    try (final DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream)) {
                        assertEquals("boolean", true, dataInputStream.readBoolean());
                        assertEquals("byte", (byte) 1, dataInputStream.readByte());
                        assertEquals("int", 2, dataInputStream.readInt());
                        assertEquals("double", 3.5, dataInputStream.readDouble(), 0.1);
                        assertEquals("UTF", "abc456", dataInputStream.readUTF());
                    }
                }
            }
        }
    }
}
