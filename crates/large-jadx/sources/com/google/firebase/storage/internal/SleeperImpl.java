package com.google.firebase.storage.internal;

/* loaded from: classes2.dex */
public class SleeperImpl implements com.google.firebase.storage.internal.Sleeper {
    @Override // com.google.firebase.storage.internal.Sleeper
    public void sleep(int i) {
        Thread.sleep((long)i);
    }
}
