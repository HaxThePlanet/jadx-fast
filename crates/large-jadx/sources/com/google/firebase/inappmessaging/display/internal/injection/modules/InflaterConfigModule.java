package com.google.firebase.inappmessaging.display.internal.injection.modules;

import android.app.Application;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.firebase.inappmessaging.display.dagger.Module;
import com.google.firebase.inappmessaging.display.dagger.Provides;
import com.google.firebase.inappmessaging.display.dagger.multibindings.IntoMap;
import com.google.firebase.inappmessaging.display.dagger.multibindings.StringKey;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig;
import com.google.firebase.inappmessaging.display.internal.InAppMessageLayoutConfig.Builder;
import com.google.firebase.inappmessaging.model.MessageType;

/* loaded from: classes2.dex */
@Module
public class InflaterConfigModule {

    public static int DISABLED_BG_FLAG = 327938;
    public static int DISMISSIBLE_DIALOG_FLAG = 327970;
    private int ENABLED_BG_FLAG = 65824;
    static {
    }

    public InflaterConfigModule() {
        super();
        final int i = 65824;
    }

    public static String configFor(MessageType messageType, int i2) {
        final int i = 0;
        final int i3 = 4;
        final int i4 = 3;
        final int i5 = 2;
        final int i6 = 1;
        int obj5 = InflaterConfigModule.1.$SwitchMap$com$google$firebase$inappmessaging$model$MessageType[messageType.ordinal()];
        if (i2 == i6 && obj5 != i6 && obj5 != i5 && obj5 != i4 && obj5 != i3) {
            obj5 = InflaterConfigModule.1.$SwitchMap$com$google$firebase$inappmessaging$model$MessageType[messageType.ordinal()];
            if (obj5 != i6) {
                if (obj5 != i5) {
                    if (obj5 != i4) {
                        if (obj5 != i3) {
                            return i;
                        }
                        return "BANNER_PORTRAIT";
                    }
                    return "IMAGE_ONLY_PORTRAIT";
                }
                return "CARD_PORTRAIT";
            }
            return "MODAL_PORTRAIT";
        }
        obj5 = InflaterConfigModule.1.$SwitchMap$com$google$firebase$inappmessaging$model$MessageType[messageType.ordinal()];
        if (obj5 != i6 && obj5 != i5 && obj5 != i4 && obj5 != i3) {
            if (obj5 != i5) {
                if (obj5 != i4) {
                    if (obj5 != i3) {
                        return i;
                    }
                    return "BANNER_LANDSCAPE";
                }
                return "IMAGE_ONLY_LANDSCAPE";
            }
            return "CARD_LANDSCAPE";
        }
        return "MODAL_LANDSCAPE";
    }

    @Provides
    @IntoMap
    @StringKey("BANNER_LANDSCAPE")
    public InAppMessageLayoutConfig providesBannerLandscapeLayoutConfig(DisplayMetrics displayMetrics) {
        Float valueOf5 = 0.3f;
        Boolean tRUE = Boolean.TRUE;
        return InAppMessageLayoutConfig.builder().setMaxImageHeightWeight(valueOf5).setMaxImageWidthWeight(valueOf5).setMaxDialogHeightPx(Integer.valueOf((int)i5)).setMaxDialogWidthPx(Integer.valueOf((int)obj4)).setViewWindowGravity(48).setWindowFlag(Integer.valueOf(this.ENABLED_BG_FLAG)).setWindowWidth(-1).setWindowHeight(-2).setBackgroundEnabled(tRUE).setAnimate(tRUE).setAutoDismiss(tRUE).build();
    }

    @Provides
    @IntoMap
    @StringKey("BANNER_PORTRAIT")
    public InAppMessageLayoutConfig providesBannerPortraitLayoutConfig(DisplayMetrics displayMetrics) {
        Float valueOf5 = 0.3f;
        Boolean tRUE = Boolean.TRUE;
        return InAppMessageLayoutConfig.builder().setMaxImageHeightWeight(valueOf5).setMaxImageWidthWeight(valueOf5).setMaxDialogHeightPx(Integer.valueOf((int)i5)).setMaxDialogWidthPx(Integer.valueOf((int)obj4)).setViewWindowGravity(48).setWindowFlag(Integer.valueOf(this.ENABLED_BG_FLAG)).setWindowWidth(-1).setWindowHeight(-2).setBackgroundEnabled(tRUE).setAnimate(tRUE).setAutoDismiss(tRUE).build();
    }

    @Provides
    @IntoMap
    @StringKey("CARD_LANDSCAPE")
    public InAppMessageLayoutConfig providesCardLandscapeConfig(DisplayMetrics displayMetrics) {
        Integer valueOf5 = -2;
        Boolean fALSE = Boolean.FALSE;
        return InAppMessageLayoutConfig.builder().setMaxDialogHeightPx(Integer.valueOf((int)i5)).setMaxDialogWidthPx(Integer.valueOf(displayMetrics.widthPixels)).setMaxImageHeightWeight(1f).setMaxImageWidthWeight(0.5f).setViewWindowGravity(17).setWindowFlag(Integer.valueOf(InflaterConfigModule.DISMISSIBLE_DIALOG_FLAG)).setWindowWidth(valueOf5).setWindowHeight(valueOf5).setBackgroundEnabled(fALSE).setAnimate(fALSE).setAutoDismiss(fALSE).build();
    }

