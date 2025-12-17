package com.google.firebase.inappmessaging.display.internal;

/* loaded from: classes2.dex */
public class InAppMessageLayoutConfig {

    private Boolean animate;
    private Boolean autoDismiss;
    private Boolean backgroundEnabled;
    private Float maxBodyHeightWeight;
    private Float maxBodyWidthWeight;
    private Integer maxDialogHeightPx;
    private Integer maxDialogWidthPx;
    private Float maxImageHeightWeight;
    private Float maxImageWidthWeight;
    private Integer viewWindowGravity;
    private Integer windowFlag;
    private Integer windowHeight;
    private Integer windowWidth;

    public static class Builder {

        private final com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig config;
        public Builder() {
            super();
            InAppMessageLayoutConfig inAppMessageLayoutConfig = new InAppMessageLayoutConfig();
            this.config = inAppMessageLayoutConfig;
        }

        public com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig build() {
            return this.config;
        }

        public com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig.Builder setAnimate(Boolean boolean) {
            InAppMessageLayoutConfig.access$1102(this.config, boolean);
            return this;
        }

        public com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig.Builder setAutoDismiss(Boolean boolean) {
            InAppMessageLayoutConfig.access$1202(this.config, boolean);
            return this;
        }

        public com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig.Builder setBackgroundEnabled(Boolean boolean) {
            InAppMessageLayoutConfig.access$1002(this.config, boolean);
            return this;
        }

        public com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig.Builder setMaxBodyHeightWeight(Float float) {
            InAppMessageLayoutConfig.access$202(this.config, float);
            return this;
        }

        public com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig.Builder setMaxBodyWidthWeight(Float float) {
            InAppMessageLayoutConfig.access$302(this.config, float);
            return this;
        }

        public com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig.Builder setMaxDialogHeightPx(Integer integer) {
            InAppMessageLayoutConfig.access$402(this.config, integer);
            return this;
        }

        public com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig.Builder setMaxDialogWidthPx(Integer integer) {
            InAppMessageLayoutConfig.access$502(this.config, integer);
            return this;
        }

        public com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig.Builder setMaxImageHeightWeight(Float float) {
            InAppMessageLayoutConfig.access$002(this.config, float);
            return this;
        }

        public com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig.Builder setMaxImageWidthWeight(Float float) {
            InAppMessageLayoutConfig.access$102(this.config, float);
            return this;
        }

        public com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig.Builder setViewWindowGravity(Integer integer) {
            InAppMessageLayoutConfig.access$602(this.config, integer);
            return this;
        }

        public com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig.Builder setWindowFlag(Integer integer) {
            InAppMessageLayoutConfig.access$702(this.config, integer);
            return this;
        }

        public com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig.Builder setWindowHeight(Integer integer) {
            InAppMessageLayoutConfig.access$902(this.config, integer);
            return this;
        }

        public com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig.Builder setWindowWidth(Integer integer) {
            InAppMessageLayoutConfig.access$802(this.config, integer);
            return this;
        }
    }
    static Float access$002(com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig inAppMessageLayoutConfig, Float float2) {
        inAppMessageLayoutConfig.maxImageHeightWeight = float2;
        return float2;
    }

    static Boolean access$1002(com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig inAppMessageLayoutConfig, Boolean boolean2) {
        inAppMessageLayoutConfig.backgroundEnabled = boolean2;
        return boolean2;
    }

    static Float access$102(com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig inAppMessageLayoutConfig, Float float2) {
        inAppMessageLayoutConfig.maxImageWidthWeight = float2;
        return float2;
    }

    static Boolean access$1102(com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig inAppMessageLayoutConfig, Boolean boolean2) {
        inAppMessageLayoutConfig.animate = boolean2;
        return boolean2;
    }

    static Boolean access$1202(com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig inAppMessageLayoutConfig, Boolean boolean2) {
        inAppMessageLayoutConfig.autoDismiss = boolean2;
        return boolean2;
    }

    static Float access$202(com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig inAppMessageLayoutConfig, Float float2) {
        inAppMessageLayoutConfig.maxBodyHeightWeight = float2;
        return float2;
    }

    static Float access$302(com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig inAppMessageLayoutConfig, Float float2) {
        inAppMessageLayoutConfig.maxBodyWidthWeight = float2;
        return float2;
    }

    static Integer access$402(com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig inAppMessageLayoutConfig, Integer integer2) {
        inAppMessageLayoutConfig.maxDialogHeightPx = integer2;
        return integer2;
    }

    static Integer access$502(com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig inAppMessageLayoutConfig, Integer integer2) {
        inAppMessageLayoutConfig.maxDialogWidthPx = integer2;
        return integer2;
    }

    static Integer access$602(com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig inAppMessageLayoutConfig, Integer integer2) {
        inAppMessageLayoutConfig.viewWindowGravity = integer2;
        return integer2;
    }

    static Integer access$702(com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig inAppMessageLayoutConfig, Integer integer2) {
        inAppMessageLayoutConfig.windowFlag = integer2;
        return integer2;
    }

    static Integer access$802(com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig inAppMessageLayoutConfig, Integer integer2) {
        inAppMessageLayoutConfig.windowWidth = integer2;
        return integer2;
    }

    static Integer access$902(com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig inAppMessageLayoutConfig, Integer integer2) {
        inAppMessageLayoutConfig.windowHeight = integer2;
        return integer2;
    }

    public static com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig.Builder builder() {
        InAppMessageLayoutConfig.Builder builder = new InAppMessageLayoutConfig.Builder();
        return builder;
    }

    public Boolean animate() {
        return this.animate;
    }

    public Boolean autoDismiss() {
        return this.autoDismiss;
    }

    public Boolean backgroundEnabled() {
        return this.backgroundEnabled;
    }

    public int getMaxBodyHeight() {
        return (int)i;
    }

    public int getMaxBodyWidth() {
        return (int)i;
    }

    public int getMaxImageHeight() {
        return (int)i;
    }

    public int getMaxImageWidth() {
        return (int)i;
    }

    public Float maxBodyHeightWeight() {
        return this.maxBodyHeightWeight;
    }

    public Float maxBodyWidthWeight() {
        return this.maxBodyWidthWeight;
    }

    public Integer maxDialogHeightPx() {
        return this.maxDialogHeightPx;
    }

    public Integer maxDialogWidthPx() {
        return this.maxDialogWidthPx;
    }

    public Float maxImageHeightWeight() {
        return this.maxImageHeightWeight;
    }

    public Float maxImageWidthWeight() {
        return this.maxImageWidthWeight;
    }

    public Integer viewWindowGravity() {
        return this.viewWindowGravity;
    }

    public Integer windowFlag() {
        return this.windowFlag;
    }

    public Integer windowHeight() {
        return this.windowHeight;
    }

    public Integer windowWidth() {
        return this.windowWidth;
    }
}
