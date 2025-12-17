package zendesk.support.request;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.b0;
import androidx.recyclerview.widget.RecyclerView.o;
import f.g.c.a;
import f.g.d.d;

/* loaded from: classes3.dex */
class CellMarginDecorator extends RecyclerView.o {

    public static final int CELL = 1;
    public static final int CELL_LAST = 16;
    public static final int CELL_START_BLOCK = 2;
    public static final int CELL_WITH_LABEL = 8;
    private final zendesk.support.request.ComponentRequestAdapter dataSource;
    private final int groupVerticalMargin;
    private final int verticalMargin;
    CellMarginDecorator(zendesk.support.request.ComponentRequestAdapter componentRequestAdapter, int i2, int i3) {
        super();
        this.dataSource = componentRequestAdapter;
        this.verticalMargin = i2;
        this.groupVerticalMargin = i3;
    }

    CellMarginDecorator(zendesk.support.request.ComponentRequestAdapter componentRequestAdapter, Context context2) {
        super();
        this.dataSource = componentRequestAdapter;
        this.verticalMargin = context2.getResources().getDimensionPixelOffset(d.r);
        this.groupVerticalMargin = context2.getResources().getDimensionPixelOffset(d.l);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$o
    public void getItemOffsets(Rect rect, View view2, RecyclerView recyclerView3, RecyclerView.b0 recyclerView$b04) {
        int str;
        int i;
        int i3;
        int i4;
        int i2;
        Rect obj11;
        int obj12;
        int obj13;
        obj11 = recyclerView3.g0(view2);
        if (obj11 == -1) {
        }
        obj11 = this.dataSource.getMessageForPos(obj11);
        obj12 = obj11.getPositionType();
        obj11 = obj11.getInsets();
        final int i7 = 0;
        final int i8 = 1;
        obj13 = obj12 & 2 == 2 ? i8 : i7;
        str = obj12 & 8 == 8 ? i8 : i7;
        i = obj12 & 16 == 16 ? i8 : i7;
        i3 = obj12 & 1 == i8 ? i8 : i7;
        i4 = -top;
        if (obj13 != null && str != null) {
            if (str != null) {
                obj12 = this.groupVerticalMargin;
                i4 += obj12;
                i2 += obj12;
            } else {
            }
        } else {
        }
        if (i != 0) {
            i2 = -obj11;
        }
        rect.set(-left, i4, -right, i2);
    }
}
