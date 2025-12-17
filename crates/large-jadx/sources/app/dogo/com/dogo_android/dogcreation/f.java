package app.dogo.com.dogo_android.dogcreation;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import app.dogo.com.dogo_android.util.m0.a;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B/\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\u0008J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u000c\u0010\u0013\u001a\u0006\u0012\u0002\u0008\u00030\u0014H\u0014J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000e¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/DogCreationScreenKey;", "Lapp/dogo/com/dogo_android/util/navigation/ActivityScreenKey;", "dogId", "", "presetDogName", "skipWelcomeSuggestion", "", "goToMainScreen", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "getDogId", "()Ljava/lang/String;", "setDogId", "(Ljava/lang/String;)V", "getGoToMainScreen", "()Z", "getPresetDogName", "getSkipWelcomeSuggestion", "describeContents", "", "getActivityClass", "Ljava/lang/Class;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class f extends a {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.dogcreation.f> CREATOR;
    private String a;
    private final String b;
    private final boolean c;
    private final boolean v;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.dogcreation.f> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.dogcreation.f a(Parcel parcel) {
            int i;
            int i2;
            n.f(parcel, "parcel");
            final int i3 = 0;
            i = parcel.readInt() != 0 ? i2 : i3;
            if (parcel.readInt() != 0) {
            } else {
                i2 = i3;
            }
            f fVar = new f(parcel.readString(), parcel.readString(), i, i2);
            return fVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.dogcreation.f[] b(int i) {
            return new f[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return b(i);
        }
    }
    static {
        f.a aVar = new f.a();
        f.CREATOR = aVar;
    }

    public f(String string, String string2, boolean z3, boolean z4) {
        super();
        this.a = string;
        this.b = string2;
        this.c = z3;
        this.v = z4;
    }

    public f(String string, String string2, boolean z3, boolean z4, int i5, g g6) {
        int obj2;
        int obj3;
        int obj4;
        obj2 = i5 & 2 != 0 ? 0 : obj2;
        obj3 = i5 & 4 != 0 ? 1 : obj3;
        obj4 = i5 &= 8 != 0 ? 0 : obj4;
        super(string, obj2, obj3, obj4);
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public final String a() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public final boolean b() {
        return this.v;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public final String c() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public final boolean d() {
        return this.c;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public int describeContents() {
        return 0;
    }

    protected Class<?> getActivityClass() {
        return DogCreationActivity.class;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.v);
    }
}
