package com.google.firebase.inappmessaging.display.internal.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import androidx.cardview.widget.CardView;
import com.google.firebase.inappmessaging.display.internal.layout.util.BackButtonHandler;

/* loaded from: classes2.dex */
public class FiamCardView extends CardView implements com.google.firebase.inappmessaging.display.internal.layout.BackButtonLayout {

    private BackButtonHandler mBackHandler;
    public FiamCardView(Context context) {
        super(context);
    }

    public FiamCardView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
    }

    public FiamCardView(Context context, AttributeSet attributeSet2, int i3) {
        super(context, attributeSet2, i3);
    }

    @Override // androidx.cardview.widget.CardView
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Boolean dispatchKeyEvent = this.mBackHandler.dispatchKeyEvent(keyEvent);
        if (dispatchKeyEvent != null) {
            return dispatchKeyEvent.booleanValue();
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // androidx.cardview.widget.CardView
    public void setDismissListener(View.OnClickListener view$OnClickListener) {
        BackButtonHandler backButtonHandler = new BackButtonHandler(this, onClickListener);
        this.mBackHandler = backButtonHandler;
    }
}
