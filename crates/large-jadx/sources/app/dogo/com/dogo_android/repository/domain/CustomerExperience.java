package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B#\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0005HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000b¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/CustomerExperience;", "Landroid/os/Parcelable;", "name", "", "imageId", "", "text", "(Ljava/lang/String;ILjava/lang/String;)V", "getImageId", "()I", "getName", "()Ljava/lang/String;", "getText", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CustomerExperience implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.CustomerExperience> CREATOR;
    private final int imageId;
    private final String name;
    private final String text;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.CustomerExperience> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.CustomerExperience createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            CustomerExperience customerExperience = new CustomerExperience(parcel.readString(), parcel.readInt(), parcel.readString());
            return customerExperience;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.CustomerExperience[] newArray(int i) {
            return new CustomerExperience[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        CustomerExperience.Creator creator = new CustomerExperience.Creator();
        CustomerExperience.CREATOR = creator;
    }

    public CustomerExperience() {
        super(0, 0, 0, 7, 0);
    }

    public CustomerExperience(String string, int i2, String string3) {
        n.f(string, "name");
        n.f(string3, "text");
        super();
        this.name = string;
        this.imageId = i2;
        this.text = string3;
    }

    public CustomerExperience(String string, int i2, String string3, int i4, g g5) {
        String obj2;
        int obj3;
        String obj4;
        final String str = "";
        obj2 = i4 & 1 != 0 ? str : obj2;
        obj3 = i4 & 2 != 0 ? 0 : obj3;
        obj4 = i4 &= 4 != 0 ? str : obj4;
        super(obj2, obj3, obj4);
    }

    public static app.dogo.com.dogo_android.repository.domain.CustomerExperience copy$default(app.dogo.com.dogo_android.repository.domain.CustomerExperience customerExperience, String string2, int i3, String string4, int i5, Object object6) {
        String obj1;
        int obj2;
        String obj3;
        if (i5 & 1 != 0) {
            obj1 = customerExperience.name;
        }
        if (i5 & 2 != 0) {
            obj2 = customerExperience.imageId;
        }
        if (i5 &= 4 != 0) {
            obj3 = customerExperience.text;
        }
        return customerExperience.copy(obj1, obj2, obj3);
    }

    @Override // android.os.Parcelable
    public final String component1() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public final int component2() {
        return this.imageId;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.text;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.CustomerExperience copy(String string, int i2, String string3) {
        n.f(string, "name");
        n.f(string3, "text");
        CustomerExperience customerExperience = new CustomerExperience(string, i2, string3);
        return customerExperience;
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
        if (!object instanceof CustomerExperience) {
            return i2;
        }
        if (!n.b(this.name, object.name)) {
            return i2;
        }
        if (this.imageId != object.imageId) {
            return i2;
        }
        if (!n.b(this.text, object.text)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final int getImageId() {
        return this.imageId;
    }

    @Override // android.os.Parcelable
    public final String getName() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public final String getText() {
        return this.text;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i4 += i7;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CustomerExperience(name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", imageId=");
        stringBuilder.append(this.imageId);
        stringBuilder.append(", text=");
        stringBuilder.append(this.text);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.name);
        parcel.writeInt(this.imageId);
        parcel.writeString(this.text);
    }
}
