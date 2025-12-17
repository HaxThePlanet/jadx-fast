package androidx.core.app;

import android.app.Notification;
import android.app.Notification.BigPictureStyle;
import android.app.Notification.BigTextStyle;
import android.app.Notification.BubbleMetadata;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes.Builder;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.content.b;
import androidx.core.graphics.drawable.IconCompat;
import d.h.b;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class j {

    public static class a {

        final Bundle a;
        private IconCompat b;
        private final androidx.core.app.o[] c;
        private final androidx.core.app.o[] d;
        private boolean e;
        boolean f;
        private final int g;
        private final boolean h;
        @Deprecated
        public int i;
        public java.lang.CharSequence j;
        public PendingIntent k;
        public a(int i, java.lang.CharSequence charSequence2, PendingIntent pendingIntent3) {
            int i2;
            String str;
            if (i == 0) {
            } else {
                i2 = IconCompat.c(0, "", i);
            }
            super(i2, charSequence2, pendingIntent3);
        }

        public a(IconCompat iconCompat, java.lang.CharSequence charSequence2, PendingIntent pendingIntent3) {
            Bundle bundle = new Bundle();
            super(iconCompat, charSequence2, pendingIntent3, bundle, 0, 0, 1, 0, 1, 0);
        }

        a(IconCompat iconCompat, java.lang.CharSequence charSequence2, PendingIntent pendingIntent3, Bundle bundle4, androidx.core.app.o[] o5Arr5, androidx.core.app.o[] o6Arr6, boolean z7, int i8, boolean z9, boolean z10) {
            int i2;
            int i;
            IconCompat obj3;
            Bundle obj6;
            super();
            this.f = true;
            this.b = iconCompat;
            if (iconCompat != null && iconCompat.i() == 2) {
                if (iconCompat.i() == 2) {
                    this.i = iconCompat.e();
                }
            }
            this.j = j.e.e(charSequence2);
            this.k = pendingIntent3;
            if (bundle4 != null) {
            } else {
                obj6 = new Bundle();
            }
            this.a = obj6;
            this.c = o5Arr5;
            this.d = o6Arr6;
            this.e = z7;
            this.g = i8;
            this.f = z9;
            this.h = z10;
        }

        public PendingIntent a() {
            return this.k;
        }

        public boolean b() {
            return this.e;
        }

        public androidx.core.app.o[] c() {
            return this.d;
        }

        public Bundle d() {
            return this.a;
        }

        public IconCompat e() {
            IconCompat iconCompat;
            int i;
            String str;
            iconCompat = this.i;
            if (this.b == null && iconCompat != 0) {
                iconCompat = this.i;
                if (iconCompat != 0) {
                    this.b = IconCompat.c(0, "", iconCompat);
                }
            }
            return this.b;
        }

        public androidx.core.app.o[] f() {
            return this.c;
        }

        public int g() {
            return this.g;
        }

        public boolean h() {
            return this.f;
        }

        public java.lang.CharSequence i() {
            return this.j;
        }

        public boolean j() {
            return this.h;
        }
    }

    public static final class d {
        public static Notification.BubbleMetadata c(androidx.core.app.j.d j$d) {
            final int i = 0;
            if (d == null) {
                return i;
            }
            final int sDK_INT = Build.VERSION.SDK_INT;
            if (sDK_INT >= 30) {
                return j.d.b.a(d);
            }
            if (sDK_INT == 29) {
                return j.d.a.a(d);
            }
            return i;
        }

        public PendingIntent a() {
            throw 0;
        }

        public String b() {
            throw 0;
        }
    }

    public static class e {

        boolean A;
        boolean B;
        String C;
        Bundle D;
        int E;
        int F;
        Notification G;
        RemoteViews H;
        RemoteViews I;
        RemoteViews J;
        String K;
        int L;
        String M;
        b N;
        long O;
        int P;
        boolean Q;
        androidx.core.app.j.d R;
        Notification S;
        boolean T;
        Icon U;
        @Deprecated
        public ArrayList<String> V;
        public Context a;
        public ArrayList<androidx.core.app.j.a> b;
        public ArrayList<androidx.core.app.n> c;
        ArrayList<androidx.core.app.j.a> d;
        java.lang.CharSequence e;
        java.lang.CharSequence f;
        PendingIntent g;
        PendingIntent h;
        RemoteViews i;
        Bitmap j;
        java.lang.CharSequence k;
        int l;
        int m;
        boolean n;
        boolean o;
        androidx.core.app.j.f p;
        java.lang.CharSequence q;
        java.lang.CharSequence r;
        java.lang.CharSequence[] s;
        int t;
        int u;
        boolean v;
        String w;
        boolean x;
        String y;
        boolean z;
        @Deprecated
        public e(Context context) {
            super(context, 0);
        }

        public e(Context context, String string2) {
            super();
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            ArrayList arrayList2 = new ArrayList();
            this.c = arrayList2;
            ArrayList arrayList3 = new ArrayList();
            this.d = arrayList3;
            int i = 1;
            this.n = i;
            final int i2 = 0;
            this.z = i2;
            this.E = i2;
            this.F = i2;
            this.L = i2;
            this.P = i2;
            Notification notification = new Notification();
            this.S = notification;
            this.a = context;
            this.K = string2;
            notification.when = System.currentTimeMillis();
            obj4.audioStreamType = -1;
            this.m = i2;
            ArrayList obj4 = new ArrayList();
            this.V = obj4;
            this.Q = i;
        }

        protected static java.lang.CharSequence e(java.lang.CharSequence charSequence) {
            int length;
            java.lang.CharSequence obj2;
            if (charSequence == null) {
                return charSequence;
            }
            final int i = 5120;
            if (charSequence.length() > i) {
                obj2 = charSequence.subSequence(0, i);
            }
            return obj2;
        }

        private Bitmap f(Bitmap bitmap) {
            int sDK_INT;
            int i;
            int i4;
            int height2;
            int height;
            int i3;
            int i2;
            double d;
            Bitmap obj10;
            if (bitmap != null) {
                if (Build.VERSION.SDK_INT >= 27) {
                } else {
                    Resources resources = this.a.getResources();
                    int dimensionPixelSize2 = resources.getDimensionPixelSize(b.b);
                    int dimensionPixelSize = resources.getDimensionPixelSize(b.a);
                    if (bitmap.getWidth() <= dimensionPixelSize2 && bitmap.getHeight() <= dimensionPixelSize) {
                        if (bitmap.getHeight() <= dimensionPixelSize) {
                            return bitmap;
                        }
                    }
                    i3 = 1;
                    int i9 = Math.max(i3, bitmap.getWidth());
                    double d2 = Math.min(d3 /= d5, height2);
                    obj10 = Bitmap.createScaledBitmap(bitmap, (int)ceil2, (int)ceil, i3);
                }
            }
            return obj10;
        }

        private void p(int i, boolean z2) {
            int flags;
            int obj2;
            Notification obj3;
            if (z2) {
                obj3 = this.S;
                obj3.flags = i |= flags;
            } else {
                obj3 = this.S;
                obj3.flags = obj2 &= flags;
            }
        }

        public androidx.core.app.j.e A(androidx.core.app.j.f j$f) {
            this.p = f;
            if (this.p != f && f != null) {
                this.p = f;
                if (f != null) {
                    f.g(this);
                }
            }
            return this;
        }

        public androidx.core.app.j.e B(java.lang.CharSequence charSequence) {
            notification.tickerText = j.e.e(charSequence);
            return this;
        }

        public androidx.core.app.j.e C(long[] lArr) {
            notification.vibrate = lArr;
            return this;
        }

        public androidx.core.app.j.e D(int i) {
            this.F = i;
            return this;
        }

        public androidx.core.app.j.e E(long l) {
            notification.when = l;
            return this;
        }

        public androidx.core.app.j.e a(int i, java.lang.CharSequence charSequence2, PendingIntent pendingIntent3) {
            j.a aVar = new j.a(i, charSequence2, pendingIntent3);
            this.b.add(aVar);
            return this;
        }

        public androidx.core.app.j.e b(androidx.core.app.j.a j$a) {
            ArrayList list;
            if (a != null) {
                this.b.add(a);
            }
            return this;
        }

        public Notification c() {
            k kVar = new k(this);
            return kVar.c();
        }

        public Bundle d() {
            Bundle bundle;
            if (this.D == null) {
                bundle = new Bundle();
                this.D = bundle;
            }
            return this.D;
        }

        public androidx.core.app.j.e g(boolean z) {
            p(16, z);
            return this;
        }

        public androidx.core.app.j.e h(String string) {
            this.C = string;
            return this;
        }

        public androidx.core.app.j.e i(String string) {
            this.K = string;
            return this;
        }

        public androidx.core.app.j.e j(int i) {
            this.E = i;
            return this;
        }

        public androidx.core.app.j.e k(PendingIntent pendingIntent) {
            this.g = pendingIntent;
            return this;
        }

        public androidx.core.app.j.e l(java.lang.CharSequence charSequence) {
            this.f = j.e.e(charSequence);
            return this;
        }

        public androidx.core.app.j.e m(java.lang.CharSequence charSequence) {
            this.e = j.e.e(charSequence);
            return this;
        }

        public androidx.core.app.j.e n(int i) {
            int obj2;
            final Notification notification = this.S;
            notification.defaults = i;
            if (i &= 4 != 0) {
                notification.flags = obj2 |= 1;
            }
            return this;
        }

        public androidx.core.app.j.e o(PendingIntent pendingIntent) {
            notification.deleteIntent = pendingIntent;
            return this;
        }

        public androidx.core.app.j.e q(Bitmap bitmap) {
            this.j = f(bitmap);
            return this;
        }

        public androidx.core.app.j.e r(int i, int i2, int i3) {
            int obj2;
            final Notification notification = this.S;
            notification.ledARGB = i;
            notification.ledOnMS = i2;
            notification.ledOffMS = i3;
            if (i2 != 0 && i3 != 0) {
                obj2 = i3 != 0 ? 1 : 0;
            } else {
            }
            notification.flags = obj2 |= obj3;
            return this;
        }

        public androidx.core.app.j.e s(boolean z) {
            this.z = z;
            return this;
        }

        public androidx.core.app.j.e t(int i) {
            this.l = i;
            return this;
        }

        public androidx.core.app.j.e u(boolean z) {
            p(2, z);
            return this;
        }

        public androidx.core.app.j.e v(int i) {
            this.m = i;
            return this;
        }

        public androidx.core.app.j.e w(int i, int i2, boolean z3) {
            this.t = i;
            this.u = i2;
            this.v = z3;
            return this;
        }

        public androidx.core.app.j.e x(boolean z) {
            this.n = z;
            return this;
        }

        public androidx.core.app.j.e y(int i) {
            notification.icon = i;
            return this;
        }

        public androidx.core.app.j.e z(Uri uri) {
            int i;
            int obj3;
            final Notification notification = this.S;
            notification.sound = uri;
            notification.audioStreamType = -1;
            if (Build.VERSION.SDK_INT >= 21) {
                obj3 = new AudioAttributes.Builder();
                notification.audioAttributes = obj3.setContentType(4).setUsage(5).build();
            }
            return this;
        }
    }

    public static abstract class f {

        protected androidx.core.app.j.e a;
        java.lang.CharSequence b;
        java.lang.CharSequence c;
        boolean d = false;
        public f() {
            super();
            final int i = 0;
        }

        public void a(Bundle bundle) {
            boolean z;
            String str;
            if (this.d) {
                bundle.putCharSequence("android.summaryText", this.c);
            }
            java.lang.CharSequence charSequence = this.b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String str2 = c();
            if (str2 != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", str2);
            }
        }

        public abstract void b(androidx.core.app.i i);

        protected abstract String c();

        public RemoteViews d(androidx.core.app.i i) {
            return null;
        }

        public RemoteViews e(androidx.core.app.i i) {
            return null;
        }

        public RemoteViews f(androidx.core.app.i i) {
            return null;
        }

        public void g(androidx.core.app.j.e j$e) {
            this.a = e;
            if (this.a != e && e != null) {
                this.a = e;
                if (e != null) {
                    e.A(this);
                }
            }
        }
    }

    public static class b extends androidx.core.app.j.f {

        private Bitmap e;
        private IconCompat f;
        private boolean g;
        @Override // androidx.core.app.j$f
        public void b(androidx.core.app.i i) {
            int sDK_INT;
            int bigPicture;
            boolean z;
            int i2;
            int i3;
            Object obj6;
            sDK_INT = Build.VERSION.SDK_INT;
            Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle(i.a());
            bigPicture = bigPictureStyle.setBigContentTitle(this.b).bigPicture(this.e);
            if (sDK_INT >= 16 && this.g) {
                bigPictureStyle = new Notification.BigPictureStyle(i.a());
                bigPicture = bigPictureStyle.setBigContentTitle(this.b).bigPicture(this.e);
                if (this.g) {
                    z = this.f;
                    i2 = 0;
                    if (z == null) {
                        j.b.a.a(bigPicture, i2);
                    } else {
                        if (sDK_INT >= 23) {
                            if (i instanceof k) {
                                i2 = (k)i.f();
                            }
                            j.b.b.a(bigPicture, this.f.q(i2));
                        } else {
                            if (z.i() == 1) {
                                j.b.a.a(bigPicture, this.f.d());
                            } else {
                                j.b.a.a(bigPicture, i2);
                            }
                        }
                    }
                }
                if (this.d) {
                    j.b.a.b(bigPicture, this.c);
                }
            }
        }

        @Override // androidx.core.app.j$f
        protected String c() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }

        @Override // androidx.core.app.j$f
        public androidx.core.app.j.b h(Bitmap bitmap) {
            int obj1;
            if (bitmap == null) {
                obj1 = 0;
            } else {
                obj1 = IconCompat.b(bitmap);
            }
            this.f = obj1;
            this.g = true;
            return this;
        }

        @Override // androidx.core.app.j$f
        public androidx.core.app.j.b i(Bitmap bitmap) {
            this.e = bitmap;
            return this;
        }

        @Override // androidx.core.app.j$f
        public androidx.core.app.j.b j(java.lang.CharSequence charSequence) {
            this.c = j.e.e(charSequence);
            this.d = true;
            return this;
        }
    }

    public static class c extends androidx.core.app.j.f {

        private java.lang.CharSequence e;
        @Override // androidx.core.app.j$f
        public void a(Bundle bundle) {
            int sDK_INT;
            int str;
            super.a(bundle);
            if (Build.VERSION.SDK_INT < 21) {
                bundle.putCharSequence("android.bigText", this.e);
            }
        }

        @Override // androidx.core.app.j$f
        public void b(androidx.core.app.i i) {
            int sDK_INT;
            Notification.BigTextStyle obj3;
            Notification.BigTextStyle bigTextStyle = new Notification.BigTextStyle(i.a());
            if (Build.VERSION.SDK_INT >= 16 && this.d) {
                bigTextStyle = new Notification.BigTextStyle(i.a());
                if (this.d) {
                    bigTextStyle.setBigContentTitle(this.b).bigText(this.e).setSummaryText(this.c);
                }
            }
        }

        @Override // androidx.core.app.j$f
        protected String c() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        @Override // androidx.core.app.j$f
        public androidx.core.app.j.c h(java.lang.CharSequence charSequence) {
            this.e = j.e.e(charSequence);
            return this;
        }
    }
    public static Bundle a(Notification notification) {
        final int sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 19) {
            return notification.extras;
        }
        if (sDK_INT >= 16) {
            return l.c(notification);
        }
        return null;
    }
}
