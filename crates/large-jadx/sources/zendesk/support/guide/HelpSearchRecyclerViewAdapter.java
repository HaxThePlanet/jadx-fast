package zendesk.support.guide;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import f.g.b.a.e;
import f.g.b.a.f;
import f.g.b.a.h;
import f.g.c.a;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import zendesk.support.Article;
import zendesk.support.Category;
import zendesk.support.HelpCenterProvider;
import zendesk.support.SearchArticle;
import zendesk.support.Section;

/* loaded from: classes3.dex */
class HelpSearchRecyclerViewAdapter extends RecyclerView.h {

    private static final int TYPE_ARTICLE = 531;
    private static final int TYPE_NO_RESULTS = 441;
    private static final int TYPE_PADDING = 423;
    private final HelpCenterProvider helpCenterProvider;
    private final zendesk.support.guide.HelpCenterConfiguration helpCenterUiConfig;
    private String query;
    private boolean resultsCleared = false;
    private List<SearchArticle> searchArticles;

    private class HelpSearchViewHolder extends RecyclerView.e0 {

        private Context context;
        private TextView subtitleTextView;
        final zendesk.support.guide.HelpSearchRecyclerViewAdapter this$0;
        private TextView titleTextView;
        HelpSearchViewHolder(zendesk.support.guide.HelpSearchRecyclerViewAdapter helpSearchRecyclerViewAdapter, View view2, Context context3) {
            this.this$0 = helpSearchRecyclerViewAdapter;
            super(view2);
            this.titleTextView = (TextView)view2.findViewById(e.r);
            this.subtitleTextView = (TextView)view2.findViewById(e.o);
            this.context = context3;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        void bindTo(SearchArticle searchArticle) {
            Article article;
            String titleTextView;
            int titleTextView2;
            int spannableString;
            String lowerCase;
            Locale default;
            int i;
            int i2 = 0;
            if (searchArticle != null) {
                if (searchArticle.getArticle() == null) {
                } else {
                    if (searchArticle.getArticle().getTitle() != null) {
                        titleTextView = searchArticle.getArticle().getTitle();
                    } else {
                        titleTextView = "";
                    }
                    spannableString = -1;
                    if (HelpSearchRecyclerViewAdapter.access$000(this.this$0) == null) {
                        titleTextView2 = spannableString;
                    } else {
                        titleTextView2 = titleTextView.toLowerCase(Locale.getDefault()).indexOf(HelpSearchRecyclerViewAdapter.access$000(this.this$0).toLowerCase(Locale.getDefault()));
                    }
                    int i4 = 1;
                    if (titleTextView2 != spannableString) {
                        spannableString = new SpannableString(titleTextView);
                        StyleSpan styleSpan = new StyleSpan(i4);
                        spannableString.setSpan(styleSpan, titleTextView2, length += titleTextView2, 18);
                        this.titleTextView.setText(spannableString);
                    } else {
                        this.titleTextView.setText(titleTextView);
                    }
                }
                Object[] arr = new Object[2];
                arr[i2] = searchArticle.getCategory().getName();
                arr[i4] = searchArticle.getSection().getName();
                this.subtitleTextView.setText(this.context.getString(h.a, arr));
                HelpSearchRecyclerViewAdapter.HelpSearchViewHolder.1 anon = new HelpSearchRecyclerViewAdapter.HelpSearchViewHolder.1(this, searchArticle);
                this.itemView.setOnClickListener(anon);
            }
            a.e("HelpCenterActivity", "The article was null, cannot bind the view.", new Object[i2]);
        }
    }

    private class NoResultsViewHolder extends RecyclerView.e0 {

        final zendesk.support.guide.HelpSearchRecyclerViewAdapter this$0;
        NoResultsViewHolder(zendesk.support.guide.HelpSearchRecyclerViewAdapter helpSearchRecyclerViewAdapter, View view2) {
            this.this$0 = helpSearchRecyclerViewAdapter;
            super(view2);
        }
    }

    private class PaddingViewHolder extends RecyclerView.e0 {

        final zendesk.support.guide.HelpSearchRecyclerViewAdapter this$0;
        PaddingViewHolder(zendesk.support.guide.HelpSearchRecyclerViewAdapter helpSearchRecyclerViewAdapter, View view2) {
            this.this$0 = helpSearchRecyclerViewAdapter;
            super(view2);
        }
    }
    HelpSearchRecyclerViewAdapter(List<SearchArticle> list, String string2, zendesk.support.guide.HelpCenterConfiguration helpCenterConfiguration3, HelpCenterProvider helpCenterProvider4) {
        super();
        final int i = 0;
        this.searchArticles = list;
        this.query = string2;
        this.helpCenterUiConfig = helpCenterConfiguration3;
        this.helpCenterProvider = helpCenterProvider4;
    }

    static String access$000(zendesk.support.guide.HelpSearchRecyclerViewAdapter helpSearchRecyclerViewAdapter) {
        return helpSearchRecyclerViewAdapter.query;
    }

    static HelpCenterProvider access$100(zendesk.support.guide.HelpSearchRecyclerViewAdapter helpSearchRecyclerViewAdapter) {
        return helpSearchRecyclerViewAdapter.helpCenterProvider;
    }

    static zendesk.support.guide.HelpCenterConfiguration access$200(zendesk.support.guide.HelpSearchRecyclerViewAdapter helpSearchRecyclerViewAdapter) {
        return helpSearchRecyclerViewAdapter.helpCenterUiConfig;
    }

    private int getPaddingExtraItem() {
        return this.helpCenterUiConfig.isContactUsButtonVisible();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    void clearResults() {
        this.resultsCleared = true;
        this.searchArticles = Collections.emptyList();
        this.query = "";
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        if (this.resultsCleared) {
            return 0;
        }
        return Math.max(size += paddingExtraItem, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        int size;
        if (i == 0 && this.searchArticles.size() == 0) {
            if (this.searchArticles.size() == 0) {
                return 441;
            }
        }
        if (i > 0 && i == this.searchArticles.size()) {
            if (i == this.searchArticles.size()) {
                return 423;
            }
        }
        return 531;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        int searchArticles;
        int obj4;
        if (531 == getItemViewType(i2)) {
            (HelpSearchRecyclerViewAdapter.HelpSearchViewHolder)e0.bindTo((SearchArticle)this.searchArticles.get(i2));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        final int i8 = 0;
        if (i2 != 423 && i2 != 441 && i2 != 531) {
            if (i2 != 441) {
                if (i2 != 531) {
                    return null;
                }
                HelpSearchRecyclerViewAdapter.HelpSearchViewHolder helpSearchViewHolder = new HelpSearchRecyclerViewAdapter.HelpSearchViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(f.k, viewGroup, i8), viewGroup.getContext());
                return helpSearchViewHolder;
            }
            HelpSearchRecyclerViewAdapter.NoResultsViewHolder obj4 = new HelpSearchRecyclerViewAdapter.NoResultsViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(f.i, viewGroup, i8));
            return obj4;
        }
        obj4 = new HelpSearchRecyclerViewAdapter.PaddingViewHolder(this, LayoutInflater.from(viewGroup.getContext()).inflate(f.j, viewGroup, i8));
        return obj4;
    }

    void update(List<SearchArticle> list, String string2) {
        this.resultsCleared = false;
        this.searchArticles = list;
        this.query = string2;
        notifyDataSetChanged();
    }
}
