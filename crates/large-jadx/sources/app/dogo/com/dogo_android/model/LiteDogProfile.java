package app.dogo.com.dogo_android.model;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;

/* compiled from: LiteDogProfile.kt */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\u0008\u0014\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B%\u0008\u0016\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tB\u000f\u0008\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u0016H\u0004J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\u001aJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0016H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u001c\u0010\u0008\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u000e\"\u0004\u0008\u0012\u0010\u0010R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\u000e\"\u0004\u0008\u0014\u0010\u0010¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/model/LiteDogProfile;", "Landroid/os/Parcelable;", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "name", "", "avatar", "id", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "dogProfile", "Lapp/dogo/com/dogo_android/model/DogProfileModel;", "(Lapp/dogo/com/dogo_android/model/DogProfileModel;)V", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "getId", "setId", "getName", "setName", "describeContents", "", "generateThumbnailUrl", "size", "resources", "Landroid/content/res/Resources;", "writeToParcel", "", "dest", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class LiteDogProfile implements Parcelable {

    public static final Parcelable.Creator<LiteDogProfile> CREATOR = new LiteDogProfile$Companion$CREATOR$1<>();
    /* renamed from: Companion, reason: from kotlin metadata */
    public static final LiteDogProfile.Companion INSTANCE = new LiteDogProfile$Companion(0);
    private String avatar;
    private String id;
    private String name;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/model/LiteDogProfile$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lapp/dogo/com/dogo_android/model/LiteDogProfile;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
            super();
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }
    }

    protected LiteDogProfile(Parcel parcel) {
        n.f(parcel, "in");
        super();
        this.name = parcel.readString();
        this.avatar = parcel.readString();
        this.id = parcel.readString();
    }

    protected final String generateThumbnailUrl(int size) {
        String str3 = null;
        if (this.avatar != null) {
            n.d(this.avatar);
            StringBuilder stringBuilder = new StringBuilder();
            String str4 = "avatar_";
            String str5 = ".jpg";
            str2 = str4 + size + str5;
            boolean z = false;
            int i = 4;
            Object obj = null;
            str = "avatar.jpg";
            str3 = l.G(this.avatar, str, str2, z, i, obj);
        } else {
            int i2 = 0;
        }
        return str3;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final void setId(String str) {
        this.id = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        n.f(dest, "dest");
        dest.writeString(this.name);
        dest.writeString(this.avatar);
        dest.writeString(this.id);
    }

    public final String getAvatar(Resources resources) {
        String thumbnailUrl;
        n.f(resources, "resources");
        float f2 = (float)resources.getDisplayMetrics().widthPixels;
        if (f2 < 1131413504) {
            thumbnailUrl = generateThumbnailUrl(60);
        } else {
            if (f2 < 1135869952) {
                thumbnailUrl = generateThumbnailUrl(120);
            } else {
                float f = 720f;
                if (f2 < f) {
                    thumbnailUrl = generateThumbnailUrl(240);
                } else {
                    thumbnailUrl = generateThumbnailUrl(360);
                }
            }
        }
        return thumbnailUrl;
    }

    public LiteDogProfile(String str, String str2, String str3) {
        super();
        this.name = str;
        this.avatar = str2;
        this.id = str3;
    }

    public LiteDogProfile(DogProfileModel dogProfileModel) {
        n.f(dogProfileModel, "dogProfile");
        super();
        this.name = dogProfileModel.getName();
        this.avatar = dogProfileModel.getAvatar();
        this.id = dogProfileModel.getId();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
