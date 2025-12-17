package zendesk.belvedere;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.appcompat.app.d;
import androidx.fragment.app.e;
import androidx.fragment.app.n;
import androidx.fragment.app.w;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class b {

    static class a {
    }

    public static class b {

        private final Context a;
        private boolean b;
        private List<zendesk.belvedere.r> c;
        private List<zendesk.belvedere.s> d;
        private List<zendesk.belvedere.s> e;
        private List<Integer> f;
        private long g;
        private boolean h;
        private b(Context context) {
            super();
            this.b = true;
            ArrayList arrayList = new ArrayList();
            this.c = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.d = arrayList2;
            ArrayList arrayList3 = new ArrayList();
            this.e = arrayList3;
            ArrayList arrayList4 = new ArrayList();
            this.f = arrayList4;
            this.g = -1;
            this.h = false;
            this.a = context;
        }

        b(Context context, zendesk.belvedere.b.a b$a2) {
            super(context);
        }

        static List a(zendesk.belvedere.b.b b$b) {
            return b.d;
        }

        static List b(zendesk.belvedere.b.b b$b) {
            return b.e;
        }

        static boolean c(zendesk.belvedere.b.b b$b) {
            return b.b;
        }

        static List d(zendesk.belvedere.b.b b$b) {
            return b.f;
        }

        static long e(zendesk.belvedere.b.b b$b) {
            return b.g;
        }

        static boolean f(zendesk.belvedere.b.b b$b) {
            return b.h;
        }

        public void g(d d) {
            final zendesk.belvedere.e obj3 = b.b(d);
            b.b.a aVar = new b.b.a(this, obj3);
            obj3.F1(this.c, aVar);
        }

        public zendesk.belvedere.b.b h() {
            this.c.add(a.c(this.a).a().a());
            return this;
        }

        public zendesk.belvedere.b.b i(String string, boolean z2) {
            zendesk.belvedere.r.c cVar = a.c(this.a).b();
            cVar.a(z2);
            cVar.c(string);
            this.c.add(cVar.b());
            return this;
        }

        public zendesk.belvedere.b.b j(List<zendesk.belvedere.s> list) {
            ArrayList arrayList = new ArrayList(list);
            this.e = arrayList;
            return this;
        }

        public zendesk.belvedere.b.b k(boolean z) {
            this.h = z;
            return this;
        }

        public zendesk.belvedere.b.b l(long l) {
            this.g = l;
            return this;
        }

        public zendesk.belvedere.b.b m(List<zendesk.belvedere.s> list) {
            ArrayList arrayList = new ArrayList(list);
            this.d = arrayList;
            return this;
        }

        public zendesk.belvedere.b.b n(int... iArr) {
            int i;
            Integer valueOf;
            ArrayList arrayList = new ArrayList(iArr.length);
            i = 0;
            while (i < iArr.length) {
                arrayList.add(Integer.valueOf(iArr[i]));
                i++;
            }
            this.f = arrayList;
            return this;
        }
    }

    public static class c implements Parcelable {

        public static final Parcelable.Creator<zendesk.belvedere.b.c> CREATOR;
        private final List<zendesk.belvedere.r> a;
        private final List<zendesk.belvedere.s> b;
        private final List<zendesk.belvedere.s> c;
        private final List<Integer> v;
        private final boolean w;
        private final long x;
        private final boolean y;
        static {
            b.c.a aVar = new b.c.a();
            b.c.CREATOR = aVar;
        }

        c(Parcel parcel) {
            int i2;
            int i;
            super();
            this.a = parcel.createTypedArrayList(r.CREATOR);
            Parcelable.Creator cREATOR2 = s.CREATOR;
            this.b = parcel.createTypedArrayList(cREATOR2);
            this.c = parcel.createTypedArrayList(cREATOR2);
            ArrayList arrayList = new ArrayList();
            this.v = arrayList;
            parcel.readList(arrayList, Integer.class.getClassLoader());
            final int i3 = 1;
            i2 = parcel.readInt() == i3 ? i3 : i;
            this.w = i2;
            this.x = parcel.readLong();
            i = parcel.readInt() == i3 ? i3 : i;
            this.y = i;
        }

        c(List<zendesk.belvedere.r> list, List<zendesk.belvedere.s> list2, List<zendesk.belvedere.s> list3, boolean z4, List<Integer> list5, long l6, boolean z7) {
            super();
            this.a = list;
            this.b = list2;
            this.c = list3;
            this.w = z4;
            this.v = list5;
            this.x = l6;
            this.y = obj8;
        }

        List<zendesk.belvedere.s> a() {
            return this.c;
        }

        List<zendesk.belvedere.r> b() {
            return this.a;
        }

        @Override // android.os.Parcelable
        long c() {
            return this.x;
        }

        List<zendesk.belvedere.s> d() {
            return this.b;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        List<Integer> e() {
            return this.v;
        }

        @Override // android.os.Parcelable
        boolean f() {
            return this.y;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeTypedList(this.a);
            parcel.writeTypedList(this.b);
            parcel.writeTypedList(this.c);
            parcel.writeList(this.v);
            parcel.writeInt(this.w);
            parcel.writeLong(this.x);
            parcel.writeInt(this.y);
        }
    }
    public static zendesk.belvedere.b.b a(Context context) {
        b.b bVar = new b.b(context, 0);
        return bVar;
    }

    public static zendesk.belvedere.e b(d d) {
        Object supportFragmentManager;
        androidx.fragment.app.Fragment eVar;
        supportFragmentManager = d.getSupportFragmentManager();
        final String str = "belvedere_image_stream";
        if (eVar instanceof e) {
        } else {
            eVar = new e();
            supportFragmentManager = supportFragmentManager.n();
            supportFragmentManager.d(eVar, str);
            supportFragmentManager.i();
        }
        eVar.N1(p.l(d));
        return eVar;
    }
}
