package f.c.a.e.s;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

/* loaded from: classes2.dex */
public class a implements View.OnTouchListener {

    private final Dialog a;
    private final int b;
    private final int c;
    private final int v;
    public a(Dialog dialog, Rect rect2) {
        super();
        this.a = dialog;
        this.b = rect2.left;
        this.c = rect2.top;
        this.v = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View$OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent2) {
        int i;
        int obj7;
        View viewById = view.findViewById(16908290);
        i4 += left;
        i10 += top;
        RectF rectF = new RectF((float)i5, (float)i11, (float)i8, (float)i3);
        i = 0;
        if (rectF.contains(motionEvent2.getX(), motionEvent2.getY())) {
            return i;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent2);
        int i9 = 1;
        if (motionEvent2.getAction() == i9) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(i);
            obj7 = this.v;
            obtain.setLocation((float)i7, (float)obj7);
        }
        view.performClick();
        return this.a.onTouchEvent(obtain);
    }
}
