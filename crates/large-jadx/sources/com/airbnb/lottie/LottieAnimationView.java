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

/* compiled from: LottieAnimationView.java */
/* loaded from: classes.dex */
public class LottieAnimationView extends AppCompatImageView {

    private static final String L;
    private static final h<Throwable> M = new LottieAnimationView$a<>();
    private boolean A = false;
    private boolean B = false;
    private boolean C = false;
    private boolean D = false;
    private boolean E = false;
    private boolean F = true;
    private q G;
    private final Set<j> H = new HashSet<>();
    private int I = 0;
    private m<d> J;
    private d K;
    private final h<d> a = new LottieAnimationView$b<>();
    private final h<Throwable> b = new LottieAnimationView$c<>();
    private h<Throwable> c;
    private int v = 0;
    private final f w = new f();
    private boolean x;
    private String y;
    private int z;

    class d implements Callable<l<d>> {

        final /* synthetic */ int a;
        final /* synthetic */ LottieAnimationView b;
        d(int i) {
            this.b = lottieAnimationView;
            this.a = i;
            super();
        }

        public l<d> a() {
            com.airbnb.lottie.l lVar;
            if (this.b.F) {
                lVar = e.o(this.b.getContext(), this.a);
            } else {
                String str = null;
                lVar = e.p(this.b.getContext(), this.a, str);
            }
            return lVar;
        }
    }

    class e implements Callable<l<d>> {

        final /* synthetic */ String a;
        final /* synthetic */ LottieAnimationView b;
        e(String str) {
            this.b = lottieAnimationView;
            this.a = str;
            super();
        }

        public l<d> a() {
            com.airbnb.lottie.l lVar;
            if (this.b.F) {
                lVar = e.f(this.b.getContext(), this.a);
            } else {
                String str2 = null;
                lVar = e.g(this.b.getContext(), this.a, str2);
            }
            return lVar;
        }
    }

    static class f {

        static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[q.values().length];
            LottieAnimationView.f.a = iArr;
            try {
                iArr[q.HARDWARE.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                LottieAnimationView.f.a[q.SOFTWARE.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
            try {
                LottieAnimationView.f.a[q.AUTOMATIC.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused) {
                return;
            }
        }
    }

    private static class g extends View.BaseSavedState {

        public static final Parcelable.Creator<LottieAnimationView.g> CREATOR = new LottieAnimationView$g$a<>();
        String a;
        int b;
        float c;
        boolean v;
        String w;
        int x;
        int y;

        /* synthetic */ g(Parcel parcel, LottieAnimationView.a aVar) {
            this(parcel);
        }

        @Override // android.view.View$BaseSavedState
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.a);
            parcel.writeFloat(this.c);
            parcel.writeInt(this.v);
            parcel.writeString(this.w);
            parcel.writeInt(this.x);
            parcel.writeInt(this.y);
        }

        g(Parcelable parcelable) {
            super(parcelable);
        }

        private g(Parcel parcel) {
            int i = 1;
            super(parcel);
            this.a = parcel.readString();
            this.c = parcel.readFloat();
            i = 1;
            if (parcel.readInt() != 1) {
                i = 0;
            }
            this.v = i;
            this.w = parcel.readString();
            this.x = parcel.readInt();
            this.y = parcel.readInt();
        }
    }

    class a implements h<Throwable> {
        a() {
            super();
        }

        public void b(Throwable th) {
            if (!h.k(th)) {
                throw new IllegalStateException("Unable to parse composition", th);
            } else {
                d.d("Unable to load composition.", th);
                return;
            }
        }
    }

    class b implements h<d> {

        final /* synthetic */ LottieAnimationView a;
        b() {
            this.a = lottieAnimationView;
            super();
        }

        public void b(d dVar) {
            this.a.setComposition(dVar);
        }
    }

    class c implements h<Throwable> {

        final /* synthetic */ LottieAnimationView a;
        c() {
            this.a = lottieAnimationView;
            super();
        }

