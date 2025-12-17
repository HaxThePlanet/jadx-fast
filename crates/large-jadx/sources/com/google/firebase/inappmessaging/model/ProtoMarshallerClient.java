package com.google.firebase.inappmessaging.model;

import android.text.TextUtils;
import com.google.common.base.n;
import com.google.firebase.inappmessaging.MessagesProto.Action;
import com.google.firebase.inappmessaging.MessagesProto.BannerMessage;
import com.google.firebase.inappmessaging.MessagesProto.Button;
import com.google.firebase.inappmessaging.MessagesProto.CardMessage;
import com.google.firebase.inappmessaging.MessagesProto.Content;
import com.google.firebase.inappmessaging.MessagesProto.Content.MessageDetailsCase;
import com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage;
import com.google.firebase.inappmessaging.MessagesProto.ModalMessage;
import com.google.firebase.inappmessaging.MessagesProto.Text;
import com.google.firebase.inappmessaging.internal.Logging;
import com.google.protobuf.z;
import java.util.Map;

/* loaded from: classes2.dex */
public class ProtoMarshallerClient {
    private static com.google.firebase.inappmessaging.model.Action.Builder decode(MessagesProto.Action messagesProto$Action) {
        String obj2;
        final com.google.firebase.inappmessaging.model.Action.Builder builder = Action.builder();
        if (!TextUtils.isEmpty(action.getActionUrl())) {
            builder.setActionUrl(action.getActionUrl());
        }
        return builder;
    }

    private static com.google.firebase.inappmessaging.model.Action decode(MessagesProto.Action messagesProto$Action, MessagesProto.Button messagesProto$Button2) {
        boolean builder2;
        boolean builder;
        boolean buttonHexColor;
        boolean empty;
        boolean empty2;
        Object obj4;
        com.google.firebase.inappmessaging.model.Action.Builder obj3 = ProtoMarshallerClient.decode(action);
        builder2 = Button.builder();
        if (!button2.equals(MessagesProto.Button.getDefaultInstance()) && !TextUtils.isEmpty(button2.getButtonHexColor())) {
            builder2 = Button.builder();
            if (!TextUtils.isEmpty(button2.getButtonHexColor())) {
                builder2.setButtonHexColor(button2.getButtonHexColor());
            }
            builder = Text.builder();
            obj4 = button2.getText();
            if (button2.hasText() && !TextUtils.isEmpty(obj4.getText())) {
                builder = Text.builder();
                obj4 = button2.getText();
                if (!TextUtils.isEmpty(obj4.getText())) {
                    builder.setText(obj4.getText());
                }
                if (!TextUtils.isEmpty(obj4.getHexColor())) {
                    builder.setHexColor(obj4.getHexColor());
                }
                builder2.setText(builder.build());
            }
            obj3.setButton(builder2.build());
        }
        return obj3.build();
    }

    private static com.google.firebase.inappmessaging.model.Button decode(MessagesProto.Button messagesProto$Button) {
        boolean buttonHexColor;
        com.google.firebase.inappmessaging.model.Text obj2;
        final com.google.firebase.inappmessaging.model.Button.Builder builder = Button.builder();
        if (!TextUtils.isEmpty(button.getButtonHexColor())) {
            builder.setButtonHexColor(button.getButtonHexColor());
        }
        if (button.hasText()) {
            builder.setText(ProtoMarshallerClient.decode(button.getText()));
        }
        return builder.build();
    }

