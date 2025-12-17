package com.google.firebase.inappmessaging.display.internal.bindingwrappers;

import android.graphics.Color;
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
import com.google.firebase.inappmessaging.display.internal.layout.BaseModalLayout;
import com.google.firebase.inappmessaging.display.internal.layout.FiamCardView;
import com.google.firebase.inappmessaging.model.Action;
import com.google.firebase.inappmessaging.model.CardMessage;
import com.google.firebase.inappmessaging.model.InAppMessage;
import com.google.firebase.inappmessaging.model.MessageType;
import com.google.firebase.inappmessaging.model.Text;
import java.util.Map;

/* loaded from: classes2.dex */
public class CardBindingWrapper extends com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper {

    private ScrollView bodyScroll;
    private BaseModalLayout cardContentRoot;
    private CardMessage cardMessage;
    private FiamCardView cardRoot;
    private View.OnClickListener dismissListener;
    private ImageView imageView;
    private ViewTreeObserver.OnGlobalLayoutListener layoutListener;
    private TextView messageBody;
    private TextView messageTitle;
    private Button primaryButton;
    private Button secondaryButton;

    public class ScrollViewAdjustableListener implements ViewTreeObserver.OnGlobalLayoutListener {

        final com.google.firebase.inappmessaging.display.internal.bindingwrappers.CardBindingWrapper this$0;
        public ScrollViewAdjustableListener(com.google.firebase.inappmessaging.display.internal.bindingwrappers.CardBindingWrapper cardBindingWrapper) {
            this.this$0 = cardBindingWrapper;
            super();
        }

        @Override // android.view.ViewTreeObserver$OnGlobalLayoutListener
        public void onGlobalLayout() {
            CardBindingWrapper.access$000(this.this$0).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }
    public CardBindingWrapper(InAppMessageLayoutConfig inAppMessageLayoutConfig, LayoutInflater layoutInflater2, InAppMessage inAppMessage3) {
        super(inAppMessageLayoutConfig, layoutInflater2, inAppMessage3);
        CardBindingWrapper.ScrollViewAdjustableListener obj1 = new CardBindingWrapper.ScrollViewAdjustableListener(this);
        this.layoutListener = obj1;
    }

    static ImageView access$000(com.google.firebase.inappmessaging.display.internal.bindingwrappers.CardBindingWrapper cardBindingWrapper) {
        return cardBindingWrapper.imageView;
    }

    private void setButtons(Map<Action, View.OnClickListener> map) {
        Object primaryButton;
        int secondaryButton;
        com.google.firebase.inappmessaging.model.Button button;
        Button obj5;
        Action primaryAction = this.cardMessage.getPrimaryAction();
        Action secondaryAction = this.cardMessage.getSecondaryAction();
        BindingWrapper.setupViewButtonFromModel(this.primaryButton, primaryAction.getButton());
        setButtonActionListener(this.primaryButton, (View.OnClickListener)map.get(primaryAction));
        int i = 0;
        this.primaryButton.setVisibility(i);
        if (secondaryAction != null && secondaryAction.getButton() != null) {
            if (secondaryAction.getButton() != null) {
                BindingWrapper.setupViewButtonFromModel(this.secondaryButton, secondaryAction.getButton());
                setButtonActionListener(this.secondaryButton, (View.OnClickListener)map.get(secondaryAction));
                this.secondaryButton.setVisibility(i);
            } else {
                this.secondaryButton.setVisibility(8);
            }
        } else {
        }
    }

    private void setDismissListener(View.OnClickListener view$OnClickListener) {
        this.dismissListener = onClickListener;
        this.cardRoot.setDismissListener(onClickListener);
    }

    private void setImage(CardMessage cardMessage) {
        int i;
        ImageView obj2;
        if (cardMessage.getPortraitImageData() == null) {
            if (cardMessage.getLandscapeImageData() != null) {
                this.imageView.setVisibility(0);
            } else {
                this.imageView.setVisibility(8);
            }
        } else {
        }
    }

    private void setLayoutConfig(InAppMessageLayoutConfig inAppMessageLayoutConfig) {
        this.imageView.setMaxHeight(inAppMessageLayoutConfig.getMaxImageHeight());
        this.imageView.setMaxWidth(inAppMessageLayoutConfig.getMaxImageWidth());
    }

    private void setMessage(CardMessage cardMessage) {
        Object body;
        int messageBody;
        int color;
        TextView obj3;
        this.messageTitle.setText(cardMessage.getTitle().getText());
        this.messageTitle.setTextColor(Color.parseColor(cardMessage.getTitle().getHexColor()));
        if (cardMessage.getBody() != null && cardMessage.getBody().getText() != null) {
            if (cardMessage.getBody().getText() != null) {
                int i = 0;
                this.bodyScroll.setVisibility(i);
                this.messageBody.setVisibility(i);
                this.messageBody.setText(cardMessage.getBody().getText());
                this.messageBody.setTextColor(Color.parseColor(cardMessage.getBody().getHexColor()));
            } else {
                messageBody = 8;
                this.bodyScroll.setVisibility(messageBody);
                this.messageBody.setVisibility(messageBody);
            }
        } else {
        }
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public InAppMessageLayoutConfig getConfig() {
        return this.config;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public View getDialogView() {
        return this.cardContentRoot;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public View.OnClickListener getDismissListener() {
        return this.dismissListener;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public ImageView getImageView() {
        return this.imageView;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public Button getPrimaryButton() {
        return this.primaryButton;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public ViewGroup getRootView() {
        return this.cardRoot;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public View getScrollView() {
        return this.bodyScroll;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public Button getSecondaryButton() {
        return this.secondaryButton;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public View getTitleView() {
        return this.messageTitle;
    }

    public ViewTreeObserver.OnGlobalLayoutListener inflate(Map<Action, View.OnClickListener> map, View.OnClickListener view$OnClickListener2) {
        boolean cardMessage;
        Object obj4;
        Object obj5;
        View inflate = this.inflater.inflate(R.layout.card, 0);
        this.bodyScroll = (ScrollView)inflate.findViewById(R.id.body_scroll);
        this.primaryButton = (Button)inflate.findViewById(R.id.primary_button);
        this.secondaryButton = (Button)inflate.findViewById(R.id.secondary_button);
        this.imageView = (ImageView)inflate.findViewById(R.id.image_view);
        this.messageBody = (TextView)inflate.findViewById(R.id.message_body);
        this.messageTitle = (TextView)inflate.findViewById(R.id.message_title);
        this.cardRoot = (FiamCardView)inflate.findViewById(R.id.card_root);
        this.cardContentRoot = (BaseModalLayout)inflate.findViewById(R.id.card_content_root);
        if (this.message.getMessageType().equals(MessageType.CARD)) {
            InAppMessage message2 = this.message;
            this.cardMessage = (CardMessage)message2;
            setMessage(message2);
            setImage(this.cardMessage);
            setButtons(map);
            setLayoutConfig(this.config);
            setDismissListener(onClickListener2);
            setViewBgColorFromHex(this.cardContentRoot, this.cardMessage.getBackgroundHexColor());
        }
        return this.layoutListener;
    }

    @Override // com.google.firebase.inappmessaging.display.internal.bindingwrappers.BindingWrapper
    public void setLayoutListener(ViewTreeObserver.OnGlobalLayoutListener viewTreeObserver$OnGlobalLayoutListener) {
        this.layoutListener = onGlobalLayoutListener;
    }
}
