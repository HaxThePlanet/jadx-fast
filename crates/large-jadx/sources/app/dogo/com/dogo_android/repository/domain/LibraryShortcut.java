package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001!B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/LibraryShortcut;", "Landroid/os/Parcelable;", "id", "", "name", "icon", "type", "Lapp/dogo/com/dogo_android/repository/domain/LibraryShortcut$Type;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/LibraryShortcut$Type;)V", "getIcon", "()Ljava/lang/String;", "getId", "getName", "getType", "()Lapp/dogo/com/dogo_android/repository/domain/LibraryShortcut$Type;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Type", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LibraryShortcut implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.LibraryShortcut> CREATOR;
    private final String icon;
    private final String id;
    private final String name;
    private final app.dogo.com.dogo_android.repository.domain.LibraryShortcut.Type type;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.LibraryShortcut> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.LibraryShortcut createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            LibraryShortcut libraryShortcut = new LibraryShortcut(parcel.readString(), parcel.readString(), parcel.readString(), LibraryShortcut.Type.valueOf(parcel.readString()));
            return libraryShortcut;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.LibraryShortcut[] newArray(int i) {
            return new LibraryShortcut[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/LibraryShortcut$Type;", "", "(Ljava/lang/String;I)V", "ARTICLE", "TRICK", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static enum Type {

        ARTICLE,
        TRICK;
        private static final app.dogo.com.dogo_android.repository.domain.LibraryShortcut.Type[] $values() {
            app.dogo.com.dogo_android.repository.domain.LibraryShortcut.Type[] arr = new LibraryShortcut.Type[2];
            return arr;
        }
    }
    static {
        LibraryShortcut.Creator creator = new LibraryShortcut.Creator();
        LibraryShortcut.CREATOR = creator;
    }

    public LibraryShortcut(String string, String string2, String string3, app.dogo.com.dogo_android.repository.domain.LibraryShortcut.Type libraryShortcut$Type4) {
        n.f(string, "id");
        n.f(string2, "name");
        n.f(string3, "icon");
        n.f(type4, "type");
        super();
        this.id = string;
        this.name = string2;
        this.icon = string3;
        this.type = type4;
    }

    public static app.dogo.com.dogo_android.repository.domain.LibraryShortcut copy$default(app.dogo.com.dogo_android.repository.domain.LibraryShortcut libraryShortcut, String string2, String string3, String string4, app.dogo.com.dogo_android.repository.domain.LibraryShortcut.Type libraryShortcut$Type5, int i6, Object object7) {
        String obj1;
        String obj2;
        String obj3;
        app.dogo.com.dogo_android.repository.domain.LibraryShortcut.Type obj4;
        if (i6 & 1 != 0) {
            obj1 = libraryShortcut.id;
        }
        if (i6 & 2 != 0) {
            obj2 = libraryShortcut.name;
        }
        if (i6 & 4 != 0) {
            obj3 = libraryShortcut.icon;
        }
        if (i6 &= 8 != 0) {
            obj4 = libraryShortcut.type;
        }
        return libraryShortcut.copy(obj1, obj2, obj3, obj4);
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
    public final String component3() {
        return this.icon;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.LibraryShortcut.Type component4() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.LibraryShortcut copy(String string, String string2, String string3, app.dogo.com.dogo_android.repository.domain.LibraryShortcut.Type libraryShortcut$Type4) {
        n.f(string, "id");
        n.f(string2, "name");
        n.f(string3, "icon");
        n.f(type4, "type");
        LibraryShortcut libraryShortcut = new LibraryShortcut(string, string2, string3, type4);
        return libraryShortcut;
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
        if (!object instanceof LibraryShortcut) {
            return i2;
        }
        if (!n.b(this.id, object.id)) {
            return i2;
        }
        if (!n.b(this.name, object.name)) {
            return i2;
        }
        if (!n.b(this.icon, object.icon)) {
            return i2;
        }
        if (this.type != object.type) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final String getIcon() {
        return this.icon;
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
    public final app.dogo.com.dogo_android.repository.domain.LibraryShortcut.Type getType() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i6 += i10;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("LibraryShortcut(id=");
        stringBuilder.append(this.id);
        stringBuilder.append(", name=");
        stringBuilder.append(this.name);
        stringBuilder.append(", icon=");
        stringBuilder.append(this.icon);
        stringBuilder.append(", type=");
        stringBuilder.append(this.type);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.icon);
        parcel.writeString(this.type.name());
    }
}
