package com.airbnb.lottie;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.BaseSavedState;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.airbnb.lottie.v.e;
import com.airbnb.lottie.y.d;
import com.airbnb.lottie.y.h;
import com.airbnb.lottie.z.c;
import d.a.k.a.a;
import d.h.l.u;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {

    private static final String L;
    private static final com.airbnb.lottie.h<Throwable> M;
    private boolean A = false;
    private boolean B = false;
    private boolean C = false;
    private boolean D = false;
    private boolean E = false;
    private boolean F = true;
    private com.airbnb.lottie.q G = 1;
    private final Set<com.airbnb.lottie.j> H;
    private int I = 0;
    private com.airbnb.lottie.m<com.airbnb.lottie.d> J;
    private com.airbnb.lottie.d K;
    private final com.airbnb.lottie.h<com.airbnb.lottie.d> a;
    private final com.airbnb.lottie.h<Throwable> b;
    private com.airbnb.lottie.h<Throwable> c;
    private int v = 0;
    private final com.airbnb.lottie.f w;
    private boolean x;
    private String y;
    private int z;

    class d implements Callable<com.airbnb.lottie.l<com.airbnb.lottie.d>> {

        final int a;
        final com.airbnb.lottie.LottieAnimationView b;
        d(com.airbnb.lottie.LottieAnimationView lottieAnimationView, int i2) {
            this.b = lottieAnimationView;
            this.a = i2;
            super();
        }

        public com.airbnb.lottie.l<com.airbnb.lottie.d> a() {
            com.airbnb.lottie.l lVar;
            int i;
            int i2;
            if (LottieAnimationView.d(this.b)) {
                lVar = e.o(this.b.getContext(), this.a);
            } else {
                lVar = e.p(this.b.getContext(), this.a, 0);
            }
            return lVar;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    class e implements Callable<com.airbnb.lottie.l<com.airbnb.lottie.d>> {

        final String a;
        final com.airbnb.lottie.LottieAnimationView b;
        e(com.airbnb.lottie.LottieAnimationView lottieAnimationView, String string2) {
            this.b = lottieAnimationView;
            this.a = string2;
            super();
        }

        public com.airbnb.lottie.l<com.airbnb.lottie.d> a() {
            com.airbnb.lottie.l lVar;
            String str;
            int i;
            if (LottieAnimationView.d(this.b)) {
                lVar = e.f(this.b.getContext(), this.a);
            } else {
                lVar = e.g(this.b.getContext(), this.a, 0);
            }
            return lVar;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return a();
        }
    }

    static class f {

        static final int[] a;
        static {
            int[] iArr = new int[values.length];
            LottieAnimationView.f.a = iArr;
            iArr[q.HARDWARE.ordinal()] = 1;
            LottieAnimationView.f.a[q.SOFTWARE.ordinal()] = 2;
            LottieAnimationView.f.a[q.AUTOMATIC.ordinal()] = 3;
        }
    }

    private static class g extends View.BaseSavedState {

        public static final Parcelable.Creator<com.airbnb.lottie.LottieAnimationView.g> CREATOR;
        String a;
        int b;
        float c;
        boolean v;
        String w;
        int x;
        int y;
        static {
            LottieAnimationView.g.a aVar = new LottieAnimationView.g.a();
            LottieAnimationView.g.CREATOR = aVar;
        }

        private g(Parcel parcel) {
            int i;
            super(parcel);
            this.a = parcel.readString();
            this.c = parcel.readFloat();
            if (parcel.readInt() == 1) {
            } else {
                i = 0;
            }
            this.v = i;
            this.w = parcel.readString();
            this.x = parcel.readInt();
            this.y = parcel.readInt();
        }

        g(Parcel parcel, com.airbnb.lottie.LottieAnimationView.a lottieAnimationView$a2) {
            super(parcel);
        }

        g(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View$BaseSavedState
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.a);
            parcel.writeFloat(this.c);
            parcel.writeInt(this.v);
            parcel.writeString(this.w);
            parcel.writeInt(this.x);
            parcel.writeInt(this.y);
        }
    }

    class a implements com.airbnb.lottie.h<Throwable> {
        @Override // com.airbnb.lottie.h
        public void a(Object object) {
            b((Throwable)object);
        }

        @Override // com.airbnb.lottie.h
        public void b(Throwable throwable) {
            if (!h.k(throwable)) {
            } else {
                d.d("Unable to load composition.", throwable);
            }
            IllegalStateException illegalStateException = new IllegalStateException("Unable to parse composition", throwable);
            throw illegalStateException;
        }
    }

    class b implements com.airbnb.lottie.h<com.airbnb.lottie.d> {

        final com.airbnb.lottie.LottieAnimationView a;
        b(com.airbnb.lottie.LottieAnimationView lottieAnimationView) {
            this.a = lottieAnimationView;
            super();
        }

        @Override // com.airbnb.lottie.h
        public void a(Object object) {
            b((d)object);
        }

        @Override // com.airbnb.lottie.h
        public void b(com.airbnb.lottie.d d) {
            this.a.setComposition(d);
        }
    }

    class c implements com.airbnb.lottie.h<Throwable> {

        final com.airbnb.lottie.LottieAnimationView a;
        c(com.airbnb.lottie.LottieAnimationView lottieAnimationView) {
            this.a = lottieAnimationView;
            super();
        }

        @Override // com.airbnb.lottie.h
        public void a(Object object) {
            b((Throwable)object);
        }

        @Override // com.airbnb.lottie.h
        public void b(Throwable throwable) {
            int i;
            com.airbnb.lottie.h hVar;
            int i2;
            if (LottieAnimationView.a(this.a) != 0) {
                i = this.a;
                i.setImageResource(LottieAnimationView.a(i));
            }
            if (LottieAnimationView.b(this.a) == null) {
                hVar = LottieAnimationView.c();
            } else {
                hVar = LottieAnimationView.b(this.a);
            }
            hVar.a(throwable);
        }
    }
    static {
        LottieAnimationView.L = LottieAnimationView.class.getSimpleName();
        LottieAnimationView.a aVar = new LottieAnimationView.a();
        LottieAnimationView.M = aVar;
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        LottieAnimationView.b obj2 = new LottieAnimationView.b(this);
        this.a = obj2;
        obj2 = new LottieAnimationView.c(this);
        this.b = obj2;
        obj2 = 0;
        f fVar = new f();
        this.w = fVar;
        int i = 1;
        com.airbnb.lottie.q aUTOMATIC = q.AUTOMATIC;
        HashSet hashSet = new HashSet();
        this.H = hashSet;
        o(attributeSet2, o.a);
    }

    static int a(com.airbnb.lottie.LottieAnimationView lottieAnimationView) {
        return lottieAnimationView.v;
    }

    static com.airbnb.lottie.h b(com.airbnb.lottie.LottieAnimationView lottieAnimationView) {
        return lottieAnimationView.c;
    }

    static com.airbnb.lottie.h c() {
        return LottieAnimationView.M;
    }

    static boolean d(com.airbnb.lottie.LottieAnimationView lottieAnimationView) {
        return lottieAnimationView.F;
    }

    private void i() {
        com.airbnb.lottie.m mVar;
        com.airbnb.lottie.h hVar;
        mVar = this.J;
        if (mVar != null) {
            mVar.k(this.a);
            this.J.j(this.b);
        }
    }

    private void j() {
        this.K = 0;
        this.w.h();
    }

    private void l() {
        int sDK_INT;
        int layerType;
        int i3;
        int i2;
        int i;
        sDK_INT = LottieAnimationView.f.a[this.G.ordinal()];
        final int i4 = 1;
        if (sDK_INT != i4) {
            if (sDK_INT != 2 && sDK_INT != 3) {
                if (sDK_INT != 3) {
                    i3 = i4;
                } else {
                }
            } else {
            }
        }
        if (i3 != getLayerType()) {
            setLayerType(i3, 0);
        }
    }

    private com.airbnb.lottie.m<com.airbnb.lottie.d> m(String string) {
        Context context;
        int i;
        com.airbnb.lottie.m obj3;
        if (isInEditMode()) {
            LottieAnimationView.e eVar = new LottieAnimationView.e(this, string);
            m mVar = new m(eVar, 1);
            return mVar;
        }
        if (this.F) {
            obj3 = e.d(getContext(), string);
        } else {
            obj3 = e.e(getContext(), string, 0);
        }
        return obj3;
    }

    private com.airbnb.lottie.m<com.airbnb.lottie.d> n(int i) {
        Context context;
        int i2;
        com.airbnb.lottie.m obj3;
        if (isInEditMode()) {
            LottieAnimationView.d dVar = new LottieAnimationView.d(this, i);
            m mVar = new m(dVar, 1);
            return mVar;
        }
        if (this.F) {
            obj3 = e.m(getContext(), i);
        } else {
            obj3 = e.n(getContext(), i, 0);
        }
        return obj3;
    }

    private void o(AttributeSet attributeSet, int i2) {
        int i3;
        boolean value;
        boolean values;
        int i;
        int length;
        boolean cVar;
        int obj9;
        i = 0;
        TypedArray obj8 = getContext().obtainStyledAttributes(attributeSet, p.a, i2, i);
        int i4 = 1;
        this.F = obj8.getBoolean(p.c, i4);
        obj9 = p.k;
        boolean value2 = obj8.hasValue(obj9);
        int i5 = p.g;
        boolean value6 = obj8.hasValue(i5);
        int i7 = p.q;
        if (value2 != null) {
            if (value6 != null) {
            } else {
            }
            obj8 = new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            throw obj8;
        }
        if (value2 != null) {
            obj9 = obj8.getResourceId(obj9, i);
            if (obj9 != null) {
                setAnimation(obj9);
            }
        } else {
            if (value6 != null) {
                obj9 = obj8.getString(i5);
                if (obj9 != null) {
                    setAnimation(obj9);
                }
            } else {
                obj9 = obj8.getString(i7);
                if (obj8.hasValue(i7) && obj9 != null) {
                    obj9 = obj8.getString(i7);
                    if (obj9 != null) {
                        setAnimationFromUrl(obj9);
                    }
                }
            }
        }
        setFallbackResource(obj8.getResourceId(p.f, i));
        if (obj8.getBoolean(p.b, i)) {
            this.C = i4;
            this.E = i4;
        }
        i3 = -1;
        if (obj8.getBoolean(p.i, i)) {
            this.w.d0(i3);
        }
        obj9 = p.n;
        if (obj8.hasValue(obj9)) {
            setRepeatMode(obj8.getInt(obj9, i4));
        }
        obj9 = p.m;
        if (obj8.hasValue(obj9)) {
            setRepeatCount(obj8.getInt(obj9, i3));
        }
        obj9 = p.p;
        length = 1065353216;
        if (obj8.hasValue(obj9)) {
            setSpeed(obj8.getFloat(obj9, length));
        }
        setImageAssetsFolder(obj8.getString(p.h));
        int i6 = 0;
        setProgress(obj8.getFloat(p.j, i6));
        k(obj8.getBoolean(p.e, i));
        obj9 = p.d;
        if (obj8.hasValue(obj9)) {
            r rVar = new r(a.c(getContext(), obj8.getResourceId(obj9, i3)).getDefaultColor());
            obj9 = new e(/* result */);
            cVar = new c(rVar);
            g(obj9, k.E, cVar);
        }
        obj9 = p.o;
        if (obj8.hasValue(obj9)) {
            this.w.g0(obj8.getFloat(obj9, length));
        }
        obj9 = p.l;
        com.airbnb.lottie.q aUTOMATIC = q.AUTOMATIC;
        if (obj8.hasValue(obj9) && obj8.getInt(obj9, aUTOMATIC.ordinal()) >= values2.length) {
            aUTOMATIC = q.AUTOMATIC;
            if (obj8.getInt(obj9, aUTOMATIC.ordinal()) >= values2.length) {
                obj9 = aUTOMATIC.ordinal();
            }
            setRenderMode(q.values()[obj9]);
        }
        obj8.recycle();
        if (Float.compare(obj9, i6) != 0) {
            i = i4;
        }
        this.w.i0(Boolean.valueOf(i));
        l();
        this.x = i4;
    }

    private void setCompositionTask(com.airbnb.lottie.m<com.airbnb.lottie.d> m) {
        j();
        i();
        m.f(this.a);
        m.e(this.b);
        this.J = m;
    }

    private void v() {
        boolean z;
        setImageDrawable(0);
        setImageDrawable(this.w);
        if (p()) {
            this.w.L();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void buildDrawingCache(boolean z) {
        int layerType;
        boolean obj4;
        final String str = "buildDrawingCache";
        c.a(str);
        final int i3 = 1;
        this.I = i += i3;
        super.buildDrawingCache(z);
        if (this.I == i3 && getWidth() > 0 && getHeight() > 0 && getLayerType() == i3 && getDrawingCache(z) == null) {
            if (getWidth() > 0) {
                if (getHeight() > 0) {
                    if (getLayerType() == i3) {
                        if (getDrawingCache(z) == null) {
                            setRenderMode(q.HARDWARE);
                        }
                    }
                }
            }
        }
        this.I = obj4 -= i3;
        c.b(str);
    }

    public <T> void g(e e, T t2, c<T> c3) {
        this.w.c(e, t2, c3);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public com.airbnb.lottie.d getComposition() {
        return this.K;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public long getDuration() {
        long l;
        com.airbnb.lottie.d dVar = this.K;
        if (dVar != null) {
            l = (long)f;
        } else {
            l = 0;
        }
        return l;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public int getFrame() {
        return this.w.r();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public String getImageAssetsFolder() {
        return this.w.u();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public float getMaxFrame() {
        return this.w.v();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public float getMinFrame() {
        return this.w.x();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public com.airbnb.lottie.n getPerformanceTracker() {
        return this.w.y();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public float getProgress() {
        return this.w.z();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public int getRepeatCount() {
        return this.w.A();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public int getRepeatMode() {
        return this.w.B();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public float getScale() {
        return this.w.C();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public float getSpeed() {
        return this.w.D();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void h() {
        int i = 0;
        this.C = i;
        this.B = i;
        this.A = i;
        this.w.g();
        l();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void invalidateDrawable(Drawable drawable) {
        final com.airbnb.lottie.f fVar = this.w;
        if (getDrawable() == fVar) {
            super.invalidateDrawable(fVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void k(boolean z) {
        this.w.l(z);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    protected void onAttachedToWindow() {
        boolean inEditMode;
        int sDK_INT;
        super.onAttachedToWindow();
        if (!isInEditMode()) {
            if (!this.E) {
                if (this.C) {
                    r();
                    inEditMode = 0;
                    this.E = inEditMode;
                    this.C = inEditMode;
                }
            } else {
            }
        }
        if (Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    protected void onDetachedFromWindow() {
        boolean z;
        if (p()) {
            h();
            this.C = true;
        }
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    protected void onRestoreInstanceState(Parcelable parcelable) {
        boolean empty;
        if (!parcelable instanceof LottieAnimationView.g) {
            super.onRestoreInstanceState(parcelable);
        }
        super.onRestoreInstanceState((LottieAnimationView.g)parcelable.getSuperState());
        String str = parcelable.a;
        this.y = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.y);
        }
        int i = parcelable.b;
        this.z = i;
        if (i != 0) {
            setAnimation(i);
        }
        setProgress(parcelable.c);
        if (parcelable.v) {
            r();
        }
        this.w.R(parcelable.w);
        setRepeatMode(parcelable.x);
        setRepeatCount(parcelable.y);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    protected Parcelable onSaveInstanceState() {
        boolean z;
        int i;
        LottieAnimationView.g gVar = new LottieAnimationView.g(super.onSaveInstanceState());
        gVar.a = this.y;
        gVar.b = this.z;
        gVar.c = this.w.z();
        if (!this.w.G()) {
            if (!u.Q(this) && this.C) {
                if (this.C) {
                    i = 1;
                } else {
                    i = 0;
                }
            } else {
            }
        } else {
        }
        gVar.v = i;
        gVar.w = this.w.u();
        gVar.x = this.w.B();
        gVar.y = this.w.A();
        return gVar;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    protected void onVisibilityChanged(View view, int i2) {
        boolean obj1;
        if (!this.x) {
        }
        if (isShown()) {
            if (this.B) {
                s();
            } else {
                if (this.A) {
                    r();
                }
            }
            obj1 = 0;
            this.B = obj1;
            this.A = obj1;
        } else {
            if (p()) {
                q();
                this.B = true;
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public boolean p() {
        return this.w.G();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void q() {
        int i = 0;
        this.E = i;
        this.C = i;
        this.B = i;
        this.A = i;
        this.w.I();
        l();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void r() {
        com.airbnb.lottie.f fVar;
        if (isShown()) {
            this.w.J();
            l();
        } else {
            this.A = true;
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void s() {
        com.airbnb.lottie.f fVar;
        if (isShown()) {
            this.w.L();
            l();
        } else {
            this.A = false;
            this.B = true;
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setAnimation(int i) {
        this.z = i;
        this.y = 0;
        setCompositionTask(n(i));
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setAnimation(String string) {
        this.y = string;
        this.z = 0;
        setCompositionTask(m(string));
    }

    @Deprecated
    public void setAnimationFromJson(String string) {
        u(string, 0);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setAnimationFromUrl(String string) {
        Context context;
        int i;
        com.airbnb.lottie.m obj3;
        if (this.F) {
            obj3 = e.q(getContext(), string);
        } else {
            obj3 = e.r(getContext(), string, 0);
        }
        setCompositionTask(obj3);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setApplyingOpacityToLayersEnabled(boolean z) {
        this.w.M(z);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setCacheComposition(boolean z) {
        this.F = z;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setComposition(com.airbnb.lottie.d d) {
        boolean z;
        String string;
        Drawable drawable;
        String str;
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Set Composition \n");
            stringBuilder.append(d);
            Log.v(LottieAnimationView.L, stringBuilder.toString());
        }
        this.w.setCallback(this);
        this.K = d;
        this.D = true;
        boolean z2 = this.w.N(d);
        this.D = false;
        l();
        if (getDrawable() == this.w && !z2) {
            if (!z2) {
            }
        }
        if (!z2) {
            v();
        }
        onVisibilityChanged(this, getVisibility());
        requestLayout();
        Iterator iterator = this.H.iterator();
        for (j drawable : iterator) {
            drawable.a(d);
        }
    }

    public void setFailureListener(com.airbnb.lottie.h<Throwable> h) {
        this.c = h;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setFallbackResource(int i) {
        this.v = i;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setFontAssetDelegate(com.airbnb.lottie.a a) {
        this.w.O(a);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setFrame(int i) {
        this.w.P(i);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setImageAssetDelegate(com.airbnb.lottie.b b) {
        this.w.Q(b);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setImageAssetsFolder(String string) {
        this.w.R(string);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setImageBitmap(Bitmap bitmap) {
        i();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setImageDrawable(Drawable drawable) {
        i();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setImageResource(int i) {
        i();
        super.setImageResource(i);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setMaxFrame(int i) {
        this.w.S(i);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setMaxFrame(String string) {
        this.w.T(string);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setMaxProgress(float f) {
        this.w.U(f);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setMinAndMaxFrame(String string) {
        this.w.W(string);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setMinFrame(int i) {
        this.w.X(i);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setMinFrame(String string) {
        this.w.Y(string);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setMinProgress(float f) {
        this.w.Z(f);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setOutlineMasksAndMattes(boolean z) {
        this.w.a0(z);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setPerformanceTrackingEnabled(boolean z) {
        this.w.b0(z);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setProgress(float f) {
        this.w.c0(f);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setRenderMode(com.airbnb.lottie.q q) {
        this.G = q;
        l();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setRepeatCount(int i) {
        this.w.d0(i);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setRepeatMode(int i) {
        this.w.e0(i);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setSafeMode(boolean z) {
        this.w.f0(z);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setScale(float f) {
        this.w.g0(f);
        if (getDrawable() == this.w) {
            v();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setSpeed(float f) {
        this.w.h0(f);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setTextDelegate(com.airbnb.lottie.s s) {
        this.w.j0(s);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void t(InputStream inputStream, String string2) {
        setCompositionTask(e.h(inputStream, string2));
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void u(String string, String string2) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(string.getBytes());
        t(byteArrayInputStream, string2);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void unscheduleDrawable(Drawable drawable) {
        boolean z;
        boolean z2;
        z = this.w;
        if (!this.D && drawable == z && z.G()) {
            z = this.w;
            if (drawable == z) {
                if (z.G()) {
                    q();
                } else {
                    z = drawable;
                    if (!this.D && drawable instanceof f && (f)z.G()) {
                        if (drawable instanceof f) {
                            z = drawable;
                            if ((f)z.G()) {
                                z.I();
                            }
                        }
                    }
                }
            } else {
            }
        } else {
        }
        super.unscheduleDrawable(drawable);
    }
}
