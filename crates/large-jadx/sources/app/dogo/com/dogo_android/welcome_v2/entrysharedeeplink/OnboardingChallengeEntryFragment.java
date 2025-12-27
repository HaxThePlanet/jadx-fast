package app.dogo.com.dogo_android.welcome_v2.w0;

import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.d.b.x;
import app.dogo.com.dogo_android.d.b.z.i;
import app.dogo.com.dogo_android.h.ci;
import app.dogo.com.dogo_android.h.cn;
import app.dogo.com.dogo_android.h.e8;
import app.dogo.com.dogo_android.model.ChallengeComment;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.util.k0.d;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.m;

/* compiled from: OnboardingChallengeEntryFragment.kt */
@Metadata(d1 = "\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0017\u001a\u00020\u0018H\u0002J\u0008\u0010\u0019\u001a\u00020\u0010H\u0002J\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0008\u0010%\u001a\u0004\u0018\u00010&2\u0008\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0008\u0010)\u001a\u00020\u001bH\u0002J\u0008\u0010*\u001a\u00020\u001bH\u0016J\u0008\u0010+\u001a\u00020\u001bH\u0016J\u0008\u0010,\u001a\u00020\u001bH\u0016J\u001a\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\"2\u0008\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0008\u0010/\u001a\u00020\u001bH\u0002J\u0008\u00100\u001a\u00020\u001bH\u0002J\u0010\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u000203H\u0002J\u0018\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u001dH\u0002J\u0010\u00108\u001a\u00020\u001b2\u0006\u00105\u001a\u000209H\u0002J\u0012\u0010:\u001a\u00020\u001b2\u0008\u0008\u0001\u0010;\u001a\u00020\u001dH\u0002J\u0018\u0010<\u001a\u00020\u001b2\u0008\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010\u001c\u001a\u00020\u001dR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0015\u0010\u0016\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006@", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/entrysharedeeplink/OnboardingChallengeEntryFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lapp/dogo/com/dogo_android/challenge/comments/ChallengeCommentsListAdapter;", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogChallengeCommentsBinding;", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "screenKey", "Lapp/dogo/com/dogo_android/welcome_v2/entrysharedeeplink/OnboardingChallengeEntryScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/welcome_v2/entrysharedeeplink/OnboardingChallengeEntryScreen;", "toast", "Landroid/widget/Toast;", "topBarManager", "Lapp/dogo/com/dogo_android/util/interfaces/TopBarManager;", "vm", "Lapp/dogo/com/dogo_android/challenge/comments/ChallengeCommentsViewModel;", "getVm", "()Lapp/dogo/com/dogo_android/challenge/comments/ChallengeCommentsViewModel;", "vm$delegate", "Lkotlin/Lazy;", "createCommentBarManager", "Lapp/dogo/com/dogo_android/util/interfaces/CommentBarManager;", "createTopBarManager", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onFailure", "onPause", "onResume", "onStop", "onViewCreated", "view", "setupCommentListData", "setupObservers", "setupRecyclerView", "recycleView", "Landroidx/recyclerview/widget/RecyclerView;", "showDeleteCommentDialog", "model", "Lapp/dogo/com/dogo_android/model/ChallengeComment;", "position", "showDeleteEntryDialog", "Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentCaptionItem;", "showToast", "res", "startDogCreation", "dogId", "", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: i, reason: from kotlin metadata */
public final class OnboardingChallengeEntryFragment extends Fragment {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final i.a INSTANCE = new i$a(0);
    private static final app.dogo.com.dogo_android.k.j y;
    /* renamed from: a, reason: from kotlin metadata */
    private e8 adapter;
    /* renamed from: b, reason: from kotlin metadata */
    private final h binding;
    /* renamed from: c, reason: from kotlin metadata */
    private app.dogo.com.dogo_android.d.b.w linearLayoutManager;
    private LinearLayoutManager v;
    /* renamed from: w, reason: from kotlin metadata */
    private app.dogo.com.dogo_android.util.k0.g toast;
    /* renamed from: x, reason: from kotlin metadata */
    private Toast topBarManager;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/entrysharedeeplink/OnboardingChallengeEntryFragment$Companion;", "", "()V", "LOAD_NEXT_PAGE_THRESHOLD", "", "fragmentTag", "Lapp/dogo/com/dogo_android/enums/FullScreenTag;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(kotlin.d0.d.g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/welcome_v2/entrysharedeeplink/OnboardingChallengeEntryFragment$setupRecyclerView$1", "Lapp/dogo/com/dogo_android/util/recycle_views/EndlessRecyclerOnScrollListener;", "onLoadMore", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d extends app.dogo.com.dogo_android.util.n0.k {

        final /* synthetic */ i d;
        d() {
            this.d = iVar;
            super(20);
        }

        @Override // app.dogo.com.dogo_android.util.n0.k
        /* renamed from: a, reason: from kotlin metadata */
        public void onLoadMore() {
            this.d.J1().K0();
        }
    }

    @Metadata(d1 = "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016J\u0008\u0010\u0004\u001a\u00020\u0005H\u0016J\u0008\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0008", d2 = {"app/dogo/com/dogo_android/welcome_v2/entrysharedeeplink/OnboardingChallengeEntryFragment$createTopBarManager$1", "Lapp/dogo/com/dogo_android/util/interfaces/TopBarManager;", "getTitle", "", "isBackVisible", "", "onBack", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends app.dogo.com.dogo_android.util.k0.g {

        final /* synthetic */ i a;
        c() {
            this.a = iVar;
            super();
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public String getTitle() throws android.content.res.Resources.NotFoundException {
            int i;
            boolean z = false;
            int i2 = 4;
            String quantityString = this.a.getResources().getQuantityString(2131755009, 999);
            n.e(quantityString, "resources.getQuantityString(R.plurals.comments_title, 999)");
            z = false;
            i2 = 4;
            String str2 = l.G(quantityString, "%d", "", z, i2, null);
            i = 1;
            i = str2.length() - i;
            i = 0;
            while (i <= i) {
                int r6 = i;
                i2 = 32;
                r6 = i;
                if (i != 0) {
                    break;
                }
            }
            String object = str2.subSequence(i, i + i).toString();
            String str4 = "null cannot be cast to non-null type java.lang.String";
            Objects.requireNonNull(object, str4);
            String substring2 = object.substring(i, i);
            n.e(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            Locale _default = Locale.getDefault();
            n.e(_default, "getDefault()");
            Objects.requireNonNull(substring2, str4);
            String str6 = substring2.toUpperCase(_default);
            n.e(str6, "(this as java.lang.String).toUpperCase(locale)");
            Objects.requireNonNull(object, str4);
            String substring = object.substring(i);
            n.e(substring, "(this as java.lang.String).substring(startIndex)");
            return n.o(str6, substring);
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public void onBack() {
            androidx.fragment.app.e activity = this.a.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public boolean isBackVisible() {
            return true;
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements kotlin.d0.c.l<String, kotlin.w> {

        final /* synthetic */ h.a.b.h.f<?> $item;
        final /* synthetic */ int $position;
        @Override // kotlin.d0.d.p
        public final void a(String str) {
            str2 = "it";
            n.f(str, str2);
            if (!i.this.J1().k0()) {
                if (!i.this.J1().n0((ChallengeCommentItem)this.$item.g())) {
                    app.dogo.com.dogo_android.d.b.w recyclerView = i.this.linearLayoutManager;
                    if (recyclerView != null) {
                        recyclerView.removeItem(this.$position);
                    }
                }
            }
        }

        e(h.a.b.h.f<?> fVar, int i) {
            this.$item = fVar;
            this.$position = i;
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends p implements kotlin.d0.c.a<kotlin.w> {

        final /* synthetic */ ChallengeComment $model;
        final /* synthetic */ int $position;
        @Override // kotlin.d0.d.p
        public final kotlin.w a() {
            kotlin.w wVar = null;
            if (this.$model.getDocumentId() == null) {
                i.this.g2(R.string.alert.something.failed);
                str = "model.document id is null";
                a.c(str, new Object[0]);
                wVar = w.a;
            } else {
                i.this.J1().M0(this.$model, OnboardingChallengeEntryFragment.y.getTag());
                app.dogo.com.dogo_android.d.b.w recyclerView = i.this.linearLayoutManager;
                if (recyclerView == null) {
                    int i2 = 0;
                } else {
                    recyclerView.removeItem(this.$position);
                    wVar = w.a;
                }
            }
            return wVar;
        }

        f(ChallengeComment challengeComment, i iVar, int i) {
            this.$model = challengeComment;
            this.$position = i;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends p implements kotlin.d0.c.a<kotlin.w> {

        final /* synthetic */ i $model;
        @Override // kotlin.d0.d.p
        public final kotlin.w a() {
            kotlin.w wVar = null;
            if (i.this.J1().J(this.$model.getModel(), this.$model.h())) {
                androidx.fragment.app.e activity = i.this.getActivity();
                if (activity != null) {
                    activity.onBackPressed();
                }
            }
            app.dogo.com.dogo_android.d.b.w recyclerView = i.this.linearLayoutManager;
            if (recyclerView == null) {
                int i2 = 0;
            } else {
                int i = 0;
                recyclerView.notifyItemChanged(i, Integer.valueOf(i));
                wVar = w.a;
            }
            return wVar;
        }

        g(i iVar) {
            this.$model = iVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class h extends p implements kotlin.d0.c.a<x> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final x invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(ChallengeCommentsViewModel.class), this.$parameters);
        }

        public h(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\u0008\u0010\u0004\u001a\u00020\u0005H\u0016J\u0008\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0016J\u0008\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u000e", d2 = {"app/dogo/com/dogo_android/welcome_v2/entrysharedeeplink/OnboardingChallengeEntryFragment$createCommentBarManager$1", "Lapp/dogo/com/dogo_android/util/interfaces/CommentBarManager;", "getUserDogIcon", "Landroid/net/Uri;", "isUserPremiumBadgeVisible", "", "onAvatarClick", "", "onSendActionListener", "string", "", "replyTarget", "Lapp/dogo/com/dogo_android/model/ChallengeComment;", "permissionCheck", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends d {

        final /* synthetic */ i a;
        b() {
            this.a = iVar;
            super();
        }

        @Override // app.dogo.com.dogo_android.util.k0.d
        public Uri getUserDogIcon() {
            return this.a.J1().h0();
        }

        @Override // app.dogo.com.dogo_android.util.k0.d
        public boolean isUserPremiumBadgeVisible() {
            return this.a.J1().s0();
        }

        @Override // app.dogo.com.dogo_android.util.k0.d
        public void onSendActionListener(String string, ChallengeComment replyTarget) {
            n.f(string, "string");
            if (this.a.J1().m0()) {
                this.a.h2(this.a.J1().X(), 11101);
                int i3 = 2131886415;
                this.a.g2(i3);
                return;
            } else {
                if (!this.a.J1().isUserSignedIn()) {
                    androidx.fragment.app.e activity = this.a.getActivity();
                    if (activity != null) {
                        int i = 10002;
                        app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo zendeskConfigurationInfo = null;
                        int i2 = 4;
                        Object obj = null;
                        str = "welcome";
                        app.dogo.com.dogo_android.util.extensionfunction.g1.H(activity, i, str, zendeskConfigurationInfo, i2, obj);
                    }
                } else {
                    this.a.J1().N0(string, replyTarget);
                    e8 showDeleteEntryDialog = this.a.adapter;
                    if (showDeleteEntryDialog != null) {
                        i3 = 1;
                        showDeleteEntryDialog.P.q1(i3);
                    }
                }
            }
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        }

        @Override // app.dogo.com.dogo_android.util.k0.d
        public boolean permissionCheck() {
            boolean z2 = false;
            if (this.a.J1().o0()) {
                int r0 = this.a.J1().r0() ? 1 : 0;
            }
            return (this.a.J1().r0() ? 1 : 0);
        }

        @Override // app.dogo.com.dogo_android.util.k0.d
        public void onAvatarClick() {
        }
    }
    static {
        OnboardingChallengeEntryFragment.y = FullScreenTag.CHALLENGE_COMMENTS_DIALOG;
    }

    public i() {
        super();
        final m.a.c.j.a aVar = null;
        this.binding = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.welcome_v2.entrysharedeeplink.i.h(this, aVar, aVar));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ app.dogo.com.dogo_android.d.b.w setupRecyclerView(i recycleView) {
        return recycleView.linearLayoutManager;
    }

    /* renamed from: C1, reason: from kotlin metadata */
    public static final /* synthetic */ e8 showDeleteEntryDialog(i model) {
        return model.adapter;
    }

    /* renamed from: D1, reason: from kotlin metadata */
    public static final /* synthetic */ app.dogo.com.dogo_android.k.j createCommentBarManager() {
        return OnboardingChallengeEntryFragment.y;
    }

    /* renamed from: E1, reason: from kotlin metadata */
    public static final /* synthetic */ x showToast(i res) {
        return res.J1();
    }

    /* renamed from: F1, reason: from kotlin metadata */
    public static final /* synthetic */ void onViewCreated(i view, int savedInstanceState) {
        view.g2(savedInstanceState);
    }

    private final d G1() {
        return new OnboardingChallengeEntryFragment_createCommentBarManager_1(this);
    }

    private final app.dogo.com.dogo_android.util.k0.g H1() {
        if (this.toast == null) {
            this.toast = new OnboardingChallengeEntryFragment_createTopBarManager_1(this);
        }
        n.d(this.toast);
        return this.toast;
    }

    private final j I1() {
        return (OnboardingChallengeEntryScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final x J1() {
        return (ChallengeCommentsViewModel)this.binding.getValue();
    }

    private static final boolean S1(i iVar, View view, int i, KeyEvent keyEvent) {
        n.f(iVar, "this$0");
        if (i == 4) {
            final int i5 = 0;
            final String str2 = "binding";
            if (iVar.adapter == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i5;
            } else {
                adapter22.O.S.requestFocus();
                if (iVar.adapter == null) {
                    n.w(str2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i5;
                } else {
                    d dVar = adapter2.O.T();
                    if (dVar != null) {
                        dVar.clearCommentField();
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private final void T1() {
        g2(2131886123);
        androidx.fragment.app.e activity = getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
    }

    private static final void U1(i iVar, y yVar) {
        n.f(iVar, "this$0");
        z = yVar instanceof LoadResult_Error;
        if (yVar instanceof oadResult_Error) {
            a.d(yVar.component1());
            iVar.T1();
        } else {
            if (yVar instanceof LoadResult_Success && iVar.adapter != null) {
                n.e(adapter2.P, "binding.recycleView");
                iVar.c2(adapter2.P);
                iVar.X1();
                iVar.V1();
            }
        }
    }

    private final void V1() {
        ChallengeEntryModel challengeEntryModel = J1().a0();
        if (this.linearLayoutManager != null) {
            this.linearLayoutManager.insertCaptionItem(challengeEntryModel, J1().T());
        }
        n.d(challengeEntryModel);
        final String challengeId = challengeEntryModel.getChallengeId();
        n.d(challengeId);
        J1().Q0(challengeEntryModel.getDocumentId(), challengeId).addOnCompleteListener(new app.dogo.com.dogo_android.welcome_v2.entrysharedeeplink.d(this, challengeEntryModel));
    }

    private static final void W1(i iVar, ChallengeEntryModel challengeEntryModel, com.google.android.gms.tasks.j jVar) {
        n.f(iVar, "this$0");
        n.f(jVar, "task");
        if (jVar.isSuccessful()) {
            iVar.J1().G(iVar.J1().f0());
            iVar.J1().K0();
            if (iVar.linearLayoutManager != null) {
                iVar.linearLayoutManager.updateCaption(challengeEntryModel, iVar.J1().T());
            }
        } else {
            int i = 2131886123;
            iVar.g2(i);
            androidx.fragment.app.e activity = iVar.getActivity();
            if (activity != null) {
                activity.onBackPressed();
            }
        }
    }

    private final void X1() {
        androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
        String str = "viewLifecycleOwner";
        n.e(viewLifecycleOwner, str);
        J1().U().observe(viewLifecycleOwner, new app.dogo.com.dogo_android.welcome_v2.entrysharedeeplink.h(this));
        androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner2, str);
        J1().e0().observe(viewLifecycleOwner2, new app.dogo.com.dogo_android.welcome_v2.entrysharedeeplink.c(this));
        J1().Y().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.welcome_v2.entrysharedeeplink.g(this));
        J1().c0().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.welcome_v2.entrysharedeeplink.a(this));
    }

    private static final void Y1(i iVar, List list) {
        int i2 = 0;
        str = "this$0";
        n.f(iVar, str);
        if (list != null) {
            n.d(iVar.v);
            if (iVar.v.r2() == 0) {
                if (iVar.adapter == null) {
                    n.w("binding");
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) 0;
                } else {
                    i2 = 0;
                    adapter2.P.q1(i2);
                }
            }
            if (iVar.linearLayoutManager != null) {
                iVar.linearLayoutManager.addComments(list, iVar.J1().d0());
            }
        }
    }

    private static final void Z1(i iVar, List list) {
        int i = 1;
        str = "this$0";
        n.f(iVar, str);
        if (list != null && iVar.linearLayoutManager == null) {
            i = 0;
            list = i;
            if (iVar.v != 0) {
                if (iVar.adapter == null) {
                    n.w("binding");
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) 0;
                } else {
                    adapter2.P.q1(i);
                }
            }
            if (iVar.linearLayoutManager != null) {
                iVar.linearLayoutManager.k2();
            }
        }
    }

    private static final void a2(i iVar, Boolean boolean) {
        n.f(iVar, "this$0");
    }

    private static final void b2(i iVar, Boolean boolean) {
        int boolean22;
        str = "this$0";
        n.f(iVar, str);
        if (iVar.linearLayoutManager != null) {
            boolean22 = 0;
            if (iVar.linearLayoutManager == null) {
            } else {
                boolean22 = iVar.linearLayoutManager.getItemCount();
            }
            iVar.linearLayoutManager.notifyItemRangeChanged(boolean22, boolean22);
        }
    }

    private final void c2(RecyclerView recyclerView) {
        ArrayList arrayList = new ArrayList();
        Iterator it = J1().S().iterator();
        while (it.hasNext()) {
            boolean z = false;
            int i = 2;
            kotlin.d0.d.g gVar = null;
            arrayList.add(new ChallengeCommentItem((ChallengeComment)it.next(), z, i, gVar));
        }
        this.linearLayoutManager = new ChallengeCommentsListAdapter(arrayList, OnboardingChallengeEntryFragment.y, J1().s0());
        this.v = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(this.linearLayoutManager);
        recyclerView.setLayoutManager(this.v);
        recyclerView.q1(J1().b0());
        recyclerView.l(new OnboardingChallengeEntryFragment_setupRecyclerView_1(this));
        if (this.linearLayoutManager != null) {
            this.linearLayoutManager.a0(new app.dogo.com.dogo_android.welcome_v2.entrysharedeeplink.b(this));
        }
    }

    private static final boolean d2(i iVar, View view, int i) {
        h.a.b.h.f fVar;
        int i6;
        int i7;
        int i10 = 2131363063;
        ChallengeEntryModel model;
        n.f(iVar, "this$0");
        n.f(view, "view");
        i = 0;
        if (iVar.linearLayoutManager == null) {
        } else {
            fVar = iVar.linearLayoutManager.O0(i);
        }
        z = fVar instanceof ChallengeCommentCaptionItem;
        i7 = 1;
        i7 = 0;
        if (fVar instanceof ChallengeCommentCaptionItem) {
            int i8 = 2131362404;
            int i9 = 2131362724;
            i10 = 2131363063;
            if (view.getId() == 2131363063) {
                i iVar2 = fVar;
                if (iVar.J1().q0(iVar2.getModel())) {
                    iVar.f2(iVar2);
                } else {
                    if (l.z(iVar2.getModel().getDocumentId()) ^ i7 != 0) {
                        App.INSTANCE.r().logEvent(E_Challenges.B);
                    }
                }
            }
        }
        z2 = fVar instanceof ChallengeCommentItem;
        if (fVar instanceof ChallengeCommentItem) {
            if (view.getId() == R.id.delete_button_touch_area) {
                iVar.e2((ChallengeCommentItem)fVar.g(), i);
            }
            i10 = 2131363058;
            if (view.getId() == 2131363058) {
                String str7 = "binding";
                if (iVar.adapter == null) {
                    n.w(str7);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    d dVar = adapter2.O.T();
                    if (dVar != null) {
                        dVar.addReplyTag((ChallengeCommentItem)fVar.g());
                    }
                    if (iVar.adapter == null) {
                        n.w(str7);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        n.e(adapter22.O.Q, "binding.commentView.commentField");
                        app.dogo.com.dogo_android.util.extensionfunction.k1.legacyShowDialog(iVar, adapter22.O.Q);
                    }
                }
            }
            i = 2131363061;
            if (view.getId() == 2131363061) {
                String entryId = fVar.g().getEntryId();
                String documentId2 = fVar.g().getDocumentId();
                if (entryId == null || l.z(entryId)) {
                }
                if (adapter2.O == 0 && documentId2 != null) {
                    if (!(l.z(documentId2))) {
                    }
                    if (i7 == 0) {
                        App.INSTANCE.r().logEvent(E_Challenges.B);
                        androidx.fragment.app.e requireActivity = iVar.requireActivity();
                        n.e(requireActivity, "requireActivity()");
                        app.dogo.com.dogo_android.util.extensionfunction.g1.T(requireActivity, entryId, documentId2, new app.dogo.com.dogo_android.welcome_v2.entrysharedeeplink.i.e(iVar, fVar, i));
                    }
                }
            }
        }
        return false;
    }

    private final void e2(ChallengeComment challengeComment, int i) {
        final androidx.fragment.app.e requireActivity = requireActivity();
        n.e(requireActivity, "requireActivity()");
        app.dogo.com.dogo_android.util.extensionfunction.f1.showInputDialog(requireActivity, new app.dogo.com.dogo_android.welcome_v2.entrysharedeeplink.i.f(challengeComment, this, i));
    }

    private final void f2(i iVar) {
        final androidx.fragment.app.e requireActivity = requireActivity();
        n.e(requireActivity, "requireActivity()");
        app.dogo.com.dogo_android.util.extensionfunction.f1.showInputDialog(requireActivity, new app.dogo.com.dogo_android.welcome_v2.entrysharedeeplink.i.g(this, iVar));
    }

    private final void g2(int i) throws android.content.res.Resources.NotFoundException {
        if (this.topBarManager != null) {
            this.topBarManager.cancel();
        }
        final Toast text = Toast.makeText(getContext(), i, 1);
        this.topBarManager = text;
        if (text != null) {
            text.show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void h2(String str, int i) {
        DogCreationScreenKey dogCreationScreenKey = new DogCreationScreenKey(str, null, false, false, 14, null);
        android.content.Context requireContext = requireContext();
        n.e(requireContext, "requireContext()");
        startActivityForResult(dogCreationScreenKey.buildIntent(requireContext), i);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        int i3 = 11100;
        super.onActivityResult(i, i2, intent);
        i3 = 11100;
        if (i == 11100 || i == 11101) {
            J1().F0();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        n.f(layoutInflater, "inflater");
        e8 e8Var = e8.T(layoutInflater, viewGroup, false);
        n.e(e8Var, "inflate(inflater, container, false)");
        this.adapter = e8Var;
        J1().F0();
        int i = 0;
        String str9 = "binding";
        if (this.adapter == null) {
            n.w(str9);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            adapter2.O.U(G1());
            if (this.adapter == null) {
                n.w(str9);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                adapter22.Q.U(H1());
                if (this.adapter == null) {
                    n.w(str9);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    adapter23.O.Q.setOnKeyListener(new app.dogo.com.dogo_android.welcome_v2.entrysharedeeplink.f(this));
                    J1().registry = OnboardingChallengeEntryFragment.y;
                    bundle = new Bundle();
                    bundle.putString("entryId", I1().b());
                    bundle.putString("challengeId", I1().createFragment());
                    bundle.putString("linkType", I1().c());
                    if (!J1().O0(bundle)) {
                        T1();
                    }
                    J1().G0();
                    if (this.adapter == null) {
                        n.w(str9);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        View view = this.adapter.w();
                        n.e(view, "binding.root");
                        return view;
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        J1().K();
        J1().L();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        J1().G(J1().f0());
        J1().I();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        int i = 0;
        super.onStop();
        if (this.v == null) {
            i = 0;
        } else {
            i = this.v.v2();
        }
        J1().P0(i);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        J1().Z().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.welcome_v2.entrysharedeeplink.e(this));
    }

    /* renamed from: K1, reason: from kotlin metadata */
    public static /* synthetic */ void showDeleteCommentDialog(i model, Boolean position) {
        OnboardingChallengeEntryFragment.b2(model, position);
    }

    /* renamed from: L1, reason: from kotlin metadata */
    public static /* synthetic */ boolean onActivityResult(i requestCode, View resultCode, int data) {
        return OnboardingChallengeEntryFragment.d2(requestCode, resultCode, data);
    }

    /* renamed from: M1, reason: from kotlin metadata */
    public static /* synthetic */ void startDogCreation(i dogId, List requestCode) {
        OnboardingChallengeEntryFragment.Z1(dogId, requestCode);
    }

    /* renamed from: N1, reason: from kotlin metadata */
    public static /* synthetic */ void onCreateView(i inflater, ChallengeEntryModel container, com.google.android.gms.tasks.j savedInstanceState) {
        OnboardingChallengeEntryFragment.W1(inflater, container, savedInstanceState);
    }

    public static /* synthetic */ void O1(i iVar, y yVar) {
        OnboardingChallengeEntryFragment.U1(iVar, yVar);
    }

    public static /* synthetic */ boolean P1(i iVar, View view, int i, KeyEvent keyEvent) {
        return OnboardingChallengeEntryFragment.S1(iVar, view, i, keyEvent);
    }

    public static /* synthetic */ void Q1(i iVar, Boolean boolean) {
        OnboardingChallengeEntryFragment.a2(iVar, boolean);
    }

    public static /* synthetic */ void R1(i iVar, List list) {
        OnboardingChallengeEntryFragment.Y1(iVar, list);
    }
}