    public static com.google.firebase.inappmessaging.model.InAppMessage decode(MessagesProto.Content messagesProto$Content, String string2, String string3, boolean z4, Map<String, String> map5) {
        n.p(content, "FirebaseInAppMessaging content cannot be null.");
        n.p(string2, "FirebaseInAppMessaging campaign id cannot be null.");
        n.p(string3, "FirebaseInAppMessaging campaign name cannot be null.");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Decoding message: ");
        stringBuilder.append(content.toString());
        Logging.logd(stringBuilder.toString());
        CampaignMetadata campaignMetadata = new CampaignMetadata(string2, string3, z4);
        int i = ProtoMarshallerClient.2.$SwitchMap$com$google$firebase$inappmessaging$MessagesProto$Content$MessageDetailsCase[content.getMessageDetailsCase().ordinal()];
        if (i != 1 && i != 2 && i != 3 && i != 4) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        CampaignMetadata campaignMetadata2 = new CampaignMetadata(string2, string3, z4);
                        ProtoMarshallerClient.1 obj3 = new ProtoMarshallerClient.1(campaignMetadata2, MessageType.UNSUPPORTED, map5);
                        return obj3;
                    }
                    return ProtoMarshallerClient.from(content.getCard()).build(campaignMetadata, map5);
                }
                return ProtoMarshallerClient.from(content.getModal()).build(campaignMetadata, map5);
            }
            return ProtoMarshallerClient.from(content.getImageOnly()).build(campaignMetadata, map5);
        }
        return ProtoMarshallerClient.from(content.getBanner()).build(campaignMetadata, map5);
    }

    private static com.google.firebase.inappmessaging.model.Text decode(MessagesProto.Text messagesProto$Text) {
        boolean hexColor;
        String obj2;
        final com.google.firebase.inappmessaging.model.Text.Builder builder = Text.builder();
        if (!TextUtils.isEmpty(text.getHexColor())) {
            builder.setHexColor(text.getHexColor());
        }
        if (!TextUtils.isEmpty(text.getText())) {
            builder.setText(text.getText());
        }
        return builder.build();
    }

    private static com.google.firebase.inappmessaging.model.BannerMessage.Builder from(MessagesProto.BannerMessage messagesProto$BannerMessage) {
        boolean backgroundHexColor;
        boolean empty;
        boolean action;
        boolean decode;
        String imageUrl;
        com.google.firebase.inappmessaging.model.Text obj3;
        final com.google.firebase.inappmessaging.model.BannerMessage.Builder builder = BannerMessage.builder();
        if (!TextUtils.isEmpty(bannerMessage.getBackgroundHexColor())) {
            builder.setBackgroundHexColor(bannerMessage.getBackgroundHexColor());
        }
        if (!TextUtils.isEmpty(bannerMessage.getImageUrl())) {
            builder.setImageData(ImageData.builder().setImageUrl(bannerMessage.getImageUrl()).build());
        }
        if (bannerMessage.hasAction()) {
            builder.setAction(ProtoMarshallerClient.decode(bannerMessage.getAction()).build());
        }
        if (bannerMessage.hasBody()) {
            builder.setBody(ProtoMarshallerClient.decode(bannerMessage.getBody()));
        }
        if (bannerMessage.hasTitle()) {
            builder.setTitle(ProtoMarshallerClient.decode(bannerMessage.getTitle()));
        }
        return builder;
    }

    private static com.google.firebase.inappmessaging.model.CardMessage.Builder from(MessagesProto.CardMessage messagesProto$CardMessage) {
        boolean decode2;
        boolean decode;
        boolean backgroundHexColor;
        boolean primaryActionButton;
        boolean secondaryActionButton;
        boolean empty;
        boolean builder;
        MessagesProto.Button secondaryActionButton2;
        com.google.firebase.inappmessaging.model.ImageData obj3;
        final com.google.firebase.inappmessaging.model.CardMessage.Builder builder2 = CardMessage.builder();
        if (cardMessage.hasTitle()) {
            builder2.setTitle(ProtoMarshallerClient.decode(cardMessage.getTitle()));
        }
        if (cardMessage.hasBody()) {
            builder2.setBody(ProtoMarshallerClient.decode(cardMessage.getBody()));
        }
        if (!TextUtils.isEmpty(cardMessage.getBackgroundHexColor())) {
            builder2.setBackgroundHexColor(cardMessage.getBackgroundHexColor());
        }
        if (!cardMessage.hasPrimaryAction()) {
            if (cardMessage.hasPrimaryActionButton()) {
                builder2.setPrimaryAction(ProtoMarshallerClient.decode(cardMessage.getPrimaryAction(), cardMessage.getPrimaryActionButton()));
            }
        } else {
        }
        if (!cardMessage.hasSecondaryAction()) {
            if (cardMessage.hasSecondaryActionButton()) {
                builder2.setSecondaryAction(ProtoMarshallerClient.decode(cardMessage.getSecondaryAction(), cardMessage.getSecondaryActionButton()));
            }
        } else {
        }
        if (!TextUtils.isEmpty(cardMessage.getPortraitImageUrl())) {
            builder2.setPortraitImageData(ImageData.builder().setImageUrl(cardMessage.getPortraitImageUrl()).build());
        }
        if (!TextUtils.isEmpty(cardMessage.getLandscapeImageUrl())) {
            builder2.setLandscapeImageData(ImageData.builder().setImageUrl(cardMessage.getLandscapeImageUrl()).build());
        }
        return builder2;
    }

    private static com.google.firebase.inappmessaging.model.ImageOnlyMessage.Builder from(MessagesProto.ImageOnlyMessage messagesProto$ImageOnlyMessage) {
        boolean empty;
        String imageUrl;
        com.google.firebase.inappmessaging.model.Action obj3;
        final com.google.firebase.inappmessaging.model.ImageOnlyMessage.Builder builder = ImageOnlyMessage.builder();
        if (!TextUtils.isEmpty(imageOnlyMessage.getImageUrl())) {
            builder.setImageData(ImageData.builder().setImageUrl(imageOnlyMessage.getImageUrl()).build());
        }
        if (imageOnlyMessage.hasAction()) {
            builder.setAction(ProtoMarshallerClient.decode(imageOnlyMessage.getAction()).build());
        }
        return builder;
    }

    private static com.google.firebase.inappmessaging.model.ModalMessage.Builder from(MessagesProto.ModalMessage messagesProto$ModalMessage) {
        boolean backgroundHexColor;
        boolean empty;
        boolean action;
        boolean decode;
        String actionButton;
        com.google.firebase.inappmessaging.model.Text obj3;
        final com.google.firebase.inappmessaging.model.ModalMessage.Builder builder = ModalMessage.builder();
        if (!TextUtils.isEmpty(modalMessage.getBackgroundHexColor())) {
            builder.setBackgroundHexColor(modalMessage.getBackgroundHexColor());
        }
        if (!TextUtils.isEmpty(modalMessage.getImageUrl())) {
            builder.setImageData(ImageData.builder().setImageUrl(modalMessage.getImageUrl()).build());
        }
        if (modalMessage.hasAction()) {
            builder.setAction(ProtoMarshallerClient.decode(modalMessage.getAction(), modalMessage.getActionButton()));
        }
        if (modalMessage.hasBody()) {
            builder.setBody(ProtoMarshallerClient.decode(modalMessage.getBody()));
        }
        if (modalMessage.hasTitle()) {
            builder.setTitle(ProtoMarshallerClient.decode(modalMessage.getTitle()));
        }
        return builder;
    }
}
