package com.facebook.login;

import kotlin.Metadata;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u000f\u0008\u0086\u0001\u0018\u00002\u0008\u0012\u0004\u0012\u00020\u00000\u0001B?\u0008\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\u0008\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\u0006\u0010\u0007\u001a\u00020\u0003J\u0006\u0010\u0006\u001a\u00020\u0003J\u0006\u0010\u0008\u001a\u00020\u0003J\u0006\u0010\u0002\u001a\u00020\u0003J\u0006\u0010\t\u001a\u00020\u0003J\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\u0005\u001a\u00020\u0003R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\u0008\u000bj\u0002\u0008\u000cj\u0002\u0008\rj\u0002\u0008\u000ej\u0002\u0008\u000fj\u0002\u0008\u0010j\u0002\u0008\u0011¨\u0006\u0012", d2 = {"Lcom/facebook/login/LoginBehavior;", "", "allowsGetTokenAuth", "", "allowsKatanaAuth", "allowsWebViewAuth", "allowsDeviceAuth", "allowsCustomTabAuth", "allowsFacebookLiteAuth", "allowsInstagramAppAuth", "(Ljava/lang/String;IZZZZZZZ)V", "NATIVE_WITH_FALLBACK", "NATIVE_ONLY", "KATANA_ONLY", "WEB_ONLY", "WEB_VIEW_ONLY", "DIALOG_ONLY", "DEVICE_AUTH", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public enum k {

    NATIVE_WITH_FALLBACK(true, true, true, false, true, true, true),
    NATIVE_WITH_FALLBACK(true, true, true, false, true, true, true),
    NATIVE_WITH_FALLBACK(true, true, true, false, true, true, true),
    NATIVE_WITH_FALLBACK(true, true, true, false, true, true, true),
    NATIVE_WITH_FALLBACK(true, true, true, false, true, true, true),
    NATIVE_WITH_FALLBACK(true, true, true, false, true, true, true);

    private final boolean allowsCustomTabAuth;
    private final boolean allowsDeviceAuth;
    private final boolean allowsFacebookLiteAuth;
    private final boolean allowsGetTokenAuth;
    private final boolean allowsInstagramAppAuth;
    private final boolean allowsKatanaAuth;
    private final boolean allowsWebViewAuth;
    @Override // java.lang.Enum
    public final boolean allowsCustomTabAuth() {
        return this.allowsCustomTabAuth;
    }

    @Override // java.lang.Enum
    public final boolean allowsDeviceAuth() {
        return this.allowsDeviceAuth;
    }

    @Override // java.lang.Enum
    public final boolean allowsFacebookLiteAuth() {
        return this.allowsFacebookLiteAuth;
    }

    @Override // java.lang.Enum
    public final boolean allowsGetTokenAuth() {
        return this.allowsGetTokenAuth;
    }

    @Override // java.lang.Enum
    public final boolean allowsInstagramAppAuth() {
        return this.allowsInstagramAppAuth;
    }

    @Override // java.lang.Enum
    public final boolean allowsKatanaAuth() {
        return this.allowsKatanaAuth;
    }

    @Override // java.lang.Enum
    public final boolean allowsWebViewAuth() {
        return this.allowsWebViewAuth;
    }
}
