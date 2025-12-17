package zendesk.belvedere;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class r implements Parcelable {

    public static final Parcelable.Creator<zendesk.belvedere.r> CREATOR;
    private final boolean a;
    private final int b;
    private final Intent c;
    private final String v;
    private final int w;

    static class a implements Parcelable.Creator<zendesk.belvedere.r> {
        @Override // android.os.Parcelable$Creator
        public zendesk.belvedere.r a(Parcel parcel) {
            r rVar = new r(parcel);
            return rVar;
        }

        @Override // android.os.Parcelable$Creator
        public zendesk.belvedere.r[] b(int i) {
            return new r[i];
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

    public static class b {

        private final zendesk.belvedere.t a;
        private final zendesk.belvedere.o b;
        private final int c;
        b(int i, zendesk.belvedere.t t2, zendesk.belvedere.o o3) {
            super();
            this.c = i;
            this.a = t2;
            this.b = o3;
        }

        public zendesk.belvedere.r a() {
            boolean z;
            int i;
            d.h.k.d dVar = this.a.c(this.c);
            Object obj2 = dVar.a;
            if ((r)obj2.d()) {
                this.b.e(this.c, (s)dVar.b);
            }
            return obj2;
        }
    }

    public static class c {

        private final zendesk.belvedere.t a;
        private final int b;
        String c;
        List<String> d;
        boolean e = false;
        c(int i, zendesk.belvedere.t t2) {
            super();
            this.a = t2;
            this.b = i;
            this.c = "*/*";
            ArrayList obj1 = new ArrayList();
            this.d = obj1;
            obj1 = 0;
        }

        public zendesk.belvedere.r.c a(boolean z) {
            this.e = z;
            return this;
        }

        public zendesk.belvedere.r b() {
            return this.a.f(this.b, this.c, this.e, this.d);
        }

        public zendesk.belvedere.r.c c(String string) {
            this.c = string;
            ArrayList obj1 = new ArrayList();
            this.d = obj1;
            return this;
        }
    }
    static {
        r.a aVar = new r.a();
        r.CREATOR = aVar;
    }

    r(int i, Intent intent2, String string3, boolean z4, int i5) {
        super();
        this.b = i;
        this.c = intent2;
        this.v = string3;
        this.a = z4;
        this.w = i5;
    }

    r(Parcel parcel) {
        super();
        this.b = parcel.readInt();
        this.c = (Intent)parcel.readParcelable(r.class.getClassLoader());
        this.v = parcel.readString();
        boolean[] zArr = new boolean[1];
        parcel.readBooleanArray(zArr);
        this.a = zArr[0];
        this.w = parcel.readInt();
    }

    static zendesk.belvedere.r e() {
        super(-1, 0, 0, 0, -1);
        return rVar2;
    }

    @Override // android.os.Parcelable
    public Intent a() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public String b() {
        return this.v;
    }

    @Override // android.os.Parcelable
    public int c() {
        return this.w;
    }

    @Override // android.os.Parcelable
    public boolean d() {
        return this.a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void f(Fragment fragment) {
        fragment.startActivityForResult(this.c, this.b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.b);
        parcel.writeParcelable(this.c, i2);
        parcel.writeString(this.v);
        boolean[] obj4 = new boolean[1];
        parcel.writeBooleanArray(this.a);
        parcel.writeInt(this.w);
    }
}
