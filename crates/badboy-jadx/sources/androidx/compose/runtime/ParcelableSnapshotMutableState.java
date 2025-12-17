package androidx.compose.runtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0001\u0018\u0000 \u000f*\u0004\u0008\u0000\u0010\u00012\u0008\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u0001\u000fB\u001b\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u000c\u0010\u0005\u001a\u0008\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007J\u0008\u0010\u0008\u001a\u00020\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\tH\u0016¨\u0006\u0010", d2 = {"Landroidx/compose/runtime/ParcelableSnapshotMutableState;", "T", "Landroidx/compose/runtime/SnapshotMutableStateImpl;", "Landroid/os/Parcelable;", "value", "policy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "(Ljava/lang/Object;Landroidx/compose/runtime/SnapshotMutationPolicy;)V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ParcelableSnapshotMutableState<T>  extends androidx.compose.runtime.SnapshotMutableStateImpl<T> implements Parcelable {

    public static final int $stable = 0;
    public static final Parcelable.Creator<androidx.compose.runtime.ParcelableSnapshotMutableState<Object>> CREATOR = null;
    public static final androidx.compose.runtime.ParcelableSnapshotMutableState.Companion Companion = null;
    private static final int PolicyNeverEquals = 0;
    private static final int PolicyReferentialEquality = 2;
    private static final int PolicyStructuralEquality = 1;

    @Metadata(d1 = "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\u0010\u0012\u000c\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0006\u0010\u0002R\u000e\u0010\u0007\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0008X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b", d2 = {"Landroidx/compose/runtime/ParcelableSnapshotMutableState$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Landroidx/compose/runtime/ParcelableSnapshotMutableState;", "getCREATOR$annotations", "PolicyNeverEquals", "", "PolicyReferentialEquality", "PolicyStructuralEquality", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getCREATOR$annotations() {
        }
    }
    static {
        ParcelableSnapshotMutableState.Companion companion = new ParcelableSnapshotMutableState.Companion(0);
        ParcelableSnapshotMutableState.Companion = companion;
        ParcelableSnapshotMutableState.Companion.CREATOR.1 anon = new ParcelableSnapshotMutableState.Companion.CREATOR.1();
        ParcelableSnapshotMutableState.CREATOR = (Parcelable.Creator)anon;
    }

    public ParcelableSnapshotMutableState(T value, androidx.compose.runtime.SnapshotMutationPolicy<T> policy) {
        super(value, policy);
    }

    @Override // androidx.compose.runtime.SnapshotMutableStateImpl
    public int describeContents() {
        return 0;
    }

    @Override // androidx.compose.runtime.SnapshotMutableStateImpl
    public void writeToParcel(Parcel parcel, int flags) {
        int i;
        boolean referentialEqualityPolicy;
        parcel.writeValue(getValue());
        androidx.compose.runtime.SnapshotMutationPolicy policy = getPolicy();
        if (Intrinsics.areEqual(policy, SnapshotStateKt.neverEqualPolicy())) {
            i = 0;
            parcel.writeInt(i);
        } else {
            if (Intrinsics.areEqual(policy, SnapshotStateKt.structuralEqualityPolicy())) {
                i = 1;
            } else {
                if (!Intrinsics.areEqual(policy, SnapshotStateKt.referentialEqualityPolicy())) {
                } else {
                    i = 2;
                }
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException("Only known types of MutableState's SnapshotMutationPolicy are supported");
        throw illegalStateException;
    }
}
