package app.dogo.com.dogo_android.model;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\u0008\u0014\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B%\u0008\u0016\u0012\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0008\u0010\u0008\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\tB\u000f\u0008\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\u000cJ\u0008\u0010\u0015\u001a\u00020\u0016H\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0018\u001a\u00020\u0016H\u0004J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0019\u001a\u00020\u001aJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0016H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\r\u0010\u000e\"\u0004\u0008\u000f\u0010\u0010R\u001c\u0010\u0008\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0011\u0010\u000e\"\u0004\u0008\u0012\u0010\u0010R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u0013\u0010\u000e\"\u0004\u0008\u0014\u0010\u0010¨\u0006 ", d2 = {"Lapp/dogo/com/dogo_android/model/LiteDogProfile;", "Landroid/os/Parcelable;", "in", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "name", "", "avatar", "id", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "dogProfile", "Lapp/dogo/com/dogo_android/model/DogProfileModel;", "(Lapp/dogo/com/dogo_android/model/DogProfileModel;)V", "getAvatar", "()Ljava/lang/String;", "setAvatar", "(Ljava/lang/String;)V", "getId", "setId", "getName", "setName", "describeContents", "", "generateThumbnailUrl", "size", "resources", "Landroid/content/res/Resources;", "writeToParcel", "", "dest", "flags", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class LiteDogProfile implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.model.LiteDogProfile> CREATOR;
    public static final app.dogo.com.dogo_android.model.LiteDogProfile.Companion Companion;
    private String avatar;
    private String id;
    private String name;

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006", d2 = {"Lapp/dogo/com/dogo_android/model/LiteDogProfile$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lapp/dogo/com/dogo_android/model/LiteDogProfile;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public Companion(g g) {
            super();
        }
    }
    static {
        LiteDogProfile.Companion companion = new LiteDogProfile.Companion(0);
        LiteDogProfile.Companion = companion;
        LiteDogProfile.Companion.CREATOR.1 anon = new LiteDogProfile.Companion.CREATOR.1();
        LiteDogProfile.CREATOR = anon;
    }

    protected LiteDogProfile(Parcel parcel) {
        n.f(parcel, "in");
        super();
        this.name = parcel.readString();
        this.avatar = parcel.readString();
        this.id = parcel.readString();
    }

    public LiteDogProfile(app.dogo.com.dogo_android.model.DogProfileModel dogProfileModel) {
        n.f(dogProfileModel, "dogProfile");
        super();
        this.name = dogProfileModel.getName();
        this.avatar = dogProfileModel.getAvatar();
        this.id = dogProfileModel.getId();
    }

    public LiteDogProfile(String string, String string2, String string3) {
        super();
        this.name = string;
        this.avatar = string2;
        this.id = string3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    protected final String generateThumbnailUrl(int i) {
        String str;
        String string;
        int i3;
        int i4;
        int i2;
        String obj7;
        final String avatar = this.avatar;
        if (avatar != null) {
            n.d(avatar);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("avatar_");
            stringBuilder.append(i);
            stringBuilder.append(".jpg");
            obj7 = l.G(avatar, "avatar.jpg", stringBuilder.toString(), false, 4, 0);
        } else {
            obj7 = 0;
        }
        return obj7;
    }

    @Override // android.os.Parcelable
    public final String getAvatar() {
        return this.avatar;
    }

    @Override // android.os.Parcelable
    public final String getAvatar(Resources resources) {
        int cmp;
        String obj2;
        n.f(resources, "resources");
        obj2 = (float)obj2;
        if (Float.compare(obj2, i) < 0) {
            obj2 = generateThumbnailUrl(60);
        } else {
            if (Float.compare(obj2, i2) < 0) {
                obj2 = generateThumbnailUrl(120);
            } else {
                if (Float.compare(obj2, cmp) < 0) {
                    obj2 = generateThumbnailUrl(240);
                } else {
                    obj2 = generateThumbnailUrl(360);
                }
            }
        }
        return obj2;
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
    public final void setAvatar(String string) {
        this.avatar = string;
    }

    @Override // android.os.Parcelable
    public final void setId(String string) {
        this.id = string;
    }

    @Override // android.os.Parcelable
    public final void setName(String string) {
        this.name = string;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "dest");
        parcel.writeString(this.name);
        parcel.writeString(this.avatar);
        parcel.writeString(this.id);
    }
}
