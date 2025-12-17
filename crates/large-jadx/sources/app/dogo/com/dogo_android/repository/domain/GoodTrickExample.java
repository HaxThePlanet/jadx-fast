package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0011\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B-\u0012\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u0005\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\u0008J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J1\u0010\u0015\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00052\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\u0008\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0017HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\nR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u000c\u0010\n\"\u0004\u0008\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006#", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/GoodTrickExample;", "Landroid/os/Parcelable;", "vimeoContentId", "", "dogName", "", "videoUrl", "imageUrl", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDogName", "()Ljava/lang/String;", "getImageUrl", "getVideoUrl", "setVideoUrl", "(Ljava/lang/String;)V", "getVimeoContentId", "()J", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class GoodTrickExample implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.GoodTrickExample> CREATOR;
    private final String dogName;
    private final String imageUrl;
    private String videoUrl;
    private final long vimeoContentId;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.GoodTrickExample> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.GoodTrickExample createFromParcel(Parcel parcel) {
            n.f(parcel, "parcel");
            super(parcel.readLong(), obj3, parcel.readString(), parcel.readString(), parcel.readString());
            return goodTrickExample;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.GoodTrickExample[] newArray(int i) {
            return new GoodTrickExample[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        GoodTrickExample.Creator creator = new GoodTrickExample.Creator();
        GoodTrickExample.CREATOR = creator;
    }

    public GoodTrickExample() {
        super(0, obj2, 0, 0, 0, 15, 0);
    }

    public GoodTrickExample(long l, String string2, String string3, String string4) {
        n.f(string3, "dogName");
        n.f(string4, "videoUrl");
        n.f(obj6, "imageUrl");
        super();
        this.vimeoContentId = l;
        this.dogName = string3;
        this.videoUrl = string4;
        this.imageUrl = obj6;
    }

    public GoodTrickExample(long l, String string2, String string3, String string4, int i5, g g6) {
        String str;
        String str2;
        String str3;
        int obj7;
        obj7 = g6 & 1 != 0 ? 0 : obj7;
        final String obj8 = "";
        str = g6 & 2 != 0 ? obj8 : string3;
        str2 = g6 & 4 != 0 ? obj8 : string4;
        str3 = g6 & 8 != 0 ? obj8 : i5;
        super(obj7, obj2, str, str2, str3);
    }

    public static app.dogo.com.dogo_android.repository.domain.GoodTrickExample copy$default(app.dogo.com.dogo_android.repository.domain.GoodTrickExample goodTrickExample, long l2, String string3, String string4, String string5, int i6, Object object7) {
        long obj7;
        String obj9;
        String obj10;
        String obj11;
        if (object7 & 1 != 0) {
            obj7 = goodTrickExample.vimeoContentId;
        }
        if (object7 & 2 != 0) {
            obj9 = goodTrickExample.dogName;
        }
        if (object7 & 4 != 0) {
            obj10 = goodTrickExample.videoUrl;
        }
        if (object7 & 8 != 0) {
            obj11 = goodTrickExample.imageUrl;
        }
        return goodTrickExample.copy(obj7, obj2, obj9, obj10);
    }

    @Override // android.os.Parcelable
    public final long component1() {
        return this.vimeoContentId;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.dogName;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.videoUrl;
    }

    @Override // android.os.Parcelable
    public final String component4() {
        return this.imageUrl;
    }

    @Override // android.os.Parcelable
    public final app.dogo.com.dogo_android.repository.domain.GoodTrickExample copy(long l, String string2, String string3, String string4) {
        n.f(string3, "dogName");
        n.f(string4, "videoUrl");
        n.f(obj12, "imageUrl");
        super(l, obj3, string3, string4, obj12);
        return goodTrickExample;
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
        if (!object instanceof GoodTrickExample) {
            return i2;
        }
        if (Long.compare(vimeoContentId, vimeoContentId2) != 0) {
            return i2;
        }
        if (!n.b(this.dogName, object.dogName)) {
            return i2;
        }
        if (!n.b(this.videoUrl, object.videoUrl)) {
            return i2;
        }
        if (!n.b(this.imageUrl, object.imageUrl)) {
            return i2;
        }
        return i;
    }

    @Override // android.os.Parcelable
    public final String getDogName() {
        return this.dogName;
    }

    @Override // android.os.Parcelable
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @Override // android.os.Parcelable
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    @Override // android.os.Parcelable
    public final long getVimeoContentId() {
        return this.vimeoContentId;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i6 += i10;
    }

    @Override // android.os.Parcelable
    public final void setVideoUrl(String string) {
        n.f(string, "<set-?>");
        this.videoUrl = string;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GoodTrickExample(vimeoContentId=");
        stringBuilder.append(this.vimeoContentId);
        stringBuilder.append(", dogName=");
        stringBuilder.append(this.dogName);
        stringBuilder.append(", videoUrl=");
        stringBuilder.append(this.videoUrl);
        stringBuilder.append(", imageUrl=");
        stringBuilder.append(this.imageUrl);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeLong(this.vimeoContentId);
        parcel.writeString(this.dogName);
        parcel.writeString(this.videoUrl);
        parcel.writeString(this.imageUrl);
    }
}
