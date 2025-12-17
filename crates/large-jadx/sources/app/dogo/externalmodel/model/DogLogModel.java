package app.dogo.externalmodel.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\t\n\u0002\u0008\u0015\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001BK\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\t\u001a\u00020\u0008\u0012\u0008\u0008\u0002\u0010\n\u001a\u00020\u0008¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0008HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0008HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0008HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u00082\u0008\u0008\u0002\u0010\t\u001a\u00020\u00082\u0008\u0008\u0002\u0010\n\u001a\u00020\u0008HÆ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0013\u0010\u001f\u001a\u00020 2\u0008\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\u001eHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\t\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0013\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u000f¨\u0006*", d2 = {"Lapp/dogo/externalmodel/model/DogLogModel;", "Landroid/os/Parcelable;", "id", "", "userId", "dogId", "type", "eventTimeMs", "", "createTimeMs", "updateTimeMs", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJ)V", "getCreateTimeMs", "()J", "getDogId", "()Ljava/lang/String;", "getEventTimeMs", "getId", "getType", "getUpdateTimeMs", "getUserId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "externalmodel_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DogLogModel implements Parcelable {

    public static final Parcelable.Creator<app.dogo.externalmodel.model.DogLogModel> CREATOR;
    private final long createTimeMs;
    private final String dogId;
    private final long eventTimeMs;
    private final String id;
    private final String type;
    private final long updateTimeMs;
    private final String userId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.externalmodel.model.DogLogModel> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.DogLogModel createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            super(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readLong(), obj7, parcel.readLong(), obj9, parcel.readLong(), obj11);
            return dogLogModel;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.externalmodel.model.DogLogModel[] newArray(int i) {
            return new DogLogModel[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        DogLogModel.Creator creator = new DogLogModel.Creator();
        DogLogModel.CREATOR = creator;
    }

    public DogLogModel() {
        super(0, 0, 0, 0, 0, obj6, 0, obj8, 0, obj10, 127, 0);
    }

    public DogLogModel(String string, String string2, String string3, String string4, long l5, long l6, long l7) {
        n.f(string, "id");
        n.f(string2, "userId");
        n.f(string3, "dogId");
        n.f(string4, "type");
        super();
        this.id = string;
        this.userId = string2;
        this.dogId = string3;
        this.type = string4;
        this.eventTimeMs = l5;
        this.createTimeMs = l7;
        this.updateTimeMs = obj10;
    }

    public DogLogModel(String string, String string2, String string3, String string4, long l5, long l6, long l7, int i8, g g9) {
        String str;
        String str2;
        String str4;
        String str3;
        int i2;
        int i;
        int l;
        str2 = "";
        str = obj22 & 1 != 0 ? str2 : string;
        str4 = obj22 & 2 != 0 ? str2 : string2;
        str3 = obj22 & 4 != 0 ? str2 : string3;
        if (obj22 & 8 != 0) {
        } else {
            str2 = string4;
        }
        i2 = 0;
        i = obj22 & 16 != 0 ? i2 : l5;
        l = obj22 & 32 != 0 ? i2 : l7;
        if (obj22 & 64 != 0) {
        } else {
            i2 = g9;
        }
        super(str, str4, str3, str2, i, l7, l, g9, i2, obj22);
    }

    public static app.dogo.externalmodel.model.DogLogModel copy$default(app.dogo.externalmodel.model.DogLogModel dogLogModel, String string2, String string3, String string4, String string5, long l6, long l7, long l8, int i9, Object object10) {
        String str;
        String userId;
        String dogId;
        String type;
        long eventTimeMs;
        long createTimeMs;
        long updateTimeMs;
        Object obj = dogLogModel;
        str = obj22 & 1 != 0 ? obj.id : string2;
        userId = obj22 & 2 != 0 ? obj.userId : string3;
        dogId = obj22 & 4 != 0 ? obj.dogId : string4;
        type = obj22 & 8 != 0 ? obj.type : string5;
        eventTimeMs = obj22 & 16 != 0 ? obj.eventTimeMs : l6;
        createTimeMs = obj22 & 32 != 0 ? obj.createTimeMs : l8;
        updateTimeMs = obj22 & 64 != 0 ? obj.updateTimeMs : object10;
        return dogLogModel.copy(str, userId, dogId, type, eventTimeMs, l7, createTimeMs);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.userId;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.dogId;
    }

    @Override // android.os.Parcelable
    public final String component4() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public final long component5() {
        return this.eventTimeMs;
    }

    @Override // android.os.Parcelable
    public final long component6() {
        return this.createTimeMs;
    }

    @Override // android.os.Parcelable
    public final long component7() {
        return this.updateTimeMs;
    }

    @Override // android.os.Parcelable
    public final app.dogo.externalmodel.model.DogLogModel copy(String string, String string2, String string3, String string4, long l5, long l6, long l7) {
        n.f(string, "id");
        n.f(string2, "userId");
        n.f(string3, "dogId");
        final Object obj = string4;
        n.f(obj, "type");
        super(string, string2, string3, obj, l5, obj7, l7, obj9, obj21, obj11);
        return dogLogModel;
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
        if (!object instanceof DogLogModel) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (!n.b(this.userId, object.userId)) {
            return i2;
        }
        if (!n.b(this.dogId, object.dogId)) {
            return i2;
        }
        if (!n.b(this.type, object.type)) {
            return i2;
        }
        if (Long.compare(eventTimeMs, eventTimeMs2) != 0) {
            return i2;
        }
        if (Long.compare(createTimeMs, createTimeMs2) != 0) {
            return i2;
        }
        if (Long.compare(updateTimeMs, updateTimeMs2) != 0) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final long getCreateTimeMs() {
        return this.createTimeMs;
    }

    @Override // android.os.Parcelable
    public final String getDogId() {
        return this.dogId;
    }

    @Override // android.os.Parcelable
    public final long getEventTimeMs() {
        return this.eventTimeMs;
    }

    @Override // android.os.Parcelable
    public final String getId() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final String getType() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public final long getUpdateTimeMs() {
        return this.updateTimeMs;
    }

    @Override // android.os.Parcelable
    public final String getUserId() {
        return this.userId;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i12 += i19;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DogLogModel(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", userId=");
        stringBuilder.append(this.userId);
        stringBuilder.append(", dogId=");
        stringBuilder.append(this.dogId);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(", eventTimeMs=");
        stringBuilder.append(this.eventTimeMs);
        stringBuilder.append(", createTimeMs=");
        stringBuilder.append(this.createTimeMs);
        stringBuilder.append(", updateTimeMs=");
        stringBuilder.append(this.updateTimeMs);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
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
