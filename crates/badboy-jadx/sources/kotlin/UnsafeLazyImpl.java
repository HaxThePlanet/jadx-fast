package kotlin;

import java.io.Serializable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0008\u0000\u0018\u0000*\u0006\u0008\u0000\u0010\u0001 \u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004B\u0013\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0008\u0010\r\u001a\u00020\u000eH\u0016J\u0008\u0010\u000f\u001a\u00020\u0010H\u0016J\u0008\u0010\u0011\u001a\u00020\tH\u0002R\u0010\u0010\u0008\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0088\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000c¨\u0006\u0012", d2 = {"Lkotlin/UnsafeLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "Lkotlin/io/Serializable;", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class UnsafeLazyImpl<T>  implements kotlin.Lazy<T>, Serializable {

    private Object _value;
    private Function0<? extends T> initializer;
    public UnsafeLazyImpl(Function0<? extends T> initializer) {
        Intrinsics.checkNotNullParameter(initializer, "initializer");
        super();
        this.initializer = initializer;
        this._value = UNINITIALIZED_VALUE.INSTANCE;
    }

    private final Object writeReplace() {
        InitializedLazyImpl initializedLazyImpl = new InitializedLazyImpl(getValue());
        return initializedLazyImpl;
    }

    public T getValue() {
        Object _value;
        if (this._value == UNINITIALIZED_VALUE.INSTANCE) {
            Function0 initializer = this.initializer;
            Intrinsics.checkNotNull(initializer);
            this._value = initializer.invoke();
            this.initializer = 0;
        }
        return this._value;
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
