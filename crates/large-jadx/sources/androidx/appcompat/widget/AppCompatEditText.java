package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.EditText;
import androidx.core.widget.k;
import d.a.a;
import d.h.l.t;

/* loaded from: classes.dex */
public class AppCompatEditText extends EditText implements t {

    private final androidx.appcompat.widget.e a;
    private final androidx.appcompat.widget.v b;
    private final androidx.appcompat.widget.u c;
    public AppCompatEditText(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, a.B);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet2, int i3) {
        super(q0.b(context), attributeSet2, i3);
        o0.a(this, getContext());
        e obj1 = new e(this);
        this.a = obj1;
        obj1.e(attributeSet2, i3);
        obj1 = new v(this);
        this.b = obj1;
        obj1.m(attributeSet2, i3);
        obj1.b();
        obj1 = new u(this);
        this.c = obj1;
    }

    @Override // android.widget.EditText
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

    @Override // android.widget.EditText
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

    @Override // android.widget.EditText
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

    @Override // android.widget.EditText
    public Editable getText() {
        if (Build.VERSION.SDK_INT >= 28) {
            return super.getText();
        }
        return super.getEditableText();
    }

    @Override // android.widget.EditText
    public java.lang.CharSequence getText() {
        return getText();
    }

    @Override // android.widget.EditText
    public TextClassifier getTextClassifier() {
        int sDK_INT;
        sDK_INT = this.c;
        if (Build.VERSION.SDK_INT < 28 && sDK_INT == null) {
            sDK_INT = this.c;
            if (sDK_INT == null) {
            }
            return sDK_INT.a();
        }
        return super.getTextClassifier();
    }

    @Override // android.widget.EditText
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        final InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        j.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.EditText
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        final androidx.appcompat.widget.e eVar = this.a;
        if (eVar != null) {
            eVar.f(drawable);
        }
    }

    @Override // android.widget.EditText
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        final androidx.appcompat.widget.e eVar = this.a;
        if (eVar != null) {
            eVar.g(i);
        }
    }

    @Override // android.widget.EditText
    public void setCustomSelectionActionModeCallback(ActionMode.Callback actionMode$Callback) {
        super.setCustomSelectionActionModeCallback(k.s(this, callback));
    }

    @Override // android.widget.EditText
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        final androidx.appcompat.widget.e eVar = this.a;
        if (eVar != null) {
            eVar.i(colorStateList);
        }
    }

    @Override // android.widget.EditText
    public void setSupportBackgroundTintMode(PorterDuff.Mode porterDuff$Mode) {
        final androidx.appcompat.widget.e eVar = this.a;
        if (eVar != null) {
            eVar.j(mode);
        }
    }

    @Override // android.widget.EditText
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        final androidx.appcompat.widget.v vVar = this.b;
        if (vVar != null) {
            vVar.q(context, i2);
        }
    }

    @Override // android.widget.EditText
    public void setTextClassifier(TextClassifier textClassifier) {
        int sDK_INT;
        sDK_INT = this.c;
        if (Build.VERSION.SDK_INT < 28 && sDK_INT == null) {
            sDK_INT = this.c;
            if (sDK_INT == null) {
            }
            sDK_INT.b(textClassifier);
        }
        super.setTextClassifier(textClassifier);
    }
}
