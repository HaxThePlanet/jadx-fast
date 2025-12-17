package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0002\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u001f\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006\u0012\n\u0008\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0008¢\u0006\u0002\u0010\tJ\u0008\u0010\u000e\u001a\u00020\u000fH\u0016J\u0008\u0010\u0010\u001a\u00020\u0011H\u0016J\u0008\u0010\u0012\u001a\u00020\u0008H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0088\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000c\u0010\r¨\u0006\u0013", d2 = {"Lkotlin/SynchronizedLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "lock", "", "(Lkotlin/jvm/functions/Function0;Ljava/lang/Object;)V", "_value", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class SynchronizedLazyImpl<T>  implements kotlin.Lazy<T>, Serializable {

    private volatile Object _value;
    private Function0<? extends T> initializer;
    private final Object lock;
    public SynchronizedLazyImpl(Function0<? extends T> initializer, Object lock) {
        Object obj;
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        super();
        this.initializer = initializer;
        this._value = UNINITIALIZED_VALUE.INSTANCE;
        obj = lock == null ? this : lock;
        this.lock = obj;
    }

    public SynchronizedLazyImpl(Function0 function0, Object object2, int i3, DefaultConstructorMarker defaultConstructorMarker4) {
        int obj2;
        obj2 = i3 &= 2 != 0 ? 0 : obj2;
        super(function0, obj2);
    }

    private final Object writeReplace() {
        InitializedLazyImpl initializedLazyImpl = new InitializedLazyImpl(getValue());
        return initializedLazyImpl;
    }

    public T getValue() {
        Object invoke;
        int i;
        final Object _value = this._value;
        if (_value != UNINITIALIZED_VALUE.INSTANCE) {
            return _value;
        }
        Object lock = this.lock;
        final int i2 = 0;
        final Object _value2 = this._value;
        synchronized (lock) {
            invoke = _value2;
            return invoke;
        }
    }

    @Override // kotlin.Lazy
    public boolean isInitialized() {
        int i;
        i = this._value != UNINITIALIZED_VALUE.INSTANCE ? 1 : 0;
        return i;
    }

    @Override // kotlin.Lazy
    public String toString() {
        String valueOf;
        if (isInitialized()) {
            valueOf = String.valueOf(getValue());
        } else {
            valueOf = "Lazy value not initialized yet.";
        }
        return valueOf;
    }
}
