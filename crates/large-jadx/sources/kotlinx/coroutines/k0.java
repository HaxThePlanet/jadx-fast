package kotlinx.coroutines;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.b0.a;
import kotlin.b0.g;
import kotlin.b0.g.c;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.w;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0008\u0080\u0008\u0018\u0000 \u00182\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\u0018B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\t\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\u000c2\u0008\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u0008\u0010\u0016\u001a\u00020\u0002H\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0019", d2 = {"Lkotlinx/coroutines/CoroutineId;", "Lkotlinx/coroutines/ThreadContextElement;", "", "Lkotlin/coroutines/AbstractCoroutineContextElement;", "id", "", "(J)V", "getId", "()J", "component1", "copy", "equals", "", "other", "", "hashCode", "", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "toString", "updateThreadContext", "Key", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class k0 extends a implements kotlinx.coroutines.t2<String> {

    public static final kotlinx.coroutines.k0.a b;
    private final long a;

    @Metadata(d1 = "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004", d2 = {"Lkotlinx/coroutines/CoroutineId$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/CoroutineId;", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a implements g.c<kotlinx.coroutines.k0> {
        public a(g g) {
            super();
        }
    }
    static {
        k0.a aVar = new k0.a(0);
        k0.b = aVar;
    }

    public k0(long l) {
        super(k0.b);
        this.a = l;
    }

    @Override // kotlin.b0.a
    public void E(g g, Object object2) {
        L(g, (String)object2);
    }

    @Override // kotlin.b0.a
    public Object H(g g) {
        return M(g);
    }

    @Override // kotlin.b0.a
    public final long K() {
        return this.a;
    }

    @Override // kotlin.b0.a
    public void L(g g, String string2) {
        Thread.currentThread().setName(string2);
    }

    @Override // kotlin.b0.a
    public String M(g g) {
        String str;
        int length;
        Object obj9;
        obj9 = g.get(l0.b);
        str = "coroutine";
        if ((l0)obj9 == null) {
        } else {
            obj9 = (l0)obj9.K();
            if (obj9 == null) {
            } else {
                str = obj9;
            }
        }
        obj9 = Thread.currentThread();
        final String name = obj9.getName();
        if (l.j0(name, " @", 0, false, 6, 0) < 0) {
            length = name.length();
        }
        StringBuilder stringBuilder = new StringBuilder(i2 += 10);
        Objects.requireNonNull(name, "null cannot be cast to non-null type java.lang.String");
        String substring = name.substring(0, length);
        n.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        stringBuilder.append(substring);
        String str3 = " @";
        stringBuilder.append(str3);
        stringBuilder.append(str);
        stringBuilder.append('#');
        stringBuilder.append(K());
        w wVar = w.a;
        String string = stringBuilder.toString();
        n.e(string, "StringBuilder(capacity).…builderAction).toString()");
        obj9.setName(string);
        return name;
    }

    @Override // kotlin.b0.a
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof k0) {
            return i2;
        }
        if (Long.compare(l, l2) != 0) {
            return i2;
        }
        return i;
    }

    @Override // kotlin.b0.a
    public int hashCode() {
        return Long.hashCode(this.a);
    }

    @Override // kotlin.b0.a
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CoroutineId(");
        stringBuilder.append(this.a);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
