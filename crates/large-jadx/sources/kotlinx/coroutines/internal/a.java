package kotlinx.coroutines.internal;

import java.util.Objects;
import kotlin.Metadata;
import kotlin.y.i;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0011\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0007\u0008\u0010\u0018\u0000*\u0008\u0008\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00028\u0000¢\u0006\u0002\u0010\u0010J\u0006\u0010\u0011\u001a\u00020\u000eJ\u0008\u0010\u0012\u001a\u00020\u000eH\u0002J\r\u0010\u0013\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0014R\u0018\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0005X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\u0008\t\u0010\u000bR\u000e\u0010\u000c\u001a\u00020\u0008X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Lkotlinx/coroutines/internal/ArrayQueue;", "T", "", "()V", "elements", "", "[Ljava/lang/Object;", "head", "", "isEmpty", "", "()Z", "tail", "addLast", "", "element", "(Ljava/lang/Object;)V", "clear", "ensureCapacity", "removeFirstOrNull", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public class a<T>  {

    private Object[] a;
    private int b;
    private int c;
    public a() {
        super();
        this.a = new Object[16];
    }

    private final void b() {
        final Object obj = this;
        Object[] objArr = obj.a;
        final int length2 = objArr.length;
        Object[] arr = new Object[length2 << 1];
        Object[] objArr2 = arr;
        i.h(objArr, objArr2, 0, obj.b, 0, 10, 0);
        final Object[] objArr3 = obj.a;
        final int i11 = obj.b;
        i.h(objArr3, arr, length - i11, 0, i11, 4, 0);
        obj.a = objArr2;
        obj.b = 0;
        obj.c = length2;
    }

    public final void a(T t) {
        Object[] objArr = this.a;
        int i2 = this.c;
        objArr[i2] = t;
        obj3 &= i3;
        this.c = obj3;
        if (obj3 == this.b) {
            b();
        }
    }

    public final boolean c() {
        int i;
        i = this.b == this.c ? 1 : 0;
        return i;
    }

    public final T d() {
        int i = this.b;
        final int i6 = 0;
        if (i == this.c) {
            return i6;
        }
        Object[] objArr = this.a;
        final Object obj = objArr[i];
        objArr[i] = i6;
        this.b = i2 &= i5;
        Objects.requireNonNull(obj, "null cannot be cast to non-null type T of kotlinx.coroutines.internal.ArrayQueue");
        return obj;
    }
}
