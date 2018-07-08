package com.slamtheham.ultracore.menu;

import me.blackness.black.event.ElementBasicEvent;
import me.blackness.black.event.ElementClickEvent;
import me.blackness.black.event.ElementDragEvent;

public interface ClickHandler {

    default void runBasic(ElementBasicEvent event) {
    }

    default void runClick(ElementClickEvent event) {
    }

    default void runDrag(ElementDragEvent event) {
    }

}
