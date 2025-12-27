package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: DogParentUIState.kt */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001\u001bB\u001b\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0006HÆ\u0003J#\u0010\r\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0008R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/DogParentUIState;", "Landroid/os/Parcelable;", "parents", "", "Lapp/dogo/com/dogo_android/repository/domain/DogParentUIState$DogParent;", "isPremium", "", "(Ljava/util/List;Z)V", "()Z", "getParents", "()Ljava/util/List;", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "DogParent", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DogParentUIState implements Parcelable {

    public static final Parcelable.Creator<DogParentUIState> CREATOR = new DogParentUIState$Creator<>();
    private final boolean isPremium;
    private final List<DogParentUIState.DogParent> parents;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DogParentUIState> {
        @Override // android.os.Parcelable$Creator
        public final DogParentUIState createFromParcel(Parcel parcel) {
            boolean z = false;
            int i;
            n.f(parcel, "parcel");
            int _int = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int);
            while (i != _int) {
                arrayList.add(DogParentUIState_DogParent.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            if (parcel.readInt() != 0) {
                int i2 = 1;
            }
            return new DogParentUIState(arrayList, z);
        }

        @Override // android.os.Parcelable$Creator
        public final DogParentUIState[] newArray(int i) {
            return new DogParentUIState[i];
        }
    }

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\t¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/DogParentUIState$DogParent;", "Landroid/os/Parcelable;", "name", "", "id", "isCreator", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "()Z", "getName", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DogParent implements Parcelable {

        public static final Parcelable.Creator<DogParentUIState.DogParent> CREATOR = new DogParentUIState$DogParent$Creator<>();
        private final String id;
        private final boolean isCreator;
        private final String name;
        public DogParent(String str, String str2, boolean z) {
            n.f(str, "name");
            n.f(str2, "id");
            super();
            this.name = str;
            this.id = str2;
            this.isCreator = z;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final boolean isCreator() {
            return this.isCreator;
        }


        public static /* synthetic */ DogParentUIState.DogParent copy$default(DogParentUIState.DogParent dogParent, String str, String str2, boolean z, int i, Object object) {
            String name2;
            String id2;
            boolean isCreator2;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            if (i & 4 != 0) {
            }
            return dogParent.copy(name2, id2, isCreator2);
        }

        /* operator */ public final String component1() {
            return this.name;
        }

        /* operator */ public final String component2() {
            return this.id;
        }

        /* operator */ public final boolean component3() {
            return this.isCreator;
        }

        public final DogParentUIState.DogParent copy(String name, String id, boolean isCreator) {
            n.f(name, "name");
            n.f(id, "id");
            return new DogParentUIState_DogParent(name, id, isCreator);
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
            final boolean z5 = false;
            if (!(other instanceof DogParentUIState_DogParent)) {
                return false;
            }
            if (!n.b(this.name, other.name)) {
                return false;
            }
            if (!n.b(this.id, other.id)) {
                return false;
            }
            return this.isCreator != other.isCreator ? z5 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            boolean isCreator2 = true;
            if (this.isCreator) {
                int i7 = 1;
            }
            return (this.name.hashCode() * 31) + this.id.hashCode() * 31 + isCreator2;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "DogParent(name=";
            String str3 = ", id=";
            String str4 = ", isCreator=";
            str = str2 + this.name + str3 + this.id + str4 + this.isCreator + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.name);
            parcel.writeString(this.id);
            parcel.writeInt(this.isCreator);
        }
    }
    public DogParentUIState(List<DogParentUIState.DogParent> list, boolean z) {
        n.f(list, "parents");
        super();
        this.parents = list;
        this.isPremium = z;
    }

    public final List<DogParentUIState.DogParent> getParents() {
        return this.parents;
    }

    public final boolean isPremium() {
        return this.isPremium;
    }


    public static /* synthetic */ DogParentUIState copy$default(DogParentUIState dogParentUIState, List list, boolean z, int i, Object object) {
        List parents2;
        boolean isPremium2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        return dogParentUIState.copy(parents2, isPremium2);
    }

    /* operator */ public final List<DogParentUIState.DogParent> component1() {
        return this.parents;
    }

    /* operator */ public final boolean component2() {
        return this.isPremium;
    }

    public final DogParentUIState copy(List<DogParentUIState.DogParent> parents, boolean isPremium) {
        n.f(parents, "parents");
        return new DogParentUIState(parents, isPremium);
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
        if (!(other instanceof DogParentUIState)) {
            return false;
        }
        if (!n.b(this.parents, other.parents)) {
            return false;
        }
        return this.isPremium != other.isPremium ? z4 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean isPremium2 = true;
        if (this.isPremium) {
            int i4 = 1;
        }
        return (this.parents.hashCode() * 31) + isPremium2;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DogParentUIState(parents=";
        String str3 = ", isPremium=";
        str = str2 + this.parents + str3 + this.isPremium + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeInt(this.parents.size());
        Iterator it = this.parents.iterator();
        while (it.hasNext()) {
            (DogParentUIState_DogParent)it.next().writeToParcel(parcel, flags);
        }
        parcel.writeInt(this.isPremium);
    }
}
