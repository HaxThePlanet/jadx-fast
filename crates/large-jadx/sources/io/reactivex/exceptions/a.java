package io.reactivex.exceptions;

import i.b.m0.j.k;

/* loaded from: classes3.dex */
public final class a {
    public static RuntimeException a(Throwable throwable) {
        throw k.e(throwable);
    }

    public static void b(Throwable throwable) {
        if (throwable instanceof VirtualMachineError != null) {
        } else {
            if (throwable instanceof ThreadDeath) {
            } else {
                if (throwable instanceof LinkageError != null) {
                } else {
                }
                throw (LinkageError)throwable;
            }
            throw (ThreadDeath)throwable;
        }
        throw (VirtualMachineError)throwable;
    }
}
