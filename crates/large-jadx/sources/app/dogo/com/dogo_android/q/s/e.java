package app.dogo.com.dogo_android.q.s;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.l.f;
import androidx.recyclerview.widget.l.i;
import app.dogo.com.dogo_android.h.w1;
import app.dogo.com.dogo_android.repository.domain.DogParentUIState.DogParent;
import kotlin.Metadata;
import kotlin.d0.c.p;
import kotlin.d0.d.n;
import kotlin.o;
import kotlin.w;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00126\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\n\u0012\u0004\u0012\u00020\u000b0\u0005¢\u0006\u0002\u0010\u000cJ@\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#H\u0016J \u0010$\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u001eH\u0016J\u0018\u0010&\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\n\u001a\u00020\u0006H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000RA\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\n\u0012\u0004\u0012\u00020\u000b0\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'", d2 = {"Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsTouchHelperCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$SimpleCallback;", "context", "Landroid/content/Context;", "onSwipe", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "swipeDir", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function2;)V", "creatorBackground", "Landroid/graphics/Paint;", "deleteText", "", "getOnSwipe", "()Lkotlin/jvm/functions/Function2;", "paintText", "parentBackground", "textMargin", "", "youText", "onChildDraw", "canvas", "Landroid/graphics/Canvas;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "dX", "dY", "actionState", "isCurrentlyActive", "", "onMove", "target", "onSwiped", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class e extends l.i {

    private final p<Integer, Integer, w> f;
    private final Paint g;
    private final Paint h;
    private final String i;
    private final String j;
    private final float k;
    private final Paint l;
    public e(Context context, p<? super Integer, ? super Integer, w> p2) {
        n.f(context, "context");
        n.f(p2, "onSwipe");
        super(0, 4);
        this.f = p2;
        Paint obj4 = new Paint();
        obj4.setColor(-65536);
        w wVar = w.a;
        this.g = obj4;
        obj4 = new Paint();
        obj4.setColor(-12303292);
        this.h = obj4;
        obj4 = context.getResources().getString(2131886715);
        n.e(obj4, "context.resources.getString(R.string.general_you)");
        obj4 = obj4.toUpperCase();
        String str4 = "(this as java.lang.String).toUpperCase()";
        n.e(obj4, str4);
        this.i = obj4;
        obj4 = context.getResources().getString(2131886681);
        n.e(obj4, "context.resources.getString(R.string.general_delete)");
        obj4 = obj4.toUpperCase();
        n.e(obj4, str4);
        this.j = obj4;
        int i5 = 2131165620;
        this.k = context.getResources().getDimension(i5);
        obj4 = new Paint();
        obj4.setColor(-1);
        obj4.setTextSize(context.getResources().getDimension(i5));
        obj4.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
        this.l = obj4;
    }

    @Override // androidx.recyclerview.widget.l$i
    public void C(RecyclerView.e0 recyclerView$e0, int i2) {
        n.f(e0, "viewHolder");
        this.f.invoke(Integer.valueOf(e0.getAdapterPosition()), Integer.valueOf(i2));
    }

    @Override // androidx.recyclerview.widget.l$i
    public void v(Canvas canvas, RecyclerView recyclerView2, RecyclerView.e0 recyclerView$e03, float f4, float f5, int i6, boolean z7) {
        String str;
        int i;
        float f3;
        float f2;
        float f;
        Object obj;
        Object obj8;
        int obj9;
        float obj10;
        int obj11;
        int obj12;
        String obj13;
        n.f(canvas, "canvas");
        n.f(recyclerView2, "recyclerView");
        n.f(e03, "viewHolder");
        super.v(canvas, recyclerView2, e03, f4, f5, i6, z7);
        obj8 = e03.itemView;
        n.e(obj8, "viewHolder.itemView");
        if (Float.compare(f4, obj11) < 0) {
            if (e03 instanceof b.a) {
            } else {
                obj9 = 0;
            }
            obj12 = 0;
            if (obj9 == null) {
                obj11 = obj12;
            } else {
            }
            if (obj11 != null) {
                obj9 = new o(this.h, this.i);
            } else {
                obj9 = new o(this.g, this.j);
            }
            obj9 = obj9.b();
            obj11 = new Rect();
            this.l.getTextBounds(obj9, obj12, (String)obj9.length(), obj11);
            canvas.drawRect(obj12 + f4, (float)obj12, (float)obj12, (float)obj12, (Paint)obj9.a());
            obj13 = 2;
            canvas.drawText(obj9, obj12 += obj10, obj10 += obj8, this.l);
        }
    }

    @Override // androidx.recyclerview.widget.l$i
    public boolean z(RecyclerView recyclerView, RecyclerView.e0 recyclerView$e02, RecyclerView.e0 recyclerView$e03) {
        n.f(recyclerView, "recyclerView");
        n.f(e02, "viewHolder");
        n.f(e03, "target");
        return 0;
    }
}
