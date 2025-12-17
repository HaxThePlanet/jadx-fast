package com.google.firebase.inappmessaging.internal;

import i.b.z;

/* loaded from: classes2.dex */
public class Schedulers {

    private final z computeScheduler;
    private final z ioScheduler;
    private final z mainThreadScheduler;
    Schedulers(z z, z z2, z z3) {
        super();
        this.ioScheduler = z;
        this.computeScheduler = z2;
        this.mainThreadScheduler = z3;
    }

    public z computation() {
        return this.computeScheduler;
    }

    public z io() {
        return this.ioScheduler;
    }

    public z mainThread() {
        return this.mainThreadScheduler;
    }
}