        public void b(Throwable th) {
            com.airbnb.lottie.h hVar;
            if (this.a.v != 0) {
                this.a.setImageResource(this.a.v);
            }
            if (this.a.c == null) {
                hVar = LottieAnimationView.M;
            } else {
                hVar = this.a.c;
            }
            hVar.a(th);
        }
    }
    static {
        LottieAnimationView.L = LottieAnimationView.class.getSimpleName();
    }

    public LottieAnimationView(Context context, AttributeSet set) {
        super(context, set);
        com.airbnb.lottie.LottieAnimationView.b bVar = new LottieAnimationView.b(this);
        com.airbnb.lottie.LottieAnimationView.c cVar = new LottieAnimationView.c(this);
        com.airbnb.lottie.f fVar = new f();
        this.G = q.AUTOMATIC;
        HashSet hashSet = new HashSet();
        o(set, o.a);
    }

    static /* synthetic */ int a(LottieAnimationView lottieAnimationView) {
        return lottieAnimationView.v;
    }

    static /* synthetic */ h b(LottieAnimationView lottieAnimationView) {
        return lottieAnimationView.c;
    }

    static /* synthetic */ h c() {
        return LottieAnimationView.M;
    }

    static /* synthetic */ boolean d(LottieAnimationView lottieAnimationView) {
        return lottieAnimationView.F;
    }

    private void i() {
        if (this.J != null) {
            this.J.k(this.a);
            this.J.j(this.b);
        }
    }

    private void j() {
        this.K = null;
        this.w.h();
    }

    private void l() {
        int sDK_INT2;
        int i = 2;
        int i2;
        sDK_INT2 = LottieAnimationView.f.a[this.G.ordinal()];
        i = 2;
        i = 1;
        if (LottieAnimationView.f.a != i) {
            int r1 = i;
        }
        if (this.G != this.getLayerType()) {
            setLayerType(i, null);
        }
    }

    private m<d> m(String str) {
        com.airbnb.lottie.m mVar;
        if (isInEditMode()) {
            return new m(new LottieAnimationView.e(this, str), true);
        }
        if (this.F) {
            mVar = e.d(getContext(), str);
        } else {
            String str2 = null;
            mVar = e.e(getContext(), str, str2);
        }
        return mVar;
    }

    private m<d> n(int i) {
        com.airbnb.lottie.m mVar;
        if (isInEditMode()) {
            return new m(new LottieAnimationView.d(this, i), true);
        }
        if (this.F) {
            mVar = e.m(getContext(), i);
        } else {
            String str = null;
            mVar = e.n(getContext(), i, str);
        }
        return mVar;
    }

