package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.widget.d;
import androidx.core.widget.k;
import androidx.core.widget.m;
import d.a.k.a.a;
import d.h.f.d;
import d.h.j.d;
import d.h.j.d.a;
import d.h.l.t;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class AppCompatTextView extends TextView implements t, m, d {

    private final androidx.appcompat.widget.e mBackgroundTintHelper;
    private Future<d> mPrecomputedTextFuture;
    private final androidx.appcompat.widget.u mTextClassifierHelper;
    private final androidx.appcompat.widget.v mTextHelper;
    public AppCompatTextView(Context context) {
        super(context, 0);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 16842884);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet2, int i3) {
        super(q0.b(context), attributeSet2, i3);
        o0.a(this, getContext());
        e obj1 = new e(this);
        this.mBackgroundTintHelper = obj1;
        obj1.e(attributeSet2, i3);
        obj1 = new v(this);
        this.mTextHelper = obj1;
        obj1.m(attributeSet2, i3);
        obj1.b();
        obj1 = new u(this);
        this.mTextClassifierHelper = obj1;
    }

    private void consumeTextFutureAndSetBlocking() {
        Object mPrecomputedTextFuture;
        int i;
        mPrecomputedTextFuture = this.mPrecomputedTextFuture;
        if (mPrecomputedTextFuture != null) {
            this.mPrecomputedTextFuture = 0;
            k.p(this, (d)mPrecomputedTextFuture.get());
        }
    }

    @Override // android.widget.TextView
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        androidx.appcompat.widget.e mBackgroundTintHelper = this.mBackgroundTintHelper;
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.b();
        }
        androidx.appcompat.widget.v mTextHelper = this.mTextHelper;
        if (mTextHelper != null) {
            mTextHelper.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (d.d) {
            return super.getAutoSizeMaxTextSize();
        }
        androidx.appcompat.widget.v mTextHelper = this.mTextHelper;
        if (mTextHelper != null) {
            return mTextHelper.e();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (d.d) {
            return super.getAutoSizeMinTextSize();
        }
        androidx.appcompat.widget.v mTextHelper = this.mTextHelper;
        if (mTextHelper != null) {
            return mTextHelper.f();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (d.d) {
            return super.getAutoSizeStepGranularity();
        }
        androidx.appcompat.widget.v mTextHelper = this.mTextHelper;
        if (mTextHelper != null) {
            return mTextHelper.g();
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (d.d) {
            return super.getAutoSizeTextAvailableSizes();
        }
        androidx.appcompat.widget.v mTextHelper = this.mTextHelper;
        if (mTextHelper != null) {
            return mTextHelper.h();
        }
        return new int[0];
    }

    @Override // android.widget.TextView
    public int getAutoSizeTextType() {
        int i;
        final int i3 = 1;
        if (d.d && super.getAutoSizeTextType() == i3) {
            i3 = 1;
            if (super.getAutoSizeTextType() == i3) {
                i = i3;
            }
            return i;
        }
        androidx.appcompat.widget.v mTextHelper = this.mTextHelper;
        if (mTextHelper != null) {
            return mTextHelper.i();
        }
        return 0;
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return k.b(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return k.c(this);
    }

    @Override // android.widget.TextView
    public ColorStateList getSupportBackgroundTintList() {
        ColorStateList list;
        androidx.appcompat.widget.e mBackgroundTintHelper = this.mBackgroundTintHelper;
        if (mBackgroundTintHelper != null) {
            list = mBackgroundTintHelper.c();
        } else {
            list = 0;
        }
        return list;
    }

    @Override // android.widget.TextView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        PorterDuff.Mode mode;
        androidx.appcompat.widget.e mBackgroundTintHelper = this.mBackgroundTintHelper;
        if (mBackgroundTintHelper != null) {
            mode = mBackgroundTintHelper.d();
        } else {
            mode = 0;
        }
        return mode;
    }

    @Override // android.widget.TextView
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.mTextHelper.j();
    }

    @Override // android.widget.TextView
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.mTextHelper.k();
    }

    @Override // android.widget.TextView
    public java.lang.CharSequence getText() {
        consumeTextFutureAndSetBlocking();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        int mTextClassifierHelper;
        mTextClassifierHelper = this.mTextClassifierHelper;
        if (Build.VERSION.SDK_INT < 28 && mTextClassifierHelper == null) {
            mTextClassifierHelper = this.mTextClassifierHelper;
            if (mTextClassifierHelper == null) {
            }
            return mTextClassifierHelper.a();
        }
        return super.getTextClassifier();
    }

    @Override // android.widget.TextView
    public d.a getTextMetricsParamsCompat() {
        return k.g(this);
    }

    @Override // android.widget.TextView
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        final InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        j.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.TextView
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean z2;
        int i7;
        int i;
        int i6;
        int i8;
        super.onLayout(z, i2, i3, i4, i5);
        final androidx.appcompat.widget.v mTextHelper = this.mTextHelper;
        if (mTextHelper != null) {
            mTextHelper.o(z, i2, i3, i4, i5);
        }
    }

    @Override // android.widget.TextView
    protected void onMeasure(int i, int i2) {
        consumeTextFutureAndSetBlocking();
        super.onMeasure(i, i2);
    }

    @Override // android.widget.TextView
    protected void onTextChanged(java.lang.CharSequence charSequence, int i2, int i3, int i4) {
        androidx.appcompat.widget.v obj1;
        int obj2;
        super.onTextChanged(charSequence, i2, i3, i4);
        obj1 = this.mTextHelper;
        if (obj1 != null && !d.d && obj1.l()) {
            if (!d.d) {
                if (obj1.l()) {
                    this.mTextHelper.c();
                }
            }
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        boolean mTextHelper;
        if (d.d) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        } else {
            mTextHelper = this.mTextHelper;
            if (mTextHelper != null) {
                mTextHelper.s(i, i2, i3, i4);
            }
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) {
        boolean mTextHelper;
        if (d.d) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
        } else {
            mTextHelper = this.mTextHelper;
            if (mTextHelper != null) {
                mTextHelper.t(iArr, i2);
            }
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        boolean mTextHelper;
        if (d.d) {
            super.setAutoSizeTextTypeWithDefaults(i);
        } else {
            mTextHelper = this.mTextHelper;
            if (mTextHelper != null) {
                mTextHelper.u(i);
            }
        }
    }

    @Override // android.widget.TextView
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        final androidx.appcompat.widget.e mBackgroundTintHelper = this.mBackgroundTintHelper;
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.f(drawable);
        }
    }

    @Override // android.widget.TextView
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        final androidx.appcompat.widget.e mBackgroundTintHelper = this.mBackgroundTintHelper;
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.g(i);
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        final androidx.appcompat.widget.v obj1 = this.mTextHelper;
        if (obj1 != null) {
            obj1.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        final androidx.appcompat.widget.v obj1 = this.mTextHelper;
        if (obj1 != null) {
            obj1.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        int i5;
        int obj3;
        int obj4;
        Drawable obj5;
        final Context context = getContext();
        i5 = 0;
        if (i != 0) {
            obj3 = a.d(context, i);
        } else {
            obj3 = i5;
        }
        if (i2 != 0) {
            obj4 = a.d(context, i2);
        } else {
            obj4 = i5;
        }
        if (i3 != 0) {
            obj5 = a.d(context, i3);
        } else {
            obj5 = i5;
        }
        if (i4 != 0) {
            i5 = a.d(context, i4);
        }
        setCompoundDrawablesRelativeWithIntrinsicBounds(obj3, obj4, obj5, i5);
        obj3 = this.mTextHelper;
        if (obj3 != null) {
            obj3.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        final androidx.appcompat.widget.v obj1 = this.mTextHelper;
        if (obj1 != null) {
            obj1.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        int i5;
        int obj3;
        int obj4;
        Drawable obj5;
        final Context context = getContext();
        i5 = 0;
        if (i != 0) {
            obj3 = a.d(context, i);
        } else {
            obj3 = i5;
        }
        if (i2 != 0) {
            obj4 = a.d(context, i2);
        } else {
            obj4 = i5;
        }
        if (i3 != 0) {
            obj5 = a.d(context, i3);
        } else {
            obj5 = i5;
        }
        if (i4 != 0) {
            i5 = a.d(context, i4);
        }
        setCompoundDrawablesWithIntrinsicBounds(obj3, obj4, obj5, i5);
        obj3 = this.mTextHelper;
        if (obj3 != null) {
            obj3.p();
        }
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        final androidx.appcompat.widget.v obj1 = this.mTextHelper;
        if (obj1 != null) {
            obj1.p();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback actionMode$Callback) {
        super.setCustomSelectionActionModeCallback(k.s(this, callback));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i);
        } else {
            k.m(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i);
        } else {
            k.n(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        k.o(this, i);
    }

    @Override // android.widget.TextView
    public void setPrecomputedText(d d) {
        k.p(this, d);
    }

    @Override // android.widget.TextView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        final androidx.appcompat.widget.e mBackgroundTintHelper = this.mBackgroundTintHelper;
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.i(colorStateList);
        }
    }

    @Override // android.widget.TextView
    public void setSupportBackgroundTintMode(PorterDuff.Mode porterDuff$Mode) {
        final androidx.appcompat.widget.e mBackgroundTintHelper = this.mBackgroundTintHelper;
        if (mBackgroundTintHelper != null) {
            mBackgroundTintHelper.j(mode);
        }
    }

    @Override // android.widget.TextView
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.mTextHelper.v(colorStateList);
        this.mTextHelper.b();
    }

    @Override // android.widget.TextView
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode porterDuff$Mode) {
        this.mTextHelper.w(mode);
        this.mTextHelper.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        final androidx.appcompat.widget.v mTextHelper = this.mTextHelper;
        if (mTextHelper != null) {
            mTextHelper.q(context, i2);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        int mTextClassifierHelper;
        mTextClassifierHelper = this.mTextClassifierHelper;
        if (Build.VERSION.SDK_INT < 28 && mTextClassifierHelper == null) {
            mTextClassifierHelper = this.mTextClassifierHelper;
            if (mTextClassifierHelper == null) {
            }
            mTextClassifierHelper.b(textClassifier);
        }
        super.setTextClassifier(textClassifier);
    }

    public void setTextFuture(Future<d> future) {
        this.mPrecomputedTextFuture = future;
        if (future != null) {
            requestLayout();
        }
    }

    @Override // android.widget.TextView
    public void setTextMetricsParamsCompat(d.a d$a) {
        k.r(this, a);
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f2) {
        boolean mTextHelper;
        if (d.d) {
            super.setTextSize(i, f2);
        } else {
            mTextHelper = this.mTextHelper;
            if (mTextHelper != null) {
                mTextHelper.z(i, f2);
            }
        }
    }

    @Override // android.widget.TextView
    public void setTypeface(Typeface typeface, int i2) {
        int i;
        Typeface obj2;
        if (typeface != null && i2 > 0) {
            if (i2 > 0) {
                i = d.a(getContext(), typeface, i2);
            } else {
                i = 0;
            }
        } else {
        }
        if (i != 0) {
            obj2 = i;
        }
        super.setTypeface(obj2, i2);
    }
}
