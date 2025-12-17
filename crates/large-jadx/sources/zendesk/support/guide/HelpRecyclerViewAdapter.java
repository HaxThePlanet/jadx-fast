package zendesk.support.guide;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.a;
import androidx.core.graphics.drawable.a;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import f.g.b.a.a;
import f.g.b.a.b;
import f.g.b.a.d;
import f.g.b.a.e;
import f.g.b.a.f;
import f.g.b.a.h;
import f.g.c.a;
import java.util.List;
import zendesk.commonui.d;
import zendesk.core.NetworkInfoProvider;
import zendesk.support.CategoryItem;
import zendesk.support.HelpCenterProvider;
import zendesk.support.HelpItem;
import zendesk.support.SectionItem;
import zendesk.support.SeeAllArticlesItem;

/* loaded from: classes3.dex */
class HelpRecyclerViewAdapter extends RecyclerView.h<zendesk.support.guide.HelpRecyclerViewAdapter.HelpViewHolder> implements zendesk.support.guide.HelpMvp.View {

    private Context context;
    private int defaultCategoryTitleColour;
    private final zendesk.support.guide.HelpCenterConfiguration helpCenterUiConfig;
    private int highlightCategoryTitleColour;
    private zendesk.support.guide.HelpMvp.Presenter presenter;

    static abstract class HelpViewHolder extends RecyclerView.e0 {

