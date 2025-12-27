package app.dogo.com.dogo_android.d.b;

import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.d.b.z.i;
import app.dogo.com.dogo_android.h.ci;
import app.dogo.com.dogo_android.h.cn;
import app.dogo.com.dogo_android.h.e8;
import app.dogo.com.dogo_android.k.c;
import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.model.ChallengeComment;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.DogProfileModel;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.e0.x;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.z;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.k0.d;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u;
import h.a.b.h.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.m;

/* compiled from: ChallengeCommentsDialog.kt */
@Metadata(d1 = "\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u0000 =2\u00020\u0001:\u0001=B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0014\u001a\u00020\u0015H\u0002J\u0008\u0010\u0016\u001a\u00020\u0017H\u0016J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016J\u0008\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010 0\u001fH\u0016J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0008\u0010%\u001a\u0004\u0018\u00010&2\u0008\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0008\u0010)\u001a\u00020*H\u0016J\u0008\u0010+\u001a\u00020*H\u0016J\u0008\u0010,\u001a\u00020*H\u0016J\u0008\u0010-\u001a\u00020*H\u0016J\u001a\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u00020\"2\u0008\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0008\u00100\u001a\u00020*H\u0002J\u0008\u00101\u001a\u00020*H\u0002J\u0010\u00102\u001a\u00020*2\u0006\u00103\u001a\u000204H\u0002J\u0018\u00105\u001a\u00020*2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002J\u0010\u0010:\u001a\u00020*2\u0006\u00106\u001a\u00020;H\u0002J\u0018\u0010<\u001a\u00020*2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000cR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0013\u0010\u000e\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006>", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/ChallengeCommentsDialog;", "Lapp/dogo/com/dogo_android/util/base_classes/LegacyFullScreenFragment;", "()V", "adapter", "Lapp/dogo/com/dogo_android/challenge/comments/ChallengeCommentsListAdapter;", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogChallengeCommentsBinding;", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "vm", "Lapp/dogo/com/dogo_android/challenge/comments/ChallengeCommentsViewModel;", "getVm", "()Lapp/dogo/com/dogo_android/challenge/comments/ChallengeCommentsViewModel;", "vm$delegate", "createCommentBarManager", "Lapp/dogo/com/dogo_android/util/interfaces/CommentBarManager;", "getFragmentTag", "Lapp/dogo/com/dogo_android/enums/TagGlue;", "getScreenViewDescriptor", "Lapp/dogo/com/dogo_android/tracking/Screen;", "getTitle", "", "getTopBarBinding", "Lapp/dogo/com/dogo_android/databinding/LayoutTopBarBinding;", "getViewModelClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onPause", "onResume", "onStop", "onViewCreated", "view", "setupCommentListData", "setupObservers", "setupRecyclerView", "recycleView", "Landroidx/recyclerview/widget/RecyclerView;", "showDeleteCommentDialog", "model", "Lapp/dogo/com/dogo_android/model/ChallengeComment;", "position", "", "showDeleteEntryDialog", "Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentCaptionItem;", "showReportDialog", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: v, reason: from kotlin metadata */
public final class ChallengeCommentsDialog extends x {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final v.a INSTANCE = new v$a(0);
    /* renamed from: A, reason: from kotlin metadata */
    private final h adapter;
    /* renamed from: B, reason: from kotlin metadata */
    private w binding;
    /* renamed from: C, reason: from kotlin metadata */
    private LinearLayoutManager linearLayoutManager;
    private final h y;
    private e8 z;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/ChallengeCommentsDialog$Companion;", "", "()V", "COMMENT_DOG_PROFILE_SELECT", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        private a() {
            super();
        }

        public /* synthetic */ a(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/challenge/comments/ChallengeCommentsDialog$setupRecyclerView$1", "Lapp/dogo/com/dogo_android/util/recycle_views/EndlessRecyclerOnScrollListener;", "onLoadMore", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends app.dogo.com.dogo_android.util.n0.k {

        final /* synthetic */ v d;
        c() {
            this.d = vVar;
            super(20);
        }

        @Override // app.dogo.com.dogo_android.util.n0.k
        /* renamed from: a, reason: from kotlin metadata */
        public void onLoadMore() {
            this.d.i2().K0();
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements kotlin.d0.c.l<String, kotlin.w> {
        @Override // kotlin.d0.d.p
        public final void a(String str) {
            n.f(str, "it");
            if (!v.this.i2().k0()) {
                a0 a0Var = v.this.G1();
                if (a0Var != null) {
                    a0Var.onBackPressed();
                }
            }
        }

        d() {
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements kotlin.d0.c.a<kotlin.w> {

        final /* synthetic */ f<?> $item;
        final /* synthetic */ int $position;
        @Override // kotlin.d0.d.p
        public final void invoke() {
            v.this.G2((ChallengeCommentItem)this.$item.g(), this.$position);
        }

        e(f<?> fVar, int i) {
            this.$item = fVar;
            this.$position = i;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends p implements kotlin.d0.c.a<kotlin.w> {

        final /* synthetic */ f<?> $item;
        final /* synthetic */ int $position;
        @Override // kotlin.d0.d.p
        public final void invoke() {
            v.this.showReportDialog((ChallengeCommentItem)this.$item.g(), this.$position);
        }

        f(f<?> fVar, int i) {
            this.$item = fVar;
            this.$position = i;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends p implements kotlin.d0.c.l<String, kotlin.w> {

        final /* synthetic */ f<?> $item;
        final /* synthetic */ int $position;
        @Override // kotlin.d0.d.p
        public final void a(String str) {
            str2 = "it";
            n.f(str, str2);
            if (!v.this.i2().k0()) {
                if (!v.this.i2().n0((ChallengeCommentItem)this.$item.g())) {
                    app.dogo.com.dogo_android.d.b.w wVar = v.this.binding;
                    if (wVar != null) {
                        wVar.removeItem(this.$position);
                    }
                }
            }
        }

        g(f<?> fVar, int i) {
            this.$item = fVar;
            this.$position = i;
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class h extends p implements kotlin.d0.c.a<kotlin.w> {

        final /* synthetic */ ChallengeComment $model;
        final /* synthetic */ int $position;
        @Override // kotlin.d0.d.p
        public final kotlin.w a() {
            kotlin.w wVar2 = null;
            int i = 0;
            if (this.$model.getDocumentId() == null) {
                v.this.Z1(2131886123);
                wVar2 = w.a;
            } else {
                v.this.i2().M0(this.$model, v.this.D1().getTag());
                if (v.this.i2().U0(this.$model)) {
                    app.dogo.com.dogo_android.d.b.w wVar = v.this.binding;
                    if (wVar != null) {
                        wVar.removeItem(this.$position);
                        wVar2 = w.a;
                    }
                } else {
                    wVar = v.this.binding;
                    if (wVar != null) {
                        wVar.j2(this.$position);
                        wVar2 = w.a;
                    }
                }
            }
            return wVar2;
        }

        h(ChallengeComment challengeComment, v vVar, int i) {
            this.$model = challengeComment;
            this.$position = i;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class i extends p implements kotlin.d0.c.a<kotlin.w> {

        final /* synthetic */ i $model;
        @Override // kotlin.d0.d.p
        public final kotlin.w a() {
            kotlin.w wVar = null;
            if (v.this.i2().J(this.$model.getModel(), this.$model.h())) {
                a0 a0Var = v.this.G1();
                if (a0Var != null) {
                    a0Var.onBackPressed();
                }
            }
            app.dogo.com.dogo_android.d.b.w wVar2 = v.this.binding;
            if (wVar2 == null) {
                int i2 = 0;
            } else {
                int i = 0;
                wVar2.notifyItemChanged(i);
                wVar = w.a;
            }
            return wVar;
        }

        i(i iVar) {
            this.$model = iVar;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class j extends p implements kotlin.d0.c.l<String, kotlin.w> {

        final /* synthetic */ ChallengeComment $model;
        final /* synthetic */ int $position;
        @Override // kotlin.d0.d.p
        public final void a(String str) {
            str2 = "it";
            n.f(str, str2);
            if (!v.this.i2().k0()) {
                if (!v.this.i2().n0(this.$model)) {
                    app.dogo.com.dogo_android.d.b.w wVar = v.this.binding;
                    if (wVar != null) {
                        wVar.removeItem(this.$position);
                    }
                }
            }
        }

        j(ChallengeComment challengeComment, int i) {
            this.$model = challengeComment;
            this.$position = i;
            super(1);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class k extends p implements kotlin.d0.c.a<app.dogo.com.dogo_android.view.dailytraining.l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final app.dogo.com.dogo_android.view.dailytraining.l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(SessionViewModel.class), this.$parameters);
        }

        public k(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class l extends p implements kotlin.d0.c.a<x> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final x invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(ChallengeCommentsViewModel.class), this.$parameters);
        }

        public l(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\u0008\u0010\u0004\u001a\u00020\u0005H\u0016J\u0008\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0016J\u0008\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u000e", d2 = {"app/dogo/com/dogo_android/challenge/comments/ChallengeCommentsDialog$createCommentBarManager$1", "Lapp/dogo/com/dogo_android/util/interfaces/CommentBarManager;", "getUserDogIcon", "Landroid/net/Uri;", "isUserPremiumBadgeVisible", "", "onAvatarClick", "", "onSendActionListener", "string", "", "replyTarget", "Lapp/dogo/com/dogo_android/model/ChallengeComment;", "permissionCheck", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends d {

        final /* synthetic */ v a;
        b() {
            this.a = vVar;
            super();
        }

        @Override // app.dogo.com.dogo_android.util.k0.d
        public Uri getUserDogIcon() {
            return this.a.i2().h0();
        }

        @Override // app.dogo.com.dogo_android.util.k0.d
        public boolean isUserPremiumBadgeVisible() {
            return this.a.i2().s0();
        }

        @Override // app.dogo.com.dogo_android.util.k0.d
        public void onAvatarClick() {
            if (this.a.i2().W() > 0) {
                a0 a0Var = this.a.G1();
                if (a0Var != null) {
                    str = "comment_dog_select";
                    str2 = "challenges_entry_comments";
                    a0Var.l0(str, str2);
                }
            } else {
                a0Var = this.a.G1();
                if (a0Var != null) {
                    a0Var.w0(this.a.i2().X(), 11100);
                }
            }
        }

        @Override // app.dogo.com.dogo_android.util.k0.d
        public void onSendActionListener(String string, ChallengeComment replyTarget) {
            int i = 11100;
            n.f(string, "string");
            if (this.a.i2().m0()) {
                a0 a0Var = this.a.G1();
                if (a0Var != null) {
                    i = 11100;
                    a0Var.w0(this.a.i2().X(), i);
                }
                int i4 = 2131886415;
                this.a.Z1(i4);
                return;
            } else {
                if (!this.a.i2().isUserSignedIn()) {
                    androidx.fragment.app.e activity = this.a.getActivity();
                    if (activity != null) {
                        int i2 = 0;
                        app.dogo.com.dogo_android.repository.domain.ZendeskConfigurationInfo zendeskConfigurationInfo = null;
                        int i3 = 5;
                        Object obj = null;
                        str = "challenges_entry_comments";
                        app.dogo.com.dogo_android.util.extensionfunction.g1.H(activity, i2, str, zendeskConfigurationInfo, i3, obj);
                    }
                } else {
                    this.a.i2().N0(string, replyTarget);
                    clearCommentField();
                    e8 e8Var = this.a.z;
                    if (e8Var != null) {
                        i4 = 1;
                        e8Var.P.q1(i4);
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
            if (this.a.i2().o0()) {
                int r0 = this.a.i2().r0() ? 1 : 0;
            }
            return (this.a.i2().r0() ? 1 : 0);
        }
    }

    public v() {
        super();
        final m.a.c.j.a aVar = null;
        this.y = j.a(LazyThreadSafetyMode.NONE, new app.dogo.com.dogo_android.challenge.comments.v.k(this, aVar, aVar));
        this.adapter = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new app.dogo.com.dogo_android.challenge.comments.v.l(this, aVar, aVar));
    }

    /* renamed from: A2, reason: from kotlin metadata */
    private static final void onViewCreated(v view, y savedInstanceState) {
        int i;
        n.f(view, "this$0");
        n.e(savedInstanceState, "it");
        i = 0;
        savedInstanceState = app.dogo.com.dogo_android.util.base_classes.z.b(savedInstanceState) instanceof DogProfile ? (DogProfile)app.dogo.com.dogo_android.util.base_classes.z.b(savedInstanceState) : i;
        if (i == 0) {
            return;
        } else {
            view.i2().W0(i.getId());
            if (view.z != null) {
                d dVar = e8Var.O.T();
                if (dVar != null) {
                    dVar.updateDogAvatar();
                }
            }
        }
        n.w("binding");
        /* Dexterity WARN: Type inference failed for thrown value */
        throw (Throwable) i;
    }

    /* renamed from: B2, reason: from kotlin metadata */
    private static final void showDeleteCommentDialog(v model, Boolean position) {
        int position2;
        str = "this$0";
        n.f(model, str);
        if (model.binding != null) {
            position2 = 0;
            if (model.binding == null) {
            } else {
                position2 = model.binding.getItemCount();
            }
            model.binding.notifyItemRangeChanged(position2, position2);
        }
    }

    /* renamed from: C2, reason: from kotlin metadata */
    private final void setupRecyclerView(RecyclerView recycleView) {
        ArrayList arrayList = new ArrayList();
        Iterator it = i2().S().iterator();
        while (it.hasNext()) {
            boolean z = false;
            int i = 2;
            g gVar = null;
            arrayList.add(new ChallengeCommentItem((ChallengeComment)it.next(), z, i, gVar));
        }
        this.binding = new ChallengeCommentsListAdapter(arrayList, D1(), i2().s0());
        this.linearLayoutManager = new LinearLayoutManager(getContext());
        recycleView.setAdapter(this.binding);
        recycleView.setLayoutManager(this.linearLayoutManager);
        recycleView.q1(i2().b0());
        recycleView.l(new ChallengeCommentsDialog_setupRecyclerView_1(this));
        n.d(this.binding);
        this.binding.a0(new app.dogo.com.dogo_android.challenge.comments.i(this));
    }

    /* renamed from: D2, reason: from kotlin metadata */
    private static final boolean onCreateView(v inflater, View container, int savedInstanceState) throws v.e {
        int i4;
        String str;
        int i10 = 2131363063;
        ChallengeEntryModel model;
        ChallengeComment challengeComment;
        boolean z4 = true;
        String dogAvatarUrl;
        int i9;
        String dogAvatarUrl2;
        String str2;
        String str3;
        Long l;
        String str4;
        int i18;
        String dogId;
        Double d;
        boolean z5;
        Long l2;
        int i19;
        g gVar = null;
        inflater2 = inflater;
        savedInstanceState2 = savedInstanceState;
        n.f(inflater2, "this$0");
        n.f(container, "view");
        n.d(inflater2.binding);
        f fVar = inflater2.binding.O0(savedInstanceState2);
        z = fVar instanceof ChallengeCommentCaptionItem;
        str = "requireActivity()";
        final int i20 = 2131362981;
        i9 = 0;
        if (fVar instanceof ChallengeCommentCaptionItem) {
            int i14 = 2131362404;
            if (container.getId() == 2131362404) {
                if (inflater.i2().M(fVar.getModel(), fVar.g())) {
                    n.d(inflater2.binding);
                    inflater2.binding.notifyItemChanged(savedInstanceState2, 100);
                }
            }
            int i15 = 2131362724;
            if (container.getId() == 2131362724) {
                if (inflater.i2().N(fVar.getModel(), fVar.g())) {
                    n.d(inflater2.binding);
                    inflater2.binding.notifyItemChanged(savedInstanceState2, null);
                }
            }
            int i16 = 2131363557;
            int i17 = 2131362149;
            if (container.getId() == 2131362149 || container.getId() == i20) {
                dogId = fVar.getModel().getDogId();
                if (dogId != null) {
                    str2 = null;
                    str3 = null;
                    l = null;
                    str4 = null;
                    i18 = 0;
                    d = null;
                    z5 = false;
                    l2 = null;
                    i19 = 1916;
                    gVar = null;
                    DogProfileModel dogProfileModel2 = new DogProfileModel(fVar.getModel().getDogName(), fVar.getModel().getDogAvatarUrl(), str2, str3, l, str4, i18, dogId, d, z5, l2, i19, gVar);
                    a0 a0Var4 = inflater.G1();
                    if (a0Var4 != null) {
                        a0Var4.f0(dogProfileModel2, fVar.getModel().getBadges());
                    }
                }
            }
            i10 = 2131363063;
            if (container.getId() == 2131363063) {
                i iVar = fVar;
                if (inflater.i2().q0(iVar.getModel())) {
                    inflater2.showDeleteEntryDialog(iVar);
                } else {
                    App.INSTANCE.r().logEvent(E_Challenges.B);
                    androidx.fragment.app.e requireActivity = inflater.requireActivity();
                    n.e(requireActivity, str);
                    app.dogo.com.dogo_android.util.extensionfunction.g1.launchLogInActivity(requireActivity, iVar.getModel().getDocumentId(), new app.dogo.com.dogo_android.challenge.comments.v.d(inflater2));
                }
            }
        }
        z2 = fVar instanceof ChallengeCommentItem;
        if (fVar instanceof ChallengeCommentItem) {
            int i11 = 2131362294;
            if (container.getId() == 2131362294) {
                if (inflater.i2().n0(fVar.g())) {
                    if (inflater.i2().l0(fVar.g())) {
                        inflater2.showReportDialog(fVar.g(), savedInstanceState2);
                    } else {
                        androidx.fragment.app.e activity = inflater.getActivity();
                        if (activity != null) {
                            app.dogo.com.dogo_android.util.extensionfunction.f1.J(activity, new app.dogo.com.dogo_android.challenge.comments.v.e(inflater2, fVar, savedInstanceState2), new app.dogo.com.dogo_android.challenge.comments.v.f(inflater2, fVar, savedInstanceState2));
                        }
                    }
                }
            }
            int i12 = 2131363058;
            if (container.getId() == 2131363058) {
                i12 = 0;
                String str11 = "binding";
                if (inflater2.z == null) {
                    n.w(str11);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i12;
                } else {
                    d dVar = e8Var.O.T();
                    n.d(dVar);
                    dVar.addReplyTag((ChallengeCommentItem)fVar.g());
                    if (inflater2.z == null) {
                        n.w(str11);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i12;
                    } else {
                        inflater2.Y1(e8Var2.O.Q);
                    }
                }
            }
            int i13 = 2131362217;
            z4 = true;
            if (container.getId() == 2131362217) {
                if ((ChallengeCommentItem)fVar.g().isSpam()) {
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("challenge", inflater.i2().T());
                    bundle.putBoolean("show_rules", z4);
                    bundle.putBoolean("hide_participate_button", z4);
                    dogAvatarUrl = "style";
                    bundle.putInt(dogAvatarUrl, 2131951968);
                    a0 a0Var3 = inflater.G1();
                    if (a0Var3 != null) {
                        a0Var3.k(DialogTags.CHALLENGE_DETAILS_DIALOG, bundle);
                    }
                }
            }
            i10 = 2131363061;
            if (container.getId() == 2131363061) {
                String entryId = fVar.g().getEntryId();
                String documentId = fVar.g().getDocumentId();
                if (entryId == null || l.z(entryId)) {
                }
                if (DialogTags.CHALLENGE_DETAILS_DIALOG == 0 && documentId != null) {
                    if (!(l.z(documentId))) {
                    }
                    if (!E_Challenges.B) {
                        App.INSTANCE.r().logEvent(E_Challenges.B);
                        androidx.fragment.app.e requireActivity2 = inflater.requireActivity();
                        n.e(requireActivity2, str);
                        app.dogo.com.dogo_android.util.extensionfunction.g1.T(requireActivity2, entryId, documentId, new app.dogo.com.dogo_android.challenge.comments.v.g(inflater2, fVar, savedInstanceState2));
                    }
                }
            }
            if (container.getId() == i20) {
                ChallengeComment challengeComment2 = fVar.g();
                dogAvatarUrl2 = null;
                str2 = null;
                DogProfileModel dogProfileModel = new DogProfileModel(challengeComment2.getDogName(), challengeComment2.getDogAvatarUrl(), dogAvatarUrl2, str2, null, null, 0, challengeComment2.getDogId(), null, false, null, 1916, null);
                a0 a0Var = inflater.G1();
                if (a0Var != null) {
                    a0Var.f0(dogProfileModel, fVar.g().getBadges());
                }
            }
        }
        return false;
    }

    /* renamed from: E2, reason: from kotlin metadata */
    private final void showReportDialog(ChallengeComment model, int position) {
        final androidx.fragment.app.e requireActivity = requireActivity();
        n.e(requireActivity, "requireActivity()");
        app.dogo.com.dogo_android.util.extensionfunction.f1.showInputDialog(requireActivity, new app.dogo.com.dogo_android.challenge.comments.v.h(model, this, position));
    }

    /* renamed from: F2, reason: from kotlin metadata */
    private final void showDeleteEntryDialog(i model) {
        final androidx.fragment.app.e requireActivity = requireActivity();
        n.e(requireActivity, "requireActivity()");
        app.dogo.com.dogo_android.util.extensionfunction.f1.showInputDialog(requireActivity, new app.dogo.com.dogo_android.challenge.comments.v.i(this, model));
    }

    private final void G2(ChallengeComment challengeComment, int i) {
        boolean z;
        final String entryId = challengeComment.getEntryId();
        final String documentId = challengeComment.getDocumentId();
        i = 0;
        i = 1;
        if (entryId == null || l.z(entryId)) {
        }
        if (i == 0 && documentId != null) {
            if (l.z(documentId)) {
            }
            if (i == 0) {
                App.INSTANCE.r().logEvent(E_Challenges.B);
                androidx.fragment.app.e requireActivity = requireActivity();
                n.e(requireActivity, "requireActivity()");
                app.dogo.com.dogo_android.util.extensionfunction.g1.T(requireActivity, entryId, documentId, new app.dogo.com.dogo_android.challenge.comments.v.j(this, challengeComment, i));
            }
        }
    }

    public static final /* synthetic */ w c2(v vVar) {
        return vVar.binding;
    }

    public static final /* synthetic */ e8 d2(v vVar) {
        return vVar.z;
    }

    public static final /* synthetic */ x e2(v vVar) {
        return vVar.i2();
    }

    public static final /* synthetic */ void f2(v vVar, ChallengeComment challengeComment, int i) {
        vVar.showReportDialog(challengeComment, i);
    }

    public static final /* synthetic */ void g2(v vVar, ChallengeComment challengeComment, int i) {
        vVar.G2(challengeComment, i);
    }

    private final app.dogo.com.dogo_android.view.dailytraining.l getSharedViewModel() {
        return (SessionViewModel)this.y.getValue();
    }

    /* renamed from: h2, reason: from kotlin metadata */
    private final d createCommentBarManager() {
        return new ChallengeCommentsDialog_createCommentBarManager_1(this);
    }

    private final x i2() {
        return (ChallengeCommentsViewModel)this.adapter.getValue();
    }

    private static final boolean s2(v vVar, View view, int i, KeyEvent keyEvent) {
        n.f(vVar, "this$0");
        if (i == 4) {
            final int i5 = 0;
            final String str2 = "binding";
            if (vVar.z == null) {
                n.w(str2);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i5;
            } else {
                e8Var2.O.S.requestFocus();
                if (vVar.z == null) {
                    n.w(str2);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i5;
                } else {
                    d dVar = e8Var.O.T();
                    n.d(dVar);
                    dVar.clearCommentField();
                    return true;
                }
            }
        }
        return false;
    }

    private static final void t2(v vVar, y yVar) {
        n.f(vVar, "this$0");
        z = yVar instanceof LoadResult_Error;
        if (yVar instanceof oadResult_Error) {
            z2 = yVar.component1() instanceof UnknownHostException;
            if (yVar.component1() instanceof UnknownHostException) {
                androidx.fragment.app.e activity = vVar.getActivity();
                if (activity != null) {
                    app.dogo.com.dogo_android.util.extensionfunction.g1.g0(activity, 2131886953);
                }
            } else {
                vVar.Z1(2131886123);
                a0 a0Var = vVar.G1();
                if (a0Var != null) {
                    a0Var.onBackPressed();
                }
            }
        } else {
            z2 = yVar instanceof LoadResult_Success;
            if (yVar instanceof oadResult_Success && vVar.z != null) {
                n.e(e8Var.P, "binding.recycleView");
                vVar.setupRecyclerView(e8Var.P);
                vVar.w2();
                vVar.u2();
            }
        }
    }

    private final void u2() {
        ChallengeEntryModel challengeEntryModel = i2().a0();
        if (this.binding != null) {
            this.binding.h2(challengeEntryModel, i2().T());
        }
        n.d(challengeEntryModel);
        final String challengeId = challengeEntryModel.getChallengeId();
        n.d(challengeId);
        i2().Q0(challengeEntryModel.getDocumentId(), challengeId).addOnCompleteListener(new app.dogo.com.dogo_android.challenge.comments.a(this, challengeEntryModel));
    }

    private static final void v2(v vVar, ChallengeEntryModel challengeEntryModel, com.google.android.gms.tasks.j jVar) {
        n.f(vVar, "this$0");
        n.f(jVar, "task");
        if (jVar.isSuccessful()) {
            vVar.i2().G(vVar.i2().f0());
            vVar.i2().K0();
            if (vVar.binding != null) {
                vVar.binding.n2(challengeEntryModel, vVar.i2().T());
            }
        }
    }

    private final void w2() {
        androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
        String str = "viewLifecycleOwner";
        n.e(viewLifecycleOwner, str);
        i2().U().observe(viewLifecycleOwner, new app.dogo.com.dogo_android.challenge.comments.g(this));
        androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner2, str);
        i2().g0().observe(viewLifecycleOwner2, new app.dogo.com.dogo_android.challenge.comments.e(this));
        i2().Y().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.challenge.comments.h(this));
        getSharedViewModel().E().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.challenge.comments.f(this));
        i2().c0().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.challenge.comments.c(this));
    }

    private static final void x2(v vVar, List list) {
        int i2 = 0;
        str = "this$0";
        n.f(vVar, str);
        if (list != null) {
            n.d(vVar.linearLayoutManager);
            if (vVar.linearLayoutManager.r2() == 0) {
                if (vVar.z == null) {
                    n.w("binding");
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) 0;
                } else {
                    i2 = 0;
                    e8Var.P.q1(i2);
                }
            }
            if (vVar.binding != null) {
                vVar.binding.e2(list, vVar.i2().d0());
            }
            i3 = !list.isEmpty();
            if (!list.isEmpty()) {
                vVar.i2().V0();
            }
        }
    }

    private static final void y2(v vVar, String str) {
        n.f(vVar, "this$0");
        n.f(str, "commentId");
        if (vVar.binding != null) {
            vVar.binding.m2(str);
        }
    }

    private static final void z2(v vVar, Boolean boolean) {
        n.f(vVar, "this$0");
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public q D1() {
        return FullScreenTag.CHALLENGE_COMMENTS_DIALOG;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public k3 H1() {
        return S.clickerHelp;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public String I1() throws android.content.res.Resources.NotFoundException {
        int i;
        boolean z = false;
        int i2 = 4;
        String quantityString = getResources().getQuantityString(2131755009, 999);
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

    @Override // app.dogo.com.dogo_android.util.e0.x
    public cn b2() {
        if (this.z == null) {
            n.w("binding");
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) 0;
        } else {
            n.e(e8Var.Q, "binding.topBar");
            return e8Var.Q;
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        n.f(layoutInflater, "inflater");
        e8 e8Var = e8.T(layoutInflater, viewGroup, false);
        n.e(e8Var, "inflate(inflater, container, false)");
        this.z = e8Var;
        int i2 = 0;
        String str4 = "binding";
        if (e8Var == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i2;
        } else {
            e8Var.W(i2());
            if (this.z == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i2;
            } else {
                this.z.V(G1());
                i2().F0();
                if (this.z == null) {
                    n.w(str4);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i2;
                } else {
                    e8Var3.O.U(createCommentBarManager());
                    if (this.z == null) {
                        n.w(str4);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i2;
                    } else {
                        e8Var4.O.Q.setOnKeyListener(new app.dogo.com.dogo_android.challenge.comments.b(this));
                        i2().registry = D1();
                        if (!i2().O0(getArguments())) {
                            Z1(2131886123);
                            a0 a0Var2 = G1();
                            if (a0Var2 != null) {
                                a0Var2.onBackPressed();
                            }
                        }
                        i2().G0();
                        if (this.z == null) {
                            n.w(str4);
                            /* Dexterity WARN: Type inference failed for thrown value */
                            throw (Throwable) i2;
                        } else {
                            View view = this.z.w();
                            n.e(view, "binding.root");
                            return view;
                        }
                    }
                }
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public void onDestroyView() {
        super.onDestroyView();
        this.binding = null;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public void onPause() {
        super.onPause();
        i2().K();
        i2().L();
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public void onResume() {
        super.onResume();
        i2().G(i2().f0());
        i2().I();
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public void onStop() {
        int i = 0;
        super.onStop();
        if (this.linearLayoutManager == null) {
            i = 0;
        } else {
            i = this.linearLayoutManager.v2();
        }
        i2().P0(i);
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public void onViewCreated(View view, Bundle bundle) {
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        i2().Z().observe(getViewLifecycleOwner(), new app.dogo.com.dogo_android.challenge.comments.d(this));
    }

    public static /* synthetic */ void j2(v vVar, ChallengeEntryModel challengeEntryModel, com.google.android.gms.tasks.j jVar) {
        ChallengeCommentsDialog.v2(vVar, challengeEntryModel, jVar);
    }

    public static /* synthetic */ boolean k2(v vVar, View view, int i, KeyEvent keyEvent) {
        return ChallengeCommentsDialog.s2(vVar, view, i, keyEvent);
    }

    public static /* synthetic */ void l2(v vVar, Boolean boolean) {
        ChallengeCommentsDialog.showDeleteCommentDialog(vVar, boolean);
    }

    public static /* synthetic */ void m2(v vVar, y yVar) {
        ChallengeCommentsDialog.t2(vVar, yVar);
    }

    public static /* synthetic */ void n2(v vVar, String str) {
        ChallengeCommentsDialog.y2(vVar, str);
    }

    public static /* synthetic */ void o2(v vVar, y yVar) {
        ChallengeCommentsDialog.onViewCreated(vVar, yVar);
    }

    public static /* synthetic */ void p2(v vVar, List list) {
        ChallengeCommentsDialog.x2(vVar, list);
    }

    public static /* synthetic */ void q2(v vVar, Boolean boolean) {
        ChallengeCommentsDialog.z2(vVar, boolean);
    }

    public static /* synthetic */ boolean r2(v vVar, View view, int i) {
        return ChallengeCommentsDialog.onCreateView(vVar, view, i);
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public Class<? extends r> K1() {
        return BaseViewModel.class;
    }
}
