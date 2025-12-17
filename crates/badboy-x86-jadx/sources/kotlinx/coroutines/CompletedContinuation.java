package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
@Metadata(d1 = "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0008\u0082\u0008\u0018\u00002\u00020\u0001BZ\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\n\u0008\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012%\u0008\u0002\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006\u0012\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u0001\u0012\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J&\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J`\u0010\u0018\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\u0008\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042%\u0008\u0002\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00062\n\u0008\u0002\u0010\u000c\u001a\u0004\u0018\u00010\u00012\n\u0008\u0002\u0010\r\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00102\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u001a\u0010\u001d\u001a\u00020\u000b2\n\u0010\u001e\u001a\u0006\u0012\u0002\u0008\u00030\u001f2\u0006\u0010\n\u001a\u00020\u0007J\t\u0010 \u001a\u00020!HÖ\u0001R\u0012\u0010\r\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\u0008\u0011\u0010\u0012R\u0012\u0010\u000c\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R-\u0010\u0005\u001a\u001f\u0012\u0013\u0012\u00110\u0007¢\u0006\u000c\u0008\u0008\u0012\u0008\u0008\t\u0012\u0004\u0008\u0008(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\"", d2 = {"Lkotlinx/coroutines/CompletedContinuation;", "", "result", "cancelHandler", "Lkotlinx/coroutines/CancelHandler;", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "", "idempotentResume", "cancelCause", "(Ljava/lang/Object;Lkotlinx/coroutines/CancelHandler;Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Ljava/lang/Throwable;)V", "cancelled", "", "getCancelled", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "invokeHandlers", "cont", "Lkotlinx/coroutines/CancellableContinuationImpl;", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class CompletedContinuation {

    public final Throwable cancelCause;
    public final kotlinx.coroutines.CancelHandler cancelHandler;
    public final Object idempotentResume;
    public final Function1<Throwable, Unit> onCancellation;
    public final Object result;
    public CompletedContinuation(Object result, kotlinx.coroutines.CancelHandler cancelHandler, Function1<? super Throwable, Unit> onCancellation, Object idempotentResume, Throwable cancelCause) {
        super();
        this.result = result;
        this.cancelHandler = cancelHandler;
        this.onCancellation = onCancellation;
        this.idempotentResume = idempotentResume;
        this.cancelCause = cancelCause;
    }

    public CompletedContinuation(Object object, kotlinx.coroutines.CancelHandler cancelHandler2, Function1 function13, Object object4, Throwable throwable5, int i6, DefaultConstructorMarker defaultConstructorMarker7) {
        int obj3;
        int obj4;
        int obj5;
        int obj7;
        final int i = 0;
        obj3 = i6 & 2 != 0 ? i : obj3;
        obj4 = i6 & 4 != 0 ? i : obj4;
        obj5 = i6 & 8 != 0 ? i : obj5;
        obj7 = i6 &= 16 != 0 ? i : throwable5;
        super(object, obj3, obj4, obj5, obj7);
    }

    public static kotlinx.coroutines.CompletedContinuation copy$default(kotlinx.coroutines.CompletedContinuation completedContinuation, Object object2, kotlinx.coroutines.CancelHandler cancelHandler3, Function1 function14, Object object5, Throwable throwable6, int i7, Object object8) {
        Object obj1;
        kotlinx.coroutines.CancelHandler obj2;
        Function1 obj3;
        Object obj4;
        Throwable obj5;
        if (i7 & 1 != 0) {
            obj1 = completedContinuation.result;
        }
        if (i7 & 2 != 0) {
            obj2 = completedContinuation.cancelHandler;
        }
        if (i7 & 4 != 0) {
            obj3 = completedContinuation.onCancellation;
        }
        if (i7 & 8 != 0) {
            obj4 = completedContinuation.idempotentResume;
        }
        if (i7 &= 16 != 0) {
            obj5 = completedContinuation.cancelCause;
        }
        return completedContinuation.copy(obj1, obj2, obj3, obj4, obj5);
    }

    public final Object component1() {
        return this.result;
    }

    public final kotlinx.coroutines.CancelHandler component2() {
        return this.cancelHandler;
    }

    public final Function1<Throwable, Unit> component3() {
        return this.onCancellation;
    }

    public final Object component4() {
        return this.idempotentResume;
    }

    public final Throwable component5() {
        return this.cancelCause;
    }

    public final kotlinx.coroutines.CompletedContinuation copy(Object object, kotlinx.coroutines.CancelHandler cancelHandler2, Function1<? super Throwable, Unit> function13, Object object4, Throwable throwable5) {
        CompletedContinuation completedContinuation = new CompletedContinuation(object, cancelHandler2, function13, object4, throwable5);
        return completedContinuation;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof CompletedContinuation) {
            return i2;
        }
        Object obj = object;
        if (!Intrinsics.areEqual(this.result, obj.result)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.cancelHandler, obj.cancelHandler)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.onCancellation, obj.onCancellation)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.idempotentResume, obj.idempotentResume)) {
            return i2;
        }
        if (!Intrinsics.areEqual(this.cancelCause, obj.cancelCause)) {
            return i2;
        }
        return i;
    }

    public final boolean getCancelled() {
        int i;
        i = this.cancelCause != null ? 1 : 0;
        return i;
    }

    public int hashCode() {
        int i2;
        int i;
        int i4;
        int i3;
        int i5;
        i = 0;
        if (this.result == null) {
            i2 = i;
        } else {
            i2 = this.result.hashCode();
        }
        if (this.cancelHandler == null) {
            i4 = i;
        } else {
            i4 = this.cancelHandler.hashCode();
        }
        if (this.onCancellation == null) {
            i3 = i;
        } else {
            i3 = this.onCancellation.hashCode();
        }
        if (this.idempotentResume == null) {
            i5 = i;
        } else {
            i5 = this.idempotentResume.hashCode();
        }
        if (this.cancelCause == null) {
        } else {
            i = this.cancelCause.hashCode();
        }
        return i8 += i;
    }

    public final void invokeHandlers(kotlinx.coroutines.CancellableContinuationImpl<?> cont, Throwable cause) {
        int i;
        kotlinx.coroutines.CancelHandler cancelHandler = this.cancelHandler;
        if (cancelHandler != null) {
            i = 0;
            cont.callCancelHandler(cancelHandler, cause);
        }
        Function1 it = this.onCancellation;
        if (it != null) {
            i = 0;
            cont.callOnCancellation(it, cause);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("CompletedContinuation(result=").append(this.result).append(", cancelHandler=").append(this.cancelHandler).append(", onCancellation=").append(this.onCancellation).append(", idempotentResume=").append(this.idempotentResume).append(", cancelCause=").append(this.cancelCause).append(')').toString();
    }
}
