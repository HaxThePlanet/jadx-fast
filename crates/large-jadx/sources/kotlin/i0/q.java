package kotlin.i0;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000c\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0008\u0010\u0013\u001a\u00020\u0014H\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u0016", d2 = {"Lkotlin/reflect/KTypeProjection;", "", "variance", "Lkotlin/reflect/KVariance;", "type", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)V", "getType", "()Lkotlin/reflect/KType;", "getVariance", "()Lkotlin/reflect/KVariance;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class q {

    public static final kotlin.i0.q c;
    public static final kotlin.i0.q.a d;
    private final kotlin.i0.s a;
    private final kotlin.i0.o b;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u000c\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\u0008\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0000X\u0081\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0008\u0010\u0002¨\u0006\u000e", d2 = {"Lkotlin/reflect/KTypeProjection$Companion;", "", "()V", "STAR", "Lkotlin/reflect/KTypeProjection;", "getSTAR", "()Lkotlin/reflect/KTypeProjection;", "star", "getStar$annotations", "contravariant", "type", "Lkotlin/reflect/KType;", "covariant", "invariant", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public final kotlin.i0.q a(kotlin.i0.o o) {
            n.f(o, "type");
            q qVar = new q(s.IN, o);
            return qVar;
        }

        public final kotlin.i0.q b(kotlin.i0.o o) {
            n.f(o, "type");
            q qVar = new q(s.OUT, o);
            return qVar;
        }

        public final kotlin.i0.q c() {
            return q.c;
        }

        public final kotlin.i0.q d(kotlin.i0.o o) {
            n.f(o, "type");
            q qVar = new q(s.INVARIANT, o);
            return qVar;
        }
    }
    static {
        final int i = 0;
        q.a aVar = new q.a(i);
        q.d = aVar;
        q qVar = new q(i, i);
        q.c = qVar;
    }

    public q(kotlin.i0.s s, kotlin.i0.o o2) {
        int str;
        int i;
        String obj4;
        int obj5;
        super();
        this.a = s;
        this.b = o2;
        str = 1;
        final int i2 = 0;
        i = s == null ? str : i2;
        obj5 = o2 == null ? str : i2;
        if (i == obj5) {
        } else {
            str = i2;
        }
        if (str == null) {
            if (s == null) {
                obj4 = "Star projection must have no type specified.";
            } else {
                obj5 = new StringBuilder();
                obj5.append("The projection variance ");
                obj5.append(s);
                obj5.append(" requires type to be specified.");
                obj4 = obj5.toString();
            }
            obj5 = new IllegalArgumentException(obj4.toString());
            throw obj5;
        }
    }

    public final kotlin.i0.s a() {
        return this.a;
    }

    public final kotlin.i0.o b() {
        return this.b;
    }

    public final kotlin.i0.o c() {
        return this.b;
    }

    public final kotlin.i0.s d() {
        return this.a;
    }

    public boolean equals(Object object) {
        boolean z;
        kotlin.i0.s sVar;
        Object obj3;
        if (this != (q)object && object instanceof q && n.b(this.a, object.a) && n.b(this.b, object.b)) {
            if (object instanceof q) {
                if (n.b(this.a, object.a)) {
                    if (n.b(this.b, object.b)) {
                    }
                }
            }
            return 0;
        }
        return 1;
    }

    public int hashCode() {
        int i;
        int i2;
        kotlin.i0.s sVar = this.a;
        if (sVar != null) {
            i = sVar.hashCode();
        } else {
            i = i2;
        }
        final kotlin.i0.o oVar = this.b;
        if (oVar != null) {
            i2 = oVar.hashCode();
        }
        return i3 += i2;
    }

    public String toString() {
        String valueOf;
        kotlin.i0.o i;
        kotlin.i0.s sVar = this.a;
        if (sVar == null) {
            valueOf = "*";
        } else {
            int i2 = r.a[sVar.ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                    } else {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("out ");
                        stringBuilder2.append(this.b);
                        valueOf = stringBuilder2.toString();
                    }
                    NoWhenBranchMatchedException noWhenBranchMatchedException = new NoWhenBranchMatchedException();
                    throw noWhenBranchMatchedException;
                }
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("in ");
                stringBuilder.append(this.b);
                valueOf = stringBuilder.toString();
            } else {
                valueOf = String.valueOf(this.b);
            }
        }
        return valueOf;
    }
}
