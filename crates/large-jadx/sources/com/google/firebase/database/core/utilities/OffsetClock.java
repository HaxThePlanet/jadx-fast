package com.google.firebase.database.core.utilities;

/* loaded from: classes2.dex */
public class OffsetClock implements com.google.firebase.database.core.utilities.Clock {

    private final com.google.firebase.database.core.utilities.Clock baseClock;
    private long offset = 0;
    public OffsetClock(com.google.firebase.database.core.utilities.Clock clock, long l2) {
        super();
        final int i = 0;
        this.baseClock = clock;
        this.offset = l2;
    }

    @Override // com.google.firebase.database.core.utilities.Clock
    public long millis() {
        return millis += offset;
    }

    @Override // com.google.firebase.database.core.utilities.Clock
    public void setOffset(long l) {
        this.offset = l;
    }
}
