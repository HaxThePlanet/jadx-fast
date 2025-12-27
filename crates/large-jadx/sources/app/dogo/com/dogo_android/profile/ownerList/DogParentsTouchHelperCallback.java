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

/* compiled from: DogParentsTouchHelperCallback.kt */
@Metadata(d1 = "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0008\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0005\n\u0002\u0010\u0007\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000b\n\u0002\u0008\u0004\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00126\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\n\u0012\u0004\u0012\u00020\u000b0\u0005¢\u0006\u0002\u0010\u000cJ@\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020#H\u0016J \u0010$\u001a\u00020#2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u001eH\u0016J\u0018\u0010&\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\n\u001a\u00020\u0006H\u0016R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000RA\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\t\u0012\u0013\u0012\u00110\u0006¢\u0006\u000c\u0008\u0007\u0012\u0008\u0008\u0008\u0012\u0004\u0008\u0008(\n\u0012\u0004\u0012\u00020\u000b0\u0005¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'", d2 = {"Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsTouchHelperCallback;", "Landroidx/recyclerview/widget/ItemTouchHelper$SimpleCallback;", "context", "Landroid/content/Context;", "onSwipe", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "position", "swipeDir", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function2;)V", "creatorBackground", "Landroid/graphics/Paint;", "deleteText", "", "getOnSwipe", "()Lkotlin/jvm/functions/Function2;", "paintText", "parentBackground", "textMargin", "", "youText", "onChildDraw", "canvas", "Landroid/graphics/Canvas;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "dX", "dY", "actionState", "isCurrentlyActive", "", "onMove", "target", "onSwiped", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: e, reason: from kotlin metadata */
public final class DogParentsTouchHelperCallback extends l.i {

    /* renamed from: f, reason: from kotlin metadata */
    private final p<Integer, Integer, w> creatorBackground;
    /* renamed from: g, reason: from kotlin metadata */
    private final Paint deleteText = new Paint();
    private final Paint h = new Paint();
    /* renamed from: i, reason: from kotlin metadata */
    private final String paintText;
    /* renamed from: j, reason: from kotlin metadata */
    private final String parentBackground;
    /* renamed from: k, reason: from kotlin metadata */
    private final float textMargin;
    /* renamed from: l, reason: from kotlin metadata */
    private final Paint youText = new Paint();
    public e(Context context, p<? super Integer, ? super Integer, w> pVar) throws android.content.res.Resources.NotFoundException {
        n.f(context, "context");
        n.f(pVar, "onSwipe");
        super(0, 4);
        this.creatorBackground = pVar;
        new Paint().setColor(-65536);
        new Paint().setColor(-12303292);
        String string = context.getResources().getString(2131886715);
        n.e(string, "context.resources.getString(R.string.general_you)");
        String str6 = string.toUpperCase();
        String str4 = "(this as java.lang.String).toUpperCase()";
        n.e(str6, str4);
        this.paintText = str6;
        String string2 = context.getResources().getString(2131886681);
        n.e(string2, "context.resources.getString(R.string.general_delete)");
        String str7 = string2.toUpperCase();
        n.e(str7, str4);
        this.parentBackground = str7;
        int i5 = 2131165620;
        this.textMargin = context.getResources().getDimension(i5);
        Paint paint3 = new Paint();
        paint3.setColor(-1);
        paint3.setTextSize(context.getResources().getDimension(i5));
        paint3.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
    }

    @Override // androidx.recyclerview.widget.l$i
    /* renamed from: C, reason: from kotlin metadata */
    public void onSwiped(RecyclerView.e0 viewHolder, int swipeDir) {
        n.f(viewHolder, "viewHolder");
        this.creatorBackground.invoke(Integer.valueOf(viewHolder.getAdapterPosition()), Integer.valueOf(swipeDir));
    }

    @Override // androidx.recyclerview.widget.l$i
    /* renamed from: v, reason: from kotlin metadata */
    public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.e0 viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        int i = 0;
        o pair;
        int actionState2 = 1;
        n.f(canvas, "canvas");
        n.f(recyclerView, "recyclerView");
        str = "viewHolder";
        n.f(viewHolder, str);
        super.v(canvas, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
        n.e(viewHolder.itemView, "viewHolder.itemView");
        if (dX < 0) {
            viewHolder = viewHolder instanceof DogParentsAdapter_DefaultViewHolder ? (DogParentsAdapter_DefaultViewHolder)viewHolder : 0;
            actionState2 = 1;
            actionState2 = 0;
            dY = actionState2;
            if ("viewHolder.itemView" != 0) {
                pair = new Pair(this.h, this.paintText);
            } else {
                pair = new Pair(this.deleteText, this.parentBackground);
            }
            Object obj = pair.b();
            Rect rect = new Rect();
            this.youText.getTextBounds(obj, actionState2, obj.length(), rect);
            f = (float)viewHolder.itemView.getRight() + dX;
            f2 = (float)viewHolder.itemView.getTop();
            f3 = (float)viewHolder.itemView.getRight();
            f4 = (float)viewHolder.itemView.getBottom();
            canvas.drawRect(f, f2, f3, f4, (Paint)pair.a());
            f6 = (float)viewHolder.itemView.getRight() + dX + this.textMargin;
            int i2 = 2;
            f5 = (float)viewHolder.itemView.getTop() + (float)rect.height() / (float)i2 + (float)(viewHolder.itemView.getHeight() / i2);
            canvas.drawText(obj, f6, f5, this.youText);
        }
    }

    @Override // androidx.recyclerview.widget.l$i
    /* renamed from: z, reason: from kotlin metadata */
    public boolean onMove(RecyclerView recyclerView, RecyclerView.e0 viewHolder, RecyclerView.e0 target) {
        n.f(recyclerView, "recyclerView");
        n.f(viewHolder, "viewHolder");
        n.f(target, "target");
        return false;
    }
}
