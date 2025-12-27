package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: LibraryTag.kt */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB#\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000b¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/LibraryTag;", "Landroid/os/Parcelable;", "hidden", "", "name", "", "id", "(ZLjava/lang/String;Ljava/lang/String;)V", "getHidden", "()Z", "getId", "()Ljava/lang/String;", "getName", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class LibraryTag implements Parcelable {

    public static final String ALL_TAG_ID = "id_all";
    public static final Parcelable.Creator<LibraryTag> CREATOR = new LibraryTag$Creator<>();
    /* renamed from: Companion, reason: from kotlin metadata */
    public static final LibraryTag.Companion INSTANCE = new LibraryTag$Companion(0);
    private final boolean hidden;
    private final String id;
    private final String name;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/LibraryTag$Companion;", "", "()V", "ALL_TAG_ID", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
            super();
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LibraryTag> {
        @Override // android.os.Parcelable$Creator
        public final LibraryTag createFromParcel(Parcel parcel) {
            boolean z = true;
            n.f(parcel, "parcel");
            int r1 = parcel.readInt() != 0 ? 1 : 0;
            LibraryTag libraryTag = new LibraryTag((parcel.readInt() != 0 ? 1 : 0), parcel.readString(), parcel.readString());
            return libraryTag;
        }

        @Override // android.os.Parcelable$Creator
        public final LibraryTag[] newArray(int i) {
            return new LibraryTag[i];
        }
    }
    public LibraryTag(boolean z, String str, String str2) {
        n.f(str, "name");
        n.f(str2, "id");
        super();
        this.hidden = z;
        this.name = str;
        this.id = str2;
    }

    public final boolean getHidden() {
        return this.hidden;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public /* synthetic */ LibraryTag(boolean z, String str, String str2, int i, g gVar) {
        boolean z2 = false;
        i = i & 1 != 0 ? 0 : i;
        str = "";
        str = i & 2 != 0 ? str : str;
        str = i & 4 != 0 ? str : str;
        this(z2, str, str);
    }


    public LibraryTag() {
        this(false, null, null, 7, null);
    }

    public static /* synthetic */ LibraryTag copy$default(LibraryTag libraryTag, boolean z, String str, String str2, int i, Object object) {
        boolean hidden2;
        String name2;
        String id2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        return libraryTag.copy(hidden2, name2, id2);
    }

    /* operator */ public final boolean component1() {
        return this.hidden;
    }

    /* operator */ public final String component2() {
        return this.name;
    }

    /* operator */ public final String component3() {
        return this.id;
    }

    public final LibraryTag copy(boolean hidden, String name, String id) {
        n.f(name, "name");
        n.f(id, "id");
        return new LibraryTag(hidden, name, id);
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
        if (!(other instanceof LibraryTag)) {
            return false;
        }
        if (this.hidden != other.hidden) {
            return false;
        }
        if (!n.b(this.name, other.name)) {
            return false;
        }
        return !n.b(this.id, other.id) ? z4 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        boolean hidden2 = true;
        if (this.hidden) {
            int i5 = 1;
        }
        return (hidden2 * 31) + this.name.hashCode() * 31 + this.id.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "LibraryTag(hidden=";
        String str3 = ", name=";
        String str4 = ", id=";
        str = str2 + this.hidden + str3 + this.name + str4 + this.id + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeInt(this.hidden);
        parcel.writeString(this.name);
        parcel.writeString(this.id);
    }
}
