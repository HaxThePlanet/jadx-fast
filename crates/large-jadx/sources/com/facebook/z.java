package com.facebook;

import android.os.Handler;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0010%\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0008\u0003\n\u0002\u0010\u0012\n\u0002\u0008\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u0016J\u0012\u0010\u0017\u001a\u00020\u00122\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J \u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J\u0010\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u000bH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000c\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\t0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e", d2 = {"Lcom/facebook/ProgressNoopOutputStream;", "Ljava/io/OutputStream;", "Lcom/facebook/RequestOutputStream;", "callbackHandler", "Landroid/os/Handler;", "(Landroid/os/Handler;)V", "currentRequest", "Lcom/facebook/GraphRequest;", "currentRequestProgress", "Lcom/facebook/RequestProgress;", "<set-?>", "", "maxProgress", "getMaxProgress", "()I", "progressMap", "", "addProgress", "", "size", "", "getProgressMap", "", "setCurrentRequest", "write", "buffer", "", "offset", "length", "oneByte", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class z extends OutputStream implements com.facebook.b0 {

    private final Map<com.facebook.p, com.facebook.c0> a;
    private com.facebook.p b;
    private com.facebook.c0 c;
    private int v;
    private final Handler w;
    public z(Handler handler) {
        super();
        this.w = handler;
        HashMap obj1 = new HashMap();
        this.a = obj1;
    }

    @Override // java.io.OutputStream
    public void a(com.facebook.p p) {
        Map map;
        Object obj2;
        this.b = p;
        if (p != null) {
            obj2 = this.a.get(p);
        } else {
            obj2 = 0;
        }
        this.c = obj2;
    }

    @Override // java.io.OutputStream
    public final void c(long l) {
        com.facebook.p pVar;
        com.facebook.c0 c0Var;
        Map map;
        long obj4;
        pVar = this.b;
        if (pVar != null && this.c == null) {
            if (this.c == null) {
                c0Var = new c0(this.w, pVar);
                this.c = c0Var;
                this.a.put(pVar, c0Var);
            }
            com.facebook.c0 c0Var2 = this.c;
            if (c0Var2 != null) {
                c0Var2.b(l);
            }
            this.v = i += obj4;
        }
    }

    @Override // java.io.OutputStream
    public final int e() {
        return this.v;
    }

    public final Map<com.facebook.p, com.facebook.c0> f() {
        return this.a;
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        c(1);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr) {
        n.f(bArr, "buffer");
        c((long)obj3);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i2, int i3) {
        final String obj2 = "buffer";
        n.f(bArr, obj2);
        c((long)i3);
    }
}
