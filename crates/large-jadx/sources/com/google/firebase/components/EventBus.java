package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
class EventBus implements Subscriber, Publisher {

    private final Executor defaultExecutor;
    private final Map<Class<?>, ConcurrentHashMap<EventHandler<Object>, Executor>> handlerMap;
    private Queue<Event<?>> pendingEvents;
    EventBus(Executor executor) {
        super();
        HashMap hashMap = new HashMap();
        this.handlerMap = hashMap;
        ArrayDeque arrayDeque = new ArrayDeque();
        this.pendingEvents = arrayDeque;
        this.defaultExecutor = executor;
    }

    static void a(Map.Entry map$Entry, Event event2) {
        (EventHandler)entry.getKey().handle(event2);
    }

    private Set<Map.Entry<EventHandler<Object>, Executor>> getHandlers(Event<?> event) {
        Set obj2;
        obj2 = this.handlerMap.get(event.getType());
        synchronized (this) {
            try {
                obj2 = Collections.emptySet();
                obj2 = (Map)obj2.entrySet();
                return obj2;
                throw event;
            }
        }
    }

    @Override // com.google.firebase.events.Subscriber
    void enablePublishingAndFlushPending() {
        int pendingEvents;
        int next;
        next = 0;
        synchronized (this) {
            try {
                this.pendingEvents = next;
                pendingEvents = next;
                if (pendingEvents != 0) {
                }
                pendingEvents = pendingEvents.iterator();
                for (Event next : pendingEvents) {
                    publish(next);
                }
                publish((Event)pendingEvents.next());
                throw th;
            }
        }
    }

    public void publish(Event<?> event) {
        Object next;
        Object value;
        com.google.firebase.components.j jVar;
        Preconditions.checkNotNull(event);
        Queue pendingEvents = this.pendingEvents;
        synchronized (this) {
            pendingEvents.add(event);
        }
        for (Map.Entry next : iterator) {
            jVar = new j(next, event);
            (Executor)next.getValue().execute(jVar);
        }
    }

    public <T> void subscribe(Class<T> class, EventHandler<? super T> eventHandler2) {
        subscribe(class, this.defaultExecutor, eventHandler2);
    }

    public <T> void subscribe(Class<T> class, Executor executor2, EventHandler<? super T> eventHandler3) {
        boolean handlerMap;
        ConcurrentHashMap concurrentHashMap;
        Preconditions.checkNotNull(class);
        Preconditions.checkNotNull(eventHandler3);
        Preconditions.checkNotNull(executor2);
        synchronized (this) {
            try {
                concurrentHashMap = new ConcurrentHashMap();
                this.handlerMap.put(class, concurrentHashMap);
                (ConcurrentHashMap)this.handlerMap.get(class).put(eventHandler3, executor2);
                throw class;
            }
        }
    }

    public <T> void unsubscribe(Class<T> class, EventHandler<? super T> eventHandler2) {
        boolean obj3;
        Preconditions.checkNotNull(class);
        Preconditions.checkNotNull(eventHandler2);
        synchronized (this) {
            try {
                Object obj = this.handlerMap.get(class);
                (ConcurrentHashMap)obj.remove(eventHandler2);
                if (obj.isEmpty()) {
                }
                this.handlerMap.remove(class);
                throw class;
            }
        }
    }
}
