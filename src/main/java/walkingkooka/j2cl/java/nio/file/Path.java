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

package walkingkooka.j2cl.java.nio.file;

import java.util.Objects;

public final class Path {

    public static Path of(final String path) {
        Objects.requireNonNull(path, "path");

        return new Path(path);
    }

    private Path(final String path) {
        super();
        this.path = path;
    }

    // Object...........................................................................................................

    @Override
    public int hashCode() {
        return this.path.hashCode();
    }

    @Override
    public boolean equals(final Object other) {
        return this == other ||
                (other instanceof Path && this.equals0((Path) other));
    }

    private boolean equals0(final Path other) {
        return this.path.equals(other.path);
    }

    @Override
    public String toString() {
        return this.path;
    }

    private final String path;
}
