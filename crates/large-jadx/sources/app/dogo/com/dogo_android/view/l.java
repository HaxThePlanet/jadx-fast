package app.dogo.com.dogo_android.view;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import app.dogo.com.dogo_android.util.m0.a;
import kotlin.Metadata;
import kotlin.d0.d.n;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u000c\n\u0002\u0010\u0008\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0087\u0008\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000c\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\u0008\u0008\u0002\u0010\u0002\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0004\u001a\u00020\u00032\u0008\u0008\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\u000c\u0010\u0015\u001a\u0006\u0012\u0002\u0008\u00030\u0016H\u0014J\t\u0010\u0017\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\t\u0010\u0008R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\n\u0010\u0008¨\u0006\u001e", d2 = {"Lapp/dogo/com/dogo_android/view/GenericWebViewScreen;", "Lapp/dogo/com/dogo_android/util/navigation/ActivityScreenKey;", "htmlText", "", "titleText", "source", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getHtmlText", "()Ljava/lang/String;", "getSource", "getTitleText", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "getActivityClass", "Ljava/lang/Class;", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class l extends a {

    public static final Parcelable.Creator<app.dogo.com.dogo_android.view.l> CREATOR;
    private final String a;
    private final String b;
    private final String c;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<app.dogo.com.dogo_android.view.l> {
        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.view.l a(Parcel parcel) {
            n.f(parcel, "parcel");
            l lVar = new l(parcel.readString(), parcel.readString(), parcel.readString());
            return lVar;
        }

        @Override // android.os.Parcelable$Creator
        public final app.dogo.com.dogo_android.view.l[] b(int i) {
            return new l[i];
        }

        @Override // android.os.Parcelable$Creator
        public Object createFromParcel(Parcel parcel) {
            return a(parcel);
        }

        @Override // android.os.Parcelable$Creator
        public Object[] newArray(int i) {
            return b(i);
        }
    }
    static {
        l.a aVar = new l.a();
        l.CREATOR = aVar;
    }

    public l(String string, String string2, String string3) {
        n.f(string, "htmlText");
        n.f(string2, "titleText");
        n.f(string3, "source");
        super();
        this.a = string;
        this.b = string2;
        this.c = string3;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public final String a() {
        return this.a;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public final String b() {
        return this.b;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public int describeContents() {
        return 0;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public boolean equals(Object object) {
        final int i = 1;
        if (this == object) {
            return i;
        }
        final int i2 = 0;
        if (!object instanceof l) {
            return i2;
        }
        if (!n.b(this.a, object.a)) {
            return i2;
        }
        if (!n.b(this.b, object.b)) {
            return i2;
        }
        if (!n.b(this.c, object.c)) {
            return i2;
        }
        return i;
    }

    protected Class<?> getActivityClass() {
        return GenericWebViewActivity.class;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public int hashCode() {
        return i4 += i7;
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("GenericWebViewScreen(htmlText=");
        stringBuilder.append(this.a);
        stringBuilder.append(", titleText=");
        stringBuilder.append(this.b);
        stringBuilder.append(", source=");
        stringBuilder.append(this.c);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }

    @Override // app.dogo.com.dogo_android.util.m0.a
    public void writeToParcel(Parcel parcel, int i2) {
        n.f(parcel, "out");
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.c);
    }
}
