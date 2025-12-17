package zendesk.support.guide;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.a;
import androidx.appcompat.app.d;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.os.c;
import androidx.core.os.e;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.zendesk.service.a;
import com.zendesk.service.e;
import com.zendesk.service.f;
import f.g.b.a.e;
import f.g.b.a.f;
import f.g.b.a.h;
import f.g.b.a.i;
import f.g.c.a;
import f.g.e.a;
import f.g.e.c;
import f.g.e.g;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import o.a.b;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;
import zendesk.commonui.d;
import zendesk.core.ActionDescription;
import zendesk.core.ActionHandler;
import zendesk.core.ActionHandlerRegistry;
import zendesk.core.ApplicationConfiguration;
import zendesk.core.NetworkAware;
import zendesk.core.NetworkInfoProvider;
import zendesk.messaging.Engine;
import zendesk.messaging.MessagingActivity;
import zendesk.messaging.MessagingConfiguration.Builder;
import zendesk.support.Article;
import zendesk.support.ArticleVoteStorage;
import zendesk.support.AttachmentType;
import zendesk.support.HelpCenterAttachment;
import zendesk.support.HelpCenterProvider;
import zendesk.support.HelpCenterSettings;
import zendesk.support.HelpCenterSettingsProvider;

/* loaded from: classes3.dex */
public class ViewArticleActivity extends d implements AdapterView.OnItemClickListener {

    private static final String ARTICLE_DETAIL_FORMAT_STRING = "%s %s <span dir=\"auto\">%s</span>";
    private static final String CSS_FILE = "file:///android_asset/help_center_article_style.css";
    private static final long FETCH_ATTACHMENTS_DELAY_MILLIS = 250L;
    static final String LOG_TAG = "ViewArticleActivity";
    private static final Integer NETWORK_AWARE_ID = null;
    private static final String TYPE_TEXT_HTML = "text/html";
    private static final String UTF_8_ENCODING_TYPE = "UTF-8";
    ActionHandlerRegistry actionHandlerRegistry;
    private zendesk.support.guide.ViewArticleActivity.ArticleAttachmentAdapter adapter;
    ApplicationConfiguration applicationConfiguration;
    private zendesk.support.guide.ArticleViewModel article;
    private WebView articleContentWebView;
    private Long articleId;
    ArticleVoteStorage articleVoteStorage;
    private zendesk.support.guide.ArticleVotingView articleVotingView;
    private ListView attachmentListView;
    private e<List<HelpCenterAttachment>> attachmentRequestCallback;
    private zendesk.support.guide.ArticleConfiguration config;
    b configurationHelper;
    private CoordinatorLayout coordinatorLayout;
    private List<Engine> engines;
    private final Handler handler;
    HelpCenterProvider helpCenterProvider;
    private final NetworkAware networkConnectionCallbacks;
    NetworkInfoProvider networkInfoProvider;
    OkHttpClient okHttpClient;
    private ProgressBar progressView;
    private final zendesk.support.guide.AggregatedCallback<HelpCenterSettings> settingsAggregatedCallback;
    HelpCenterSettingsProvider settingsProvider;
    private Snackbar snackbar;

    private static class ArticleAttachmentAdapter extends ArrayAdapter<HelpCenterAttachment> {
        ArticleAttachmentAdapter(Context context) {
            super(context, f.f);
        }

        @Override // android.widget.ArrayAdapter
        public View getView(int i, View view2, ViewGroup viewGroup3) {
            Object obj2;
            boolean obj3;
            if (view2 instanceof ViewArticleActivity.ArticleAttachmentRow) {
            } else {
                obj2 = new ViewArticleActivity.ArticleAttachmentRow(getContext());
            }
            obj2.bind((HelpCenterAttachment)getItem(i));
            return obj2;
        }
    }

    private static class ArticleAttachmentRow extends RelativeLayout {

        private final TextView fileName;
        private final TextView fileSize;
        public ArticleAttachmentRow(Context context) {
            super(context);
            RelativeLayout.inflate(context, f.f, this);
            this.fileName = (TextView)findViewById(e.a);
            this.fileSize = (TextView)findViewById(e.b);
        }

        @Override // android.widget.RelativeLayout
        public void bind(HelpCenterAttachment helpCenterAttachment) {
            this.fileName.setText(helpCenterAttachment.getFileName());
            this.fileSize.setText(c.b(helpCenterAttachment.getSize()));
        }
    }

    private static enum LoadingState {

        LOADING,
        DISPLAYING,
        ERRORED,
        ERRORED_ATTACHMENT;
    }

