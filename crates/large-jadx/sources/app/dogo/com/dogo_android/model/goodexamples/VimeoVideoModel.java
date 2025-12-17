package app.dogo.com.dogo_android.model.goodexamples;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/model/goodexamples/VimeoVideoModel;", "", "videoUrl", "", "imageUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "getImageUrl", "()Ljava/lang/String;", "getVideoUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class VimeoVideoModel {

    private final String imageUrl;
    private final String videoUrl;
    public VimeoVideoModel(String string, String string2) {
        n.f(string, "videoUrl");
        n.f(string2, "imageUrl");
        super();
        this.videoUrl = string;
        this.imageUrl = string2;
    }

    public static app.dogo.com.dogo_android.model.goodexamples.VimeoVideoModel copy$default(app.dogo.com.dogo_android.model.goodexamples.VimeoVideoModel vimeoVideoModel, String string2, String string3, int i4, Object object5) {
        String obj1;
        String obj2;
        if (i4 & 1 != 0) {
            obj1 = vimeoVideoModel.videoUrl;
        }
        if (i4 &= 2 != 0) {
            obj2 = vimeoVideoModel.imageUrl;
        }
        return vimeoVideoModel.copy(obj1, obj2);
    }

    public final String component1() {
        return this.videoUrl;
    }

    public final String component2() {
        return this.imageUrl;
    }

    public final app.dogo.com.dogo_android.model.goodexamples.VimeoVideoModel copy(String string, String string2) {
        n.f(string, "videoUrl");
        n.f(string2, "imageUrl");
        VimeoVideoModel vimeoVideoModel = new VimeoVideoModel(string, string2);
        return vimeoVideoModel;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof VimeoVideoModel) {
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

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public int hashCode() {
        return i2 += i4;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VimeoVideoModel(videoUrl=");
        stringBuilder.append(this.videoUrl);
        stringBuilder.append(", imageUrl=");
        stringBuilder.append(this.imageUrl);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
