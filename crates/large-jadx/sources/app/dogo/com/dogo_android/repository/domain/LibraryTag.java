package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB#\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000b¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/LibraryTag;", "Landroid/os/Parcelable;", "hidden", "", "name", "", "id", "(ZLjava/lang/String;Ljava/lang/String;)V", "getHidden", "()Z", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LibraryTag implements Parcelable {

    public static final String ALL_TAG_ID = "id_all";
    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.LibraryTag> CREATOR;
    public static final app.dogo.com.dogo_android.repository.domain.LibraryTag.Companion Companion;
    private final boolean hidden;
    private final String id;
    private final String name;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/LibraryTag$Companion;", "", "()V", "ALL_TAG_ID", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public Companion(g g) {
            super();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.LibraryTag> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.LibraryTag createFromParcel(Parcel parcel) {
            int i;
            n.f(parcel, "parcel");
            i = parcel.readInt() != 0 ? 1 : 0;
            LibraryTag libraryTag = new LibraryTag(i, parcel.readString(), parcel.readString());
            return libraryTag;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.LibraryTag[] newArray(int i) {
            return new LibraryTag[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        LibraryTag.Companion companion = new LibraryTag.Companion(0);
        LibraryTag.Companion = companion;
        LibraryTag.Creator creator = new LibraryTag.Creator();
        LibraryTag.CREATOR = creator;
    }

    public LibraryTag() {
        super(0, 0, 0, 7, 0);
    }

    public LibraryTag(boolean z, String string2, String string3) {
        n.f(string2, "name");
        n.f(string3, "id");
        super();
        this.hidden = z;
        this.name = string2;
        this.id = string3;
    }

    public LibraryTag(boolean z, String string2, String string3, int i4, g g5) {
        int obj2;
        String obj3;
        String obj4;
        obj2 = i4 & 1 != 0 ? 0 : obj2;
        final String str = "";
        obj3 = i4 & 2 != 0 ? str : obj3;
        obj4 = i4 &= 4 != 0 ? str : obj4;
        super(obj2, obj3, obj4);
    }

    public static app.dogo.com.dogo_android.repository.domain.LibraryTag copy$default(app.dogo.com.dogo_android.repository.domain.LibraryTag libraryTag, boolean z2, String string3, String string4, int i5, Object object6) {
        boolean obj1;
        String obj2;
        String obj3;
        if (i5 & 1 != 0) {
            obj1 = libraryTag.hidden;
        }
        if (i5 & 2 != 0) {
            obj2 = libraryTag.name;
        }
        if (i5 &= 4 != 0) {
            obj3 = libraryTag.id;
        }
        return libraryTag.copy(obj1, obj2, obj3);
    }

    @Override // android.os.Parcelable
    public final boolean component1() {
        return this.hidden;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.name;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.LibraryTag copy(boolean z, String string2, String string3) {
        n.f(string2, "name");
        n.f(string3, "id");
        LibraryTag libraryTag = new LibraryTag(z, string2, string3);
        return libraryTag;
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
        if (!object instanceof LibraryTag) {
            return i2;
        }
        if (this.hidden != object.hidden) {
            return i2;
        }
        if (!n.b(this.name, object.name)) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final boolean getHidden() {
        return this.hidden;
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
        boolean hidden;
        if (this.hidden) {
            hidden = 1;
        }
        return i3 += i6;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LibraryTag(hidden=");
        stringBuilder.append(this.hidden);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", id=");
        stringBuilder.append(this.id);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeInt(this.hidden);
        parcel.writeString(this.name);
        parcel.writeString(this.id);
    }
}
