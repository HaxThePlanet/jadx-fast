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

/* compiled from: GetDogParentsResponse.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001\u0018B\u001b\u0012\u0014\u0008\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0015\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001f\u0010\n\u001a\u00020\u00002\u0014\u0008\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0001J\t\u0010\u000b\u001a\u00020\u000cHÖ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u000cHÖ\u0001J\t\u0010\u0012\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000cHÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008¨\u0006\u0019", d2 = {"Lapp/dogo/externalmodel/model/responses/GetDogParentsResponse;", "Landroid/os/Parcelable;", "parents", "", "", "Lapp/dogo/externalmodel/model/responses/GetDogParentsResponse$DogParentData;", "(Ljava/util/Map;)V", "getParents", "()Ljava/util/Map;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "DogParentData", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class GetDogParentsResponse implements Parcelable {

    public static final Parcelable.Creator<GetDogParentsResponse> CREATOR = new GetDogParentsResponse$Creator<>();
    private final Map<String, GetDogParentsResponse.DogParentData> parents;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<GetDogParentsResponse> {
        @Override // android.os.Parcelable$Creator
        public final GetDogParentsResponse createFromParcel(Parcel parcel) {
            int i = 0;
            n.f(parcel, "parcel");
            int _int = parcel.readInt();
            final LinkedHashMap linkedHashMap = new LinkedHashMap(_int);
            i = 0;
            while (i != _int) {
                linkedHashMap.put(parcel.readString(), GetDogParentsResponse_DogParentData.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            return new GetDogParentsResponse(linkedHashMap);
        }

        @Override // android.os.Parcelable$Creator
        public final GetDogParentsResponse[] newArray(int i) {
            return new GetDogParentsResponse[i];
        }
    }

    @Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J)\u0010\u000f\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\t¨\u0006\u001c", d2 = {"Lapp/dogo/externalmodel/model/responses/GetDogParentsResponse$DogParentData;", "Landroid/os/Parcelable;", "id", "", "name", "isCreator", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "()Z", "getName", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class DogParentData implements Parcelable {

        public static final Parcelable.Creator<GetDogParentsResponse.DogParentData> CREATOR = new GetDogParentsResponse$DogParentData$Creator<>();
        private final String id;
        private final boolean isCreator;
        private final String name;
        public DogParentData(String str, String str2, boolean z) {
            n.f(str, "id");
            super();
            this.id = str;
            this.name = str2;
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

        public /* synthetic */ DogParentData(String str, String str2, boolean z, int i, g gVar) {
            String str3 = null;
            i = i & 2 != 0 ? 0 : i;
            this(str, str3, z);
        }


        public static /* synthetic */ GetDogParentsResponse.DogParentData copy$default(GetDogParentsResponse.DogParentData dogParentData, String str, String str2, boolean z, int i, Object object) {
            String id2;
            String name2;
            boolean isCreator2;
            if (i & 1 != 0) {
            }
            if (i & 2 != 0) {
            }
            if (i & 4 != 0) {
            }
            return dogParentData.copy(id2, name2, isCreator2);
        }

        /* operator */ public final String component1() {
            return this.id;
        }

        /* operator */ public final String component2() {
            return this.name;
        }

        /* operator */ public final boolean component3() {
            return this.isCreator;
        }

        public final GetDogParentsResponse.DogParentData copy(String id, String name, boolean isCreator) {
            n.f(id, "id");
            return new GetDogParentsResponse_DogParentData(id, name, isCreator);
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
            if (!(other instanceof GetDogParentsResponse_DogParentData)) {
                return false;
            }
            if (!n.b(this.id, other.id)) {
                return false;
            }
            if (!n.b(this.name, other.name)) {
                return false;
            }
            return this.isCreator != other.isCreator ? z5 : z;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int i = 0;
            boolean isCreator2 = true;
            if (this.name == null) {
                i = 0;
            } else {
                i = this.name.hashCode();
            }
            if (this.isCreator) {
                int i7 = 1;
            }
            return (this.id.hashCode() * 31) + i * 31 + isCreator2;
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "DogParentData(id=";
            String str3 = ", name=";
            String str4 = ", isCreator=";
            str = str2 + this.id + str3 + this.name + str4 + this.isCreator + 41;
            return str;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int flags) {
            n.f(parcel, "out");
            parcel.writeString(this.id);
            parcel.writeString(this.name);
            parcel.writeInt(this.isCreator);
        }
    }
    public GetDogParentsResponse(Map<String, GetDogParentsResponse.DogParentData> map) {
        n.f(map, "parents");
        super();
        this.parents = map;
    }

    public final Map<String, GetDogParentsResponse.DogParentData> getParents() {
        return this.parents;
    }

    public /* synthetic */ GetDogParentsResponse(Map map, int i, g gVar) {
        Map map2;
        if (i & 1 != 0) {
            map2 = j0.h();
        }
        this(map2);
    }


    public GetDogParentsResponse() {
        final Map map = null;
        this(map, 1, map);
    }

    public static /* synthetic */ GetDogParentsResponse copy$default(GetDogParentsResponse getDogParentsResponse, Map map, int i, Object object) {
        Map parents2;
        if (i & 1 != 0) {
        }
        return getDogParentsResponse.copy(parents2);
    }

    /* operator */ public final Map<String, GetDogParentsResponse.DogParentData> component1() {
        return this.parents;
    }

    public final GetDogParentsResponse copy(Map<String, GetDogParentsResponse.DogParentData> parents) {
        n.f(parents, "parents");
        return new GetDogParentsResponse(parents);
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
        final boolean z3 = false;
        if (!(other instanceof GetDogParentsResponse)) {
            return false;
        }
        return !n.b(this.parents, other.parents) ? z3 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.parents.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "GetDogParentsResponse(parents=";
        str = str2 + this.parents + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeInt(this.parents.size());
        Iterator it = this.parents.entrySet().iterator();
        while (it.hasNext()) {
            Object item = it.next();
            parcel.writeString((String)item.getKey());
            (GetDogParentsResponse_DogParentData)item.getValue().writeToParcel(parcel, flags);
        }
    }
}
