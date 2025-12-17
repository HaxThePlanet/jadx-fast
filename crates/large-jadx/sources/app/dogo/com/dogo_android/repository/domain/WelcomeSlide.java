package app.dogo.com.dogo_android.repository.domain;

import app.dogo.com.dogo_android.w.i3;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0008HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/WelcomeSlide;", "", "titleRes", "", "descriptionRes", "authorRes", "imageRes", "trackingTag", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "(IIIILapp/dogo/com/dogo_android/tracking/ParameterizedScreen;)V", "getAuthorRes", "()I", "getDescriptionRes", "getImageRes", "getTitleRes", "getTrackingTag", "()Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class WelcomeSlide {

    private final int authorRes;
    private final int descriptionRes;
    private final int imageRes;
    private final int titleRes;
    private final i3 trackingTag;
    public WelcomeSlide(int i, int i2, int i3, int i4, i3 i35) {
        n.f(i35, "trackingTag");
        super();
        this.titleRes = i;
        this.descriptionRes = i2;
        this.authorRes = i3;
        this.imageRes = i4;
        this.trackingTag = i35;
    }

    public static app.dogo.com.dogo_android.repository.domain.WelcomeSlide copy$default(app.dogo.com.dogo_android.repository.domain.WelcomeSlide welcomeSlide, int i2, int i3, int i4, int i5, i3 i36, int i7, Object object8) {
        int obj4;
        int obj5;
        int obj6;
        int obj7;
        i3 obj8;
        if (i7 & 1 != 0) {
            obj4 = welcomeSlide.titleRes;
        }
        if (i7 & 2 != 0) {
            obj5 = welcomeSlide.descriptionRes;
        }
        if (i7 & 4 != 0) {
            obj6 = welcomeSlide.authorRes;
        }
        if (i7 & 8 != 0) {
            obj7 = welcomeSlide.imageRes;
        }
        if (i7 & 16 != 0) {
            obj8 = welcomeSlide.trackingTag;
        }
        return welcomeSlide.copy(obj4, obj5, obj6, obj7, obj8);
    }

    public final int component1() {
        return this.titleRes;
    }

    public final int component2() {
        return this.descriptionRes;
    }

    public final int component3() {
        return this.authorRes;
    }

    public final int component4() {
        return this.imageRes;
    }

    public final i3 component5() {
        return this.trackingTag;
    }

    public final app.dogo.com.dogo_android.repository.domain.WelcomeSlide copy(int i, int i2, int i3, int i4, i3 i35) {
        n.f(i35, "trackingTag");
        super(i, i2, i3, i4, i35);
        return welcomeSlide;
    }

    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof WelcomeSlide) {
            return i2;
        }
        if (this.titleRes != object.titleRes) {
            return i2;
        }
        if (this.descriptionRes != object.descriptionRes) {
            return i2;
        }
        if (this.authorRes != object.authorRes) {
            return i2;
        }
        if (this.imageRes != object.imageRes) {
            return i2;
        }
        if (!n.b(this.trackingTag, object.trackingTag)) {
            return i2;
        }
        return i;
    }

    public final int getAuthorRes() {
        return this.authorRes;
    }

    public final int getDescriptionRes() {
        return this.descriptionRes;
    }

    public final int getImageRes() {
        return this.imageRes;
    }

    public final int getTitleRes() {
        return this.titleRes;
    }

    public final i3 getTrackingTag() {
        return this.trackingTag;
    }

    public int hashCode() {
        return i8 += i13;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("WelcomeSlide(titleRes=");
        stringBuilder.append(this.titleRes);
        stringBuilder.append(", descriptionRes=");
        stringBuilder.append(this.descriptionRes);
        stringBuilder.append(", authorRes=");
        stringBuilder.append(this.authorRes);
        stringBuilder.append(", imageRes=");
        stringBuilder.append(this.imageRes);
        stringBuilder.append(", trackingTag=");
        stringBuilder.append(this.trackingTag);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}
