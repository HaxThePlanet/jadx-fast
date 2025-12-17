package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.firebase.inappmessaging.display.R.id;
import com.google.firebase.inappmessaging.display.R.layout;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.ResizableImageView;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope;
import com.google.firebase.inappmessaging.display.internal.layout.FiamFrameLayout;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.BannerMessage;
import com.google.firebase.inappmessaging.model.ImageData;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.Text;
import java.util.Map;

/* loaded from: classes2.dex */
public class BannerBindingWrapper extends com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper {

    private TextView bannerBody;
    private ViewGroup bannerContentRoot;
    private ResizableImageView bannerImage;
    private FiamFrameLayout bannerRoot;
    private TextView bannerTitle;
    private View.OnClickListener mDismissListener;
    public BannerBindingWrapper(InAppMessageLayoutConfig inAppMessageLayoutConfig, LayoutInflater layoutInflater2, InAppMessage inAppMessage3) {
        super(inAppMessageLayoutConfig, layoutInflater2, inAppMessage3);
    }

    private void setActionListener(View.OnClickListener view$OnClickListener) {
        this.bannerContentRoot.setOnClickListener(onClickListener);
    }

    private void setLayoutConfig(InAppMessageLayoutConfig inAppMessageLayoutConfig) {
        ViewGroup.LayoutParams layoutParams;
        int i;
        int i2;
        if (this.bannerRoot.getLayoutParams() == null) {
            layoutParams = new ViewGroup.LayoutParams(-1, -2);
        }
        layoutParams.width = Math.min(inAppMessageLayoutConfig.maxDialogWidthPx().intValue(), inAppMessageLayoutConfig.maxDialogHeightPx().intValue());
        this.bannerRoot.setLayoutParams(layoutParams);
        this.bannerImage.setMaxHeight(inAppMessageLayoutConfig.getMaxImageHeight());
        this.bannerImage.setMaxWidth(inAppMessageLayoutConfig.getMaxImageWidth());
    }

    private void setMessage(BannerMessage bannerMessage) {
        boolean bannerContentRoot;
        Text bannerTitle2;
        Text bannerBody;
        boolean bannerBody2;
        boolean bannerTitle;
        String backgroundHexColor;
        ImageData imageData;
        int color;
        int obj3;
        if (!TextUtils.isEmpty(bannerMessage.getBackgroundHexColor())) {
            setViewBgColorFromHex(this.bannerContentRoot, bannerMessage.getBackgroundHexColor());
        }
        if (bannerMessage.getImageData() != null) {
            if (TextUtils.isEmpty(bannerMessage.getImageData().getImageUrl())) {
                color = 8;
            } else {
                color = 0;
            }
        } else {
        }
        this.bannerImage.setVisibility(color);
        if (bannerMessage.getTitle() != null && !TextUtils.isEmpty(bannerMessage.getTitle().getText())) {
            if (!TextUtils.isEmpty(bannerMessage.getTitle().getText())) {
                this.bannerTitle.setText(bannerMessage.getTitle().getText());
            }
            if (!TextUtils.isEmpty(bannerMessage.getTitle().getHexColor())) {
                this.bannerTitle.setTextColor(Color.parseColor(bannerMessage.getTitle().getHexColor()));
            }
        }
        if (bannerMessage.getBody() != null && !TextUtils.isEmpty(bannerMessage.getBody().getText())) {
            if (!TextUtils.isEmpty(bannerMessage.getBody().getText())) {
                this.bannerBody.setText(bannerMessage.getBody().getText());
            }
            if (!TextUtils.isEmpty(bannerMessage.getBody().getHexColor())) {
                this.bannerBody.setTextColor(Color.parseColor(bannerMessage.getBody().getHexColor()));
            }
        }
    }

    private void setSwipeDismissListener(View.OnClickListener view$OnClickListener) {
        this.mDismissListener = onClickListener;
        this.bannerRoot.setDismissListener(onClickListener);
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public boolean canSwipeToDismiss() {
        return 1;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public InAppMessageLayoutConfig getConfig() {
        return this.config;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public View getDialogView() {
        return this.bannerContentRoot;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public View.OnClickListener getDismissListener() {
        return this.mDismissListener;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public ImageView getImageView() {
        return this.bannerImage;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public ViewGroup getRootView() {
        return this.bannerRoot;
    }

    public ViewTreeObserver.OnGlobalLayoutListener inflate(Map<Action, View.OnClickListener> map, View.OnClickListener view$OnClickListener2) {
        boolean message;
        Object bANNER;
        Object obj4;
        Object obj5;
        final int i = 0;
        View inflate = this.inflater.inflate(R.layout.banner, i);
        this.bannerRoot = (FiamFrameLayout)inflate.findViewById(R.id.banner_root);
        this.bannerContentRoot = (ViewGroup)inflate.findViewById(R.id.banner_content_root);
        this.bannerBody = (TextView)inflate.findViewById(R.id.banner_body);
        this.bannerImage = (ResizableImageView)inflate.findViewById(R.id.banner_image);
        this.bannerTitle = (TextView)inflate.findViewById(R.id.banner_title);
        if (this.message.getMessageType().equals(MessageType.BANNER)) {
            message = this.message;
            setMessage((BannerMessage)message);
            setLayoutConfig(this.config);
            setSwipeDismissListener(onClickListener2);
            setActionListener((View.OnClickListener)map.get(message.getAction()));
        }
        return i;
    }
}
