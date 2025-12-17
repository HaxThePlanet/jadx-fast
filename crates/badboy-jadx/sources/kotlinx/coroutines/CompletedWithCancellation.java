package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0080\u0008\u0018\u00002\u00020\u0001B2\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012!\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u0008\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\u0002\u0010\nJ\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÆ\u0003J$\u0010\u000c\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u0008\u0012\u0004\u0012\u00020\t0\u0004HÆ\u0003J:\u0010\r\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012#\u0008\u0002\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u0008\u0012\u0004\u0012\u00020\t0\u0004HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\u0008\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R+\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\u000c\u0008\u0006\u0012\u0008\u0008\u0007\u0012\u0004\u0008\u0008(\u0008\u0012\u0004\u0012\u00020\t0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Lkotlinx/coroutines/CompletedWithCancellation;", "", "result", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CompletedWithCancellation {

    public final Function1<Throwable, Unit> onCancellation;
    public final Object result;
    public CompletedWithCancellation(Object result, Function1<? super Throwable, Unit> onCancellation) {
        super();
        this.result = result;
        this.onCancellation = onCancellation;
    }

    public static kotlinx.coroutines.CompletedWithCancellation copy$default(kotlinx.coroutines.CompletedWithCancellation completedWithCancellation, Object object2, Function1 function13, int i4, Object object5) {
        Object obj1;
        Function1 obj2;
        if (i4 & 1 != 0) {
            obj1 = completedWithCancellation.result;
        }
        if (i4 &= 2 != 0) {
            obj2 = completedWithCancellation.onCancellation;
        }
        return completedWithCancellation.copy(obj1, obj2);
    }

    public final Object component1() {
        return this.result;
    }

    public final Function1<Throwable, Unit> component2() {
        return this.onCancellation;
    }

    public final kotlinx.coroutines.CompletedWithCancellation copy(Object object, Function1<? super Throwable, Unit> function12) {
        CompletedWithCancellation completedWithCancellation = new CompletedWithCancellation(object, function12);
        return completedWithCancellation;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof CompletedWithCancellation) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.result, obj.result)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.onCancellation, obj.onCancellation)) {
            return i2;
        }
        return i;
    }

    public int hashCode() {
        int i;
        if (this.result == null) {
            i = 0;
        } else {
            i = this.result.hashCode();
        }
        return i2 += i4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("CompletedWithCancellation(result=").append(this.result).append(", onCancellation=").append(this.onCancellation).append(')').toString();
    }
}
