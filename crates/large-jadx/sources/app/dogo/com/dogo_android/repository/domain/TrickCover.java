package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001 B#\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/TrickCover;", "Landroid/os/Parcelable;", "trickItem", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "undisplayedTrickCount", "", "coverType", "Lapp/dogo/com/dogo_android/repository/domain/TrickCover$CoverType;", "(Lapp/dogo/com/dogo_android/repository/domain/TrickItem;ILapp/dogo/com/dogo_android/repository/domain/TrickCover$CoverType;)V", "getCoverType", "()Lapp/dogo/com/dogo_android/repository/domain/TrickCover$CoverType;", "getTrickItem", "()Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "getUndisplayedTrickCount", "()I", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CoverType", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TrickCover implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.TrickCover> CREATOR;
    private final app.dogo.com.dogo_android.repository.domain.TrickCover.CoverType coverType;
    private final app.dogo.com.dogo_android.repository.domain.TrickItem trickItem;
    private final int undisplayedTrickCount;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/TrickCover$CoverType;", "", "(Ljava/lang/String;I)V", "UNDISPLAYED_TRICK", "TRICK", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum CoverType {

        UNDISPLAYED_TRICK,
        TRICK;
        private static final app.dogo.com.dogo_android.repository.domain.TrickCover.CoverType[] $values() {
            app.dogo.com.dogo_android.repository.domain.TrickCover.CoverType[] arr = new TrickCover.CoverType[2];
            return arr;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.TrickCover> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.TrickCover createFromParcel(Parcel parcel) {
            int fromParcel;
            n.f(parcel, "parcel");
            if (parcel.readInt() == 0) {
                fromParcel = 0;
            } else {
                fromParcel = TrickItem.CREATOR.createFromParcel(parcel);
            }
            TrickCover trickCover = new TrickCover((TrickItem)fromParcel, parcel.readInt(), TrickCover.CoverType.valueOf(parcel.readString()));
            return trickCover;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.TrickCover[] newArray(int i) {
            return new TrickCover[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        TrickCover.Creator creator = new TrickCover.Creator();
        TrickCover.CREATOR = creator;
    }

    public TrickCover(app.dogo.com.dogo_android.repository.domain.TrickItem trickItem, int i2, app.dogo.com.dogo_android.repository.domain.TrickCover.CoverType trickCover$CoverType3) {
        n.f(coverType3, "coverType");
        super();
        this.trickItem = trickItem;
        this.undisplayedTrickCount = i2;
        this.coverType = coverType3;
    }

    public TrickCover(app.dogo.com.dogo_android.repository.domain.TrickItem trickItem, int i2, app.dogo.com.dogo_android.repository.domain.TrickCover.CoverType trickCover$CoverType3, int i4, g g5) {
        int obj1;
        int obj2;
        obj1 = i4 & 1 != 0 ? 0 : obj1;
        obj2 = i4 &= 2 != 0 ? 0 : obj2;
        super(obj1, obj2, coverType3);
    }

    public static app.dogo.com.dogo_android.repository.domain.TrickCover copy$default(app.dogo.com.dogo_android.repository.domain.TrickCover trickCover, app.dogo.com.dogo_android.repository.domain.TrickItem trickItem2, int i3, app.dogo.com.dogo_android.repository.domain.TrickCover.CoverType trickCover$CoverType4, int i5, Object object6) {
        app.dogo.com.dogo_android.repository.domain.TrickItem obj1;
        int obj2;
        app.dogo.com.dogo_android.repository.domain.TrickCover.CoverType obj3;
        if (i5 & 1 != 0) {
            obj1 = trickCover.trickItem;
        }
        if (i5 & 2 != 0) {
            obj2 = trickCover.undisplayedTrickCount;
        }
        if (i5 &= 4 != 0) {
            obj3 = trickCover.coverType;
        }
        return trickCover.copy(obj1, obj2, obj3);
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.TrickItem component1() {
        return this.trickItem;
    }

    @Override // android.os.Parcelable
    public final int component2() {
        return this.undisplayedTrickCount;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.TrickCover.CoverType component3() {
        return this.coverType;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.TrickCover copy(app.dogo.com.dogo_android.repository.domain.TrickItem trickItem, int i2, app.dogo.com.dogo_android.repository.domain.TrickCover.CoverType trickCover$CoverType3) {
        n.f(coverType3, "coverType");
        TrickCover trickCover = new TrickCover(trickItem, i2, coverType3);
        return trickCover;
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
        if (!object instanceof TrickCover) {
            return i2;
        }
        if (!n.b(this.trickItem, object.trickItem)) {
            return i2;
        }
        if (this.undisplayedTrickCount != object.undisplayedTrickCount) {
            return i2;
        }
        if (this.coverType != object.coverType) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.TrickCover.CoverType getCoverType() {
        return this.coverType;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.TrickItem getTrickItem() {
        return this.trickItem;
    }

    @Override // android.os.Parcelable
    public final int getUndisplayedTrickCount() {
        return this.undisplayedTrickCount;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        int i;
        app.dogo.com.dogo_android.repository.domain.TrickItem trickItem = this.trickItem;
        if (trickItem == null) {
            i = 0;
        } else {
            i = trickItem.hashCode();
        }
        return i4 += i7;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrickCover(trickItem=");
        stringBuilder.append(this.trickItem);
        stringBuilder.append(", undisplayedTrickCount=");
        stringBuilder.append(this.undisplayedTrickCount);
        stringBuilder.append(", coverType=");
        stringBuilder.append(this.coverType);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int i;
        int obj4;
        n.f(parcel, "out");
        app.dogo.com.dogo_android.repository.domain.TrickItem trickItem = this.trickItem;
        if (trickItem == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            trickItem.writeToParcel(parcel, i2);
        }
        parcel.writeInt(this.undisplayedTrickCount);
        parcel.writeString(this.coverType.name());
    }
}
