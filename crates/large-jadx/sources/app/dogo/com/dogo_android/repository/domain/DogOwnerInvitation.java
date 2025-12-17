package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000f\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B-\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\t¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/DogOwnerInvitation;", "Landroid/os/Parcelable;", "dogId", "", "dogName", "userName", "dogAvatar", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDogAvatar", "()Ljava/lang/String;", "getDogId", "getDogName", "getUserName", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DogOwnerInvitation implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.DogOwnerInvitation> CREATOR;
    private final String dogAvatar;
    private final String dogId;
    private final String dogName;
    private final String userName;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.DogOwnerInvitation> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.DogOwnerInvitation createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            DogOwnerInvitation dogOwnerInvitation = new DogOwnerInvitation(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            return dogOwnerInvitation;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.DogOwnerInvitation[] newArray(int i) {
            return new DogOwnerInvitation[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        DogOwnerInvitation.Creator creator = new DogOwnerInvitation.Creator();
        DogOwnerInvitation.CREATOR = creator;
    }

    public DogOwnerInvitation() {
        super(0, 0, 0, 0, 15, 0);
    }

    public DogOwnerInvitation(String string, String string2, String string3, String string4) {
        n.f(string, "dogId");
        n.f(string2, "dogName");
        n.f(string3, "userName");
        n.f(string4, "dogAvatar");
        super();
        this.dogId = string;
        this.dogName = string2;
        this.userName = string3;
        this.dogAvatar = string4;
    }

    public DogOwnerInvitation(String string, String string2, String string3, String string4, int i5, g g6) {
        String obj2;
        String obj3;
        String obj4;
        String obj5;
        final String str = "";
        obj2 = i5 & 1 != 0 ? str : obj2;
        obj3 = i5 & 2 != 0 ? str : obj3;
        obj4 = i5 & 4 != 0 ? str : obj4;
        obj5 = i5 &= 8 != 0 ? str : obj5;
        super(obj2, obj3, obj4, obj5);
    }

    public static app.dogo.com.dogo_android.repository.domain.DogOwnerInvitation copy$default(app.dogo.com.dogo_android.repository.domain.DogOwnerInvitation dogOwnerInvitation, String string2, String string3, String string4, String string5, int i6, Object object7) {
        String obj1;
        String obj2;
        String obj3;
        String obj4;
        if (i6 & 1 != 0) {
            obj1 = dogOwnerInvitation.dogId;
        }
        if (i6 & 2 != 0) {
            obj2 = dogOwnerInvitation.dogName;
        }
        if (i6 & 4 != 0) {
            obj3 = dogOwnerInvitation.userName;
        }
        if (i6 &= 8 != 0) {
            obj4 = dogOwnerInvitation.dogAvatar;
        }
        return dogOwnerInvitation.copy(obj1, obj2, obj3, obj4);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.dogId;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.dogName;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.userName;
    }

    @Override // android.os.Parcelable
    public final String component4() {
        return this.dogAvatar;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.DogOwnerInvitation copy(String string, String string2, String string3, String string4) {
        n.f(string, "dogId");
        n.f(string2, "dogName");
        n.f(string3, "userName");
        n.f(string4, "dogAvatar");
        DogOwnerInvitation dogOwnerInvitation = new DogOwnerInvitation(string, string2, string3, string4);
        return dogOwnerInvitation;
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
        if (!object instanceof DogOwnerInvitation) {
            return i2;
        }
        if (!n.b(this.dogId, object.dogId)) {
            return i2;
        }
        if (!n.b(this.dogName, object.dogName)) {
            return i2;
        }
        if (!n.b(this.userName, object.userName)) {
            return i2;
        }
        if (!n.b(this.dogAvatar, object.dogAvatar)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final String getDogAvatar() {
        return this.dogAvatar;
    }

    @Override // android.os.Parcelable
    public final String getDogId() {
        return this.dogId;
    }

    @Override // android.os.Parcelable
    public final String getDogName() {
        return this.dogName;
    }

    @Override // android.os.Parcelable
    public final String getUserName() {
        return this.userName;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i6 += i10;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DogOwnerInvitation(dogId=");
        stringBuilder.append(this.dogId);
        stringBuilder.append(", dogName=");
        stringBuilder.append(this.dogName);
        stringBuilder.append(", userName=");
        stringBuilder.append(this.userName);
        stringBuilder.append(", dogAvatar=");
        stringBuilder.append(this.dogAvatar);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.dogId);
        parcel.writeString(this.dogName);
        parcel.writeString(this.userName);
        parcel.writeString(this.dogAvatar);
    }
}
