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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J#\u0010\r\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u000e\u0008\u0002\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\u0008\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0017\u0010\u0004\u001a\u0008\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/TrickItemWithVariations;", "Landroid/os/Parcelable;", "coreTrick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "variations", "", "(Lapp/dogo/com/dogo_android/repository/domain/TrickItem;Ljava/util/List;)V", "getCoreTrick", "()Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "getVariations", "()Ljava/util/List;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TrickItemWithVariations implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.TrickItemWithVariations> CREATOR;
    private final app.dogo.com.dogo_android.repository.domain.TrickItem coreTrick;
    private final List<app.dogo.com.dogo_android.repository.domain.TrickItem> variations;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.TrickItemWithVariations> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.TrickItemWithVariations createFromParcel(Parcel parcel) {
            int i;
            Object fromParcel;
            n.f(parcel, "parcel");
            final int int = parcel.readInt();
            ArrayList arrayList = new ArrayList(int);
            i = 0;
            while (i != int) {
                arrayList.add(TrickItem.CREATOR.createFromParcel(parcel));
                i++;
            }
            TrickItemWithVariations obj6 = new TrickItemWithVariations((TrickItem)TrickItem.CREATOR.createFromParcel(parcel), arrayList);
            return obj6;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.TrickItemWithVariations[] newArray(int i) {
            return new TrickItemWithVariations[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        TrickItemWithVariations.Creator creator = new TrickItemWithVariations.Creator();
        TrickItemWithVariations.CREATOR = creator;
    }

    public TrickItemWithVariations(app.dogo.com.dogo_android.repository.domain.TrickItem trickItem, List<app.dogo.com.dogo_android.repository.domain.TrickItem> list2) {
        n.f(trickItem, "coreTrick");
        n.f(list2, "variations");
        super();
        this.coreTrick = trickItem;
        this.variations = list2;
    }

    public TrickItemWithVariations(app.dogo.com.dogo_android.repository.domain.TrickItem trickItem, List list2, int i3, g g4) {
        List obj2;
        if (i3 &= 2 != 0) {
            obj2 = p.g();
        }
        super(trickItem, obj2);
    }

    public static app.dogo.com.dogo_android.repository.domain.TrickItemWithVariations copy$default(app.dogo.com.dogo_android.repository.domain.TrickItemWithVariations trickItemWithVariations, app.dogo.com.dogo_android.repository.domain.TrickItem trickItem2, List list3, int i4, Object object5) {
        app.dogo.com.dogo_android.repository.domain.TrickItem obj1;
        List obj2;
        if (i4 & 1 != 0) {
            obj1 = trickItemWithVariations.coreTrick;
        }
        if (i4 &= 2 != 0) {
            obj2 = trickItemWithVariations.variations;
        }
        return trickItemWithVariations.copy(obj1, obj2);
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.TrickItem component1() {
        return this.coreTrick;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.TrickItem> component2() {
        return this.variations;
    }

    public final app.dogo.com.dogo_android.repository.domain.TrickItemWithVariations copy(app.dogo.com.dogo_android.repository.domain.TrickItem trickItem, List<app.dogo.com.dogo_android.repository.domain.TrickItem> list2) {
        n.f(trickItem, "coreTrick");
        n.f(list2, "variations");
        TrickItemWithVariations trickItemWithVariations = new TrickItemWithVariations(trickItem, list2);
        return trickItemWithVariations;
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
        if (!object instanceof TrickItemWithVariations) {
            return i2;
        }
        if (!n.b(this.coreTrick, object.coreTrick)) {
            return i2;
        }
        if (!n.b(this.variations, object.variations)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.TrickItem getCoreTrick() {
        return this.coreTrick;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.TrickItem> getVariations() {
        return this.variations;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i2 += i4;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("TrickItemWithVariations(coreTrick=");
        stringBuilder.append(this.coreTrick);
        stringBuilder.append(", variations=");
        stringBuilder.append(this.variations);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size;
        n.f(parcel, "out");
        this.coreTrick.writeToParcel(parcel, i2);
        List variations = this.variations;
        parcel.writeInt(variations.size());
        Iterator iterator = variations.iterator();
        for (TrickItem size : iterator) {
            size.writeToParcel(parcel, i2);
        }
    }
}
