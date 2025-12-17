package com.google.firebase.events;

import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public interface Subscriber {
    public abstract <T> void subscribe(Class<T> class, com.google.firebase.events.EventHandler<? super T> eventHandler2);

    public abstract <T> void subscribe(Class<T> class, Executor executor2, com.google.firebase.events.EventHandler<? super T> eventHandler3);

    public abstract <T> void unsubscribe(Class<T> class, com.google.firebase.events.EventHandler<? super T> eventHandler2);
}
