package d.a.o;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.ViewConfiguration;
import d.a.a;
import d.a.b;
import d.a.d;
import d.a.j;

/* compiled from: ActionBarPolicy.java */
/* loaded from: classes.dex */
public class a {

    private Context a;
    private a(Context context) {
        super();
        this.a = context;
    }

    public static a b(Context context) {
        return new a(context);
    }

    public boolean a() {
        boolean z = true;
        int r0 = this.a.getApplicationInfo().targetSdkVersion < 14 ? 1 : 0;
        return (this.a.getApplicationInfo().targetSdkVersion < 14 ? 1 : 0);
    }

    public int c() {
        return this.a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public int d() {
        Configuration configuration = this.a.getResources().getConfiguration();
        int i2 = 600;
        int smallestScreenWidthDp2 = 720;
        i2 = 960;
        return 5;
    }

    public int e() throws android.content.res.Resources.NotFoundException {
        return this.a.getResources().getDimensionPixelSize(d.b);
    }

    public int f() throws android.content.res.Resources.NotFoundException {
        int layoutDimension;
        final int i5 = 0;
        TypedArray styledAttributes = this.a.obtainStyledAttributes(null, j.a, a.c, i5);
        if (!g()) {
            layoutDimension = Math.min(styledAttributes.getLayoutDimension(j.j, i5), this.a.getResources().getDimensionPixelSize(d.a));
        }
        styledAttributes.recycle();
        return layoutDimension;
    }

    public boolean g() throws android.content.res.Resources.NotFoundException {
        return this.a.getResources().getBoolean(b.a);
    }

    public boolean h() {
        final boolean z = true;
        if (Build.VERSION.SDK_INT >= 19) {
            return true;
        }
        return ViewConfiguration.get(this.a).hasPermanentMenuKey() ^ z;
    }
}
