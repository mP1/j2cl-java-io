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

import walkingkooka.reflect.ClassTesting2;
import walkingkooka.reflect.JavaVisibility;

public class UTFDataFormatExceptionTest implements ClassTesting2<UTFDataFormatException> {

    @Override
    public void testAllConstructorsVisibility() {
    }

    @Override
    public Class<UTFDataFormatException> type() {
        return UTFDataFormatException.class;
    }

    @Override
    public JavaVisibility typeVisibility() {
        return JavaVisibility.of(java.io.UTFDataFormatException.class);
    }
}
