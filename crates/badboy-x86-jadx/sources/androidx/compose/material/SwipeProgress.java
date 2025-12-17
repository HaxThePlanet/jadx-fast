package androidx.compose.material;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Deprecated(message = "Material's Swipeable has been replaced by Foundation's AnchoredDraggable APIs. Please see developer.android.com for an overview of the changes and a migration guide.")
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0007\n\u0002\u0008\u0008\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0007\u0018\u0000*\u0004\u0008\u0000\u0010\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0008\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000c\u001a\u0004\u0008\r\u0010\u000b¨\u0006\u0015", d2 = {"Landroidx/compose/material/SwipeProgress;", "T", "", "from", "to", "fraction", "", "(Ljava/lang/Object;Ljava/lang/Object;F)V", "getFraction", "()F", "getFrom", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getTo", "equals", "", "other", "hashCode", "", "toString", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SwipeProgress<T>  {

    public static final int $stable;
    private final float fraction;
    private final T from;
    private final T to;
    static {
    }

    public SwipeProgress(T from, T to, float fraction) {
        super();
        this.from = from;
        this.to = to;
        this.fraction = fraction;
    }

    public boolean equals(Object other) {
        int i;
        final int i2 = 1;
        if (this == other) {
            return i2;
        }
        final int i3 = 0;
        if (!other instanceof SwipeProgress) {
            return i3;
        }
        if (!Intrinsics.areEqual(this.from, obj2.from)) {
            return i3;
        }
        if (!Intrinsics.areEqual(this.to, obj3.to)) {
            return i3;
        }
        i = Float.compare(fraction, fraction2) == 0 ? i2 : i3;
        if (i == 0) {
            return i3;
        }
        return i2;
    }

    public final float getFraction() {
        return this.fraction;
    }

    public final T getFrom() {
        return this.from;
    }

    public final T getTo() {
        return this.to;
    }

    public int hashCode() {
        int i;
        int i2;
        Object from = this.from;
        if (from != null) {
            i = from.hashCode();
        } else {
            i = i2;
        }
        final Object obj = this.to;
        if (obj != null) {
            i2 = obj.hashCode();
        }
        return result += i4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("SwipeProgress(from=").append(this.from).append(", to=").append(this.to).append(", fraction=").append(this.fraction).append(')').toString();
    }
}
