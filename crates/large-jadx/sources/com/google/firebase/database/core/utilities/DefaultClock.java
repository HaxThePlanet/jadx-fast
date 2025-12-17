package com.google.firebase.database.core.utilities;

/* loaded from: classes2.dex */
public class DefaultClock implements com.google.firebase.database.core.utilities.Clock {
    @Override // com.google.firebase.database.core.utilities.Clock
    public long millis() {
        return System.currentTimeMillis();
    }
}
