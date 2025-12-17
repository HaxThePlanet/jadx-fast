package com.revenuecat.purchases.utils;

import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\u0008\u0004\u0008\u0010\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001b\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\u0008\u0007\u0010\u0008¨\u0006\t", d2 = {"Lcom/revenuecat/purchases/utils/SerializationException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "", "message", "", "cause", "<init>", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "utils_release"}, k = 1, mv = {1, 4, 0})
public class SerializationException extends RuntimeException {
    public SerializationException(String string, Throwable throwable2) {
        n.f(string, "message");
        super(string, throwable2);
    }

    public SerializationException(String string, Throwable throwable2, int i3, g g4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(string, obj2);
    }
}
