package com.google.firebase.database.core;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.InternalHelpers;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.DataEvent;
import com.google.firebase.database.core.view.Event.EventType;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.snapshot.ChildKey;

/* loaded from: classes2.dex */
public class ChildEventRegistration extends com.google.firebase.database.core.EventRegistration {

    private final ChildEventListener eventListener;
    private final com.google.firebase.database.core.Repo repo;
    private final QuerySpec spec;
    public ChildEventRegistration(com.google.firebase.database.core.Repo repo, ChildEventListener childEventListener2, QuerySpec querySpec3) {
        super();
        this.repo = repo;
        this.eventListener = childEventListener2;
        this.spec = querySpec3;
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public com.google.firebase.database.core.EventRegistration clone(QuerySpec querySpec) {
        ChildEventRegistration childEventRegistration = new ChildEventRegistration(this.repo, this.eventListener, querySpec);
        return childEventRegistration;
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public DataEvent createEvent(Change change, QuerySpec querySpec2) {
        String string;
        if (change.getPrevName() != null) {
            string = change.getPrevName().asString();
        } else {
            string = 0;
        }
        DataEvent dataEvent = new DataEvent(change.getEventType(), this, InternalHelpers.createDataSnapshot(InternalHelpers.createReference(this.repo, querySpec2.getPath().child(change.getChildKey())), change.getIndexedNode()), string);
        return dataEvent;
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public boolean equals(Object object) {
        boolean equals;
        Object eventListener;
        Object obj3;
        if (object instanceof ChildEventRegistration && object.eventListener.equals(this.eventListener) && object.repo.equals(this.repo) && object.spec.equals(this.spec)) {
            if (object.eventListener.equals(this.eventListener)) {
                if (object.repo.equals(this.repo)) {
                    obj3 = object.spec.equals(this.spec) ? 1 : 0;
                } else {
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public void fireCancelEvent(DatabaseError databaseError) {
        this.eventListener.onCancelled(databaseError);
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public void fireEvent(DataEvent dataEvent) {
        ChildEventListener eventListener;
        com.google.firebase.database.DataSnapshot snapshot;
        Object obj3;
        if (isZombied()) {
        }
        eventListener = ChildEventRegistration.1.$SwitchMap$com$google$firebase$database$core$view$Event$EventType[dataEvent.getEventType().ordinal()];
        if (eventListener != 1) {
            if (eventListener != 2) {
                if (eventListener != 3) {
                    if (eventListener != 4) {
                    } else {
                        this.eventListener.onChildRemoved(dataEvent.getSnapshot());
                    }
                } else {
                    this.eventListener.onChildMoved(dataEvent.getSnapshot(), dataEvent.getPreviousName());
                }
            } else {
                this.eventListener.onChildChanged(dataEvent.getSnapshot(), dataEvent.getPreviousName());
            }
        } else {
            this.eventListener.onChildAdded(dataEvent.getSnapshot(), dataEvent.getPreviousName());
        }
    }

    public QuerySpec getQuerySpec() {
        return this.spec;
    }

    @Override // com.google.firebase.database.core.EventRegistration
    com.google.firebase.database.core.Repo getRepo() {
        return this.repo;
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public int hashCode() {
        return i4 += i7;
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public boolean isSameListener(com.google.firebase.database.core.EventRegistration eventRegistration) {
        boolean eventListener;
        Object obj2;
        if (eventRegistration instanceof ChildEventRegistration && eventRegistration.eventListener.equals(this.eventListener)) {
            obj2 = eventRegistration.eventListener.equals(this.eventListener) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public boolean respondsTo(Event.EventType event$EventType) {
        int obj2;
        obj2 = eventType != Event.EventType.VALUE ? 1 : 0;
        return obj2;
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public String toString() {
        return "ChildEventRegistration";
    }
}
