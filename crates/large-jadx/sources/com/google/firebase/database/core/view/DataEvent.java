package com.google.firebase.database.core.view;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.Query;
import com.google.firebase.database.core.EventRegistration;
import com.google.firebase.database.core.Path;

/* loaded from: classes2.dex */
public class DataEvent implements com.google.firebase.database.core.view.Event {

    private final EventRegistration eventRegistration;
    private final com.google.firebase.database.core.view.Event.EventType eventType;
    private final String prevName;
    private final DataSnapshot snapshot;
    public DataEvent(com.google.firebase.database.core.view.Event.EventType event$EventType, EventRegistration eventRegistration2, DataSnapshot dataSnapshot3, String string4) {
        super();
        this.eventType = eventType;
        this.eventRegistration = eventRegistration2;
        this.snapshot = dataSnapshot3;
        this.prevName = string4;
    }

    @Override // com.google.firebase.database.core.view.Event
    public void fire() {
        this.eventRegistration.fireEvent(this);
    }

    @Override // com.google.firebase.database.core.view.Event
    public com.google.firebase.database.core.view.Event.EventType getEventType() {
        return this.eventType;
    }

    @Override // com.google.firebase.database.core.view.Event
    public Path getPath() {
        Path path = this.snapshot.getRef().getPath();
        if (this.eventType == Event.EventType.VALUE) {
            return path;
        }
        return path.getParent();
    }

    @Override // com.google.firebase.database.core.view.Event
    public String getPreviousName() {
        return this.prevName;
    }

    @Override // com.google.firebase.database.core.view.Event
    public DataSnapshot getSnapshot() {
        return this.snapshot;
    }

    @Override // com.google.firebase.database.core.view.Event
    public String toString() {
        final int i = 1;
        final String str3 = ": ";
        if (this.eventType == Event.EventType.VALUE) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getPath());
            stringBuilder.append(str3);
            stringBuilder.append(this.eventType);
            stringBuilder.append(str3);
            stringBuilder.append(this.snapshot.getValue(i));
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(getPath());
        stringBuilder2.append(str3);
        stringBuilder2.append(this.eventType);
        stringBuilder2.append(": { ");
        stringBuilder2.append(this.snapshot.getKey());
        stringBuilder2.append(str3);
        stringBuilder2.append(this.snapshot.getValue(i));
        stringBuilder2.append(" }");
        return stringBuilder2.toString();
    }
}