    class AttachmentRequestCallback extends f<List<HelpCenterAttachment>> {

        final zendesk.support.guide.ViewArticleActivity this$0;
        AttachmentRequestCallback(zendesk.support.guide.ViewArticleActivity viewArticleActivity) {
            this.this$0 = viewArticleActivity;
            super();
        }

        @Override // com.zendesk.service.f
        public void onError(a a) {
            ViewArticleActivity.access$1000(this.this$0).clear();
            this.this$0.setLoadingState(ViewArticleActivity.LoadingState.ERRORED_ATTACHMENT);
            a.c("ViewArticleActivity", a);
        }

        @Override // com.zendesk.service.f
        public void onSuccess(Object object) {
            onSuccess((List)object);
        }

        public void onSuccess(List<HelpCenterAttachment> list) {
            ViewArticleActivity.access$1000(this.this$0).clear();
            ViewArticleActivity.access$1000(this.this$0).addAll(list);
            ViewArticleActivity.access$1200(ViewArticleActivity.access$1100(this.this$0));
            this.this$0.setLoadingState(ViewArticleActivity.LoadingState.DISPLAYING);
        }
    }
    static {
        ViewArticleActivity.NETWORK_AWARE_ID = 57564;
    }

    public ViewArticleActivity() {
        super();
        AggregatedCallback aggregatedCallback = new AggregatedCallback();
        this.settingsAggregatedCallback = aggregatedCallback;
        Handler handler = new Handler();
        this.handler = handler;
        ViewArticleActivity.6 anon = new ViewArticleActivity.6(this);
        this.networkConnectionCallbacks = anon;
    }

    static zendesk.support.guide.ArticleConfiguration access$000(zendesk.support.guide.ViewArticleActivity viewArticleActivity) {
        return viewArticleActivity.config;
    }

    static zendesk.support.guide.ArticleViewModel access$100(zendesk.support.guide.ViewArticleActivity viewArticleActivity) {
        return viewArticleActivity.article;
    }

    static zendesk.support.guide.ViewArticleActivity.ArticleAttachmentAdapter access$1000(zendesk.support.guide.ViewArticleActivity viewArticleActivity) {
        return viewArticleActivity.adapter;
    }

    static zendesk.support.guide.ArticleViewModel access$102(zendesk.support.guide.ViewArticleActivity viewArticleActivity, zendesk.support.guide.ArticleViewModel articleViewModel2) {
        viewArticleActivity.article = articleViewModel2;
        return articleViewModel2;
    }

    static ListView access$1100(zendesk.support.guide.ViewArticleActivity viewArticleActivity) {
        return viewArticleActivity.attachmentListView;
    }

    static void access$1200(ListView listView) {
        ViewArticleActivity.setListViewHeightBasedOnChildren(listView);
    }

    static zendesk.support.guide.ArticleVotingView access$1300(zendesk.support.guide.ViewArticleActivity viewArticleActivity) {
        return viewArticleActivity.articleVotingView;
    }

    static void access$200(zendesk.support.guide.ViewArticleActivity viewArticleActivity) {
        viewArticleActivity.loadArticleBody();
    }

    static void access$300(zendesk.support.guide.ViewArticleActivity viewArticleActivity, long l2) {
        viewArticleActivity.fetchAttachmentsForArticle(l2);
    }

    static void access$400(zendesk.support.guide.ViewArticleActivity viewArticleActivity) {
        viewArticleActivity.applyVoteButtonSettings();
    }

    static Long access$500(zendesk.support.guide.ViewArticleActivity viewArticleActivity) {
        return viewArticleActivity.articleId;
    }

    static void access$600(zendesk.support.guide.ViewArticleActivity viewArticleActivity, long l2) {
        viewArticleActivity.fetchArticle(l2);
    }

    static void access$700(zendesk.support.guide.ViewArticleActivity viewArticleActivity) {
        viewArticleActivity.dimissSnackBar();
    }

    static Snackbar access$800(zendesk.support.guide.ViewArticleActivity viewArticleActivity) {
        return viewArticleActivity.snackbar;
    }

    static Snackbar access$802(zendesk.support.guide.ViewArticleActivity viewArticleActivity, Snackbar snackbar2) {
        viewArticleActivity.snackbar = snackbar2;
        return snackbar2;
    }

    static CoordinatorLayout access$900(zendesk.support.guide.ViewArticleActivity viewArticleActivity) {
        return viewArticleActivity.coordinatorLayout;
    }

