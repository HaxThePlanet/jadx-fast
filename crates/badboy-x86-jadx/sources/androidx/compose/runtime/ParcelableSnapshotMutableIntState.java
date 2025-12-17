package androidx.compose.runtime;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0001\u0018\u0000 \u000c2\u00020\u00012\u00020\u0002:\u0001\u000cB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0008\u0010\u0006\u001a\u00020\u0004H\u0016J\u0018\u0010\u0007\u001a\u00020\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016¨\u0006\r", d2 = {"Landroidx/compose/runtime/ParcelableSnapshotMutableIntState;", "Landroidx/compose/runtime/SnapshotMutableIntStateImpl;", "Landroid/os/Parcelable;", "value", "", "(I)V", "describeContents", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ParcelableSnapshotMutableIntState extends androidx.compose.runtime.SnapshotMutableIntStateImpl implements Parcelable {

    public static final int $stable;
    public static final Parcelable.Creator<androidx.compose.runtime.ParcelableSnapshotMutableIntState> CREATOR;
    public static final androidx.compose.runtime.ParcelableSnapshotMutableIntState.Companion Companion;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0006\u0010\u0002¨\u0006\u0007", d2 = {"Landroidx/compose/runtime/ParcelableSnapshotMutableIntState$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Landroidx/compose/runtime/ParcelableSnapshotMutableIntState;", "getCREATOR$annotations", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getCREATOR$annotations() {
        }
    }
    static {
        ParcelableSnapshotMutableIntState.Companion companion = new ParcelableSnapshotMutableIntState.Companion(0);
        ParcelableSnapshotMutableIntState.Companion = companion;
        ParcelableSnapshotMutableIntState.Companion.CREATOR.1 anon = new ParcelableSnapshotMutableIntState.Companion.CREATOR.1();
        ParcelableSnapshotMutableIntState.CREATOR = (Parcelable.Creator)anon;
    }

    public ParcelableSnapshotMutableIntState(int value) {
        super(value);
    }

    @Override // androidx.compose.runtime.SnapshotMutableIntStateImpl
    public int describeContents() {
        return 0;
    }

    @Override // androidx.compose.runtime.SnapshotMutableIntStateImpl
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(getIntValue());
    }
}
