package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: TrickCover.kt */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001 B#\u0012\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J)\u0010\u0012\u001a\u00020\u00002\n\u0008\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/TrickCover;", "Landroid/os/Parcelable;", "trickItem", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "undisplayedTrickCount", "", "coverType", "Lapp/dogo/com/dogo_android/repository/domain/TrickCover$CoverType;", "(Lapp/dogo/com/dogo_android/repository/domain/TrickItem;ILapp/dogo/com/dogo_android/repository/domain/TrickCover$CoverType;)V", "getCoverType", "()Lapp/dogo/com/dogo_android/repository/domain/TrickCover$CoverType;", "getTrickItem", "()Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "getUndisplayedTrickCount", "()I", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CoverType", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TrickCover implements Parcelable {

    public static final Parcelable.Creator<TrickCover> CREATOR = new TrickCover$Creator<>();
    private final TrickCover.CoverType coverType;
    private final TrickItem trickItem;
    private final int undisplayedTrickCount;

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/TrickCover$CoverType;", "", "(Ljava/lang/String;I)V", "UNDISPLAYED_TRICK", "TRICK", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum CoverType {

        TRICK,
        UNDISPLAYED_TRICK;
        private static final /* synthetic */ TrickCover.CoverType[] $values() {
            app.dogo.com.dogo_android.repository.domain.TrickCover.CoverType[] arr = new TrickCover.CoverType[2];
            return new TrickCover.CoverType[] { TrickCover_CoverType.UNDISPLAYED_TRICK, TrickCover_CoverType.TRICK };
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TrickCover> {
        @Override // android.os.Parcelable$Creator
        public final TrickCover createFromParcel(Parcel parcel) {
            app.dogo.com.dogo_android.repository.domain.TrickItem trickItem = null;
            n.f(parcel, "parcel");
            if (parcel.readInt() == 0) {
                int i = 0;
            } else {
                Object fromParcel = TrickItem.CREATOR.createFromParcel(parcel);
            }
            TrickCover trickCover = new TrickCover((TrickItem)trickItem, parcel.readInt(), TrickCover_CoverType.valueOf(parcel.readString()));
            return trickCover;
        }

        @Override // android.os.Parcelable$Creator
        public final TrickCover[] newArray(int i) {
            return new TrickCover[i];
        }
    }
    public TrickCover(TrickItem trickItem, int i, TrickCover.CoverType coverType) {
        n.f(coverType, "coverType");
        super();
        this.trickItem = trickItem;
        this.undisplayedTrickCount = i;
        this.coverType = coverType;
    }

    public final TrickCover.CoverType getCoverType() {
        return this.coverType;
    }

    public final TrickItem getTrickItem() {
        return this.trickItem;
    }

    public final int getUndisplayedTrickCount() {
        return this.undisplayedTrickCount;
    }

    public /* synthetic */ TrickCover(TrickItem trickItem, int i, TrickCover.CoverType coverType, int i2, g gVar) {
        app.dogo.com.dogo_android.repository.domain.TrickItem trickItem2 = null;
        int i3 = i2 & 1 != 0 ? 0 : i3;
        i = i2 & 2 != 0 ? 0 : i;
        this(trickItem2, i, coverType);
    }


    public static /* synthetic */ TrickCover copy$default(TrickCover trickCover, TrickItem trickItem, int i, TrickCover.CoverType coverType, int i2, Object object) {
        app.dogo.com.dogo_android.repository.domain.TrickItem trickItem22;
        int undisplayedTrickCount2;
        app.dogo.com.dogo_android.repository.domain.TrickCover.CoverType coverType2;
        if (i2 & 1 != 0) {
        }
        if (i2 & 2 != 0) {
        }
        if (i2 & 4 != 0) {
        }
        return trickCover.copy(trickItem22, undisplayedTrickCount2, coverType2);
    }

    /* operator */ public final TrickItem component1() {
        return this.trickItem;
    }

    /* operator */ public final int component2() {
        return this.undisplayedTrickCount;
    }

    /* operator */ public final TrickCover.CoverType component3() {
        return this.coverType;
    }

    public final TrickCover copy(TrickItem trickItem, int undisplayedTrickCount, TrickCover.CoverType coverType) {
        n.f(coverType, "coverType");
        return new TrickCover(trickItem, undisplayedTrickCount, coverType);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z4 = false;
        if (!(other instanceof TrickCover)) {
            return false;
        }
        if (!n.b(this.trickItem, other.trickItem)) {
            return false;
        }
        if (this.undisplayedTrickCount != other.undisplayedTrickCount) {
            return false;
        }
        return this.coverType != other.coverType ? z4 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 0;
        if (this.trickItem == null) {
            i = 0;
        } else {
            i = this.trickItem.hashCode();
        }
        return (i * 31) + Integer.hashCode(this.undisplayedTrickCount) * 31 + this.coverType.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "TrickCover(trickItem=";
        String str3 = ", undisplayedTrickCount=";
        String str4 = ", coverType=";
        str = str2 + this.trickItem + str3 + this.undisplayedTrickCount + str4 + this.coverType + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        if (this.trickItem == null) {
            int i2 = 0;
            parcel.writeInt(i2);
        } else {
            int i = 1;
            parcel.writeInt(i);
            this.trickItem.writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.undisplayedTrickCount);
        parcel.writeString(this.coverType.name());
    }
}
