package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: TrickItemWithVariations.kt */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/TrickItemWithVariations;", "Landroid/os/Parcelable;", "coreTrick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "variations", "", "(Lapp/dogo/com/dogo_android/repository/domain/TrickItem;Ljava/util/List;)V", "getCoreTrick", "()Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "getVariations", "()Ljava/util/List;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TrickItemWithVariations implements Parcelable {

    public static final Parcelable.Creator<TrickItemWithVariations> CREATOR = new TrickItemWithVariations$Creator<>();
    private final TrickItem coreTrick;
    private final List<TrickItem> variations;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TrickItemWithVariations> {
        @Override // android.os.Parcelable$Creator
        public final TrickItemWithVariations createFromParcel(Parcel parcel) {
            int i = 0;
            n.f(parcel, "parcel");
            final int _int = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int);
            i = 0;
            while (i != _int) {
                arrayList.add(TrickItem.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            return new TrickItemWithVariations((TrickItem)TrickItem.CREATOR.createFromParcel(parcel), arrayList);
        }

        @Override // android.os.Parcelable$Creator
        public final TrickItemWithVariations[] newArray(int i) {
            return new TrickItemWithVariations[i];
        }
    }
    public TrickItemWithVariations(TrickItem trickItem, List<TrickItem> list) {
        n.f(trickItem, "coreTrick");
        n.f(list, "variations");
        super();
        this.coreTrick = trickItem;
        this.variations = list;
    }

    public final TrickItem getCoreTrick() {
        return this.coreTrick;
    }

    public final List<TrickItem> getVariations() {
        return this.variations;
    }

    public /* synthetic */ TrickItemWithVariations(TrickItem trickItem, List list, int i, g gVar) {
        if (i & 2 != 0) {
            list = p.g();
        }
        this(trickItem, list);
    }


    public static /* synthetic */ TrickItemWithVariations copy$default(TrickItemWithVariations trickItemWithVariations, TrickItem trickItem, List list, int i, Object object) {
        app.dogo.com.dogo_android.repository.domain.TrickItem coreTrick2;
        List variations2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        return trickItemWithVariations.copy(coreTrick2, variations2);
    }

    /* operator */ public final TrickItem component1() {
        return this.coreTrick;
    }

    /* operator */ public final List<TrickItem> component2() {
        return this.variations;
    }

    public final TrickItemWithVariations copy(TrickItem coreTrick, List<TrickItem> variations) {
        n.f(coreTrick, "coreTrick");
        n.f(variations, "variations");
        return new TrickItemWithVariations(coreTrick, variations);
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
        if (!(other instanceof TrickItemWithVariations)) {
            return false;
        }
        if (!n.b(this.coreTrick, other.coreTrick)) {
            return false;
        }
        return !n.b(this.variations, other.variations) ? z4 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.coreTrick.hashCode() * 31) + this.variations.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "TrickItemWithVariations(coreTrick=";
        String str3 = ", variations=";
        str = str2 + this.coreTrick + str3 + this.variations + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        this.coreTrick.writeToParcel(parcel, flags);
        parcel.writeInt(this.variations.size());
        Iterator it = this.variations.iterator();
        while (it.hasNext()) {
            (TrickItem)it.next().writeToParcel(parcel, flags);
        }
    }
}
