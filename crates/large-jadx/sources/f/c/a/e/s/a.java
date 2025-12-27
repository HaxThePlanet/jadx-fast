package f.c.a.e.s;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;

/* compiled from: InsetDialogOnTouchListener.java */
/* loaded from: classes2.dex */
public class a implements View.OnTouchListener {

    private final Dialog a;
    private final int b;
    private final int c;
    private final int v;
    public a(Dialog dialog, Rect rect) {
        super();
        this.a = dialog;
        this.b = rect.left;
        this.c = rect.top;
        this.v = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View$OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View viewById = view.findViewById(16908290);
        int i5 = this.b + viewById.getLeft();
        int i11 = this.c + viewById.getTop();
        int i = 0;
        if (new RectF((float)i5, (float)i11, (float)(viewById.getWidth() + i5), (float)(viewById.getHeight() + i11)).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int i9 = 1;
        if (motionEvent.getAction() == i9) {
            int action = 4;
            obtain.setAction(action);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(i);
            obtain.setLocation((float)(-i13 - i9), (float)(-i13 - i9));
        }
        view.performClick();
        return this.a.onTouchEvent(obtain);
    }
}
