package com.skydoves.balloon.vectortext;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.skydoves.balloon.a0.d;
import com.skydoves.balloon.l;
import com.skydoves.balloon.x;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.w;

/* loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\n\u0018\u00002\u00020\u0001B\u001d\u0008\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\u0008\u0016\u0010\u0008J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\u0008\u000b\u0010\u000cR.\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014¨\u0006\u0017", d2 = {"Lcom/skydoves/balloon/vectortext/VectorTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "Lkotlin/w;", "i", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "rtlLayout", "j", "(Z)V", "Lcom/skydoves/balloon/vectortext/a;", "value", "a", "Lcom/skydoves/balloon/vectortext/a;", "getDrawableTextViewParams", "()Lcom/skydoves/balloon/vectortext/a;", "setDrawableTextViewParams", "(Lcom/skydoves/balloon/vectortext/a;)V", "drawableTextViewParams", "<init>", "balloon_release"}, k = 1, mv = {1, 4, 2})
public final class VectorTextView extends AppCompatTextView {

    private com.skydoves.balloon.vectortext.a a;
    public VectorTextView(Context context, AttributeSet attributeSet2) {
        n.f(context, "context");
        super(context, attributeSet2);
        i(context, attributeSet2);
    }

    private final void i(Context context, AttributeSet attributeSet2) {
        Object styledAttributes;
        com.skydoves.balloon.vectortext.a aVar;
        Object obj;
        Integer num8;
        Integer num7;
        Integer num5;
        Integer num9;
        int i;
        int i2;
        int i10;
        int i6;
        int i8;
        int i5;
        int i4;
        int i3;
        Integer num3;
        Integer num4;
        Integer num6;
        Integer num;
        Integer num2;
        int i9;
        int i7;
        styledAttributes = attributeSet2;
        if (styledAttributes != null) {
            styledAttributes = context.obtainStyledAttributes(styledAttributes, x.a);
            n.e(styledAttributes, "context.obtainStyledAttr…styleable.VectorTextView)");
            int i23 = Integer.MIN_VALUE;
            int i15 = 0;
            int i21 = 0;
            int i22 = i23;
            super(l.a(styledAttributes.getResourceId(x.g, i23)), l.a(styledAttributes.getResourceId(x.c, i23)), l.a(styledAttributes.getResourceId(x.b, i23)), l.a(styledAttributes.getResourceId(x.i, i23)), 0, 0, 0, 0, 0, 0, 0, 0, l.a(styledAttributes.getResourceId(x.e, i23)), l.a(styledAttributes.getResourceId(x.h, i22)), l.a(styledAttributes.getResourceId(x.j, i22)), l.a(styledAttributes.getResourceId(x.d, i22)), l.a(styledAttributes.getResourceId(x.f, i22)), 4080, 0);
            this.setDrawableTextViewParams(aVar);
            styledAttributes.recycle();
        } else {
            obj = this;
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public final com.skydoves.balloon.vectortext.a getDrawableTextViewParams() {
        return this.a;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public final void j(boolean z) {
        final com.skydoves.balloon.vectortext.a aVar = this.a;
        if (aVar != null) {
            aVar.z(z);
            d.a(this, aVar);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public final void setDrawableTextViewParams(com.skydoves.balloon.vectortext.a a) {
        w wVar;
        com.skydoves.balloon.vectortext.a obj2;
        if (a != null) {
            d.a(this, a);
            wVar = w.a;
        } else {
            obj2 = 0;
        }
        this.a = obj2;
    }
}
