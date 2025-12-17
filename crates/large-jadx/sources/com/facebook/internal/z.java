package com.facebook.internal;

import com.facebook.o;
import java.util.Arrays;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.n;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u00084\n\u0002\u0010\u001e\n\u0002\u0008\u000f\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0002\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010@\u001a\u00020\u0004H\u0007J\u0008\u0010A\u001a\u00020\u0004H\u0007J\u0008\u0010B\u001a\u00020\u0004H\u0007J\u0008\u0010C\u001a\u00020\u0004H\u0007J\u0010\u0010D\u001a\u00020\u00042\u0006\u0010E\u001a\u00020\u0004H\u0007J\u0008\u0010F\u001a\u00020\u0004H\u0007J\u0008\u0010G\u001a\u00020\u0004H\u0007J$\u0010H\u001a\u0004\u0018\u00010I2\u0006\u0010J\u001a\u00020\u00042\u0006\u0010K\u001a\u00020L2\u0008\u0010M\u001a\u0004\u0018\u00010IH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00104\u001a\u00020\u00048\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\u00085\u0010\u0002\u001a\u0004\u00086\u00107R\"\u00108\u001a\u0008\u0012\u0004\u0012\u00020\u0004098\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008:\u0010\u0002\u001a\u0004\u0008;\u0010<R\"\u0010=\u001a\u0008\u0012\u0004\u0012\u00020\u0004098\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\u0008>\u0010\u0002\u001a\u0004\u0008?\u0010<¨\u0006N", d2 = {"Lcom/facebook/internal/ServerProtocol;", "", "()V", "DIALOG_AUTHORITY_FORMAT", "", "DIALOG_CANCEL_URI", "DIALOG_PARAM_ACCESS_TOKEN", "DIALOG_PARAM_APP_ID", "DIALOG_PARAM_AUTH_TYPE", "DIALOG_PARAM_CBT", "DIALOG_PARAM_CCT_OVER_LOGGED_OUT_APP_SWITCH", "DIALOG_PARAM_CLIENT_ID", "DIALOG_PARAM_CUSTOM_TABS_PREFETCHING", "DIALOG_PARAM_DEFAULT_AUDIENCE", "DIALOG_PARAM_DISPLAY", "DIALOG_PARAM_DISPLAY_TOUCH", "DIALOG_PARAM_E2E", "DIALOG_PARAM_FAIL_ON_LOGGED_OUT", "DIALOG_PARAM_FX_APP", "DIALOG_PARAM_IES", "DIALOG_PARAM_LEGACY_OVERRIDE", "DIALOG_PARAM_LOGIN_BEHAVIOR", "DIALOG_PARAM_MESSENGER_PAGE_ID", "DIALOG_PARAM_NONCE", "DIALOG_PARAM_REDIRECT_URI", "DIALOG_PARAM_RESET_MESSENGER_STATE", "DIALOG_PARAM_RESPONSE_TYPE", "DIALOG_PARAM_RETURN_SCOPES", "DIALOG_PARAM_SCOPE", "DIALOG_PARAM_SDK_VERSION", "DIALOG_PARAM_SKIP_DEDUPE", "DIALOG_PARAM_SSO_DEVICE", "DIALOG_PARAM_STATE", "DIALOG_PATH", "DIALOG_REDIRECT_CHROME_OS_URI", "DIALOG_REDIRECT_URI", "DIALOG_REREQUEST_AUTH_TYPE", "DIALOG_RESPONSE_TYPE_ID_TOKEN_AND_SIGNED_REQUEST", "DIALOG_RESPONSE_TYPE_TOKEN_AND_SCOPES", "DIALOG_RESPONSE_TYPE_TOKEN_AND_SIGNED_REQUEST", "DIALOG_RETURN_SCOPES_TRUE", "FALLBACK_DIALOG_DISPLAY_VALUE_TOUCH", "FALLBACK_DIALOG_PARAM_APP_ID", "FALLBACK_DIALOG_PARAM_BRIDGE_ARGS", "FALLBACK_DIALOG_PARAM_KEY_HASH", "FALLBACK_DIALOG_PARAM_METHOD_ARGS", "FALLBACK_DIALOG_PARAM_METHOD_RESULTS", "FALLBACK_DIALOG_PARAM_VERSION", "GRAPH_URL_FORMAT", "GRAPH_VIDEO_URL_FORMAT", "INSTAGRAM_OAUTH_PATH", "TAG", "errorConnectionFailure", "getErrorConnectionFailure$annotations", "getErrorConnectionFailure", "()Ljava/lang/String;", "errorsProxyAuthDisabled", "", "getErrorsProxyAuthDisabled$annotations", "getErrorsProxyAuthDisabled", "()Ljava/util/Collection;", "errorsUserCanceled", "getErrorsUserCanceled$annotations", "getErrorsUserCanceled", "getDefaultAPIVersion", "getDialogAuthority", "getFacebookGraphUrlBase", "getGraphUrlBase", "getGraphUrlBaseForSubdomain", "subdomain", "getGraphVideoUrlBase", "getInstagramDialogAuthority", "getQueryParamsForPlatformActivityIntentWebFallback", "Landroid/os/Bundle;", "callId", "version", "", "methodArgs", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class z {

    private static final Collection<String> a;
    private static final Collection<String> b;
    private static final String c;
    static {
        n.e(z.class.getName(), "ServerProtocol::class.java.name");
        z.a = p.j(/* result */);
        z.b = p.j(/* result */);
        z.c = "CONNECTION_FAILURE";
    }

    public static final String a() {
        return "v12.0";
    }

    public static final String b() {
        f0 f0Var = f0.a;
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = o.o();
        String format = String.format("m.%s", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public static final String c() {
        return z.c;
    }

    public static final Collection<String> d() {
        return z.a;
    }

    public static final Collection<String> e() {
        return z.b;
    }

    public static final String f() {
        f0 f0Var = f0.a;
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = o.o();
        String format = String.format("https://graph.%s", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public static final String g() {
        f0 f0Var = f0.a;
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = o.q();
        String format = String.format("https://graph.%s", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public static final String h(String string) {
        n.f(string, "subdomain");
        f0 f0Var = f0.a;
        int i = 1;
        final Object[] arr = new Object[i];
        arr[0] = string;
        String obj3 = String.format("https://graph.%s", Arrays.copyOf(arr, i));
        n.e(obj3, "java.lang.String.format(format, *args)");
        return obj3;
    }

    public static final String i() {
        f0 f0Var = f0.a;
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = o.q();
        String format = String.format("https://graph-video.%s", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(format, *args)");
        return format;
    }

    public static final String j() {
        f0 f0Var = f0.a;
        int i = 1;
        Object[] arr = new Object[i];
        arr[0] = o.r();
        String format = String.format("m.%s", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(format, *args)");
        return format;
    }
}
