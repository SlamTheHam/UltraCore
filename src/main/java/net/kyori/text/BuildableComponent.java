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
package net.kyori.text;

import net.kyori.text.event.ClickEvent;
import net.kyori.text.event.HoverEvent;
import net.kyori.text.format.TextColor;
import net.kyori.text.format.TextDecoration;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * A component which may be built.
 *
 * @param <C> the component type
 * @param <B> the builder type
 */
public interface BuildableComponent<C extends BuildableComponent<C, B>, B extends BuildableComponent.Builder<C, B>> extends Component {
    /**
     * Create a builder from this component.
     *
     * @return the builder
     */
    @NonNull B toBuilder();

    /**
     * A component builder.
     *
     * @param <C> the component type
     * @param <B> the builder type
     */
    interface Builder<C extends BuildableComponent, B extends Builder<C, B>> {
        /**
         * Appends a component to this component.
         *
         * @param component the component to append
         * @return this builder
         */
        @NonNull B append(final @NonNull Component component);

        /**
         * Appends components to this component.
         *
         * @param components the components to append
         * @return this builder
         */
        @NonNull B append(final @NonNull Iterable<? extends Component> components);

        /**
         * Applies an action to this builder.
         *
         * @param consumer the action
         * @return this builder
         */
        default @NonNull B apply(final @NonNull Consumer<Builder<?, ?>> consumer) {
            consumer.accept(this);
            return (B) this;
        }

        /**
         * Applies an action to this component and all child components if they are
         * an instance of {@link BuildableComponent}.
         *
         * @param action the action
         * @return this builder
         */
        @NonNull B applyDeep(final @NonNull Consumer<Builder<?, ?>> action);

        /**
         * Replaces each child of this component with the resultant component from the function.
         *
         * @param function the mapping function
         * @return this builder
         */
        @NonNull B mapChildren(final @NonNull Function<BuildableComponent<?, ?>, BuildableComponent<?, ?>> function);

        /**
         * Replaces each child and sub-child of this component with the resultant
         * component of the function.
         *
         * @param function the mapping function
         * @return this builder
         */
        @NonNull B mapChildrenDeep(final @NonNull Function<BuildableComponent<?, ?>, BuildableComponent<?, ?>> function);

        /**
         * Sets the color of this component.
         *
         * @param color the color
         * @return this builder
         */
        @NonNull B color(final @Nullable TextColor color);

        /**
         * Sets the color of this component if there isn't one set already.
         *
         * @param color the color
         * @return this builder
         */
        @NonNull B colorIfAbsent(final @Nullable TextColor color);

        /**
         * Sets the state of a set of decorations to {@code flag} on this component.
         *
         * @param decorations the decorations
         * @param flag        {@code true} if this component should have the decorations, {@code false} if
         *                    this component should not have the decorations
         * @return this builder
         */
        default @NonNull B decorations(final @NonNull Set<TextDecoration> decorations, final boolean flag) {
            final TextDecoration.State state = TextDecoration.State.byBoolean(flag);
            decorations.forEach(decoration -> this.decoration(decoration, state));
            return (B) this;
        }

        /**
         * Sets the state of a decoration on this component.
         *
         * @param decoration the decoration
         * @param flag       {@code true} if this component should have the decoration, {@code false} if
         *                   this component should not have the decoration
         * @return this builder
         */
        default @NonNull B decoration(final @NonNull TextDecoration decoration, final boolean flag) {
            return this.decoration(decoration, TextDecoration.State.byBoolean(flag));
        }

        /**
         * Sets the value of a decoration on this component.
         *
         * @param decoration the decoration
         * @param state      {@link TextDecoration.State#TRUE} if this component should have the
         *                   decoration, {@link TextDecoration.State#FALSE} if this component should not
         *                   have the decoration, and {@link TextDecoration.State#NOT_SET} if the decoration
         *                   should not have a set value
         * @return this builder
         */
        @NonNull B decoration(final @NonNull TextDecoration decoration, final TextDecoration.@NonNull State state);

        /**
         * Sets the click event of this component.
         *
         * @param event the click event
         * @return this builder
         */
        @NonNull B clickEvent(final @Nullable ClickEvent event);

        /**
         * Sets the hover event of this component.
         *
         * @param event the hover event
         * @return this builder
         */
        @NonNull B hoverEvent(final @Nullable HoverEvent event);

        /**
         * Sets the string to be inserted when this component is shift-clicked.
         *
         * @param insertion the insertion string
         * @return this builder
         */
        @NonNull B insertion(final @Nullable String insertion);

        /**
         * Merges styling from another component into this component.
         *
         * @param that the other component
         * @return this builder
         */
        default @NonNull B mergeStyle(final @NonNull Component that) {
            this.mergeColor(that);
            this.mergeDecorations(that);
            this.mergeEvents(that);
            return (B) this;
        }

        /**
         * Merges the color from another component into this component.
         *
         * @param that the other component
         * @return this builder
         */
        default @NonNull B mergeColor(final @NonNull Component that) {
            if (that.color() != null) this.color(that.color());
            return (B) this;
        }

        /**
         * Merges the decorations from another component into this component.
         *
         * @param that the other component
         * @return this builder
         */
        default @NonNull B mergeDecorations(final @NonNull Component that) {
            for (final TextDecoration decoration : TextDecoration.values()) {
                final TextDecoration.State state = that.decoration(decoration);
                if (state != TextDecoration.State.NOT_SET) this.decoration(decoration, state);
            }
            return (B) this;
        }

        /**
         * Merges the events from another component into this component.
         *
         * @param that the other component
         * @return this builder
         */
        default @NonNull B mergeEvents(final @NonNull Component that) {
            if (that.clickEvent() != null) this.clickEvent(that.clickEvent());
            if (that.hoverEvent() != null)
                this.hoverEvent(that.hoverEvent().copy()); // hard copy, hover events have a component
            return (B) this;
        }

        /**
         * Resets all styling on this component.
         *
         * @return this builder
         */
        default @NonNull B resetStyle() {
            this.color(null);
            for (final TextDecoration decoration : TextDecoration.values())
                this.decoration(decoration, TextDecoration.State.NOT_SET);
            this.clickEvent(null);
            this.hoverEvent(null);
            return (B) this;
        }

        /**
         * Build a component.
         *
         * @return the component
         */
        @NonNull C build();
    }
}
