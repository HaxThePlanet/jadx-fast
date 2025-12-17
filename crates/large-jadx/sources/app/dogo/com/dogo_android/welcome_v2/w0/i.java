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
import app.dogo.com.dogo_android.d.b.w;
import app.dogo.com.dogo_android.d.b.x;
import app.dogo.com.dogo_android.d.b.z.i;
import app.dogo.com.dogo_android.d.b.z.k;
import app.dogo.com.dogo_android.dogcreation.f;
import app.dogo.com.dogo_android.h.ci;
import app.dogo.com.dogo_android.h.cn;
import app.dogo.com.dogo_android.h.e8;
import app.dogo.com.dogo_android.k.j;
import app.dogo.com.dogo_android.model.ChallengeComment;
import app.dogo.com.dogo_android.model.ChallengeEntryModel;
import app.dogo.com.dogo_android.service.App;
import app.dogo.com.dogo_android.service.App.a;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.a;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.util.k0.d;
import app.dogo.com.dogo_android.util.k0.g;
import app.dogo.com.dogo_android.util.m0.a;
import app.dogo.com.dogo_android.util.n0.k;
import app.dogo.com.dogo_android.w.o3;
import app.dogo.com.dogo_android.w.u;
import com.google.android.gms.tasks.j;
import f.d.a.a;
import h.a.b.b;
import h.a.b.h.f;
import java.util.ArrayList;
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
import m.a.b.a.d.a.b;
import m.a.c.j.a;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\n\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u000e\n\u0002\u0008\u0002\u0018\u0000 ?2\u00020\u0001:\u0001?B\u0005¢\u0006\u0002\u0010\u0002J\u0008\u0010\u0017\u001a\u00020\u0018H\u0002J\u0008\u0010\u0019\u001a\u00020\u0010H\u0002J\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0008\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0008\u0010%\u001a\u0004\u0018\u00010&2\u0008\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0008\u0010)\u001a\u00020\u001bH\u0002J\u0008\u0010*\u001a\u00020\u001bH\u0016J\u0008\u0010+\u001a\u00020\u001bH\u0016J\u0008\u0010,\u001a\u00020\u001bH\u0016J\u001a\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020\"2\u0008\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0008\u0010/\u001a\u00020\u001bH\u0002J\u0008\u00100\u001a\u00020\u001bH\u0002J\u0010\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u000203H\u0002J\u0018\u00104\u001a\u00020\u001b2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u001dH\u0002J\u0010\u00108\u001a\u00020\u001b2\u0006\u00105\u001a\u000209H\u0002J\u0012\u0010:\u001a\u00020\u001b2\u0008\u0008\u0001\u0010;\u001a\u00020\u001dH\u0002J\u0018\u0010<\u001a\u00020\u001b2\u0008\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010\u001c\u001a\u00020\u001dR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0008X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u000b\u0010\u000cR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0015\u0010\u0016\u001a\u0004\u0008\u0013\u0010\u0014¨\u0006@", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/entrysharedeeplink/OnboardingChallengeEntryFragment;", "Landroidx/fragment/app/Fragment;", "()V", "adapter", "Lapp/dogo/com/dogo_android/challenge/comments/ChallengeCommentsListAdapter;", "binding", "Lapp/dogo/com/dogo_android/databinding/DialogChallengeCommentsBinding;", "linearLayoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "screenKey", "Lapp/dogo/com/dogo_android/welcome_v2/entrysharedeeplink/OnboardingChallengeEntryScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/welcome_v2/entrysharedeeplink/OnboardingChallengeEntryScreen;", "toast", "Landroid/widget/Toast;", "topBarManager", "Lapp/dogo/com/dogo_android/util/interfaces/TopBarManager;", "vm", "Lapp/dogo/com/dogo_android/challenge/comments/ChallengeCommentsViewModel;", "getVm", "()Lapp/dogo/com/dogo_android/challenge/comments/ChallengeCommentsViewModel;", "vm$delegate", "Lkotlin/Lazy;", "createCommentBarManager", "Lapp/dogo/com/dogo_android/util/interfaces/CommentBarManager;", "createTopBarManager", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onFailure", "onPause", "onResume", "onStop", "onViewCreated", "view", "setupCommentListData", "setupObservers", "setupRecyclerView", "recycleView", "Landroidx/recyclerview/widget/RecyclerView;", "showDeleteCommentDialog", "model", "Lapp/dogo/com/dogo_android/model/ChallengeComment;", "position", "showDeleteEntryDialog", "Lapp/dogo/com/dogo_android/challenge/comments/listitems/ChallengeCommentCaptionItem;", "showToast", "res", "startDogCreation", "dogId", "", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class i extends Fragment {

    public static final app.dogo.com.dogo_android.welcome_v2.w0.i.a Companion;
    private static final j y;
    private e8 a;
    private final h b;
    private w c;
    private LinearLayoutManager v;
    private g w;
    private Toast x;

    @Metadata(d1 = "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/entrysharedeeplink/OnboardingChallengeEntryFragment$Companion;", "", "()V", "LOAD_NEXT_PAGE_THRESHOLD", "", "fragmentTag", "Lapp/dogo/com/dogo_android/enums/FullScreenTag;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a {
        public a(g g) {
            super();
        }
    }

    @Metadata(d1 = "\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004", d2 = {"app/dogo/com/dogo_android/welcome_v2/entrysharedeeplink/OnboardingChallengeEntryFragment$setupRecyclerView$1", "Lapp/dogo/com/dogo_android/util/recycle_views/EndlessRecyclerOnScrollListener;", "onLoadMore", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d extends k {

        final app.dogo.com.dogo_android.welcome_v2.w0.i d;
        d(app.dogo.com.dogo_android.welcome_v2.w0.i i) {
            this.d = i;
            super(20);
        }

        @Override // app.dogo.com.dogo_android.util.n0.k
        public void a() {
            i.E1(this.d).K0();
        }
    }

    @Metadata(d1 = "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016J\u0008\u0010\u0004\u001a\u00020\u0005H\u0016J\u0008\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0008", d2 = {"app/dogo/com/dogo_android/welcome_v2/entrysharedeeplink/OnboardingChallengeEntryFragment$createTopBarManager$1", "Lapp/dogo/com/dogo_android/util/interfaces/TopBarManager;", "getTitle", "", "isBackVisible", "", "onBack", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c extends g {

        final app.dogo.com.dogo_android.welcome_v2.w0.i a;
        c(app.dogo.com.dogo_android.welcome_v2.w0.i i) {
            this.a = i;
            super();
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public String getTitle() {
            int i;
            int i3;
            int i2;
            int i5;
            int i6;
            int i4;
            String quantityString = this.a.getResources().getQuantityString(2131755009, 999);
            n.e(quantityString, "resources.getQuantityString(R.plurals.comments_title, 999)");
            String str2 = l.G(quantityString, "%d", "", false, 4, 0);
            int i10 = 1;
            length -= i10;
            int i11 = 0;
            i2 = i3;
            while (i3 <= i) {
                if (i2 == 0) {
                } else {
                }
                i6 = i;
                if (n.h(str2.charAt(i6), 32) <= 0) {
                } else {
                }
                i5 = i11;
                if (i2 != 0) {
                    break;
                } else {
                }
                if (i5 == 0) {
                    break;
                } else {
                }
                i--;
                if (i5 == 0) {
                } else {
                }
                i3++;
                i2 = i10;
                i5 = i10;
                i6 = i3;
            }
            String string = str2.subSequence(i3, i += i10).toString();
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

        @Override // app.dogo.com.dogo_android.util.k0.g
        public boolean isBackVisible() {
            return 1;
        }

        @Override // app.dogo.com.dogo_android.util.k0.g
        public void onBack() {
            androidx.fragment.app.e activity = this.a.getActivity();
            if (activity == null) {
            } else {
                activity.onBackPressed();
            }
        }
    }

    @Metadata(d1 = "\u0000\u000c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class e extends p implements l<String, w> {

        final f<?> $item;
        final int $position;
        final app.dogo.com.dogo_android.welcome_v2.w0.i this$0;
        e(app.dogo.com.dogo_android.welcome_v2.w0.i i, f<?> f2, int i3) {
            this.this$0 = i;
            this.$item = f2;
            this.$position = i3;
            super(1);
        }

        @Override // kotlin.d0.d.p
        public final void a(String string) {
            String $position;
            boolean obj2;
            n.f(string, "it");
            if (!i.E1(this.this$0).k0() && !i.E1(this.this$0).n0((k)this.$item.g())) {
                if (!i.E1(this.this$0).n0((k)this.$item.g())) {
                    obj2 = i.B1(this.this$0);
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
    static final class f extends p implements a<w> {

        final ChallengeComment $model;
        final int $position;
        final app.dogo.com.dogo_android.welcome_v2.w0.i this$0;
        f(ChallengeComment challengeComment, app.dogo.com.dogo_android.welcome_v2.w0.i i2, int i3) {
            this.$model = challengeComment;
            this.this$0 = i2;
            this.$position = i3;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final w a() {
            w wVar;
            String $position;
            String tag;
            if (this.$model.getDocumentId() == null) {
                i.F1(this.this$0, 2131886123);
                a.c("model.document id is null", new Object[0]);
                wVar = w.a;
            } else {
                i.E1(this.this$0).M0(this.$model, i.D1().getTag());
                w wVar2 = i.B1(this.this$0);
                if (wVar2 == null) {
                    wVar = 0;
                } else {
                    wVar2.removeItem(this.$position);
                    wVar = w.a;
                }
            }
            return wVar;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    @Metadata(d1 = "\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n", d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class g extends p implements a<w> {

        final i $model;
        final app.dogo.com.dogo_android.welcome_v2.w0.i this$0;
        g(app.dogo.com.dogo_android.welcome_v2.w0.i i, i i2) {
            this.this$0 = i;
            this.$model = i2;
            super(0);
        }

        @Override // kotlin.d0.d.p
        public final w a() {
            boolean activity;
            w wVar;
            int model;
            Integer valueOf;
            if (i.E1(this.this$0).J(this.$model.getModel(), this.$model.h())) {
                activity = this.this$0.getActivity();
                if (activity == null) {
                } else {
                    activity.onBackPressed();
                }
            }
            w wVar2 = i.B1(this.this$0);
            if (wVar2 == null) {
                wVar = 0;
            } else {
                model = 0;
                wVar2.notifyItemChanged(model, Integer.valueOf(model));
                wVar = w.a;
            }
            return wVar;
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return a();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class h extends p implements a<x> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public h(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final x invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(x.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }

    @Metadata(d1 = "\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\u0008\u0010\u0004\u001a\u00020\u0005H\u0016J\u0008\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\u0008\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0016J\u0008\u0010\r\u001a\u00020\u0005H\u0016¨\u0006\u000e", d2 = {"app/dogo/com/dogo_android/welcome_v2/entrysharedeeplink/OnboardingChallengeEntryFragment$createCommentBarManager$1", "Lapp/dogo/com/dogo_android/util/interfaces/CommentBarManager;", "getUserDogIcon", "Landroid/net/Uri;", "isUserPremiumBadgeVisible", "", "onAvatarClick", "", "onSendActionListener", "string", "", "replyTarget", "Lapp/dogo/com/dogo_android/model/ChallengeComment;", "permissionCheck", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends d {

        final app.dogo.com.dogo_android.welcome_v2.w0.i a;
        b(app.dogo.com.dogo_android.welcome_v2.w0.i i) {
            this.a = i;
            super();
        }

        @Override // app.dogo.com.dogo_android.util.k0.d
        public Uri getUserDogIcon() {
            return i.E1(this.a).h0();
        }

        @Override // app.dogo.com.dogo_android.util.k0.d
        public boolean isUserPremiumBadgeVisible() {
            return i.E1(this.a).s0();
        }

        @Override // app.dogo.com.dogo_android.util.k0.d
        public void onAvatarClick() {
        }

        @Override // app.dogo.com.dogo_android.util.k0.d
        public void onSendActionListener(String string, ChallengeComment challengeComment2) {
            androidx.fragment.app.e activity;
            int i4;
            String str;
            int i;
            int i2;
            int i3;
            Object obj7;
            ChallengeComment obj8;
            n.f(string, "string");
            if (i.E1(this.a).m0()) {
                obj7 = this.a;
                obj7.h2(i.E1(obj7).X(), 11101);
                i.F1(this.a, 2131886415);
            } else {
                if (!i.E1(this.a).isUserSignedIn()) {
                    activity = this.a.getActivity();
                    if (activity == null) {
                    } else {
                        g1.H(activity, 10002, "welcome", 0, 4, 0);
                    }
                } else {
                    i.E1(this.a).N0(string, challengeComment2);
                    obj7 = i.C1(this.a);
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
            if (i.E1(this.a).o0() && i.E1(this.a).r0()) {
                i = i.E1(this.a).r0() ? 1 : 0;
            } else {
            }
            return i;
        }
    }
    static {
        i.a aVar = new i.a(0);
        i.Companion = aVar;
        i.y = j.CHALLENGE_COMMENTS_DIALOG;
    }

    public i() {
        super();
        final int i = 0;
        i.h hVar2 = new i.h(this, i, i);
        this.b = j.a(m.SYNCHRONIZED, hVar2);
    }

    public static final w B1(app.dogo.com.dogo_android.welcome_v2.w0.i i) {
        return i.c;
    }

    public static final e8 C1(app.dogo.com.dogo_android.welcome_v2.w0.i i) {
        return i.a;
    }

    public static final j D1() {
        return i.y;
    }

    public static final x E1(app.dogo.com.dogo_android.welcome_v2.w0.i i) {
        return i.J1();
    }

    public static final void F1(app.dogo.com.dogo_android.welcome_v2.w0.i i, int i2) {
        i.g2(i2);
    }

    private final d G1() {
        i.b bVar = new i.b(this);
        return bVar;
    }

    private final g H1() {
        g cVar;
        if (this.w == null) {
            cVar = new i.c(this);
            this.w = cVar;
        }
        g gVar = this.w;
        n.d(gVar);
        return gVar;
    }

    private final app.dogo.com.dogo_android.welcome_v2.w0.j I1() {
        return (j)k1.a(this);
    }

    private final x J1() {
        return (x)this.b.getValue();
    }

    public static void K1(app.dogo.com.dogo_android.welcome_v2.w0.i i, Boolean boolean2) {
        i.b2(i, boolean2);
    }

    public static boolean L1(app.dogo.com.dogo_android.welcome_v2.w0.i i, View view2, int i3) {
        return i.d2(i, view2, i3);
    }

    public static void M1(app.dogo.com.dogo_android.welcome_v2.w0.i i, List list2) {
        i.Z1(i, list2);
    }

    public static void N1(app.dogo.com.dogo_android.welcome_v2.w0.i i, ChallengeEntryModel challengeEntryModel2, j j3) {
        i.W1(i, challengeEntryModel2, j3);
    }

    public static void O1(app.dogo.com.dogo_android.welcome_v2.w0.i i, y y2) {
        i.U1(i, y2);
    }

    public static boolean P1(app.dogo.com.dogo_android.welcome_v2.w0.i i, View view2, int i3, KeyEvent keyEvent4) {
        return i.S1(i, view2, i3, keyEvent4);
    }

    public static void Q1(app.dogo.com.dogo_android.welcome_v2.w0.i i, Boolean boolean2) {
        i.a2(i, boolean2);
    }

    public static void R1(app.dogo.com.dogo_android.welcome_v2.w0.i i, List list2) {
        i.Y1(i, list2);
    }

    private static final boolean S1(app.dogo.com.dogo_android.welcome_v2.w0.i i, View view2, int i3, KeyEvent keyEvent4) {
        n.f(i, "this$0");
        if (i3 == 4) {
            e8 obj1 = i.a;
            final int obj2 = 0;
            final String obj3 = "binding";
            if (obj1 == null) {
            } else {
                obj1.S.requestFocus();
                e8 obj0 = i.a;
                if (obj0 == null) {
                } else {
                    obj0 = obj0.O.T();
                    if (obj0 == null) {
                    } else {
                        obj0.clearCommentField();
                    }
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

    private final void T1() {
        g2(2131886123);
        androidx.fragment.app.e activity = getActivity();
        if (activity == null) {
        } else {
            activity.onBackPressed();
        }
    }

    private static final void U1(app.dogo.com.dogo_android.welcome_v2.w0.i i, y y2) {
        boolean str;
        Exception obj2;
        n.f(i, "this$0");
        if (y2 instanceof y.a) {
            a.d((y.a)y2.a());
            i.T1();
        } else {
            if (y2 instanceof y.c) {
                obj2 = i.a;
                if (obj2 == null) {
                } else {
                    obj2 = obj2.P;
                    n.e(obj2, "binding.recycleView");
                    i.c2(obj2);
                    i.X1();
                    i.V1();
                }
                n.w("binding");
                throw 0;
            }
        }
    }

    private final void V1() {
        app.dogo.com.dogo_android.model.ChallengeModel challengeModel;
        ChallengeEntryModel challengeEntryModel = J1().a0();
        w wVar = this.c;
        if (wVar == null) {
        } else {
            wVar.h2(challengeEntryModel, J1().T());
        }
        n.d(challengeEntryModel);
        final String challengeId = challengeEntryModel.getChallengeId();
        n.d(challengeId);
        d dVar = new d(this, challengeEntryModel);
        J1().Q0(challengeEntryModel.getDocumentId(), challengeId).addOnCompleteListener(dVar);
    }

    private static final void W1(app.dogo.com.dogo_android.welcome_v2.w0.i i, ChallengeEntryModel challengeEntryModel2, j j3) {
        long str;
        Object obj2;
        ChallengeEntryModel obj3;
        w obj4;
        n.f(i, "this$0");
        n.f(j3, "task");
        if (j3.isSuccessful()) {
            i.J1().G(i.J1().f0());
            i.J1().K0();
            obj4 = i.c;
            if (obj4 == null) {
            } else {
                obj4.n2(challengeEntryModel2, i.J1().T());
            }
        } else {
            i.g2(2131886123);
            obj2 = i.getActivity();
            if (obj2 == null) {
            } else {
                obj2.onBackPressed();
            }
        }
    }

    private final void X1() {
        androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
        String str = "viewLifecycleOwner";
        n.e(viewLifecycleOwner, str);
        h hVar = new h(this);
        J1().U().observe(viewLifecycleOwner, hVar);
        androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
        n.e(viewLifecycleOwner2, str);
        c cVar = new c(this);
        J1().e0().observe(viewLifecycleOwner2, cVar);
        g gVar = new g(this);
        J1().Y().observe(getViewLifecycleOwner(), gVar);
        a aVar3 = new a(this);
        J1().c0().observe(getViewLifecycleOwner(), aVar3);
    }

    private static final void Y1(app.dogo.com.dogo_android.welcome_v2.w0.i i, List list2) {
        int i2;
        Object str;
        int i3;
        Object obj2;
        n.f(i, "this$0");
        LinearLayoutManager linearLayoutManager = i.v;
        n.d(linearLayoutManager);
        if (list2 != null && linearLayoutManager.r2() == 0) {
            linearLayoutManager = i.v;
            n.d(linearLayoutManager);
            if (linearLayoutManager.r2() == 0) {
                e8 e8Var = i.a;
                if (e8Var == null) {
                } else {
                    e8Var.P.q1(0);
                }
                n.w("binding");
                throw 0;
            }
            str = i.c;
            if (str == null) {
            } else {
                str.e2(list2, i.J1().d0());
            }
        }
    }

    private static final void Z1(app.dogo.com.dogo_android.welcome_v2.w0.i i, List list2) {
        String str;
        Object obj1;
        LinearLayoutManager obj2;
        n.f(i, "this$0");
        if (list2 != null) {
            w wVar = i.c;
            if (wVar == null) {
            } else {
                wVar.g2(list2);
            }
            obj2 = i.v;
            str = 0;
            if (obj2 == null) {
                obj2 = str;
            } else {
            }
            if (obj2 != null) {
                obj2 = i.a;
                if (obj2 == null) {
                } else {
                    obj2.P.q1(str);
                }
                n.w("binding");
                throw 0;
            }
            obj1 = i.c;
            if (obj1 == null) {
            } else {
                obj1.k2();
            }
        }
    }

    private static final void a2(app.dogo.com.dogo_android.welcome_v2.w0.i i, Boolean boolean2) {
        Object obj1;
        n.f(i, "this$0");
        if (boolean2 != null) {
            obj1 = i.c;
            if (obj1 == null) {
            } else {
                obj1.i2();
            }
        }
    }

    private static final void b2(app.dogo.com.dogo_android.welcome_v2.w0.i i, Boolean boolean2) {
        int itemCount;
        String obj2;
        n.f(i, "this$0");
        final w obj1 = i.c;
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

    private final void c2(RecyclerView recyclerView) {
        Object dVar;
        Object next;
        k kVar;
        int i;
        int i2;
        int i3;
        ArrayList arrayList = new ArrayList();
        Iterator iterator = J1().S().iterator();
        for (ChallengeComment next : iterator) {
            kVar = new k(next, 0, 2, 0);
            arrayList.add(kVar);
        }
        w wVar2 = new w(arrayList, i.y, J1().s0());
        this.c = wVar2;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.v = linearLayoutManager;
        recyclerView.setAdapter(this.c);
        recyclerView.setLayoutManager(this.v);
        recyclerView.q1(J1().b0());
        dVar = new i.d(this);
        recyclerView.l(dVar);
        final w obj8 = this.c;
        if (obj8 == null) {
        } else {
            dVar = new b(this);
            obj8.a0(dVar);
        }
    }

    private static final boolean d2(app.dogo.com.dogo_android.welcome_v2.w0.i i, View view2, int i3) {
        f fVar;
        int entryId;
        int i2;
        int i5;
        boolean z;
        boolean requireActivity;
        int i4;
        int eVar;
        int valueOf;
        int valueOf2;
        int str;
        ChallengeEntryModel model;
        Object obj8;
        n.f(i, "this$0");
        n.f(view2, "view");
        w wVar = i.c;
        entryId = 0;
        if (wVar == null) {
            fVar = entryId;
        } else {
            fVar = wVar.O0(i3);
        }
        eVar = 1;
        final int i6 = 0;
        f fVar4 = fVar;
        if (fVar instanceof i && view2.getId() == 2131362404 && i.J1().M((i)fVar4.getModel(), fVar4.g())) {
            if (view2.getId() == 2131362404) {
                fVar4 = fVar;
                if (i.J1().M((i)fVar4.getModel(), fVar4.g())) {
                    i2 = i.c;
                    if (i2 == null) {
                    } else {
                        i2.notifyItemChanged(i3, 100);
                    }
                }
            }
            f fVar3 = fVar;
            if (view2.getId() == 2131362724 && i.J1().N((i)fVar3.getModel(), fVar3.g())) {
                fVar3 = fVar;
                if (i.J1().N((i)fVar3.getModel(), fVar3.g())) {
                    i5 = i.c;
                    if (i5 == null) {
                    } else {
                        i5.notifyItemChanged(i3, Integer.valueOf(i6));
                    }
                }
            }
            if (view2.getId() == 2131363063) {
                str = fVar;
                if (i.J1().q0((i)str.getModel())) {
                    i.f2(str);
                } else {
                    if (z2 ^= eVar != 0) {
                        App.Companion.r().c(u.B);
                    }
                }
            }
        }
        if (fVar instanceof k && view2.getId() == 2131362294) {
            if (view2.getId() == 2131362294) {
                i.e2((k)fVar.g(), i3);
            }
            if (view2.getId() == 2131363058) {
                e8 e8Var = i.a;
                str = "binding";
                if (e8Var == null) {
                } else {
                    d dVar = e8Var.O.T();
                    if (dVar == null) {
                    } else {
                        dVar.addReplyTag((k)fVar.g());
                    }
                    e8 e8Var2 = i.a;
                    if (e8Var2 == null) {
                    } else {
                        entryId = ciVar.Q;
                        n.e(entryId, "binding.commentView.commentField");
                        k1.g(i, entryId);
                    }
                    n.w(str);
                    throw entryId;
                }
                n.w(str);
                throw entryId;
            }
            if (view2.getId() == 2131363061) {
                obj8 = fVar;
                entryId = (k)obj8.g().getEntryId();
                obj8 = obj8.g().getDocumentId();
                if (entryId != null) {
                    if (l.z(entryId)) {
                        requireActivity = eVar;
                    } else {
                        requireActivity = i6;
                    }
                } else {
                }
                if (requireActivity == null && obj8 != null) {
                    if (obj8 != null) {
                        if (l.z(obj8)) {
                        } else {
                            eVar = i6;
                        }
                    }
                    if (eVar == 0) {
                        App.Companion.r().c(u.B);
                        requireActivity = i.requireActivity();
                        n.e(requireActivity, "requireActivity()");
                        eVar = new i.e(i, fVar, i3);
                        g1.T(requireActivity, entryId, obj8, eVar);
                    }
                }
            }
        }
        return i6;
    }

    private final void e2(ChallengeComment challengeComment, int i2) {
        final androidx.fragment.app.e requireActivity = requireActivity();
        n.e(requireActivity, "requireActivity()");
        i.f fVar = new i.f(challengeComment, this, i2);
        f1.O(requireActivity, fVar);
    }

    private final void f2(i i) {
        final androidx.fragment.app.e requireActivity = requireActivity();
        n.e(requireActivity, "requireActivity()");
        i.g gVar = new i.g(this, i);
        f1.O(requireActivity, gVar);
    }

    private final void g2(int i) {
        Toast toast = this.x;
        if (toast == null) {
        } else {
            toast.cancel();
        }
        final Toast obj3 = Toast.makeText(getContext(), i, 1);
        this.x = obj3;
        if (obj3 == null) {
        } else {
            obj3.show();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void h2(String string, int i2) {
        super(string, 0, 0, 0, 14, 0);
        android.content.Context obj9 = requireContext();
        n.e(obj9, "requireContext()");
        startActivityForResult(fVar2.buildIntent(obj9), i2);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent3) {
        x obj1;
        int obj2;
        super.onActivityResult(i, i2, intent3);
        if (i != 11100 && i != 11101) {
            if (i != 11101) {
            } else {
                J1().F0();
            }
        } else {
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        e8 obj3 = e8.T(layoutInflater, viewGroup2, false);
        n.e(obj3, "inflate(inflater, container, false)");
        this.a = obj3;
        J1().F0();
        obj3 = this.a;
        int obj4 = 0;
        String obj5 = "binding";
        if (obj3 == null) {
        } else {
            obj3.O.U(G1());
            obj3 = this.a;
            if (obj3 == null) {
            } else {
                obj3.Q.U(H1());
                obj3 = this.a;
                if (obj3 == null) {
                } else {
                    f fVar = new f(this);
                    obj3.Q.setOnKeyListener(fVar);
                    obj3.w = i.y;
                    obj3 = new Bundle();
                    obj3.putString("entryId", I1().b());
                    obj3.putString("challengeId", I1().a());
                    obj3.putString("linkType", I1().c());
                    if (!J1().O0(obj3)) {
                        T1();
                    }
                    J1().G0();
                    obj3 = this.a;
                    if (obj3 == null) {
                    } else {
                        obj3 = obj3.w();
                        n.e(obj3, "binding.root");
                        return obj3;
                    }
                    n.w(obj5);
                    throw obj4;
                }
                n.w(obj5);
                throw obj4;
            }
            n.w(obj5);
            throw obj4;
        }
        n.w(obj5);
        throw obj4;
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
        int i;
        super.onStop();
        LinearLayoutManager linearLayoutManager = this.v;
        if (linearLayoutManager == null) {
            i = 0;
        } else {
            i = linearLayoutManager.v2();
        }
        J1().P0(i);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        e eVar = new e(this);
        J1().Z().observe(getViewLifecycleOwner(), eVar);
    }
}
