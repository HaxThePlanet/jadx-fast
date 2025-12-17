package com.google.android.material.timepicker;

import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.a;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.button.MaterialButtonToggleGroup.e;
import com.google.android.material.internal.k;
import com.google.android.material.textfield.TextInputLayout;
import d.a.k.a.a;
import f.c.a.e.b;
import f.c.a.e.f;
import f.c.a.e.j;
import f.c.a.e.r.a;
import java.lang.reflect.Field;

/* loaded from: classes2.dex */
class i implements com.google.android.material.timepicker.TimePickerView.g, com.google.android.material.timepicker.g {

    private final EditText A;
    private MaterialButtonToggleGroup B;
    private final LinearLayout a;
    private final com.google.android.material.timepicker.e b;
    private final TextWatcher c;
    private final TextWatcher v;
    private final com.google.android.material.timepicker.ChipTextInputComboView w;
    private final com.google.android.material.timepicker.ChipTextInputComboView x;
    private final com.google.android.material.timepicker.h y;
    private final EditText z;

    class c implements View.OnClickListener {

        final com.google.android.material.timepicker.i a;
        c(com.google.android.material.timepicker.i i) {
            this.a = i;
            super();
        }

        @Override // android.view.View$OnClickListener
        public void onClick(View view) {
            this.a.f((Integer)view.getTag(f.Z).intValue());
        }
    }

    class a extends k {

        final com.google.android.material.timepicker.i a;
        a(com.google.android.material.timepicker.i i) {
            this.a = i;
            super();
        }

