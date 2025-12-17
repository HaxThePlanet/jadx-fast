package androidx.compose.runtime.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0000\u0008\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0008\u0010\u0008\u001a\u00020\tH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006\"\u0004\u0008\u0007\u0010\u0004¨\u0006\n", d2 = {"Landroidx/compose/runtime/internal/IntRef;", "", "element", "", "(I)V", "getElement", "()I", "setElement", "toString", "", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IntRef {

    public static final int $stable = 8;
    private int element;
    static {
        final int i = 8;
    }

    public IntRef() {
        super(0, 1, 0);
    }

    public IntRef(int element) {
        super();
        this.element = element;
    }

    public IntRef(int i, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        int obj1;
        obj1 = i2 &= 1 != 0 ? 0 : obj1;
        super(obj1);
    }

    public final int getElement() {
        return this.element;
    }

    public final void setElement(int <set-?>) {
        this.element = <set-?>;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = Integer.toString(hashCode(), CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(string2, "toString(this, checkRadix(radix))");
        return stringBuilder.append("IntRef(element = ").append(this.element).append(")@").append(string2).toString();
    }
}
