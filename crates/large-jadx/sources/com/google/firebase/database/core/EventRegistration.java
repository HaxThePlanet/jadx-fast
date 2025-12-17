package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.DataEvent;
import com.google.firebase.database.core.view.Event.EventType;
import com.google.firebase.database.core.view.QuerySpec;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public abstract class EventRegistration {

    private boolean isUserInitiated = false;
    private com.google.firebase.database.core.EventRegistrationZombieListener listener;
    private AtomicBoolean zombied;
    public EventRegistration() {
        super();
        AtomicBoolean atomicBoolean = new AtomicBoolean(0);
        this.zombied = atomicBoolean;
    }

    public abstract com.google.firebase.database.core.EventRegistration clone(QuerySpec querySpec);

    public abstract DataEvent createEvent(Change change, QuerySpec querySpec2);

    public abstract void fireCancelEvent(DatabaseError databaseError);

    public abstract void fireEvent(DataEvent dataEvent);

    public abstract QuerySpec getQuerySpec();

    com.google.firebase.database.core.Repo getRepo() {
        return null;
    }

    public abstract boolean isSameListener(com.google.firebase.database.core.EventRegistration eventRegistration);

    public boolean isUserInitiated() {
        return this.isUserInitiated;
    }

    public boolean isZombied() {
        return this.zombied.get();
    }

    public abstract boolean respondsTo(Event.EventType event$EventType);

    public void setIsUserInitiated(boolean z) {
        this.isUserInitiated = z;
    }

    public void setOnZombied(com.google.firebase.database.core.EventRegistrationZombieListener eventRegistrationZombieListener) {
        int i;
        Utilities.hardAssert(zombied ^= i);
        if (this.listener == null) {
        } else {
            i = 0;
        }
        Utilities.hardAssert(i);
        this.listener = eventRegistrationZombieListener;
    }

    public void zombify() {
        boolean compareAndSet;
        compareAndSet = this.listener;
        if (this.zombied.compareAndSet(false, true) && compareAndSet != null) {
            compareAndSet = this.listener;
            if (compareAndSet != null) {
                compareAndSet.onZombied(this);
                this.listener = 0;
            }
        }
    }
}
