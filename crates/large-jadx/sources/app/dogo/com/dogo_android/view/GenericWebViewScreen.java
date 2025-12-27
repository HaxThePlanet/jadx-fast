package app.dogo.com.dogo_android.view;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import app.dogo.com.dogo_android.util.m0.a;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* compiled from: GenericWebViewScreen.kt */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\u000c\u0010\u0015\u001a\u0006\u0012\u0002\u0008\u00030\u0016H\u0014J\t\u0010\u0017\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0008¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/view/GenericWebViewScreen;", "Lapp/dogo/com/dogo_android/util/navigation/ActivityScreenKey;", "htmlText", "", "titleText", "source", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHtmlText", "()Ljava/lang/String;", "getSource", "getTitleText", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "getActivityClass", "Ljava/lang/Class;", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: l, reason: from kotlin metadata */
public final /* data */ class GenericWebViewScreen extends a {

    public static final Parcelable.Creator<l> CREATOR = new l$a<>();
    /* renamed from: a, reason: from kotlin metadata */
    private final String htmlText;
    /* renamed from: b, reason: from kotlin metadata */
    private final String source;
    /* renamed from: c, reason: from kotlin metadata */
    private final String titleText;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<l> {
        public final l a(Parcel parcel) {
            n.f(parcel, "parcel");
            return new GenericWebViewScreen(parcel.readString(), parcel.readString(), parcel.readString());
        }

        public final l[] b(int i) {
            return new l[i];
        }
    }
    public l(String str, String str2, String str3) {
        n.f(str, "htmlText");
        n.f(str2, "titleText");
        n.f(str3, "source");
        super();
        this.htmlText = str;
        this.source = str2;
        this.titleText = str3;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    /* renamed from: a, reason: from kotlin metadata */
    /* operator */ public final String component1() {
        return this.htmlText;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public final String b() {
        return this.source;
    }


    @Override // app.dogo.com.dogo_android.util.m0.a
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    /* operator */ public boolean equals(Object other) {
        final boolean z = true;
        if (this == other) {
            return true;
        }
        final boolean z5 = false;
        if (!(other instanceof GenericWebViewScreen)) {
            return false;
        }
        if (!n.b(this.htmlText, other.htmlText)) {
            return false;
        }
        if (!n.b(this.source, other.source)) {
            return false;
        }
        return !n.b(this.titleText, other.titleText) ? z5 : z;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    protected Class<?> getActivityClass() {
        return GenericWebViewActivity.class;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public int hashCode() {
        return (this.htmlText.hashCode() * 31) + this.source.hashCode() * 31 + this.titleText.hashCode();
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String str2 = "GenericWebViewScreen(htmlText=";
        String str3 = ", titleText=";
        String str4 = ", source=";
        str = str2 + this.htmlText + str3 + this.source + str4 + this.titleText + 41;
        return str;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public void writeToParcel(Parcel parcel, int flags) {
        n.f(parcel, "out");
        parcel.writeString(this.htmlText);
        parcel.writeString(this.source);
        parcel.writeString(this.titleText);
    }
}
