package app.dogo.com.dogo_android.repository.domain;

import app.dogo.com.dogo_android.w.i3;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: WelcomeSlide.kt */
@Metadata(d1 = "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u000f\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0008\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0008HÆ\u0003J;\u0010\u0016\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0006\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0007\u001a\u00020\u0008HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000c\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0008¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000f\u0010\u0010¨\u0006\u001d", d2 = {"Lapp/dogo/com/dogo_android/repository/domain/WelcomeSlide;", "", "titleRes", "", "descriptionRes", "authorRes", "imageRes", "trackingTag", "Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "(IIIILapp/dogo/com/dogo_android/tracking/ParameterizedScreen;)V", "getAuthorRes", "()I", "getDescriptionRes", "getImageRes", "getTitleRes", "getTrackingTag", "()Lapp/dogo/com/dogo_android/tracking/ParameterizedScreen;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class WelcomeSlide {

    private final int authorRes;
    private final int descriptionRes;
    private final int imageRes;
    private final int titleRes;
    private final i3 trackingTag;
    public WelcomeSlide(int i, int i2, int i3, int i4, i3 i3Var) {
        n.f(i3Var, "trackingTag");
        super();
        this.titleRes = i;
        this.descriptionRes = i2;
        this.authorRes = i3;
        this.imageRes = i4;
        this.trackingTag = i3Var;
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

    public static /* synthetic */ WelcomeSlide copy$default(WelcomeSlide welcomeSlide, int i, int i2, int i3, int i4, i3 i3Var, int i5, Object object) {
        int i22;
        int object82;
        int i42;
        int i52;
        i3 i3Var62;
        if (i5 & 1 != 0) {
        }
        if (i5 & 2 != 0) {
        }
        if (i5 & 4 != 0) {
        }
        if (i5 & 8 != 0) {
        }
        if (i5 & 16 != 0) {
        }
        return welcomeSlide.copy(i22, object82, i42, i52, i3Var62);
    }

    /* operator */ public final int component1() {
        return this.titleRes;
    }

    /* operator */ public final int component2() {
        return this.descriptionRes;
    }

    /* operator */ public final int component3() {
        return this.authorRes;
    }

    /* operator */ public final int component4() {
        return this.imageRes;
    }

    /* operator */ public final i3 component5() {
        return this.trackingTag;
    }

    public final WelcomeSlide copy(int titleRes, int descriptionRes, int authorRes, int imageRes, i3 trackingTag) {
        n.f(trackingTag, "trackingTag");
        WelcomeSlide welcomeSlide = new WelcomeSlide(titleRes, descriptionRes, authorRes, imageRes, trackingTag);
        return welcomeSlide;
    }

    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z3 = false;
        if (!(other instanceof WelcomeSlide)) {
            return false;
        }
        if (this.titleRes != other.titleRes) {
            return false;
        }
        if (this.descriptionRes != other.descriptionRes) {
            return false;
        }
        if (this.authorRes != other.authorRes) {
            return false;
        }
        if (this.imageRes != other.imageRes) {
            return false;
        }
        return !n.b(this.trackingTag, other.trackingTag) ? z3 : z;
    }

    public int hashCode() {
        return (Integer.hashCode(this.titleRes) * 31) + Integer.hashCode(this.descriptionRes) * 31 + Integer.hashCode(this.authorRes) * 31 + Integer.hashCode(this.imageRes) * 31 + this.trackingTag.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "WelcomeSlide(titleRes=";
        String str3 = ", descriptionRes=";
        String str4 = ", authorRes=";
        String str5 = ", imageRes=";
        String str6 = ", trackingTag=";
        str = str2 + this.titleRes + str3 + this.descriptionRes + str4 + this.authorRes + str5 + this.imageRes + str6 + this.trackingTag + 41;
        return str;
    }
}