    private void applyVoteButtonSettings() {
        ViewArticleActivity.7 anon = new ViewArticleActivity.7(this);
        loadSettings(anon);
    }

    public static zendesk.support.guide.ArticleConfiguration.Builder builder() {
        ArticleConfiguration.Builder builder = new ArticleConfiguration.Builder();
        return builder;
    }

    public static zendesk.support.guide.ArticleConfiguration.Builder builder(long l) {
        ArticleConfiguration.Builder builder = new ArticleConfiguration.Builder(l, obj2);
        return builder;
    }

    public static zendesk.support.guide.ArticleConfiguration.Builder builder(Article article) {
        ArticleConfiguration.Builder builder = new ArticleConfiguration.Builder(article);
        return builder;
    }

    private void dimissSnackBar() {
        Snackbar snackbar;
        snackbar = this.snackbar;
        if (snackbar != null) {
            snackbar.u();
            this.snackbar = 0;
        }
    }

    private void fetchArticle(long l) {
        setLoadingState(ViewArticleActivity.LoadingState.LOADING);
        ViewArticleActivity.3 obj3 = new ViewArticleActivity.3(this);
        this.helpCenterProvider.getArticle(Long.valueOf(l), obj3);
    }

    private void fetchAttachmentsForArticle(long l) {
        setLoadingState(ViewArticleActivity.LoadingState.LOADING);
        this.helpCenterProvider.getAttachments(Long.valueOf(l), AttachmentType.BLOCK, this.attachmentRequestCallback);
    }

    private a initToolbar() {
        int viewById;
        int i;
        if (Build.VERSION.SDK_INT >= 21) {
            findViewById(e.w).setVisibility(8);
        }
        setSupportActionBar((Toolbar)findViewById(e.z));
        return getSupportActionBar();
    }

