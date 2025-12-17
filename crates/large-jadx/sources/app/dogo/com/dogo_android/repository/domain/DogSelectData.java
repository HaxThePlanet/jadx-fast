package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.h0.g;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001b\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\u0006\u0010\u0015\u001a\u00020\u0010J\t\u0010\u0016\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/DogSelectData;", "Landroid/os/Parcelable;", "dogList", "", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "currentDogId", "", "(Ljava/util/List;Ljava/lang/String;)V", "getCurrentDogId", "()Ljava/lang/String;", "getDogList", "()Ljava/util/List;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "getCurrentDogPosition", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DogSelectData implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.DogSelectData> CREATOR;
    private final String currentDogId;
    private final List<app.dogo.com.dogo_android.repository.domain.DogProfile> dogList;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.DogSelectData> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.DogSelectData createFromParcel(Parcel parcel) {
            int i;
            Object fromParcel;
            n.f(parcel, "parcel");
            int int = parcel.readInt();
            ArrayList arrayList = new ArrayList(int);
            i = 0;
            while (i != int) {
                arrayList.add(DogProfile.CREATOR.createFromParcel(parcel));
                i++;
            }
            DogSelectData dogSelectData = new DogSelectData(arrayList, parcel.readString());
            return dogSelectData;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.DogSelectData[] newArray(int i) {
            return new DogSelectData[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        DogSelectData.Creator creator = new DogSelectData.Creator();
        DogSelectData.CREATOR = creator;
    }

    public DogSelectData(List<app.dogo.com.dogo_android.repository.domain.DogProfile> list, String string2) {
        n.f(list, "dogList");
        n.f(string2, "currentDogId");
        super();
        this.dogList = list;
        this.currentDogId = string2;
    }

    public static app.dogo.com.dogo_android.repository.domain.DogSelectData copy$default(app.dogo.com.dogo_android.repository.domain.DogSelectData dogSelectData, List list2, String string3, int i4, Object object5) {
        List obj1;
        String obj2;
        if (i4 & 1 != 0) {
            obj1 = dogSelectData.dogList;
        }
        if (i4 &= 2 != 0) {
            obj2 = dogSelectData.currentDogId;
        }
        return dogSelectData.copy(obj1, obj2);
    }

    public final List<app.dogo.com.dogo_android.repository.domain.DogProfile> component1() {
        return this.dogList;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.currentDogId;
    }

    public final app.dogo.com.dogo_android.repository.domain.DogSelectData copy(List<app.dogo.com.dogo_android.repository.domain.DogProfile> list, String string2) {
        n.f(list, "dogList");
        n.f(string2, "currentDogId");
        DogSelectData dogSelectData = new DogSelectData(list, string2);
        return dogSelectData;
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
        if (object instanceof DogSelectData == null) {
            return i2;
        }
        if (!n.b(this.dogList, object.dogList)) {
            return i2;
        }
        if (!n.b(this.currentDogId, object.currentDogId)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final String getCurrentDogId() {
        return this.currentDogId;
    }

    @Override // android.os.Parcelable
    public final int getCurrentDogPosition() {
        int i;
        boolean next;
        String currentDogId;
        Iterator iterator = this.dogList.iterator();
        final int i3 = 0;
        i = i3;
        for (DogProfile next2 : iterator) {
            i++;
        }
        i = -1;
        return g.b(i, i3);
    }

    public final List<app.dogo.com.dogo_android.repository.domain.DogProfile> getDogList() {
        return this.dogList;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i2 += i4;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DogSelectData(dogList=");
        stringBuilder.append(this.dogList);
        stringBuilder.append(", currentDogId=");
        stringBuilder.append(this.currentDogId);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size;
        n.f(parcel, "out");
        List dogList = this.dogList;
        parcel.writeInt(dogList.size());
        Iterator iterator = dogList.iterator();
        for (DogProfile size : iterator) {
            size.writeToParcel(parcel, i2);
        }
        parcel.writeString(this.currentDogId);
    }
}
