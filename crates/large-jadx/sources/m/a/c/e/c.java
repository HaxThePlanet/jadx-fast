package m.a.c.e;

import kotlin.Metadata;
import kotlin.d0.c.l;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.w;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B+\u0012$\u0008\u0002\u0010\u0003\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007J%\u0010\n\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0006HÆ\u0003J5\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u00002$\u0008\u0002\u0010\u0003\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0006HÆ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R-\u0010\u0003\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\t¨\u0006\u0013", d2 = {"Lorg/koin/core/definition/Callbacks;", "T", "", "onClose", "Lkotlin/Function1;", "", "Lorg/koin/core/definition/OnCloseCallback;", "(Lkotlin/jvm/functions/Function1;)V", "getOnClose", "()Lkotlin/jvm/functions/Function1;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "koin-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class c<T>  {

    private final l<T, w> a;
    public c() {
        final int i = 0;
        super(i, 1, i);
    }

    public c(l<? super T, w> l) {
        super();
        this.a = l;
    }

    public c(l l, int i2, g g3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof c) {
            return i2;
        }
        if (!n.b(this.a, object.a)) {
            return i2;
        }
        return i;
    }

    public int hashCode() {
        int i;
        l lVar = this.a;
        if (lVar == null) {
            i = 0;
        } else {
            i = lVar.hashCode();
        }
        return i;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Callbacks(onClose=");
        stringBuilder.append(this.a);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
