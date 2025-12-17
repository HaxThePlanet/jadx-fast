package com.appsflyer.internal;

/* loaded from: classes.dex */
public final class bz extends com.appsflyer.internal.i {
    public bz() {
        final int i = 0;
        super(i, i, Boolean.FALSE, i);
    }

    @Override // com.appsflyer.internal.i
    public final com.appsflyer.internal.i values(String string) {
        return super.values(AFInAppEventType(string));
    }
}
