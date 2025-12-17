package androidx.compose.foundation.lazy.layout;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0083\u0008\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0008\u0010\u0007\u001a\u00020\u0003H\u0016J\u0013\u0010\u0008\u001a\u00020\t2\u0008\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\u000c\u001a\u00020\u0003HÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015", d2 = {"Landroidx/compose/foundation/lazy/layout/DefaultLazyKey;", "Landroid/os/Parcelable;", "index", "", "(I)V", "component1", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
final class DefaultLazyKey implements Parcelable {

    public static final Parcelable.Creator<androidx.compose.foundation.lazy.layout.DefaultLazyKey> CREATOR;
    public static final androidx.compose.foundation.lazy.layout.DefaultLazyKey.Companion Companion;
    private final int index;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0008\n\u0000\u0012\u0004\u0008\u0006\u0010\u0002¨\u0006\u0007", d2 = {"Landroidx/compose/foundation/lazy/layout/DefaultLazyKey$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Landroidx/compose/foundation/lazy/layout/DefaultLazyKey;", "getCREATOR$annotations", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
            super();
        }

        public static void getCREATOR$annotations() {
        }
    }
    static {
        DefaultLazyKey.Companion companion = new DefaultLazyKey.Companion(0);
        DefaultLazyKey.Companion = companion;
        DefaultLazyKey.Companion.CREATOR.1 anon = new DefaultLazyKey.Companion.CREATOR.1();
        DefaultLazyKey.CREATOR = (Parcelable.Creator)anon;
    }

    public DefaultLazyKey(int index) {
        super();
        this.index = index;
    }

    private final int component1() {
        return this.index;
    }

    public static androidx.compose.foundation.lazy.layout.DefaultLazyKey copy$default(androidx.compose.foundation.lazy.layout.DefaultLazyKey defaultLazyKey, int i2, int i3, Object object4) {
        int obj1;
        if (i3 &= 1 != 0) {
            obj1 = defaultLazyKey.index;
        }
        return defaultLazyKey.copy(obj1);
    }

    @Override // android.os.Parcelable
    public final androidx.compose.foundation.lazy.layout.DefaultLazyKey copy(int i) {
        DefaultLazyKey defaultLazyKey = new DefaultLazyKey(i);
        return defaultLazyKey;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof DefaultLazyKey) {
            return i2;
        }
        if (this.index != obj.index) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return Integer.hashCode(this.index);
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append("DefaultLazyKey(index=").append(this.index).append(')').toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeInt(this.index);
    }
}
