package zendesk.support.guide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import f.g.b.a.e;
import f.g.b.a.f;
import f.g.b.a.h;
import java.util.Collections;
import java.util.List;
import o.a.c;
import zendesk.support.HelpCenterProvider;
import zendesk.support.SearchArticle;

/* loaded from: classes3.dex */
public class HelpSearchFragment extends Fragment {

    private zendesk.support.guide.HelpSearchRecyclerViewAdapter adapter;
    private HelpCenterProvider helpCenterProvider;
    private String query;
    private RecyclerView recyclerView;
    private List<SearchArticle> searchArticles;
    public HelpSearchFragment() {
        super();
        this.searchArticles = Collections.emptyList();
        this.query = "";
    }

    public static zendesk.support.guide.HelpSearchFragment newInstance(zendesk.support.guide.HelpCenterConfiguration helpCenterConfiguration, HelpCenterProvider helpCenterProvider2) {
        Bundle bundle = new Bundle();
        c.b(bundle, helpCenterConfiguration);
        HelpSearchFragment obj1 = new HelpSearchFragment();
        obj1.setArguments(bundle);
        obj1.helpCenterProvider = helpCenterProvider2;
        return obj1;
    }

    private void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, 0);
        this.recyclerView.setLayoutManager(linearLayoutManager);
        HelpSearchRecyclerViewAdapter helpSearchRecyclerViewAdapter = new HelpSearchRecyclerViewAdapter(this.searchArticles, this.query, (HelpCenterConfiguration)c.e(getArguments(), HelpCenterConfiguration.class), this.helpCenterProvider);
        this.adapter = helpSearchRecyclerViewAdapter;
        this.recyclerView.setAdapter(helpSearchRecyclerViewAdapter);
    }

    @Override // androidx.fragment.app.Fragment
    public void clearResults() {
        final zendesk.support.guide.HelpSearchRecyclerViewAdapter adapter = this.adapter;
        if (adapter != null) {
            adapter.clearResults();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRetainInstance(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        final View obj2 = layoutInflater.inflate(f.c, viewGroup2, false);
        this.recyclerView = (RecyclerView)obj2.findViewById(e.j);
        setupRecyclerView();
        return obj2;
    }

    public void updateResults(List<SearchArticle> list, String string2) {
        Object recyclerView;
        int i;
        Object obj3;
        String obj4;
        this.searchArticles = list;
        this.query = string2;
        recyclerView = this.recyclerView;
        if (this.adapter != null && recyclerView != null) {
            recyclerView = this.recyclerView;
            if (recyclerView != null) {
                recyclerView.setVisibility(0);
                this.adapter.update(list, string2);
                this.recyclerView.announceForAccessibility(getString(h.m));
            }
        }
    }
}
