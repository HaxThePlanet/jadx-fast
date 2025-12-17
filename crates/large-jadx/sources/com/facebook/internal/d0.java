package com.facebook.internal;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslError;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.facebook.FacebookDialogException;
import com.facebook.FacebookException;
import com.facebook.FacebookOperationCanceledException;
import com.facebook.FacebookServiceException;
import com.facebook.a;
import com.facebook.a.c;
import com.facebook.common.a;
import com.facebook.common.d;
import com.facebook.common.e;
import com.facebook.internal.g0.i.a;
import com.facebook.login.s;
import com.facebook.n;
import com.facebook.o;
import com.facebook.p;
import com.facebook.share.a.c;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;
import kotlin.y.i;
import org.json.JSONArray;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000b\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0007\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\t\n\u0002\u0010\u0003\n\u0002\u0008\u000c\u0008\u0016\u0018\u0000 N2\u00020\u0001:\u0006MNOPQRB\u0017\u0008\u0014\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\u0008\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0008¢\u0006\u0002\u0010\tB=\u0008\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000c\u0012\u0006\u0010\u0007\u001a\u00020\u0008\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\u0002\u0010\u0011J\u0008\u0010,\u001a\u00020-H\u0016J\u0008\u0010.\u001a\u00020-H\u0002J\u0008\u0010/\u001a\u00020-H\u0016J(\u00100\u001a\u00020\u00082\u0006\u00101\u001a\u00020\u00082\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00082\u0006\u00105\u001a\u00020\u0008H\u0002J\u0008\u00106\u001a\u00020-H\u0016J\u0012\u00107\u001a\u00020-2\u0008\u00108\u001a\u0004\u0018\u00010\u000cH\u0014J\u0008\u00109\u001a\u00020-H\u0016J\u0018\u0010:\u001a\u00020\u00182\u0006\u0010;\u001a\u00020\u00082\u0006\u0010<\u001a\u00020=H\u0016J\u0008\u0010>\u001a\u00020-H\u0014J\u0008\u0010?\u001a\u00020-H\u0014J\u0010\u0010@\u001a\u00020-2\u0006\u0010A\u001a\u00020+H\u0016J\u0012\u0010B\u001a\u00020\u000c2\u0008\u0010C\u001a\u0004\u0018\u00010\u0005H\u0017J\u0006\u0010D\u001a\u00020-J\u0012\u0010E\u001a\u00020-2\u0008\u0010F\u001a\u0004\u0018\u00010GH\u0004J\u0012\u0010H\u001a\u00020-2\u0008\u0010I\u001a\u0004\u0018\u00010\u000cH\u0004J\u0010\u0010J\u001a\u00020-2\u0006\u0010\u0016\u001a\u00020\u0005H\u0004J\u0010\u0010K\u001a\u00020-2\u0006\u0010L\u001a\u00020\u0008H\u0003R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018@BX\u0084\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001bR\u001e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018@BX\u0084\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001c\u0010\u001bR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\u0008\u001e\u0010\u001f\"\u0004\u0008 \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u0008\u0018\u00010%R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010'\u001a\u0004\u0018\u00010&2\u0008\u0010\u0019\u001a\u0004\u0018\u00010&@BX\u0084\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006S", d2 = {"Lcom/facebook/internal/WebDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "url", "", "(Landroid/content/Context;Ljava/lang/String;)V", "theme", "", "(Landroid/content/Context;Ljava/lang/String;I)V", "action", "parameters", "Landroid/os/Bundle;", "targetApp", "Lcom/facebook/login/LoginTargetApp;", "listener", "Lcom/facebook/internal/WebDialog$OnCompleteListener;", "(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;ILcom/facebook/login/LoginTargetApp;Lcom/facebook/internal/WebDialog$OnCompleteListener;)V", "contentFrameLayout", "Landroid/widget/FrameLayout;", "crossImageView", "Landroid/widget/ImageView;", "expectedRedirectUrl", "isDetached", "", "<set-?>", "isListenerCalled", "()Z", "isPageFinished", "onCompleteListener", "getOnCompleteListener", "()Lcom/facebook/internal/WebDialog$OnCompleteListener;", "setOnCompleteListener", "(Lcom/facebook/internal/WebDialog$OnCompleteListener;)V", "spinner", "Landroid/app/ProgressDialog;", "uploadTask", "Lcom/facebook/internal/WebDialog$UploadStagingResourcesTask;", "Landroid/webkit/WebView;", "webView", "getWebView", "()Landroid/webkit/WebView;", "windowParams", "Landroid/view/WindowManager$LayoutParams;", "cancel", "", "createCrossImage", "dismiss", "getScaledSize", "screenSize", "density", "", "noPaddingSize", "maxPaddingSize", "onAttachedToWindow", "onCreate", "savedInstanceState", "onDetachedFromWindow", "onKeyDown", "keyCode", "event", "Landroid/view/KeyEvent;", "onStart", "onStop", "onWindowAttributesChanged", "params", "parseResponseUri", "urlString", "resize", "sendErrorToListener", "error", "", "sendSuccessToListener", "values", "setExpectedRedirectUrl", "setUpWebView", "margin", "Builder", "Companion", "DialogWebViewClient", "InitCallback", "OnCompleteListener", "UploadStagingResourcesTask", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public class d0 extends Dialog {

    private static final int E;
    private static volatile int F;
    private static com.facebook.internal.d0.d G;
    public static final com.facebook.internal.d0.b H;
    private boolean A;
    private boolean B;
    private boolean C;
    private WindowManager.LayoutParams D;
    private String a;
    private String b;
    private com.facebook.internal.d0.e c;
    private WebView v;
    private ProgressDialog w;
    private ImageView x;
    private FrameLayout y;
    private com.facebook.internal.d0.f z;

    @Metadata(d1 = "\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0016\u0018\u00002\u00020\u0001B!\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0008B+\u0008\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0008\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\n\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J$\u0010\u001e\u001a\u00020\u001f2\u0008\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u0010 \u001a\u00020\u00002\u0008\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0018R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u000cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0004\u0018\u00010\u00052\u0008\u0010\r\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u000fR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0008\u0010\r\u001a\u0004\u0018\u00010\u0003@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0011R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0008\u0010\r\u001a\u0004\u0018\u00010\u0012@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0014\u0010\u0015R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0008\u0010\r\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0016\u0010\u0017R\u001e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u0018@BX\u0086\u000e¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u001a\u0010\u001b¨\u0006\"", d2 = {"Lcom/facebook/internal/WebDialog$Builder;", "", "context", "Landroid/content/Context;", "action", "", "parameters", "Landroid/os/Bundle;", "(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)V", "applicationId", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "accessToken", "Lcom/facebook/AccessToken;", "<set-?>", "getApplicationId", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "Lcom/facebook/internal/WebDialog$OnCompleteListener;", "listener", "getListener", "()Lcom/facebook/internal/WebDialog$OnCompleteListener;", "getParameters", "()Landroid/os/Bundle;", "", "theme", "getTheme", "()I", "build", "Lcom/facebook/internal/WebDialog;", "finishInit", "", "setOnCompleteListener", "setTheme", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public static class a {

        private Context a;
        private String b;
        private String c;
        private int d;
        private com.facebook.internal.d0.e e;
        private Bundle f;
        private a g;
        public a(Context context, String string2, Bundle bundle3) {
            boolean z;
            n.f(context, "context");
            n.f(string2, "action");
            super();
            a.c cVar = a.H;
            this.g = cVar.e();
            if (!cVar.g()) {
                z = b0.D(context);
                if (z == null) {
                } else {
                    this.b = z;
                }
                FacebookException obj3 = new FacebookException("Attempted to create a builder without a valid access token or a valid default Application ID.");
                throw obj3;
            }
            b(context, string2, bundle3);
        }

        public a(Context context, String string2, String string3, Bundle bundle4) {
            String obj3;
            n.f(context, "context");
            n.f(string3, "action");
            super();
            if (string2 == null) {
                obj3 = b0.D(context);
            }
            c0.k(obj3, "applicationId");
            this.b = obj3;
            b(context, string3, bundle4);
        }

        private final void b(Context context, String string2, Bundle bundle3) {
            Object obj1;
            this.a = context;
            this.c = string2;
            if (bundle3 != null) {
                this.f = bundle3;
            } else {
                obj1 = new Bundle();
                this.f = obj1;
            }
        }

        public com.facebook.internal.d0 a() {
            Object aVar;
            Bundle bundle2;
            String str;
            Object bundle;
            int i;
            aVar = this.g;
            str = "app_id";
            if (aVar != null) {
                bundle = this.f;
                if (bundle != null) {
                    if (aVar != null) {
                        aVar = aVar.c();
                    } else {
                        aVar = i;
                    }
                    bundle.putString(str, aVar);
                }
                bundle2 = this.f;
                a aVar2 = this.g;
                if (bundle2 != null && aVar2 != null) {
                    aVar2 = this.g;
                    if (aVar2 != null) {
                        i = aVar2.m();
                    }
                    bundle2.putString("access_token", i);
                }
            } else {
                bundle2 = this.f;
                if (bundle2 != null) {
                    bundle2.putString(str, this.b);
                }
            }
            final Context context = this.a;
            if (context == null) {
            } else {
                return d0.H.c(context, this.c, this.f, this.d, this.e);
            }
            IllegalStateException illegalStateException = new IllegalStateException("Required value was null.".toString());
            throw illegalStateException;
        }

        public final String c() {
            return this.b;
        }

        public final Context d() {
            return this.a;
        }

        public final com.facebook.internal.d0.e e() {
            return this.e;
        }

        public final Bundle f() {
            return this.f;
        }

        public final int g() {
            return this.d;
        }

        public final com.facebook.internal.d0.a h(com.facebook.internal.d0.e d0$e) {
            this.e = e;
            return this;
        }
    }

    @Metadata(d1 = "\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0004\n\u0002\u0010\u0006\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0016\u001a\u00020\u0004H\u0007J\u0012\u0010\u0017\u001a\u00020\u00182\u0008\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0005J6\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\n2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u00042\u0008\u0010!\u001a\u0004\u0018\u00010\"H\u0007J>\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u001a2\u0008\u0010\u001d\u001a\u0004\u0018\u00010\n2\u0008\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u00042\u0006\u0010#\u001a\u00020$2\u0008\u0010!\u001a\u0004\u0018\u00010\"H\u0007J\u0012\u0010%\u001a\u00020\u00182\u0008\u0010&\u001a\u0004\u0018\u00010\u0014H\u0007J\u0010\u0010'\u001a\u00020\u00182\u0006\u0010 \u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0008X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006(", d2 = {"Lcom/facebook/internal/WebDialog$Companion;", "", "()V", "API_EC_DIALOG_CANCEL", "", "BACKGROUND_GRAY", "DEFAULT_THEME", "DISABLE_SSL_CHECK_FOR_TESTING", "", "DISPLAY_TOUCH", "", "LOG_TAG", "MAX_PADDING_SCREEN_HEIGHT", "MAX_PADDING_SCREEN_WIDTH", "MIN_SCALE_FACTOR", "", "NO_PADDING_SCREEN_HEIGHT", "NO_PADDING_SCREEN_WIDTH", "PLATFORM_DIALOG_PATH_REGEX", "initCallback", "Lcom/facebook/internal/WebDialog$InitCallback;", "webDialogTheme", "getWebDialogTheme", "initDefaultTheme", "", "context", "Landroid/content/Context;", "newInstance", "Lcom/facebook/internal/WebDialog;", "action", "parameters", "Landroid/os/Bundle;", "theme", "listener", "Lcom/facebook/internal/WebDialog$OnCompleteListener;", "targetApp", "Lcom/facebook/login/LoginTargetApp;", "setInitCallback", "callback", "setWebDialogTheme", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public static final class b {
        public b(g g) {
            super();
        }

        public final int a() {
            c0.l();
            return d0.f();
        }

        protected final void b(Context context) {
            Bundle metaData;
            int str;
            android.content.pm.ApplicationInfo obj3;
            if (context == null) {
            }
            obj3 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (obj3 != null) {
                try {
                    metaData = obj3.metaData;
                    metaData = 0;
                    if (metaData == null) {
                    }
                    if (d0.f() == 0) {
                    }
                    e(obj3.metaData.getInt("com.facebook.sdk.WebDialogTheme"));
                }
            } else {
            }
        }

        public final com.facebook.internal.d0 c(Context context, String string2, Bundle bundle3, int i4, com.facebook.internal.d0.e d0$e5) {
            n.f(context, "context");
            b(context);
            super(context, string2, bundle3, i4, s.FACEBOOK, e5, 0);
            return d0Var;
        }

        public final com.facebook.internal.d0 d(Context context, String string2, Bundle bundle3, int i4, s s5, com.facebook.internal.d0.e d0$e6) {
            n.f(context, "context");
            n.f(s5, "targetApp");
            b(context);
            super(context, string2, bundle3, i4, s5, e6, 0);
            return d0Var;
        }

        public final void e(int i) {
            int obj1;
            if (i != 0) {
            } else {
                obj1 = d0.c();
            }
            d0.k(obj1);
        }
    }

    @Metadata(d1 = "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0008\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016J\"\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00082\u0008\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J(\u0010\u000c\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00082\u0006\u0010\u0010\u001a\u00020\u0008H\u0016J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0016¨\u0006\u0018", d2 = {"Lcom/facebook/internal/WebDialog$DialogWebViewClient;", "Landroid/webkit/WebViewClient;", "(Lcom/facebook/internal/WebDialog;)V", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedError", "errorCode", "", "description", "failingUrl", "onReceivedSslError", "handler", "Landroid/webkit/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "shouldOverrideUrlLoading", "", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    private final class c extends WebViewClient {

        final com.facebook.internal.d0 a;
        public c(com.facebook.internal.d0 d0) {
            this.a = d0;
            super();
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String string2) {
            boolean obj2;
            n.f(webView, "view");
            n.f(string2, "url");
            super.onPageFinished(webView, string2);
            obj2 = d0.e(this.a);
            if (!d0.g(this.a) && obj2 != null) {
                obj2 = d0.e(this.a);
                if (obj2 != null) {
                    obj2.dismiss();
                }
            }
            obj2 = d0.a(this.a);
            int obj3 = 0;
            if (obj2 != null) {
                obj2.setBackgroundColor(obj3);
            }
            obj2 = this.a.n();
            if (obj2 != null) {
                obj2.setVisibility(obj3);
            }
            obj2 = d0.b(this.a);
            if (obj2 != null) {
                obj2.setVisibility(obj3);
            }
            d0.h(this.a, true);
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String string2, Bitmap bitmap3) {
            boolean obj3;
            n.f(webView, "view");
            n.f(string2, "url");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Webview loading URL: ");
            stringBuilder.append(string2);
            b0.d0("FacebookSDK.WebDialog", stringBuilder.toString());
            super.onPageStarted(webView, string2, bitmap3);
            obj3 = d0.e(this.a);
            if (!d0.g(this.a) && obj3 != null) {
                obj3 = d0.e(this.a);
                if (obj3 != null) {
                    obj3.show();
                }
            }
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i2, String string3, String string4) {
            n.f(webView, "view");
            n.f(string3, "description");
            n.f(string4, "failingUrl");
            super.onReceivedError(webView, i2, string3, string4);
            FacebookDialogException facebookDialogException = new FacebookDialogException(string3, i2, string4);
            this.a.t(facebookDialogException);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler2, SslError sslError3) {
            n.f(webView, "view");
            n.f(sslErrorHandler2, "handler");
            n.f(sslError3, "error");
            super.onReceivedSslError(webView, sslErrorHandler2, sslError3);
            sslErrorHandler2.cancel();
            final int obj4 = 0;
            FacebookDialogException obj3 = new FacebookDialogException(obj4, -11, obj4);
            this.a.t(obj3);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String string2) {
            String path;
            String string;
            int i;
            int facebookServiceException;
            boolean i2;
            boolean z;
            Uri obj6;
            String obj7;
            n.f(webView, "view");
            n.f(string2, "url");
            obj6 = new StringBuilder();
            obj6.append("Redirect URL: ");
            obj6.append(string2);
            b0.d0("FacebookSDK.WebDialog", obj6.toString());
            obj6 = Uri.parse(string2);
            n.e(obj6, "parsedURL");
            i = 1;
            int i3 = 0;
            if (obj6.getPath() != null && Pattern.matches("^/(v\\d+\\.\\d+/)??dialog/.*", obj6.getPath())) {
                obj6 = Pattern.matches("^/(v\\d+\\.\\d+/)??dialog/.*", obj6.getPath()) ? i : i3;
            } else {
            }
            int i4 = 2;
            i2 = 0;
            obj6 = this.a.r(string2);
            if (l.M(string2, d0.d(this.a), i3, i4, i2) && obj6.getString("error") == null) {
                obj6 = this.a.r(string2);
                if (obj6.getString("error") == null) {
                    obj7 = obj6.getString("error_type");
                }
                if (obj6.getString("error_msg") == null) {
                    string = obj6.getString("error_message");
                }
                if (string == null) {
                    string = obj6.getString("error_description");
                }
                String string3 = obj6.getString("error_code");
                int i5 = -1;
                if (string3 != null && !b0.W(string3)) {
                    if (!b0.W(string3)) {
                        facebookServiceException = Integer.parseInt(string3);
                    } else {
                        facebookServiceException = i5;
                    }
                } else {
                }
                if (b0.W(obj7) && b0.W(string) && facebookServiceException == i5) {
                    if (b0.W(string)) {
                        if (facebookServiceException == i5) {
                            this.a.u(obj6);
                        } else {
                            if (obj7 != null) {
                                if (!n.b(obj7, "access_denied")) {
                                    if (n.b(obj7, "OAuthAccessDeniedException")) {
                                        this.a.cancel();
                                    } else {
                                        if (facebookServiceException == 4201) {
                                            this.a.cancel();
                                        } else {
                                            obj6 = new n(facebookServiceException, obj7, string);
                                            facebookServiceException = new FacebookServiceException(obj6, string);
                                            this.a.t(facebookServiceException);
                                        }
                                    }
                                } else {
                                }
                            } else {
                            }
                        }
                    } else {
                    }
                } else {
                }
                return i;
            }
            if (l.M(string2, "fbconnect://cancel", i3, i4, i2)) {
                this.a.cancel();
                return i;
            }
            if (obj6 == null) {
                if (l.R(string2, "touch", i3, i4, i2)) {
                } else {
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(string2));
                    this.a.getContext().startActivity(intent);
                }
                return i;
            }
            return i3;
        }
    }

    @Metadata(d1 = "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008æ\u0080\u0001\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006", d2 = {"Lcom/facebook/internal/WebDialog$InitCallback;", "", "onInit", "", "webView", "Landroid/webkit/WebView;", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public interface d {
        public abstract void a(WebView webView);
    }

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008æ\u0080\u0001\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\u0008", d2 = {"Lcom/facebook/internal/WebDialog$OnCompleteListener;", "", "onComplete", "", "values", "Landroid/os/Bundle;", "error", "Lcom/facebook/FacebookException;", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public interface e {
        public abstract void a(Bundle bundle, FacebookException facebookException2);
    }

    @Metadata(d1 = "\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0010\u0002\n\u0002\u0008\u0003\u0008\u0082\u0004\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0012\u000e\u0012\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00030\u0001B\u0017\u0008\u0000\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u0008J+\u0010\r\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\u0010\u000e\u001a\n\u0012\u0006\u0008\u0001\u0012\u00020\u00020\u0003\"\u00020\u0002H\u0014¢\u0006\u0002\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\u00112\u0010\u0010\u0012\u001a\u000c\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\t\u001a\u0010\u0012\u000c\u0012\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b0\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000cR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014", d2 = {"Lcom/facebook/internal/WebDialog$UploadStagingResourcesTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "", "", "action", "parameters", "Landroid/os/Bundle;", "(Lcom/facebook/internal/WebDialog;Ljava/lang/String;Landroid/os/Bundle;)V", "exceptions", "Ljava/lang/Exception;", "Lkotlin/Exception;", "[Ljava/lang/Exception;", "doInBackground", "p0", "([Ljava/lang/Void;)[Ljava/lang/String;", "onPostExecute", "", "results", "([Ljava/lang/String;)V", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    private final class f extends AsyncTask<Void, Void, String[]> {

        private Exception[] a;
        private final String b;
        private final Bundle c;
        final com.facebook.internal.d0 d;
        public f(com.facebook.internal.d0 d0, String string2, Bundle bundle3) {
            n.f(string2, "action");
            n.f(bundle3, "parameters");
            this.d = d0;
            super();
            this.b = string2;
            this.c = bundle3;
            this.a = new Exception[0];
        }

        public static final Exception[] a(com.facebook.internal.d0.f d0$f) {
            return f.a;
        }

        @Override // android.os.AsyncTask
        protected String[] b(Void... voidArr) {
            String[] strArr;
            String str;
            int i;
            String string;
            boolean aVar;
            String[] obj11;
            final int i2 = 0;
            if (a.d(this)) {
                return i2;
            }
            n.f(voidArr, "p0");
            obj11 = this.c.getStringArray("media");
            if (obj11 != null) {
                n.e(obj11, "parameters.getStringArra…RAM_MEDIA) ?: return null");
                strArr = new String[obj11.length];
                this.a = new Exception[obj11.length];
                CountDownLatch countDownLatch = new CountDownLatch(obj11.length);
                ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
                i = 0;
                while (i < obj11.length) {
                    if (isCancelled()) {
                        break;
                    } else {
                    }
                    Uri parse = Uri.parse(obj11[i]);
                    if (b0.Y(parse)) {
                    } else {
                    }
                    aVar = new d0.f.a(this, strArr, i, countDownLatch);
                    concurrentLinkedQueue.add(c.b(a.H.e(), parse, aVar).j());
                    i++;
                    strArr[i] = parse.toString();
                    countDownLatch.countDown();
                }
                countDownLatch.await();
                return strArr;
            }
            return i2;
        }

        @Override // android.os.AsyncTask
        protected void c(String[] stringArr) {
            int i;
            Exception exc;
            if (a.d(this)) {
            }
            ProgressDialog progressDialog = d0.e(this.d);
            if (progressDialog != null) {
                progressDialog.dismiss();
            }
            Exception[] objArr = this.a;
            i = 0;
            while (i < objArr.length) {
                exc = objArr[i];
                i++;
            }
            String str = "Failed to stage photos for web dialog";
            if (stringArr == null) {
                FacebookException facebookException2 = new FacebookException(str);
                this.d.t(facebookException2);
            }
            List obj5 = i.d(stringArr);
            if (obj5.contains(0)) {
                FacebookException facebookException = new FacebookException(str);
                this.d.t(facebookException);
            }
            JSONArray jSONArray = new JSONArray(obj5);
            b0.j0(this.c, "media", jSONArray);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(o.p());
            stringBuilder.append("/");
            stringBuilder.append("dialog/");
            stringBuilder.append(this.b);
            d0.j(this.d, b0.f(z.b(), stringBuilder.toString(), this.c).toString());
            obj5 = d0.b(this.d);
            if (obj5 == null) {
            } else {
                obj5 = obj5.getDrawable();
                n.e(obj5, "checkNotNull(crossImageView).drawable");
                d0.i(this.d, obj5++);
            }
            IllegalStateException illegalStateException = new IllegalStateException("Required value was null.".toString());
            throw illegalStateException;
        }

        @Override // android.os.AsyncTask
        public Object doInBackground(Object[] objectArr) {
            if (a.d(this)) {
                return null;
            }
            return b((Void[])objectArr);
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Object object) {
            if (a.d(this)) {
            }
            c((String[])object);
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\u0008\u0005", d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 5, 1})
    static final class g implements View.OnClickListener {

        final com.facebook.internal.d0 a;
        g(com.facebook.internal.d0 d0) {
            this.a = d0;
            super();
        }

        @Override // android.view.View$OnClickListener
        public final void onClick(View view) {
            if (a.d(this)) {
            }
            this.a.cancel();
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\u0008\u0005", d2 = {"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"}, k = 3, mv = {1, 5, 1})
    static final class h implements DialogInterface.OnCancelListener {

        final com.facebook.internal.d0 a;
        h(com.facebook.internal.d0 d0) {
            this.a = d0;
            super();
        }

        @Override // android.content.DialogInterface$OnCancelListener
        public final void onCancel(DialogInterface dialogInterface) {
            this.a.cancel();
        }
    }

    @Metadata(d1 = "\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006", d2 = {"com/facebook/internal/WebDialog$setUpWebView$1", "Landroid/webkit/WebView;", "onWindowFocusChanged", "", "hasWindowFocus", "", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
    public static final class i extends WebView {
        i(com.facebook.internal.d0 d0, Context context2) {
            super(context2);
        }

        @Override // android.webkit.WebView
        public void onWindowFocusChanged(boolean z) {
            try {
                super.onWindowFocusChanged(z);
            }
        }
    }

    @Metadata(d1 = "\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\u0008\u0007", d2 = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"}, k = 3, mv = {1, 5, 1})
    static final class j implements View.OnTouchListener {

        public static final com.facebook.internal.d0.j a;
        static {
            d0.j jVar = new d0.j();
            d0.j.a = jVar;
        }

        @Override // android.view.View$OnTouchListener
        public final boolean onTouch(View view, MotionEvent motionEvent2) {
            if (!view.hasFocus()) {
                view.requestFocus();
            }
            return 0;
        }
    }
    static {
        d0.b bVar = new d0.b(0);
        d0.H = bVar;
        d0.E = e.a;
    }

    protected d0(Context context, String string2) {
        n.f(context, "context");
        n.f(string2, "url");
        super(context, string2, d0.H.a());
    }

    private d0(Context context, String string2, int i3) {
        int obj3;
        if (i3 == 0) {
            obj3 = d0.H.a();
        }
        super(context, obj3);
        this.b = "fbconnect://success";
        this.a = string2;
    }

    private d0(Context context, String string2, Bundle bundle3, int i4, s s5, com.facebook.internal.d0.e d0$e6) {
        boolean obj4;
        String obj5;
        Bundle obj6;
        int obj7;
        int obj8;
        if (i4 == 0) {
            obj7 = d0.H.a();
        }
        super(context, obj7);
        this.b = "fbconnect://success";
        if (bundle3 == null) {
            obj6 = new Bundle();
        }
        obj7 = b0.Q(context) ? "fbconnect://chrome_os_success" : obj7;
        this.b = obj7;
        obj6.putString("redirect_uri", obj7);
        obj6.putString("display", "touch");
        obj6.putString("client_id", o.g());
        obj4 = f0.a;
        obj7 = 1;
        Object[] arr = new Object[obj7];
        arr[0] = o.u();
        obj4 = String.format(Locale.ROOT, "android-%s", Arrays.copyOf(arr, obj7));
        n.e(obj4, "java.lang.String.format(locale, format, *args)");
        obj6.putString("sdk", obj4);
        this.c = e6;
        if (n.b(string2, "share") && obj6.containsKey("media")) {
            if (obj6.containsKey("media")) {
                obj4 = new d0.f(this, string2, obj6);
                this.z = obj4;
            } else {
                if (e0.a[s5.ordinal()] != obj7) {
                    obj7 = new StringBuilder();
                    obj7.append(o.p());
                    obj7.append("/");
                    obj7.append("dialog/");
                    obj7.append(string2);
                    obj4 = b0.f(z.b(), obj7.toString(), obj6);
                } else {
                    obj4 = b0.f(z.j(), "oauth/authorize", obj6);
                }
                this.a = obj4.toString();
            }
        } else {
        }
    }

    public d0(Context context, String string2, Bundle bundle3, int i4, s s5, com.facebook.internal.d0.e d0$e6, g g7) {
        super(context, string2, bundle3, i4, s5, e6);
    }

    public static final FrameLayout a(com.facebook.internal.d0 d0) {
        return d0.y;
    }

    public static final ImageView b(com.facebook.internal.d0 d0) {
        return d0.x;
    }

    public static final int c() {
        return d0.E;
    }

    public static final String d(com.facebook.internal.d0 d0) {
        return d0.b;
    }

    public static final ProgressDialog e(com.facebook.internal.d0 d0) {
        return d0.w;
    }

    public static final int f() {
        return d0.F;
    }

    public static final boolean g(com.facebook.internal.d0 d0) {
        return d0.B;
    }

    public static final void h(com.facebook.internal.d0 d0, boolean z2) {
        d0.C = z2;
    }

    public static final void i(com.facebook.internal.d0 d0, int i2) {
        d0.x(i2);
    }

    public static final void j(com.facebook.internal.d0 d0, String string2) {
        d0.a = string2;
    }

    public static final void k(int i) {
        d0.F = i;
    }

    private final void l() {
        Object gVar;
        ImageView view;
        ImageView imageView = new ImageView(getContext());
        this.x = imageView;
        if (imageView != null) {
            gVar = new d0.g(this);
            imageView.setOnClickListener(gVar);
        }
        Context context = getContext();
        n.e(context, "context");
        view = this.x;
        if (view != null) {
            view.setImageDrawable(context.getResources().getDrawable(a.a));
        }
        ImageView view2 = this.x;
        if (view2 != null) {
            view2.setVisibility(4);
        }
    }

    private final int m(int i, float f2, int i3, int i4) {
        long l;
        int i2;
        int obj6;
        int obj8;
        obj6 = (int)i5;
        l = 4602678819172646912L;
        if (obj6 <= i3) {
            l = 4607182418800017408L;
        } else {
            if (obj6 >= i4) {
            } else {
                l += i2;
            }
        }
        return (int)obj5;
    }

    public static final com.facebook.internal.d0 q(Context context, String string2, Bundle bundle3, int i4, s s5, com.facebook.internal.d0.e d0$e6) {
        return d0.H.d(context, string2, bundle3, i4, s5, e6);
    }

    private final void x(int i) {
        Object settings3;
        Object settings;
        Object settings2;
        int i2;
        com.facebook.internal.d0.c cVar;
        String layoutParams;
        int i3;
        LinearLayout linearLayout = new LinearLayout(getContext());
        d0.i iVar = new d0.i(this, getContext());
        this.v = iVar;
        com.facebook.internal.d0.d dVar = d0.G;
        if (dVar != null) {
            dVar.a(iVar);
        }
        WebView view = this.v;
        i2 = 0;
        if (view != null) {
            view.setVerticalScrollBarEnabled(i2);
        }
        WebView view2 = this.v;
        if (view2 != null) {
            view2.setHorizontalScrollBarEnabled(i2);
        }
        WebView view3 = this.v;
        if (view3 != null) {
            cVar = new d0.c(this);
            view3.setWebViewClient(cVar);
        }
        settings3 = this.v;
        int i4 = 1;
        settings3 = settings3.getSettings();
        if (settings3 != null && settings3 != null) {
            settings3 = settings3.getSettings();
            if (settings3 != null) {
                settings3.setJavaScriptEnabled(i4);
            }
        }
        WebView view4 = this.v;
        if (view4 != null) {
            layoutParams = this.a;
            if (layoutParams == null) {
            } else {
                view4.loadUrl(layoutParams);
            }
            IllegalStateException obj7 = new IllegalStateException("Required value was null.".toString());
            throw obj7;
        }
        WebView view5 = this.v;
        if (view5 != null) {
            i3 = -1;
            layoutParams = new FrameLayout.LayoutParams(i3, i3);
            view5.setLayoutParams(layoutParams);
        }
        WebView view6 = this.v;
        if (view6 != null) {
            view6.setVisibility(4);
        }
        settings = this.v;
        settings = settings.getSettings();
        if (settings != null && settings != null) {
            settings = settings.getSettings();
            if (settings != null) {
                settings.setSavePassword(i2);
            }
        }
        settings2 = this.v;
        settings2 = settings2.getSettings();
        if (settings2 != null && settings2 != null) {
            settings2 = settings2.getSettings();
            if (settings2 != null) {
                settings2.setSaveFormData(i2);
            }
        }
        WebView view7 = this.v;
        if (view7 != null) {
            view7.setFocusable(i4);
        }
        WebView view8 = this.v;
        if (view8 != null) {
            view8.setFocusableInTouchMode(i4);
        }
        WebView view9 = this.v;
        if (view9 != null) {
            view9.setOnTouchListener(d0.j.a);
        }
        linearLayout.setPadding(i, i, i, i);
        linearLayout.addView(this.v);
        linearLayout.setBackgroundColor(-872415232);
        obj7 = this.y;
        if (obj7 != null) {
            obj7.addView(linearLayout);
        }
    }

    @Override // android.app.Dialog
    public void cancel() {
        com.facebook.internal.d0.e facebookOperationCanceledException;
        if (this.c != null && !this.A) {
            if (!this.A) {
                facebookOperationCanceledException = new FacebookOperationCanceledException();
                t(facebookOperationCanceledException);
            }
        }
    }

    @Override // android.app.Dialog
    public void dismiss() {
        boolean z;
        boolean showing;
        WebView view = this.v;
        if (view != null) {
            view.stopLoading();
        }
        z = this.w;
        if (!this.B && z != null && z.isShowing()) {
            z = this.w;
            if (z != null) {
                if (z.isShowing()) {
                    z.dismiss();
                }
            }
        }
        super.dismiss();
    }

    @Override // android.app.Dialog
    protected final WebView n() {
        return this.v;
    }

    @Override // android.app.Dialog
    protected final boolean o() {
        return this.A;
    }

    @Override // android.app.Dialog
    public void onAttachedToWindow() {
        boolean string;
        int token;
        android.os.IBinder token2;
        Object ownerActivity;
        this.B = false;
        Context context = getContext();
        n.e(context, "context");
        string = this.D;
        if (b0.h0(context) && string != null) {
            string = this.D;
            if (string != null) {
                token = 0;
                token2 = string != null ? string.token : token;
                if (token2 == null && string != null) {
                    if (string != null) {
                        ownerActivity = getOwnerActivity();
                        ownerActivity = ownerActivity.getWindow();
                        ownerActivity = ownerActivity.getAttributes();
                        if (ownerActivity != null && ownerActivity != null && ownerActivity != null) {
                            ownerActivity = ownerActivity.getWindow();
                            if (ownerActivity != null) {
                                ownerActivity = ownerActivity.getAttributes();
                                token2 = ownerActivity != null ? ownerActivity.token : token;
                            } else {
                            }
                        } else {
                        }
                        string.token = token2;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Set token on onAttachedToWindow(): ");
                    token2 = this.D;
                    if (token2 != null) {
                        token = token2.token;
                    }
                    stringBuilder.append(token);
                    b0.d0("FacebookSDK.WebDialog", stringBuilder.toString());
                }
            }
        }
        super.onAttachedToWindow();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        int i;
        String hVar;
        Context context;
        int layoutParams;
        int i2;
        String obj5;
        super.onCreate(bundle);
        obj5 = new ProgressDialog(getContext());
        this.w = obj5;
        i = 1;
        if (obj5 != null) {
            obj5.requestWindowFeature(i);
        }
        obj5 = this.w;
        if (obj5 != null) {
            obj5.setMessage(getContext().getString(d.d));
        }
        obj5 = this.w;
        if (obj5 != null) {
            obj5.setCanceledOnTouchOutside(false);
        }
        obj5 = this.w;
        if (obj5 != null) {
            hVar = new d0.h(this);
            obj5.setOnCancelListener(hVar);
        }
        requestWindowFeature(i);
        obj5 = new FrameLayout(getContext());
        this.y = obj5;
        s();
        obj5 = getWindow();
        if (obj5 != null) {
            obj5.setGravity(17);
        }
        obj5 = getWindow();
        if (obj5 != null) {
            obj5.setSoftInputMode(16);
        }
        l();
        String str = "Required value was null.";
        if (this.a != null) {
            obj5 = this.x;
            if (obj5 == null) {
            } else {
                obj5 = obj5.getDrawable();
                n.e(obj5, "checkNotNull(crossImageView).drawable");
                x(obj5 += i);
            }
            obj5 = new IllegalStateException(str.toString());
            throw obj5;
        }
        obj5 = this.y;
        if (obj5 != null) {
            i2 = -2;
            layoutParams = new ViewGroup.LayoutParams(i2, i2);
            obj5.addView(this.x, layoutParams);
        }
        obj5 = this.y;
        if (obj5 == null) {
        } else {
            setContentView(obj5);
        }
        obj5 = new IllegalStateException(str.toString());
        throw obj5;
    }

    @Override // android.app.Dialog
    public void onDetachedFromWindow() {
        this.B = true;
        super.onDetachedFromWindow();
    }

    @Override // android.app.Dialog
    public boolean onKeyDown(int i, KeyEvent keyEvent2) {
        WebView goBack;
        int i2;
        n.f(keyEvent2, "event");
        goBack = this.v;
        i2 = 1;
        WebView obj3 = this.v;
        if (i == 4 && goBack != null && goBack != null && goBack.canGoBack() == i2 && obj3 != null) {
            goBack = this.v;
            if (goBack != null) {
                if (goBack != null) {
                    i2 = 1;
                    if (goBack.canGoBack() == i2) {
                        obj3 = this.v;
                        if (obj3 != null) {
                            obj3.goBack();
                        }
                        return i2;
                    }
                }
            }
            cancel();
        }
        return super.onKeyDown(i, keyEvent2);
    }

    @Override // android.app.Dialog
    protected void onStart() {
        Object status;
        AsyncTask.Status pENDING;
        super.onStart();
        status = this.z;
        if (status != null) {
            if (status != null) {
                status = status.getStatus();
            } else {
                status = 0;
            }
            if (status == AsyncTask.Status.PENDING) {
                com.facebook.internal.d0.f fVar = this.z;
                if (fVar != null) {
                    fVar.execute(new Void[0]);
                }
                status = this.w;
                if (status != null) {
                    status.show();
                }
            } else {
                s();
            }
        } else {
        }
    }

    @Override // android.app.Dialog
    protected void onStop() {
        Object fVar;
        int i;
        fVar = this.z;
        fVar.cancel(true);
        fVar = this.w;
        if (fVar != null && fVar != null) {
            fVar.cancel(true);
            fVar = this.w;
            if (fVar != null) {
                fVar.dismiss();
            }
        }
        super.onStop();
    }

    @Override // android.app.Dialog
    public void onWindowAttributesChanged(WindowManager.LayoutParams windowManager$LayoutParams) {
        n.f(layoutParams, "params");
        if (layoutParams.token == null) {
            this.D = layoutParams;
        }
        super.onWindowAttributesChanged(layoutParams);
    }

    @Override // android.app.Dialog
    protected final boolean p() {
        return this.C;
    }

    @Override // android.app.Dialog
    public Bundle r(String string) {
        Uri obj2 = Uri.parse(string);
        n.e(obj2, "u");
        Bundle bundle = b0.i0(obj2.getQuery());
        bundle.putAll(b0.i0(obj2.getFragment()));
        return bundle;
    }

    @Override // android.app.Dialog
    public final void s() {
        int widthPixels;
        int i;
        Object systemService = getContext().getSystemService("window");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        (WindowManager)systemService.getDefaultDisplay().getMetrics(displayMetrics);
        widthPixels = displayMetrics.widthPixels;
        int heightPixels2 = displayMetrics.heightPixels;
        i = widthPixels < heightPixels2 ? widthPixels : heightPixels2;
        if (widthPixels < heightPixels2) {
            widthPixels = heightPixels2;
        }
        final int i8 = 800;
        Window window = getWindow();
        if (window != null) {
            window.setLayout(Math.min(m(i, displayMetrics.density, 480, i8), displayMetrics.widthPixels), Math.min(m(widthPixels, displayMetrics.density, i8, 1280), displayMetrics.heightPixels));
        }
    }

    @Override // android.app.Dialog
    protected final void t(Throwable throwable) {
        boolean facebookException;
        com.facebook.internal.d0.e eVar;
        int i;
        Object obj3;
        if (this.c != null && !this.A) {
            if (!this.A) {
                this.A = true;
                if (throwable instanceof FacebookException != null) {
                } else {
                    facebookException = new FacebookException((FacebookException)throwable);
                    obj3 = facebookException;
                }
                eVar = this.c;
                if (eVar != null) {
                    eVar.a(0, obj3);
                }
                dismiss();
            }
        }
    }

    @Override // android.app.Dialog
    protected final void u(Bundle bundle) {
        int z;
        final com.facebook.internal.d0.e eVar = this.c;
        this.A = true;
        if (eVar != null && !this.A && eVar != null) {
            if (!this.A) {
                this.A = true;
                if (eVar != null) {
                    eVar.a(bundle, 0);
                }
                dismiss();
            }
        }
    }

    @Override // android.app.Dialog
    protected final void v(String string) {
        n.f(string, "expectedRedirectUrl");
        this.b = string;
    }

    @Override // android.app.Dialog
    public final void w(com.facebook.internal.d0.e d0$e) {
        this.c = e;
    }
}
