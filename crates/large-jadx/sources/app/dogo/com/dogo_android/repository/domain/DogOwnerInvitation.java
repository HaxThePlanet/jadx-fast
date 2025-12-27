package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: DogOwnerInvitation.kt */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000f\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B-\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\t¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/DogOwnerInvitation;", "Landroid/os/Parcelable;", "dogId", "", "dogName", "userName", "dogAvatar", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDogAvatar", "()Ljava/lang/String;", "getDogId", "getDogName", "getUserName", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DogOwnerInvitation implements Parcelable {

    public static final Parcelable.Creator<DogOwnerInvitation> CREATOR = new DogOwnerInvitation$Creator<>();
    private final String dogAvatar;
    private final String dogId;
    private final String dogName;
    private final String userName;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DogOwnerInvitation> {
        @Override // android.os.Parcelable$Creator
        public final DogOwnerInvitation createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            return new DogOwnerInvitation(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable$Creator
        public final DogOwnerInvitation[] newArray(int i) {
            return new DogOwnerInvitation[i];
        }
    }
    public DogOwnerInvitation(String str, String str2, String str3, String str4) {
        n.f(str, "dogId");
        n.f(str2, "dogName");
        n.f(str3, "userName");
        n.f(str4, "dogAvatar");
        super();
        this.dogId = str;
        this.dogName = str2;
        this.userName = str3;
        this.dogAvatar = str4;
    }

    public final String getDogAvatar() {
        return this.dogAvatar;
    }

    public final String getDogId() {
        return this.dogId;
    }

    public final String getDogName() {
        return this.dogName;
    }

    public final String getUserName() {
        return this.userName;
    }

    public /* synthetic */ DogOwnerInvitation(String str, String str2, String str3, String str4, int i, g gVar) {
        String str5;
        str5 = "";
        str5 = i & 1 != 0 ? str5 : str5;
        str5 = i & 2 != 0 ? str5 : str5;
        str5 = i & 4 != 0 ? str5 : str5;
        str5 = i & 8 != 0 ? str5 : str5;
        this(str5, str5, str5, str5);
    }


    public DogOwnerInvitation() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ DogOwnerInvitation copy$default(DogOwnerInvitation dogOwnerInvitation, String str, String str2, String str3, String str4, int i, Object object) {
        String dogId2;
        String dogName2;
        String userName2;
        String dogAvatar2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        if (i & 8 != 0) {
        }
        return dogOwnerInvitation.copy(dogId2, dogName2, userName2, dogAvatar2);
    }

    /* operator */ public final String component1() {
        return this.dogId;
    }

    /* operator */ public final String component2() {
        return this.dogName;
    }

    /* operator */ public final String component3() {
        return this.userName;
    }

    /* operator */ public final String component4() {
        return this.dogAvatar;
    }

    public final DogOwnerInvitation copy(String dogId, String dogName, String userName, String dogAvatar) {
        n.f(dogId, "dogId");
        n.f(dogName, "dogName");
        n.f(userName, "userName");
        n.f(dogAvatar, "dogAvatar");
        return new DogOwnerInvitation(dogId, dogName, userName, dogAvatar);
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
        final boolean z6 = false;
        if (!(other instanceof DogOwnerInvitation)) {
            return false;
        }
        if (!n.b(this.dogId, other.dogId)) {
            return false;
        }
        if (!n.b(this.dogName, other.dogName)) {
            return false;
        }
        if (!n.b(this.userName, other.userName)) {
            return false;
        }
        return !n.b(this.dogAvatar, other.dogAvatar) ? z6 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.dogId.hashCode() * 31) + this.dogName.hashCode() * 31 + this.userName.hashCode() * 31 + this.dogAvatar.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DogOwnerInvitation(dogId=";
        String str3 = ", dogName=";
        String str4 = ", userName=";
        String str5 = ", dogAvatar=";
        str = str2 + this.dogId + str3 + this.dogName + str4 + this.userName + str5 + this.dogAvatar + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.dogId);
        parcel.writeString(this.dogName);
        parcel.writeString(this.userName);
        parcel.writeString(this.dogAvatar);
    }
}
