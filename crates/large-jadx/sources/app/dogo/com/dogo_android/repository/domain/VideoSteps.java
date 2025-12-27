package app.dogo.com.dogo_android.repository.domain;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.y.p;

/* compiled from: VideoSteps.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B)\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\u0008J\u000f\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\n¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/VideoSteps;", "Landroid/os/Parcelable;", "steps", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem$VideoStep;", "videoUrl", "", "imageUrl", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getImageUrl", "()Ljava/lang/String;", "getSteps", "()Ljava/util/List;", "getVideoUrl", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class VideoSteps implements Parcelable {

    public static final Parcelable.Creator<VideoSteps> CREATOR = new VideoSteps$Creator<>();
    private final String imageUrl;
    private final List<TrickItem.VideoStep> steps;
    private final String videoUrl;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<VideoSteps> {
        @Override // android.os.Parcelable$Creator
        public final VideoSteps createFromParcel(Parcel parcel) {
            int i = 0;
            n.f(parcel, "parcel");
            int _int = parcel.readInt();
            final ArrayList arrayList = new ArrayList(_int);
            i = 0;
            while (i != _int) {
                arrayList.add(TrickItem_VideoStep.CREATOR.createFromParcel(parcel));
                i = i + 1;
            }
            return new VideoSteps(arrayList, parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable$Creator
        public final VideoSteps[] newArray(int i) {
            return new VideoSteps[i];
        }
    }
    public VideoSteps(List<TrickItem.VideoStep> list, String str, String str2) {
        n.f(list, "steps");
        n.f(str, "videoUrl");
        n.f(str2, "imageUrl");
        super();
        this.steps = list;
        this.videoUrl = str;
        this.imageUrl = str2;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final List<TrickItem.VideoStep> getSteps() {
        return this.steps;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public /* synthetic */ VideoSteps(List list, String str, String str2, int i, g gVar) {
        List list2;
        if (i & 1 != 0) {
            list2 = p.g();
        }
        str = "";
        str = i & 2 != 0 ? str : str;
        str = i & 4 != 0 ? str : str;
        this(list2, str, str);
    }


    public VideoSteps() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ VideoSteps copy$default(VideoSteps videoSteps, List list, String str, String str2, int i, Object object) {
        List steps2;
        String videoUrl2;
        String imageUrl2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        if (i & 4 != 0) {
        }
        return videoSteps.copy(steps2, videoUrl2, imageUrl2);
    }

    /* operator */ public final List<TrickItem.VideoStep> component1() {
        return this.steps;
    }

    /* operator */ public final String component2() {
        return this.videoUrl;
    }

    /* operator */ public final String component3() {
        return this.imageUrl;
    }

    public final VideoSteps copy(List<TrickItem.VideoStep> steps, String videoUrl, String imageUrl) {
        n.f(steps, "steps");
        n.f(videoUrl, "videoUrl");
        n.f(imageUrl, "imageUrl");
        return new VideoSteps(steps, videoUrl, imageUrl);
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
        if (!(other instanceof VideoSteps)) {
            return false;
        }
        if (!n.b(this.steps, other.steps)) {
            return false;
        }
        if (!n.b(this.videoUrl, other.videoUrl)) {
            return false;
        }
        return !n.b(this.imageUrl, other.imageUrl) ? z5 : z;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (this.steps.hashCode() * 31) + this.videoUrl.hashCode() * 31 + this.imageUrl.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "VideoSteps(steps=";
        String str3 = ", videoUrl=";
        String str4 = ", imageUrl=";
        str = str2 + this.steps + str3 + this.videoUrl + str4 + this.imageUrl + 41;
        return str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeInt(this.steps.size());
        Iterator it = this.steps.iterator();
        while (it.hasNext()) {
            (TrickItem_VideoStep)it.next().writeToParcel(parcel, flags);
        }
        parcel.writeString(this.videoUrl);
        parcel.writeString(this.imageUrl);
    }
}
