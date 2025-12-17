package kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.d0.c.a;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0002\u0018\u0000 \u0013*\u0006\u0008\u0000\u0010\u0001 \u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004:\u0001\u0013B\u0013\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0008\u0010\u000e\u001a\u00020\u000fH\u0016J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J\u0008\u0010\u0012\u001a\u00020\tH\u0002R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0088\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u0014", d2 = {"Lkotlin/SafePublicationLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "final", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
final class r<T>  implements kotlin.h<T>, Serializable {

    private static final AtomicReferenceFieldUpdater<kotlin.r<?>, Object> a;
    private volatile Object _value;
    private final Object final;
    private volatile a<? extends T> initializer;
    static {
        r.a = AtomicReferenceFieldUpdater.newUpdater(r.class, Object.class, "_value");
    }

    public r(a<? extends T> a) {
        n.f(a, "initializer");
        super();
        this.initializer = a;
        final kotlin.v obj2 = v.a;
        this._value = obj2;
        this.final = obj2;
    }

    private final Object writeReplace() {
        e eVar = new e(getValue());
        return eVar;
    }

    @Override // kotlin.h
    public boolean a() {
        int i;
        i = this._value != v.a ? 1 : 0;
        return i;
    }

    public T getValue() {
        Object initializer;
        kotlin.v compareAndSet;
        AtomicReferenceFieldUpdater field;
        Object _value = this._value;
        compareAndSet = v.a;
        if (_value != compareAndSet) {
            return _value;
        }
        initializer = this.initializer;
        initializer = initializer.invoke();
        if (initializer != null && r.a.compareAndSet(this, compareAndSet, initializer)) {
            initializer = initializer.invoke();
            if (r.a.compareAndSet(this, compareAndSet, initializer)) {
                this.initializer = 0;
                return initializer;
            }
        }
        return this._value;
    }

    @Override // kotlin.h
    public String toString() {
        String valueOf;
        if (a()) {
            valueOf = String.valueOf(getValue());
        } else {
            valueOf = "Lazy value not initialized yet.";
        }
        return valueOf;
    }
}
