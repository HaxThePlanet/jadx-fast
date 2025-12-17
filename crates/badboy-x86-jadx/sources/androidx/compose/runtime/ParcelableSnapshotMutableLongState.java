package androidx.compose.runtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0001\u0018\u0000 \r2\u00020\u00012\u00020\u0002:\u0001\rB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0008\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\u0008\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\u0007H\u0016¨\u0006\u000e", d2 = {"Landroidx/compose/runtime/ParcelableSnapshotMutableLongState;", "Landroidx/compose/runtime/SnapshotMutableLongStateImpl;", "Landroid/os/Parcelable;", "value", "", "(J)V", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ParcelableSnapshotMutableLongState extends androidx.compose.runtime.SnapshotMutableLongStateImpl implements Parcelable {

    public static final int $stable;
    public static final Parcelable.Creator<androidx.compose.runtime.ParcelableSnapshotMutableLongState> CREATOR;
    public static final androidx.compose.runtime.ParcelableSnapshotMutableLongState.Companion Companion;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0006\u0010\u0002¨\u0006\u0007", d2 = {"Landroidx/compose/runtime/ParcelableSnapshotMutableLongState$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Landroidx/compose/runtime/ParcelableSnapshotMutableLongState;", "getCREATOR$annotations", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getCREATOR$annotations() {
        }
    }
    static {
        ParcelableSnapshotMutableLongState.Companion companion = new ParcelableSnapshotMutableLongState.Companion(0);
        ParcelableSnapshotMutableLongState.Companion = companion;
        ParcelableSnapshotMutableLongState.Companion.CREATOR.1 anon = new ParcelableSnapshotMutableLongState.Companion.CREATOR.1();
        ParcelableSnapshotMutableLongState.CREATOR = (Parcelable.Creator)anon;
    }

    public ParcelableSnapshotMutableLongState(long value) {
        super(value, obj2);
    }

    @Override // androidx.compose.runtime.SnapshotMutableLongStateImpl
    public int describeContents() {
        return 0;
    }

    @Override // androidx.compose.runtime.SnapshotMutableLongStateImpl
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeLong(getLongValue());
    }
}
