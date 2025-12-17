package com.google.firebase.events;

import com.google.firebase.components.Preconditions;

/* loaded from: classes2.dex */
public class Event<T>  {

    private final T payload;
    private final Class<T> type;
    public Event(Class<T> class, T t2) {
        super();
        this.type = (Class)Preconditions.checkNotNull(class);
        this.payload = Preconditions.checkNotNull(t2);
    }

    public T getPayload() {
        return this.payload;
    }

    public Class<T> getType() {
        return this.type;
    }

    public String toString() {
        Object[] arr = new Object[2];
        return String.format("Event{type: %s, payload: %s}", this.type, this.payload);
    }
}
