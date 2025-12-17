package com.google.common.util.concurrent;

import java.util.concurrent.locks.LockSupport;

/* loaded from: classes2.dex */
final class e {
    static void a(Object object, long l2) {
        LockSupport.parkNanos(object, Math.min(l2, obj4));
    }
}
