package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: CustomerExperience.kt */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B#\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000b¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/CustomerExperience;", "Landroid/os/Parcelable;", "name", "", "imageId", "", "text", "(Ljava/lang/String;ILjava/lang/String;)V", "getImageId", "()I", "getName", "()Ljava/lang/String;", "getText", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class CustomerExperience implements Parcelable {

    public static final Parcelable.Creator<CustomerExperience> CREATOR = new CustomerExperience$Creator<>();
    private final int imageId;
    private final String name;
    private final String text;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CustomerExperience> {
        @Override // android.os.Parcelable$Creator
        public final CustomerExperience createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            return new CustomerExperience(parcel.readString(), parcel.readInt(), parcel.readString());
        }

        @Override // android.os.Parcelable$Creator
        public final CustomerExperience[] newArray(int i) {
            return new CustomerExperience[i];
        }
    }
    public CustomerExperience(String str, int i, String str2) {
        n.f(str, "name");
        n.f(str2, "text");
        super();
        this.name = str;
        this.imageId = i;
        this.text = str2;
    }

    public final int getImageId() {
        return this.imageId;
    }

    public final String getName() {
        return this.name;
    }

    public final String getText() {
        return this.text;
    }

    public /* synthetic */ CustomerExperience(String str, int i, String str2, int i2, g gVar) {
        str2 = "";
        str2 = i2 & 1 != 0 ? str2 : str2;
        i = i2 & 2 != 0 ? 0 : i;
        str2 = i2 & 4 != 0 ? str2 : str2;
        this(str2, i, str2);
    }


    public CustomerExperience() {
        this(null, 0, null, 7, null);
    }

    public static /* synthetic */ CustomerExperience copy$default(CustomerExperience customerExperience, String str, int i, String str2, int i2, Object object) {
        String name2;
        int imageId2;
        String text2;
        if (i2 & 1 != 0) {
        }
        if (i2 & 2 != 0) {
        }
        if (i2 & 4 != 0) {
        }
        return customerExperience.copy(name2, imageId2, text2);
    }

    /* operator */ public final String component1() {
        return this.name;
    }

    /* operator */ public final int component2() {
        return this.imageId;
    }

    /* operator */ public final String component3() {
        return this.text;
    }

    public final CustomerExperience copy(String name, int imageId, String text) {
        n.f(name, "name");
        n.f(text, "text");
        return new CustomerExperience(name, imageId, text);
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
        if (!(other instanceof CustomerExperience)) {
            return false;
        }
        if (!n.b(this.name, other.name)) {
            return false;
        }
        if (this.imageId != other.imageId) {
            return false;
        }
        return !n.b(this.text, other.text) ? z4 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.name.hashCode() * 31) + Integer.hashCode(this.imageId) * 31 + this.text.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "CustomerExperience(name=";
        String str3 = ", imageId=";
        String str4 = ", text=";
        str = str2 + this.name + str3 + this.imageId + str4 + this.text + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.name);
        parcel.writeInt(this.imageId);
        parcel.writeString(this.text);
    }
}