        @Override // com.google.android.material.internal.k
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                }
                i.b(this.a).i(0);
                i.b(this.a).i(Integer.parseInt(editable.toString()));
            }
        }
    }

    class b extends k {

        final com.google.android.material.timepicker.i a;
        b(com.google.android.material.timepicker.i i) {
            this.a = i;
            super();
        }

        @Override // com.google.android.material.internal.k
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                }
                i.b(this.a).g(0);
                i.b(this.a).g(Integer.parseInt(editable.toString()));
            }
        }
    }

    class d implements MaterialButtonToggleGroup.e {

        final com.google.android.material.timepicker.i a;
        d(com.google.android.material.timepicker.i i) {
            this.a = i;
            super();
        }

        @Override // com.google.android.material.button.MaterialButtonToggleGroup$e
        public void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i2, boolean z3) {
            int obj1;
            obj1 = i2 == f.m ? 1 : 0;
            i.b(this.a).j(obj1);
        }
    }
    public i(LinearLayout linearLayout, com.google.android.material.timepicker.e e2) {
        int sDK_INT;
        super();
        i.a aVar = new i.a(this);
        this.c = aVar;
        i.b bVar = new i.b(this);
        this.v = bVar;
        this.a = linearLayout;
        this.b = e2;
        Resources resources = linearLayout.getResources();
        View viewById = linearLayout.findViewById(f.r);
        this.w = (ChipTextInputComboView)viewById;
        View viewById2 = linearLayout.findViewById(f.o);
        this.x = (ChipTextInputComboView)viewById2;
        int i6 = f.q;
        (TextView)viewById.findViewById(i6).setText(resources.getString(j.o));
        (TextView)viewById2.findViewById(i6).setText(resources.getString(j.n));
        int i = f.Z;
        viewById.setTag(i, 12);
        viewById2.setTag(i, 10);
        if (e2.c == 0) {
            m();
        }
        i.c cVar = new i.c(this);
        viewById2.setOnClickListener(cVar);
        viewById.setOnClickListener(cVar);
        viewById2.c(e2.d());
        viewById.c(e2.e());
        EditText editText = viewById2.e().getEditText();
        this.z = editText;
        EditText editText2 = viewById.e().getEditText();
        this.A = editText2;
        if (Build.VERSION.SDK_INT < 21) {
            sDK_INT = a.d(linearLayout, b.o);
            i.k(editText, sDK_INT);
            i.k(editText2, sDK_INT);
        }
        h hVar = new h(viewById2, viewById, e2);
        this.y = hVar;
        a obj8 = new a(linearLayout.getContext(), j.i);
        viewById2.f(obj8);
        obj8 = new a(linearLayout.getContext(), j.k);
        viewById.f(obj8);
        h();
    }

    static com.google.android.material.timepicker.e b(com.google.android.material.timepicker.i i) {
        return i.b;
    }

    private void d() {
        this.z.addTextChangedListener(this.v);
        this.A.addTextChangedListener(this.c);
    }

    private void i() {
        this.z.removeTextChangedListener(this.v);
        this.A.removeTextChangedListener(this.c);
    }

    private static void k(EditText editText, int i2) {
        try {
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            int i3 = 1;
            declaredField.setAccessible(i3);
            Field declaredField2 = TextView.class.getDeclaredField("mEditor");
            declaredField2.setAccessible(i3);
            final Object obj5 = declaredField2.get(editText);
            Field declaredField3 = obj5.getClass().getDeclaredField("mCursorDrawable");
            declaredField3.setAccessible(i3);
            Drawable drawable = a.d(editText.getContext(), declaredField.getInt(editText));
            drawable.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
            Drawable[] obj6 = new Drawable[2];
            obj6[i3] = drawable;
            declaredField3.set(obj5, obj6);
        }
    }

    private void l(com.google.android.material.timepicker.e e) {
        i();
        java.util.Locale locale = configuration.locale;
        int i = 1;
        Object[] arr2 = new Object[i];
        final int i3 = 0;
        arr2[i3] = Integer.valueOf(e.w);
        String str = "%02d";
        Object[] arr = new Object[i];
        arr[i3] = Integer.valueOf(e.c());
        this.w.g(String.format(locale, str, arr2));
        this.x.g(String.format(locale, str, arr));
        d();
        n();
    }

    private void m() {
        View viewById = this.a.findViewById(f.n);
        this.B = (MaterialButtonToggleGroup)viewById;
        i.d dVar = new i.d(this);
        viewById.g(dVar);
        this.B.setVisibility(0);
        n();
    }

    private void n() {
        int i;
        final MaterialButtonToggleGroup materialButtonToggleGroup = this.B;
        if (materialButtonToggleGroup == null) {
        }
        i = eVar.y == 0 ? f.l : f.m;
        materialButtonToggleGroup.j(i);
    }

    @Override // com.google.android.material.timepicker.TimePickerView$g
    public void a() {
        this.a.setVisibility(0);
    }

    @Override // com.google.android.material.timepicker.TimePickerView$g
    public void c() {
        l(this.b);
    }

    @Override // com.google.android.material.timepicker.TimePickerView$g
    public void e() {
        final int i = 0;
        this.w.setChecked(i);
        this.x.setChecked(i);
    }

    @Override // com.google.android.material.timepicker.TimePickerView$g
    public void f(int i) {
        int i3;
        int i2;
        eVar.x = i;
        final int i4 = 0;
        i2 = i == 12 ? i3 : i4;
        this.w.setChecked(i2);
        if (i == 10) {
        } else {
            i3 = i4;
        }
        this.x.setChecked(i3);
        n();
    }

    @Override // com.google.android.material.timepicker.TimePickerView$g
    public void g() {
        Object focusedChild;
        Class<InputMethodManager> obj;
        focusedChild = this.a.getFocusedChild();
        final int i = 8;
        if (focusedChild == null) {
            this.a.setVisibility(i);
        }
        Object obj2 = a.k(this.a.getContext(), InputMethodManager.class);
        if ((InputMethodManager)obj2 != null) {
            (InputMethodManager)obj2.hideSoftInputFromWindow(focusedChild.getWindowToken(), 0);
        }
        this.a.setVisibility(i);
    }

    @Override // com.google.android.material.timepicker.TimePickerView$g
    public void h() {
        d();
        l(this.b);
        this.y.a();
    }

    @Override // com.google.android.material.timepicker.TimePickerView$g
    public void j() {
        int i;
        int i2;
        final int i5 = 0;
        i = eVar.x == 12 ? i2 : i5;
        this.w.setChecked(i);
        if (eVar2.x == 10) {
        } else {
            i2 = i5;
        }
        this.x.setChecked(i2);
    }
}
