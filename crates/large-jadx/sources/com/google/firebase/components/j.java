package com.google.firebase.components;

import com.google.firebase.events.Event;
import java.util.Map.Entry;

/* loaded from: classes2.dex */
public final class j implements Runnable {

    public final Map.Entry a;
    public final Event b;
    public j(Map.Entry map$Entry, Event event2) {
        super();
        this.a = entry;
        this.b = event2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        EventBus.a(this.a, this.b);
    }
}
