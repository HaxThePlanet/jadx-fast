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

/* compiled from: VectorTextView.kt */
@Metadata(bv = {1, 0, 3}, d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\n\u0018\u00002\u00020\u0001B\u001d\u0008\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0008\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\u0008\u0016\u0010\u0008J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0008\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\u0008\u0007\u0010\u0008J\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\u0008\u000b\u0010\u000cR.\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0008\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u0011\u0010\u0012\"\u0004\u0008\u0013\u0010\u0014¨\u0006\u0017", d2 = {"Lcom/skydoves/balloon/vectortext/VectorTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "Lkotlin/w;", "i", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "rtlLayout", "j", "(Z)V", "Lcom/skydoves/balloon/vectortext/a;", "value", "a", "Lcom/skydoves/balloon/vectortext/a;", "getDrawableTextViewParams", "()Lcom/skydoves/balloon/vectortext/a;", "setDrawableTextViewParams", "(Lcom/skydoves/balloon/vectortext/a;)V", "drawableTextViewParams", "<init>", "balloon_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes2.dex */
public final class VectorTextView extends AppCompatTextView {

    /* renamed from: a, reason: from kotlin metadata */
    private a drawableTextViewParams;
    public VectorTextView(Context context, AttributeSet set) {
        n.f(context, "context");
        super(context, set);
        i(context, set);
    }

    private final void i(Context context, AttributeSet attrs) throws android.content.res.Resources.NotFoundException {
        AttributeSet attrs2 = attrs;
        if (attrs2 != null) {
            TypedArray styledAttributes = context.obtainStyledAttributes(attrs2, x.a);
            n.e(styledAttributes, "context.obtainStyledAttr…styleable.VectorTextView)");
            int i = Integer.MIN_VALUE;
            android.graphics.drawable.Drawable drawable3 = null;
            android.graphics.drawable.Drawable drawable4 = null;
            boolean z = false;
            Integer num6 = null;
            Integer num7 = null;
            Integer num8 = null;
            int i2 = 4080;
            kotlin.d0.d.g gVar = null;
            android.graphics.drawable.Drawable drawable = null;
            android.graphics.drawable.Drawable drawable2 = null;
            a aVar = new a(l.a(styledAttributes.getResourceId(x.g, i)), l.a(styledAttributes.getResourceId(x.c, i)), l.a(styledAttributes.getResourceId(x.b, i)), l.a(styledAttributes.getResourceId(x.i, i)), drawable, drawable2, drawable3, drawable4, z, num6, num7, num8, num5, l.a(styledAttributes.getResourceId(x.h, i)), l.a(styledAttributes.getResourceId(x.j, i)), l.a(styledAttributes.getResourceId(x.d, i)), l.a(styledAttributes.getResourceId(x.f, i)), i2, gVar);
            this.setDrawableTextViewParams(aVar);
            styledAttributes.recycle();
        } else {
            obj = this;
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public final a getDrawableTextViewParams() {
        return this.drawableTextViewParams;
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public final void j(boolean rtlLayout) {
        if (this.drawableTextViewParams != null) {
            this.drawableTextViewParams.z(rtlLayout);
            d.a(this, this.drawableTextViewParams);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatTextView
    public final void setDrawableTextViewParams(a aVar) {
        int i = 0;
        if (aVar != null) {
            d.a(this, aVar);
            wVar = w.a;
        } else {
            i = 0;
        }
        this.drawableTextViewParams = i;
    }
}
