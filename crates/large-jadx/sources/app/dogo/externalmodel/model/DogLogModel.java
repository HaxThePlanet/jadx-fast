package app.dogo.externalmodel.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: DogLogModel.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0015\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001BK\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0008¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0008HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0008HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0008HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00082\u0008\u0008\u0002\u0010\n\u001a\u00020\u0008HÆ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0013\u0010\u001f\u001a\u00020 2\u0008\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u001eHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\t\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u000f¨\u0006*", d2 = {"Lapp/dogo/externalmodel/model/DogLogModel;", "Landroid/os/Parcelable;", "id", "", "userId", "dogId", "type", "eventTimeMs", "", "createTimeMs", "updateTimeMs", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJ)V", "getCreateTimeMs", "()J", "getDogId", "()Ljava/lang/String;", "getEventTimeMs", "getId", "getType", "getUpdateTimeMs", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DogLogModel implements Parcelable {

    public static final Parcelable.Creator<DogLogModel> CREATOR = new DogLogModel$Creator<>();
    private final long createTimeMs;
    private final String dogId;
    private final long eventTimeMs;
    private final String id;
    private final String type;
    private final long updateTimeMs;
    private final String userId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DogLogModel> {
        @Override // android.os.Parcelable$Creator
        public final DogLogModel createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            DogLogModel dogLogModel = new DogLogModel(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), l, parcel.readLong(), obj, parcel.readLong(), obj2);
            return dogLogModel;
        }

        @Override // android.os.Parcelable$Creator
        public final DogLogModel[] newArray(int i) {
            return new DogLogModel[i];
        }
    }
    public DogLogModel(String str, String str2, String str3, String str4, long j, long j2, long j3) {
        n.f(str, "id");
        n.f(str2, "userId");
        n.f(str3, "dogId");
        n.f(str4, "type");
        super();
        this.id = str;
        this.userId = str2;
        this.dogId = str3;
        this.type = str4;
        this.eventTimeMs = j;
        this.createTimeMs = j2;
        this.updateTimeMs = j3;
    }

    public final long getCreateTimeMs() {
        return this.createTimeMs;
    }

    public final String getDogId() {
        return this.dogId;
    }

    public final long getEventTimeMs() {
        return this.eventTimeMs;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final long getUpdateTimeMs() {
        return this.updateTimeMs;
    }

    public final String getUserId() {
        return this.userId;
    }

    public /* synthetic */ DogLogModel(String str, String str2, String str3, String str4, long j, long j2, long j3, int i, g gVar) {
        String str5;
        int gVar92 = 0;
        long j72;
        str5 = "";
        String r0 = i & 1 != 0 ? str5 : str;
        String r2 = i & 2 != 0 ? str5 : str2;
        String r3 = i & 4 != 0 ? str5 : str3;
        if (i & 8 == 0) {
            str5 = str4;
        }
        gVar92 = 0;
        int r7 = i & 16 != 0 ? gVar92 : j;
        int r9 = i & 32 != 0 ? gVar92 : j2;
        if (i & 64 == 0) {
            gVar92 = j3;
        }
        this(str5, str5, str5, str5, gVar92, j2, j72, j3, gVar92, i);
    }


    public DogLogModel() {
        this(null, null, null, null, 0L, l, 0L, i7, null, obj2, 127, 0);
    }

    public static /* synthetic */ DogLogModel copy$default(DogLogModel dogLogModel, String str, String str2, String str3, String str4, long j, long j2, long j3, int i, Object object) {
        String str22;
        String str32;
        String str42;
        String str52;
        long j62;
        long j82;
        long object102;
        Object dogLogModel2 = dogLogModel;
        String r1 = i & 1 != 0 ? dogLogModel2.id : str;
        String r2 = i & 2 != 0 ? dogLogModel2.userId : str2;
        String r3 = i & 4 != 0 ? dogLogModel2.dogId : str3;
        String r4 = i & 8 != 0 ? dogLogModel2.type : str4;
        long r5 = i & 16 != 0 ? dogLogModel2.eventTimeMs : j;
        long r7 = i & 32 != 0 ? dogLogModel2.createTimeMs : j2;
        long r9 = i & 64 != 0 ? dogLogModel2.updateTimeMs : j3;
        return dogLogModel.copy(str22, str32, str42, str52, j62, r17, j82, r19, (i & 64 != 0 ? dogLogModel2.updateTimeMs : j3), r21);
    }

    /* operator */ public final String component1() {
        return this.id;
    }

    /* operator */ public final String component2() {
        return this.userId;
    }

    /* operator */ public final String component3() {
        return this.dogId;
    }

    /* operator */ public final String component4() {
        return this.type;
    }

    /* operator */ public final long component5() {
        return this.eventTimeMs;
    }

    /* operator */ public final long component6() {
        return this.createTimeMs;
    }

    /* operator */ public final long component7() {
        return this.updateTimeMs;
    }

    public final DogLogModel copy(String id, String userId, String dogId, String type, long eventTimeMs, long createTimeMs, long updateTimeMs) {
        n.f(id, "id");
        n.f(userId, "userId");
        n.f(dogId, "dogId");
        final Object type2 = type;
        n.f(type2, "type");
        DogLogModel dogLogModel = new DogLogModel(id, userId, dogId, type2, eventTimeMs, l, createTimeMs, obj, updateTimeMs, obj3);
        return dogLogModel;
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
        final boolean z7 = false;
        if (!(other instanceof DogLogModel)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (!n.b(this.userId, other.userId)) {
            return false;
        }
        if (!n.b(this.dogId, other.dogId)) {
            return false;
        }
        if (!n.b(this.type, other.type)) {
            return false;
        }
        if (this.eventTimeMs != other.eventTimeMs) {
            return false;
        }
        if (this.createTimeMs != other.createTimeMs) {
            return false;
        }
        return this.updateTimeMs != other.updateTimeMs ? z7 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.id.hashCode() * 31) + this.userId.hashCode() * 31 + this.dogId.hashCode() * 31 + this.type.hashCode() * 31 + Long.hashCode(this.eventTimeMs) * 31 + Long.hashCode(this.createTimeMs) * 31 + Long.hashCode(this.updateTimeMs);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DogLogModel(id=";
        String str3 = ", userId=";
        String str4 = ", dogId=";
        String str5 = ", type=";
        String str6 = ", eventTimeMs=";
        String str7 = ", createTimeMs=";
        String str8 = ", updateTimeMs=";
        str = str2 + this.id + str3 + this.userId + str4 + this.dogId + str5 + this.type + str6 + this.eventTimeMs + str7 + this.createTimeMs + str8 + this.updateTimeMs + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.userId);
        parcel.writeString(this.dogId);
        parcel.writeString(this.type);
        parcel.writeLong(this.eventTimeMs);
        parcel.writeLong(this.createTimeMs);
        parcel.writeLong(this.updateTimeMs);
    }
}
