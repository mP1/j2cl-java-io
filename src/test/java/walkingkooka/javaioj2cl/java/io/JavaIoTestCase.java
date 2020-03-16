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

package walkingkooka.javaioj2cl.java.io;

import org.junit.jupiter.api.Test;
import walkingkooka.reflect.ClassTesting2;
import walkingkooka.reflect.J2clShadedClassTesting;
import walkingkooka.reflect.JavaVisibility;

import java.io.IOException;

public abstract class JavaIoTestCase<T> implements ClassTesting2<T>, J2clShadedClassTesting {

    JavaIoTestCase() {
        super();
    }

    @Test
    public final void testFieldDeclarations() throws IOException {
        this.fieldDeclarationsCheck(this.type(), this.jdkType());
    }

    @Test
    public final void testMethodSignatures() throws IOException {
        this.methodSignaturesCheck(this.type(), this.jdkType());
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.of(this.jdkType());
    }

    abstract Class<?> jdkType();
}
