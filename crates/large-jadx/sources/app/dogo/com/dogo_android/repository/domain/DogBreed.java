package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB!\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0007HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\n\u0008\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\n¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/DogBreed;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "id", "", "name", "isCustom", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "()Z", "getName", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DogBreed implements Parcelable, Serializable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.DogBreed> CREATOR = null;
    public static final String CUSTOM_ID_TRACK_TAG = "id_custom_breed";
    public static final app.dogo.com.dogo_android.repository.domain.DogBreed.Companion Companion;
    private final String id;
    private final boolean isCustom;
    private final String name;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/DogBreed$Companion;", "", "()V", "CUSTOM_ID_TRACK_TAG", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public Companion(g g) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.DogBreed> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.DogBreed createFromParcel(Parcel parcel) {
            int obj4;
            n.f(parcel, "parcel");
            obj4 = parcel.readInt() != 0 ? 1 : 0;
            DogBreed dogBreed = new DogBreed(parcel.readString(), parcel.readString(), obj4);
            return dogBreed;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.DogBreed[] newArray(int i) {
            return new DogBreed[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        DogBreed.Companion companion = new DogBreed.Companion(0);
        DogBreed.Companion = companion;
        DogBreed.Creator creator = new DogBreed.Creator();
        DogBreed.CREATOR = creator;
    }

    public DogBreed(String string, String string2, boolean z3) {
        n.f(string2, "name");
        super();
        this.id = string;
        this.name = string2;
        this.isCustom = z3;
    }

    public DogBreed(String string, String string2, boolean z3, int i4, g g5) {
        int obj3;
        obj3 = i4 &= 4 != 0 ? 0 : obj3;
        super(string, string2, obj3);
    }

    public static app.dogo.com.dogo_android.repository.domain.DogBreed copy$default(app.dogo.com.dogo_android.repository.domain.DogBreed dogBreed, String string2, String string3, boolean z4, int i5, Object object6) {
        String obj1;
        String obj2;
        boolean obj3;
        if (i5 & 1 != 0) {
            obj1 = dogBreed.id;
        }
        if (i5 & 2 != 0) {
            obj2 = dogBreed.name;
        }
        if (i5 &= 4 != 0) {
            obj3 = dogBreed.isCustom;
        }
        return dogBreed.copy(obj1, obj2, obj3);
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
        return this.isCustom;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.DogBreed copy(String string, String string2, boolean z3) {
        n.f(string2, "name");
        DogBreed dogBreed = new DogBreed(string, string2, z3);
        return dogBreed;
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
        if (!object instanceof DogBreed) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (!n.b(this.name, object.name)) {
            return i2;
        }
        if (this.isCustom != object.isCustom) {
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
        boolean isCustom;
        String str = this.id;
        if (str == null) {
            i = 0;
        } else {
            i = str.hashCode();
        }
        if (this.isCustom) {
            isCustom = 1;
        }
        return i4 += isCustom;
    }

    @Override // android.os.Parcelable
    public final boolean isCustom() {
        return this.isCustom;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DogBreed(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", isCustom=");
        stringBuilder.append(this.isCustom);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeInt(this.isCustom);
    }
}
