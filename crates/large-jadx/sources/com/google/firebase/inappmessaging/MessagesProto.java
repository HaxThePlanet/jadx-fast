package com.google.firebase.inappmessaging;

import android.accounts.Account;
import com.google.protobuf.a;
import com.google.protobuf.d1;
import com.google.protobuf.j;
import com.google.protobuf.k;
import com.google.protobuf.q;
import com.google.protobuf.t0;
import com.google.protobuf.u0;
import com.google.protobuf.z;
import com.google.protobuf.z.a;
import com.google.protobuf.z.b;
import com.google.protobuf.z.f;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public final class MessagesProto {

    public interface ActionOrBuilder extends u0 {
        @Override // com.google.protobuf.u0
        public abstract String getActionUrl();

        @Override // com.google.protobuf.u0
        public abstract j getActionUrlBytes();

        @Override // com.google.protobuf.u0
        public abstract t0 getDefaultInstanceForType();

        @Override // com.google.protobuf.u0
        public abstract boolean isInitialized();
    }

    public interface BannerMessageOrBuilder extends u0 {
        @Override // com.google.protobuf.u0
        public abstract com.google.firebase.inappmessaging.MessagesProto.Action getAction();

        @Override // com.google.protobuf.u0
        public abstract String getBackgroundHexColor();

        @Override // com.google.protobuf.u0
        public abstract j getBackgroundHexColorBytes();

        @Override // com.google.protobuf.u0
        public abstract com.google.firebase.inappmessaging.MessagesProto.Text getBody();

        @Override // com.google.protobuf.u0
        public abstract t0 getDefaultInstanceForType();

        @Override // com.google.protobuf.u0
        public abstract String getImageUrl();

        @Override // com.google.protobuf.u0
        public abstract j getImageUrlBytes();

        @Override // com.google.protobuf.u0
        public abstract com.google.firebase.inappmessaging.MessagesProto.Text getTitle();

        @Override // com.google.protobuf.u0
        public abstract boolean hasAction();

        @Override // com.google.protobuf.u0
        public abstract boolean hasBody();

        @Override // com.google.protobuf.u0
        public abstract boolean hasTitle();

        @Override // com.google.protobuf.u0
        public abstract boolean isInitialized();
    }

    public interface ButtonOrBuilder extends u0 {
        @Override // com.google.protobuf.u0
        public abstract String getButtonHexColor();

        @Override // com.google.protobuf.u0
        public abstract j getButtonHexColorBytes();

        @Override // com.google.protobuf.u0
        public abstract t0 getDefaultInstanceForType();

        @Override // com.google.protobuf.u0
        public abstract com.google.firebase.inappmessaging.MessagesProto.Text getText();

        @Override // com.google.protobuf.u0
        public abstract boolean hasText();

        @Override // com.google.protobuf.u0
        public abstract boolean isInitialized();
    }

    public interface CardMessageOrBuilder extends u0 {
        @Override // com.google.protobuf.u0
        public abstract String getBackgroundHexColor();

        @Override // com.google.protobuf.u0
        public abstract j getBackgroundHexColorBytes();

        @Override // com.google.protobuf.u0
        public abstract com.google.firebase.inappmessaging.MessagesProto.Text getBody();

        @Override // com.google.protobuf.u0
        public abstract t0 getDefaultInstanceForType();

        @Override // com.google.protobuf.u0
        public abstract String getLandscapeImageUrl();

        @Override // com.google.protobuf.u0
        public abstract j getLandscapeImageUrlBytes();

        @Override // com.google.protobuf.u0
        public abstract String getPortraitImageUrl();

        @Override // com.google.protobuf.u0
        public abstract j getPortraitImageUrlBytes();

        @Override // com.google.protobuf.u0
        public abstract com.google.firebase.inappmessaging.MessagesProto.Action getPrimaryAction();

        @Override // com.google.protobuf.u0
        public abstract com.google.firebase.inappmessaging.MessagesProto.Button getPrimaryActionButton();

        @Override // com.google.protobuf.u0
        public abstract com.google.firebase.inappmessaging.MessagesProto.Action getSecondaryAction();

        @Override // com.google.protobuf.u0
        public abstract com.google.firebase.inappmessaging.MessagesProto.Button getSecondaryActionButton();

        @Override // com.google.protobuf.u0
        public abstract com.google.firebase.inappmessaging.MessagesProto.Text getTitle();

        @Override // com.google.protobuf.u0
        public abstract boolean hasBody();

        @Override // com.google.protobuf.u0
        public abstract boolean hasPrimaryAction();

        @Override // com.google.protobuf.u0
        public abstract boolean hasPrimaryActionButton();

        @Override // com.google.protobuf.u0
        public abstract boolean hasSecondaryAction();

        @Override // com.google.protobuf.u0
        public abstract boolean hasSecondaryActionButton();

        @Override // com.google.protobuf.u0
        public abstract boolean hasTitle();

        @Override // com.google.protobuf.u0
        public abstract boolean isInitialized();
    }

    public interface ContentOrBuilder extends u0 {
        @Override // com.google.protobuf.u0
        public abstract com.google.firebase.inappmessaging.MessagesProto.BannerMessage getBanner();

        @Override // com.google.protobuf.u0
        public abstract com.google.firebase.inappmessaging.MessagesProto.CardMessage getCard();

        @Override // com.google.protobuf.u0
        public abstract t0 getDefaultInstanceForType();

        @Override // com.google.protobuf.u0
        public abstract com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage getImageOnly();

        @Override // com.google.protobuf.u0
        public abstract com.google.firebase.inappmessaging.MessagesProto.Content.MessageDetailsCase getMessageDetailsCase();

        @Override // com.google.protobuf.u0
        public abstract com.google.firebase.inappmessaging.MessagesProto.ModalMessage getModal();

        @Override // com.google.protobuf.u0
        public abstract boolean hasBanner();

        @Override // com.google.protobuf.u0
        public abstract boolean hasCard();

        @Override // com.google.protobuf.u0
        public abstract boolean hasImageOnly();

        @Override // com.google.protobuf.u0
        public abstract boolean hasModal();

        @Override // com.google.protobuf.u0
        public abstract boolean isInitialized();
    }

    public interface ImageOnlyMessageOrBuilder extends u0 {
        @Override // com.google.protobuf.u0
        public abstract com.google.firebase.inappmessaging.MessagesProto.Action getAction();

        @Override // com.google.protobuf.u0
        public abstract t0 getDefaultInstanceForType();

        @Override // com.google.protobuf.u0
        public abstract String getImageUrl();

        @Override // com.google.protobuf.u0
        public abstract j getImageUrlBytes();

        @Override // com.google.protobuf.u0
        public abstract boolean hasAction();

        @Override // com.google.protobuf.u0
        public abstract boolean isInitialized();
    }

    public interface ModalMessageOrBuilder extends u0 {
        @Override // com.google.protobuf.u0
        public abstract com.google.firebase.inappmessaging.MessagesProto.Action getAction();

        @Override // com.google.protobuf.u0
        public abstract com.google.firebase.inappmessaging.MessagesProto.Button getActionButton();

        @Override // com.google.protobuf.u0
        public abstract String getBackgroundHexColor();

        @Override // com.google.protobuf.u0
        public abstract j getBackgroundHexColorBytes();

        @Override // com.google.protobuf.u0
        public abstract com.google.firebase.inappmessaging.MessagesProto.Text getBody();

        @Override // com.google.protobuf.u0
        public abstract t0 getDefaultInstanceForType();

        @Override // com.google.protobuf.u0
        public abstract String getImageUrl();

        @Override // com.google.protobuf.u0
        public abstract j getImageUrlBytes();

        @Override // com.google.protobuf.u0
        public abstract com.google.firebase.inappmessaging.MessagesProto.Text getTitle();

        @Override // com.google.protobuf.u0
        public abstract boolean hasAction();

        @Override // com.google.protobuf.u0
        public abstract boolean hasActionButton();

        @Override // com.google.protobuf.u0
        public abstract boolean hasBody();

        @Override // com.google.protobuf.u0
        public abstract boolean hasTitle();

        @Override // com.google.protobuf.u0
        public abstract boolean isInitialized();
    }

    public interface TextOrBuilder extends u0 {
        @Override // com.google.protobuf.u0
        public abstract t0 getDefaultInstanceForType();

        @Override // com.google.protobuf.u0
        public abstract String getHexColor();

        @Override // com.google.protobuf.u0
        public abstract j getHexColorBytes();

        @Override // com.google.protobuf.u0
        public abstract String getText();

        @Override // com.google.protobuf.u0
        public abstract j getTextBytes();

        @Override // com.google.protobuf.u0
        public abstract boolean isInitialized();
    }

    public static final class Action extends z<com.google.firebase.inappmessaging.MessagesProto.Action, com.google.firebase.inappmessaging.MessagesProto.Action.Builder> implements com.google.firebase.inappmessaging.MessagesProto.ActionOrBuilder {

        public static final int ACTION_URL_FIELD_NUMBER = 1;
        private static final com.google.firebase.inappmessaging.MessagesProto.Action DEFAULT_INSTANCE;
        private static volatile d1<com.google.firebase.inappmessaging.MessagesProto.Action> PARSER;
        private String actionUrl_;
        static {
            MessagesProto.Action action = new MessagesProto.Action();
            MessagesProto.Action.DEFAULT_INSTANCE = action;
            z.registerDefaultInstance(MessagesProto.Action.class, action);
        }

        private Action() {
            super();
            this.actionUrl_ = "";
        }

        static com.google.firebase.inappmessaging.MessagesProto.Action access$10500() {
            return MessagesProto.Action.DEFAULT_INSTANCE;
        }

        static void access$10600(com.google.firebase.inappmessaging.MessagesProto.Action messagesProto$Action, String string2) {
            action.setActionUrl(string2);
        }

        static void access$10700(com.google.firebase.inappmessaging.MessagesProto.Action messagesProto$Action) {
            action.clearActionUrl();
        }

        static void access$10800(com.google.firebase.inappmessaging.MessagesProto.Action messagesProto$Action, j j2) {
            action.setActionUrlBytes(j2);
        }

        private void clearActionUrl() {
            this.actionUrl_ = MessagesProto.Action.getDefaultInstance().getActionUrl();
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Action getDefaultInstance() {
            return MessagesProto.Action.DEFAULT_INSTANCE;
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Action.Builder newBuilder() {
            return (MessagesProto.Action.Builder)MessagesProto.Action.DEFAULT_INSTANCE.createBuilder();
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Action.Builder newBuilder(com.google.firebase.inappmessaging.MessagesProto.Action messagesProto$Action) {
            return (MessagesProto.Action.Builder)MessagesProto.Action.DEFAULT_INSTANCE.createBuilder(action);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Action parseDelimitedFrom(InputStream inputStream) {
            return (MessagesProto.Action)z.parseDelimitedFrom(MessagesProto.Action.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Action parseDelimitedFrom(InputStream inputStream, q q2) {
            return (MessagesProto.Action)z.parseDelimitedFrom(MessagesProto.Action.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Action parseFrom(j j) {
            return (MessagesProto.Action)z.parseFrom(MessagesProto.Action.DEFAULT_INSTANCE, j);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Action parseFrom(j j, q q2) {
            return (MessagesProto.Action)z.parseFrom(MessagesProto.Action.DEFAULT_INSTANCE, j, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Action parseFrom(k k) {
            return (MessagesProto.Action)z.parseFrom(MessagesProto.Action.DEFAULT_INSTANCE, k);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Action parseFrom(k k, q q2) {
            return (MessagesProto.Action)z.parseFrom(MessagesProto.Action.DEFAULT_INSTANCE, k, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Action parseFrom(InputStream inputStream) {
            return (MessagesProto.Action)z.parseFrom(MessagesProto.Action.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Action parseFrom(InputStream inputStream, q q2) {
            return (MessagesProto.Action)z.parseFrom(MessagesProto.Action.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Action parseFrom(ByteBuffer byteBuffer) {
            return (MessagesProto.Action)z.parseFrom(MessagesProto.Action.DEFAULT_INSTANCE, byteBuffer);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Action parseFrom(ByteBuffer byteBuffer, q q2) {
            return (MessagesProto.Action)z.parseFrom(MessagesProto.Action.DEFAULT_INSTANCE, byteBuffer, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Action parseFrom(byte[] bArr) {
            return (MessagesProto.Action)z.parseFrom(MessagesProto.Action.DEFAULT_INSTANCE, bArr);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Action parseFrom(byte[] bArr, q q2) {
            return (MessagesProto.Action)z.parseFrom(MessagesProto.Action.DEFAULT_INSTANCE, bArr, q2);
        }

        public static d1<com.google.firebase.inappmessaging.MessagesProto.Action> parser() {
            return MessagesProto.Action.DEFAULT_INSTANCE.getParserForType();
        }

        private void setActionUrl(String string) {
            string.getClass();
            this.actionUrl_ = string;
        }

        private void setActionUrlBytes(j j) {
            a.checkByteStringIsUtf8(j);
            this.actionUrl_ = j.R();
        }

        @Override // com.google.protobuf.z
        protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
            d1 obj1;
            int obj2;
            int obj3;
            obj2 = 1;
            obj3 = 0;
            switch (obj1) {
                case 1:
                    obj1 = new MessagesProto.Action();
                    return obj1;
                case 2:
                    obj1 = new MessagesProto.Action.Builder(obj3);
                    return obj1;
                case 3:
                    obj1 = new Object[obj2];
                    obj1[0] = "actionUrl_";
                    return z.newMessageInfo(MessagesProto.Action.DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", obj1);
                case 4:
                    return MessagesProto.Action.DEFAULT_INSTANCE;
                case 5:
                    return obj1;
                case 6:
                    return Byte.valueOf(obj2);
                case 7:
                    return obj3;
                default:
                    obj1 = new UnsupportedOperationException();
                    throw obj1;
            }
            obj2 = MessagesProto.Action.class;
            synchronized (obj2) {
                obj1 = new z.b(MessagesProto.Action.DEFAULT_INSTANCE);
                MessagesProto.Action.PARSER = obj1;
            }
        }

        @Override // com.google.protobuf.z
        public String getActionUrl() {
            return this.actionUrl_;
        }

        @Override // com.google.protobuf.z
        public j getActionUrlBytes() {
            return j.u(this.actionUrl_);
        }
    }

    public static final class BannerMessage extends z<com.google.firebase.inappmessaging.MessagesProto.BannerMessage, com.google.firebase.inappmessaging.MessagesProto.BannerMessage.Builder> implements com.google.firebase.inappmessaging.MessagesProto.BannerMessageOrBuilder {

        public static final int ACTION_FIELD_NUMBER = 4;
        public static final int BACKGROUND_HEX_COLOR_FIELD_NUMBER = 5;
        public static final int BODY_FIELD_NUMBER = 2;
        private static final com.google.firebase.inappmessaging.MessagesProto.BannerMessage DEFAULT_INSTANCE = null;
        public static final int IMAGE_URL_FIELD_NUMBER = 3;
        private static volatile d1<com.google.firebase.inappmessaging.MessagesProto.BannerMessage> PARSER = null;
        public static final int TITLE_FIELD_NUMBER = 1;
        private com.google.firebase.inappmessaging.MessagesProto.Action action_;
        private String backgroundHexColor_;
        private com.google.firebase.inappmessaging.MessagesProto.Text body_;
        private String imageUrl_;
        private com.google.firebase.inappmessaging.MessagesProto.Text title_;
        static {
            MessagesProto.BannerMessage bannerMessage = new MessagesProto.BannerMessage();
            MessagesProto.BannerMessage.DEFAULT_INSTANCE = bannerMessage;
            z.registerDefaultInstance(MessagesProto.BannerMessage.class, bannerMessage);
        }

        private BannerMessage() {
            super();
            final String str = "";
            this.imageUrl_ = str;
            this.backgroundHexColor_ = str;
        }

        static com.google.firebase.inappmessaging.MessagesProto.BannerMessage access$5200() {
            return MessagesProto.BannerMessage.DEFAULT_INSTANCE;
        }

        static void access$5300(com.google.firebase.inappmessaging.MessagesProto.BannerMessage messagesProto$BannerMessage, com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text2) {
            bannerMessage.setTitle(text2);
        }

        static void access$5400(com.google.firebase.inappmessaging.MessagesProto.BannerMessage messagesProto$BannerMessage, com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text2) {
            bannerMessage.mergeTitle(text2);
        }

        static void access$5500(com.google.firebase.inappmessaging.MessagesProto.BannerMessage messagesProto$BannerMessage) {
            bannerMessage.clearTitle();
        }

        static void access$5600(com.google.firebase.inappmessaging.MessagesProto.BannerMessage messagesProto$BannerMessage, com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text2) {
            bannerMessage.setBody(text2);
        }

        static void access$5700(com.google.firebase.inappmessaging.MessagesProto.BannerMessage messagesProto$BannerMessage, com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text2) {
            bannerMessage.mergeBody(text2);
        }

        static void access$5800(com.google.firebase.inappmessaging.MessagesProto.BannerMessage messagesProto$BannerMessage) {
            bannerMessage.clearBody();
        }

        static void access$5900(com.google.firebase.inappmessaging.MessagesProto.BannerMessage messagesProto$BannerMessage, String string2) {
            bannerMessage.setImageUrl(string2);
        }

        static void access$6000(com.google.firebase.inappmessaging.MessagesProto.BannerMessage messagesProto$BannerMessage) {
            bannerMessage.clearImageUrl();
        }

        static void access$6100(com.google.firebase.inappmessaging.MessagesProto.BannerMessage messagesProto$BannerMessage, j j2) {
            bannerMessage.setImageUrlBytes(j2);
        }

        static void access$6200(com.google.firebase.inappmessaging.MessagesProto.BannerMessage messagesProto$BannerMessage, com.google.firebase.inappmessaging.MessagesProto.Action messagesProto$Action2) {
            bannerMessage.setAction(action2);
        }

        static void access$6300(com.google.firebase.inappmessaging.MessagesProto.BannerMessage messagesProto$BannerMessage, com.google.firebase.inappmessaging.MessagesProto.Action messagesProto$Action2) {
            bannerMessage.mergeAction(action2);
        }

        static void access$6400(com.google.firebase.inappmessaging.MessagesProto.BannerMessage messagesProto$BannerMessage) {
            bannerMessage.clearAction();
        }

        static void access$6500(com.google.firebase.inappmessaging.MessagesProto.BannerMessage messagesProto$BannerMessage, String string2) {
            bannerMessage.setBackgroundHexColor(string2);
        }

        static void access$6600(com.google.firebase.inappmessaging.MessagesProto.BannerMessage messagesProto$BannerMessage) {
            bannerMessage.clearBackgroundHexColor();
        }

        static void access$6700(com.google.firebase.inappmessaging.MessagesProto.BannerMessage messagesProto$BannerMessage, j j2) {
            bannerMessage.setBackgroundHexColorBytes(j2);
        }

        private void clearAction() {
            this.action_ = 0;
        }

        private void clearBackgroundHexColor() {
            this.backgroundHexColor_ = MessagesProto.BannerMessage.getDefaultInstance().getBackgroundHexColor();
        }

        private void clearBody() {
            this.body_ = 0;
        }

        private void clearImageUrl() {
            this.imageUrl_ = MessagesProto.BannerMessage.getDefaultInstance().getImageUrl();
        }

        private void clearTitle() {
            this.title_ = 0;
        }

        public static com.google.firebase.inappmessaging.MessagesProto.BannerMessage getDefaultInstance() {
            return MessagesProto.BannerMessage.DEFAULT_INSTANCE;
        }

        private void mergeAction(com.google.firebase.inappmessaging.MessagesProto.Action messagesProto$Action) {
            Object action_;
            com.google.firebase.inappmessaging.MessagesProto.Action defaultInstance;
            z obj3;
            action.getClass();
            action_ = this.action_;
            if (action_ != null && action_ != MessagesProto.Action.getDefaultInstance()) {
                if (action_ != MessagesProto.Action.getDefaultInstance()) {
                    this.action_ = (MessagesProto.Action)(MessagesProto.Action.Builder)MessagesProto.Action.newBuilder(this.action_).mergeFrom(action).buildPartial();
                } else {
                    this.action_ = action;
                }
            } else {
            }
        }

        private void mergeBody(com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text) {
            Object builder;
            com.google.firebase.inappmessaging.MessagesProto.Text defaultInstance;
            z obj3;
            text.getClass();
            builder = this.body_;
            if (builder != null && builder != MessagesProto.Text.getDefaultInstance()) {
                if (builder != MessagesProto.Text.getDefaultInstance()) {
                    this.body_ = (MessagesProto.Text)(MessagesProto.Text.Builder)MessagesProto.Text.newBuilder(this.body_).mergeFrom(text).buildPartial();
                } else {
                    this.body_ = text;
                }
            } else {
            }
        }

        private void mergeTitle(com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text) {
            Object builder;
            com.google.firebase.inappmessaging.MessagesProto.Text defaultInstance;
            z obj3;
            text.getClass();
            builder = this.title_;
            if (builder != null && builder != MessagesProto.Text.getDefaultInstance()) {
                if (builder != MessagesProto.Text.getDefaultInstance()) {
                    this.title_ = (MessagesProto.Text)(MessagesProto.Text.Builder)MessagesProto.Text.newBuilder(this.title_).mergeFrom(text).buildPartial();
                } else {
                    this.title_ = text;
                }
            } else {
            }
        }

        public static com.google.firebase.inappmessaging.MessagesProto.BannerMessage.Builder newBuilder() {
            return (MessagesProto.BannerMessage.Builder)MessagesProto.BannerMessage.DEFAULT_INSTANCE.createBuilder();
        }

        public static com.google.firebase.inappmessaging.MessagesProto.BannerMessage.Builder newBuilder(com.google.firebase.inappmessaging.MessagesProto.BannerMessage messagesProto$BannerMessage) {
            return (MessagesProto.BannerMessage.Builder)MessagesProto.BannerMessage.DEFAULT_INSTANCE.createBuilder(bannerMessage);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.BannerMessage parseDelimitedFrom(InputStream inputStream) {
            return (MessagesProto.BannerMessage)z.parseDelimitedFrom(MessagesProto.BannerMessage.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.BannerMessage parseDelimitedFrom(InputStream inputStream, q q2) {
            return (MessagesProto.BannerMessage)z.parseDelimitedFrom(MessagesProto.BannerMessage.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.BannerMessage parseFrom(j j) {
            return (MessagesProto.BannerMessage)z.parseFrom(MessagesProto.BannerMessage.DEFAULT_INSTANCE, j);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.BannerMessage parseFrom(j j, q q2) {
            return (MessagesProto.BannerMessage)z.parseFrom(MessagesProto.BannerMessage.DEFAULT_INSTANCE, j, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.BannerMessage parseFrom(k k) {
            return (MessagesProto.BannerMessage)z.parseFrom(MessagesProto.BannerMessage.DEFAULT_INSTANCE, k);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.BannerMessage parseFrom(k k, q q2) {
            return (MessagesProto.BannerMessage)z.parseFrom(MessagesProto.BannerMessage.DEFAULT_INSTANCE, k, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.BannerMessage parseFrom(InputStream inputStream) {
            return (MessagesProto.BannerMessage)z.parseFrom(MessagesProto.BannerMessage.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.BannerMessage parseFrom(InputStream inputStream, q q2) {
            return (MessagesProto.BannerMessage)z.parseFrom(MessagesProto.BannerMessage.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.BannerMessage parseFrom(ByteBuffer byteBuffer) {
            return (MessagesProto.BannerMessage)z.parseFrom(MessagesProto.BannerMessage.DEFAULT_INSTANCE, byteBuffer);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.BannerMessage parseFrom(ByteBuffer byteBuffer, q q2) {
            return (MessagesProto.BannerMessage)z.parseFrom(MessagesProto.BannerMessage.DEFAULT_INSTANCE, byteBuffer, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.BannerMessage parseFrom(byte[] bArr) {
            return (MessagesProto.BannerMessage)z.parseFrom(MessagesProto.BannerMessage.DEFAULT_INSTANCE, bArr);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.BannerMessage parseFrom(byte[] bArr, q q2) {
            return (MessagesProto.BannerMessage)z.parseFrom(MessagesProto.BannerMessage.DEFAULT_INSTANCE, bArr, q2);
        }

        public static d1<com.google.firebase.inappmessaging.MessagesProto.BannerMessage> parser() {
            return MessagesProto.BannerMessage.DEFAULT_INSTANCE.getParserForType();
        }

        private void setAction(com.google.firebase.inappmessaging.MessagesProto.Action messagesProto$Action) {
            action.getClass();
            this.action_ = action;
        }

        private void setBackgroundHexColor(String string) {
            string.getClass();
            this.backgroundHexColor_ = string;
        }

        private void setBackgroundHexColorBytes(j j) {
            a.checkByteStringIsUtf8(j);
            this.backgroundHexColor_ = j.R();
        }

        private void setBody(com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text) {
            text.getClass();
            this.body_ = text;
        }

        private void setImageUrl(String string) {
            string.getClass();
            this.imageUrl_ = string;
        }

        private void setImageUrlBytes(j j) {
            a.checkByteStringIsUtf8(j);
            this.imageUrl_ = j.R();
        }

        private void setTitle(com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text) {
            text.getClass();
            this.title_ = text;
        }

        @Override // com.google.protobuf.z
        protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
            d1 obj2;
            int obj3;
            int obj4;
            obj3 = 1;
            obj4 = 0;
            switch (obj2) {
                case 1:
                    obj2 = new MessagesProto.BannerMessage();
                    return obj2;
                case 2:
                    obj2 = new MessagesProto.BannerMessage.Builder(obj4);
                    return obj2;
                case 3:
                    obj2 = new Object[5];
                    obj2[obj3] = "body_";
                    obj2[2] = "imageUrl_";
                    obj2[3] = "action_";
                    obj2[4] = "backgroundHexColor_";
                    return z.newMessageInfo(MessagesProto.BannerMessage.DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\t\u0002\t\u0003Ȉ\u0004\t\u0005Ȉ", obj2);
                case 4:
                    return MessagesProto.BannerMessage.DEFAULT_INSTANCE;
                case 5:
                    return obj2;
                case 6:
                    return Byte.valueOf(obj3);
                case 7:
                    return obj4;
                default:
                    obj2 = new UnsupportedOperationException();
                    throw obj2;
            }
            obj3 = MessagesProto.BannerMessage.class;
            synchronized (obj3) {
                obj2 = new z.b(MessagesProto.BannerMessage.DEFAULT_INSTANCE);
                MessagesProto.BannerMessage.PARSER = obj2;
            }
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.MessagesProto.Action getAction() {
            com.google.firebase.inappmessaging.MessagesProto.Action defaultInstance;
            if (this.action_ == null) {
                defaultInstance = MessagesProto.Action.getDefaultInstance();
            }
            return defaultInstance;
        }

        @Override // com.google.protobuf.z
        public String getBackgroundHexColor() {
            return this.backgroundHexColor_;
        }

        @Override // com.google.protobuf.z
        public j getBackgroundHexColorBytes() {
            return j.u(this.backgroundHexColor_);
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.MessagesProto.Text getBody() {
            com.google.firebase.inappmessaging.MessagesProto.Text defaultInstance;
            if (this.body_ == null) {
                defaultInstance = MessagesProto.Text.getDefaultInstance();
            }
            return defaultInstance;
        }

        @Override // com.google.protobuf.z
        public String getImageUrl() {
            return this.imageUrl_;
        }

        @Override // com.google.protobuf.z
        public j getImageUrlBytes() {
            return j.u(this.imageUrl_);
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.MessagesProto.Text getTitle() {
            com.google.firebase.inappmessaging.MessagesProto.Text defaultInstance;
            if (this.title_ == null) {
                defaultInstance = MessagesProto.Text.getDefaultInstance();
            }
            return defaultInstance;
        }

        @Override // com.google.protobuf.z
        public boolean hasAction() {
            int i;
            i = this.action_ != null ? 1 : 0;
            return i;
        }

        @Override // com.google.protobuf.z
        public boolean hasBody() {
            int i;
            i = this.body_ != null ? 1 : 0;
            return i;
        }

        @Override // com.google.protobuf.z
        public boolean hasTitle() {
            int i;
            i = this.title_ != null ? 1 : 0;
            return i;
        }
    }

    public static final class Button extends z<com.google.firebase.inappmessaging.MessagesProto.Button, com.google.firebase.inappmessaging.MessagesProto.Button.Builder> implements com.google.firebase.inappmessaging.MessagesProto.ButtonOrBuilder {

        public static final int BUTTON_HEX_COLOR_FIELD_NUMBER = 2;
        private static final com.google.firebase.inappmessaging.MessagesProto.Button DEFAULT_INSTANCE = null;
        private static volatile d1<com.google.firebase.inappmessaging.MessagesProto.Button> PARSER = null;
        public static final int TEXT_FIELD_NUMBER = 1;
        private String buttonHexColor_;
        private com.google.firebase.inappmessaging.MessagesProto.Text text_;
        static {
            MessagesProto.Button button = new MessagesProto.Button();
            MessagesProto.Button.DEFAULT_INSTANCE = button;
            z.registerDefaultInstance(MessagesProto.Button.class, button);
        }

        private Button() {
            super();
            this.buttonHexColor_ = "";
        }

        static void access$10000(com.google.firebase.inappmessaging.MessagesProto.Button messagesProto$Button) {
            button.clearText();
        }

        static void access$10100(com.google.firebase.inappmessaging.MessagesProto.Button messagesProto$Button, String string2) {
            button.setButtonHexColor(string2);
        }

        static void access$10200(com.google.firebase.inappmessaging.MessagesProto.Button messagesProto$Button) {
            button.clearButtonHexColor();
        }

        static void access$10300(com.google.firebase.inappmessaging.MessagesProto.Button messagesProto$Button, j j2) {
            button.setButtonHexColorBytes(j2);
        }

        static com.google.firebase.inappmessaging.MessagesProto.Button access$9700() {
            return MessagesProto.Button.DEFAULT_INSTANCE;
        }

        static void access$9800(com.google.firebase.inappmessaging.MessagesProto.Button messagesProto$Button, com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text2) {
            button.setText(text2);
        }

        static void access$9900(com.google.firebase.inappmessaging.MessagesProto.Button messagesProto$Button, com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text2) {
            button.mergeText(text2);
        }

        private void clearButtonHexColor() {
            this.buttonHexColor_ = MessagesProto.Button.getDefaultInstance().getButtonHexColor();
        }

        private void clearText() {
            this.text_ = 0;
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Button getDefaultInstance() {
            return MessagesProto.Button.DEFAULT_INSTANCE;
        }

        private void mergeText(com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text) {
            Object builder;
            com.google.firebase.inappmessaging.MessagesProto.Text defaultInstance;
            z obj3;
            text.getClass();
            builder = this.text_;
            if (builder != null && builder != MessagesProto.Text.getDefaultInstance()) {
                if (builder != MessagesProto.Text.getDefaultInstance()) {
                    this.text_ = (MessagesProto.Text)(MessagesProto.Text.Builder)MessagesProto.Text.newBuilder(this.text_).mergeFrom(text).buildPartial();
                } else {
                    this.text_ = text;
                }
            } else {
            }
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Button.Builder newBuilder() {
            return (MessagesProto.Button.Builder)MessagesProto.Button.DEFAULT_INSTANCE.createBuilder();
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Button.Builder newBuilder(com.google.firebase.inappmessaging.MessagesProto.Button messagesProto$Button) {
            return (MessagesProto.Button.Builder)MessagesProto.Button.DEFAULT_INSTANCE.createBuilder(button);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Button parseDelimitedFrom(InputStream inputStream) {
            return (MessagesProto.Button)z.parseDelimitedFrom(MessagesProto.Button.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Button parseDelimitedFrom(InputStream inputStream, q q2) {
            return (MessagesProto.Button)z.parseDelimitedFrom(MessagesProto.Button.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Button parseFrom(j j) {
            return (MessagesProto.Button)z.parseFrom(MessagesProto.Button.DEFAULT_INSTANCE, j);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Button parseFrom(j j, q q2) {
            return (MessagesProto.Button)z.parseFrom(MessagesProto.Button.DEFAULT_INSTANCE, j, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Button parseFrom(k k) {
            return (MessagesProto.Button)z.parseFrom(MessagesProto.Button.DEFAULT_INSTANCE, k);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Button parseFrom(k k, q q2) {
            return (MessagesProto.Button)z.parseFrom(MessagesProto.Button.DEFAULT_INSTANCE, k, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Button parseFrom(InputStream inputStream) {
            return (MessagesProto.Button)z.parseFrom(MessagesProto.Button.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Button parseFrom(InputStream inputStream, q q2) {
            return (MessagesProto.Button)z.parseFrom(MessagesProto.Button.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Button parseFrom(ByteBuffer byteBuffer) {
            return (MessagesProto.Button)z.parseFrom(MessagesProto.Button.DEFAULT_INSTANCE, byteBuffer);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Button parseFrom(ByteBuffer byteBuffer, q q2) {
            return (MessagesProto.Button)z.parseFrom(MessagesProto.Button.DEFAULT_INSTANCE, byteBuffer, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Button parseFrom(byte[] bArr) {
            return (MessagesProto.Button)z.parseFrom(MessagesProto.Button.DEFAULT_INSTANCE, bArr);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Button parseFrom(byte[] bArr, q q2) {
            return (MessagesProto.Button)z.parseFrom(MessagesProto.Button.DEFAULT_INSTANCE, bArr, q2);
        }

        public static d1<com.google.firebase.inappmessaging.MessagesProto.Button> parser() {
            return MessagesProto.Button.DEFAULT_INSTANCE.getParserForType();
        }

        private void setButtonHexColor(String string) {
            string.getClass();
            this.buttonHexColor_ = string;
        }

        private void setButtonHexColorBytes(j j) {
            a.checkByteStringIsUtf8(j);
            this.buttonHexColor_ = j.R();
        }

        private void setText(com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text) {
            text.getClass();
            this.text_ = text;
        }

        @Override // com.google.protobuf.z
        protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
            d1 obj2;
            int obj3;
            int obj4;
            obj3 = 1;
            obj4 = 0;
            switch (obj2) {
                case 1:
                    obj2 = new MessagesProto.Button();
                    return obj2;
                case 2:
                    obj2 = new MessagesProto.Button.Builder(obj4);
                    return obj2;
                case 3:
                    obj2 = new Object[2];
                    obj2[obj3] = "buttonHexColor_";
                    return z.newMessageInfo(MessagesProto.Button.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002Ȉ", obj2);
                case 4:
                    return MessagesProto.Button.DEFAULT_INSTANCE;
                case 5:
                    return obj2;
                case 6:
                    return Byte.valueOf(obj3);
                case 7:
                    return obj4;
                default:
                    obj2 = new UnsupportedOperationException();
                    throw obj2;
            }
            obj3 = MessagesProto.Button.class;
            synchronized (obj3) {
                obj2 = new z.b(MessagesProto.Button.DEFAULT_INSTANCE);
                MessagesProto.Button.PARSER = obj2;
            }
        }

        @Override // com.google.protobuf.z
        public String getButtonHexColor() {
            return this.buttonHexColor_;
        }

        @Override // com.google.protobuf.z
        public j getButtonHexColorBytes() {
            return j.u(this.buttonHexColor_);
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.MessagesProto.Text getText() {
            com.google.firebase.inappmessaging.MessagesProto.Text defaultInstance;
            if (this.text_ == null) {
                defaultInstance = MessagesProto.Text.getDefaultInstance();
            }
            return defaultInstance;
        }

        @Override // com.google.protobuf.z
        public boolean hasText() {
            int i;
            i = this.text_ != null ? 1 : 0;
            return i;
        }
    }

    public static final class CardMessage extends z<com.google.firebase.inappmessaging.MessagesProto.CardMessage, com.google.firebase.inappmessaging.MessagesProto.CardMessage.Builder> implements com.google.firebase.inappmessaging.MessagesProto.CardMessageOrBuilder {

        public static final int BACKGROUND_HEX_COLOR_FIELD_NUMBER = 5;
        public static final int BODY_FIELD_NUMBER = 2;
        private static final com.google.firebase.inappmessaging.MessagesProto.CardMessage DEFAULT_INSTANCE = null;
        public static final int LANDSCAPE_IMAGE_URL_FIELD_NUMBER = 4;
        private static volatile d1<com.google.firebase.inappmessaging.MessagesProto.CardMessage> PARSER = null;
        public static final int PORTRAIT_IMAGE_URL_FIELD_NUMBER = 3;
        public static final int PRIMARY_ACTION_BUTTON_FIELD_NUMBER = 6;
        public static final int PRIMARY_ACTION_FIELD_NUMBER = 7;
        public static final int SECONDARY_ACTION_BUTTON_FIELD_NUMBER = 8;
        public static final int SECONDARY_ACTION_FIELD_NUMBER = 9;
        public static final int TITLE_FIELD_NUMBER = 1;
        private String backgroundHexColor_;
        private com.google.firebase.inappmessaging.MessagesProto.Text body_;
        private String landscapeImageUrl_;
        private String portraitImageUrl_;
        private com.google.firebase.inappmessaging.MessagesProto.Button primaryActionButton_;
        private com.google.firebase.inappmessaging.MessagesProto.Action primaryAction_;
        private com.google.firebase.inappmessaging.MessagesProto.Button secondaryActionButton_;
        private com.google.firebase.inappmessaging.MessagesProto.Action secondaryAction_;
        private com.google.firebase.inappmessaging.MessagesProto.Text title_;
        static {
            MessagesProto.CardMessage cardMessage = new MessagesProto.CardMessage();
            MessagesProto.CardMessage.DEFAULT_INSTANCE = cardMessage;
            z.registerDefaultInstance(MessagesProto.CardMessage.class, cardMessage);
        }

        private CardMessage() {
            super();
            final String str = "";
            this.portraitImageUrl_ = str;
            this.landscapeImageUrl_ = str;
            this.backgroundHexColor_ = str;
        }

        static com.google.firebase.inappmessaging.MessagesProto.CardMessage access$1500() {
            return MessagesProto.CardMessage.DEFAULT_INSTANCE;
        }

        static void access$1600(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage, com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text2) {
            cardMessage.setTitle(text2);
        }

        static void access$1700(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage, com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text2) {
            cardMessage.mergeTitle(text2);
        }

        static void access$1800(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage) {
            cardMessage.clearTitle();
        }

        static void access$1900(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage, com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text2) {
            cardMessage.setBody(text2);
        }

        static void access$2000(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage, com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text2) {
            cardMessage.mergeBody(text2);
        }

        static void access$2100(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage) {
            cardMessage.clearBody();
        }

        static void access$2200(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage, String string2) {
            cardMessage.setPortraitImageUrl(string2);
        }

        static void access$2300(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage) {
            cardMessage.clearPortraitImageUrl();
        }

        static void access$2400(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage, j j2) {
            cardMessage.setPortraitImageUrlBytes(j2);
        }

        static void access$2500(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage, String string2) {
            cardMessage.setLandscapeImageUrl(string2);
        }

        static void access$2600(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage) {
            cardMessage.clearLandscapeImageUrl();
        }

        static void access$2700(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage, j j2) {
            cardMessage.setLandscapeImageUrlBytes(j2);
        }

        static void access$2800(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage, String string2) {
            cardMessage.setBackgroundHexColor(string2);
        }

        static void access$2900(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage) {
            cardMessage.clearBackgroundHexColor();
        }

        static void access$3000(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage, j j2) {
            cardMessage.setBackgroundHexColorBytes(j2);
        }

        static void access$3100(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage, com.google.firebase.inappmessaging.MessagesProto.Button messagesProto$Button2) {
            cardMessage.setPrimaryActionButton(button2);
        }

        static void access$3200(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage, com.google.firebase.inappmessaging.MessagesProto.Button messagesProto$Button2) {
            cardMessage.mergePrimaryActionButton(button2);
        }

        static void access$3300(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage) {
            cardMessage.clearPrimaryActionButton();
        }

        static void access$3400(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage, com.google.firebase.inappmessaging.MessagesProto.Action messagesProto$Action2) {
            cardMessage.setPrimaryAction(action2);
        }

        static void access$3500(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage, com.google.firebase.inappmessaging.MessagesProto.Action messagesProto$Action2) {
            cardMessage.mergePrimaryAction(action2);
        }

        static void access$3600(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage) {
            cardMessage.clearPrimaryAction();
        }

        static void access$3700(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage, com.google.firebase.inappmessaging.MessagesProto.Button messagesProto$Button2) {
            cardMessage.setSecondaryActionButton(button2);
        }

        static void access$3800(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage, com.google.firebase.inappmessaging.MessagesProto.Button messagesProto$Button2) {
            cardMessage.mergeSecondaryActionButton(button2);
        }

        static void access$3900(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage) {
            cardMessage.clearSecondaryActionButton();
        }

        static void access$4000(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage, com.google.firebase.inappmessaging.MessagesProto.Action messagesProto$Action2) {
            cardMessage.setSecondaryAction(action2);
        }

        static void access$4100(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage, com.google.firebase.inappmessaging.MessagesProto.Action messagesProto$Action2) {
            cardMessage.mergeSecondaryAction(action2);
        }

        static void access$4200(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage) {
            cardMessage.clearSecondaryAction();
        }

        private void clearBackgroundHexColor() {
            this.backgroundHexColor_ = MessagesProto.CardMessage.getDefaultInstance().getBackgroundHexColor();
        }

        private void clearBody() {
            this.body_ = 0;
        }

        private void clearLandscapeImageUrl() {
            this.landscapeImageUrl_ = MessagesProto.CardMessage.getDefaultInstance().getLandscapeImageUrl();
        }

        private void clearPortraitImageUrl() {
            this.portraitImageUrl_ = MessagesProto.CardMessage.getDefaultInstance().getPortraitImageUrl();
        }

        private void clearPrimaryAction() {
            this.primaryAction_ = 0;
        }

        private void clearPrimaryActionButton() {
            this.primaryActionButton_ = 0;
        }

        private void clearSecondaryAction() {
            this.secondaryAction_ = 0;
        }

        private void clearSecondaryActionButton() {
            this.secondaryActionButton_ = 0;
        }

        private void clearTitle() {
            this.title_ = 0;
        }

        public static com.google.firebase.inappmessaging.MessagesProto.CardMessage getDefaultInstance() {
            return MessagesProto.CardMessage.DEFAULT_INSTANCE;
        }

        private void mergeBody(com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text) {
            Object builder;
            com.google.firebase.inappmessaging.MessagesProto.Text defaultInstance;
            z obj3;
            text.getClass();
            builder = this.body_;
            if (builder != null && builder != MessagesProto.Text.getDefaultInstance()) {
                if (builder != MessagesProto.Text.getDefaultInstance()) {
                    this.body_ = (MessagesProto.Text)(MessagesProto.Text.Builder)MessagesProto.Text.newBuilder(this.body_).mergeFrom(text).buildPartial();
                } else {
                    this.body_ = text;
                }
            } else {
            }
        }

        private void mergePrimaryAction(com.google.firebase.inappmessaging.MessagesProto.Action messagesProto$Action) {
            Object primaryAction_;
            com.google.firebase.inappmessaging.MessagesProto.Action defaultInstance;
            z obj3;
            action.getClass();
            primaryAction_ = this.primaryAction_;
            if (primaryAction_ != null && primaryAction_ != MessagesProto.Action.getDefaultInstance()) {
                if (primaryAction_ != MessagesProto.Action.getDefaultInstance()) {
                    this.primaryAction_ = (MessagesProto.Action)(MessagesProto.Action.Builder)MessagesProto.Action.newBuilder(this.primaryAction_).mergeFrom(action).buildPartial();
                } else {
                    this.primaryAction_ = action;
                }
            } else {
            }
        }

        private void mergePrimaryActionButton(com.google.firebase.inappmessaging.MessagesProto.Button messagesProto$Button) {
            Object primaryActionButton_;
            com.google.firebase.inappmessaging.MessagesProto.Button defaultInstance;
            z obj3;
            button.getClass();
            primaryActionButton_ = this.primaryActionButton_;
            if (primaryActionButton_ != null && primaryActionButton_ != MessagesProto.Button.getDefaultInstance()) {
                if (primaryActionButton_ != MessagesProto.Button.getDefaultInstance()) {
                    this.primaryActionButton_ = (MessagesProto.Button)(MessagesProto.Button.Builder)MessagesProto.Button.newBuilder(this.primaryActionButton_).mergeFrom(button).buildPartial();
                } else {
                    this.primaryActionButton_ = button;
                }
            } else {
            }
        }

        private void mergeSecondaryAction(com.google.firebase.inappmessaging.MessagesProto.Action messagesProto$Action) {
            Object secondaryAction_;
            com.google.firebase.inappmessaging.MessagesProto.Action defaultInstance;
            z obj3;
            action.getClass();
            secondaryAction_ = this.secondaryAction_;
            if (secondaryAction_ != null && secondaryAction_ != MessagesProto.Action.getDefaultInstance()) {
                if (secondaryAction_ != MessagesProto.Action.getDefaultInstance()) {
                    this.secondaryAction_ = (MessagesProto.Action)(MessagesProto.Action.Builder)MessagesProto.Action.newBuilder(this.secondaryAction_).mergeFrom(action).buildPartial();
                } else {
                    this.secondaryAction_ = action;
                }
            } else {
            }
        }

        private void mergeSecondaryActionButton(com.google.firebase.inappmessaging.MessagesProto.Button messagesProto$Button) {
            Object secondaryActionButton_;
            com.google.firebase.inappmessaging.MessagesProto.Button defaultInstance;
            z obj3;
            button.getClass();
            secondaryActionButton_ = this.secondaryActionButton_;
            if (secondaryActionButton_ != null && secondaryActionButton_ != MessagesProto.Button.getDefaultInstance()) {
                if (secondaryActionButton_ != MessagesProto.Button.getDefaultInstance()) {
                    this.secondaryActionButton_ = (MessagesProto.Button)(MessagesProto.Button.Builder)MessagesProto.Button.newBuilder(this.secondaryActionButton_).mergeFrom(button).buildPartial();
                } else {
                    this.secondaryActionButton_ = button;
                }
            } else {
            }
        }

        private void mergeTitle(com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text) {
            Object builder;
            com.google.firebase.inappmessaging.MessagesProto.Text defaultInstance;
            z obj3;
            text.getClass();
            builder = this.title_;
            if (builder != null && builder != MessagesProto.Text.getDefaultInstance()) {
                if (builder != MessagesProto.Text.getDefaultInstance()) {
                    this.title_ = (MessagesProto.Text)(MessagesProto.Text.Builder)MessagesProto.Text.newBuilder(this.title_).mergeFrom(text).buildPartial();
                } else {
                    this.title_ = text;
                }
            } else {
            }
        }

        public static com.google.firebase.inappmessaging.MessagesProto.CardMessage.Builder newBuilder() {
            return (MessagesProto.CardMessage.Builder)MessagesProto.CardMessage.DEFAULT_INSTANCE.createBuilder();
        }

        public static com.google.firebase.inappmessaging.MessagesProto.CardMessage.Builder newBuilder(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage) {
            return (MessagesProto.CardMessage.Builder)MessagesProto.CardMessage.DEFAULT_INSTANCE.createBuilder(cardMessage);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.CardMessage parseDelimitedFrom(InputStream inputStream) {
            return (MessagesProto.CardMessage)z.parseDelimitedFrom(MessagesProto.CardMessage.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.CardMessage parseDelimitedFrom(InputStream inputStream, q q2) {
            return (MessagesProto.CardMessage)z.parseDelimitedFrom(MessagesProto.CardMessage.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.CardMessage parseFrom(j j) {
            return (MessagesProto.CardMessage)z.parseFrom(MessagesProto.CardMessage.DEFAULT_INSTANCE, j);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.CardMessage parseFrom(j j, q q2) {
            return (MessagesProto.CardMessage)z.parseFrom(MessagesProto.CardMessage.DEFAULT_INSTANCE, j, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.CardMessage parseFrom(k k) {
            return (MessagesProto.CardMessage)z.parseFrom(MessagesProto.CardMessage.DEFAULT_INSTANCE, k);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.CardMessage parseFrom(k k, q q2) {
            return (MessagesProto.CardMessage)z.parseFrom(MessagesProto.CardMessage.DEFAULT_INSTANCE, k, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.CardMessage parseFrom(InputStream inputStream) {
            return (MessagesProto.CardMessage)z.parseFrom(MessagesProto.CardMessage.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.CardMessage parseFrom(InputStream inputStream, q q2) {
            return (MessagesProto.CardMessage)z.parseFrom(MessagesProto.CardMessage.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.CardMessage parseFrom(ByteBuffer byteBuffer) {
            return (MessagesProto.CardMessage)z.parseFrom(MessagesProto.CardMessage.DEFAULT_INSTANCE, byteBuffer);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.CardMessage parseFrom(ByteBuffer byteBuffer, q q2) {
            return (MessagesProto.CardMessage)z.parseFrom(MessagesProto.CardMessage.DEFAULT_INSTANCE, byteBuffer, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.CardMessage parseFrom(byte[] bArr) {
            return (MessagesProto.CardMessage)z.parseFrom(MessagesProto.CardMessage.DEFAULT_INSTANCE, bArr);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.CardMessage parseFrom(byte[] bArr, q q2) {
            return (MessagesProto.CardMessage)z.parseFrom(MessagesProto.CardMessage.DEFAULT_INSTANCE, bArr, q2);
        }

        public static d1<com.google.firebase.inappmessaging.MessagesProto.CardMessage> parser() {
            return MessagesProto.CardMessage.DEFAULT_INSTANCE.getParserForType();
        }

        private void setBackgroundHexColor(String string) {
            string.getClass();
            this.backgroundHexColor_ = string;
        }

        private void setBackgroundHexColorBytes(j j) {
            a.checkByteStringIsUtf8(j);
            this.backgroundHexColor_ = j.R();
        }

        private void setBody(com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text) {
            text.getClass();
            this.body_ = text;
        }

        private void setLandscapeImageUrl(String string) {
            string.getClass();
            this.landscapeImageUrl_ = string;
        }

        private void setLandscapeImageUrlBytes(j j) {
            a.checkByteStringIsUtf8(j);
            this.landscapeImageUrl_ = j.R();
        }

        private void setPortraitImageUrl(String string) {
            string.getClass();
            this.portraitImageUrl_ = string;
        }

        private void setPortraitImageUrlBytes(j j) {
            a.checkByteStringIsUtf8(j);
            this.portraitImageUrl_ = j.R();
        }

        private void setPrimaryAction(com.google.firebase.inappmessaging.MessagesProto.Action messagesProto$Action) {
            action.getClass();
            this.primaryAction_ = action;
        }

        private void setPrimaryActionButton(com.google.firebase.inappmessaging.MessagesProto.Button messagesProto$Button) {
            button.getClass();
            this.primaryActionButton_ = button;
        }

        private void setSecondaryAction(com.google.firebase.inappmessaging.MessagesProto.Action messagesProto$Action) {
            action.getClass();
            this.secondaryAction_ = action;
        }

        private void setSecondaryActionButton(com.google.firebase.inappmessaging.MessagesProto.Button messagesProto$Button) {
            button.getClass();
            this.secondaryActionButton_ = button;
        }

        private void setTitle(com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text) {
            text.getClass();
            this.title_ = text;
        }

        @Override // com.google.protobuf.z
        protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
            d1 obj2;
            int obj3;
            int obj4;
            obj3 = 1;
            obj4 = 0;
            switch (obj2) {
                case 1:
                    obj2 = new MessagesProto.CardMessage();
                    return obj2;
                case 2:
                    obj2 = new MessagesProto.CardMessage.Builder(obj4);
                    return obj2;
                case 3:
                    obj2 = new Object[9];
                    obj2[obj3] = "body_";
                    obj2[2] = "portraitImageUrl_";
                    obj2[3] = "landscapeImageUrl_";
                    obj2[4] = "backgroundHexColor_";
                    obj2[5] = "primaryActionButton_";
                    obj2[6] = "primaryAction_";
                    obj2[7] = "secondaryActionButton_";
                    obj2[8] = "secondaryAction_";
                    return z.newMessageInfo(MessagesProto.CardMessage.DEFAULT_INSTANCE, "\u0000\t\u0000\u0000\u0001\t\t\u0000\u0000\u0000\u0001\t\u0002\t\u0003Ȉ\u0004Ȉ\u0005Ȉ\u0006\t\u0007\t\u0008\t\t\t", obj2);
                case 4:
                    return MessagesProto.CardMessage.DEFAULT_INSTANCE;
                case 5:
                    return obj2;
                case 6:
                    return Byte.valueOf(obj3);
                case 7:
                    return obj4;
                default:
                    obj2 = new UnsupportedOperationException();
                    throw obj2;
            }
            obj3 = MessagesProto.CardMessage.class;
            synchronized (obj3) {
                obj2 = new z.b(MessagesProto.CardMessage.DEFAULT_INSTANCE);
                MessagesProto.CardMessage.PARSER = obj2;
            }
        }

        @Override // com.google.protobuf.z
        public String getBackgroundHexColor() {
            return this.backgroundHexColor_;
        }

        @Override // com.google.protobuf.z
        public j getBackgroundHexColorBytes() {
            return j.u(this.backgroundHexColor_);
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.MessagesProto.Text getBody() {
            com.google.firebase.inappmessaging.MessagesProto.Text defaultInstance;
            if (this.body_ == null) {
                defaultInstance = MessagesProto.Text.getDefaultInstance();
            }
            return defaultInstance;
        }

        @Override // com.google.protobuf.z
        public String getLandscapeImageUrl() {
            return this.landscapeImageUrl_;
        }

        @Override // com.google.protobuf.z
        public j getLandscapeImageUrlBytes() {
            return j.u(this.landscapeImageUrl_);
        }

        @Override // com.google.protobuf.z
        public String getPortraitImageUrl() {
            return this.portraitImageUrl_;
        }

        @Override // com.google.protobuf.z
        public j getPortraitImageUrlBytes() {
            return j.u(this.portraitImageUrl_);
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.MessagesProto.Action getPrimaryAction() {
            com.google.firebase.inappmessaging.MessagesProto.Action defaultInstance;
            if (this.primaryAction_ == null) {
                defaultInstance = MessagesProto.Action.getDefaultInstance();
            }
            return defaultInstance;
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.MessagesProto.Button getPrimaryActionButton() {
            com.google.firebase.inappmessaging.MessagesProto.Button primaryActionButton_;
            if (this.primaryActionButton_ == null) {
                primaryActionButton_ = MessagesProto.Button.getDefaultInstance();
            }
            return primaryActionButton_;
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.MessagesProto.Action getSecondaryAction() {
            com.google.firebase.inappmessaging.MessagesProto.Action secondaryAction_;
            if (this.secondaryAction_ == null) {
                secondaryAction_ = MessagesProto.Action.getDefaultInstance();
            }
            return secondaryAction_;
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.MessagesProto.Button getSecondaryActionButton() {
            com.google.firebase.inappmessaging.MessagesProto.Button secondaryActionButton_;
            if (this.secondaryActionButton_ == null) {
                secondaryActionButton_ = MessagesProto.Button.getDefaultInstance();
            }
            return secondaryActionButton_;
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.MessagesProto.Text getTitle() {
            com.google.firebase.inappmessaging.MessagesProto.Text defaultInstance;
            if (this.title_ == null) {
                defaultInstance = MessagesProto.Text.getDefaultInstance();
            }
            return defaultInstance;
        }

        @Override // com.google.protobuf.z
        public boolean hasBody() {
            int i;
            i = this.body_ != null ? 1 : 0;
            return i;
        }

        @Override // com.google.protobuf.z
        public boolean hasPrimaryAction() {
            int i;
            i = this.primaryAction_ != null ? 1 : 0;
            return i;
        }

        @Override // com.google.protobuf.z
        public boolean hasPrimaryActionButton() {
            int i;
            i = this.primaryActionButton_ != null ? 1 : 0;
            return i;
        }

        @Override // com.google.protobuf.z
        public boolean hasSecondaryAction() {
            int i;
            i = this.secondaryAction_ != null ? 1 : 0;
            return i;
        }

        @Override // com.google.protobuf.z
        public boolean hasSecondaryActionButton() {
            int i;
            i = this.secondaryActionButton_ != null ? 1 : 0;
            return i;
        }

        @Override // com.google.protobuf.z
        public boolean hasTitle() {
            int i;
            i = this.title_ != null ? 1 : 0;
            return i;
        }
    }

    public static final class Content extends z<com.google.firebase.inappmessaging.MessagesProto.Content, com.google.firebase.inappmessaging.MessagesProto.Content.Builder> implements com.google.firebase.inappmessaging.MessagesProto.ContentOrBuilder {

        public static final int BANNER_FIELD_NUMBER = 1;
        public static final int CARD_FIELD_NUMBER = 4;
        private static final com.google.firebase.inappmessaging.MessagesProto.Content DEFAULT_INSTANCE = null;
        public static final int IMAGE_ONLY_FIELD_NUMBER = 3;
        public static final int MODAL_FIELD_NUMBER = 2;
        private static volatile d1<com.google.firebase.inappmessaging.MessagesProto.Content> PARSER;
        private int messageDetailsCase_ = 0;
        private Object messageDetails_;
        static {
            MessagesProto.Content content = new MessagesProto.Content();
            MessagesProto.Content.DEFAULT_INSTANCE = content;
            z.registerDefaultInstance(MessagesProto.Content.class, content);
        }

        private Content() {
            super();
            final int i = 0;
        }

        static com.google.firebase.inappmessaging.MessagesProto.Content access$000() {
            return MessagesProto.Content.DEFAULT_INSTANCE;
        }

        static void access$100(com.google.firebase.inappmessaging.MessagesProto.Content messagesProto$Content) {
            content.clearMessageDetails();
        }

        static void access$1000(com.google.firebase.inappmessaging.MessagesProto.Content messagesProto$Content) {
            content.clearImageOnly();
        }

        static void access$1100(com.google.firebase.inappmessaging.MessagesProto.Content messagesProto$Content, com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage2) {
            content.setCard(cardMessage2);
        }

        static void access$1200(com.google.firebase.inappmessaging.MessagesProto.Content messagesProto$Content, com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage2) {
            content.mergeCard(cardMessage2);
        }

        static void access$1300(com.google.firebase.inappmessaging.MessagesProto.Content messagesProto$Content) {
            content.clearCard();
        }

        static void access$200(com.google.firebase.inappmessaging.MessagesProto.Content messagesProto$Content, com.google.firebase.inappmessaging.MessagesProto.BannerMessage messagesProto$BannerMessage2) {
            content.setBanner(bannerMessage2);
        }

        static void access$300(com.google.firebase.inappmessaging.MessagesProto.Content messagesProto$Content, com.google.firebase.inappmessaging.MessagesProto.BannerMessage messagesProto$BannerMessage2) {
            content.mergeBanner(bannerMessage2);
        }

        static void access$400(com.google.firebase.inappmessaging.MessagesProto.Content messagesProto$Content) {
            content.clearBanner();
        }

        static void access$500(com.google.firebase.inappmessaging.MessagesProto.Content messagesProto$Content, com.google.firebase.inappmessaging.MessagesProto.ModalMessage messagesProto$ModalMessage2) {
            content.setModal(modalMessage2);
        }

        static void access$600(com.google.firebase.inappmessaging.MessagesProto.Content messagesProto$Content, com.google.firebase.inappmessaging.MessagesProto.ModalMessage messagesProto$ModalMessage2) {
            content.mergeModal(modalMessage2);
        }

        static void access$700(com.google.firebase.inappmessaging.MessagesProto.Content messagesProto$Content) {
            content.clearModal();
        }

        static void access$800(com.google.firebase.inappmessaging.MessagesProto.Content messagesProto$Content, com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage messagesProto$ImageOnlyMessage2) {
            content.setImageOnly(imageOnlyMessage2);
        }

        static void access$900(com.google.firebase.inappmessaging.MessagesProto.Content messagesProto$Content, com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage messagesProto$ImageOnlyMessage2) {
            content.mergeImageOnly(imageOnlyMessage2);
        }

        private void clearBanner() {
            int messageDetailsCase_;
            if (this.messageDetailsCase_ == 1) {
                this.messageDetailsCase_ = 0;
                this.messageDetails_ = 0;
            }
        }

        private void clearCard() {
            int messageDetailsCase_;
            if (this.messageDetailsCase_ == 4) {
                this.messageDetailsCase_ = 0;
                this.messageDetails_ = 0;
            }
        }

        private void clearImageOnly() {
            int messageDetailsCase_;
            if (this.messageDetailsCase_ == 3) {
                this.messageDetailsCase_ = 0;
                this.messageDetails_ = 0;
            }
        }

        private void clearMessageDetails() {
            this.messageDetailsCase_ = 0;
            this.messageDetails_ = 0;
        }

        private void clearModal() {
            int messageDetailsCase_;
            if (this.messageDetailsCase_ == 2) {
                this.messageDetailsCase_ = 0;
                this.messageDetails_ = 0;
            }
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Content getDefaultInstance() {
            return MessagesProto.Content.DEFAULT_INSTANCE;
        }

        private void mergeBanner(com.google.firebase.inappmessaging.MessagesProto.BannerMessage messagesProto$BannerMessage) {
            int messageDetailsCase_;
            com.google.firebase.inappmessaging.MessagesProto.BannerMessage defaultInstance;
            z obj4;
            bannerMessage.getClass();
            final int i = 1;
            if (this.messageDetailsCase_ == i && this.messageDetails_ != MessagesProto.BannerMessage.getDefaultInstance()) {
                if (this.messageDetails_ != MessagesProto.BannerMessage.getDefaultInstance()) {
                    this.messageDetails_ = (MessagesProto.BannerMessage.Builder)MessagesProto.BannerMessage.newBuilder((MessagesProto.BannerMessage)this.messageDetails_).mergeFrom(bannerMessage).buildPartial();
                } else {
                    this.messageDetails_ = bannerMessage;
                }
            } else {
            }
            this.messageDetailsCase_ = i;
        }

        private void mergeCard(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage) {
            int messageDetailsCase_;
            com.google.firebase.inappmessaging.MessagesProto.CardMessage defaultInstance;
            z obj4;
            cardMessage.getClass();
            final int i = 4;
            if (this.messageDetailsCase_ == i && this.messageDetails_ != MessagesProto.CardMessage.getDefaultInstance()) {
                if (this.messageDetails_ != MessagesProto.CardMessage.getDefaultInstance()) {
                    this.messageDetails_ = (MessagesProto.CardMessage.Builder)MessagesProto.CardMessage.newBuilder((MessagesProto.CardMessage)this.messageDetails_).mergeFrom(cardMessage).buildPartial();
                } else {
                    this.messageDetails_ = cardMessage;
                }
            } else {
            }
            this.messageDetailsCase_ = i;
        }

        private void mergeImageOnly(com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage messagesProto$ImageOnlyMessage) {
            int messageDetailsCase_;
            com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage defaultInstance;
            z obj4;
            imageOnlyMessage.getClass();
            final int i = 3;
            if (this.messageDetailsCase_ == i && this.messageDetails_ != MessagesProto.ImageOnlyMessage.getDefaultInstance()) {
                if (this.messageDetails_ != MessagesProto.ImageOnlyMessage.getDefaultInstance()) {
                    this.messageDetails_ = (MessagesProto.ImageOnlyMessage.Builder)MessagesProto.ImageOnlyMessage.newBuilder((MessagesProto.ImageOnlyMessage)this.messageDetails_).mergeFrom(imageOnlyMessage).buildPartial();
                } else {
                    this.messageDetails_ = imageOnlyMessage;
                }
            } else {
            }
            this.messageDetailsCase_ = i;
        }

        private void mergeModal(com.google.firebase.inappmessaging.MessagesProto.ModalMessage messagesProto$ModalMessage) {
            int messageDetailsCase_;
            com.google.firebase.inappmessaging.MessagesProto.ModalMessage defaultInstance;
            z obj4;
            modalMessage.getClass();
            final int i = 2;
            if (this.messageDetailsCase_ == i && this.messageDetails_ != MessagesProto.ModalMessage.getDefaultInstance()) {
                if (this.messageDetails_ != MessagesProto.ModalMessage.getDefaultInstance()) {
                    this.messageDetails_ = (MessagesProto.ModalMessage.Builder)MessagesProto.ModalMessage.newBuilder((MessagesProto.ModalMessage)this.messageDetails_).mergeFrom(modalMessage).buildPartial();
                } else {
                    this.messageDetails_ = modalMessage;
                }
            } else {
            }
            this.messageDetailsCase_ = i;
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Content.Builder newBuilder() {
            return (MessagesProto.Content.Builder)MessagesProto.Content.DEFAULT_INSTANCE.createBuilder();
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Content.Builder newBuilder(com.google.firebase.inappmessaging.MessagesProto.Content messagesProto$Content) {
            return (MessagesProto.Content.Builder)MessagesProto.Content.DEFAULT_INSTANCE.createBuilder(content);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Content parseDelimitedFrom(InputStream inputStream) {
            return (MessagesProto.Content)z.parseDelimitedFrom(MessagesProto.Content.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Content parseDelimitedFrom(InputStream inputStream, q q2) {
            return (MessagesProto.Content)z.parseDelimitedFrom(MessagesProto.Content.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Content parseFrom(j j) {
            return (MessagesProto.Content)z.parseFrom(MessagesProto.Content.DEFAULT_INSTANCE, j);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Content parseFrom(j j, q q2) {
            return (MessagesProto.Content)z.parseFrom(MessagesProto.Content.DEFAULT_INSTANCE, j, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Content parseFrom(k k) {
            return (MessagesProto.Content)z.parseFrom(MessagesProto.Content.DEFAULT_INSTANCE, k);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Content parseFrom(k k, q q2) {
            return (MessagesProto.Content)z.parseFrom(MessagesProto.Content.DEFAULT_INSTANCE, k, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Content parseFrom(InputStream inputStream) {
            return (MessagesProto.Content)z.parseFrom(MessagesProto.Content.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Content parseFrom(InputStream inputStream, q q2) {
            return (MessagesProto.Content)z.parseFrom(MessagesProto.Content.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Content parseFrom(ByteBuffer byteBuffer) {
            return (MessagesProto.Content)z.parseFrom(MessagesProto.Content.DEFAULT_INSTANCE, byteBuffer);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Content parseFrom(ByteBuffer byteBuffer, q q2) {
            return (MessagesProto.Content)z.parseFrom(MessagesProto.Content.DEFAULT_INSTANCE, byteBuffer, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Content parseFrom(byte[] bArr) {
            return (MessagesProto.Content)z.parseFrom(MessagesProto.Content.DEFAULT_INSTANCE, bArr);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Content parseFrom(byte[] bArr, q q2) {
            return (MessagesProto.Content)z.parseFrom(MessagesProto.Content.DEFAULT_INSTANCE, bArr, q2);
        }

        public static d1<com.google.firebase.inappmessaging.MessagesProto.Content> parser() {
            return MessagesProto.Content.DEFAULT_INSTANCE.getParserForType();
        }

        private void setBanner(com.google.firebase.inappmessaging.MessagesProto.BannerMessage messagesProto$BannerMessage) {
            bannerMessage.getClass();
            this.messageDetails_ = bannerMessage;
            this.messageDetailsCase_ = 1;
        }

        private void setCard(com.google.firebase.inappmessaging.MessagesProto.CardMessage messagesProto$CardMessage) {
            cardMessage.getClass();
            this.messageDetails_ = cardMessage;
            this.messageDetailsCase_ = 4;
        }

        private void setImageOnly(com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage messagesProto$ImageOnlyMessage) {
            imageOnlyMessage.getClass();
            this.messageDetails_ = imageOnlyMessage;
            this.messageDetailsCase_ = 3;
        }

        private void setModal(com.google.firebase.inappmessaging.MessagesProto.ModalMessage messagesProto$ModalMessage) {
            modalMessage.getClass();
            this.messageDetails_ = modalMessage;
            this.messageDetailsCase_ = 2;
        }

        @Override // com.google.protobuf.z
        protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
            d1 obj2;
            int obj3;
            int obj4;
            obj3 = 1;
            obj4 = 0;
            switch (obj2) {
                case 1:
                    obj2 = new MessagesProto.Content();
                    return obj2;
                case 2:
                    obj2 = new MessagesProto.Content.Builder(obj4);
                    return obj2;
                case 3:
                    obj2 = new Object[6];
                    obj2[obj3] = "messageDetailsCase_";
                    obj2[2] = MessagesProto.BannerMessage.class;
                    obj2[3] = MessagesProto.ModalMessage.class;
                    obj2[4] = MessagesProto.ImageOnlyMessage.class;
                    obj2[5] = MessagesProto.CardMessage.class;
                    return z.newMessageInfo(MessagesProto.Content.DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000", obj2);
                case 4:
                    return MessagesProto.Content.DEFAULT_INSTANCE;
                case 5:
                    return obj2;
                case 6:
                    return Byte.valueOf(obj3);
                case 7:
                    return obj4;
                default:
                    obj2 = new UnsupportedOperationException();
                    throw obj2;
            }
            obj3 = MessagesProto.Content.class;
            synchronized (obj3) {
                obj2 = new z.b(MessagesProto.Content.DEFAULT_INSTANCE);
                MessagesProto.Content.PARSER = obj2;
            }
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.MessagesProto.BannerMessage getBanner() {
            if (this.messageDetailsCase_ == 1) {
                return (MessagesProto.BannerMessage)this.messageDetails_;
            }
            return MessagesProto.BannerMessage.getDefaultInstance();
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.MessagesProto.CardMessage getCard() {
            if (this.messageDetailsCase_ == 4) {
                return (MessagesProto.CardMessage)this.messageDetails_;
            }
            return MessagesProto.CardMessage.getDefaultInstance();
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage getImageOnly() {
            if (this.messageDetailsCase_ == 3) {
                return (MessagesProto.ImageOnlyMessage)this.messageDetails_;
            }
            return MessagesProto.ImageOnlyMessage.getDefaultInstance();
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.MessagesProto.Content.MessageDetailsCase getMessageDetailsCase() {
            return MessagesProto.Content.MessageDetailsCase.forNumber(this.messageDetailsCase_);
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.MessagesProto.ModalMessage getModal() {
            if (this.messageDetailsCase_ == 2) {
                return (MessagesProto.ModalMessage)this.messageDetails_;
            }
            return MessagesProto.ModalMessage.getDefaultInstance();
        }

        @Override // com.google.protobuf.z
        public boolean hasBanner() {
            int i;
            if (this.messageDetailsCase_ == 1) {
            } else {
                i = 0;
            }
            return i;
        }

        @Override // com.google.protobuf.z
        public boolean hasCard() {
            int i;
            i = this.messageDetailsCase_ == 4 ? 1 : 0;
            return i;
        }

        @Override // com.google.protobuf.z
        public boolean hasImageOnly() {
            int i;
            i = this.messageDetailsCase_ == 3 ? 1 : 0;
            return i;
        }

        @Override // com.google.protobuf.z
        public boolean hasModal() {
            int i;
            i = this.messageDetailsCase_ == 2 ? 1 : 0;
            return i;
        }
    }

    public static final class ImageOnlyMessage extends z<com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage, com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage.Builder> implements com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessageOrBuilder {

        public static final int ACTION_FIELD_NUMBER = 2;
        private static final com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage DEFAULT_INSTANCE = null;
        public static final int IMAGE_URL_FIELD_NUMBER = 1;
        private static volatile d1<com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage> PARSER;
        private com.google.firebase.inappmessaging.MessagesProto.Action action_;
        private String imageUrl_;
        static {
            MessagesProto.ImageOnlyMessage imageOnlyMessage = new MessagesProto.ImageOnlyMessage();
            MessagesProto.ImageOnlyMessage.DEFAULT_INSTANCE = imageOnlyMessage;
            z.registerDefaultInstance(MessagesProto.ImageOnlyMessage.class, imageOnlyMessage);
        }

        private ImageOnlyMessage() {
            super();
            this.imageUrl_ = "";
        }

        static com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage access$4400() {
            return MessagesProto.ImageOnlyMessage.DEFAULT_INSTANCE;
        }

        static void access$4500(com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage messagesProto$ImageOnlyMessage, String string2) {
            imageOnlyMessage.setImageUrl(string2);
        }

        static void access$4600(com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage messagesProto$ImageOnlyMessage) {
            imageOnlyMessage.clearImageUrl();
        }

        static void access$4700(com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage messagesProto$ImageOnlyMessage, j j2) {
            imageOnlyMessage.setImageUrlBytes(j2);
        }

        static void access$4800(com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage messagesProto$ImageOnlyMessage, com.google.firebase.inappmessaging.MessagesProto.Action messagesProto$Action2) {
            imageOnlyMessage.setAction(action2);
        }

        static void access$4900(com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage messagesProto$ImageOnlyMessage, com.google.firebase.inappmessaging.MessagesProto.Action messagesProto$Action2) {
            imageOnlyMessage.mergeAction(action2);
        }

        static void access$5000(com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage messagesProto$ImageOnlyMessage) {
            imageOnlyMessage.clearAction();
        }

        private void clearAction() {
            this.action_ = 0;
        }

        private void clearImageUrl() {
            this.imageUrl_ = MessagesProto.ImageOnlyMessage.getDefaultInstance().getImageUrl();
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage getDefaultInstance() {
            return MessagesProto.ImageOnlyMessage.DEFAULT_INSTANCE;
        }

        private void mergeAction(com.google.firebase.inappmessaging.MessagesProto.Action messagesProto$Action) {
            Object action_;
            com.google.firebase.inappmessaging.MessagesProto.Action defaultInstance;
            z obj3;
            action.getClass();
            action_ = this.action_;
            if (action_ != null && action_ != MessagesProto.Action.getDefaultInstance()) {
                if (action_ != MessagesProto.Action.getDefaultInstance()) {
                    this.action_ = (MessagesProto.Action)(MessagesProto.Action.Builder)MessagesProto.Action.newBuilder(this.action_).mergeFrom(action).buildPartial();
                } else {
                    this.action_ = action;
                }
            } else {
            }
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage.Builder newBuilder() {
            return (MessagesProto.ImageOnlyMessage.Builder)MessagesProto.ImageOnlyMessage.DEFAULT_INSTANCE.createBuilder();
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage.Builder newBuilder(com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage messagesProto$ImageOnlyMessage) {
            return (MessagesProto.ImageOnlyMessage.Builder)MessagesProto.ImageOnlyMessage.DEFAULT_INSTANCE.createBuilder(imageOnlyMessage);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage parseDelimitedFrom(InputStream inputStream) {
            return (MessagesProto.ImageOnlyMessage)z.parseDelimitedFrom(MessagesProto.ImageOnlyMessage.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage parseDelimitedFrom(InputStream inputStream, q q2) {
            return (MessagesProto.ImageOnlyMessage)z.parseDelimitedFrom(MessagesProto.ImageOnlyMessage.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage parseFrom(j j) {
            return (MessagesProto.ImageOnlyMessage)z.parseFrom(MessagesProto.ImageOnlyMessage.DEFAULT_INSTANCE, j);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage parseFrom(j j, q q2) {
            return (MessagesProto.ImageOnlyMessage)z.parseFrom(MessagesProto.ImageOnlyMessage.DEFAULT_INSTANCE, j, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage parseFrom(k k) {
            return (MessagesProto.ImageOnlyMessage)z.parseFrom(MessagesProto.ImageOnlyMessage.DEFAULT_INSTANCE, k);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage parseFrom(k k, q q2) {
            return (MessagesProto.ImageOnlyMessage)z.parseFrom(MessagesProto.ImageOnlyMessage.DEFAULT_INSTANCE, k, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage parseFrom(InputStream inputStream) {
            return (MessagesProto.ImageOnlyMessage)z.parseFrom(MessagesProto.ImageOnlyMessage.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage parseFrom(InputStream inputStream, q q2) {
            return (MessagesProto.ImageOnlyMessage)z.parseFrom(MessagesProto.ImageOnlyMessage.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage parseFrom(ByteBuffer byteBuffer) {
            return (MessagesProto.ImageOnlyMessage)z.parseFrom(MessagesProto.ImageOnlyMessage.DEFAULT_INSTANCE, byteBuffer);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage parseFrom(ByteBuffer byteBuffer, q q2) {
            return (MessagesProto.ImageOnlyMessage)z.parseFrom(MessagesProto.ImageOnlyMessage.DEFAULT_INSTANCE, byteBuffer, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage parseFrom(byte[] bArr) {
            return (MessagesProto.ImageOnlyMessage)z.parseFrom(MessagesProto.ImageOnlyMessage.DEFAULT_INSTANCE, bArr);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage parseFrom(byte[] bArr, q q2) {
            return (MessagesProto.ImageOnlyMessage)z.parseFrom(MessagesProto.ImageOnlyMessage.DEFAULT_INSTANCE, bArr, q2);
        }

        public static d1<com.google.firebase.inappmessaging.MessagesProto.ImageOnlyMessage> parser() {
            return MessagesProto.ImageOnlyMessage.DEFAULT_INSTANCE.getParserForType();
        }

        private void setAction(com.google.firebase.inappmessaging.MessagesProto.Action messagesProto$Action) {
            action.getClass();
            this.action_ = action;
        }

        private void setImageUrl(String string) {
            string.getClass();
            this.imageUrl_ = string;
        }

        private void setImageUrlBytes(j j) {
            a.checkByteStringIsUtf8(j);
            this.imageUrl_ = j.R();
        }

        @Override // com.google.protobuf.z
        protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
            d1 obj2;
            int obj3;
            int obj4;
            obj3 = 1;
            obj4 = 0;
            switch (obj2) {
                case 1:
                    obj2 = new MessagesProto.ImageOnlyMessage();
                    return obj2;
                case 2:
                    obj2 = new MessagesProto.ImageOnlyMessage.Builder(obj4);
                    return obj2;
                case 3:
                    obj2 = new Object[2];
                    obj2[obj3] = "action_";
                    return z.newMessageInfo(MessagesProto.ImageOnlyMessage.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", obj2);
                case 4:
                    return MessagesProto.ImageOnlyMessage.DEFAULT_INSTANCE;
                case 5:
                    return obj2;
                case 6:
                    return Byte.valueOf(obj3);
                case 7:
                    return obj4;
                default:
                    obj2 = new UnsupportedOperationException();
                    throw obj2;
            }
            obj3 = MessagesProto.ImageOnlyMessage.class;
            synchronized (obj3) {
                obj2 = new z.b(MessagesProto.ImageOnlyMessage.DEFAULT_INSTANCE);
                MessagesProto.ImageOnlyMessage.PARSER = obj2;
            }
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.MessagesProto.Action getAction() {
            com.google.firebase.inappmessaging.MessagesProto.Action defaultInstance;
            if (this.action_ == null) {
                defaultInstance = MessagesProto.Action.getDefaultInstance();
            }
            return defaultInstance;
        }

        @Override // com.google.protobuf.z
        public String getImageUrl() {
            return this.imageUrl_;
        }

        @Override // com.google.protobuf.z
        public j getImageUrlBytes() {
            return j.u(this.imageUrl_);
        }

        @Override // com.google.protobuf.z
        public boolean hasAction() {
            int i;
            i = this.action_ != null ? 1 : 0;
            return i;
        }
    }

    public static final class ModalMessage extends z<com.google.firebase.inappmessaging.MessagesProto.ModalMessage, com.google.firebase.inappmessaging.MessagesProto.ModalMessage.Builder> implements com.google.firebase.inappmessaging.MessagesProto.ModalMessageOrBuilder {

        public static final int ACTION_BUTTON_FIELD_NUMBER = 4;
        public static final int ACTION_FIELD_NUMBER = 5;
        public static final int BACKGROUND_HEX_COLOR_FIELD_NUMBER = 6;
        public static final int BODY_FIELD_NUMBER = 2;
        private static final com.google.firebase.inappmessaging.MessagesProto.ModalMessage DEFAULT_INSTANCE = null;
        public static final int IMAGE_URL_FIELD_NUMBER = 3;
        private static volatile d1<com.google.firebase.inappmessaging.MessagesProto.ModalMessage> PARSER = null;
        public static final int TITLE_FIELD_NUMBER = 1;
        private com.google.firebase.inappmessaging.MessagesProto.Button actionButton_;
        private com.google.firebase.inappmessaging.MessagesProto.Action action_;
        private String backgroundHexColor_;
        private com.google.firebase.inappmessaging.MessagesProto.Text body_;
        private String imageUrl_;
        private com.google.firebase.inappmessaging.MessagesProto.Text title_;
        static {
            MessagesProto.ModalMessage modalMessage = new MessagesProto.ModalMessage();
            MessagesProto.ModalMessage.DEFAULT_INSTANCE = modalMessage;
            z.registerDefaultInstance(MessagesProto.ModalMessage.class, modalMessage);
        }

        private ModalMessage() {
            super();
            final String str = "";
            this.imageUrl_ = str;
            this.backgroundHexColor_ = str;
        }

        static com.google.firebase.inappmessaging.MessagesProto.ModalMessage access$6900() {
            return MessagesProto.ModalMessage.DEFAULT_INSTANCE;
        }

        static void access$7000(com.google.firebase.inappmessaging.MessagesProto.ModalMessage messagesProto$ModalMessage, com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text2) {
            modalMessage.setTitle(text2);
        }

        static void access$7100(com.google.firebase.inappmessaging.MessagesProto.ModalMessage messagesProto$ModalMessage, com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text2) {
            modalMessage.mergeTitle(text2);
        }

        static void access$7200(com.google.firebase.inappmessaging.MessagesProto.ModalMessage messagesProto$ModalMessage) {
            modalMessage.clearTitle();
        }

        static void access$7300(com.google.firebase.inappmessaging.MessagesProto.ModalMessage messagesProto$ModalMessage, com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text2) {
            modalMessage.setBody(text2);
        }

        static void access$7400(com.google.firebase.inappmessaging.MessagesProto.ModalMessage messagesProto$ModalMessage, com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text2) {
            modalMessage.mergeBody(text2);
        }

        static void access$7500(com.google.firebase.inappmessaging.MessagesProto.ModalMessage messagesProto$ModalMessage) {
            modalMessage.clearBody();
        }

        static void access$7600(com.google.firebase.inappmessaging.MessagesProto.ModalMessage messagesProto$ModalMessage, String string2) {
            modalMessage.setImageUrl(string2);
        }

        static void access$7700(com.google.firebase.inappmessaging.MessagesProto.ModalMessage messagesProto$ModalMessage) {
            modalMessage.clearImageUrl();
        }

        static void access$7800(com.google.firebase.inappmessaging.MessagesProto.ModalMessage messagesProto$ModalMessage, j j2) {
            modalMessage.setImageUrlBytes(j2);
        }

        static void access$7900(com.google.firebase.inappmessaging.MessagesProto.ModalMessage messagesProto$ModalMessage, com.google.firebase.inappmessaging.MessagesProto.Button messagesProto$Button2) {
            modalMessage.setActionButton(button2);
        }

        static void access$8000(com.google.firebase.inappmessaging.MessagesProto.ModalMessage messagesProto$ModalMessage, com.google.firebase.inappmessaging.MessagesProto.Button messagesProto$Button2) {
            modalMessage.mergeActionButton(button2);
        }

        static void access$8100(com.google.firebase.inappmessaging.MessagesProto.ModalMessage messagesProto$ModalMessage) {
            modalMessage.clearActionButton();
        }

        static void access$8200(com.google.firebase.inappmessaging.MessagesProto.ModalMessage messagesProto$ModalMessage, com.google.firebase.inappmessaging.MessagesProto.Action messagesProto$Action2) {
            modalMessage.setAction(action2);
        }

        static void access$8300(com.google.firebase.inappmessaging.MessagesProto.ModalMessage messagesProto$ModalMessage, com.google.firebase.inappmessaging.MessagesProto.Action messagesProto$Action2) {
            modalMessage.mergeAction(action2);
        }

        static void access$8400(com.google.firebase.inappmessaging.MessagesProto.ModalMessage messagesProto$ModalMessage) {
            modalMessage.clearAction();
        }

        static void access$8500(com.google.firebase.inappmessaging.MessagesProto.ModalMessage messagesProto$ModalMessage, String string2) {
            modalMessage.setBackgroundHexColor(string2);
        }

        static void access$8600(com.google.firebase.inappmessaging.MessagesProto.ModalMessage messagesProto$ModalMessage) {
            modalMessage.clearBackgroundHexColor();
        }

        static void access$8700(com.google.firebase.inappmessaging.MessagesProto.ModalMessage messagesProto$ModalMessage, j j2) {
            modalMessage.setBackgroundHexColorBytes(j2);
        }

        private void clearAction() {
            this.action_ = 0;
        }

        private void clearActionButton() {
            this.actionButton_ = 0;
        }

        private void clearBackgroundHexColor() {
            this.backgroundHexColor_ = MessagesProto.ModalMessage.getDefaultInstance().getBackgroundHexColor();
        }

        private void clearBody() {
            this.body_ = 0;
        }

        private void clearImageUrl() {
            this.imageUrl_ = MessagesProto.ModalMessage.getDefaultInstance().getImageUrl();
        }

        private void clearTitle() {
            this.title_ = 0;
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ModalMessage getDefaultInstance() {
            return MessagesProto.ModalMessage.DEFAULT_INSTANCE;
        }

        private void mergeAction(com.google.firebase.inappmessaging.MessagesProto.Action messagesProto$Action) {
            Object action_;
            com.google.firebase.inappmessaging.MessagesProto.Action defaultInstance;
            z obj3;
            action.getClass();
            action_ = this.action_;
            if (action_ != null && action_ != MessagesProto.Action.getDefaultInstance()) {
                if (action_ != MessagesProto.Action.getDefaultInstance()) {
                    this.action_ = (MessagesProto.Action)(MessagesProto.Action.Builder)MessagesProto.Action.newBuilder(this.action_).mergeFrom(action).buildPartial();
                } else {
                    this.action_ = action;
                }
            } else {
            }
        }

        private void mergeActionButton(com.google.firebase.inappmessaging.MessagesProto.Button messagesProto$Button) {
            Object actionButton_;
            com.google.firebase.inappmessaging.MessagesProto.Button defaultInstance;
            z obj3;
            button.getClass();
            actionButton_ = this.actionButton_;
            if (actionButton_ != null && actionButton_ != MessagesProto.Button.getDefaultInstance()) {
                if (actionButton_ != MessagesProto.Button.getDefaultInstance()) {
                    this.actionButton_ = (MessagesProto.Button)(MessagesProto.Button.Builder)MessagesProto.Button.newBuilder(this.actionButton_).mergeFrom(button).buildPartial();
                } else {
                    this.actionButton_ = button;
                }
            } else {
            }
        }

        private void mergeBody(com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text) {
            Object builder;
            com.google.firebase.inappmessaging.MessagesProto.Text defaultInstance;
            z obj3;
            text.getClass();
            builder = this.body_;
            if (builder != null && builder != MessagesProto.Text.getDefaultInstance()) {
                if (builder != MessagesProto.Text.getDefaultInstance()) {
                    this.body_ = (MessagesProto.Text)(MessagesProto.Text.Builder)MessagesProto.Text.newBuilder(this.body_).mergeFrom(text).buildPartial();
                } else {
                    this.body_ = text;
                }
            } else {
            }
        }

        private void mergeTitle(com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text) {
            Object builder;
            com.google.firebase.inappmessaging.MessagesProto.Text defaultInstance;
            z obj3;
            text.getClass();
            builder = this.title_;
            if (builder != null && builder != MessagesProto.Text.getDefaultInstance()) {
                if (builder != MessagesProto.Text.getDefaultInstance()) {
                    this.title_ = (MessagesProto.Text)(MessagesProto.Text.Builder)MessagesProto.Text.newBuilder(this.title_).mergeFrom(text).buildPartial();
                } else {
                    this.title_ = text;
                }
            } else {
            }
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ModalMessage.Builder newBuilder() {
            return (MessagesProto.ModalMessage.Builder)MessagesProto.ModalMessage.DEFAULT_INSTANCE.createBuilder();
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ModalMessage.Builder newBuilder(com.google.firebase.inappmessaging.MessagesProto.ModalMessage messagesProto$ModalMessage) {
            return (MessagesProto.ModalMessage.Builder)MessagesProto.ModalMessage.DEFAULT_INSTANCE.createBuilder(modalMessage);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ModalMessage parseDelimitedFrom(InputStream inputStream) {
            return (MessagesProto.ModalMessage)z.parseDelimitedFrom(MessagesProto.ModalMessage.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ModalMessage parseDelimitedFrom(InputStream inputStream, q q2) {
            return (MessagesProto.ModalMessage)z.parseDelimitedFrom(MessagesProto.ModalMessage.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ModalMessage parseFrom(j j) {
            return (MessagesProto.ModalMessage)z.parseFrom(MessagesProto.ModalMessage.DEFAULT_INSTANCE, j);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ModalMessage parseFrom(j j, q q2) {
            return (MessagesProto.ModalMessage)z.parseFrom(MessagesProto.ModalMessage.DEFAULT_INSTANCE, j, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ModalMessage parseFrom(k k) {
            return (MessagesProto.ModalMessage)z.parseFrom(MessagesProto.ModalMessage.DEFAULT_INSTANCE, k);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ModalMessage parseFrom(k k, q q2) {
            return (MessagesProto.ModalMessage)z.parseFrom(MessagesProto.ModalMessage.DEFAULT_INSTANCE, k, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ModalMessage parseFrom(InputStream inputStream) {
            return (MessagesProto.ModalMessage)z.parseFrom(MessagesProto.ModalMessage.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ModalMessage parseFrom(InputStream inputStream, q q2) {
            return (MessagesProto.ModalMessage)z.parseFrom(MessagesProto.ModalMessage.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ModalMessage parseFrom(ByteBuffer byteBuffer) {
            return (MessagesProto.ModalMessage)z.parseFrom(MessagesProto.ModalMessage.DEFAULT_INSTANCE, byteBuffer);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ModalMessage parseFrom(ByteBuffer byteBuffer, q q2) {
            return (MessagesProto.ModalMessage)z.parseFrom(MessagesProto.ModalMessage.DEFAULT_INSTANCE, byteBuffer, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ModalMessage parseFrom(byte[] bArr) {
            return (MessagesProto.ModalMessage)z.parseFrom(MessagesProto.ModalMessage.DEFAULT_INSTANCE, bArr);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.ModalMessage parseFrom(byte[] bArr, q q2) {
            return (MessagesProto.ModalMessage)z.parseFrom(MessagesProto.ModalMessage.DEFAULT_INSTANCE, bArr, q2);
        }

        public static d1<com.google.firebase.inappmessaging.MessagesProto.ModalMessage> parser() {
            return MessagesProto.ModalMessage.DEFAULT_INSTANCE.getParserForType();
        }

        private void setAction(com.google.firebase.inappmessaging.MessagesProto.Action messagesProto$Action) {
            action.getClass();
            this.action_ = action;
        }

        private void setActionButton(com.google.firebase.inappmessaging.MessagesProto.Button messagesProto$Button) {
            button.getClass();
            this.actionButton_ = button;
        }

        private void setBackgroundHexColor(String string) {
            string.getClass();
            this.backgroundHexColor_ = string;
        }

        private void setBackgroundHexColorBytes(j j) {
            a.checkByteStringIsUtf8(j);
            this.backgroundHexColor_ = j.R();
        }

        private void setBody(com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text) {
            text.getClass();
            this.body_ = text;
        }

        private void setImageUrl(String string) {
            string.getClass();
            this.imageUrl_ = string;
        }

        private void setImageUrlBytes(j j) {
            a.checkByteStringIsUtf8(j);
            this.imageUrl_ = j.R();
        }

        private void setTitle(com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text) {
            text.getClass();
            this.title_ = text;
        }

        @Override // com.google.protobuf.z
        protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
            d1 obj2;
            int obj3;
            int obj4;
            obj3 = 1;
            obj4 = 0;
            switch (obj2) {
                case 1:
                    obj2 = new MessagesProto.ModalMessage();
                    return obj2;
                case 2:
                    obj2 = new MessagesProto.ModalMessage.Builder(obj4);
                    return obj2;
                case 3:
                    obj2 = new Object[6];
                    obj2[obj3] = "body_";
                    obj2[2] = "imageUrl_";
                    obj2[3] = "actionButton_";
                    obj2[4] = "action_";
                    obj2[5] = "backgroundHexColor_";
                    return z.newMessageInfo(MessagesProto.ModalMessage.DEFAULT_INSTANCE, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001\t\u0002\t\u0003Ȉ\u0004\t\u0005\t\u0006Ȉ", obj2);
                case 4:
                    return MessagesProto.ModalMessage.DEFAULT_INSTANCE;
                case 5:
                    return obj2;
                case 6:
                    return Byte.valueOf(obj3);
                case 7:
                    return obj4;
                default:
                    obj2 = new UnsupportedOperationException();
                    throw obj2;
            }
            obj3 = MessagesProto.ModalMessage.class;
            synchronized (obj3) {
                obj2 = new z.b(MessagesProto.ModalMessage.DEFAULT_INSTANCE);
                MessagesProto.ModalMessage.PARSER = obj2;
            }
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.MessagesProto.Action getAction() {
            com.google.firebase.inappmessaging.MessagesProto.Action defaultInstance;
            if (this.action_ == null) {
                defaultInstance = MessagesProto.Action.getDefaultInstance();
            }
            return defaultInstance;
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.MessagesProto.Button getActionButton() {
            com.google.firebase.inappmessaging.MessagesProto.Button defaultInstance;
            if (this.actionButton_ == null) {
                defaultInstance = MessagesProto.Button.getDefaultInstance();
            }
            return defaultInstance;
        }

        @Override // com.google.protobuf.z
        public String getBackgroundHexColor() {
            return this.backgroundHexColor_;
        }

        @Override // com.google.protobuf.z
        public j getBackgroundHexColorBytes() {
            return j.u(this.backgroundHexColor_);
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.MessagesProto.Text getBody() {
            com.google.firebase.inappmessaging.MessagesProto.Text defaultInstance;
            if (this.body_ == null) {
                defaultInstance = MessagesProto.Text.getDefaultInstance();
            }
            return defaultInstance;
        }

        @Override // com.google.protobuf.z
        public String getImageUrl() {
            return this.imageUrl_;
        }

        @Override // com.google.protobuf.z
        public j getImageUrlBytes() {
            return j.u(this.imageUrl_);
        }

        @Override // com.google.protobuf.z
        public com.google.firebase.inappmessaging.MessagesProto.Text getTitle() {
            com.google.firebase.inappmessaging.MessagesProto.Text defaultInstance;
            if (this.title_ == null) {
                defaultInstance = MessagesProto.Text.getDefaultInstance();
            }
            return defaultInstance;
        }

        @Override // com.google.protobuf.z
        public boolean hasAction() {
            int i;
            i = this.action_ != null ? 1 : 0;
            return i;
        }

        @Override // com.google.protobuf.z
        public boolean hasActionButton() {
            int i;
            i = this.actionButton_ != null ? 1 : 0;
            return i;
        }

        @Override // com.google.protobuf.z
        public boolean hasBody() {
            int i;
            i = this.body_ != null ? 1 : 0;
            return i;
        }

        @Override // com.google.protobuf.z
        public boolean hasTitle() {
            int i;
            i = this.title_ != null ? 1 : 0;
            return i;
        }
    }

    public static final class Text extends z<com.google.firebase.inappmessaging.MessagesProto.Text, com.google.firebase.inappmessaging.MessagesProto.Text.Builder> implements com.google.firebase.inappmessaging.MessagesProto.TextOrBuilder {

        private static final com.google.firebase.inappmessaging.MessagesProto.Text DEFAULT_INSTANCE = null;
        public static final int HEX_COLOR_FIELD_NUMBER = 2;
        private static volatile d1<com.google.firebase.inappmessaging.MessagesProto.Text> PARSER = null;
        public static final int TEXT_FIELD_NUMBER = 1;
        private String hexColor_;
        private String text_;
        static {
            MessagesProto.Text text = new MessagesProto.Text();
            MessagesProto.Text.DEFAULT_INSTANCE = text;
            z.registerDefaultInstance(MessagesProto.Text.class, text);
        }

        private Text() {
            super();
            final String str = "";
            this.text_ = str;
            this.hexColor_ = str;
        }

        static com.google.firebase.inappmessaging.MessagesProto.Text access$8900() {
            return MessagesProto.Text.DEFAULT_INSTANCE;
        }

        static void access$9000(com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text, String string2) {
            text.setText(string2);
        }

        static void access$9100(com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text) {
            text.clearText();
        }

        static void access$9200(com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text, j j2) {
            text.setTextBytes(j2);
        }

        static void access$9300(com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text, String string2) {
            text.setHexColor(string2);
        }

        static void access$9400(com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text) {
            text.clearHexColor();
        }

        static void access$9500(com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text, j j2) {
            text.setHexColorBytes(j2);
        }

        private void clearHexColor() {
            this.hexColor_ = MessagesProto.Text.getDefaultInstance().getHexColor();
        }

        private void clearText() {
            this.text_ = MessagesProto.Text.getDefaultInstance().getText();
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Text getDefaultInstance() {
            return MessagesProto.Text.DEFAULT_INSTANCE;
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Text.Builder newBuilder() {
            return (MessagesProto.Text.Builder)MessagesProto.Text.DEFAULT_INSTANCE.createBuilder();
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Text.Builder newBuilder(com.google.firebase.inappmessaging.MessagesProto.Text messagesProto$Text) {
            return (MessagesProto.Text.Builder)MessagesProto.Text.DEFAULT_INSTANCE.createBuilder(text);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Text parseDelimitedFrom(InputStream inputStream) {
            return (MessagesProto.Text)z.parseDelimitedFrom(MessagesProto.Text.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Text parseDelimitedFrom(InputStream inputStream, q q2) {
            return (MessagesProto.Text)z.parseDelimitedFrom(MessagesProto.Text.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Text parseFrom(j j) {
            return (MessagesProto.Text)z.parseFrom(MessagesProto.Text.DEFAULT_INSTANCE, j);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Text parseFrom(j j, q q2) {
            return (MessagesProto.Text)z.parseFrom(MessagesProto.Text.DEFAULT_INSTANCE, j, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Text parseFrom(k k) {
            return (MessagesProto.Text)z.parseFrom(MessagesProto.Text.DEFAULT_INSTANCE, k);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Text parseFrom(k k, q q2) {
            return (MessagesProto.Text)z.parseFrom(MessagesProto.Text.DEFAULT_INSTANCE, k, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Text parseFrom(InputStream inputStream) {
            return (MessagesProto.Text)z.parseFrom(MessagesProto.Text.DEFAULT_INSTANCE, inputStream);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Text parseFrom(InputStream inputStream, q q2) {
            return (MessagesProto.Text)z.parseFrom(MessagesProto.Text.DEFAULT_INSTANCE, inputStream, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Text parseFrom(ByteBuffer byteBuffer) {
            return (MessagesProto.Text)z.parseFrom(MessagesProto.Text.DEFAULT_INSTANCE, byteBuffer);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Text parseFrom(ByteBuffer byteBuffer, q q2) {
            return (MessagesProto.Text)z.parseFrom(MessagesProto.Text.DEFAULT_INSTANCE, byteBuffer, q2);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Text parseFrom(byte[] bArr) {
            return (MessagesProto.Text)z.parseFrom(MessagesProto.Text.DEFAULT_INSTANCE, bArr);
        }

        public static com.google.firebase.inappmessaging.MessagesProto.Text parseFrom(byte[] bArr, q q2) {
            return (MessagesProto.Text)z.parseFrom(MessagesProto.Text.DEFAULT_INSTANCE, bArr, q2);
        }

        public static d1<com.google.firebase.inappmessaging.MessagesProto.Text> parser() {
            return MessagesProto.Text.DEFAULT_INSTANCE.getParserForType();
        }

        private void setHexColor(String string) {
            string.getClass();
            this.hexColor_ = string;
        }

        private void setHexColorBytes(j j) {
            a.checkByteStringIsUtf8(j);
            this.hexColor_ = j.R();
        }

        private void setText(String string) {
            string.getClass();
            this.text_ = string;
        }

        private void setTextBytes(j j) {
            a.checkByteStringIsUtf8(j);
            this.text_ = j.R();
        }

        @Override // com.google.protobuf.z
        protected final Object dynamicMethod(z.f z$f, Object object2, Object object3) {
            d1 obj2;
            int obj3;
            int obj4;
            obj3 = 1;
            obj4 = 0;
            switch (obj2) {
                case 1:
                    obj2 = new MessagesProto.Text();
                    return obj2;
                case 2:
                    obj2 = new MessagesProto.Text.Builder(obj4);
                    return obj2;
                case 3:
                    obj2 = new Object[2];
                    obj2[obj3] = "hexColor_";
                    return z.newMessageInfo(MessagesProto.Text.DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", obj2);
                case 4:
                    return MessagesProto.Text.DEFAULT_INSTANCE;
                case 5:
                    return obj2;
                case 6:
                    return Byte.valueOf(obj3);
                case 7:
                    return obj4;
                default:
                    obj2 = new UnsupportedOperationException();
                    throw obj2;
            }
            obj3 = MessagesProto.Text.class;
            synchronized (obj3) {
                obj2 = new z.b(MessagesProto.Text.DEFAULT_INSTANCE);
                MessagesProto.Text.PARSER = obj2;
            }
        }

        @Override // com.google.protobuf.z
        public String getHexColor() {
            return this.hexColor_;
        }

        @Override // com.google.protobuf.z
        public j getHexColorBytes() {
            return j.u(this.hexColor_);
        }

        @Override // com.google.protobuf.z
        public String getText() {
            return this.text_;
        }

        @Override // com.google.protobuf.z
        public j getTextBytes() {
            return j.u(this.text_);
        }
    }
    static {
    }

    public static void registerAllExtensions(q q) {
    }
}
