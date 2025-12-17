package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.internal.e;
import com.google.android.material.internal.l;
import com.google.android.material.theme.a.a;
import f.c.a.e.b;
import f.c.a.e.d;
import f.c.a.e.f;
import f.c.a.e.k;
import f.c.a.e.l;

/* loaded from: classes2.dex */
public class TextInputEditText extends AppCompatEditText {

    private final Rect v;
    private boolean w;
    public TextInputEditText(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, b.r);
    }

    public TextInputEditText(Context context, AttributeSet attributeSet2, int i3) {
        final int i = 0;
        super(a.c(context, attributeSet2, i3, i), attributeSet2, i3);
        Rect rect = new Rect();
        this.v = rect;
        final TypedArray obj9 = l.h(context, attributeSet2, l.j5, i3, k.m, new int[i]);
        setTextInputLayoutFocusedRectEnabled(obj9.getBoolean(l.k5, i));
        obj9.recycle();
    }

    private String a(com.google.android.material.textfield.TextInputLayout textInputLayout) {
        boolean stringBuilder;
        int str;
        int sDK_INT;
        String string;
        String obj6;
        android.text.Editable text = getText();
        obj6 = textInputLayout.getHint();
        if (Build.VERSION.SDK_INT >= 17) {
            setLabelFor(f.f0);
        }
        string = "";
        if (empty3 ^= 1 != 0) {
            obj6 = obj6.toString();
        } else {
            obj6 = string;
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(text);
        if (empty2 ^= 1 != 0 && !TextUtils.isEmpty(obj6)) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(text);
            if (!TextUtils.isEmpty(obj6)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(", ");
                stringBuilder.append(obj6);
                string = stringBuilder.toString();
            }
            stringBuilder2.append(string);
            return stringBuilder2.toString();
        }
        if (!TextUtils.isEmpty(obj6)) {
            return obj6;
        }
        return string;
    }

    private java.lang.CharSequence getHintFromLayout() {
        java.lang.CharSequence hint;
        com.google.android.material.textfield.TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null) {
            hint = textInputLayout.getHint();
        } else {
            hint = 0;
        }
        return hint;
    }

    private com.google.android.material.textfield.TextInputLayout getTextInputLayout() {
        ViewParent parent;
        boolean z;
        parent = getParent();
        while (parent instanceof View != null) {
            parent = parent.getParent();
        }
        return null;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText
    public void getFocusedRect(Rect rect) {
        com.google.android.material.textfield.TextInputLayout textInputLayout;
        boolean z;
        super.getFocusedRect(rect);
        textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.w && rect != null) {
            if (this.w) {
                if (rect != null) {
                    textInputLayout.getFocusedRect(this.v);
                    rect.bottom = rect2.bottom;
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatEditText
    public boolean getGlobalVisibleRect(Rect rect, Point point2) {
        boolean z;
        Point obj5;
        final com.google.android.material.textfield.TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.w && rect != null) {
            if (this.w) {
                if (rect != null) {
                    textInputLayout.getGlobalVisibleRect(this.v, point2);
                    rect.bottom = obj5.bottom;
                }
            }
        }
        return super.getGlobalVisibleRect(rect, point2);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText
    public java.lang.CharSequence getHint() {
        boolean z;
        com.google.android.material.textfield.TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && textInputLayout.P()) {
            if (textInputLayout.P()) {
                return textInputLayout.getHint();
            }
        }
        return super.getHint();
    }

    @Override // androidx.appcompat.widget.AppCompatEditText
    protected void onAttachedToWindow() {
        com.google.android.material.textfield.TextInputLayout textInputLayout;
        super.onAttachedToWindow();
        textInputLayout = getTextInputLayout();
        if (textInputLayout != null && textInputLayout.P() && super.getHint() == null && e.c()) {
            if (textInputLayout.P()) {
                if (super.getHint() == null) {
                    if (e.c()) {
                        setHint("");
                    }
                }
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatEditText
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        java.lang.CharSequence hintFromLayout;
        final InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection != null && editorInfo.hintText == null) {
            if (editorInfo.hintText == null) {
                editorInfo.hintText = getHintFromLayout();
            }
        }
        return onCreateInputConnection;
    }

    @Override // androidx.appcompat.widget.AppCompatEditText
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        Object textInputLayout;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        textInputLayout = getTextInputLayout();
        if (Build.VERSION.SDK_INT < 23 && textInputLayout != null) {
            if (textInputLayout != null) {
                accessibilityNodeInfo.setText(a(textInputLayout));
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatEditText
    public boolean requestRectangleOnScreen(Rect rect) {
        boolean z;
        int i;
        int i2;
        int width;
        int height;
        final com.google.android.material.textfield.TextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.w) {
            if (this.w) {
                this.v.set(0, height2 -= dimensionPixelOffset, textInputLayout.getWidth(), textInputLayout.getHeight());
                textInputLayout.requestRectangleOnScreen(this.v, true);
            }
        }
        return super.requestRectangleOnScreen(rect);
    }

    @Override // androidx.appcompat.widget.AppCompatEditText
    public void setTextInputLayoutFocusedRectEnabled(boolean z) {
        this.w = z;
    }
}