    private void o(AttributeSet set, int i) throws android.content.res.Resources.NotFoundException {
        boolean z = false;
        int ordinal;
        int i7 = 0;
        TypedArray styledAttributes = getContext().obtainStyledAttributes(set, p.a, i, i7);
        z = true;
        this.F = styledAttributes.getBoolean(p.c, z);
        resourceId = p.k;
        boolean value4 = styledAttributes.hasValue(resourceId);
        int i8 = p.g;
        boolean value8 = styledAttributes.hasValue(i8);
        int i9 = p.q;
        if (value4) {
            if (value8) {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            }
        }
        if (value4) {
            int resourceId = styledAttributes.getResourceId(p.k, i7);
            if (resourceId != 0) {
                setAnimation(resourceId);
            }
        } else {
            if (value8) {
                String string = styledAttributes.getString(p.g);
                if (string != null) {
                    setAnimation(string);
                }
            } else {
                if (styledAttributes.hasValue(i9) && string2 != null) {
                    setAnimationFromUrl(string2);
                }
            }
        }
        setFallbackResource(styledAttributes.getResourceId(p.f, i7));
        if (styledAttributes.getBoolean(p.b, false)) {
            this.C = z;
            this.E = z;
        }
        i = -1;
        if (styledAttributes.getBoolean(p.i, false)) {
            this.w.d0(i);
        }
        _int = p.n;
        if (styledAttributes.hasValue(_int)) {
            setRepeatMode(styledAttributes.getInt(p.n, z));
        }
        _int2 = p.m;
        if (styledAttributes.hasValue(_int2)) {
            setRepeatCount(styledAttributes.getInt(p.m, i));
        }
        i3 = p.p;
        float f = 1f;
        if (styledAttributes.hasValue(i3)) {
            setSpeed(styledAttributes.getFloat(p.p, f));
        }
        setImageAssetsFolder(styledAttributes.getString(p.h));
        float f2 = 0.0f;
        setProgress(styledAttributes.getFloat(p.j, f2));
        k(styledAttributes.getBoolean(p.e, false));
        i4 = p.d;
        if (styledAttributes.hasValue(i4)) {
            g(new e(new String[] { "**" }), k.E, new c(new r(a.c(getContext(), styledAttributes.getResourceId(p.d, i)).getDefaultColor())));
        }
        i5 = p.o;
        if (styledAttributes.hasValue(i5)) {
            this.w.g0(styledAttributes.getFloat(p.o, f));
        }
        i6 = p.l;
        if (styledAttributes.hasValue(i6)) {
            com.airbnb.lottie.q aUTOMATIC2 = q.AUTOMATIC;
            if (styledAttributes.getInt(p.l, aUTOMATIC2.ordinal()) >= q.values().length) {
                ordinal = q.AUTOMATIC.ordinal();
            }
            setRenderMode(q.values()[ordinal]);
        }
        styledAttributes.recycle();
        float f3 = h.f(getContext());
        if (f3 != 0.0f) {
        }
        this.w.i0(Boolean.valueOf(z));
        l();
        this.x = z;
    }

    private void setCompositionTask(m<d> mVar) {
        j();
        i();
        mVar.f(this.a);
        mVar.e(this.b);
        this.J = mVar;
    }

