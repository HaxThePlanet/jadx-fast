package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.google.firebase.inappmessaging.display.internal.layout.util.BackButtonHandler;

/* loaded from: classes2.dex */
public class FiamRelativeLayout extends RelativeLayout implements com.google.firebase.inappmessaging.display.internal.layout.BackButtonLayout {

    private BackButtonHandler mBackHandler;
    public FiamRelativeLayout(Context context) {
        super(context);
    }

    public FiamRelativeLayout(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
    }

    public FiamRelativeLayout(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
    }

    public FiamRelativeLayout(Context context, AttributeSet attributeSet2, int i3, int i4) {
        super(context, attributeSet2, i3, i4);
    }

    @Override // android.widget.RelativeLayout
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Boolean dispatchKeyEvent = this.mBackHandler.dispatchKeyEvent(keyEvent);
        if (dispatchKeyEvent != null) {
            return dispatchKeyEvent.booleanValue();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.widget.RelativeLayout
    public void setDismissListener(View.OnClickListener view$OnClickListener) {
        BackButtonHandler backButtonHandler = new BackButtonHandler(this, onClickListener);
        this.mBackHandler = backButtonHandler;
    }
}
