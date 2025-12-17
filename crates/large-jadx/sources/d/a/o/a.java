package d.a.o;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.view.ViewConfiguration;
import d.a.a;
import d.a.b;
import d.a.d;
import d.a.j;

/* loaded from: classes.dex */
public class a {

    private Context a;
    private a(Context context) {
        super();
        this.a = context;
    }

    public static d.a.o.a b(Context context) {
        a aVar = new a(context);
        return aVar;
    }

    public boolean a() {
        int i;
        i = applicationInfo.targetSdkVersion < 14 ? 1 : 0;
        return i;
    }

    public int c() {
        return widthPixels /= 2;
    }

    public int d() {
        int smallestScreenWidthDp;
        int i;
        int i2;
        android.content.res.Configuration configuration = this.a.getResources().getConfiguration();
        final int screenWidthDp = configuration.screenWidthDp;
        final int screenHeightDp = configuration.screenHeightDp;
        i2 = 600;
        if (configuration.smallestScreenWidthDp <= i2 && screenWidthDp <= i2) {
            if (screenWidthDp <= i2) {
                smallestScreenWidthDp = 720;
                i2 = 960;
                if (screenWidthDp > i2) {
                    if (screenHeightDp <= smallestScreenWidthDp) {
                        if (screenWidthDp > smallestScreenWidthDp && screenHeightDp > i2) {
                            if (screenHeightDp > i2) {
                            } else {
                                if (screenWidthDp < 500) {
                                    i = 480;
                                    i2 = 640;
                                    if (screenWidthDp > i2) {
                                        if (screenHeightDp <= i) {
                                            if (screenWidthDp > i && screenHeightDp > i2) {
                                                if (screenHeightDp > i2) {
                                                } else {
                                                    if (screenWidthDp >= 360) {
                                                        return 3;
                                                    }
                                                }
                                            } else {
                                            }
                                        }
                                    } else {
                                    }
                                    return 2;
                                }
                            }
                        } else {
                        }
                    }
                } else {
                }
                return 4;
            }
        }
        return 5;
    }

    public int e() {
        return this.a.getResources().getDimensionPixelSize(d.b);
    }

    public int f() {
        int layoutDimension;
        Resources dimensionPixelSize;
        boolean z;
        final int i4 = 0;
        TypedArray styledAttributes = this.a.obtainStyledAttributes(0, j.a, a.c, i4);
        if (!g()) {
            layoutDimension = Math.min(styledAttributes.getLayoutDimension(j.j, i4), this.a.getResources().getDimensionPixelSize(d.a));
        }
        styledAttributes.recycle();
        return layoutDimension;
    }

    public boolean g() {
        return this.a.getResources().getBoolean(b.a);
    }

    public boolean h() {
        final int i2 = 1;
        if (Build.VERSION.SDK_INT >= 19) {
            return i2;
        }
        return permanentMenuKey ^= i2;
    }
}
