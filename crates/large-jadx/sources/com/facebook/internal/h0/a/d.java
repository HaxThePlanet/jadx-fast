package com.facebook.internal.h0.a;

import android.content.res.Resources;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.k0.l;

/* loaded from: classes.dex */
@Metadata(d1 = "\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0008\u0007\u0018\u0000 \u00102\u00020\u0001:\u0002\u0010\u0011B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cJ\u000e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fR\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00080\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012", d2 = {"Lcom/facebook/internal/logging/dumpsys/WebViewDumpHelper;", "", "()V", "webViewHTMLs", "", "", "webViews", "", "Lcom/facebook/internal/logging/dumpsys/WebViewDumpHelper$WebViewData;", "dump", "", "writer", "Ljava/io/PrintWriter;", "handle", "view", "Landroid/webkit/WebView;", "Companion", "WebViewData", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
public final class d {

    public static final com.facebook.internal.h0.a.d.a c;
    private final Set<com.facebook.internal.h0.a.d.b> a;
    private final Map<String, String> b;

    @Metadata(d1 = "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0008\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Lcom/facebook/internal/logging/dumpsys/WebViewDumpHelper$Companion;", "", "()V", "GET_WEBVIEW_HTML_JS_SCRIPT", "", "fixHtmlString", "data", "Lcom/facebook/internal/logging/dumpsys/WebViewDumpHelper$WebViewData;", "html", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a(g g) {
            super();
        }

        public static final String a(com.facebook.internal.h0.a.d.a d$a, com.facebook.internal.h0.a.d.b d$b2, String string3) {
            return a.b(b2, string3);
        }

        private final String b(com.facebook.internal.h0.a.d.b d$b, String string2) {
            int i6 = 0;
            int i8 = 4;
            final int i11 = 0;
            String obj14 = l.G(l.G(l.G(string2, "\\u003C", "<", i6, i8, i11), "\\n", "", false, 4, 0), "\\\"", "\"", i6, i8, i11);
            f0 f0Var = f0.a;
            int i = 6;
            Object[] arr = new Object[i];
            arr[i6] = b.b();
            int i7 = 1;
            arr[i7] = Integer.valueOf(b.c());
            arr[2] = Integer.valueOf(b.d());
            arr[3] = Integer.valueOf(b.e());
            arr[4] = Integer.valueOf(b.a());
            Objects.requireNonNull(obj14, "null cannot be cast to non-null type java.lang.String");
            String obj13 = obj14.substring(i7, obj13 -= i7);
            n.e(obj13, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            arr[5] = obj13;
            obj13 = String.format("<html id=\"%s\" data-rect=\"%d,%d,%d,%d\">%s</html>", Arrays.copyOf(arr, i));
            n.e(obj13, "java.lang.String.format(format, *args)");
            return obj13;
        }
    }

    @Metadata(d1 = "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u000e\n\u0002\u0008\n\u0008\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0007\u0010\u0008R\u0011\u0010\t\u001a\u00020\n¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000b\u0010\u000cR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u000e\u0010\u0008R\u0011\u0010\u000f\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0010\u0010\u0008R\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0012\u0010\u0008¨\u0006\u0014", d2 = {"Lcom/facebook/internal/logging/dumpsys/WebViewDumpHelper$WebViewData;", "", "webView", "Landroid/webkit/WebView;", "(Landroid/webkit/WebView;)V", "height", "", "getHeight", "()I", "key", "", "getKey", "()Ljava/lang/String;", "left", "getLeft", "top", "getTop", "width", "getWidth", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1})
    private static final class b {

        private static final int[] f;
        private final String a;
        private final int b;
        private final int c;
        private final int d;
        private final int e;
        static {
            d.b.f = new int[2];
        }

        public b(WebView webView) {
            n.f(webView, "webView");
            super();
            f0 f0Var = f0.a;
            int i = 2;
            Object[] arr = new Object[i];
            final int i5 = 0;
            arr[i5] = webView.getClass().getName();
            final int i6 = 1;
            arr[i6] = Integer.toHexString(webView.hashCode());
            String format = String.format("%s{%s}", Arrays.copyOf(arr, i));
            n.e(format, "java.lang.String.format(format, *args)");
            this.a = format;
            int[] iArr = d.b.f;
            webView.getLocationOnScreen(iArr);
            this.b = iArr[i5];
            this.c = iArr[i6];
            this.d = webView.getWidth();
            this.e = webView.getHeight();
        }

        public final int a() {
            return this.e;
        }

        public final String b() {
            return this.a;
        }

        public final int c() {
            return this.b;
        }

        public final int d() {
            return this.c;
        }

        public final int e() {
            return this.d;
        }
    }

    @Metadata(d1 = "\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\u0008\u0005", d2 = {"<anonymous>", "", "html", "", "kotlin.jvm.PlatformType", "onReceiveValue"}, k = 3, mv = {1, 5, 1})
    static final class c implements ValueCallback {

        final com.facebook.internal.h0.a.d a;
        final com.facebook.internal.h0.a.d.b b;
        c(com.facebook.internal.h0.a.d d, com.facebook.internal.h0.a.d.b d$b2) {
            this.a = d;
            this.b = b2;
            super();
        }

        @Override // android.webkit.ValueCallback
        public final void a(String string) {
            n.e(string, "html");
            d.a(this.a).put(this.b.b(), string);
        }

        @Override // android.webkit.ValueCallback
        public void onReceiveValue(Object object) {
            a((String)object);
        }
    }
    static {
        d.a aVar = new d.a(0);
        d.c = aVar;
    }

    public d() {
        super();
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.a = linkedHashSet;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.b = linkedHashMap;
    }

    public static final Map a(com.facebook.internal.h0.a.d d) {
        return d.b;
    }

    public final void b(PrintWriter printWriter) {
        Object next;
        Object obj2;
        Object obj;
        n.f(printWriter, "writer");
        Iterator iterator = this.a.iterator();
        while (iterator.hasNext()) {
            next = iterator.next();
            obj2 = this.b.get((d.b)next.b());
            if ((String)obj2 != null) {
            }
            printWriter.print("WebView HTML for ");
            printWriter.print(next);
            printWriter.println(":");
            printWriter.println(d.a.a(d.c, next, (String)obj2));
        }
        this.a.clear();
        this.b.clear();
    }

    public final void c(WebView webView) {
        n.f(webView, "view");
        d.b bVar = new d.b(webView);
        this.a.add(bVar);
        Resources resources = webView.getResources();
        n.e(resources, "view.resources");
        f0 f0Var = f0.a;
        int i = 3;
        final Object[] arr = new Object[i];
        arr[0] = Integer.valueOf(bVar.c());
        arr[1] = Integer.valueOf(bVar.d());
        arr[2] = Float.valueOf(displayMetrics.scaledDensity);
        String format = String.format("(function() {  try {    const leftOf = %d;    const topOf = %d;    const density = %f;    const elements = Array.from(document.querySelectorAll('body, body *'));    for (const el of elements) {      const rect = el.getBoundingClientRect();      const left = Math.round(leftOf + rect.left * density);      const top = Math.round(topOf + rect.top * density);      const width = Math.round(rect.width * density);      const height = Math.round(rect.height * density);      el.setAttribute('data-rect', `${left},${top},${width},${height}`);      const style = window.getComputedStyle(el);      const hidden = style.display === 'none' || style.visibility !== 'visible' || el.getAttribute('hidden') === 'true';      const disabled = el.disabled || el.getAttribute('aria-disabled') === 'true';      const focused = el === document.activeElement;      if (hidden || disabled || focused) {        el.setAttribute('data-flag', `${hidden ? 'H' : ''}${disabled ? 'D' : ''}${focused ? 'F' : ''}`);      } else {        el.removeAttribute('data-flag');      }    }    document.activeElement.setAttribute('focused', 'true');    const doc = document.cloneNode(true);    for (const el of Array.from(doc.querySelectorAll('script, link'))) {      el.remove();    }    for (const el of Array.from(doc.querySelectorAll('*'))) {      el.removeAttribute('class');    }    return doc.getElementsByTagName('body')[0].outerHTML.trim();  } catch (e) {    return 'Failed: ' + e;  }})();", Arrays.copyOf(arr, i));
        n.e(format, "java.lang.String.format(format, *args)");
        d.c cVar = new d.c(this, bVar);
        webView.evaluateJavascript(format, cVar);
    }
}