    private void v() {
        setImageDrawable(null);
        setImageDrawable(this.w);
        if (p()) {
            this.w.L();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void buildDrawingCache(boolean z) {
        final String str = "buildDrawingCache";
        c.a(str);
        final int i3 = 1;
        this.I += i3;
        super.buildDrawingCache(z);
        if (this.I == i3 && this.getWidth() > 0 && this.getHeight() > 0 && this.getLayerType() == i3 && this.getDrawingCache(z) == null) {
            setRenderMode(q.HARDWARE);
        }
        this.I -= i3;
        c.b(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public <T> void g(e eVar, T t, c<T> cVar) {
        this.w.c(eVar, t, cVar);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public d getComposition() {
        return this.K;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public long getDuration() {
        long l = 0;
        l = this.K != null ? (long)f : 0;
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
    public n getPerformanceTracker() {
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
        boolean z = false;
        this.C = z;
        this.B = z;
        this.A = z;
        this.w.g();
        l();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void invalidateDrawable(Drawable drawable) {
        if (getDrawable() == this.w) {
            super.invalidateDrawable(this.w);
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
        super.onAttachedToWindow();
        if (!isInEditMode() && !this.E && this.C) {
            r();
            boolean inEditMode = false;
            this.E = inEditMode;
            this.C = inEditMode;
        }
        if (Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    protected void onDetachedFromWindow() {
        if (p()) {
            h();
            boolean z = true;
            this.C = z;
        }
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof LottieAnimationView.g)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        super.onRestoreInstanceState(parcelable.getSuperState());
        this.y = parcelable.a;
        if (!TextUtils.isEmpty(parcelable.a)) {
            setAnimation(this.y);
        }
        this.z = parcelable.b;
        if (parcelable.b != 0) {
            setAnimation(parcelable.b);
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
        int i = 0;
        final com.airbnb.lottie.LottieAnimationView.g gVar = new LottieAnimationView.g(super.onSaveInstanceState());
        gVar.a = this.y;
        gVar.b = this.z;
        gVar.c = this.w.z();
        if (this.w.G() || !u.Q(this)) {
            i = 1;
        } else {
            if (!(this.C)) {
                i = 0;
            }
        }
        gVar.v = i;
        gVar.w = this.w.u();
        gVar.x = this.w.B();
        gVar.y = this.w.A();
        return gVar;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    protected void onVisibilityChanged(View view, int i) {
        if (!this.x) {
            return;
        }
        if (isShown()) {
            if (this.B) {
                s();
            } else {
                if (this.A) {
                    r();
                }
            }
            boolean z2 = false;
            this.B = z2;
            this.A = z2;
        } else {
            if (p()) {
                q();
                z2 = true;
                this.B = z2;
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public boolean p() {
        return this.w.G();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void q() {
        boolean z = false;
        this.E = z;
        this.C = z;
        this.B = z;
        this.A = z;
        this.w.I();
        l();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void r() {
        if (isShown()) {
            this.w.J();
            l();
        } else {
            this.A = true;
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void s() {
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
        this.y = null;
        setCompositionTask(n(i));
    }

    @Deprecated
    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setAnimationFromJson(String str) {
        u(str, null);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setAnimationFromUrl(String str) {
        com.airbnb.lottie.m mVar;
        if (this.F) {
            mVar = e.q(getContext(), str);
        } else {
            String str2 = null;
            mVar = e.r(getContext(), str, str2);
        }
        setCompositionTask(mVar);
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
    public void setComposition(d dVar) {
        if (c.a) {
            StringBuilder stringBuilder = new StringBuilder();
            str2 = "Set Composition \n";
            str = str2 + dVar;
            Log.v(LottieAnimationView.L, str);
        }
        this.w.setCallback(this);
        this.K = dVar;
        this.D = true;
        boolean z2 = this.w.N(dVar);
        this.D = false;
        l();
        if (getDrawable() == this.w && !z2) {
            return;
        }
        if (!z2) {
            v();
        }
        onVisibilityChanged(this, getVisibility());
        requestLayout();
        Iterator it = this.H.iterator();
        while (it.hasNext()) {
            (j)it.next().a(dVar);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setFailureListener(h<Throwable> hVar) {
        this.c = hVar;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setFallbackResource(int i) {
        this.v = i;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setFontAssetDelegate(a aVar) {
        this.w.O(aVar);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setFrame(int i) {
        this.w.P(i);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setImageAssetDelegate(b bVar) {
        this.w.Q(bVar);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setImageAssetsFolder(String str) {
        this.w.R(str);
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
    public void setMaxProgress(float f) {
        this.w.U(f);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setMinAndMaxFrame(String str) {
        this.w.W(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setMinFrame(int i) {
        this.w.X(i);
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
    public void setRenderMode(q qVar) {
        this.G = qVar;
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
    public void setTextDelegate(s sVar) {
        this.w.j0(sVar);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void t(InputStream inputStream, String str) {
        setCompositionTask(e.h(inputStream, str));
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void u(String str, String str2) throws java.io.UnsupportedEncodingException {
        t(new ByteArrayInputStream(str.getBytes()), str2);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void unscheduleDrawable(Drawable drawable) {
        if (this.D || drawable != this.w || !this.w.G()) {
            if (!this.D) {
                z = drawable instanceof f;
                if (drawable instanceof f) {
                    com.airbnb.lottie.f drawable2 = drawable;
                    if (drawable2.G()) {
                        drawable2.I();
                    }
                }
            }
        } else {
            q();
        }
        super.unscheduleDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setMaxFrame(String str) {
        this.w.T(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setMinFrame(String str) {
        this.w.Y(str);
    }

    @Override // androidx.appcompat.widget.AppCompatImageView
    public void setAnimation(String str) {
        this.y = str;
        this.z = 0;
        setCompositionTask(m(str));
    }
}
