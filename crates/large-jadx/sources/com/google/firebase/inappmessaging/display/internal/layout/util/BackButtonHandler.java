package com.google.firebase.inappmessaging.display.internal.layout.util;

import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

/* loaded from: classes2.dex */
public class BackButtonHandler {

    private View.OnClickListener listener;
    private ViewGroup viewGroup;
    public BackButtonHandler(ViewGroup viewGroup, View.OnClickListener view$OnClickListener2) {
        super();
        this.viewGroup = viewGroup;
        this.listener = onClickListener2;
    }

    public Boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode;
        int i;
        int obj3;
        obj3 = this.listener;
        if (keyEvent != 0 && keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 1 && obj3 != null) {
            if (keyEvent.getKeyCode() == 4) {
                if (keyEvent.getAction() == 1) {
                    obj3 = this.listener;
                    if (obj3 != null) {
                        obj3.onClick(this.viewGroup);
                        return Boolean.TRUE;
                    }
                    return Boolean.FALSE;
                }
            }
        }
        return null;
    }
}