        TextView textView;
        HelpViewHolder(View view) {
            super(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public abstract void bindTo(HelpItem helpItem, int i2);
    }

    class ArticleViewHolder extends zendesk.support.guide.HelpRecyclerViewAdapter.HelpViewHolder {

        final zendesk.support.guide.HelpRecyclerViewAdapter this$0;
        ArticleViewHolder(zendesk.support.guide.HelpRecyclerViewAdapter helpRecyclerViewAdapter, View view2) {
            this.this$0 = helpRecyclerViewAdapter;
            super(view2);
            this.textView = (TextView)view2;
        }

        @Override // zendesk.support.guide.HelpRecyclerViewAdapter$HelpViewHolder
        public void bindTo(HelpItem helpItem, int i2) {
            Long obj3;
            if (helpItem != null && helpItem.getId() == null) {
                if (helpItem.getId() == null) {
                }
                this.textView.setText(d.a(helpItem.getName()));
                HelpRecyclerViewAdapter.ArticleViewHolder.1 anon = new HelpRecyclerViewAdapter.ArticleViewHolder.1(this, helpItem);
                this.textView.setOnClickListener(anon);
            }
            a.e("HelpCenterActivity", "Article item was null, cannot bind", new Object[0]);
        }
    }

    class CategoryViewHolder extends zendesk.support.guide.HelpRecyclerViewAdapter.HelpViewHolder {

        private static final int ROTATION_END_LEVEL = 10000;
        private static final String ROTATION_PROPERTY_NAME = "level";
        private static final int ROTATION_START_LEVEL;
        private boolean expanded;
        private Drawable expanderDrawable;
        final zendesk.support.guide.HelpRecyclerViewAdapter this$0;
        CategoryViewHolder(zendesk.support.guide.HelpRecyclerViewAdapter helpRecyclerViewAdapter, View view2) {
            Drawable obj4;
            this.this$0 = helpRecyclerViewAdapter;
            super(view2);
            final View view = view2;
            this.textView = (TextView)view;
            Drawable obj5 = a.r(a.f(view2.getContext(), d.a)).mutate();
            this.expanderDrawable = obj5;
            a.n(obj5, d.e(16842808, HelpRecyclerViewAdapter.access$000(helpRecyclerViewAdapter), b.a));
            a.p(this.expanderDrawable, PorterDuff.Mode.SRC_IN);
            obj5 = 0;
            if (Build.VERSION.SDK_INT >= 17) {
                view.setCompoundDrawablesRelativeWithIntrinsicBounds(obj5, obj5, this.expanderDrawable, obj5);
            } else {
                view.setCompoundDrawablesWithIntrinsicBounds(obj5, obj5, this.expanderDrawable, obj5);
            }
        }

        static boolean access$100(zendesk.support.guide.HelpRecyclerViewAdapter.CategoryViewHolder helpRecyclerViewAdapter$CategoryViewHolder) {
            return categoryViewHolder.expanded;
        }

        static boolean access$102(zendesk.support.guide.HelpRecyclerViewAdapter.CategoryViewHolder helpRecyclerViewAdapter$CategoryViewHolder, boolean z2) {
            categoryViewHolder.expanded = z2;
            return z2;
        }

        static Drawable access$300(zendesk.support.guide.HelpRecyclerViewAdapter.CategoryViewHolder helpRecyclerViewAdapter$CategoryViewHolder) {
            return categoryViewHolder.expanderDrawable;
        }

        static void access$400(zendesk.support.guide.HelpRecyclerViewAdapter.CategoryViewHolder helpRecyclerViewAdapter$CategoryViewHolder, boolean z2) {
            categoryViewHolder.setHighlightColor(z2);
        }

        private void setHighlightColor(boolean z) {
            int i;
            PorterDuff.Mode sRC_IN;
            Drawable obj3;
            if (z) {
                this.textView.setTextColor(HelpRecyclerViewAdapter.access$500(this.this$0));
                this.expanderDrawable.setColorFilter(HelpRecyclerViewAdapter.access$500(this.this$0), PorterDuff.Mode.SRC_IN);
            } else {
                this.textView.setTextColor(HelpRecyclerViewAdapter.access$600(this.this$0));
                this.expanderDrawable.setColorFilter(HelpRecyclerViewAdapter.access$600(this.this$0), PorterDuff.Mode.SRC_IN);
            }
        }

        @Override // zendesk.support.guide.HelpRecyclerViewAdapter$HelpViewHolder
        public void bindTo(HelpItem helpItem, int i2) {
            int i;
            if (helpItem == null) {
                a.e("HelpCenterActivity", "Category item was null, cannot bind", new Object[0]);
            }
            this.textView.setText(d.a(helpItem.getName()));
            boolean expanded2 = (CategoryItem)helpItem.isExpanded();
            this.expanded = expanded2;
            if (expanded2) {
                i = 10000;
            }
            this.expanderDrawable.setLevel(i);
            setHighlightColor(helpItem.isExpanded());
            HelpRecyclerViewAdapter.CategoryViewHolder.1 anon = new HelpRecyclerViewAdapter.CategoryViewHolder.1(this, helpItem, i2);
            this.textView.setOnClickListener(anon);
        }

        @Override // zendesk.support.guide.HelpRecyclerViewAdapter$HelpViewHolder
        public boolean isExpanded() {
            return this.expanded;
        }
    }

    private class ExtraPaddingViewHolder extends zendesk.support.guide.HelpRecyclerViewAdapter.HelpViewHolder {

        final zendesk.support.guide.HelpRecyclerViewAdapter this$0;
        ExtraPaddingViewHolder(zendesk.support.guide.HelpRecyclerViewAdapter helpRecyclerViewAdapter, View view2) {
            this.this$0 = helpRecyclerViewAdapter;
            super(view2);
        }

        @Override // zendesk.support.guide.HelpRecyclerViewAdapter$HelpViewHolder
        public void bindTo(HelpItem helpItem, int i2) {
        }
    }

    private class LoadingViewHolder extends zendesk.support.guide.HelpRecyclerViewAdapter.HelpViewHolder {

        final zendesk.support.guide.HelpRecyclerViewAdapter this$0;
        LoadingViewHolder(zendesk.support.guide.HelpRecyclerViewAdapter helpRecyclerViewAdapter, View view2) {
            this.this$0 = helpRecyclerViewAdapter;
            super(view2);
        }

        @Override // zendesk.support.guide.HelpRecyclerViewAdapter$HelpViewHolder
        public void bindTo(HelpItem helpItem, int i2) {
        }
    }

    private class NoResultsViewHolder extends zendesk.support.guide.HelpRecyclerViewAdapter.HelpViewHolder {

        final zendesk.support.guide.HelpRecyclerViewAdapter this$0;
        NoResultsViewHolder(zendesk.support.guide.HelpRecyclerViewAdapter helpRecyclerViewAdapter, View view2) {
            this.this$0 = helpRecyclerViewAdapter;
            super(view2);
        }

        @Override // zendesk.support.guide.HelpRecyclerViewAdapter$HelpViewHolder
        public void bindTo(HelpItem helpItem, int i2) {
        }
    }

    class SectionViewHolder extends zendesk.support.guide.HelpRecyclerViewAdapter.HelpViewHolder {

        final zendesk.support.guide.HelpRecyclerViewAdapter this$0;
        SectionViewHolder(zendesk.support.guide.HelpRecyclerViewAdapter helpRecyclerViewAdapter, View view2) {
            this.this$0 = helpRecyclerViewAdapter;
            super(view2);
            this.textView = (TextView)view2.findViewById(e.n);
        }

        @Override // zendesk.support.guide.HelpRecyclerViewAdapter$HelpViewHolder
        public void bindTo(HelpItem helpItem, int i2) {
            if (helpItem == null) {
                a.e("HelpCenterActivity", "Section item was null, cannot bind", new Object[0]);
            }
            this.textView.setText(d.a(helpItem.getName()));
        }
    }

    private class SeeAllViewHolder extends zendesk.support.guide.HelpRecyclerViewAdapter.HelpViewHolder {

        private ProgressBar progressBar;
        final zendesk.support.guide.HelpRecyclerViewAdapter this$0;
        SeeAllViewHolder(zendesk.support.guide.HelpRecyclerViewAdapter helpRecyclerViewAdapter, View view2) {
            this.this$0 = helpRecyclerViewAdapter;
            super(view2);
            this.textView = (TextView)view2.findViewById(e.k);
            this.progressBar = (ProgressBar)view2.findViewById(e.l);
        }

        static ProgressBar access$800(zendesk.support.guide.HelpRecyclerViewAdapter.SeeAllViewHolder helpRecyclerViewAdapter$SeeAllViewHolder) {
            return seeAllViewHolder.progressBar;
        }

        @Override // zendesk.support.guide.HelpRecyclerViewAdapter$HelpViewHolder
        public void bindTo(HelpItem helpItem, int i2) {
            String string;
            ProgressBar progressBar;
            int valueOf;
            int i3;
            int i;
            Object[] arr;
            int i4 = 0;
            if (!helpItem instanceof SeeAllArticlesItem) {
                a.e("HelpCenterActivity", "SeeAll item was null, cannot bind", new Object[i4]);
            }
            Object obj7 = helpItem;
            i3 = 8;
            if ((SeeAllArticlesItem)obj7.isLoading()) {
                this.textView.setVisibility(i3);
                this.progressBar.setVisibility(i4);
            } else {
                this.textView.setVisibility(i4);
                this.progressBar.setVisibility(i3);
            }
            SectionItem section = obj7.getSection();
            if (section != null) {
                arr = new Object[1];
                arr[i4] = Integer.valueOf(section.getTotalArticlesCount());
                string = HelpRecyclerViewAdapter.access$000(this.this$0).getString(h.f, arr);
            } else {
                string = HelpRecyclerViewAdapter.access$000(this.this$0).getString(h.e);
            }
            this.textView.setText(string);
            HelpRecyclerViewAdapter.SeeAllViewHolder.1 anon = new HelpRecyclerViewAdapter.SeeAllViewHolder.1(this, helpItem, obj7);
            this.textView.setOnClickListener(anon);
        }
    }
    HelpRecyclerViewAdapter(zendesk.support.guide.HelpCenterConfiguration helpCenterConfiguration, HelpCenterProvider helpCenterProvider2, NetworkInfoProvider networkInfoProvider3) {
        super();
        HelpModel helpModel = new HelpModel(helpCenterProvider2);
        HelpAdapterPresenter helpAdapterPresenter = new HelpAdapterPresenter(this, helpModel, networkInfoProvider3, helpCenterConfiguration);
        this.presenter = helpAdapterPresenter;
        this.helpCenterUiConfig = helpCenterConfiguration;
    }

    static Context access$000(zendesk.support.guide.HelpRecyclerViewAdapter helpRecyclerViewAdapter) {
        return helpRecyclerViewAdapter.context;
    }

    static zendesk.support.guide.HelpMvp.Presenter access$200(zendesk.support.guide.HelpRecyclerViewAdapter helpRecyclerViewAdapter) {
        return helpRecyclerViewAdapter.presenter;
    }

    static int access$500(zendesk.support.guide.HelpRecyclerViewAdapter helpRecyclerViewAdapter) {
        return helpRecyclerViewAdapter.highlightCategoryTitleColour;
    }

    static int access$600(zendesk.support.guide.HelpRecyclerViewAdapter helpRecyclerViewAdapter) {
        return helpRecyclerViewAdapter.defaultCategoryTitleColour;
    }

    static zendesk.support.guide.HelpCenterConfiguration access$700(zendesk.support.guide.HelpRecyclerViewAdapter helpRecyclerViewAdapter) {
        return helpRecyclerViewAdapter.helpCenterUiConfig;
    }

    private View inflateView(ViewGroup viewGroup, int i2) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(i2, viewGroup, false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void addItem(int i, HelpItem helpItem2) {
        notifyItemInserted(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return this.presenter.getItemCount();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) {
        return this.presenter.getItemViewType(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        Context obj3 = recyclerView.getContext();
        this.context = obj3;
        this.highlightCategoryTitleColour = d.e(a.a, obj3, b.a);
        this.defaultCategoryTitleColour = a.d(this.context, b.b);
        this.presenter.onAttached();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(RecyclerView.e0 recyclerView$e0, int i2) {
        onBindViewHolder((HelpRecyclerViewAdapter.HelpViewHolder)e0, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onBindViewHolder(zendesk.support.guide.HelpRecyclerViewAdapter.HelpViewHolder helpRecyclerViewAdapter$HelpViewHolder, int i2) {
        if (helpViewHolder == null) {
            a.k("HelpCenterActivity", "Holder was null, possible unexpected item type", new Object[0]);
        }
        helpViewHolder.bindTo(this.presenter.getItemForBinding(i2), i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public RecyclerView.e0 onCreateViewHolder(ViewGroup viewGroup, int i2) {
        return onCreateViewHolder(viewGroup, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public zendesk.support.guide.HelpRecyclerViewAdapter.HelpViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2) {
        switch (i2) {
            case 1:
                HelpRecyclerViewAdapter.CategoryViewHolder obj3 = new HelpRecyclerViewAdapter.CategoryViewHolder(this, inflateView(viewGroup, f.g));
                return obj3;
            case 2:
                obj3 = new HelpRecyclerViewAdapter.SectionViewHolder(this, inflateView(viewGroup, f.l));
                return obj3;
            case 3:
                obj3 = new HelpRecyclerViewAdapter.ArticleViewHolder(this, inflateView(viewGroup, f.e));
                return obj3;
            case 4:
                obj3 = new HelpRecyclerViewAdapter.SeeAllViewHolder(this, inflateView(viewGroup, f.d));
                return obj3;
            case 5:
                obj3 = new HelpRecyclerViewAdapter.LoadingViewHolder(this, inflateView(viewGroup, f.h));
                return obj3;
            case 6:
                a.k("HelpCenterActivity", "Unknown item type, returning null for holder", new Object[0]);
                return null;
            case 7:
                obj3 = new HelpRecyclerViewAdapter.NoResultsViewHolder(this, inflateView(viewGroup, f.i));
                return obj3;
            default:
                obj3 = new HelpRecyclerViewAdapter.ExtraPaddingViewHolder(this, inflateView(viewGroup, f.j));
                return obj3;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.presenter.onDetached();
        this.context = 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public void removeItem(int i) {
        notifyItemRemoved(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    void setContentUpdateListener(zendesk.support.guide.HelpCenterMvp.Presenter helpCenterMvp$Presenter) {
        final zendesk.support.guide.HelpMvp.Presenter presenter2 = this.presenter;
        if (presenter2 != null) {
            presenter2.setContentPresenter(presenter);
        }
    }

    public void showItems(List<HelpItem> list) {
        notifyDataSetChanged();
    }
}
