package kotlin;

import java.io.Serializable;
import kotlin.d0.c.a;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes3.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0002\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u001f\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0002\u0010\tJ\u0008\u0010\u000e\u001a\u00020\u000fH\u0016J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J\u0008\u0010\u0012\u001a\u00020\u0008H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0088\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u0013", d2 = {"Lkotlin/SynchronizedLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "lock", "", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Object;)V", "_value", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
final class s<T>  implements kotlin.h<T>, Serializable {

    private volatile Object _value;
    private a<? extends T> initializer;
    private final Object lock;
    public s(a<? extends T> a, Object object2) {
        Object obj3;
        n.f(a, "initializer");
        super();
        this.initializer = a;
        this._value = v.a;
        if (object2 != null) {
        } else {
            obj3 = this;
        }
        this.lock = obj3;
    }

    public s(a a, Object object2, int i3, g g4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(a, obj2);
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
        kotlin.v vVar;
        Object _value;
        Object _value2 = this._value;
        vVar = v.a;
        if (_value2 != vVar) {
            return _value2;
        }
        Object lock = this.lock;
        synchronized (lock) {
            return _value;
        }
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
