package com.google.android.gms.common.util.q;

import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.r;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
public class a implements ThreadFactory {

    private final String a;
    private final ThreadFactory b;
    public a(String string) {
        super();
        this.b = Executors.defaultThreadFactory();
        r.k(string, "Name must not be null");
        this.a = string;
    }

    public final Thread newThread(Runnable runnable) {
        b bVar = new b(runnable, 0);
        final Thread obj4 = this.b.newThread(bVar);
        obj4.setName(this.a);
        return obj4;
    }
}
