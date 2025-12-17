package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.CheckedTextView;
import androidx.core.widget.k;
import d.a.k.a.a;

/* loaded from: classes.dex */
public class g extends CheckedTextView {

    private static final int[] b;
    private final androidx.appcompat.widget.v a;
    static {
        int[] iArr = new int[1];
        g.b = iArr;
    }

    public g(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, 16843720);
    }

    public g(Context context, AttributeSet attributeSet2, int i3) {
        super(q0.b(context), attributeSet2, i3);
        o0.a(this, getContext());
        v obj3 = new v(this);
        this.a = obj3;
        obj3.m(attributeSet2, i3);
        obj3.b();
        final int i = 0;
        obj3 = t0.v(getContext(), attributeSet2, g.b, i3, i);
        setCheckMarkDrawable(obj3.g(i));
        obj3.w();
    }

    @Override // android.widget.CheckedTextView
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        final androidx.appcompat.widget.v vVar = this.a;
        if (vVar != null) {
            vVar.b();
        }
    }

    @Override // android.widget.CheckedTextView
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        final InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        j.a(onCreateInputConnection, editorInfo, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.CheckedTextView
    public void setCheckMarkDrawable(int i) {
        setCheckMarkDrawable(a.d(getContext(), i));
    }

    @Override // android.widget.CheckedTextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback actionMode$Callback) {
        super.setCustomSelectionActionModeCallback(k.s(this, callback));
    }

    @Override // android.widget.CheckedTextView
    public void setTextAppearance(Context context, int i2) {
        super.setTextAppearance(context, i2);
        final androidx.appcompat.widget.v vVar = this.a;
        if (vVar != null) {
            vVar.q(context, i2);
        }
    }
}
