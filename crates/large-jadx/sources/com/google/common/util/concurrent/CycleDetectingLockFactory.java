package com.google.common.util.concurrent;

import com.google.common.collect.d0;
import com.google.common.collect.e0;
import com.google.common.collect.z;
import java.util.ArrayList;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public class CycleDetectingLockFactory {

    private static final Logger a;

    class a extends java.lang.ThreadLocal<ArrayList<com.google.common.util.concurrent.CycleDetectingLockFactory.c>> {
        protected ArrayList<com.google.common.util.concurrent.CycleDetectingLockFactory.c> a() {
            return d0.k(3);
        }

        @Override // java.lang.ThreadLocal
        protected Object initialValue() {
            return a();
        }
    }

    private static class b extends java.lang.IllegalStateException {
        static {
            z.A(CycleDetectingLockFactory.class.getName(), CycleDetectingLockFactory.b.class.getName(), CycleDetectingLockFactory.c.class.getName());
        }
    }

    private static class c {
    }

    public static final class PotentialDeadlockException extends com.google.common.util.concurrent.CycleDetectingLockFactory.b {

        private final com.google.common.util.concurrent.CycleDetectingLockFactory.b conflictingStackTrace;
        @Override // com.google.common.util.concurrent.CycleDetectingLockFactory$b
        public String getMessage() {
            com.google.common.util.concurrent.CycleDetectingLockFactory.b conflictingStackTrace;
            String message;
            StringBuilder stringBuilder = new StringBuilder(super.getMessage());
            conflictingStackTrace = this.conflictingStackTrace;
            while (conflictingStackTrace != null) {
                stringBuilder.append(", ");
                stringBuilder.append(conflictingStackTrace.getMessage());
                conflictingStackTrace = conflictingStackTrace.getCause();
            }
            return stringBuilder.toString();
        }
    }
    static {
        e0 e0Var = new e0();
        e0Var.l();
        e0Var.i();
        CycleDetectingLockFactory.a = Logger.getLogger(CycleDetectingLockFactory.class.getName());
        CycleDetectingLockFactory.a aVar = new CycleDetectingLockFactory.a();
    }
}
