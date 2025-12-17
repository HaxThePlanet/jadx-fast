package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.core.widget.d;
import androidx.core.widget.k;
import androidx.core.widget.m;
import d.a.a;
import d.h.l.t;

/* loaded from: classes.dex */
public class f extends Button implements t, d, m {

    private final androidx.appcompat.widget.e a;
    private final androidx.appcompat.widget.v b;
    public f(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, a.q);
    }

    public f(Context context, AttributeSet attributeSet2, int i3) {
        super(q0.b(context), attributeSet2, i3);
        o0.a(this, getContext());
        e obj1 = new e(this);
        this.a = obj1;
        obj1.e(attributeSet2, i3);
        obj1 = new v(this);
        this.b = obj1;
        obj1.m(attributeSet2, i3);
        obj1.b();
    }

    @Override // android.widget.Button
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        androidx.appcompat.widget.e eVar = this.a;
        if (eVar != null) {
            eVar.b();
        }
        androidx.appcompat.widget.v vVar = this.b;
        if (vVar != null) {
            vVar.b();
        }
    }

    @Override // android.widget.Button
    public int getAutoSizeMaxTextSize() {
        if (d.d) {
            return super.getAutoSizeMaxTextSize();
        }
        androidx.appcompat.widget.v vVar = this.b;
        if (vVar != null) {
            return vVar.e();
        }
        return -1;
    }

    @Override // android.widget.Button
    public int getAutoSizeMinTextSize() {
        if (d.d) {
            return super.getAutoSizeMinTextSize();
        }
        androidx.appcompat.widget.v vVar = this.b;
        if (vVar != null) {
            return vVar.f();
        }
        return -1;
    }

    @Override // android.widget.Button
    public int getAutoSizeStepGranularity() {
        if (d.d) {
            return super.getAutoSizeStepGranularity();
        }
        androidx.appcompat.widget.v vVar = this.b;
        if (vVar != null) {
            return vVar.g();
        }
        return -1;
    }

    @Override // android.widget.Button
    public int[] getAutoSizeTextAvailableSizes() {
        if (d.d) {
            return super.getAutoSizeTextAvailableSizes();
        }
        androidx.appcompat.widget.v vVar = this.b;
        if (vVar != null) {
            return vVar.h();
        }
        return new int[0];
    }

    @Override // android.widget.Button
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
        androidx.appcompat.widget.v vVar = this.b;
        if (vVar != null) {
            return vVar.i();
        }
        return 0;
    }

    @Override // android.widget.Button
    public ColorStateList getSupportBackgroundTintList() {
        ColorStateList list;
        androidx.appcompat.widget.e eVar = this.a;
        if (eVar != null) {
            list = eVar.c();
        } else {
            list = 0;
        }
        return list;
    }

    @Override // android.widget.Button
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        PorterDuff.Mode mode;
        androidx.appcompat.widget.e eVar = this.a;
        if (eVar != null) {
            mode = eVar.d();
        } else {
            mode = 0;
        }
        return mode;
    }

    @Override // android.widget.Button
    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.b.j();
    }

    @Override // android.widget.Button
    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.b.k();
    }

    @Override // android.widget.Button
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.widget.Button
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.Button
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean z2;
        int i;
        int i7;
        int i8;
        int i6;
        super.onLayout(z, i2, i3, i4, i5);
        final androidx.appcompat.widget.v vVar = this.b;
        if (vVar != null) {
            vVar.o(z, i2, i3, i4, i5);
        }
    }

    @Override // android.widget.Button
    protected void onTextChanged(java.lang.CharSequence charSequence, int i2, int i3, int i4) {
        androidx.appcompat.widget.v obj1;
        int obj2;
        super.onTextChanged(charSequence, i2, i3, i4);
        obj1 = this.b;
        if (obj1 != null && !d.d && obj1.l()) {
            if (!d.d) {
                if (obj1.l()) {
                    this.b.c();
                }
            }
        }
    }

    @Override // android.widget.Button
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        boolean z;
        if (d.d) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        } else {
            z = this.b;
            if (z != null) {
                z.s(i, i2, i3, i4);
            }
        }
    }

    @Override // android.widget.Button
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i2) {
        boolean z;
        if (d.d) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i2);
        } else {
            z = this.b;
            if (z != null) {
                z.t(iArr, i2);
            }
        }
    }

    @Override // android.widget.Button
    public void setAutoSizeTextTypeWithDefaults(int i) {
        boolean z;
        if (d.d) {
            super.setAutoSizeTextTypeWithDefaults(i);
        } else {
            z = this.b;
            if (z != null) {
                z.u(i);
            }
        }
    }

    @Override // android.widget.Button
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        final androidx.appcompat.widget.e eVar = this.a;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.widget.Button
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        final androidx.appcompat.widget.e eVar = this.a;
        if (eVar != null) {
            eVar.g(i);
        }
    }

    @Override // android.widget.Button
    public void setCustomSelectionActionModeCallback(ActionMode.Callback actionMode$Callback) {
        super.setCustomSelectionActionModeCallback(k.s(this, callback));
    }

    @Override // android.widget.Button
    public void setSupportAllCaps(boolean z) {
        final androidx.appcompat.widget.v vVar = this.b;
        if (vVar != null) {
            vVar.r(z);
        }
    }

    @Override // android.widget.Button
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        final androidx.appcompat.widget.e eVar = this.a;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // android.widget.Button
    public void setSupportBackgroundTintMode(PorterDuff.Mode porterDuff$Mode) {
        final androidx.appcompat.widget.e eVar = this.a;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // android.widget.Button
    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        this.b.v(colorStateList);
        this.b.b();
    }

    @Override // android.widget.Button
    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode porterDuff$Mode) {
        this.b.w(mode);
        this.b.b();
    }

    @Override // android.widget.Button
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        final androidx.appcompat.widget.v vVar = this.b;
        if (vVar != null) {
            vVar.q(context, i2);
        }
    }

    @Override // android.widget.Button
    public void setTextSize(int i, float f2) {
        boolean z;
        if (d.d) {
            super.setTextSize(i, f2);
        } else {
            z = this.b;
            if (z != null) {
                z.z(i, f2);
            }
        }
    }
}
