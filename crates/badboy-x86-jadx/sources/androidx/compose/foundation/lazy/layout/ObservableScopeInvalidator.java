package androidx.compose.foundation.lazy.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000b\n\u0002\u0008\u0004\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000e\n\u0002\u0008\u0003\u0008\u0081@\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\u0008\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\u0008\u0008\u0010\tJ\u001a\u0010\n\u001a\u00020\u000b2\u0008\u0010\u000c\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\u0008\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\u0008\u0011\u0010\u0012J\r\u0010\u0013\u001a\u00020\u0004¢\u0006\u0004\u0008\u0014\u0010\tJ\u0010\u0010\u0015\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\u0008\u0017\u0010\u0018R\u0014\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u0008\u0012\u0004\u0012\u00020\u00040\u0003¨\u0006\u0019", d2 = {"Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "", "state", "Landroidx/compose/runtime/MutableState;", "", "constructor-impl", "(Landroidx/compose/runtime/MutableState;)Landroidx/compose/runtime/MutableState;", "attachToScope", "attachToScope-impl", "(Landroidx/compose/runtime/MutableState;)V", "equals", "", "other", "equals-impl", "(Landroidx/compose/runtime/MutableState;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Landroidx/compose/runtime/MutableState;)I", "invalidateScope", "invalidateScope-impl", "toString", "", "toString-impl", "(Landroidx/compose/runtime/MutableState;)Ljava/lang/String;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
@JvmInline
public final class ObservableScopeInvalidator {

    private final MutableState<Unit> state;
    private ObservableScopeInvalidator(MutableState state) {
        super();
        this.state = state;
    }

    public static final void attachToScope-impl(MutableState<Unit> arg0) {
        arg0.getValue();
    }

    public static final androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator box-impl(MutableState mutableState) {
        ObservableScopeInvalidator observableScopeInvalidator = new ObservableScopeInvalidator(mutableState);
        return observableScopeInvalidator;
    }

    public static MutableState<Unit> constructor-impl(MutableState<Unit> mutableState) {
        return mutableState;
    }

    public static MutableState constructor-impl$default(MutableState mutableState, int i2, DefaultConstructorMarker defaultConstructorMarker3) {
        MutableState obj0;
        int obj1;
        if (i2 &= 1 != 0) {
            obj0 = SnapshotStateKt.mutableStateOf(Unit.INSTANCE, SnapshotStateKt.neverEqualPolicy());
        }
        return ObservableScopeInvalidator.constructor-impl(obj0);
    }

    public static boolean equals-impl(MutableState<Unit> mutableState, Object object2) {
        final int i2 = 0;
        if (!object2 instanceof ObservableScopeInvalidator) {
            return i2;
        }
        if (!Intrinsics.areEqual(mutableState, (ObservableScopeInvalidator)object2.unbox-impl())) {
            return i2;
        }
        return 1;
    }

    public static final boolean equals-impl0(MutableState<Unit> mutableState, MutableState<Unit> mutableState2) {
        return Intrinsics.areEqual(mutableState, mutableState2);
    }

    public static int hashCode-impl(MutableState<Unit> mutableState) {
        return mutableState.hashCode();
    }

    public static final void invalidateScope-impl(MutableState<Unit> arg0) {
        arg0.setValue(Unit.INSTANCE);
    }

    public static String toString-impl(MutableState<Unit> mutableState) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("ObservableScopeInvalidator(state=").append(mutableState).append(')').toString();
    }

    public boolean equals(Object object) {
        return ObservableScopeInvalidator.equals-impl(this.state, object);
    }

    public int hashCode() {
        return ObservableScopeInvalidator.hashCode-impl(this.state);
    }

    public String toString() {
        return ObservableScopeInvalidator.toString-impl(this.state);
    }

    public final MutableState unbox-impl() {
        return this.state;
    }
}
