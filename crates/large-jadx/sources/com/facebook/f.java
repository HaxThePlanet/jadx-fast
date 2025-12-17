package com.facebook;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000f\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010\u0005\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\u0008\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000ej\u0002\u0008\u000fj\u0002\u0008\u0010j\u0002\u0008\u0011¨\u0006\u0012", d2 = {"Lcom/facebook/AccessTokenSource;", "", "canExtendToken", "", "(Ljava/lang/String;IZ)V", "fromInstagram", "NONE", "FACEBOOK_APPLICATION_WEB", "FACEBOOK_APPLICATION_NATIVE", "FACEBOOK_APPLICATION_SERVICE", "WEB_VIEW", "CHROME_CUSTOM_TAB", "TEST_USER", "CLIENT_TOKEN", "DEVICE_AUTH", "INSTAGRAM_APPLICATION_WEB", "INSTAGRAM_CUSTOM_CHROME_TAB", "INSTAGRAM_WEB_VIEW", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public enum f {

    NONE(false),
    FACEBOOK_APPLICATION_WEB(false),
    FACEBOOK_APPLICATION_NATIVE(false),
    FACEBOOK_APPLICATION_SERVICE(false),
    WEB_VIEW(false),
    CHROME_CUSTOM_TAB(false),
    TEST_USER(false),
    CLIENT_TOKEN(false),
    DEVICE_AUTH(false),
    INSTAGRAM_APPLICATION_WEB(false),
    INSTAGRAM_CUSTOM_CHROME_TAB(false),
    INSTAGRAM_WEB_VIEW(false);

    private final boolean canExtendToken;
    @Override // java.lang.Enum
    public final boolean canExtendToken() {
        return this.canExtendToken;
    }

    @Override // java.lang.Enum
    public final boolean fromInstagram() {
        int i;
        int i2;
        int i3 = e.a[ordinal()];
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            if (i3 != 2) {
                if (i3 != 3) {
                    i = 0;
                }
            }
        }
        return i;
    }
}
