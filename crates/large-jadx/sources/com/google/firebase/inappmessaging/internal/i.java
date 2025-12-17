package com.google.firebase.inappmessaging.internal;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;

/* loaded from: classes2.dex */
public final class i implements EventHandler {

    public final com.google.firebase.inappmessaging.internal.DataCollectionHelper a;
    public i(com.google.firebase.inappmessaging.internal.DataCollectionHelper dataCollectionHelper) {
        super();
        this.a = dataCollectionHelper;
    }

    @Override // com.google.firebase.events.EventHandler
    public final void handle(Event event) {
        this.a.b(event);
    }
}
