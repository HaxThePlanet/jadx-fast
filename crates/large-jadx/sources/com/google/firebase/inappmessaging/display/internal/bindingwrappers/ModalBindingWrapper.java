package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.firebase.inappmessaging.display.R.id;
import com.google.firebase.inappmessaging.display.R.layout;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.injection.scopes.InAppMessageScope;
import com.google.firebase.inappmessaging.display.internal.layout.FiamRelativeLayout;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.Button;
import com.google.firebase.inappmessaging.model.ImageData;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.ModalMessage;
import com.google.firebase.inappmessaging.model.Text;
import java.util.Map;

/* loaded from: classes2.dex */
public class ModalBindingWrapper extends com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper {

    private ScrollView bodyScroll;
    private Button button;
    private View collapseImage;
    private ImageView imageView;
    private ViewTreeObserver.OnGlobalLayoutListener layoutListener;
    private TextView messageBody;
    private TextView messageTitle;
    private ViewGroup modalContentRoot;
    private ModalMessage modalMessage;
    private FiamRelativeLayout modalRoot;

    public class ScrollViewAdjustableListener implements ViewTreeObserver.OnGlobalLayoutListener {

        final com.google.firebase.inappmessaging.display.internal.bindingwrappers.ModalBindingWrapper this$0;
        public ScrollViewAdjustableListener(com.google.firebase.inappmessaging.display.internal.bindingwrappers.ModalBindingWrapper modalBindingWrapper) {
            this.this$0 = modalBindingWrapper;
            super();
        }

        @Override // android.view.ViewTreeObserver$OnGlobalLayoutListener
        public void onGlobalLayout() {
            ModalBindingWrapper.access$000(this.this$0).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }
    public ModalBindingWrapper(InAppMessageLayoutConfig inAppMessageLayoutConfig, LayoutInflater layoutInflater2, InAppMessage inAppMessage3) {
        super(inAppMessageLayoutConfig, layoutInflater2, inAppMessage3);
        ModalBindingWrapper.ScrollViewAdjustableListener obj1 = new ModalBindingWrapper.ScrollViewAdjustableListener(this);
        this.layoutListener = obj1;
    }

    static ImageView access$000(com.google.firebase.inappmessaging.display.internal.bindingwrappers.ModalBindingWrapper modalBindingWrapper) {
        return modalBindingWrapper.imageView;
    }

    private void setButton(Map<Action, View.OnClickListener> map) {
        int i;
        Object button;
        Button obj3;
        Action action = this.modalMessage.getAction();
        if (action != null && action.getButton() != null && !TextUtils.isEmpty(action.getButton().getText().getText())) {
            if (action.getButton() != null) {
                if (!TextUtils.isEmpty(action.getButton().getText().getText())) {
                    BindingWrapper.setupViewButtonFromModel(this.button, action.getButton());
                    setButtonActionListener(this.button, (View.OnClickListener)map.get(this.modalMessage.getAction()));
                    this.button.setVisibility(0);
                } else {
                    this.button.setVisibility(8);
                }
            } else {
            }
        } else {
        }
    }

    private void setDismissListener(View.OnClickListener view$OnClickListener) {
        this.collapseImage.setOnClickListener(onClickListener);
        this.modalRoot.setDismissListener(onClickListener);
    }

    private void setLayoutConfig(InAppMessageLayoutConfig inAppMessageLayoutConfig) {
        this.imageView.setMaxHeight(inAppMessageLayoutConfig.getMaxImageHeight());
        this.imageView.setMaxWidth(inAppMessageLayoutConfig.getMaxImageWidth());
    }

    private void setMessage(ModalMessage modalMessage) {
        ImageData imageData;
        ImageView imageView;
        Text messageTitle2;
        Text messageBody;
        TextView messageTitle;
        int color;
        String color2;
        Object obj5;
        color = 0;
        final int i = 8;
        if (modalMessage.getImageData() != null) {
            if (TextUtils.isEmpty(modalMessage.getImageData().getImageUrl())) {
                this.imageView.setVisibility(i);
            } else {
                this.imageView.setVisibility(color);
            }
        } else {
        }
        if (modalMessage.getTitle() != null) {
            if (!TextUtils.isEmpty(modalMessage.getTitle().getText())) {
                this.messageTitle.setVisibility(color);
                this.messageTitle.setText(modalMessage.getTitle().getText());
            } else {
                this.messageTitle.setVisibility(i);
            }
            if (!TextUtils.isEmpty(modalMessage.getTitle().getHexColor())) {
                this.messageTitle.setTextColor(Color.parseColor(modalMessage.getTitle().getHexColor()));
            }
        }
        if (modalMessage.getBody() != null && !TextUtils.isEmpty(modalMessage.getBody().getText())) {
            if (!TextUtils.isEmpty(modalMessage.getBody().getText())) {
                this.bodyScroll.setVisibility(color);
                this.messageBody.setVisibility(color);
                this.messageBody.setTextColor(Color.parseColor(modalMessage.getBody().getHexColor()));
                this.messageBody.setText(modalMessage.getBody().getText());
            } else {
                this.bodyScroll.setVisibility(i);
                this.messageBody.setVisibility(i);
            }
        } else {
        }
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public Button getActionButton() {
        return this.button;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public View getCollapseButton() {
        return this.collapseImage;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public InAppMessageLayoutConfig getConfig() {
        return this.config;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public View getDialogView() {
        return this.modalContentRoot;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public ImageView getImageView() {
        return this.imageView;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public ViewGroup getRootView() {
        return this.modalRoot;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public View getScrollView() {
        return this.bodyScroll;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public View getTitleView() {
        return this.messageTitle;
    }

    public ViewTreeObserver.OnGlobalLayoutListener inflate(Map<Action, View.OnClickListener> map, View.OnClickListener view$OnClickListener2) {
        boolean message;
        Object obj4;
        Object obj5;
        View inflate = this.inflater.inflate(R.layout.modal, 0);
        this.bodyScroll = (ScrollView)inflate.findViewById(R.id.body_scroll);
        this.button = (Button)inflate.findViewById(R.id.button);
        this.collapseImage = inflate.findViewById(R.id.collapse_button);
        this.imageView = (ImageView)inflate.findViewById(R.id.image_view);
        this.messageBody = (TextView)inflate.findViewById(R.id.message_body);
        this.messageTitle = (TextView)inflate.findViewById(R.id.message_title);
        this.modalRoot = (FiamRelativeLayout)inflate.findViewById(R.id.modal_root);
        this.modalContentRoot = (ViewGroup)inflate.findViewById(R.id.modal_content_root);
        if (this.message.getMessageType().equals(MessageType.MODAL)) {
            message = this.message;
            this.modalMessage = (ModalMessage)message;
            setMessage(message);
            setButton(map);
            setLayoutConfig(this.config);
            setDismissListener(onClickListener2);
            setViewBgColorFromHex(this.modalContentRoot, this.modalMessage.getBackgroundHexColor());
        }
        return this.layoutListener;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public void setLayoutListener(ViewTreeObserver.OnGlobalLayoutListener viewTreeObserver$OnGlobalLayoutListener) {
        this.layoutListener = onGlobalLayoutListener;
    }
}
