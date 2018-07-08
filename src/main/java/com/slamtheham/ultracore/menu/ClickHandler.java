package com.slamtheham.ultracore.menu;

import me.blackness.black.Target;
import me.blackness.black.event.ElementBasicEvent;
import me.blackness.black.event.ElementClickEvent;
import me.blackness.black.event.ElementDragEvent;
import me.blackness.black.target.BasicTarget;

public interface ClickHandler {

    default Target[] get() {
        return new Target[] {};
    }
}
