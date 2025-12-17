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

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B)\u0012\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\u0008J\u000f\u0010\u000e\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J-\u0010\u0011\u001a\u00020\u00002\u000e\u0008\u0002\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00062\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0006HÖ\u0001J\u0019\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\nR\u0017\u0010\u0002\u001a\u0008\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\n¨\u0006\u001f", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/VideoSteps;", "Landroid/os/Parcelable;", "steps", "", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem$VideoStep;", "videoUrl", "", "imageUrl", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getImageUrl", "()Ljava/lang/String;", "getSteps", "()Ljava/util/List;", "getVideoUrl", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class VideoSteps implements Parcelable {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.VideoSteps> CREATOR;
    private final String imageUrl;
    private final List<app.dogo.com.dogo_android.repository.domain.TrickItem.VideoStep> steps;
    private final String videoUrl;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<app.dogo.com.dogo_android.repository.domain.VideoSteps> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.VideoSteps createFromParcel(Parcel parcel) {
            int i;
            Object fromParcel;
            n.f(parcel, "parcel");
            int int = parcel.readInt();
            ArrayList arrayList = new ArrayList(int);
            i = 0;
            while (i != int) {
                arrayList.add(TrickItem.VideoStep.CREATOR.createFromParcel(parcel));
                i++;
            }
            VideoSteps videoSteps = new VideoSteps(arrayList, parcel.readString(), parcel.readString());
            return videoSteps;
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.repository.domain.VideoSteps[] newArray(int i) {
            return new VideoSteps[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return newArray(i);
        }
    }
    static {
        VideoSteps.Creator creator = new VideoSteps.Creator();
        VideoSteps.CREATOR = creator;
    }

    public VideoSteps() {
        super(0, 0, 0, 7, 0);
    }

    public VideoSteps(List<app.dogo.com.dogo_android.repository.domain.TrickItem.VideoStep> list, String string2, String string3) {
        n.f(list, "steps");
        n.f(string2, "videoUrl");
        n.f(string3, "imageUrl");
        super();
        this.steps = list;
        this.videoUrl = string2;
        this.imageUrl = string3;
    }

    public VideoSteps(List list, String string2, String string3, int i4, g g5) {
        List obj2;
        String obj3;
        String obj4;
        if (i4 & 1 != 0) {
            obj2 = p.g();
        }
        final String str = "";
        obj3 = i4 & 2 != 0 ? str : obj3;
        obj4 = i4 &= 4 != 0 ? str : obj4;
        super(obj2, obj3, obj4);
    }

    public static app.dogo.com.dogo_android.repository.domain.VideoSteps copy$default(app.dogo.com.dogo_android.repository.domain.VideoSteps videoSteps, List list2, String string3, String string4, int i5, Object object6) {
        List obj1;
        String obj2;
        String obj3;
        if (i5 & 1 != 0) {
            obj1 = videoSteps.steps;
        }
        if (i5 & 2 != 0) {
            obj2 = videoSteps.videoUrl;
        }
        if (i5 &= 4 != 0) {
            obj3 = videoSteps.imageUrl;
        }
        return videoSteps.copy(obj1, obj2, obj3);
    }

    public final List<app.dogo.com.dogo_android.repository.domain.TrickItem.VideoStep> component1() {
        return this.steps;
    }

    @Override // android.os.Parcelable
    public final String component2() {
        return this.videoUrl;
    }

    @Override // android.os.Parcelable
    public final String component3() {
        return this.imageUrl;
    }

    public final app.dogo.com.dogo_android.repository.domain.VideoSteps copy(List<app.dogo.com.dogo_android.repository.domain.TrickItem.VideoStep> list, String string2, String string3) {
        n.f(list, "steps");
        n.f(string2, "videoUrl");
        n.f(string3, "imageUrl");
        VideoSteps videoSteps = new VideoSteps(list, string2, string3);
        return videoSteps;
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
        if (!object instanceof VideoSteps) {
            return i2;
        }
        if (!n.b(this.steps, object.steps)) {
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
    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final List<app.dogo.com.dogo_android.repository.domain.TrickItem.VideoStep> getSteps() {
        return this.steps;
    }

    @Override // android.os.Parcelable
    public final String getVideoUrl() {
        return this.videoUrl;
    }

    @Override // android.os.Parcelable
    public int hashCode() {
        return i4 += i7;
    }

    @Override // android.os.Parcelable
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VideoSteps(steps=");
        stringBuilder.append(this.steps);
        stringBuilder.append(", videoUrl=");
        stringBuilder.append(this.videoUrl);
        stringBuilder.append(", imageUrl=");
        stringBuilder.append(this.imageUrl);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int size;
        n.f(parcel, "out");
        List steps = this.steps;
        parcel.writeInt(steps.size());
        Iterator iterator = steps.iterator();
        for (TrickItem.VideoStep size : iterator) {
            size.writeToParcel(parcel, i2);
        }
        parcel.writeString(this.videoUrl);
        parcel.writeString(this.imageUrl);
    }
}
