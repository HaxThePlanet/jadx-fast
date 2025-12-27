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
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: AnimatedVectorDrawableCompat.java */
/* loaded from: classes.dex */
public class c extends h implements Animatable {

    private c.c b;
    private Context c;
    private ArgbEvaluator v;
    private Animator.AnimatorListener w;
    ArrayList<b> x;
    final Drawable.Callback y;

    class a implements Drawable.Callback {

        final /* synthetic */ c a;
        a() {
            this.a = cVar;
            super();
        }

        public void invalidateDrawable(Drawable drawable) {
            this.a.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            this.a.scheduleSelf(runnable, j);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            this.a.unscheduleSelf(runnable);
        }
    }

    class b extends AnimatorListenerAdapter {

        final /* synthetic */ c a;
        b() {
            this.a = cVar;
            super();
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationEnd(Animator animator) {
            int i = 0;
            final ArrayList arrayList = new ArrayList(this.a.x);
            i = 0;
            while (i < arrayList.size()) {
                (b)arrayList.get(i).onAnimationEnd(this.a);
                i = i + 1;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter
        public void onAnimationStart(Animator animator) {
            int i = 0;
            final ArrayList arrayList = new ArrayList(this.a.x);
            i = 0;
            while (i < arrayList.size()) {
                (b)arrayList.get(i).onAnimationStart(this.a);
                i = i + 1;
            }
        }
    }

    private static class c extends Drawable.ConstantState {

        int a;
        i b;
        AnimatorSet c;
        ArrayList<Animator> d = new ArrayList<>();
        d.e.a<Animator, String> e = new a<>();
        public c(Context context, c.c cVar, Drawable.Callback callback, Resources resources) {
            int i = 0;
            d.e.a aVar;
            Rect bounds;
            d.e.a aVar2;
            Animator clone;
            super();
            if (cVar != null) {
                this.a = cVar.a;
                boolean z = false;
                if (cVar.b != null) {
                    Drawable.ConstantState constantState = cVar.b.getConstantState();
                    if (resources != null) {
                        this.b = (i)constantState.newDrawable(resources);
                    } else {
                        this.b = (i)constantState.newDrawable();
                    }
                    this.b.mutate();
                    this.b = iVar3;
                    iVar3.setCallback(callback);
                    this.b.setBounds(cVar.b.getBounds());
                    this.b.h(false);
                }
                if (cVar.d != null) {
                    int size = cVar.d.size();
                    ArrayList arrayList = new ArrayList(size);
                    aVar2 = new a(size);
                    while (i < cVar.b) {
                        Object item = cVar.d.get(i);
                        clone = item.clone();
                        aVar2 = cVar.e.get(item);
                        clone.setTarget(this.b.d(aVar2));
                        this.d.add(clone);
                        this.e.put(clone, aVar2);
                        i = i + 1;
                    }
                    a();
                }
            }
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public void a() {
            if (this.c == null) {
                this.c = new AnimatorSet();
            }
            this.c.playTogether(this.d);
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public int getChangingConfigurations() {
            return this.a;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    private static class d extends Drawable.ConstantState {

        private final Drawable.ConstantState a;
        public d(Drawable.ConstantState constantState) {
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
            final d.v.a.a.c cVar = new c();
            Drawable drawable = this.a.newDrawable();
            cVar.a = drawable;
            drawable.setCallback(cVar.y);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable(Resources resources) {
            final d.v.a.a.c cVar = new c();
            final Drawable drawable = this.a.newDrawable(resources);
            cVar.a = drawable;
            drawable.setCallback(cVar.y);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable$ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            final d.v.a.a.c cVar = new c();
            final Drawable drawable = this.a.newDrawable(resources, theme);
            cVar.a = drawable;
            drawable.setCallback(cVar.y);
            return cVar;
        }
    }
    c() {
        final Context context = null;
        this(context, context, context);
    }

    public static c a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet set, Resources.Theme theme) {
        final d.v.a.a.c cVar = new c(context);
        cVar.inflate(resources, xmlPullParser, set, theme);
        return cVar;
    }

    public static void b(Drawable drawable, b bVar) {
    }

    private static void d(AnimatedVectorDrawable animatedVectorDrawable, b bVar) {
        animatedVectorDrawable.registerAnimationCallback(bVar.getPlatformCallback());
    }

    private void e(String str, Animator animator) {
        animator.setTarget(this.b.b.d(str));
        if (Build.VERSION.SDK_INT < 21) {
            f(animator);
        }
        if (cVar.d == null) {
            this.b.d = new ArrayList();
            this.b.e = new a();
        }
        this.b.d.add(animator);
        this.b.e.put(animator, str);
    }

    private void f(Animator animator) {
        int i;
        boolean equals2;
        z = animator instanceof AnimatorSet;
        if (animator instanceof AnimatorSet && childAnimations != null) {
            i = 0;
            while (i < childAnimations.size()) {
                f((Animator)childAnimations.get(i));
                i = i + 1;
            }
        }
        equals = animator instanceof ObjectAnimator;
        if (animator instanceof ObjectAnimator) {
            String propertyName = animator.getPropertyName();
            if (!"fillColor".equals(propertyName)) {
                if ("strokeColor".equals(propertyName) && this.v == null) {
                    this.v = new ArgbEvaluator();
                    animator.setEvaluator(this.v);
                }
            }
        }
    }

    @Override // d.v.a.a.h
    public void applyTheme(Resources.Theme theme) {
        if (this.a != null) {
            a.a(this.a, theme);
        }
    }

    @Override // d.v.a.a.h
    public void c(b bVar) {
        if (this.a != null) {
            c.d(drawable, bVar);
            return;
        }
        if (bVar == null) {
            return;
        }
        if (this.x == null) {
            this.x = new ArrayList();
        }
        if (this.x.contains(bVar)) {
            return;
        }
        this.x.add(bVar);
        if (this.w == null) {
            this.w = new c.b(this);
        }
        this.b.c.addListener(this.w);
    }

    @Override // d.v.a.a.h
    public boolean canApplyTheme() {
        if (this.a != null) {
            return a.b(this.a);
        }
        return false;
    }

    @Override // d.v.a.a.h
    public void draw(Canvas canvas) {
        if (this.a != null) {
            this.a.draw(canvas);
            return;
        }
        this.b.b.draw(canvas);
        if (this.b.c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // d.v.a.a.h
    public int getAlpha() {
        if (this.a != null) {
            return a.d(this.a);
        }
        return this.b.b.getAlpha();
    }

    @Override // d.v.a.a.h
    public int getChangingConfigurations() {
        if (this.a != null) {
            return this.a.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.b.a;
    }

    @Override // d.v.a.a.h
    public ColorFilter getColorFilter() {
        if (this.a != null) {
            return a.e(this.a);
        }
        return this.b.b.getColorFilter();
    }

    @Override // d.v.a.a.h
    public Drawable.ConstantState getConstantState() {
        if (this.a != null) {
            int i = 24;
            if (Build.VERSION.SDK_INT >= 24) {
                return new c.d(this.a.getConstantState());
            }
        }
        return null;
    }

    @Override // d.v.a.a.h
    public int getIntrinsicHeight() {
        if (this.a != null) {
            return this.a.getIntrinsicHeight();
        }
        return this.b.b.getIntrinsicHeight();
    }

    @Override // d.v.a.a.h
    public int getIntrinsicWidth() {
        if (this.a != null) {
            return this.a.getIntrinsicWidth();
        }
        return this.b.b.getIntrinsicWidth();
    }

    @Override // d.v.a.a.h
    public int getOpacity() {
        if (this.a != null) {
            return this.a.getOpacity();
        }
        return this.b.b.getOpacity();
    }

    @Override // d.v.a.a.h
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet set, Resources.Theme theme) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        int eventType;
        int resourceId;
        int resourceId2;
        Context context;
        Drawable.Callback callback = null;
        if (this.a != null) {
            a.g(this.a, resources, xmlPullParser, set, theme);
            return;
        }
        eventType = xmlPullParser.getEventType();
        final int i2 = 1;
        while (this.a != i2) {
            if (xmlPullParser.getDepth() >= xmlPullParser.getDepth() + i2 || this.a != 3) {
                resourceId = 2;
            }
        }
        this.b.a();
    }

    @Override // d.v.a.a.h
    public boolean isAutoMirrored() {
        if (this.a != null) {
            return a.h(this.a);
        }
        return this.b.b.isAutoMirrored();
    }

    @Override // d.v.a.a.h
    public boolean isRunning() {
        if (this.a != null) {
            return drawable.isRunning();
        }
        return this.b.c.isRunning();
    }

    @Override // d.v.a.a.h
    public boolean isStateful() {
        if (this.a != null) {
            return this.a.isStateful();
        }
        return this.b.b.isStateful();
    }

    @Override // d.v.a.a.h
    public Drawable mutate() {
        if (this.a != null) {
            this.a.mutate();
        }
        return this;
    }

    @Override // d.v.a.a.h
    protected void onBoundsChange(Rect rect) {
        if (this.a != null) {
            this.a.setBounds(rect);
            return;
        }
        this.b.b.setBounds(rect);
    }

    @Override // d.v.a.a.h
    protected boolean onLevelChange(int i) {
        if (this.a != null) {
            return this.a.setLevel(i);
        }
        return this.b.b.setLevel(i);
    }

    @Override // d.v.a.a.h
    protected boolean onStateChange(int[] iArr) {
        if (this.a != null) {
            return this.a.setState(iArr);
        }
        return this.b.b.setState(iArr);
    }

    @Override // d.v.a.a.h
    public void setAlpha(int i) {
        if (this.a != null) {
            this.a.setAlpha(i);
            return;
        }
        this.b.b.setAlpha(i);
    }

    @Override // d.v.a.a.h
    public void setAutoMirrored(boolean z) {
        if (this.a != null) {
            a.j(this.a, z);
            return;
        }
        this.b.b.setAutoMirrored(z);
    }

    @Override // d.v.a.a.h
    public void setTint(int i) {
        if (this.a != null) {
            a.n(this.a, i);
            return;
        }
        this.b.b.setTint(i);
    }

    @Override // d.v.a.a.h
    public void setTintList(ColorStateList list) {
        if (this.a != null) {
            a.o(this.a, list);
            return;
        }
        this.b.b.setTintList(list);
    }

    @Override // d.v.a.a.h
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.a != null) {
            a.p(this.a, mode);
            return;
        }
        this.b.b.setTintMode(mode);
    }

    @Override // d.v.a.a.h
    public boolean setVisible(boolean z, boolean z2) {
        if (this.a != null) {
            return this.a.setVisible(z, z2);
        }
        this.b.b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // d.v.a.a.h
    public void start() {
        if (this.a != null) {
            drawable.start();
            return;
        }
        if (this.b.c.isStarted()) {
            return;
        }
        this.b.c.start();
        invalidateSelf();
    }

    @Override // d.v.a.a.h
    public void stop() {
        if (this.a != null) {
            drawable.stop();
            return;
        }
        this.b.c.end();
    }

    private c(Context context) {
        final d.v.a.a.c.c cVar = null;
        this(context, cVar, cVar);
    }

    @Override // d.v.a.a.h
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.a != null) {
            this.a.setColorFilter(colorFilter);
            return;
        }
        this.b.b.setColorFilter(colorFilter);
    }

    private c(Context context, c.c cVar, Resources resources) {
        super();
        ArgbEvaluator argbEvaluator = null;
        this.v = argbEvaluator;
        this.w = argbEvaluator;
        this.x = argbEvaluator;
        d.v.a.a.c.a aVar = new c.a(this);
        this.y = aVar;
        this.c = context;
        if (cVar != null) {
            this.b = cVar;
        } else {
            this.b = new c.c(context, cVar, aVar, resources);
        }
    }

    @Override // d.v.a.a.h
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet set) {
        inflate(resources, xmlPullParser, set, null);
    }
}
