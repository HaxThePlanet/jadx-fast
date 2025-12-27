package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: DogBreed.kt */
@Metadata(d1 = "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0087\u0008\u0018\u0000 \u001d2\u00020\u00012\u00020\u0002:\u0001\u001dB!\u0012\u0008\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0007HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\n\u0008\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00042\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00072\u0008\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\n¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/DogBreed;", "Landroid/os/Parcelable;", "Ljava/io/Serializable;", "id", "", "name", "isCustom", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "()Z", "getName", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DogBreed implements Parcelable, Serializable {

    public static final Parcelable.Creator<DogBreed> CREATOR = null;
    public static final String CUSTOM_ID_TRACK_TAG = "id_custom_breed";
    /* renamed from: Companion, reason: from kotlin metadata */
    public static final DogBreed.Companion INSTANCE = new DogBreed$Companion(0);
    private final String id;
    private final boolean isCustom;
    private final String name;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/DogBreed$Companion;", "", "()V", "CUSTOM_ID_TRACK_TAG", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
            super();
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<DogBreed> {
        @Override // android.os.Parcelable$Creator
        public final DogBreed createFromParcel(Parcel parcel) {
            boolean z = true;
            n.f(parcel, "parcel");
            parcel = parcel.readInt() != 0 ? 1 : 0;
            DogBreed dogBreed = new DogBreed(parcel.readString(), parcel.readString(), (parcel.readInt() != 0 ? 1 : 0));
            return dogBreed;
        }

        @Override // android.os.Parcelable$Creator
        public final DogBreed[] newArray(int i) {
            return new DogBreed[i];
        }
    }
    public DogBreed(String str, String str2, boolean z) {
        n.f(str2, "name");
        super();
        this.id = str;
        this.name = str2;
        this.isCustom = z;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean isCustom() {
        return this.isCustom;
    }

    public /* synthetic */ DogBreed(String str, String str2, boolean z, int i, g gVar) {
        i = i & 4 != 0 ? 0 : i;
        this(str, str2, z);
    }

    static {
        DogBreed.CREATOR = new DogBreed.Creator();
    }

    public static /* synthetic */ DogBreed copy$default(DogBreed dogBreed, String str, String str2, boolean z, int i, Object object) {
        String id2;
        String name2;
        boolean isCustom2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        return dogBreed.copy(id2, name2, isCustom2);
    }

    /* operator */ public final String component1() {
        return this.id;
    }

    /* operator */ public final String component2() {
        return this.name;
    }

    /* operator */ public final boolean component3() {
        return this.isCustom;
    }

    public final DogBreed copy(String id, String name, boolean isCustom) {
        n.f(name, "name");
        return new DogBreed(id, name, isCustom);
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
        final boolean z5 = false;
        if (!(other instanceof DogBreed)) {
            return false;
        }
        if (!n.b(this.id, other.id)) {
            return false;
        }
        if (!n.b(this.name, other.name)) {
            return false;
        }
        return this.isCustom != other.isCustom ? z5 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        int i = 0;
        boolean isCustom2 = true;
        if (this.id == null) {
            i = 0;
        } else {
            i = this.id.hashCode();
        }
        if (this.isCustom) {
            int i7 = 1;
        }
        return (i * 31) + this.name.hashCode() * 31 + isCustom2;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "DogBreed(id=";
        String str3 = ", name=";
        String str4 = ", isCustom=";
        str = str2 + this.id + str3 + this.name + str4 + this.isCustom + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeInt(this.isCustom);
    }
}
