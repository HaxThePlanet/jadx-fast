package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.ImageView;
import androidx.core.graphics.drawable.a;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.Logging;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.Button;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.Text;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class BindingWrapper {

    final InAppMessageLayoutConfig config;
    final LayoutInflater inflater;
    protected final InAppMessage message;
    protected BindingWrapper(InAppMessageLayoutConfig inAppMessageLayoutConfig, LayoutInflater layoutInflater2, InAppMessage inAppMessage3) {
        super();
        this.config = inAppMessageLayoutConfig;
        this.inflater = layoutInflater2;
        this.message = inAppMessage3;
    }

    public static void setButtonBgColorFromHex(Button button, String string2) {
        android.graphics.drawable.Drawable drawable;
        Throwable obj1;
        int obj2;
        try {
            drawable = a.r(button.getBackground());
            a.n(drawable, Color.parseColor(string2));
            button.setBackground(drawable);
            string2 = new StringBuilder();
            string2.append("Error parsing background color: ");
            button = button.toString();
            string2.append(button);
            button = string2.toString();
            Logging.loge(button);
        }
    }

    public static void setupViewButtonFromModel(Button button, Button button2) {
        BindingWrapper.setButtonBgColorFromHex(button, button2.getButtonHexColor());
        button.setText(button2.getText().getText());
        button.setTextColor(Color.parseColor(button2.getText().getHexColor()));
    }

    public boolean canSwipeToDismiss() {
        return 0;
    }

    public InAppMessageLayoutConfig getConfig() {
        return this.config;
    }

    public abstract View getDialogView();

    public View.OnClickListener getDismissListener() {
        return null;
    }

    public abstract ImageView getImageView();

    public abstract ViewGroup getRootView();

    public abstract ViewTreeObserver.OnGlobalLayoutListener inflate(Map<Action, View.OnClickListener> map, View.OnClickListener view$OnClickListener2);

    protected void setButtonActionListener(Button button, View.OnClickListener view$OnClickListener2) {
        if (button != null) {
            button.setOnClickListener(onClickListener2);
        }
    }

    protected void setViewBgColorFromHex(View view, String string2) {
        StringBuilder stringBuilder;
        String str;
        Throwable obj3;
        if (view != null) {
            if (TextUtils.isEmpty(string2)) {
            } else {
                view.setBackgroundColor(Color.parseColor(string2));
            }
        }
    }
}
