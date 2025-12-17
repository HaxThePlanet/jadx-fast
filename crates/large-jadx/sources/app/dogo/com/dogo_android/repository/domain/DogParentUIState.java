package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001\u001bB\u001b\u0012\u000c\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\u000b\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0006HÆ\u0003J#\u0010\r\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0008R\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\n¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/DogParentUIState;", "Landroid/os/Parcelable;", "parents", "", "Lapp/dogo/com/dogo_android/repository/domain/DogParentUIState$DogParent;", "isPremium", "", "(Ljava/util/List;Z)V", "()Z", "getParents", "()Ljava/util/List;", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "DogParent", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DogParentUIState implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.DogParentUIState> CREATOR;
    private final boolean isPremium;
    private final List<app.dogo.com.dogo_android.repository.domain.DogParentUIState.DogParent> parents;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.DogParentUIState> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.DogParentUIState createFromParcel(Parcel parcel) {
            int i2;
            int i;
            Object fromParcel;
            n.f(parcel, "parcel");
            int int = parcel.readInt();
            ArrayList arrayList = new ArrayList(int);
            i = i2;
            while (i != int) {
                arrayList.add(DogParentUIState.DogParent.CREATOR.createFromParcel(parcel));
                i++;
            }
            if (parcel.readInt() != 0) {
                i2 = 1;
            }
            DogParentUIState obj6 = new DogParentUIState(arrayList, i2);
            return obj6;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.DogParentUIState[] newArray(int i) {
            return new DogParentUIState[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\t¨\u0006\u001c", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/DogParentUIState$DogParent;", "Landroid/os/Parcelable;", "name", "", "id", "isCreator", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "()Z", "getName", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DogParent implements Parcelable {

        public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.DogParentUIState.DogParent> CREATOR;
        private final String id;
        private final boolean isCreator;
        private final String name;
        static {
            DogParentUIState.DogParent.Creator creator = new DogParentUIState.DogParent.Creator();
            DogParentUIState.DogParent.CREATOR = creator;
        }

        public DogParent(String string, String string2, boolean z3) {
            n.f(string, "name");
            n.f(string2, "id");
            super();
            this.name = string;
            this.id = string2;
            this.isCreator = z3;
        }

        public static app.dogo.com.dogo_android.repository.domain.DogParentUIState.DogParent copy$default(app.dogo.com.dogo_android.repository.domain.DogParentUIState.DogParent dogParentUIState$DogParent, String string2, String string3, boolean z4, int i5, Object object6) {
            String obj1;
            String obj2;
            boolean obj3;
            if (i5 & 1 != 0) {
                obj1 = dogParent.name;
            }
            if (i5 & 2 != 0) {
                obj2 = dogParent.id;
            }
            if (i5 &= 4 != 0) {
                obj3 = dogParent.isCreator;
            }
            return dogParent.copy(obj1, obj2, obj3);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.name;
        }

        @Override // android.os.Parcelable
        public final String component2() {
            return this.id;
        }

        @Override // android.os.Parcelable
        public final boolean component3() {
            return this.isCreator;
        }

        @Override // android.os.Parcelable
        public final app.dogo.com.dogo_android.repository.domain.DogParentUIState.DogParent copy(String string, String string2, boolean z3) {
            n.f(string, "name");
            n.f(string2, "id");
            DogParentUIState.DogParent dogParent = new DogParentUIState.DogParent(string, string2, z3);
            return dogParent;
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
            if (!object instanceof DogParentUIState.DogParent) {
                return i2;
            }
            if (!n.b(this.name, object.name)) {
                return i2;
            }
            if (!n.b(this.id, object.id)) {
                return i2;
            }
            if (this.isCreator != object.isCreator) {
                return i2;
            }
            return i;
        }

        @Override // android.os.Parcelable
        public final String getId() {
            return this.id;
        }

        @Override // android.os.Parcelable
        public final String getName() {
            return this.name;
        }

        @Override // android.os.Parcelable
        public int hashCode() {
            boolean isCreator;
            if (this.isCreator) {
                isCreator = 1;
            }
            return i4 += isCreator;
        }

        @Override // android.os.Parcelable
        public final boolean isCreator() {
            return this.isCreator;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DogParent(name=");
            stringBuilder.append(this.name);
            stringBuilder.append(", id=");
            stringBuilder.append(this.id);
            stringBuilder.append(", isCreator=");
            stringBuilder.append(this.isCreator);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeString(this.name);
            parcel.writeString(this.id);
            parcel.writeInt(this.isCreator);
        }
    }
    static {
        DogParentUIState.Creator creator = new DogParentUIState.Creator();
        DogParentUIState.CREATOR = creator;
    }

    public DogParentUIState(List<app.dogo.com.dogo_android.repository.domain.DogParentUIState.DogParent> list, boolean z2) {
        n.f(list, "parents");
        super();
        this.parents = list;
        this.isPremium = z2;
    }

    public static app.dogo.com.dogo_android.repository.domain.DogParentUIState copy$default(app.dogo.com.dogo_android.repository.domain.DogParentUIState dogParentUIState, List list2, boolean z3, int i4, Object object5) {
        List obj1;
        boolean obj2;
        if (i4 & 1 != 0) {
            obj1 = dogParentUIState.parents;
        }
        if (i4 &= 2 != 0) {
            obj2 = dogParentUIState.isPremium;
        }
        return dogParentUIState.copy(obj1, obj2);
    }

    public final List<app.dogo.com.dogo_android.repository.domain.DogParentUIState.DogParent> component1() {
        return this.parents;
    }

    @Override // android.os.Parcelable
    public final boolean component2() {
        return this.isPremium;
    }

    public final app.dogo.com.dogo_android.repository.domain.DogParentUIState copy(List<app.dogo.com.dogo_android.repository.domain.DogParentUIState.DogParent> list, boolean z2) {
        n.f(list, "parents");
        DogParentUIState dogParentUIState = new DogParentUIState(list, z2);
        return dogParentUIState;
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
        if (!object instanceof DogParentUIState) {
            return i2;
        }
        if (!n.b(this.parents, object.parents)) {
            return i2;
        }
        if (this.isPremium != object.isPremium) {
            return i2;
        }
        return i;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.DogParentUIState.DogParent> getParents() {
        return this.parents;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        boolean isPremium;
        if (this.isPremium) {
            isPremium = 1;
        }
        return i2 += isPremium;
    }

    @Override // android.os.Parcelable
    public final boolean isPremium() {
        return this.isPremium;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DogParentUIState(parents=");
        stringBuilder.append(this.parents);
        stringBuilder.append(", isPremium=");
        stringBuilder.append(this.isPremium);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size;
        n.f(parcel, "out");
        List parents = this.parents;
        parcel.writeInt(parents.size());
        Iterator iterator = parents.iterator();
        for (DogParentUIState.DogParent size : iterator) {
            size.writeToParcel(parcel, i2);
        }
        parcel.writeInt(this.isPremium);
    }
}
