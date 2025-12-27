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

/* compiled from: DogSelectData.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001b\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\u0006\u0010\u0015\u001a\u00020\u0010J\t\u0010\u0016\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000b¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/DogSelectData;", "Landroid/os/Parcelable;", "dogList", "", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "currentDogId", "", "(Ljava/util/List;Ljava/lang/String;)V", "getCurrentDogId", "()Ljava/lang/String;", "getDogList", "()Ljava/util/List;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "getCurrentDogPosition", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DogSelectData implements Parcelable {

    public static final Parcelable.Creator<DogSelectData> CREATOR = new DogSelectData$Creator<>();
    private final String currentDogId;
    private final List<DogProfile> dogList;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DogSelectData> {
        @Override // android.os.Parcelable$Creator
        public final DogSelectData createFromParcel(Parcel parcel) {
            int i = 0;
            n.f(parcel, "parcel");
            int _int = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int);
            i = 0;
            while (i != _int) {
                arrayList.add(DogProfile.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            return new DogSelectData(arrayList, parcel.readString());
        }

        @Override // android.os.Parcelable$Creator
        public final DogSelectData[] newArray(int i) {
            return new DogSelectData[i];
        }
    }
    public DogSelectData(List<DogProfile> list, String str) {
        n.f(list, "dogList");
        n.f(str, "currentDogId");
        super();
        this.dogList = list;
        this.currentDogId = str;
    }

    public final String getCurrentDogId() {
        return this.currentDogId;
    }

    public final int getCurrentDogPosition() {
        int i;
        String currentDogId;
        Iterator it = this.dogList.iterator();
        i = 0;
        while (it.hasNext()) {
            if (n.b((DogProfile)it.next().getId(), getCurrentDogId()) != null) {
                break;
            }
        }
        i = -1;
        return g.b(i, i);
    }

    public final List<DogProfile> getDogList() {
        return this.dogList;
    }


    public static /* synthetic */ DogSelectData copy$default(DogSelectData dogSelectData, List list, String str, int i, Object object) {
        List dogList2;
        String currentDogId2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        return dogSelectData.copy(dogList2, currentDogId2);
    }

    /* operator */ public final List<DogProfile> component1() {
        return this.dogList;
    }

    /* operator */ public final String component2() {
        return this.currentDogId;
    }

    public final DogSelectData copy(List<DogProfile> dogList, String currentDogId) {
        n.f(dogList, "dogList");
        n.f(currentDogId, "currentDogId");
        return new DogSelectData(dogList, currentDogId);
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
        if (!(other instanceof DogSelectData)) {
            return false;
        }
        if (!n.b(this.dogList, other.dogList)) {
            return false;
        }
        return !n.b(this.currentDogId, other.currentDogId) ? z4 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.dogList.hashCode() * 31) + this.currentDogId.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DogSelectData(dogList=";
        String str3 = ", currentDogId=";
        str = str2 + this.dogList + str3 + this.currentDogId + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeInt(this.dogList.size());
        Iterator it = this.dogList.iterator();
        while (it.hasNext()) {
            (DogProfile)it.next().writeToParcel(parcel, flags);
        }
        parcel.writeString(this.currentDogId);
    }
}
