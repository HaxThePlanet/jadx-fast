package com.google.android.material.internal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Checkable;
import android.widget.ImageButton;
import androidx.appcompat.widget.k;
import d.a.a;
import d.h.l.a;
import d.h.l.e0.c;
import d.h.l.u;
import d.j.a.a;

/* loaded from: classes2.dex */
public class CheckableImageButton extends k implements Checkable {

    private static final int[] x;
    private boolean c;
    private boolean v;
    private boolean w;

    class a extends a {

        final com.google.android.material.internal.CheckableImageButton d;
        a(com.google.android.material.internal.CheckableImageButton checkableImageButton) {
            this.d = checkableImageButton;
            super();
        }

        @Override // d.h.l.a
        public void f(View view, AccessibilityEvent accessibilityEvent2) {
            super.f(view, accessibilityEvent2);
            accessibilityEvent2.setChecked(this.d.isChecked());
        }

        @Override // d.h.l.a
        public void g(View view, c c2) {
            super.g(view, c2);
            c2.V(this.d.a());
            c2.W(this.d.isChecked());
        }
    }

    static class b extends a {

        public static final Parcelable.Creator<com.google.android.material.internal.CheckableImageButton.b> CREATOR;
        boolean c;
        static {
            CheckableImageButton.b.a aVar = new CheckableImageButton.b.a();
            CheckableImageButton.b.CREATOR = aVar;
        }

        public b(Parcel parcel, java.lang.ClassLoader classLoader2) {
            super(parcel, classLoader2);
            b(parcel);
        }

        public b(Parcelable parcelable) {
            super(parcelable);
        }

        private void b(Parcel parcel) {
            int i;
            if (parcel.readInt() == 1) {
            } else {
                i = 0;
            }
            this.c = i;
        }

        @Override // d.j.a.a
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.c);
        }
    }
    static {
        int[] iArr = new int[1];
        CheckableImageButton.x = iArr;
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2, a.C);
    }

    public CheckableImageButton(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
        int obj1 = 1;
        this.v = obj1;
        this.w = obj1;
        obj1 = new CheckableImageButton.a(this);
        u.l0(this, obj1);
    }

    @Override // androidx.appcompat.widget.k
    public boolean a() {
        return this.v;
    }

    @Override // androidx.appcompat.widget.k
    public boolean isChecked() {
        return this.c;
    }

    @Override // androidx.appcompat.widget.k
    public int[] onCreateDrawableState(int i) {
        if (this.c) {
            int[] iArr = CheckableImageButton.x;
            return ImageButton.mergeDrawableStates(super.onCreateDrawableState(i += length), iArr);
        }
        return super.onCreateDrawableState(i);
    }

    @Override // androidx.appcompat.widget.k
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!parcelable instanceof CheckableImageButton.b) {
            super.onRestoreInstanceState(parcelable);
        }
        super.onRestoreInstanceState((CheckableImageButton.b)parcelable.a());
        setChecked(parcelable.c);
    }

    @Override // androidx.appcompat.widget.k
    protected Parcelable onSaveInstanceState() {
        CheckableImageButton.b bVar = new CheckableImageButton.b(super.onSaveInstanceState());
        bVar.c = this.c;
        return bVar;
    }

    @Override // androidx.appcompat.widget.k
    public void setCheckable(boolean z) {
        boolean obj2;
        if (this.v != z) {
            this.v = z;
            sendAccessibilityEvent(0);
        }
    }

    @Override // androidx.appcompat.widget.k
    public void setChecked(boolean z) {
        boolean z2;
        boolean obj2;
        if (this.v && this.c != z) {
            if (this.c != z) {
                this.c = z;
                refreshDrawableState();
                sendAccessibilityEvent(2048);
            }
        }
    }

    @Override // androidx.appcompat.widget.k
    public void setPressable(boolean z) {
        this.w = z;
    }

    @Override // androidx.appcompat.widget.k
    public void setPressed(boolean z) {
        if (this.w) {
            super.setPressed(z);
        }
    }

    @Override // androidx.appcompat.widget.k
    public void toggle() {
        setChecked(z ^= 1);
    }
}
