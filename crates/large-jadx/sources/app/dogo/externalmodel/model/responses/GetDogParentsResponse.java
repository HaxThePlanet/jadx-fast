package app.dogo.externalmodel.model.responses;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.j0;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001\u0018B\u001b\u0012\u0014\u0008\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\n\u001a\u00020\u00002\u0014\u0008\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\t\u0010\u000b\u001a\u00020\u000cHÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u000cHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000cHÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0019", d2 = {"Lapp/dogo/externalmodel/model/responses/GetDogParentsResponse;", "Landroid/os/Parcelable;", "parents", "", "", "Lapp/dogo/externalmodel/model/responses/GetDogParentsResponse$DogParentData;", "(Ljava/util/Map;)V", "getParents", "()Ljava/util/Map;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "DogParentData", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GetDogParentsResponse implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.GetDogParentsResponse> CREATOR;
    private final Map<String, app.dogo.externalmodel.model.responses.GetDogParentsResponse.DogParentData> parents;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.responses.GetDogParentsResponse> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.GetDogParentsResponse createFromParcel(Parcel parcel) {
            int i;
            String string;
            Object fromParcel;
            n.f(parcel, "parcel");
            int int = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(int);
            i = 0;
            while (i != int) {
                linkedHashMap.put(parcel.readString(), GetDogParentsResponse.DogParentData.CREATOR.createFromParcel(parcel));
                i++;
            }
            GetDogParentsResponse obj6 = new GetDogParentsResponse(linkedHashMap);
            return obj6;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.responses.GetDogParentsResponse[] newArray(int i) {
            return new GetDogParentsResponse[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\t¨\u0006\u001c", d2 = {"Lapp/dogo/externalmodel/model/responses/GetDogParentsResponse$DogParentData;", "Landroid/os/Parcelable;", "id", "", "name", "isCreator", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "()Z", "getName", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DogParentData implements Parcelable {

        public static final Parcelable.Creator<app.dogo.externalmodel.model.responses.GetDogParentsResponse.DogParentData> CREATOR;
        private final String id;
        private final boolean isCreator;
        private final String name;
        static {
            GetDogParentsResponse.DogParentData.Creator creator = new GetDogParentsResponse.DogParentData.Creator();
            GetDogParentsResponse.DogParentData.CREATOR = creator;
        }

        public DogParentData(String string, String string2, boolean z3) {
            n.f(string, "id");
            super();
            this.id = string;
            this.name = string2;
            this.isCreator = z3;
        }

        public DogParentData(String string, String string2, boolean z3, int i4, g g5) {
            int obj2;
            obj2 = i4 &= 2 != 0 ? 0 : obj2;
            super(string, obj2, z3);
        }

        public static app.dogo.externalmodel.model.responses.GetDogParentsResponse.DogParentData copy$default(app.dogo.externalmodel.model.responses.GetDogParentsResponse.DogParentData getDogParentsResponse$DogParentData, String string2, String string3, boolean z4, int i5, Object object6) {
            String obj1;
            String obj2;
            boolean obj3;
            if (i5 & 1 != 0) {
                obj1 = dogParentData.id;
            }
            if (i5 & 2 != 0) {
                obj2 = dogParentData.name;
            }
            if (i5 &= 4 != 0) {
                obj3 = dogParentData.isCreator;
            }
            return dogParentData.copy(obj1, obj2, obj3);
        }

        @Override // android.os.Parcelable
        public final String component1() {
            return this.id;
        }

        @Override // android.os.Parcelable
        public final String component2() {
            return this.name;
        }

        @Override // android.os.Parcelable
        public final boolean component3() {
            return this.isCreator;
        }

        @Override // android.os.Parcelable
        public final app.dogo.externalmodel.model.responses.GetDogParentsResponse.DogParentData copy(String string, String string2, boolean z3) {
            n.f(string, "id");
            GetDogParentsResponse.DogParentData dogParentData = new GetDogParentsResponse.DogParentData(string, string2, z3);
            return dogParentData;
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
            if (object instanceof GetDogParentsResponse.DogParentData == null) {
                return i2;
            }
            if (!n.b(this.id, object.id)) {
                return i2;
            }
            if (!n.b(this.name, object.name)) {
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
            int i;
            boolean isCreator;
            String name = this.name;
            if (name == null) {
                i = 0;
            } else {
                i = name.hashCode();
            }
            if (this.isCreator) {
                isCreator = 1;
            }
            return i5 += isCreator;
        }

        @Override // android.os.Parcelable
        public final boolean isCreator() {
            return this.isCreator;
        }

        @Override // android.os.Parcelable
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("DogParentData(id=");
            stringBuilder.append(this.id);
            stringBuilder.append(", name=");
            stringBuilder.append(this.name);
            stringBuilder.append(", isCreator=");
            stringBuilder.append(this.isCreator);
            stringBuilder.append(')');
            return stringBuilder.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            n.f(parcel, "out");
            parcel.writeString(this.id);
            parcel.writeString(this.name);
            parcel.writeInt(this.isCreator);
        }
    }
    static {
        GetDogParentsResponse.Creator creator = new GetDogParentsResponse.Creator();
        GetDogParentsResponse.CREATOR = creator;
    }

    public GetDogParentsResponse() {
        final int i = 0;
        super(i, 1, i);
    }

    public GetDogParentsResponse(Map<String, app.dogo.externalmodel.model.responses.GetDogParentsResponse.DogParentData> map) {
        n.f(map, "parents");
        super();
        this.parents = map;
    }

    public GetDogParentsResponse(Map map, int i2, g g3) {
        Map obj1;
        if (i2 &= 1 != 0) {
            obj1 = j0.h();
        }
        super(obj1);
    }

    public static app.dogo.externalmodel.model.responses.GetDogParentsResponse copy$default(app.dogo.externalmodel.model.responses.GetDogParentsResponse getDogParentsResponse, Map map2, int i3, Object object4) {
        Map obj1;
        if (i3 &= 1 != 0) {
            obj1 = getDogParentsResponse.parents;
        }
        return getDogParentsResponse.copy(obj1);
    }

    public final Map<String, app.dogo.externalmodel.model.responses.GetDogParentsResponse.DogParentData> component1() {
        return this.parents;
    }

    public final app.dogo.externalmodel.model.responses.GetDogParentsResponse copy(Map<String, app.dogo.externalmodel.model.responses.GetDogParentsResponse.DogParentData> map) {
        n.f(map, "parents");
        GetDogParentsResponse getDogParentsResponse = new GetDogParentsResponse(map);
        return getDogParentsResponse;
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
        if (object instanceof GetDogParentsResponse == null) {
            return i2;
        }
        if (!n.b(this.parents, object.parents)) {
            return i2;
        }
        return i;
    }

    public final Map<String, app.dogo.externalmodel.model.responses.GetDogParentsResponse.DogParentData> getParents() {
        return this.parents;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return this.parents.hashCode();
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GetDogParentsResponse(parents=");
        stringBuilder.append(this.parents);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int value;
        Object key;
        n.f(parcel, "out");
        Map parents = this.parents;
        parcel.writeInt(parents.size());
        Iterator iterator = parents.entrySet().iterator();
        for (Map.Entry next2 : iterator) {
            parcel.writeString((String)next2.getKey());
            (GetDogParentsResponse.DogParentData)next2.getValue().writeToParcel(parcel, i2);
        }
    }
}
