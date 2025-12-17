package com.google.firebase.database.core.view;

import com.google.firebase.database.core.Path;

/* loaded from: classes2.dex */
public interface Event {

    public static enum EventType {

        CHILD_REMOVED,
        CHILD_ADDED,
        CHILD_MOVED,
        CHILD_CHANGED,
        VALUE;
    }
    public abstract void fire();

    public abstract Path getPath();

    public abstract String toString();
}
