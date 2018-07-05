/*
 * This file is part of text, licensed under the MIT License.
 *
 * Copyright (c) 2017-2018 KyoriPowered
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package net.kyori.text.format;

import com.google.common.base.Enums;
import com.google.gson.annotations.SerializedName;
import net.kyori.text.Component;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * An enumeration of decorations which may be applied to a {@link Component}.
 */
public enum TextDecoration implements TextFormat {
    /**
     * A decoration which makes text obfuscated/unreadable.
     */
    @SerializedName("obfuscated")
    OBFUSCATED('k'),
    /**
     * A decoration which makes text appear bold.
     */
    @SerializedName("bold")
    BOLD('l'),
    /**
     * A decoration which makes text have a strike through it.
     */
    @SerializedName("strikethrough")
    STRIKETHROUGH('m'),
    /**
     * A decoration which makes text have an underline.
     */
    @SerializedName("underline")
    UNDERLINE('n'),
    /**
     * A decoration which makes text appear in italics.
     */
    @SerializedName("italic")
    ITALIC('o');

    /**
     * The serialized name of this decoration.
     */
    private final @NonNull String toString = Enums.getField(this).getAnnotation(SerializedName.class).value();
    /**
     * The legacy code.
     */
    @Deprecated
    private final char legacy;

    TextDecoration(final char legacy) {
        this.legacy = legacy;
    }

    @Deprecated
    @Override
    public char legacy() {
        return this.legacy;
    }

    @Override
    public @NonNull String toString() {
        return this.toString;
    }

    /**
     * A state that a {@link TextDecoration} can be in.
     */
    public enum State {
        NOT_SET {
            @Override
            public String toString() {
                return "null";
            }
        },
        FALSE,
        TRUE;

        @Override
        public String toString() {
            return this.name().toLowerCase();
        }

        /**
         * Gets a state from a {@code boolean}.
         *
         * @param flag the boolean
         * @return the state
         */
        public static @NonNull State byBoolean(final boolean flag) {
            return flag ? TRUE : FALSE;
        }

        /**
         * Gets a state from a {@code Boolean}.
         *
         * @param flag the boolean
         * @return the state
         */
        public static @NonNull State byBoolean(final @Nullable Boolean flag) {
            return flag == null ? NOT_SET : byBoolean(flag.booleanValue());
        }
    }
}
