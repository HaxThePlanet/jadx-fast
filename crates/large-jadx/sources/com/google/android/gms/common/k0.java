package com.google.android.gms.common;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
final class k0 extends com.google.android.gms.common.l0 {

    private final Callable<String> e;
    k0(Callable callable, com.google.android.gms.common.j0 j02) {
        final int i = 0;
        super(0, i, i);
        this.e = callable;
    }

    @Override // com.google.android.gms.common.l0
    final String a() {
        try {
            return (String)this.e.call();
            RuntimeException runtimeException = new RuntimeException(th);
            throw runtimeException;
        }
    }
}
