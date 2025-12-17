package com.google.android.material.theme;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.app.j;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.d;
import androidx.appcompat.widget.f;
import androidx.appcompat.widget.p;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.g;
import com.google.android.material.textview.MaterialTextView;
import f.c.a.e.p.a;
import f.c.a.e.z.a;

/* loaded from: classes2.dex */
public class MaterialComponentsViewInflater extends j {
    @Override // androidx.appcompat.app.j
    protected d b(Context context, AttributeSet attributeSet2) {
        g gVar = new g(context, attributeSet2);
        return gVar;
    }

    @Override // androidx.appcompat.app.j
    protected f c(Context context, AttributeSet attributeSet2) {
        MaterialButton materialButton = new MaterialButton(context, attributeSet2);
        return materialButton;
    }

    @Override // androidx.appcompat.app.j
    protected AppCompatCheckBox d(Context context, AttributeSet attributeSet2) {
        a aVar = new a(context, attributeSet2);
        return aVar;
    }

    @Override // androidx.appcompat.app.j
    protected p j(Context context, AttributeSet attributeSet2) {
        a aVar = new a(context, attributeSet2);
        return aVar;
    }

    @Override // androidx.appcompat.app.j
    protected AppCompatTextView n(Context context, AttributeSet attributeSet2) {
        MaterialTextView materialTextView = new MaterialTextView(context, attributeSet2);
        return materialTextView;
    }
}
