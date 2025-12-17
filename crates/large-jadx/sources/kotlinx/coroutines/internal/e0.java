package kotlinx.coroutines.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlinx.coroutines.q0;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0007\n\u0002\u0010\u0011\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0018\n\u0002\u0010\u0000\n\u0002\u0018\u0002\u0008\u0017\u0018\u0000*\u0012\u0008\u0000\u0010\u0003*\u00020\u0001*\u0008\u0012\u0004\u0012\u00028\u00000\u00022\u000602j\u0002`3B\u0007¢\u0006\u0004\u0008\u0004\u0010\u0005J\u0017\u0010\u0008\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000H\u0001¢\u0006\u0004\u0008\u0008\u0010\tJ\u0015\u0010\n\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\u0008\n\u0010\tJ.\u0010\u000e\u001a\u00020\u000c2\u0006\u0010\u0006\u001a\u00028\u00002\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u000c0\u000bH\u0086\u0008¢\u0006\u0004\u0008\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u0007¢\u0006\u0004\u0008\u0010\u0010\u0005J\u0011\u0010\u0011\u001a\u0004\u0018\u00018\u0000H\u0001¢\u0006\u0004\u0008\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\u0008\u0013\u0010\u0012J\u0017\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0014H\u0002¢\u0006\u0004\u0008\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u00020\u000c2\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0004\u0008\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0001¢\u0006\u0004\u0008\u001b\u0010\u001cJ&\u0010\u001e\u001a\u0004\u0018\u00018\u00002\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000c0\u000bH\u0086\u0008¢\u0006\u0004\u0008\u001e\u0010\u001fJ\u000f\u0010 \u001a\u0004\u0018\u00018\u0000¢\u0006\u0004\u0008 \u0010\u0012J\u0018\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0019H\u0082\u0010¢\u0006\u0004\u0008\"\u0010#J\u0018\u0010$\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0019H\u0082\u0010¢\u0006\u0004\u0008$\u0010#J\u001f\u0010&\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00192\u0006\u0010%\u001a\u00020\u0019H\u0002¢\u0006\u0004\u0008&\u0010'R \u0010(\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\u0008(\u0010)R\u0011\u0010*\u001a\u00020\u000c8F¢\u0006\u0006\u001a\u0004\u0008*\u0010+R$\u00100\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u00198F@BX\u0086\u000e¢\u0006\u000c\u001a\u0004\u0008-\u0010.\"\u0004\u0008/\u0010#¨\u00061", d2 = {"Lkotlinx/coroutines/internal/ThreadSafeHeap;", "Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "", "T", "<init>", "()V", "node", "", "addImpl", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)V", "addLast", "Lkotlin/Function1;", "", "cond", "addLastIf", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;Lkotlin/jvm/functions/Function1;)Z", "clear", "firstImpl", "()Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "peek", "", "realloc", "()[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "remove", "(Lkotlinx/coroutines/internal/ThreadSafeHeapNode;)Z", "", "index", "removeAtImpl", "(I)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "predicate", "removeFirstIf", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "removeFirstOrNull", "i", "siftDownFrom", "(I)V", "siftUpFrom", "j", "swap", "(II)V", "a", "[Lkotlinx/coroutines/internal/ThreadSafeHeapNode;", "isEmpty", "()Z", "value", "getSize", "()I", "setSize", "size", "kotlinx-coroutines-core", "", "Lkotlinx/coroutines/internal/SynchronizedObject;"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class e0<T extends kotlinx.coroutines.internal.f0 & Comparable<? super T>>  {

    private volatile int _size = 0;
    private T[] a;
    public e0() {
        super();
        final int i = 0;
    }

    private final T[] f() {
        kotlinx.coroutines.internal.f0[] copyOf;
        int str;
        int length;
        copyOf = this.a;
        if (copyOf == null) {
            this.a = new f0[4];
        } else {
            if (c() >= copyOf.length) {
                copyOf = Arrays.copyOf(copyOf, i2 *= 2);
                n.e(copyOf, "java.util.Arrays.copyOf(this, newSize)");
                this.a = (f0[])copyOf;
            }
        }
        return copyOf;
    }

    private final void j(int i) {
        this._size = i;
    }

    private final void k(int i) {
        int i2;
        int compareTo;
        kotlinx.coroutines.internal.f0 f0Var;
        i3++;
        while (i2 >= c()) {
            kotlinx.coroutines.internal.f0[] objArr = this.a;
            n.d(objArr);
            int i5 = i2 + 1;
            kotlinx.coroutines.internal.f0 f0Var4 = objArr[i5];
            n.d(f0Var4);
            f0Var = objArr[i2];
            n.d(f0Var);
            if (i5 < c() && (Comparable)f0Var4.compareTo(f0Var) < 0) {
            }
            kotlinx.coroutines.internal.f0 f0Var3 = objArr[i];
            n.d(f0Var3);
            kotlinx.coroutines.internal.f0 f0Var2 = objArr[i2];
            n.d(f0Var2);
            m(i, i2);
            final int obj6 = i2;
            i3++;
            f0Var4 = objArr[i5];
            n.d(f0Var4);
            f0Var = objArr[i2];
            n.d(f0Var);
            if ((Comparable)f0Var4.compareTo(f0Var) < 0) {
            }
            i2 = i5;
        }
    }

    private final void l(int i) {
        while (i <= 0) {
            kotlinx.coroutines.internal.f0[] objArr = this.a;
            n.d(objArr);
            i2 /= 2;
            final kotlinx.coroutines.internal.f0 f0Var2 = objArr[i3];
            n.d(f0Var2);
            kotlinx.coroutines.internal.f0 f0Var = objArr[i];
            n.d(f0Var);
            m(i, i3);
            final int obj4 = i3;
        }
    }

    private final void m(int i, int i2) {
        final kotlinx.coroutines.internal.f0[] objArr = this.a;
        n.d(objArr);
        final kotlinx.coroutines.internal.f0 f0Var = objArr[i2];
        n.d(f0Var);
        final kotlinx.coroutines.internal.f0 f0Var2 = objArr[i];
        n.d(f0Var2);
        objArr[i] = f0Var;
        objArr[i2] = f0Var2;
        f0Var.f(i);
        f0Var2.f(i2);
    }

    public final void a(T t) {
        boolean z;
        if (q0.a()) {
            z = t.e() == null ? 1 : 0;
            if (z == 0) {
            } else {
            }
            AssertionError obj4 = new AssertionError();
            throw obj4;
        }
        t.a(this);
        final int i = c();
        j(i + 1);
        f()[i] = t;
        t.f(i);
        l(i);
    }

    public final T b() {
        int i;
        int i2;
        kotlinx.coroutines.internal.f0[] objArr = this.a;
        i = objArr == null ? 0 : objArr[i2];
        return i;
    }

    public final int c() {
        return this._size;
    }

    public final boolean d() {
        int i;
        i = c() == 0 ? 1 : 0;
        return i;
    }

    public final T e() {
        return b();
        synchronized (this) {
            return b();
        }
    }

    public final boolean g(T t) {
        boolean e0Var;
        int i2;
        int i;
        int obj4;
        synchronized (this) {
            try {
                i2 = i;
                obj4 = t.getIndex();
                if (q0.a() && obj4 >= 0) {
                }
                if (obj4 >= 0) {
                }
                i = i2;
                if (i == 0) {
                } else {
                }
                obj4 = new AssertionError();
                throw obj4;
                h(obj4);
                return i2;
                throw t;
            }
        }
    }

    public final T h(int i) {
        int z2;
        int i2;
        int i3;
        boolean z;
        int compareTo;
        kotlinx.coroutines.internal.f0 f0Var;
        int i6 = 1;
        if (q0.a()) {
            z2 = c() > 0 ? i6 : i2;
            if (z2 == 0) {
            } else {
            }
            AssertionError obj8 = new AssertionError();
            throw obj8;
        }
        kotlinx.coroutines.internal.f0[] objArr = this.a;
        n.d(objArr);
        final int i12 = -1;
        j(i8 += i12);
        if (i < c()) {
            m(i, c());
            i11 /= 2;
            kotlinx.coroutines.internal.f0 f0Var2 = objArr[i];
            n.d(f0Var2);
            f0Var = objArr[i3];
            n.d(f0Var);
            if (i > 0 && (Comparable)f0Var2.compareTo(f0Var) < 0) {
                f0Var2 = objArr[i];
                n.d(f0Var2);
                f0Var = objArr[i3];
                n.d(f0Var);
                if ((Comparable)f0Var2.compareTo(f0Var) < 0) {
                    m(i, i3);
                    l(i3);
                } else {
                    k(i);
                }
            } else {
            }
        }
        obj8 = objArr[c()];
        n.d(obj8);
        if (q0.a() && obj8.e() == this) {
            if (obj8.e() == this) {
                i2 = i6;
            }
            if (i2 == 0) {
            } else {
            }
            obj8 = new AssertionError();
            throw obj8;
        }
        int i5 = 0;
        obj8.a(i5);
        obj8.f(i12);
        objArr[c()] = i5;
        return obj8;
    }

    public final T i() {
        kotlinx.coroutines.internal.f0 f0Var;
        synchronized (this) {
            try {
                f0Var = h(0);
                f0Var = 0;
                return f0Var;
                throw th;
            }
        }
    }
}
