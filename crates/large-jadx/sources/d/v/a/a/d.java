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

/* loaded from: classes.dex */
public class d {
    private static Interpolator a(Context context, Resources resources2, Resources.Theme resources$Theme3, XmlPullParser xmlPullParser4) {
        String accelerateInterpolator;
        boolean equals;
        int depth;
        int obj4;
        obj4 = 0;
        accelerateInterpolator = xmlPullParser4.next();
        while (accelerateInterpolator == 3) {
            obj4 = Xml.asAttributeSet(xmlPullParser4);
            accelerateInterpolator = xmlPullParser4.getName();
            accelerateInterpolator = new g(context, obj4, xmlPullParser4);
            obj4 = accelerateInterpolator;
            accelerateInterpolator = xmlPullParser4.next();
            obj4 = new BounceInterpolator();
            accelerateInterpolator = new AnticipateOvershootInterpolator(context, obj4);
            accelerateInterpolator = new OvershootInterpolator(context, obj4);
            accelerateInterpolator = new AnticipateInterpolator(context, obj4);
            accelerateInterpolator = new CycleInterpolator(context, obj4);
            obj4 = new AccelerateDecelerateInterpolator();
            accelerateInterpolator = new DecelerateInterpolator(context, obj4);
            accelerateInterpolator = new AccelerateInterpolator(context, obj4);
            obj4 = new LinearInterpolator();
        }
        return obj4;
    }

    public static Interpolator b(Context context, int i2) {
        if (Build.VERSION.SDK_INT >= 21) {
            return AnimationUtils.loadInterpolator(context, i2);
        }
        int i = 0;
        final String str = "Can't load animation resource ID #0x";
        if (i2 == 17563663) {
            a obj4 = new a();
            return obj4;
        }
        if (i2 == 17563661) {
            obj4 = new b();
            return obj4;
        }
        if (i2 == 17563662) {
            obj4 = new c();
            return obj4;
        }
        XmlResourceParser animation = context.getResources().getAnimation(i2);
        if (animation != null) {
            animation.close();
        }
        return d.a(context, context.getResources(), context.getTheme(), animation);
    }
}
