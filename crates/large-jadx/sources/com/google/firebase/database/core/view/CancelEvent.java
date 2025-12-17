package com.google.firebase.database.core.view;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.core.EventRegistration;
import com.google.firebase.database.core.Path;

/* loaded from: classes2.dex */
public class CancelEvent implements com.google.firebase.database.core.view.Event {

    private final DatabaseError error;
    private final EventRegistration eventRegistration;
    private final Path path;
    public CancelEvent(EventRegistration eventRegistration, DatabaseError databaseError2, Path path3) {
        super();
        this.eventRegistration = eventRegistration;
        this.path = path3;
        this.error = databaseError2;
    }

    @Override // com.google.firebase.database.core.view.Event
    public void fire() {
        this.eventRegistration.fireCancelEvent(this.error);
    }

    @Override // com.google.firebase.database.core.view.Event
    public Path getPath() {
        return this.path;
    }

    @Override // com.google.firebase.database.core.view.Event
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getPath());
        stringBuilder.append(":CANCEL");
        return stringBuilder.toString();
    }
}
