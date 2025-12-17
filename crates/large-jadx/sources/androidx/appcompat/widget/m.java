package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import d.a.a;
import d.a.k.a.a;
import d.h.l.t;

/* loaded from: classes.dex */
public class m extends MultiAutoCompleteTextView implements t {

    private static final int[] c;
    private final androidx.appcompat.widget.e a;
    private final androidx.appcompat.widget.v b;
    static {
        int[] iArr = new int[1];
        m.c = iArr;
    }

    public m(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, a.p);
    }

    public m(Context context, AttributeSet attributeSet2, int i3) {
        boolean z;
        super(q0.b(context), attributeSet2, i3);
        o0.a(this, getContext());
        final int i = 0;
        androidx.appcompat.widget.t0 obj3 = t0.v(getContext(), attributeSet2, m.c, i3, i);
        if (obj3.s(i)) {
            setDropDownBackgroundDrawable(obj3.g(i));
        }
        obj3.w();
        obj3 = new e(this);
        this.a = obj3;
        obj3.e(attributeSet2, i3);
        obj3 = new v(this);
        this.b = obj3;
        obj3.m(attributeSet2, i3);
        obj3.b();
    }

    @Override // android.widget.MultiAutoCompleteTextView
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

    @Override // android.widget.MultiAutoCompleteTextView
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

    @Override // android.widget.MultiAutoCompleteTextView
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

    @Override // android.widget.MultiAutoCompleteTextView
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        final InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        j.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.MultiAutoCompleteTextView
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        final androidx.appcompat.widget.e eVar = this.a;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.widget.MultiAutoCompleteTextView
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        final androidx.appcompat.widget.e eVar = this.a;
        if (eVar != null) {
            eVar.g(i);
        }
    }

    @Override // android.widget.MultiAutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(a.d(getContext(), i));
    }

    @Override // android.widget.MultiAutoCompleteTextView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        final androidx.appcompat.widget.e eVar = this.a;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // android.widget.MultiAutoCompleteTextView
    public void setSupportBackgroundTintMode(PorterDuff.Mode porterDuff$Mode) {
        final androidx.appcompat.widget.e eVar = this.a;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // android.widget.MultiAutoCompleteTextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        final androidx.appcompat.widget.v vVar = this.b;
        if (vVar != null) {
            vVar.q(context, i2);
        }
    }
}
