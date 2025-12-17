package kotlin.h0;

import kotlin.Metadata;
import kotlin.d0.d.g;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u0000 \u00142\u00020\u00012\u0008\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0014B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u0003H\u0096\u0002J\u0013\u0010\r\u001a\u00020\u000b2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\u0008\u0010\u0010\u001a\u00020\u0003H\u0016J\u0008\u0010\u0011\u001a\u00020\u000bH\u0016J\u0008\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u0007\u0010\u0008R\u0014\u0010\u0004\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\t\u0010\u0008¨\u0006\u0015", d2 = {"Lkotlin/ranges/IntRange;", "Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(II)V", "getEndInclusive", "()Ljava/lang/Integer;", "getStart", "contains", "", "value", "equals", "other", "", "hashCode", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
public final class f extends kotlin.h0.d {

    private static final kotlin.h0.f w;
    public static final kotlin.h0.f.a x;

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lkotlin/ranges/IntRange$Companion;", "", "()V", "EMPTY", "Lkotlin/ranges/IntRange;", "getEMPTY", "()Lkotlin/ranges/IntRange;", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public final kotlin.h0.f a() {
            return f.l();
        }
    }
    static {
        f.a aVar = new f.a(0);
        f.x = aVar;
        f fVar = new f(1, 0);
        f.w = fVar;
    }

    public f(int i, int i2) {
        super(i, i2, 1);
    }

    public static final kotlin.h0.f l() {
        return f.w;
    }

    @Override // kotlin.h0.d
    public boolean equals(Object object) {
        boolean empty;
        int i;
        int obj3;
        if (object instanceof f) {
            if (isEmpty()) {
                if (!(f)object.isEmpty()) {
                    if (d() == (f)object.d() && g() == object.g()) {
                        obj3 = g() == object.g() ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return obj3;
    }

    @Override // kotlin.h0.d
    public int hashCode() {
        int i;
        int i2;
        if (isEmpty()) {
            i = -1;
        } else {
            i4 += i2;
        }
        return i;
    }

    @Override // kotlin.h0.d
    public boolean isEmpty() {
        int i;
        i = d() > g() ? 1 : 0;
        return i;
    }

    @Override // kotlin.h0.d
    public boolean m(int i) {
        int i2;
        int obj2;
        if (d() <= i && i <= g()) {
            obj2 = i <= g() ? 1 : 0;
        } else {
        }
        return obj2;
    }

    @Override // kotlin.h0.d
    public Integer p() {
        return Integer.valueOf(g());
    }

    @Override // kotlin.h0.d
    public Integer q() {
        return Integer.valueOf(d());
    }

    @Override // kotlin.h0.d
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(d());
        stringBuilder.append("..");
        stringBuilder.append(g());
        return stringBuilder.toString();
    }
}
