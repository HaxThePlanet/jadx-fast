package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.InternalHelpers;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.core.view.Change;
import com.google.firebase.database.core.view.DataEvent;
import com.google.firebase.database.core.view.Event.EventType;
import com.google.firebase.database.core.view.QuerySpec;

/* loaded from: classes2.dex */
public class ValueEventRegistration extends com.google.firebase.database.core.EventRegistration {

    private final ValueEventListener eventListener;
    private final com.google.firebase.database.core.Repo repo;
    private final QuerySpec spec;
    public ValueEventRegistration(com.google.firebase.database.core.Repo repo, ValueEventListener valueEventListener2, QuerySpec querySpec3) {
        super();
        this.repo = repo;
        this.eventListener = valueEventListener2;
        this.spec = querySpec3;
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public com.google.firebase.database.core.EventRegistration clone(QuerySpec querySpec) {
        ValueEventRegistration valueEventRegistration = new ValueEventRegistration(this.repo, this.eventListener, querySpec);
        return valueEventRegistration;
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public DataEvent createEvent(Change change, QuerySpec querySpec2) {
        DataEvent obj4 = new DataEvent(Event.EventType.VALUE, this, InternalHelpers.createDataSnapshot(InternalHelpers.createReference(this.repo, querySpec2.getPath()), change.getIndexedNode()), 0);
        return obj4;
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public boolean equals(Object object) {
        boolean equals;
        Object eventListener;
        Object obj3;
        if (object instanceof ValueEventRegistration && object.eventListener.equals(this.eventListener) && object.repo.equals(this.repo) && object.spec.equals(this.spec)) {
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
        if (isZombied()) {
        }
        this.eventListener.onDataChange(dataEvent.getSnapshot());
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
        if (eventRegistration instanceof ValueEventRegistration && eventRegistration.eventListener.equals(this.eventListener)) {
            obj2 = eventRegistration.eventListener.equals(this.eventListener) ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public boolean respondsTo(Event.EventType event$EventType) {
        int obj2;
        obj2 = eventType == Event.EventType.VALUE ? 1 : 0;
        return obj2;
    }

    @Override // com.google.firebase.database.core.EventRegistration
    public String toString() {
        return "ValueEventRegistration";
    }
}
