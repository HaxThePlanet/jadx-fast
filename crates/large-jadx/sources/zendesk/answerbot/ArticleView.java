package zendesk.answerbot;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.os.c;
import androidx.core.os.e;
import com.google.android.material.snackbar.Snackbar;
import f.g.c.a;
import f.g.e.g;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.util.Locale;
import java.util.Scanner;
import zendesk.commonui.AlmostRealProgressBar;
import zendesk.commonui.d;
import zendesk.core.User;
import zendesk.support.Article;

/* loaded from: classes3.dex */
public class ArticleView extends CoordinatorLayout {

    private String css;
    private DateFormat dateFormat;
    private Snackbar errorView;
    private AlmostRealProgressBar loadingIndicator;
    private Locale locale;
    private View.OnClickListener onRetryListener;
    private Resources resources;
    private Toolbar toolbar;
    private WebView webView;
    public ArticleView(Context context, AttributeSet attributeSet2) {
        super(context, attributeSet2);
        init(context);
    }

    static String access$000(zendesk.answerbot.ArticleView articleView) {
        return articleView.getCss();
    }

    static Resources access$100(zendesk.answerbot.ArticleView articleView) {
        return articleView.resources;
    }

    static WebView access$200(zendesk.answerbot.ArticleView articleView) {
        return articleView.webView;
    }

    private static void configureWebView(WebView webView) {
        WebChromeClient webChromeClient = new WebChromeClient();
        webView.setWebChromeClient(webChromeClient);
        WebViewClient webViewClient = new WebViewClient();
        webView.setWebViewClient(webViewClient);
        webView.getSettings().setJavaScriptEnabled(true);
    }

    private String getCss() {
        boolean cssFileAsString;
        if (g.e(this.css)) {
            this.css = getCssFileAsString();
        }
        return this.css;
    }

    private String getCssFileAsString() {
        Throwable th2;
        String next;
        Throwable th3;
        Scanner useDelimiter;
        int arr;
        int i;
        Throwable th4;
        InputStream open;
        Throwable th;
        boolean next2;
        String str;
        String str2;
        Object[] arr2;
        final String str3 = "Failed to close CSS InputStream.";
        final String str4 = "ArticleView";
        next = "";
        int i2 = 0;
        i = 0;
        open = getContext().getAssets().open("help_center_article_style.css");
        Scanner scanner = new Scanner(open, "UTF-8");
        useDelimiter = scanner.useDelimiter("\\A");
        if (useDelimiter.hasNext()) {
            next = useDelimiter.next();
        }
        if (useDelimiter != null) {
            useDelimiter.close();
        }
        if (open != null) {
            open.close();
        }
        return next;
    }

    private void init(Context context) {
        View inflate = ViewGroup.inflate(context, R.layout.zui_view_article, this);
        this.toolbar = (Toolbar)inflate.findViewById(R.id.zui_toolbar);
        this.webView = (WebView)inflate.findViewById(R.id.zui_webview);
        this.loadingIndicator = (AlmostRealProgressBar)inflate.findViewById(R.id.zui_progressbar);
        this.resources = context.getResources();
        Locale obj3 = c.a(getResources().getConfiguration()).c(0);
        this.locale = obj3;
        this.dateFormat = DateFormat.getDateInstance(1, obj3);
        ArticleView.configureWebView(this.webView);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout
    boolean canGoBack() {
        return this.webView.canGoBack();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout
    void goBack() {
        this.webView.goBack();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout
    void setOnRetryListener(View.OnClickListener view$OnClickListener) {
        this.onRetryListener = onClickListener;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout
    void setTitle(String string) {
        this.toolbar.setTitle(d.a(string));
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout
    void setWebViewClient(WebViewClient webViewClient) {
        this.webView.setWebViewClient(webViewClient);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout
    void showArticle(Article article) {
        String format2;
        String format;
        int name;
        java.util.Date createdAt;
        Object author;
        Object[] arr;
        String string;
        int zab_view_article_separator;
        if (article == null) {
        }
        if (article.getCreatedAt() != null) {
            format2 = this.dateFormat.format(article.getCreatedAt());
        } else {
            format2 = name;
        }
        if (article.getAuthor() != null) {
            name = article.getAuthor().getName();
        }
        if (format2 != null && name != null) {
            if (name != null) {
                arr = new Object[3];
                format = String.format(this.locale, "%s %s <span dir=\"auto\">%s</span>", name, this.resources.getString(R.string.zab_view_article_separator), format2);
            } else {
                format = "";
            }
        } else {
        }
        ArticleView.1 anon = new ArticleView.1(this, article, format);
        AsyncTask.execute(anon);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout
    void showError(boolean z) {
        Snackbar zui_retry_button_label;
        int onRetryListener;
        Snackbar obj3;
        zui_retry_button_label = this.errorView;
        onRetryListener = zui_retry_button_label != null ? 1 : 0;
        if (z == null && onRetryListener != null) {
            if (onRetryListener != null) {
                zui_retry_button_label.u();
                this.errorView = 0;
            } else {
                if (z != null && onRetryListener == null) {
                    if (onRetryListener == null) {
                        obj3 = Snackbar.d0(this, R.string.zab_error_load_article, -2);
                        this.errorView = obj3;
                        obj3.g0(R.string.zui_retry_button_label, this.onRetryListener);
                        this.errorView.T();
                    }
                }
            }
        } else {
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout
    void showLoading(boolean z) {
        java.util.List list;
        AlmostRealProgressBar obj3;
        if (z) {
            this.loadingIndicator.n(AlmostRealProgressBar.y);
        } else {
            this.loadingIndicator.p(300);
        }
    }
}
