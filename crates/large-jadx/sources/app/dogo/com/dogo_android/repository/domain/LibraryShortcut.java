package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: LibraryShortcut.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\r\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u00002\u00020\u0001:\u0001!B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\u0008\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0015HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000e¨\u0006\"", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/LibraryShortcut;", "Landroid/os/Parcelable;", "id", "", "name", "icon", "type", "Lapp/dogo/com/dogo_android/repository/domain/LibraryShortcut$Type;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lapp/dogo/com/dogo_android/repository/domain/LibraryShortcut$Type;)V", "getIcon", "()Ljava/lang/String;", "getId", "getName", "getType", "()Lapp/dogo/com/dogo_android/repository/domain/LibraryShortcut$Type;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Type", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class LibraryShortcut implements Parcelable {

    public static final Parcelable.Creator<LibraryShortcut> CREATOR = new LibraryShortcut$Creator<>();
    private final String icon;
    private final String id;
    private final String name;
    private final LibraryShortcut.Type type;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LibraryShortcut> {
        @Override // android.os.Parcelable$Creator
        public final LibraryShortcut createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            return new LibraryShortcut(parcel.readString(), parcel.readString(), parcel.readString(), LibraryShortcut_Type.valueOf(parcel.readString()));
        }

        @Override // android.os.Parcelable$Creator
        public final LibraryShortcut[] newArray(int i) {
            return new LibraryShortcut[i];
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0008\u0004\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002j\u0002\u0008\u0003j\u0002\u0008\u0004¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/LibraryShortcut$Type;", "", "(Ljava/lang/String;I)V", "ARTICLE", "TRICK", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum Type {

        ARTICLE,
        TRICK;
        private static final /* synthetic */ LibraryShortcut.Type[] $values() {
            app.dogo.com.dogo_android.repository.domain.LibraryShortcut.Type[] arr = new LibraryShortcut.Type[2];
            return new LibraryShortcut.Type[] { LibraryShortcut_Type.ARTICLE, LibraryShortcut_Type.TRICK };
        }
    }
    public LibraryShortcut(String str, String str2, String str3, LibraryShortcut.Type type) {
        n.f(str, "id");
        n.f(str2, "name");
        n.f(str3, "icon");
        n.f(type, "type");
        super();
        this.id = str;
        this.name = str2;
        this.icon = str3;
        this.type = type;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final LibraryShortcut.Type getType() {
        return this.type;
    }


    public static /* synthetic */ LibraryShortcut copy$default(LibraryShortcut libraryShortcut, String str, String str2, String str3, LibraryShortcut.Type type, int i, Object object) {
        String id2;
        String name2;
        String icon2;
        app.dogo.com.dogo_android.repository.domain.LibraryShortcut.Type type2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        if (i & 8 != 0) {
        }
        return libraryShortcut.copy(id2, name2, icon2, type2);
    }

    /* operator */ public final String component1() {
        return this.id;
    }

    /* operator */ public final String component2() {
        return this.name;
    }

    /* operator */ public final String component3() {
        return this.icon;
    }

    /* operator */ public final LibraryShortcut.Type component4() {
        return this.type;
    }

    public final LibraryShortcut copy(String id, String name, String icon, LibraryShortcut.Type type) {
        n.f(id, "id");
        n.f(name, "name");
        n.f(icon, "icon");
        n.f(type, "type");
        return new LibraryShortcut(id, name, icon, type);
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
        if (!(other instanceof LibraryShortcut)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (!n.b(this.name, other.name)) {
            return false;
        }
        if (!n.b(this.icon, other.icon)) {
            return false;
        }
        return this.type != other.type ? z6 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.id.hashCode() * 31) + this.name.hashCode() * 31 + this.icon.hashCode() * 31 + this.type.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "LibraryShortcut(id=";
        String str3 = ", name=";
        String str4 = ", icon=";
        String str5 = ", type=";
        str = str2 + this.id + str3 + this.name + str4 + this.icon + str5 + this.type + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.icon);
        parcel.writeString(this.type.name());
    }
}
