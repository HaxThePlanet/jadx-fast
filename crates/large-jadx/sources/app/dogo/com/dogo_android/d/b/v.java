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
import app.dogo.com.dogo_android.d.b.z.k;
import app.dogo.com.dogo_android.h.ci;
import app.dogo.com.dogo_android.h.cn;
import app.dogo.com.dogo_android.h.e8;
import app.dogo.com.dogo_android.k.c;
import app.dogo.com.dogo_android.k.j;
import app.dogo.com.dogo_android.k.q;
import app.dogo.com.dogo_android.model.ChallengeComment;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.model.DogProfileModel;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.r;
import app.dogo.com.dogo_android.util.e0.w;
import app.dogo.com.dogo_android.util.e0.x;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.e0.z;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.k0.d;
import app.dogo.com.dogo_android.util.n0.k;
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.w.j3;
import app.dogo.com.dogo_android.w.k3;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u;
import com.google.android.gms.tasks.j;
import f.d.a.a;
import h.a.b.b;
import h.a.b.h.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.c.l;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.k0.l;
import kotlin.m;
import kotlin.w;
import m.a.b.a.d.a.a;
import m.a.b.a.d.a.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\t\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\u0018\u0000 =2\u00020\u0001:\u0001=B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0014\u001a\u00020\u0015H\u0002J\u0008\u0010\u0016\u001a\u00020\u0017H\u0016J\u0008\u0010\u0018\u001a\u00020\u0019H\u0016J\u0008\u0010\u001a\u001a\u00020\u001bH\u0016J\u0008\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001e\u001a\u000c\u0012\u0008\u0008\u0001\u0012\u0004\u0018\u00010 0\u001fH\u0016J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0008\u0010%\u001a\u0004\u0018\u00010&2\u0008\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0008\u0010)\u001a\u00020*H\u0016J\u0008\u0010+\u001a\u00020*H\u0016J\u0008\u0010,\u001a\u00020*H\u0016J\u0008\u0010-\u001a\u00020*H\u0016J\u001a\u0010.\u001a\u00020*2\u0006\u0010/\u001a\u00020\"2\u0008\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0008\u00100\u001a\u00020*H\u0002J\u0008\u00101\u001a\u00020*H\u0002J\u0010\u00102\u001a\u00020*2\u0006\u00103\u001a\u000204H\u0002J\u0018\u00105\u001a\u00020*2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002J\u0010\u0010:\u001a\u00020*2\u0006\u00106\u001a\u00020;H\u0002J\u0018\u0010<\u001a\u00020*2\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\r\u0010\u000e\u001a\u0004\u0008\u000b\u0010\u000cR\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0013\u0010\u000e\u001a\u0004\u0008\u0011\u0010\u0012¨\u0006>", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/ChallengeCommentsDialog;", "Lapp/dogo/com/dogo_android/util/base_classes/LegacyFullScreenFragment;", "()V", "adapter", "Lapp/dogo/com/dogo_android/challenge/comments/ChallengeCommentsListAdapter;", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogChallengeCommentsBinding;", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "vm", "Lapp/dogo/com/dogo_android/challenge/comments/ChallengeCommentsViewModel;", "getVm", "()Lapp/dogo/com/dogo_android/challenge/comments/ChallengeCommentsViewModel;", "vm$delegate", "createCommentBarManager", "Lapp/dogo/com/dogo_android/util/interfaces/CommentBarManager;", "getFragmentTag", "Lapp/dogo/com/dogo_android/enums/TagGlue;", "getScreenViewDescriptor", "Lapp/dogo/com/dogo_android/tracking/Screen;", "getTitle", "", "getTopBarBinding", "Lapp/dogo/com/dogo_android/databinding/LayoutTopBarBinding;", "getViewModelClass", "Ljava/lang/Class;", "Lapp/dogo/com/dogo_android/util/base_classes/BaseViewModel;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "onPause", "onResume", "onStop", "onViewCreated", "view", "setupCommentListData", "setupObservers", "setupRecyclerView", "recycleView", "Landroidx/recyclerview/widget/RecyclerView;", "showDeleteCommentDialog", "model", "Lapp/dogo/com/dogo_android/model/ChallengeComment;", "position", "", "showDeleteEntryDialog", "Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentCaptionItem;", "showReportDialog", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class v extends x {

    public static final app.dogo.com.dogo_android.d.b.v.a Companion;
    private final h A;
    private app.dogo.com.dogo_android.d.b.w B;
    private LinearLayoutManager C;
    private final h y;
    private e8 z;

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005", d2 = {"Lapp/dogo/com/dogo_android/challenge/comments/ChallengeCommentsDialog$Companion;", "", "()V", "COMMENT_DOG_PROFILE_SELECT", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/challenge/comments/ChallengeCommentsDialog$setupRecyclerView$1", "Lapp/dogo/com/dogo_android/util/recycle_views/EndlessRecyclerOnScrollListener;", "onLoadMore", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends k {

        final app.dogo.com.dogo_android.d.b.v d;
        c(app.dogo.com.dogo_android.d.b.v v) {
            this.d = v;
            super(20);
        }

        @Override // app.dogo.com.dogo_android.util.n0.k
        public void a() {
            v.e2(this.d).K0();
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class d extends p implements l<String, w> {

        final app.dogo.com.dogo_android.d.b.v this$0;
        d(app.dogo.com.dogo_android.d.b.v v) {
            this.this$0 = v;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(String string) {
            boolean obj2;
            n.f(string, "it");
            if (!v.e2(this.this$0).k0()) {
                obj2 = this.this$0.G1();
                if (obj2 == null) {
                } else {
                    obj2.onBackPressed();
                }
            }
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((String)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements a<w> {

        final f<?> $item;
        final int $position;
        final app.dogo.com.dogo_android.d.b.v this$0;
        e(app.dogo.com.dogo_android.d.b.v v, f<?> f2, int i3) {
            this.this$0 = v;
            this.$item = f2;
            this.$position = i3;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            v.g2(this.this$0, (k)this.$item.g(), this.$position);
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class f extends p implements a<w> {

        final f<?> $item;
        final int $position;
        final app.dogo.com.dogo_android.d.b.v this$0;
        f(app.dogo.com.dogo_android.d.b.v v, f<?> f2, int i3) {
            this.this$0 = v;
            this.$item = f2;
            this.$position = i3;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            invoke();
            return w.a;
        }

        @Override // kotlin.d0.d.p
        public final void invoke() {
            v.f2(this.this$0, (k)this.$item.g(), this.$position);
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends p implements l<String, w> {

        final f<?> $item;
        final int $position;
        final app.dogo.com.dogo_android.d.b.v this$0;
        g(app.dogo.com.dogo_android.d.b.v v, f<?> f2, int i3) {
            this.this$0 = v;
            this.$item = f2;
            this.$position = i3;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(String string) {
            String $position;
            boolean obj2;
            n.f(string, "it");
            if (!v.e2(this.this$0).k0() && !v.e2(this.this$0).n0((k)this.$item.g())) {
                if (!v.e2(this.this$0).n0((k)this.$item.g())) {
                    obj2 = v.c2(this.this$0);
                    if (obj2 == null) {
                    } else {
                        obj2.removeItem(this.$position);
                    }
                }
            }
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((String)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class h extends p implements a<w> {

        final ChallengeComment $model;
        final int $position;
        final app.dogo.com.dogo_android.d.b.v this$0;
        h(ChallengeComment challengeComment, app.dogo.com.dogo_android.d.b.v v2, int i3) {
            this.$model = challengeComment;
            this.this$0 = v2;
            this.$position = i3;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final w a() {
            Object this$0;
            w i;
            ChallengeComment $model;
            String tag;
            i = 0;
            if (this.$model.getDocumentId() == null) {
                this.this$0.Z1(2131886123);
                i = w.a;
            } else {
                v.e2(this.this$0).M0(this.$model, this.this$0.D1().getTag());
                if (v.e2(this.this$0).U0(this.$model)) {
                    this$0 = v.c2(this.this$0);
                    if (this$0 == null) {
                    } else {
                        this$0.removeItem(this.$position);
                        i = w.a;
                    }
                } else {
                    this$0 = v.c2(this.this$0);
                    if (this$0 == null) {
                    } else {
                        this$0.j2(this.$position);
                        i = w.a;
                    }
                }
            }
            return i;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class i extends p implements a<w> {

        final i $model;
        final app.dogo.com.dogo_android.d.b.v this$0;
        i(app.dogo.com.dogo_android.d.b.v v, i i2) {
            this.this$0 = v;
            this.$model = i2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final w a() {
            boolean z;
            w wVar;
            int model;
            if (v.e2(this.this$0).J(this.$model.getModel(), this.$model.h())) {
                z = this.this$0.G1();
                if (z == null) {
                } else {
                    z.onBackPressed();
                }
            }
            app.dogo.com.dogo_android.d.b.w wVar2 = v.c2(this.this$0);
            if (wVar2 == null) {
                wVar = 0;
            } else {
                wVar2.notifyItemChanged(0);
                wVar = w.a;
            }
            return wVar;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class j extends p implements l<String, w> {

        final ChallengeComment $model;
        final int $position;
        final app.dogo.com.dogo_android.d.b.v this$0;
        j(app.dogo.com.dogo_android.d.b.v v, ChallengeComment challengeComment2, int i3) {
            this.this$0 = v;
            this.$model = challengeComment2;
            this.$position = i3;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(String string) {
            String $position;
            boolean obj2;
            n.f(string, "it");
            if (!v.e2(this.this$0).k0() && !v.e2(this.this$0).n0(this.$model)) {
                if (!v.e2(this.this$0).n0(this.$model)) {
                    obj2 = v.c2(this.this$0);
                    if (obj2 == null) {
                    } else {
                        obj2.removeItem(this.$position);
                    }
                }
            }
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object) {
            a((String)object);
            return w.a;
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class k extends p implements a<l> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public k(Fragment fragment, a a2, a a3) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(l.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class l extends p implements a<app.dogo.com.dogo_android.d.b.x> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public l(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.d.b.x invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(x.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\u0008\u0010\u0004\u001a\u00020\u0005H\u0016J\u0008\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0016J\u0008\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u000e", d2 = {"app/dogo/com/dogo_android/challenge/comments/ChallengeCommentsDialog$createCommentBarManager$1", "Lapp/dogo/com/dogo_android/util/interfaces/CommentBarManager;", "getUserDogIcon", "Landroid/net/Uri;", "isUserPremiumBadgeVisible", "", "onAvatarClick", "", "onSendActionListener", "string", "", "replyTarget", "Lapp/dogo/com/dogo_android/model/ChallengeComment;", "permissionCheck", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends d {

        final app.dogo.com.dogo_android.d.b.v a;
        b(app.dogo.com.dogo_android.d.b.v v) {
            this.a = v;
            super();
        }

        @Override // app.dogo.com.dogo_android.util.k0.d
        public Uri getUserDogIcon() {
            return v.e2(this.a).h0();
        }

        @Override // app.dogo.com.dogo_android.util.k0.d
        public boolean isUserPremiumBadgeVisible() {
            return v.e2(this.a).s0();
        }

        @Override // app.dogo.com.dogo_android.util.k0.d
        public void onAvatarClick() {
            a0 a0Var;
            String str;
            String str2;
            if (v.e2(this.a).W() > 0) {
                a0Var = this.a.G1();
                if (a0Var == null) {
                } else {
                    a0Var.l0("comment_dog_select", "challenges_entry_comments");
                }
            } else {
                a0Var = this.a.G1();
                if (a0Var == null) {
                } else {
                    a0Var.w0(v.e2(this.a).X(), 11100);
                }
            }
        }

        @Override // app.dogo.com.dogo_android.util.k0.d
        public void onSendActionListener(String string, ChallengeComment challengeComment2) {
            androidx.fragment.app.e activity;
            int i2;
            String str;
            int i;
            int i3;
            int i4;
            Object obj7;
            String obj8;
            n.f(string, "string");
            if (v.e2(this.a).m0()) {
                obj7 = this.a.G1();
                if (obj7 == null) {
                } else {
                    obj7.w0(v.e2(this.a).X(), 11100);
                }
                this.a.Z1(2131886415);
            } else {
                if (!v.e2(this.a).isUserSignedIn()) {
                    activity = this.a.getActivity();
                    if (activity == null) {
                    } else {
                        g1.H(activity, 0, "challenges_entry_comments", 0, 5, 0);
                    }
                } else {
                    v.e2(this.a).N0(string, challengeComment2);
                    clearCommentField();
                    obj7 = v.d2(this.a);
                    if (obj7 == null) {
                    } else {
                        obj7.P.q1(1);
                    }
                }
            }
            n.w("binding");
            throw 0;
        }

        @Override // app.dogo.com.dogo_android.util.k0.d
        public boolean permissionCheck() {
            boolean z;
            int i;
            if (v.e2(this.a).o0() && v.e2(this.a).r0()) {
                i = v.e2(this.a).r0() ? 1 : 0;
            } else {
            }
            return i;
        }
    }
    static {
        v.a aVar = new v.a(0);
        v.Companion = aVar;
    }

    public v() {
        super();
        final int i = 0;
        v.k kVar = new v.k(this, i, i);
        this.y = j.a(m.NONE, kVar);
        v.l lVar = new v.l(this, i, i);
        this.A = j.a(m.SYNCHRONIZED, lVar);
    }

    private static final void A2(app.dogo.com.dogo_android.d.b.v v, y y2) {
        app.dogo.com.dogo_android.d.b.x xVar;
        Object obj2;
        int obj3;
        n.f(v, "this$0");
        n.e(y2, "it");
        final int i = 0;
        if (obj3 instanceof DogProfile != null) {
        } else {
            obj3 = i;
        }
        if (obj3 == null) {
        } else {
            v.i2().W0(obj3.getId());
            obj2 = v.z;
            if (obj2 == null) {
            } else {
                obj2 = obj2.O.T();
                if (obj2 == null) {
                } else {
                    obj2.updateDogAvatar();
                }
            }
        }
        n.w("binding");
        throw i;
    }

    private static final void B2(app.dogo.com.dogo_android.d.b.v v, Boolean boolean2) {
        int itemCount;
        String obj2;
        n.f(v, "this$0");
        final app.dogo.com.dogo_android.d.b.w obj1 = v.B;
        if (obj1 == null) {
        } else {
            obj2 = 0;
            if (obj1 == null) {
                itemCount = obj2;
            } else {
                itemCount = obj1.getItemCount();
            }
            obj1.notifyItemRangeChanged(obj2, itemCount);
        }
    }

    private final void C2(RecyclerView recyclerView) {
        Object next;
        k kVar;
        int i2;
        int i;
        int i3;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = i2().S().iterator();
        for (ChallengeComment next : iterator) {
            kVar = new k(next, 0, 2, 0);
            arrayList.add(kVar);
        }
        w wVar2 = new w(arrayList, D1(), i2().s0());
        this.B = wVar2;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.C = linearLayoutManager;
        recyclerView.setAdapter(this.B);
        recyclerView.setLayoutManager(this.C);
        recyclerView.q1(i2().b0());
        v.c cVar = new v.c(this);
        recyclerView.l(cVar);
        final app.dogo.com.dogo_android.d.b.w obj8 = this.B;
        n.d(obj8);
        i iVar = new i(this);
        obj8.a0(iVar);
    }

    private static final boolean D2(app.dogo.com.dogo_android.d.b.v v, View view2, int i3) {
        Object obj;
        int dogProfileModel;
        Object badges2;
        boolean requireActivity;
        boolean z2;
        int activity;
        int editText;
        int bundle;
        int documentId2;
        int i14;
        int z;
        int i2;
        int badges;
        Object gVar;
        int documentId;
        int eVar;
        int i12;
        int i8;
        int valueOf2;
        int valueOf;
        int challengeId;
        int dogProfileModel2;
        Object requireActivity2;
        String cHALLENGE_DETAILS_DIALOG;
        String dogAvatarUrl;
        int i11;
        int i4;
        int i13;
        int i6;
        int dogId2;
        String dogId;
        int i7;
        int i9;
        int i;
        int i5;
        int i10;
        obj = v;
        dogProfileModel = i3;
        n.f(obj, "this$0");
        n.f(view2, "view");
        app.dogo.com.dogo_android.d.b.w wVar = obj.B;
        n.d(wVar);
        badges2 = wVar.O0(dogProfileModel);
        gVar = "requireActivity()";
        final int i15 = 2131362981;
        final int i16 = 0;
        f fVar5 = badges2;
        if (badges2 instanceof i && view2.getId() == 2131362404 && v.i2().M((i)fVar5.getModel(), fVar5.g())) {
            if (view2.getId() == 2131362404) {
                fVar5 = badges2;
                if (v.i2().M((i)fVar5.getModel(), fVar5.g())) {
                    i14 = obj.B;
                    n.d(i14);
                    i14.notifyItemChanged(dogProfileModel, 100);
                }
            }
            f fVar3 = badges2;
            if (view2.getId() == 2131362724 && v.i2().N((i)fVar3.getModel(), fVar3.g())) {
                fVar3 = badges2;
                if (v.i2().N((i)fVar3.getModel(), fVar3.g())) {
                    z = obj.B;
                    n.d(z);
                    z.notifyItemChanged(dogProfileModel, Integer.valueOf(i16));
                }
            }
            if (view2.getId() == 2131363557) {
                i2 = v.G1();
                if (i2 == null) {
                } else {
                    f fVar4 = badges2;
                    i2.o0((i)fVar4.getModel().getDocumentId(), fVar4.getModel().getChallengeId());
                }
            }
            if (view2.getId() != 2131362149) {
                if (view2.getId() == i15) {
                    badges = badges2;
                    dogId = (i)badges.getModel().getDogId();
                    if (dogId == null) {
                    } else {
                        super(badges.getModel().getDogName(), badges.getModel().getDogAvatarUrl(), 0, 0, 0, 0, 0, dogId, 0, 0, 0, 1916, 0);
                        requireActivity2 = v.G1();
                        if (requireActivity2 == null) {
                        } else {
                            requireActivity2.f0(dogProfileModel2, badges.getModel().getBadges());
                        }
                    }
                }
            } else {
            }
            if (view2.getId() == 2131363063) {
                documentId = badges2;
                if (v.i2().q0((i)documentId.getModel())) {
                    obj.F2(documentId);
                } else {
                    App.Companion.r().c(u.B);
                    requireActivity = v.requireActivity();
                    n.e(requireActivity, gVar);
                    requireActivity2 = new v.d(obj);
                    g1.Y(requireActivity, documentId.getModel().getDocumentId(), requireActivity2);
                }
            }
        }
        if (badges2 instanceof k && view2.getId() == 2131362294) {
            if (view2.getId() == 2131362294) {
                eVar = badges2;
                if (v.i2().n0((k)eVar.g()) && !v.i2().l0(eVar.g())) {
                    if (!v.i2().l0(eVar.g())) {
                        activity = v.getActivity();
                        if (activity == null) {
                        } else {
                            eVar = new v.e(obj, badges2, dogProfileModel);
                            requireActivity2 = new v.f(obj, badges2, dogProfileModel);
                            f1.J(activity, eVar, requireActivity2);
                        }
                    } else {
                        obj.E2(eVar.g(), dogProfileModel);
                    }
                } else {
                }
            }
            if (view2.getId() == 2131363058) {
                e8 e8Var = obj.z;
                i12 = 0;
                requireActivity2 = "binding";
                if (e8Var == null) {
                } else {
                    d dVar = e8Var.O.T();
                    n.d(dVar);
                    dVar.addReplyTag((k)badges2.g());
                    e8 e8Var2 = obj.z;
                    if (e8Var2 == null) {
                    } else {
                        obj.Y1(ciVar2.Q);
                    }
                    n.w(requireActivity2);
                    throw i12;
                }
                n.w(requireActivity2);
                throw i12;
            }
            requireActivity2 = 1;
            if (view2.getId() == 2131362217 && (k)badges2.g().isSpam()) {
                if ((k)badges2.g().isSpam()) {
                    bundle = new Bundle();
                    bundle.putParcelable("challenge", v.i2().T());
                    bundle.putBoolean("show_rules", requireActivity2);
                    bundle.putBoolean("hide_participate_button", requireActivity2);
                    bundle.putInt("style", 2131951968);
                    i8 = v.G1();
                    if (i8 == null) {
                    } else {
                        i8.k(c.CHALLENGE_DETAILS_DIALOG, bundle);
                    }
                }
            }
            if (view2.getId() == 2131363061) {
                f fVar2 = badges2;
                documentId = (k)fVar2.g().getEntryId();
                documentId2 = fVar2.g().getDocumentId();
                if (documentId != null) {
                    if (l.z(documentId)) {
                        cHALLENGE_DETAILS_DIALOG = requireActivity2;
                    } else {
                        cHALLENGE_DETAILS_DIALOG = i16;
                    }
                } else {
                }
                if (cHALLENGE_DETAILS_DIALOG == 0 && documentId2 != null) {
                    if (documentId2 != null) {
                        if (l.z(documentId2)) {
                        } else {
                            requireActivity2 = i16;
                        }
                    }
                    if (requireActivity2 == 0) {
                        App.Companion.r().c(u.B);
                        requireActivity2 = v.requireActivity();
                        n.e(requireActivity2, gVar);
                        gVar = new v.g(obj, badges2, dogProfileModel);
                        g1.T(requireActivity2, documentId, documentId2, gVar);
                    }
                }
            }
            if (view2.getId() == i15) {
                ChallengeComment challengeComment = (k)badges2.g();
                super(challengeComment.getDogName(), challengeComment.getDogAvatarUrl(), 0, 0, 0, 0, 0, challengeComment.getDogId(), 0, 0, 0, 1916, 0);
                obj = v.G1();
                if (obj == null) {
                } else {
                    obj.f0(dogProfileModel, badges2.g().getBadges());
                }
            }
        }
        return i16;
    }

    private final void E2(ChallengeComment challengeComment, int i2) {
        final androidx.fragment.app.e requireActivity = requireActivity();
        n.e(requireActivity, "requireActivity()");
        v.h hVar = new v.h(challengeComment, this, i2);
        f1.O(requireActivity, hVar);
    }

    private final void F2(i i) {
        final androidx.fragment.app.e requireActivity = requireActivity();
        n.e(requireActivity, "requireActivity()");
        v.i iVar = new v.i(this, i);
        f1.O(requireActivity, iVar);
    }

    private final void G2(ChallengeComment challengeComment, int i2) {
        int requireActivity;
        int jVar;
        int i;
        boolean z;
        final String entryId = challengeComment.getEntryId();
        final String documentId = challengeComment.getDocumentId();
        jVar = 1;
        if (entryId != null) {
            if (l.z(entryId)) {
                i = jVar;
            } else {
                i = requireActivity;
            }
        } else {
        }
        if (i == 0) {
            if (documentId != null) {
                if (l.z(documentId)) {
                    requireActivity = jVar;
                }
            } else {
            }
            if (requireActivity == null) {
                App.Companion.r().c(u.B);
                requireActivity = requireActivity();
                n.e(requireActivity, "requireActivity()");
                jVar = new v.j(this, challengeComment, i2);
                g1.T(requireActivity, entryId, documentId, jVar);
            }
        }
    }

    public static final app.dogo.com.dogo_android.d.b.w c2(app.dogo.com.dogo_android.d.b.v v) {
        return v.B;
    }

    public static final e8 d2(app.dogo.com.dogo_android.d.b.v v) {
        return v.z;
    }

    public static final app.dogo.com.dogo_android.d.b.x e2(app.dogo.com.dogo_android.d.b.v v) {
        return v.i2();
    }

    public static final void f2(app.dogo.com.dogo_android.d.b.v v, ChallengeComment challengeComment2, int i3) {
        v.E2(challengeComment2, i3);
    }

    public static final void g2(app.dogo.com.dogo_android.d.b.v v, ChallengeComment challengeComment2, int i3) {
        v.G2(challengeComment2, i3);
    }

    private final l getSharedViewModel() {
        return (l)this.y.getValue();
    }

    private final d h2() {
        v.b bVar = new v.b(this);
        return bVar;
    }

    private final app.dogo.com.dogo_android.d.b.x i2() {
        return (x)this.A.getValue();
    }

    public static void j2(app.dogo.com.dogo_android.d.b.v v, ChallengeEntryModel challengeEntryModel2, j j3) {
        v.v2(v, challengeEntryModel2, j3);
    }

    public static boolean k2(app.dogo.com.dogo_android.d.b.v v, View view2, int i3, KeyEvent keyEvent4) {
        return v.s2(v, view2, i3, keyEvent4);
    }

    public static void l2(app.dogo.com.dogo_android.d.b.v v, Boolean boolean2) {
        v.B2(v, boolean2);
    }

    public static void m2(app.dogo.com.dogo_android.d.b.v v, y y2) {
        v.t2(v, y2);
    }

    public static void n2(app.dogo.com.dogo_android.d.b.v v, String string2) {
        v.y2(v, string2);
    }

    public static void o2(app.dogo.com.dogo_android.d.b.v v, y y2) {
        v.A2(v, y2);
    }

    public static void p2(app.dogo.com.dogo_android.d.b.v v, List list2) {
        v.x2(v, list2);
    }

    public static void q2(app.dogo.com.dogo_android.d.b.v v, Boolean boolean2) {
        v.z2(v, boolean2);
    }

    public static boolean r2(app.dogo.com.dogo_android.d.b.v v, View view2, int i3) {
        return v.D2(v, view2, i3);
    }

    private static final boolean s2(app.dogo.com.dogo_android.d.b.v v, View view2, int i3, KeyEvent keyEvent4) {
        n.f(v, "this$0");
        if (i3 == 4) {
            e8 obj1 = v.z;
            final int obj2 = 0;
            final String obj3 = "binding";
            if (obj1 == null) {
            } else {
                obj1.S.requestFocus();
                e8 obj0 = v.z;
                if (obj0 == null) {
                } else {
                    obj0 = obj0.O.T();
                    n.d(obj0);
                    obj0.clearCommentField();
                    return 1;
                }
                n.w(obj3);
                throw obj2;
            }
            n.w(obj3);
            throw obj2;
        }
        return 0;
    }

    private static final void t2(app.dogo.com.dogo_android.d.b.v v, y y2) {
        boolean str;
        Object obj1;
        boolean obj2;
        n.f(v, "this$0");
        if (y2 instanceof y.a) {
            if (obj2 instanceof UnknownHostException != null) {
                obj1 = v.getActivity();
                if (obj1 == null) {
                } else {
                    g1.g0(obj1, 2131886953);
                }
            } else {
                v.Z1(2131886123);
                obj1 = v.G1();
                if (obj1 == null) {
                } else {
                    obj1.onBackPressed();
                }
            }
        } else {
            if (y2 instanceof y.c) {
                obj2 = v.z;
                if (obj2 == null) {
                } else {
                    obj2 = obj2.P;
                    n.e(obj2, "binding.recycleView");
                    v.C2(obj2);
                    v.w2();
                    v.u2();
                }
                n.w("binding");
                throw 0;
            }
        }
    }

    private final void u2() {
        app.dogo.com.dogo_android.model.ChallengeModel challengeModel;
        ChallengeEntryModel challengeEntryModel = i2().a0();
        app.dogo.com.dogo_android.d.b.w wVar = this.B;
        if (wVar == null) {
        } else {
            wVar.h2(challengeEntryModel, i2().T());
        }
        n.d(challengeEntryModel);
        final String challengeId = challengeEntryModel.getChallengeId();
        n.d(challengeId);
        a aVar = new a(this, challengeEntryModel);
        i2().Q0(challengeEntryModel.getDocumentId(), challengeId).addOnCompleteListener(aVar);
    }

    private static final void v2(app.dogo.com.dogo_android.d.b.v v, ChallengeEntryModel challengeEntryModel2, j j3) {
        long str;
        Object obj2;
        Object obj3;
        app.dogo.com.dogo_android.d.b.w obj4;
        n.f(v, "this$0");
        n.f(j3, "task");
        if (j3.isSuccessful()) {
            v.i2().G(v.i2().f0());
            v.i2().K0();
            obj4 = v.B;
            if (obj4 == null) {
            } else {
                obj4.n2(challengeEntryModel2, v.i2().T());
            }
        } else {
            v.Z1(2131886123);
            if (v.G1() != null) {
                obj2 = v.G1();
                if (obj2 == null) {
                } else {
                    obj2.onBackPressed();
                }
            }
        }
    }

    private final void w2() {
        androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
        String str = "viewLifecycleOwner";
        n.e(viewLifecycleOwner, str);
        g gVar = new g(this);
        i2().U().observe(viewLifecycleOwner, gVar);
        androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner2, str);
        e eVar = new e(this);
        i2().g0().observe(viewLifecycleOwner2, eVar);
        h hVar = new h(this);
        i2().Y().observe(getViewLifecycleOwner(), hVar);
        f fVar = new f(this);
        getSharedViewModel().E().observe(getViewLifecycleOwner(), fVar);
        c cVar = new c(this);
        i2().c0().observe(getViewLifecycleOwner(), cVar);
    }

    private static final void x2(app.dogo.com.dogo_android.d.b.v v, List list2) {
        Object str;
        int i;
        List list;
        Object obj2;
        List obj3;
        n.f(v, "this$0");
        LinearLayoutManager linearLayoutManager = v.C;
        n.d(linearLayoutManager);
        if (list2 != null && linearLayoutManager.r2() == 0) {
            linearLayoutManager = v.C;
            n.d(linearLayoutManager);
            if (linearLayoutManager.r2() == 0) {
                e8 e8Var = v.z;
                if (e8Var == null) {
                } else {
                    e8Var.P.q1(0);
                }
                n.w("binding");
                throw 0;
            }
            str = v.B;
            if (str == null) {
            } else {
                str.e2(list2, v.i2().d0());
            }
            if (obj3 ^= 1 != 0) {
                v.i2().V0();
            }
        }
    }

    private static final void y2(app.dogo.com.dogo_android.d.b.v v, String string2) {
        n.f(v, "this$0");
        n.f(string2, "commentId");
        final app.dogo.com.dogo_android.d.b.w obj1 = v.B;
        if (obj1 == null) {
        } else {
            obj1.m2(string2);
        }
    }

    private static final void z2(app.dogo.com.dogo_android.d.b.v v, Boolean boolean2) {
        Object obj1;
        n.f(v, "this$0");
        if (boolean2 != null) {
            obj1 = v.B;
            if (obj1 == null) {
            } else {
                obj1.i2();
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public q D1() {
        return j.CHALLENGE_COMMENTS_DIALOG;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public k3 H1() {
        return j3.J;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public String I1() {
        int i3;
        int i6;
        int i;
        int i4;
        int i2;
        int i5;
        String quantityString = getResources().getQuantityString(2131755009, 999);
        n.e(quantityString, "resources.getQuantityString(R.plurals.comments_title, 999)");
        String str2 = l.G(quantityString, "%d", "", false, 4, 0);
        int i10 = 1;
        length -= i10;
        int i11 = 0;
        i = i6;
        while (i6 <= i3) {
            if (i == 0) {
            } else {
            }
            i2 = i3;
            if (n.h(str2.charAt(i2), 32) <= 0) {
            } else {
            }
            i4 = i11;
            if (i != 0) {
                break;
            } else {
            }
            if (i4 == 0) {
                break;
            } else {
            }
            i3--;
            if (i4 == 0) {
            } else {
            }
            i6++;
            i = i10;
            i4 = i10;
            i2 = i6;
        }
        String string = str2.subSequence(i6, i3 += i10).toString();
        String str4 = "null cannot be cast to non-null type java.lang.String";
        Objects.requireNonNull(string, str4);
        String substring2 = string.substring(i11, i10);
        n.e(substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Locale default = Locale.getDefault();
        n.e(default, "getDefault()");
        Objects.requireNonNull(substring2, str4);
        String upperCase = substring2.toUpperCase(default);
        n.e(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        Objects.requireNonNull(string, str4);
        String substring = string.substring(i10);
        n.e(substring, "(this as java.lang.String).substring(startIndex)");
        return n.o(upperCase, substring);
    }

    public Class<? extends r> K1() {
        return r.class;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public cn b2() {
        e8 e8Var = this.z;
        if (e8Var == null) {
        } else {
            cn cnVar = e8Var.Q;
            n.e(cnVar, "binding.topBar");
            return cnVar;
        }
        n.w("binding");
        throw 0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        boolean obj2;
        n.f(layoutInflater, "inflater");
        obj2 = e8.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.z = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.W(i2());
            obj2 = this.z;
            if (obj2 == null) {
            } else {
                obj2.V(G1());
                i2().F0();
                obj2 = this.z;
                if (obj2 == null) {
                } else {
                    obj2.O.U(h2());
                    obj2 = this.z;
                    if (obj2 == null) {
                    } else {
                        b bVar = new b(this);
                        obj2.Q.setOnKeyListener(bVar);
                        obj2.w = D1();
                        if (!i2().O0(getArguments())) {
                            Z1(2131886123);
                            obj2 = G1();
                            if (obj2 == null) {
                            } else {
                                obj2.onBackPressed();
                            }
                        }
                        i2().G0();
                        obj2 = this.z;
                        if (obj2 == null) {
                        } else {
                            obj2 = obj2.w();
                            n.e(obj2, "binding.root");
                            return obj2;
                        }
                        n.w(obj4);
                        throw obj3;
                    }
                    n.w(obj4);
                    throw obj3;
                }
                n.w(obj4);
                throw obj3;
            }
            n.w(obj4);
            throw obj3;
        }
        n.w(obj4);
        throw obj3;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public void onDestroyView() {
        super.onDestroyView();
        this.B = 0;
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public void onPause() {
        super.onPause();
        i2().K();
        i2().L();
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public void onResume() {
        boolean z;
        super.onResume();
        i2().G(i2().f0());
        i2().I();
        if (i2().p0()) {
            z = G1();
            if (z == null) {
            } else {
                z.onBackPressed();
            }
        }
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public void onStop() {
        int i;
        super.onStop();
        LinearLayoutManager linearLayoutManager = this.C;
        if (linearLayoutManager == null) {
            i = 0;
        } else {
            i = linearLayoutManager.v2();
        }
        i2().P0(i);
    }

    @Override // app.dogo.com.dogo_android.util.e0.x
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        d dVar = new d(this);
        i2().Z().observe(getViewLifecycleOwner(), dVar);
    }
}
