package app.dogo.com.dogo_android.dogcreation;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import app.dogo.com.dogo_android.util.m0.a;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: DogCreationScreenKey.kt */
@Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u000b\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0007\u0018\u00002\u00020\u0001B/\u0012\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\u0008J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u000c\u0010\u0013\u001a\u0006\u0012\u0002\u0008\u00030\u0014H\u0014J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\t\u0010\n\"\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u000e¨\u0006\u001a", d2 = {"Lapp/dogo/com/dogo_android/dogcreation/DogCreationScreenKey;", "Lapp/dogo/com/dogo_android/util/navigation/ActivityScreenKey;", "dogId", "", "presetDogName", "skipWelcomeSuggestion", "", "goToMainScreen", "(Ljava/lang/String;Ljava/lang/String;ZZ)V", "getDogId", "()Ljava/lang/String;", "setDogId", "(Ljava/lang/String;)V", "getGoToMainScreen", "()Z", "getPresetDogName", "getSkipWelcomeSuggestion", "describeContents", "", "getActivityClass", "Ljava/lang/Class;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: f, reason: from kotlin metadata */
public final class DogCreationScreenKey extends a {

    public static final Parcelable.Creator<f> CREATOR = new f$a<>();
    /* renamed from: a, reason: from kotlin metadata */
    private String dogId;
    private final String b;
    private final boolean c;
    /* renamed from: v, reason: from kotlin metadata */
    private final boolean skipWelcomeSuggestion;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<f> {
        public final f a(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            n.f(parcel, "parcel");
            final int i2 = 0;
            int r3 = parcel.readInt() != 0 ? 1 : i2;
            if (parcel.readInt() == 0) {
            }
            DogCreationScreenKey dogCreationScreenKey = new DogCreationScreenKey(parcel.readString(), parcel.readString(), z, z2);
            return dogCreationScreenKey;
        }

        public final f[] b(int i) {
            return new f[i];
        }
    }
    public /* synthetic */ f(String str, String str2, boolean z, boolean z2, int i, g gVar) {
        String str3 = null;
        i = i & 2 != 0 ? 0 : i;
        int i2 = i & 4 != 0 ? 1 : i2;
        int i3 = i & 8 != 0 ? 0 : i3;
        this(str, str3, z, z2);
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    /* renamed from: a, reason: from kotlin metadata */
    public final String describeContents() {
        return this.dogId;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public final boolean b() {
        return this.skipWelcomeSuggestion;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public final String c() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public final boolean d() {
        return this.c;
    }

    public f(String str, String str2, boolean z, boolean z2) {
        super();
        this.dogId = str;
        this.b = str2;
        this.c = z;
        this.skipWelcomeSuggestion = z2;
    }


    @Override // app.dogo.com.dogo_android.util.m0.a
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    protected Class<?> getActivityClass() {
        return DogCreationActivity.class;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.dogId);
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.skipWelcomeSuggestion);
    }
}