    private void loadArticleBody() {
        int format;
        String format2;
        Object[] arr2;
        String authorName;
        java.util.Date createdAt;
        Locale locale;
        Object[] arr;
        int i2 = 1;
        arr2 = new Object[i2];
        int i7 = 0;
        arr2[i7] = this.article.getTitle();
        setTitle(getString(h.o, arr2));
        setLoadingState(ViewArticleActivity.LoadingState.DISPLAYING);
        a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.u(d.a(this.article.getTitle()));
        }
        format = 0;
        authorName = this.article.getAuthorName();
        if (this.article.getCreatedAt() != null) {
            format = DateFormat.getDateInstance(i2, c.a(getResources().getConfiguration()).c(i7)).format(this.article.getCreatedAt());
        }
        int i6 = 3;
        final int i8 = 2;
        if (format != 0 && authorName != null) {
            if (authorName != null) {
                arr = new Object[i6];
                arr[i7] = authorName;
                arr[i2] = getString(h.j);
                arr[i8] = format;
                format2 = String.format(Locale.US, "%s %s <span dir=\"auto\">%s</span>", arr);
            } else {
                format2 = "";
            }
        } else {
        }
        Object[] arr3 = new Object[4];
        arr3[i7] = "file:///android_asset/help_center_article_style.css";
        arr3[i2] = this.article.getTitle();
        arr3[i8] = this.article.getBody();
        arr3[i6] = format2;
        this.articleContentWebView.loadDataWithBaseURL(this.applicationConfiguration.getZendeskUrl(), getString(h.i, arr3), "text/html", "UTF-8", 0);
        ViewArticleActivity.4 anon = new ViewArticleActivity.4(this);
        this.handler.postDelayed(anon, 250);
    }

    private void loadSettings(f<HelpCenterSettings> f) {
        zendesk.support.guide.AggregatedCallback settingsAggregatedCallback;
        boolean obj2;
        if (this.settingsAggregatedCallback.add(f)) {
            this.settingsProvider.getSettings(this.settingsAggregatedCallback);
        }
    }

    private static void setListViewHeightBasedOnChildren(ListView listView) {
        int view;
        int i2;
        int i;
        int measuredHeight;
        int layoutParams;
        int i3;
        ListAdapter adapter = listView.getAdapter();
        if (adapter == null) {
        }
        int i5 = 0;
        int measureSpec = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), i5);
        view = 0;
        i = i2;
        while (i2 < adapter.getCount()) {
            view = adapter.getView(i2, view, listView);
            if (i2 == 0) {
            }
            view.measure(measureSpec, i5);
            i += measuredHeight;
            i2++;
            layoutParams = new ViewGroup.LayoutParams(measureSpec, -2);
            view.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = listView.getLayoutParams();
        layoutParams2.height = i += i6;
        listView.setLayoutParams(layoutParams2);
        listView.requestLayout();
    }

    private void setupRequestInterceptor() {
        WebView articleContentWebView = this.articleContentWebView;
        if (articleContentWebView == null) {
            a.k("ViewArticleActivity", "The webview is null. Make sure you initialise it before trying to add the interceptor", new Object[0]);
        }
        ViewArticleActivity.2 anon = new ViewArticleActivity.2(this);
        articleContentWebView.setWebViewClient(anon);
    }

    private boolean shouldShowContactUsButton() {
        int i;
        int i2;
        final int i3 = 0;
        i = this.actionHandlerRegistry.handlerByAction("action_contact_option") != null ? i2 : i3;
        if (this.config.isContactUsButtonVisible()) {
            if (i == 0) {
                if (a.i(this.engines)) {
                } else {
                    i2 = i3;
                }
            }
        } else {
        }
        return i2;
    }

    private void showCreateRequest(Map<String, Object> map) {
        String localizedLabel;
        String str2;
        Object[] arr;
        String str;
        ActionHandler handlerByAction = this.actionHandlerRegistry.handlerByAction("action_contact_option");
        if (handlerByAction != null) {
            ActionDescription actionDescription = handlerByAction.getActionDescription();
            if (actionDescription != null) {
                localizedLabel = actionDescription.getLocalizedLabel();
            } else {
                localizedLabel = handlerByAction.getClass().getSimpleName();
            }
            arr = new Object[1];
            a.b("ViewArticleActivity", "No Deflection ActionHandler Available, opening %s", localizedLabel);
            handlerByAction.handle(map, this);
        }
    }

    @Override // androidx.appcompat.app.d
    protected void onCreate(Bundle bundle) {
        int settings;
        int articleId;
        o.a.a configurationState;
        Bundle extras;
        Object obj7;
        super.onCreate(bundle);
        int i5 = 1;
        getTheme().applyStyle(i.a, i5);
        setContentView(f.b);
        obj7 = GuideSdkDependencyProvider.INSTANCE;
        String str3 = "ViewArticleActivity";
        final int i6 = 0;
        if (!obj7.isInitialized()) {
            a.e(str3, "Zendesk is not initialized or no identity was set. Make sure Zendesk.INSTANCE.init(...), Zendesk.INSTANCE.setIdentity(...), Guide.INSTANCE.init(...) was called ", new Object[i6]);
            finish();
        }
        obj7.provideGuideSdkComponent().inject(this);
        obj7 = initToolbar();
        configurationState = this.configurationHelper.f(getIntent().getExtras(), ArticleConfiguration.class);
        this.config = (ArticleConfiguration)configurationState;
        if (configurationState != null) {
            if (configurationState.getConfigurationState() == -1) {
            } else {
                this.engines = this.config.getEngines();
                this.attachmentListView = (ListView)findViewById(e.v);
                ViewArticleActivity.ArticleAttachmentAdapter articleAttachmentAdapter = new ViewArticleActivity.ArticleAttachmentAdapter(this);
                this.adapter = articleAttachmentAdapter;
                this.attachmentListView.setAdapter(articleAttachmentAdapter);
                this.attachmentListView.setOnItemClickListener(this);
                if (obj7 != null) {
                    obj7.s(i5);
                }
                obj7 = findViewById(e.x);
                this.articleContentWebView = (WebView)obj7;
                WebChromeClient webChromeClient = new WebChromeClient();
                obj7.setWebChromeClient(webChromeClient);
                this.articleContentWebView.getSettings().setJavaScriptEnabled(i5);
                setupRequestInterceptor();
                obj7 = Build.VERSION.SDK_INT;
                if (obj7 >= 21) {
                    this.articleContentWebView.getSettings().setMixedContentMode(i6);
                }
                if (obj7 >= 19) {
                    WebView.setWebContentsDebuggingEnabled(i5);
                }
                this.progressView = (ProgressBar)findViewById(e.y);
                this.coordinatorLayout = (CoordinatorLayout)findViewById(e.u);
                if (this.config.getConfigurationState() == 2) {
                    obj7 = this.config.getArticle();
                    this.article = obj7;
                    if (obj7 != null) {
                        this.articleId = Long.valueOf(obj7.getId());
                    }
                    loadArticleBody();
                } else {
                    fetchArticle(this.config.getArticleId());
                    this.articleId = Long.valueOf(this.config.getArticleId());
                }
                if (shouldShowContactUsButton()) {
                    obj7 = findViewById(e.d);
                    articleId = new ViewArticleActivity.1(this);
                    (FloatingActionButton)obj7.setOnClickListener(articleId);
                    obj7.setVisibility(i6);
                }
            }
            obj7 = findViewById(e.c);
            this.articleVotingView = (ArticleVotingView)obj7;
            obj7.bindTo(this.articleId, this.articleVoteStorage, this.helpCenterProvider);
            this.articleVotingView.setVisibility(8);
            applyVoteButtonSettings();
        }
        a.e(str3, "No configuration found. Please use ViewArticleActivity.builder()", new Object[i6]);
        finish();
    }

    @Override // androidx.appcompat.app.d
    protected void onDestroy() {
        super.onDestroy();
        this.settingsAggregatedCallback.cancel();
        WebView articleContentWebView = this.articleContentWebView;
        if (articleContentWebView != null) {
            articleContentWebView.destroy();
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view2, int i3, long l4) {
        Object obj1;
        boolean obj2;
        int obj3;
        obj1 = adapterView.getItemAtPosition(i3);
        if (obj1 instanceof HelpCenterAttachment) {
            if ((HelpCenterAttachment)obj1.getContentUrl() != null) {
                obj2 = new Intent();
                obj2.setAction("android.intent.action.VIEW");
                obj2.setData(Uri.parse(obj1.getContentUrl()));
                startActivity(obj2);
            } else {
                a.k("ViewArticleActivity", "Unable to launch viewer, unable to parse URI for attachment", new Object[0]);
            }
        }
    }

    @Override // androidx.appcompat.app.d
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            onBackPressed();
            return 1;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override // androidx.appcompat.app.d
    protected void onStart() {
        super.onStart();
        ViewArticleActivity.AttachmentRequestCallback attachmentRequestCallback = new ViewArticleActivity.AttachmentRequestCallback(this);
        this.attachmentRequestCallback = e.a(attachmentRequestCallback);
        this.networkInfoProvider.addNetworkAwareListener(ViewArticleActivity.NETWORK_AWARE_ID, this.networkConnectionCallbacks);
        this.networkInfoProvider.register();
    }

    @Override // androidx.appcompat.app.d
    protected void onStop() {
        e attachmentRequestCallback;
        super.onStop();
        attachmentRequestCallback = this.attachmentRequestCallback;
        if (attachmentRequestCallback != null) {
            attachmentRequestCallback.cancel();
            this.attachmentRequestCallback = 0;
        }
        this.networkInfoProvider.removeNetworkAwareListener(ViewArticleActivity.NETWORK_AWARE_ID);
        this.networkInfoProvider.unregister();
    }

    @Override // androidx.appcompat.app.d
    protected void setLoadingState(zendesk.support.guide.ViewArticleActivity.LoadingState viewArticleActivity$LoadingState) {
        int i;
        int i2;
        ListView obj4;
        i = 0;
        if (loadingState == null) {
            a.k("ViewArticleActivity", "LoadingState was null, nothing to do", new Object[i]);
        }
        obj4 = ViewArticleActivity.8.$SwitchMap$zendesk$support$guide$ViewArticleActivity$LoadingState[loadingState.ordinal()];
        final int i3 = 8;
        if (obj4 != 1) {
            if (obj4 != 2) {
                if (obj4 != 3) {
                    if (obj4 != 4) {
                    } else {
                        showLoadingErrorState(h.h);
                    }
                } else {
                    showLoadingErrorState(h.n);
                }
            } else {
                d.d(this.progressView, i3);
                d.d(this.attachmentListView, i);
            }
        } else {
            d.d(this.progressView, i);
            d.d(this.attachmentListView, i3);
        }
    }

    @Override // androidx.appcompat.app.d
    public void showContactZendesk() {
        Object hashMap;
        List configurations;
        hashMap = new HashMap();
        this.configurationHelper.d(hashMap, this.config);
        if (a.i(this.engines)) {
            hashMap = MessagingActivity.builder();
            hashMap.withEngines(this.engines);
            hashMap.show(this, this.config.getConfigurations());
        } else {
            showCreateRequest(hashMap);
        }
    }

    @Override // androidx.appcompat.app.d
    public void showLoadingErrorState(int i) {
        int i3 = 8;
        d.d(this.progressView, i3);
        d.d(this.attachmentListView, i3);
        dimissSnackBar();
        final Snackbar obj3 = Snackbar.d0(this.coordinatorLayout, i, -2);
        ViewArticleActivity.5 anon = new ViewArticleActivity.5(this);
        obj3.g0(h.w, anon);
        this.snackbar = obj3;
        obj3.T();
    }
}
