package com.facebook;

import android.os.Handler;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.y.i;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u0008\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\t\u0018\u0000 <2\u0008\u0012\u0004\u0012\u00020\u00020\u0001:\u0003;<=B\u0007\u0008\u0016¢\u0006\u0002\u0010\u0003B\u0015\u0008\u0016\u0012\u000c\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001b\u0008\u0016\u0012\u0012\u0010\u0004\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00020\u0007\"\u00020\u0002¢\u0006\u0002\u0010\u0008B\u000f\u0008\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0002\u0010\tJ\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0002H\u0016J\u0018\u0010(\u001a\u00020+2\u0006\u0010,\u001a\u00020 2\u0006\u0010*\u001a\u00020\u0002H\u0016J\u000e\u0010-\u001a\u00020+2\u0006\u0010.\u001a\u00020\u0018J\u0008\u0010/\u001a\u00020+H\u0016J\u000c\u00100\u001a\u0008\u0012\u0004\u0012\u00020201J\u000e\u00103\u001a\u0008\u0012\u0004\u0012\u00020201H\u0002J\u0006\u00104\u001a\u000205J\u0008\u00106\u001a\u000205H\u0002J\u0011\u00107\u001a\u00020\u00022\u0006\u0010,\u001a\u00020 H\u0096\u0002J\u0010\u00108\u001a\u00020\u00022\u0006\u0010,\u001a\u00020 H\u0016J\u000e\u00109\u001a\u00020+2\u0006\u0010.\u001a\u00020\u0018J\u0019\u0010:\u001a\u00020\u00022\u0006\u0010,\u001a\u00020 2\u0006\u0010*\u001a\u00020\u0002H\u0096\u0002R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\r\"\u0004\u0008\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0012\u0010\u0013\"\u0004\u0008\u0014\u0010\u0015R*\u0010\u0019\u001a\u0008\u0012\u0004\u0012\u00020\u00180\u00172\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00180\u0017@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u0011\u0010\u001c\u001a\u00020\u000b¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001d\u0010\rR*\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u00172\u000c\u0010\u0016\u001a\u0008\u0012\u0004\u0012\u00020\u00020\u0017@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001e\u0010\u001bR\u0014\u0010\u001f\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008!\u0010\"R$\u0010$\u001a\u00020 2\u0006\u0010#\u001a\u00020 8F@FX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008%\u0010\"\"\u0004\u0008&\u0010'R\u000e\u0010#\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006>", d2 = {"Lcom/facebook/GraphRequestBatch;", "Ljava/util/AbstractList;", "Lcom/facebook/GraphRequest;", "()V", "requests", "", "(Ljava/util/Collection;)V", "", "([Lcom/facebook/GraphRequest;)V", "(Lcom/facebook/GraphRequestBatch;)V", "batchApplicationId", "", "getBatchApplicationId", "()Ljava/lang/String;", "setBatchApplicationId", "(Ljava/lang/String;)V", "callbackHandler", "Landroid/os/Handler;", "getCallbackHandler", "()Landroid/os/Handler;", "setCallbackHandler", "(Landroid/os/Handler;)V", "<set-?>", "", "Lcom/facebook/GraphRequestBatch$Callback;", "callbacks", "getCallbacks", "()Ljava/util/List;", "id", "getId", "getRequests", "size", "", "getSize", "()I", "timeoutInMilliseconds", "timeout", "getTimeout", "setTimeout", "(I)V", "add", "", "element", "", "index", "addCallback", "callback", "clear", "executeAndWait", "", "Lcom/facebook/GraphResponse;", "executeAndWaitImpl", "executeAsync", "Lcom/facebook/GraphRequestAsyncTask;", "executeAsyncImpl", "get", "removeAt", "removeCallback", "set", "Callback", "Companion", "OnProgressCallback", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class r extends AbstractList<com.facebook.p> {

    private static final AtomicInteger y;
    private Handler a;
    private int b;
    private final String c;
    private List<com.facebook.p> v;
    private List<com.facebook.r.a> w;
    private String x;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008æ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006", d2 = {"Lcom/facebook/GraphRequestBatch$Callback;", "", "onBatchCompleted", "", "batch", "Lcom/facebook/GraphRequestBatch;", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface a {
        public abstract void a(com.facebook.r r);
    }

    @Metadata(d1 = "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\u0008f\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0007H&¨\u0006\t", d2 = {"Lcom/facebook/GraphRequestBatch$OnProgressCallback;", "Lcom/facebook/GraphRequestBatch$Callback;", "onBatchProgress", "", "batch", "Lcom/facebook/GraphRequestBatch;", "current", "", "max", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public interface b extends com.facebook.r.a {
        @Override // com.facebook.r$a
        public abstract void b(com.facebook.r r, long l2, long l3);
    }
    static {
        AtomicInteger atomicInteger = new AtomicInteger();
        r.y = atomicInteger;
    }

    public r(Collection<com.facebook.p> collection) {
        n.f(collection, "requests");
        super();
        this.c = String.valueOf(r.y.incrementAndGet());
        ArrayList arrayList = new ArrayList();
        this.w = arrayList;
        ArrayList arrayList2 = new ArrayList(collection);
        this.v = arrayList2;
    }

    public r(com.facebook.p... pArr) {
        n.f(pArr, "requests");
        super();
        this.c = String.valueOf(r.y.incrementAndGet());
        ArrayList arrayList = new ArrayList();
        this.w = arrayList;
        ArrayList arrayList2 = new ArrayList(i.d(pArr));
        this.v = arrayList2;
    }

    private final List<com.facebook.s> l() {
        return p.t.g(this);
    }

    private final com.facebook.q p() {
        return p.t.j(this);
    }

    @Override // java.util.AbstractList
    public int A(com.facebook.p p) {
        return super.indexOf(p);
    }

    @Override // java.util.AbstractList
    public int B(com.facebook.p p) {
        return super.lastIndexOf(p);
    }

    @Override // java.util.AbstractList
    public boolean C(com.facebook.p p) {
        return super.remove(p);
    }

    @Override // java.util.AbstractList
    public com.facebook.p D(int i) {
        return (p)this.v.remove(i);
    }

    @Override // java.util.AbstractList
    public com.facebook.p E(int i, com.facebook.p p2) {
        n.f(p2, "element");
        return (p)this.v.set(i, p2);
    }

    @Override // java.util.AbstractList
    public final void G(Handler handler) {
        this.a = handler;
    }

    @Override // java.util.AbstractList
    public void add(int i, Object object2) {
        b(i, (p)object2);
    }

    @Override // java.util.AbstractList
    public boolean add(Object object) {
        return d((p)object);
    }

    @Override // java.util.AbstractList
    public void b(int i, com.facebook.p p2) {
        n.f(p2, "element");
        this.v.add(i, p2);
    }

    @Override // java.util.AbstractList
    public void clear() {
        this.v.clear();
    }

    @Override // java.util.AbstractList
    public final boolean contains(Object object) {
        boolean z;
        z = object != null ? object instanceof p : 1;
        if (z) {
            return h((p)object);
        }
        return 0;
    }

    @Override // java.util.AbstractList
    public boolean d(com.facebook.p p) {
        n.f(p, "element");
        return this.v.add(p);
    }

    @Override // java.util.AbstractList
    public final void g(com.facebook.r.a r$a) {
        boolean contains;
        n.f(a, "callback");
        if (!this.w.contains(a)) {
            this.w.add(a);
        }
    }

    @Override // java.util.AbstractList
    public Object get(int i) {
        return q(i);
    }

    @Override // java.util.AbstractList
    public boolean h(com.facebook.p p) {
        return super.contains(p);
    }

    public final List<com.facebook.s> i() {
        return l();
    }

    @Override // java.util.AbstractList
    public final int indexOf(Object object) {
        boolean z;
        z = object != null ? object instanceof p : 1;
        if (z) {
            return A((p)object);
        }
        return -1;
    }

    @Override // java.util.AbstractList
    public final int lastIndexOf(Object object) {
        boolean z;
        z = object != null ? object instanceof p : 1;
        if (z) {
            return B((p)object);
        }
        return -1;
    }

    @Override // java.util.AbstractList
    public final com.facebook.q m() {
        return p();
    }

    @Override // java.util.AbstractList
    public com.facebook.p q(int i) {
        return (p)this.v.get(i);
    }

    @Override // java.util.AbstractList
    public Object remove(int i) {
        return D(i);
    }

    @Override // java.util.AbstractList
    public final boolean remove(Object object) {
        boolean z;
        z = object != null ? object instanceof p : 1;
        if (z) {
            return C((p)object);
        }
        return 0;
    }

    @Override // java.util.AbstractList
    public final String s() {
        return this.x;
    }

    @Override // java.util.AbstractList
    public Object set(int i, Object object2) {
        return E(i, (p)object2);
    }

    @Override // java.util.AbstractList
    public final int size() {
        return y();
    }

    @Override // java.util.AbstractList
    public final Handler t() {
        return this.a;
    }

    public final List<com.facebook.r.a> u() {
        return this.w;
    }

    @Override // java.util.AbstractList
    public final String v() {
        return this.c;
    }

    public final List<com.facebook.p> w() {
        return this.v;
    }

    @Override // java.util.AbstractList
    public int y() {
        return this.v.size();
    }

    @Override // java.util.AbstractList
    public final int z() {
        return this.b;
    }
}
