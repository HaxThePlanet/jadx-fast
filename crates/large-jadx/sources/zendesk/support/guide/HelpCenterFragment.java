package zendesk.support.guide;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.a;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import f.g.b.a.d;
import f.g.b.a.e;
import f.g.b.a.f;
import o.a.c;
import zendesk.core.NetworkInfoProvider;
import zendesk.support.HelpCenterProvider;

/* loaded from: classes3.dex */
public class HelpCenterFragment extends Fragment {

    public static final String LOG_TAG = "HelpCenterFragment";
    private zendesk.support.guide.HelpRecyclerViewAdapter adapter;
    HelpCenterProvider helpCenterProvider;
    NetworkInfoProvider networkInfoProvider;
    private zendesk.support.guide.HelpCenterMvp.Presenter presenter;
    private RecyclerView recyclerView;
    public static zendesk.support.guide.HelpCenterFragment newInstance(zendesk.support.guide.HelpCenterConfiguration helpCenterConfiguration) {
        Bundle bundle = new Bundle();
        c.b(bundle, helpCenterConfiguration);
        HelpCenterFragment obj1 = new HelpCenterFragment();
        obj1.setArguments(bundle);
        return obj1;
    }

    private void setupRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, 0);
        this.recyclerView.setLayoutManager(linearLayoutManager);
        SeparatorDecoration separatorDecoration = new SeparatorDecoration(a.f(getContext(), d.b));
        this.recyclerView.h(separatorDecoration);
        this.recyclerView.setAdapter(this.adapter);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        boolean initialized;
        HelpCenterProvider helpCenterProvider;
        NetworkInfoProvider networkInfoProvider;
        Object obj4;
        super.onCreate(bundle);
        setRetainInstance(true);
        obj4 = GuideSdkDependencyProvider.INSTANCE;
        obj4.provideGuideSdkComponent().inject(this);
        obj4 = new HelpRecyclerViewAdapter((HelpCenterConfiguration)c.e(getArguments(), HelpCenterConfiguration.class), this.helpCenterProvider, this.networkInfoProvider);
        this.adapter = obj4;
        initialized = this.presenter;
        if (obj4.isInitialized() && initialized != null) {
            obj4.provideGuideSdkComponent().inject(this);
            obj4 = new HelpRecyclerViewAdapter((HelpCenterConfiguration)c.e(getArguments(), HelpCenterConfiguration.class), this.helpCenterProvider, this.networkInfoProvider);
            this.adapter = obj4;
            initialized = this.presenter;
            if (initialized != null) {
                obj4.setContentUpdateListener(initialized);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        final View obj2 = layoutInflater.inflate(f.c, viewGroup2, false);
        this.recyclerView = (RecyclerView)obj2.findViewById(e.j);
        setupRecyclerView();
        return obj2;
    }

    @Override // androidx.fragment.app.Fragment
    public void setPresenter(zendesk.support.guide.HelpCenterMvp.Presenter helpCenterMvp$Presenter) {
        this.presenter = presenter;
        final zendesk.support.guide.HelpRecyclerViewAdapter adapter = this.adapter;
        if (adapter != null) {
            adapter.setContentUpdateListener(presenter);
        }
    }
}