    @Provides
    @IntoMap
    @StringKey("CARD_PORTRAIT")
    public InAppMessageLayoutConfig providesCardPortraitConfig(DisplayMetrics displayMetrics) {
        Integer valueOf7 = -2;
        Boolean fALSE = Boolean.FALSE;
        return InAppMessageLayoutConfig.builder().setMaxDialogHeightPx(Integer.valueOf((int)i7)).setMaxDialogWidthPx(Integer.valueOf((int)obj6)).setMaxImageHeightWeight(0.6f).setMaxImageWidthWeight(1f).setMaxBodyHeightWeight(0.1f).setMaxBodyWidthWeight(0.9f).setViewWindowGravity(17).setWindowFlag(Integer.valueOf(InflaterConfigModule.DISMISSIBLE_DIALOG_FLAG)).setWindowWidth(valueOf7).setWindowHeight(valueOf7).setBackgroundEnabled(fALSE).setAnimate(fALSE).setAutoDismiss(fALSE).build();
    }

    @Provides
    DisplayMetrics providesDisplayMetrics(Application application) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        (WindowManager)application.getSystemService("window").getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    @Provides
    @IntoMap
    @StringKey("IMAGE_ONLY_LANDSCAPE")
    public InAppMessageLayoutConfig providesLandscapeImageLayoutConfig(DisplayMetrics displayMetrics) {
        final int i6 = 1063675494;
        Float valueOf = 0.8f;
        Integer valueOf4 = -2;
        Boolean fALSE = Boolean.FALSE;
        return InAppMessageLayoutConfig.builder().setMaxDialogHeightPx(Integer.valueOf((int)i4)).setMaxDialogWidthPx(Integer.valueOf((int)obj4)).setMaxImageWidthWeight(valueOf).setMaxImageHeightWeight(valueOf).setViewWindowGravity(17).setWindowFlag(Integer.valueOf(InflaterConfigModule.DISABLED_BG_FLAG)).setWindowWidth(valueOf4).setWindowHeight(valueOf4).setBackgroundEnabled(fALSE).setAnimate(fALSE).setAutoDismiss(fALSE).build();
    }

    @Provides
    @IntoMap
    @StringKey("MODAL_LANDSCAPE")
    public InAppMessageLayoutConfig providesModalLandscapeConfig(DisplayMetrics displayMetrics) {
        Float valueOf2 = 0.4f;
        Integer valueOf5 = -1;
        Boolean fALSE = Boolean.FALSE;
        return InAppMessageLayoutConfig.builder().setMaxDialogHeightPx(Integer.valueOf((int)i5)).setMaxDialogWidthPx(Integer.valueOf(displayMetrics.widthPixels)).setMaxImageHeightWeight(1f).setMaxImageWidthWeight(valueOf2).setMaxBodyHeightWeight(0.6f).setMaxBodyWidthWeight(valueOf2).setViewWindowGravity(17).setWindowFlag(Integer.valueOf(InflaterConfigModule.DISABLED_BG_FLAG)).setWindowWidth(valueOf5).setWindowHeight(valueOf5).setBackgroundEnabled(fALSE).setAnimate(fALSE).setAutoDismiss(fALSE).build();
    }

    @Provides
    @IntoMap
    @StringKey("MODAL_PORTRAIT")
    public InAppMessageLayoutConfig providesModalPortraitConfig(DisplayMetrics displayMetrics) {
        Float valueOf3 = 0.9f;
        Boolean fALSE = Boolean.FALSE;
        return InAppMessageLayoutConfig.builder().setMaxDialogHeightPx(Integer.valueOf((int)i7)).setMaxDialogWidthPx(Integer.valueOf((int)obj6)).setMaxImageHeightWeight(0.6f).setMaxBodyHeightWeight(0.1f).setMaxImageWidthWeight(valueOf3).setMaxBodyWidthWeight(valueOf3).setViewWindowGravity(17).setWindowFlag(Integer.valueOf(InflaterConfigModule.DISABLED_BG_FLAG)).setWindowWidth(-1).setWindowHeight(-2).setBackgroundEnabled(fALSE).setAnimate(fALSE).setAutoDismiss(fALSE).build();
    }

    @Provides
    @IntoMap
    @StringKey("IMAGE_ONLY_PORTRAIT")
    public InAppMessageLayoutConfig providesPortraitImageLayoutConfig(DisplayMetrics displayMetrics) {
        final int i6 = 1063675494;
        Float valueOf = 0.8f;
        Integer valueOf4 = -2;
        Boolean fALSE = Boolean.FALSE;
        return InAppMessageLayoutConfig.builder().setMaxDialogHeightPx(Integer.valueOf((int)i4)).setMaxDialogWidthPx(Integer.valueOf((int)obj4)).setMaxImageWidthWeight(valueOf).setMaxImageHeightWeight(valueOf).setViewWindowGravity(17).setWindowFlag(Integer.valueOf(InflaterConfigModule.DISABLED_BG_FLAG)).setWindowWidth(valueOf4).setWindowHeight(valueOf4).setBackgroundEnabled(fALSE).setAnimate(fALSE).setAutoDismiss(fALSE).build();
    }
}
