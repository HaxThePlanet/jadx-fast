package zendesk.answerbot;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import f.g.c.a;
import f.g.e.g;
import java.nio.charset.Charset;
import java.util.Locale;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes3.dex */
final class ZendeskWebViewClient extends WebViewClient {

    private final OkHttpClient okHttpClient;
    private zendesk.answerbot.ZendeskWebViewClient.OnLinkClickListener onLinkClickListener;
    private final String url;

    interface OnLinkClickListener {
        public abstract boolean onLinkClicked(String string);
    }
    ZendeskWebViewClient(String string, OkHttpClient okHttpClient2) {
        super();
        this.url = string;
        this.okHttpClient = okHttpClient2;
    }

    @Override // android.webkit.WebViewClient
    public void setOnLinkClickListener(zendesk.answerbot.ZendeskWebViewClient.OnLinkClickListener zendeskWebViewClient$OnLinkClickListener) {
        this.onLinkClickListener = onLinkClickListener;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String string2) {
        Object okHttpClient;
        java.io.InputStream inputStream;
        int i2;
        WebView view;
        String format;
        Locale str;
        String subtype2;
        int i;
        String subtype;
        int obj9;
        int obj10;
        i2 = 0;
        if (!string2.startsWith(this.url)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Will not intercept request because the url is not hosted by Zendesk. URL=");
            stringBuilder.append(string2);
            a.k("ZendeskWebViewClient", stringBuilder.toString(), new Object[i2]);
            return super.shouldInterceptRequest(webView, string2);
        }
        obj9 = 0;
        Request.Builder builder = new Request.Builder();
        obj10 = FirebasePerfOkHttpClient.execute(this.okHttpClient.newCall(builder.url(string2).build()));
        obj10 = obj10.body();
        if (obj10 != null && obj10.isSuccessful() && obj10 != null) {
            if (obj10.isSuccessful()) {
                obj10 = obj10.body();
                if (obj10 != null) {
                    obj10 = obj10.contentType();
                    if (obj10 != null) {
                        int i3 = 2;
                        String[] strArr = new String[i3];
                        strArr[i2] = obj10.type();
                        i = 1;
                        strArr[i] = obj10.subtype();
                        if (g.d(strArr)) {
                            Object[] arr3 = new Object[i3];
                            arr3[i2] = obj10.type();
                            arr3[i] = obj10.subtype();
                            format = String.format(Locale.US, "%s/%s", arr3);
                        } else {
                            format = obj9;
                        }
                        obj10 = obj10.charset();
                        if (obj10 != null) {
                            obj9 = obj10.name();
                        }
                        obj10 = obj9;
                    } else {
                        format = obj10;
                    }
                    obj9 = okHttpClient;
                } else {
                    format = obj10;
                }
            } else {
            }
        } else {
        }
        inputStream = obj9;
        obj10 = new WebResourceResponse(format, obj10, inputStream);
        return obj10;
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String string2) {
        int obj2;
        zendesk.answerbot.ZendeskWebViewClient.OnLinkClickListener onLinkClickListener = this.onLinkClickListener;
        if (onLinkClickListener != null) {
            if (!onLinkClickListener.onLinkClicked(string2)) {
                if (super.shouldOverrideUrlLoading(webView, string2)) {
                    obj2 = 1;
                } else {
                    obj2 = 0;
                }
            } else {
            }
            return obj2;
        }
        return super.shouldOverrideUrlLoading(webView, string2);
    }
}
