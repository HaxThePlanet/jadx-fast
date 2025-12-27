package d.v.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.content.res.XmlResourceParser;
import android.os.Build.VERSION;
import android.util.Xml;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import d.n.a.a.a;
import d.n.a.a.b;
import d.n.a.a.c;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: AnimationUtilsCompat.java */
/* loaded from: classes.dex */
public class d {
    private static Interpolator a(Context context, Resources resources, Resources.Theme theme, XmlPullParser xmlPullParser) throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        String name;
        boolean equals;
        int i = 0;
        i = 0;
        int next = xmlPullParser.next();
        int depth = 3;
        while (next == 3) {
            depth = 1;
            equals = 2;
        }
        return i;
    }

    public static Interpolator b(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return AnimationUtils.loadInterpolator(context, i);
        }
        if (i == 0x010c000f /* Unknown resource */) {
            try {
                return new a();
            } catch (Throwable th) {
            }
            if (Build.VERSION.SDK_INT == 0) {
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) th;
            } else {
                obj.close();
            }
        }
    }
}
