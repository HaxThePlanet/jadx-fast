package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.common.api.c;
import com.google.android.gms.tasks.j;
import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public abstract class xh<T extends com.google.android.gms.internal.firebase-auth-api.uh>  {

    private com.google.android.gms.internal.firebase-auth-api.th<T> a;
    public final <ResultT, A extends com.google.android.gms.common.api.a.b> j<ResultT> a(com.google.android.gms.internal.firebase-auth-api.wh<A, ResultT> wh) {
        return thVar.a.doRead(wh.zza());
    }

    public final <ResultT, A extends com.google.android.gms.common.api.a.b> j<ResultT> b(com.google.android.gms.internal.firebase-auth-api.wh<A, ResultT> wh) {
        return thVar.a.doWrite(wh.zza());
    }

    public final com.google.android.gms.internal.firebase-auth-api.th<T> c() {
        Object thVar;
        synchronized (this) {
            try {
                this.a = (th)d().get();
                String str = "There was an error while initializing the connection to the GoogleApi: ";
                Throwable th = th.getMessage();
                th = String.valueOf(th);
            } catch (Exception e) {
            } catch (Throwable th1) {
            }
            return this.a;
        }
    }

    abstract Future<com.google.android.gms.internal.firebase-auth-api.th<T>> d();
}
