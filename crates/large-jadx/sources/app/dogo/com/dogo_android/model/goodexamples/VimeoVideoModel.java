package app.dogo.com.dogo_android.model.goodexamples;

import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: VimeoVideoModel.kt */
@Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\t\n\u0002\u0010\u000b\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008\u0086\u0008\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000c\u001a\u00020\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0008\u0010\u0007¨\u0006\u0012", d2 = {"Lapp/dogo/com/dogo_android/model/goodexamples/VimeoVideoModel;", "", "videoUrl", "", "imageUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "getImageUrl", "()Ljava/lang/String;", "getVideoUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class VimeoVideoModel {

    private final String imageUrl;
    private final String videoUrl;
    public VimeoVideoModel(String str, String str2) {
        n.f(str, "videoUrl");
        n.f(str2, "imageUrl");
        super();
        this.videoUrl = str;
        this.imageUrl = str2;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    public static /* synthetic */ VimeoVideoModel copy$default(VimeoVideoModel vimeoVideoModel, String str, String str2, int i, Object object) {
        String videoUrl2;
        String imageUrl2;
        if (i & 1 != 0) {
        }
        if (i & 2 != 0) {
        }
        return vimeoVideoModel.copy(videoUrl2, imageUrl2);
    }

    /* operator */ public final String component1() {
        return this.videoUrl;
    }

    /* operator */ public final String component2() {
        return this.imageUrl;
    }

    public final VimeoVideoModel copy(String videoUrl, String imageUrl) {
        n.f(videoUrl, "videoUrl");
        n.f(imageUrl, "imageUrl");
        return new VimeoVideoModel(videoUrl, imageUrl);
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z4 = false;
        if (!(other instanceof VimeoVideoModel)) {
            return false;
        }
        if (!n.b(this.videoUrl, other.videoUrl)) {
            return false;
        }
        return !n.b(this.imageUrl, other.imageUrl) ? z4 : z;
    }

    public int hashCode() {
        return (this.videoUrl.hashCode() * 31) + this.imageUrl.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "VimeoVideoModel(videoUrl=";
        String str3 = ", imageUrl=";
        str = str2 + this.videoUrl + str3 + this.imageUrl + 41;
        return str;
    }
}
