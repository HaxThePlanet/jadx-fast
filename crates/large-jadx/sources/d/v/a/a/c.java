package d.v.a.a;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import androidx.core.content.e.g;
import androidx.core.graphics.drawable.a;
import d.e.a;
import d.e.g;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
public class c extends d.v.a.a.h implements Animatable {

    private d.v.a.a.c.c b;
    private Context c;
    private ArgbEvaluator v;
    private Animator.AnimatorListener w;
    ArrayList<d.v.a.a.b> x;
    final Drawable.Callback y;

    class a implements Drawable.Callback {

        final d.v.a.a.c a;
        a(d.v.a.a.c c) {
            this.a = c;
            super();
        }

        @Override // android.graphics.drawable.Drawable$Callback
        public void invalidateDrawable(Drawable drawable) {
            this.a.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable$Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable2, long l3) {
            this.a.scheduleSelf(runnable2, l3);
        }

        @Override // android.graphics.drawable.Drawable$Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable2) {
            this.a.unscheduleSelf(runnable2);
        }
    }

    class b extends AnimatorListenerAdapter {

        final d.v.a.a.c a;
        b(d.v.a.a.c c) {
            this.a = c;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            int i;
            Object obj;
            d.v.a.a.c cVar;
            ArrayList obj5 = new ArrayList(cVar2.x);
            i = 0;
            while (i < obj5.size()) {
                (b)obj5.get(i).onAnimationEnd(this.a);
                i++;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
            int i;
            Object obj;
            d.v.a.a.c cVar;
            ArrayList obj5 = new ArrayList(cVar2.x);
            i = 0;
            while (i < obj5.size()) {
                (b)obj5.get(i).onAnimationStart(this.a);
                i++;
            }
        }
    }

    private static class c extends Drawable.ConstantState {

        int a;
        d.v.a.a.i b;
        AnimatorSet c;
        ArrayList<Animator> d;
        a<Animator, String> e;
        public c(Context context, d.v.a.a.c.c c$c2, Drawable.Callback drawable$Callback3, Resources resources4) {
            int i;
            a aVar;
            ArrayList obj3;
            Object obj5;
            Resources obj6;
            super();
            this.a = c2.a;
            obj3 = c2.b;
            if (c2 != null && obj3 != null) {
                this.a = c2.a;
                obj3 = c2.b;
                if (obj3 != null) {
                    obj3 = obj3.getConstantState();
                    if (resources4 != null) {
                        this.b = (i)obj3.newDrawable(resources4);
                    } else {
                        this.b = (i)obj3.newDrawable();
                    }
                    obj3 = this.b;
                    obj3.mutate();
                    this.b = (i)obj3;
                    obj3.setCallback(callback3);
                    this.b.setBounds(c2.b.getBounds());
                    this.b.h(false);
                }
                obj3 = c2.d;
                if (obj3 != null) {
                    obj3 = obj3.size();
                    obj5 = new ArrayList(obj3);
                    this.d = obj5;
                    obj5 = new a(obj3);
                    this.e = obj5;
                    while (i < obj3) {
                        obj5 = c2.d.get(i);
                        obj6 = (Animator)obj5.clone();
                        obj5 = c2.e.get(obj5);
                        obj6.setTarget(this.b.d((String)obj5));
                        this.d.add(obj6);
                        this.e.put(obj6, obj5);
                        i++;
                    }
                    a();
                }
            }
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public void a() {
            AnimatorSet animatorSet;
            if (this.c == null) {
                animatorSet = new AnimatorSet();
                this.c = animatorSet;
            }
            this.c.playTogether(this.d);
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public int getChangingConfigurations() {
            return this.a;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable() {
            IllegalStateException illegalStateException = new IllegalStateException("No constant state support for SDK < 24.");
            throw illegalStateException;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable(Resources resources) {
            IllegalStateException obj2 = new IllegalStateException("No constant state support for SDK < 24.");
            throw obj2;
        }
    }

    private static class d extends Drawable.ConstantState {

        private final Drawable.ConstantState a;
        public d(Drawable.ConstantState drawable$ConstantState) {
            super();
            this.a = constantState;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public boolean canApplyTheme() {
            return this.a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public int getChangingConfigurations() {
            return this.a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable() {
            c cVar = new c();
            Drawable drawable = this.a.newDrawable();
            cVar.a = drawable;
            drawable.setCallback(cVar.y);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable(Resources resources) {
            c cVar = new c();
            final Drawable obj3 = this.a.newDrawable(resources);
            cVar.a = obj3;
            obj3.setCallback(cVar.y);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme resources$Theme2) {
            c cVar = new c();
            final Drawable obj3 = this.a.newDrawable(resources, theme2);
            cVar.a = obj3;
            obj3.setCallback(cVar.y);
            return cVar;
        }
    }
    c() {
        final int i = 0;
        super(i, i, i);
    }

    private c(Context context) {
        final int i = 0;
        super(context, i, i);
    }

    private c(Context context, d.v.a.a.c.c c$c2, Resources resources3) {
        d.v.a.a.c.c cVar;
        super();
        int i = 0;
        this.v = i;
        this.w = i;
        this.x = i;
        c.a aVar = new c.a(this);
        this.y = aVar;
        this.c = context;
        if (c2 != null) {
            this.b = c2;
        } else {
            cVar = new c.c(context, c2, aVar, resources3);
            this.b = cVar;
        }
    }

    public static d.v.a.a.c a(Context context, Resources resources2, XmlPullParser xmlPullParser3, AttributeSet attributeSet4, Resources.Theme resources$Theme5) {
        c cVar = new c(context);
        cVar.inflate(resources2, xmlPullParser3, attributeSet4, theme5);
        return cVar;
    }

    public static void b(Drawable drawable, d.v.a.a.b b2) {
        int sDK_INT;
        int i;
        if (drawable != null) {
            if (b2 == null) {
            } else {
                if (!drawable instanceof Animatable) {
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    c.d((AnimatedVectorDrawable)drawable, b2);
                } else {
                    (c)drawable.c(b2);
                }
            }
        }
    }

    private static void d(AnimatedVectorDrawable animatedVectorDrawable, d.v.a.a.b b2) {
        animatedVectorDrawable.registerAnimationCallback(b2.getPlatformCallback());
    }

    private void e(String string, Animator animator2) {
        d.v.a.a.c.c cVar;
        Object aVar;
        animator2.setTarget(cVar2.b.d(string));
        if (Build.VERSION.SDK_INT < 21) {
            f(animator2);
        }
        cVar = this.b;
        if (cVar.d == null) {
            ArrayList arrayList = new ArrayList();
            cVar.d = arrayList;
            aVar = new a();
            cVar.e = aVar;
        }
        cVar3.d.add(animator2);
        cVar4.e.put(animator2, string);
    }

    private void f(Animator animator) {
        boolean childAnimations;
        boolean propertyName;
        ArgbEvaluator argbEvaluator;
        int equals;
        int size;
        childAnimations = (AnimatorSet)animator.getChildAnimations();
        if (animator instanceof AnimatorSet != null && childAnimations != null) {
            childAnimations = (AnimatorSet)animator.getChildAnimations();
            if (childAnimations != null) {
                equals = 0;
                while (equals < childAnimations.size()) {
                    f((Animator)childAnimations.get(equals));
                    equals++;
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            propertyName = (ObjectAnimator)animator.getPropertyName();
            if (!"fillColor".equals(propertyName)) {
                if ("strokeColor".equals(propertyName) && this.v == null) {
                    if (this.v == null) {
                        argbEvaluator = new ArgbEvaluator();
                        this.v = argbEvaluator;
                    }
                    animator.setEvaluator(this.v);
                }
            } else {
            }
        }
    }

    @Override // d.v.a.a.h
    public void applyTheme(Resources.Theme resources$Theme) {
        final Drawable drawable = this.a;
        if (drawable != null) {
            a.a(drawable, theme);
        }
    }

    @Override // d.v.a.a.h
    public void c(d.v.a.a.b b) {
        ArrayList arrayList;
        Object obj2;
        Drawable drawable = this.a;
        if (drawable != null) {
            c.d((AnimatedVectorDrawable)drawable, b);
        }
        if (b == null) {
        }
        if (this.x == null) {
            arrayList = new ArrayList();
            this.x = arrayList;
        }
        if (this.x.contains(b)) {
        }
        this.x.add(b);
        if (this.w == null) {
            obj2 = new c.b(this);
            this.w = obj2;
        }
        obj2.c.addListener(this.w);
    }

    @Override // d.v.a.a.h
    public boolean canApplyTheme() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return a.b(drawable);
        }
        return 0;
    }

    @Override // d.v.a.a.h
    public void draw(Canvas canvas) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        cVar.b.draw(canvas);
        if (obj2.c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // d.v.a.a.h
    public int getAlpha() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return a.d(drawable);
        }
        return cVar.b.getAlpha();
    }

    @Override // d.v.a.a.h
    public int getChangingConfigurations() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return changingConfigurations2 |= i2;
    }

    @Override // d.v.a.a.h
    public ColorFilter getColorFilter() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return a.e(drawable);
        }
        return cVar.b.getColorFilter();
    }

    @Override // d.v.a.a.h
    public Drawable.ConstantState getConstantState() {
        Drawable sDK_INT;
        int i;
        if (this.a != null && Build.VERSION.SDK_INT >= 24) {
            if (Build.VERSION.SDK_INT >= 24) {
                c.d dVar = new c.d(this.a.getConstantState());
                return dVar;
            }
        }
        return null;
    }

    @Override // d.v.a.a.h
    public int getIntrinsicHeight() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return cVar.b.getIntrinsicHeight();
    }

    @Override // d.v.a.a.h
    public int getIntrinsicWidth() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return cVar.b.getIntrinsicWidth();
    }

    @Override // d.v.a.a.h
    public int getOpacity() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return cVar.b.getOpacity();
    }

    @Override // d.v.a.a.h
    public void inflate(Resources resources, XmlPullParser xmlPullParser2, AttributeSet attributeSet3) {
        inflate(resources, xmlPullParser2, attributeSet3, 0);
    }

    @Override // d.v.a.a.h
    public void inflate(Resources resources, XmlPullParser xmlPullParser2, AttributeSet attributeSet3, Resources.Theme resources$Theme4) {
        int eventType;
        int resourceId2;
        int resourceId;
        Context context;
        Drawable drawable = this.a;
        if (drawable != null) {
            a.g(drawable, resources, xmlPullParser2, attributeSet3, theme4);
        }
        eventType = xmlPullParser2.getEventType();
        final int i2 = 1;
        while (eventType != i2) {
            eventType = xmlPullParser2.next();
            String name = xmlPullParser2.getName();
            resourceId = 0;
            eventType = resources.obtainAttributes(attributeSet3, a.f);
            resourceId = eventType.getResourceId(i2, resourceId);
            eventType.recycle();
            context = this.c;
            e(eventType.getString(resourceId), e.i(context, resourceId));
            eventType = g.s(resources, theme4, attributeSet3, a.e);
            resourceId2 = eventType.getResourceId(resourceId, resourceId);
            resourceId2 = i.b(resources, resourceId2, theme4);
            resourceId2.h(resourceId);
            resourceId2.setCallback(this.y);
            d.v.a.a.i iVar = cVar.b;
            if (resourceId2 != 0 && iVar != null) {
            }
            eventType.recycle();
            resourceId2 = i.b(resources, resourceId2, theme4);
            resourceId2.h(resourceId);
            resourceId2.setCallback(this.y);
            iVar = cVar.b;
            if (iVar != null) {
            }
            resourceId.b = resourceId2;
            iVar.setCallback(0);
        }
        this.b.a();
    }

    @Override // d.v.a.a.h
    public boolean isAutoMirrored() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return a.h(drawable);
        }
        return cVar.b.isAutoMirrored();
    }

    @Override // d.v.a.a.h
    public boolean isRunning() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return (AnimatedVectorDrawable)drawable.isRunning();
        }
        return cVar.c.isRunning();
    }

    @Override // d.v.a.a.h
    public boolean isStateful() {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return cVar.b.isStateful();
    }

    @Override // d.v.a.a.h
    public Drawable mutate() {
        final Drawable drawable = this.a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // d.v.a.a.h
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        cVar.b.setBounds(rect);
    }

    @Override // d.v.a.a.h
    protected boolean onLevelChange(int i) {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        return cVar.b.setLevel(i);
    }

    @Override // d.v.a.a.h
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return cVar.b.setState(iArr);
    }

    @Override // d.v.a.a.h
    public void setAlpha(int i) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
        cVar.b.setAlpha(i);
    }

    @Override // d.v.a.a.h
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.a;
        if (drawable != null) {
            a.j(drawable, z);
        }
        cVar.b.setAutoMirrored(z);
    }

    @Override // d.v.a.a.h
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        cVar.b.setColorFilter(colorFilter);
    }

    @Override // d.v.a.a.h
    public void setTint(int i) {
        Drawable drawable = this.a;
        if (drawable != null) {
            a.n(drawable, i);
        }
        cVar.b.setTint(i);
    }

    @Override // d.v.a.a.h
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.a;
        if (drawable != null) {
            a.o(drawable, colorStateList);
        }
        cVar.b.setTintList(colorStateList);
    }

    @Override // d.v.a.a.h
    public void setTintMode(PorterDuff.Mode porterDuff$Mode) {
        Drawable drawable = this.a;
        if (drawable != null) {
            a.p(drawable, mode);
        }
        cVar.b.setTintMode(mode);
    }

    @Override // d.v.a.a.h
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        cVar.b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // d.v.a.a.h
    public void start() {
        Drawable drawable = this.a;
        if (drawable != null) {
            (AnimatedVectorDrawable)drawable.start();
        }
        if (cVar.c.isStarted()) {
        }
        cVar2.c.start();
        invalidateSelf();
    }

    @Override // d.v.a.a.h
    public void stop() {
        Drawable drawable = this.a;
        if (drawable != null) {
            (AnimatedVectorDrawable)drawable.stop();
        }
        cVar.c.end();
    }
}
