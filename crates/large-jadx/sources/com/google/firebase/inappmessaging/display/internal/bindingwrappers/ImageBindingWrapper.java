package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.ImageView;
import com.google.firebase.inappmessaging.display.R.id;
import com.google.firebase.inappmessaging.display.R.layout;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope;
import com.google.firebase.inappmessaging.display.internal.layout.FiamFrameLayout;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.ImageData;
import com.google.firebase.inappmessaging.model.ImageOnlyMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import java.util.Map;

/* loaded from: classes2.dex */
public class ImageBindingWrapper extends com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper {

    private Button collapseButton;
    private ViewGroup imageContentRoot;
    private FiamFrameLayout imageRoot;
    private ImageView imageView;
    public ImageBindingWrapper(InAppMessageLayoutConfig inAppMessageLayoutConfig, LayoutInflater layoutInflater2, InAppMessage inAppMessage3) {
        super(inAppMessageLayoutConfig, layoutInflater2, inAppMessage3);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public View getCollapseButton() {
        return this.collapseButton;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public View getDialogView() {
        return this.imageContentRoot;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public ImageView getImageView() {
        return this.imageView;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public ViewGroup getRootView() {
        return this.imageRoot;
    }

    public ViewTreeObserver.OnGlobalLayoutListener inflate(Map<Action, View.OnClickListener> map, View.OnClickListener view$OnClickListener2) {
        boolean equals;
        Object iMAGE_ONLY;
        int i;
        ImageData imageData;
        Object obj5;
        final int i2 = 0;
        View inflate = this.inflater.inflate(R.layout.image, i2);
        this.imageRoot = (FiamFrameLayout)inflate.findViewById(R.id.image_root);
        this.imageContentRoot = (ViewGroup)inflate.findViewById(R.id.image_content_root);
        this.imageView = (ImageView)inflate.findViewById(R.id.image_view);
        this.collapseButton = (Button)inflate.findViewById(R.id.collapse_button);
        this.imageView.setMaxHeight(this.config.getMaxImageHeight());
        this.imageView.setMaxWidth(this.config.getMaxImageWidth());
        if (this.message.getMessageType().equals(MessageType.IMAGE_ONLY)) {
            InAppMessage message2 = this.message;
            if ((ImageOnlyMessage)message2.getImageData() != null) {
                if (TextUtils.isEmpty(message2.getImageData().getImageUrl())) {
                    i = 8;
                } else {
                    i = 0;
                }
            } else {
            }
            this.imageView.setVisibility(i);
            this.imageView.setOnClickListener((View.OnClickListener)map.get(message2.getAction()));
        }
        this.imageRoot.setDismissListener(onClickListener2);
        this.collapseButton.setOnClickListener(onClickListener2);
        return i2;
    }
}
