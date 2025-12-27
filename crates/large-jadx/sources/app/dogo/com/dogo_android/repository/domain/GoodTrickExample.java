package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* compiled from: GoodTrickExample.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0011\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B-\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\u0008J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\n\"\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/GoodTrickExample;", "Landroid/os/Parcelable;", "vimeoContentId", "", "dogName", "", "videoUrl", "imageUrl", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDogName", "()Ljava/lang/String;", "getImageUrl", "getVideoUrl", "setVideoUrl", "(Ljava/lang/String;)V", "getVimeoContentId", "()J", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class GoodTrickExample implements Parcelable {

    public static final Parcelable.Creator<GoodTrickExample> CREATOR = new GoodTrickExample$Creator<>();
    private final String dogName;
    private final String imageUrl;
    private String videoUrl;
    private final long vimeoContentId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<GoodTrickExample> {
        @Override // android.os.Parcelable$Creator
        public final GoodTrickExample createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            GoodTrickExample goodTrickExample = new GoodTrickExample(parcel.readLong(), str2, parcel.readString(), parcel.readString(), parcel.readString());
            return goodTrickExample;
        }

        @Override // android.os.Parcelable$Creator
        public final GoodTrickExample[] newArray(int i) {
            return new GoodTrickExample[i];
        }
    }
    public GoodTrickExample(long j, String str, String str2, String str3) {
        n.f(str, "dogName");
        n.f(str2, "videoUrl");
        n.f(str3, "imageUrl");
        super();
        this.vimeoContentId = j;
        this.dogName = str;
        this.videoUrl = str2;
        this.imageUrl = str3;
    }

    public final String getDogName() {
        return this.dogName;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public final long getVimeoContentId() {
        return this.vimeoContentId;
    }

    public final void setVideoUrl(String str) {
        n.f(str, "<set-?>");
        this.videoUrl = str;
    }

    public /* synthetic */ GoodTrickExample(long j, String str, String str2, String str3, int i, g gVar) {
        String str22;
        int j2 = 0;
        j2 = i & 1 != 0 ? 0 : j2;
        str22 = "";
        String r3 = i & 2 != 0 ? str22 : str;
        String r4 = i & 4 != 0 ? str22 : str2;
        String r5 = i & 8 != 0 ? str22 : str3;
        this(j2, str, str22, str22, (i & 8 != 0 ? str22 : str3));
    }


    public GoodTrickExample() {
        this(0L, str, null, null, 0, 15, 0);
    }

    public static /* synthetic */ GoodTrickExample copy$default(GoodTrickExample goodTrickExample, long j, String str, String str2, String str3, int i, Object object) {
        long j22;
        String str42;
        String str52;
        String i62;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        if (i & 8 != 0) {
        }
        return goodTrickExample.copy(j22, str42, str52, i62);
    }

    /* operator */ public final long component1() {
        return this.vimeoContentId;
    }

    /* operator */ public final String component2() {
        return this.dogName;
    }

    /* operator */ public final String component3() {
        return this.videoUrl;
    }

    /* operator */ public final String component4() {
        return this.imageUrl;
    }

    public final GoodTrickExample copy(long vimeoContentId, String dogName, String videoUrl, String imageUrl) {
        n.f(dogName, "dogName");
        n.f(videoUrl, "videoUrl");
        n.f(imageUrl, "imageUrl");
        GoodTrickExample goodTrickExample = new GoodTrickExample(vimeoContentId, str4, dogName, videoUrl, imageUrl);
        return goodTrickExample;
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
        if (!(other instanceof GoodTrickExample)) {
            return false;
        }
        if (this.vimeoContentId != other.vimeoContentId) {
            return false;
        }
        if (!n.b(this.dogName, other.dogName)) {
            return false;
        }
        if (!n.b(this.videoUrl, other.videoUrl)) {
            return false;
        }
        return !n.b(this.imageUrl, other.imageUrl) ? z5 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (Long.hashCode(this.vimeoContentId) * 31) + this.dogName.hashCode() * 31 + this.videoUrl.hashCode() * 31 + this.imageUrl.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "GoodTrickExample(vimeoContentId=";
        String str3 = ", dogName=";
        String str4 = ", videoUrl=";
        String str5 = ", imageUrl=";
        str = str2 + this.vimeoContentId + str3 + this.dogName + str4 + this.videoUrl + str5 + this.imageUrl + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeLong(this.vimeoContentId);
        parcel.writeString(this.dogName);
        parcel.writeString(this.videoUrl);
        parcel.writeString(this.imageUrl);
    }
}
