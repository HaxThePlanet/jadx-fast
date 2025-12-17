package androidx.compose.runtime;

import android.os.Looper;
import android.util.Log;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\u001a\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0016H\u0000\u001a\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0019H\u0000\u001a\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\rH\u0000\u001a/\u0010\u001c\u001a\u0008\u0012\u0004\u0012\u0002H\u001e0\u001d\"\u0004\u0008\u0000\u0010\u001e2\u0006\u0010\u0012\u001a\u0002H\u001e2\u000c\u0010\u001f\u001a\u0008\u0012\u0004\u0012\u0002H\u001e0 H\u0000¢\u0006\u0002\u0010!\u001a\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000b2\u0006\u0010%\u001a\u00020&H\u0000\"!\u0010\u0000\u001a\u00020\u00018FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\u0008\u0006\u0010\u0007\u0012\u0004\u0008\u0002\u0010\u0003\u001a\u0004\u0008\u0004\u0010\u0005\"\u000e\u0010\u0008\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u000c\u001a\u00020\rX\u0080\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000f*\u000c\u0008\u0000\u0010'\"\u00020(2\u00020(¨\u0006)", d2 = {"DefaultMonotonicFrameClock", "Landroidx/compose/runtime/MonotonicFrameClock;", "getDefaultMonotonicFrameClock$annotations", "()V", "getDefaultMonotonicFrameClock", "()Landroidx/compose/runtime/MonotonicFrameClock;", "DefaultMonotonicFrameClock$delegate", "Lkotlin/Lazy;", "DisallowDefaultMonotonicFrameClock", "", "LogTag", "", "MainThreadId", "", "getMainThreadId", "()J", "createSnapshotMutableDoubleState", "Landroidx/compose/runtime/MutableDoubleState;", "value", "", "createSnapshotMutableFloatState", "Landroidx/compose/runtime/MutableFloatState;", "", "createSnapshotMutableIntState", "Landroidx/compose/runtime/MutableIntState;", "", "createSnapshotMutableLongState", "Landroidx/compose/runtime/MutableLongState;", "createSnapshotMutableState", "Landroidx/compose/runtime/snapshots/SnapshotMutableState;", "T", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "(Ljava/lang/Object;Landroidx/compose/runtime/SnapshotMutationPolicy;)Landroidx/compose/runtime/snapshots/SnapshotMutableState;", "logError", "", "message", "e", "", "CheckResult", "Landroidx/annotation/CheckResult;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class ActualAndroid_androidKt {

    private static final Lazy DefaultMonotonicFrameClock$delegate = null;
    private static final boolean DisallowDefaultMonotonicFrameClock = false;
    private static final String LogTag = "ComposeInternal";
    private static final long MainThreadId = -1;
    static {
        ActualAndroid_androidKt.DefaultMonotonicFrameClock$delegate = LazyKt.lazy((Function0)ActualAndroid_androidKt.DefaultMonotonicFrameClock.2.INSTANCE);
        long id = Looper.getMainLooper().getThread().getId();
    }

    public static final androidx.compose.runtime.MutableDoubleState createSnapshotMutableDoubleState(double value) {
        ParcelableSnapshotMutableDoubleState parcelableSnapshotMutableDoubleState = new ParcelableSnapshotMutableDoubleState(value, obj2);
        return (MutableDoubleState)parcelableSnapshotMutableDoubleState;
    }

    public static final androidx.compose.runtime.MutableFloatState createSnapshotMutableFloatState(float value) {
        ParcelableSnapshotMutableFloatState parcelableSnapshotMutableFloatState = new ParcelableSnapshotMutableFloatState(value);
        return (MutableFloatState)parcelableSnapshotMutableFloatState;
    }

    public static final androidx.compose.runtime.MutableIntState createSnapshotMutableIntState(int value) {
        ParcelableSnapshotMutableIntState parcelableSnapshotMutableIntState = new ParcelableSnapshotMutableIntState(value);
        return (MutableIntState)parcelableSnapshotMutableIntState;
    }

    public static final androidx.compose.runtime.MutableLongState createSnapshotMutableLongState(long value) {
        ParcelableSnapshotMutableLongState parcelableSnapshotMutableLongState = new ParcelableSnapshotMutableLongState(value, obj2);
        return (MutableLongState)parcelableSnapshotMutableLongState;
    }

    public static final <T> SnapshotMutableState<T> createSnapshotMutableState(T value, androidx.compose.runtime.SnapshotMutationPolicy<T> policy) {
        ParcelableSnapshotMutableState parcelableSnapshotMutableState = new ParcelableSnapshotMutableState(value, policy);
        return (SnapshotMutableState)parcelableSnapshotMutableState;
    }

    public static final androidx.compose.runtime.MonotonicFrameClock getDefaultMonotonicFrameClock() {
        return (MonotonicFrameClock)ActualAndroid_androidKt.DefaultMonotonicFrameClock$delegate.getValue();
    }

    @Deprecated(message = "MonotonicFrameClocks are not globally applicable across platforms. Use an appropriate local clock.")
    public static void getDefaultMonotonicFrameClock$annotations() {
    }

    public static final long getMainThreadId() {
        return ActualAndroid_androidKt.MainThreadId;
    }

    public static final void logError(String message, Throwable e) {
        Log.e("ComposeInternal", message, e);
    }
}
