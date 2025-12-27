package app.dogo.com.dogo_android.n;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.j0;
import androidx.lifecycle.y;
import app.dogo.com.dogo_android.h.el;
import app.dogo.com.dogo_android.h.ud;
import app.dogo.com.dogo_android.n.m.n.a;
import app.dogo.com.dogo_android.repository.domain.Article;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.Library;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem;
import app.dogo.com.dogo_android.repository.domain.ProgramDescriptionItem.State;
import app.dogo.com.dogo_android.repository.domain.ProgramExamSummary;
import app.dogo.com.dogo_android.repository.domain.ProgramSaveInfo;
import app.dogo.com.dogo_android.repository.domain.TrickItem;
import app.dogo.com.dogo_android.repository.domain.TrickItem.TrickCategory;
import app.dogo.com.dogo_android.service.q2.a;
import app.dogo.com.dogo_android.util.e0.a0;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.h0.f1;
import app.dogo.com.dogo_android.util.h0.g1;
import app.dogo.com.dogo_android.util.h0.k1;
import app.dogo.com.dogo_android.y.n.i;
import app.dogo.com.dogo_android.y.o.s;
import app.dogo.com.dogo_android.y.o.w;
import app.dogo.com.dogo_android.y.s.k;
import app.dogo.com.dogo_android.y.y.g;
import app.dogo.com.dogo_android.y.z.f;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.d0.d.c0;
import kotlin.h;
import m.a.b.a.d.a.b;

/* compiled from: LibraryFragment.kt */
@Metadata(d1 = "\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0008\u0010\u001b\u001a\u00020\u0016H\u0002J\u0008\u0010\u001c\u001a\u00020\u0016H\u0016J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"H\u0016J$\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0008\u0010'\u001a\u0004\u0018\u00010(2\u0008\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0008\u0010+\u001a\u00020\u0016H\u0016J\u0010\u0010,\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010-\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"H\u0016J\u0008\u0010.\u001a\u00020\u0016H\u0016J\u0018\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0016J\u0010\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u000205H\u0016J\u001a\u00106\u001a\u00020\u00162\u0006\u00107\u001a\u00020$2\u0008\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u00108\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"H\u0002J\u0008\u00109\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u000f\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006:", d2 = {"Lapp/dogo/com/dogo_android/library/LibraryFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/library/LibraryCallback$Callback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentLibraryBinding;", "screenKey", "Lapp/dogo/com/dogo_android/library/LibraryScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/library/LibraryScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/library/LibraryViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/library/LibraryViewModel;", "viewModel$delegate", "handleDestinationScreens", "", "destination", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "library", "Lapp/dogo/com/dogo_android/repository/domain/Library;", "loadNextAppScreenAfterResultIfRequested", "onArticleListSelected", "onArticleSelected", "article", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "onComingSoonItemSelect", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onProgramListSelected", "onProgramSelected", "onRecommendedProgramSelected", "onSubscriptionSelected", "onTrickListSelected", "categoryId", "", "categoryName", "onTrickSelected", "trick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "onViewCreated", "view", "openProgram", "removeDestinationFromKey", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: h, reason: from kotlin metadata */
public final class LibraryFragment extends Fragment implements g {

    /* renamed from: a, reason: from kotlin metadata */
    private final h binding;
    private final h b;
    private ud c;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class a<T> implements y<T> {

        final /* synthetic */ h a;
        final /* synthetic */ app.dogo.com.dogo_android.y.j b;
        public final void onChanged(T t) {
            z = t instanceof LoadResult_Success;
            if (t instanceof oadResult_Success) {
                this.a.handleDestinationScreens(this.b, (Library)t.component1());
            }
        }

        public a(app.dogo.com.dogo_android.y.j jVar) {
            this.a = hVar;
            this.b = jVar;
            super();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class b<T> implements y<T> {

        final /* synthetic */ h a;
        public final void onChanged(T t) {
            if (t != null) {
                androidx.fragment.app.e activity = this.a.getActivity();
                if (activity != null) {
                    app.dogo.com.dogo_android.util.extensionfunction.g1.showEntryReportDialog(activity, new RatePromptV2Screen(t.getTag()));
                }
            }
        }

        public b() {
            this.a = hVar;
            super();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class c<T> implements y<T> {

        final /* synthetic */ h a;
        public final void onChanged(T t) {
            if (t != null) {
                androidx.fragment.app.e activity = this.a.getActivity();
                if (activity != null) {
                    app.dogo.com.dogo_android.util.extensionfunction.g1.showEntryReportDialog(activity, new SharePromptScreen(t.getTag()));
                }
            }
        }

        public c() {
            this.a = hVar;
            super();
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends kotlin.d0.d.p implements kotlin.d0.c.a<app.dogo.com.dogo_android.view.dailytraining.l> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ Fragment $this_sharedViewModel;
        @Override // kotlin.d0.d.p
        public final app.dogo.com.dogo_android.view.dailytraining.l invoke() {
            return a.a(this.$this_sharedViewModel, this.$qualifier, c0.b(SessionViewModel.class), this.$parameters);
        }

        public d(Fragment fragment, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_sharedViewModel = fragment;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/ViewModelStoreOwnerExtKt$viewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class e extends kotlin.d0.d.p implements kotlin.d0.c.a<j> {

        final /* synthetic */ kotlin.d0.c.a $parameters;
        final /* synthetic */ m.a.c.j.a $qualifier;
        final /* synthetic */ j0 $this_viewModel;
        @Override // kotlin.d0.d.p
        public final j invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(LibraryViewModel.class), this.$parameters);
        }

        public e(j0 j0Var, m.a.c.j.a aVar, kotlin.d0.c.a aVar2) {
            this.$this_viewModel = j0Var;
            this.$qualifier = aVar;
            this.$parameters = aVar2;
            super(0);
        }
    }
    public h() {
        super();
        final m.a.c.j.a aVar = null;
        this.binding = j.a(LazyThreadSafetyMode.NONE, new kotlinx.coroutines.h.d(this, aVar, aVar));
        this.b = j.a(LazyThreadSafetyMode.SYNCHRONIZED, new kotlinx.coroutines.h.e(this, aVar, aVar));
    }

    /* renamed from: B1, reason: from kotlin metadata */
    public static final /* synthetic */ void onCreateView(h inflater, app.dogo.com.dogo_android.y.j container, Library savedInstanceState) {
        inflater.handleDestinationScreens(container, savedInstanceState);
    }

    /* renamed from: C1, reason: from kotlin metadata */
    private final i loadNextAppScreenAfterResultIfRequested() {
        return (LibraryScreen)app.dogo.com.dogo_android.util.extensionfunction.k1.a(this);
    }

    private final j D1() {
        return (LibraryViewModel)this.b.getValue();
    }

    /* renamed from: E1, reason: from kotlin metadata */
    private final void handleDestinationScreens(app.dogo.com.dogo_android.y.j destination, Library library) {
        String name;
        String str;
        java.util.List articles;
        boolean hasNext;
        boolean equals;
        int i = 0;
        Article component1;
        TrickItem trickItem2 = null;
        int i2 = 0;
        boolean z2;
        int i14 = 1;
        boolean hasNext2;
        boolean z4;
        String articleId;
        final Object destination3 = this;
        Object destination2 = destination;
        DogProfile dogProfile = getSharedViewModel().I();
        String str3 = "library";
        i = 0;
        if (destination2 instanceof TrickDetailsScreen) {
            TrickItem trickItem = destination2.b().a();
            name = "";
            if (trickItem != null) {
                name = trickItem.getId();
                if (name != null) {
                }
            }
            java.util.List tricks = library.getTricks();
            if (tricks != null) {
                Iterator it = tricks.iterator();
                while (it.hasNext()) {
                    Object item = it.next();
                    if (n.b((TrickItem)item.getId(), name)) {
                        break;
                    }
                }
                if (trickItem2 != null) {
                    app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new TrickDetailsScreen(new TrickDetailsPlan_LibraryPlan(trickItem2), loadNextAppScreenAfterResultIfRequested().getTag(), loadNextAppScreenAfterResultIfRequested().getTag(), str3));
                }
            }
        } else {
            i2 = 0;
            boolean z3 = true;
            if (!(destination2 instanceof TrickListScreen)) {
                if (!(destination2 instanceof ArticleListScreen)) {
                    if (destination2 instanceof ArticleDetailsScreen) {
                        articles = library.getArticles();
                        if (articles != null) {
                            Iterator it2 = articles.iterator();
                            while (it2.hasNext()) {
                                Object item2 = it2.next();
                                if (n.b((Article)item2.getArticleId(), (ArticleDetailsScreen)destination2.component1().getArticleId())) {
                                    break;
                                }
                            }
                        }
                        if (i == 0) {
                            component1 = destination2.component1();
                        }
                        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new ArticleDetailsScreen(component1, str3, false));
                    } else {
                        if (destination2 instanceof ProgramListScreen) {
                            app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), destination2.copy(loadNextAppScreenAfterResultIfRequested().getTag(), z3));
                        } else {
                            if (destination2 instanceof ProgramLessonsListScreen) {
                                equals = true;
                                String str2 = null;
                                z3 = false;
                                app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), ProgramLessonsListScreen.b((ProgramLessonsListScreen)destination2, equals, str2, false, z3, loadNextAppScreenAfterResultIfRequested().getTag(), 14, null));
                            } else {
                                if (destination2 instanceof CertificateDetailScreen) {
                                    if (dogProfile != null) {
                                        String str4 = null;
                                        String str5 = null;
                                        articleId = null;
                                        Object obj4 = null;
                                        String tag = null;
                                        String tag2 = null;
                                        Object obj2 = null;
                                        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), destination2.copy(ProgramExamSummary.copy$default(destination2.c(), ProgramSaveInfo.copy$default(destination2.c().getProgramSaveInfo(), str4, str5, articleId, dogProfile.getId(), 7, obj4), null, str4, str5, articleId, tag, tag2, obj4, null, null, 1022, obj2), dogProfile.getName(), loadNextAppScreenAfterResultIfRequested().getTag(), loadNextAppScreenAfterResultIfRequested().getTag()));
                                    }
                                } else {
                                    if (destination2 instanceof ProgramLessonScreen) {
                                        if (dogProfile != null) {
                                            k kVar2 = destination2;
                                            if (kVar2.f() != null) {
                                                articleId = null;
                                                tag = null;
                                                boolean z5 = false;
                                                boolean z6 = false;
                                                int i4 = 27;
                                                Object obj = null;
                                                app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), ProgramLessonScreen.b(kVar2, articleId, tag, loadNextAppScreenAfterResultIfRequested().getTag(), z5, z6, i4, obj));
                                            }
                                        }
                                    } else {
                                        if (destination2 instanceof LessonExamListScreen) {
                                            if (dogProfile != null) {
                                                w wVar2 = destination2;
                                                if (l.z(wVar2.d().getProgramId()) ^ z3 != 0) {
                                                    obj = null;
                                                    z5 = false;
                                                    app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), LessonExamListScreen.b(wVar2, ProgramSaveInfo.copy$default(wVar2.d(), null, null, null, dogProfile.getId(), 7, obj), loadNextAppScreenAfterResultIfRequested().getTag(), loadNextAppScreenAfterResultIfRequested().getTag(), z5, 8, null));
                                                }
                                            }
                                        } else {
                                            if (destination2 instanceof LessonExamHistoryScreen) {
                                                if (dogProfile != null) {
                                                    s sVar2 = destination2;
                                                    if (l.z(sVar2.component1().getProgramId()) ^ z3 != 0) {
                                                        tag = null;
                                                        tag2 = null;
                                                        obj = null;
                                                        i4 = 6;
                                                        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), LessonExamHistoryScreen.b(sVar2, ProgramSaveInfo.copy$default(sVar2.component1(), tag, tag2, null, dogProfile.getId(), 7, obj), tag, tag2, n.b(library.isDogPremiumContentLocked(), Boolean.FALSE), loadNextAppScreenAfterResultIfRequested().getTag(), i4, obj));
                                                    }
                                                }
                                            } else {
                                                if (destination2 instanceof PottyProgramOverviewScreen) {
                                                    app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), destination2);
                                                } else {
                                                    if (destination2 instanceof BitingProgramOverviewScreen) {
                                                        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), destination2);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new ArticleListScreen(destination2.component1()));
                }
            } else {
                name = destination2.a().getId();
                int i9 = name.hashCode();
                str2 = "getString(R.string.tricks)";
                int i3 = 2131887623;
                if (i9 != -808875034) {
                    if (i9 != -773789916) {
                        if (i9 != -314563939) {
                            str = destination2.b();
                            boolean r6 = z3;
                            if (i2 == 0) {
                                String string2 = destination3.getString(i3);
                                n.e(string2, str2);
                                app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new TrickListScreen(new TrickItem_TrickCategory(name, string2), destination2.b()));
                            }
                        } else {
                            str = "id_games";
                            if (name.equals(str)) {
                                String string = destination3.getString(2131886667);
                                name = "getString(R.string.games_title)";
                                n.e(string, name);
                                destination3.X(str, string);
                            }
                        }
                    } else {
                        str = "id_tricks";
                        if (name.equals(str)) {
                            string = destination3.getString(i3);
                            n.e(string, str2);
                            destination3.X(str, string);
                        }
                    }
                } else {
                    str = "id_skills";
                    if (name.equals(str)) {
                        string = destination3.getString(2131886727);
                        name = "getString(R.string.good_manners)";
                        n.e(string, name);
                        destination3.X(str, string);
                    }
                }
            }
        }
    }

    private final void J1() {
        app.dogo.com.dogo_android.y.j component1 = loadNextAppScreenAfterResultIfRequested().component1();
        if (component1 != null) {
            androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
            n.e(viewLifecycleOwner, "viewLifecycleOwner");
            D1().r().observe(viewLifecycleOwner, new kotlinx.coroutines.h.a(this, component1));
            P1();
        }
    }

    private static final void K1(h hVar, View view) {
        n.f(hVar, "this$0");
        hVar.D1().F();
        String string = hVar.getString(2131887623);
        n.e(string, "getString(R.string.tricks)");
        hVar.X("id_tricks", string);
    }

    private static final void L1(h hVar, View view) {
        n.f(hVar, "this$0");
        hVar.D1().x();
        String string = hVar.getString(2131886667);
        n.e(string, "getString(R.string.games_title)");
        hVar.X("id_games", string);
    }

    private static final void M1(h hVar, View view) {
        n.f(hVar, "this$0");
        hVar.D1().C();
        String string = hVar.getString(2131886727);
        n.e(string, "getString(R.string.good_manners)");
        hVar.X("id_skills", string);
    }

    private static final void N1(h hVar, View view) {
        n.f(hVar, "this$0");
        hVar.D1().v();
        hVar.E0();
    }

    /* renamed from: O1, reason: from kotlin metadata */
    private final void onArticleSelected(ProgramDescriptionItem article) {
        app.dogo.com.dogo_android.y.w.n programLessonsListScreen;
        int i = 1;
        ProgramDescriptionItem.State nOT_STARTED2;
        if (!article.getShouldOpenProgramOverview()) {
            if (article.getProgramState() != ProgramDescriptionItem_State.NOT_STARTED) {
                if (article.getProgramState() != ProgramDescriptionItem_State.RECOMMENDED) {
                    if (article.getProgramState() == ProgramDescriptionItem_State.RECOMMENDED_BIG) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                }
            }
            boolean z2 = true;
            boolean z3 = false;
            int i2 = 8;
            kotlin.d0.d.g gVar = null;
            programLessonsListScreen = new ProgramLessonsListScreen(i, article.getId(), z2, z3, loadNextAppScreenAfterResultIfRequested().getTag(), i2, gVar);
        } else {
            boolean z4 = true;
            boolean z5 = false;
            int i3 = 16;
            kotlin.d0.d.g gVar2 = null;
            str3 = "library";
            ProgramOverviewScreen programOverviewScreen = new ProgramOverviewScreen(article.getId(), article.getCardBackgroundColor(), article.getOverviewItem(), z4, z5, loadNextAppScreenAfterResultIfRequested().getTag(), str3, i3, gVar2);
        }
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), programLessonsListScreen);
    }

    private final void P1() {
        final Bundle arguments = getArguments();
        if (arguments != null) {
            str = "SCREEN_KEY";
            arguments.putParcelable(str, loadNextAppScreenAfterResultIfRequested().copy(null));
        }
    }

    private final app.dogo.com.dogo_android.view.dailytraining.l getSharedViewModel() {
        return (SessionViewModel)this.binding.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void E0() {
        D1().z();
        final String str = null;
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new ArticleListScreen(str, 1, str));
    }

    @Override // androidx.fragment.app.Fragment
    public void Q() {
        D1().loadList();
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new ProgramListScreen(loadNextAppScreenAfterResultIfRequested().getTag(), true));
    }

    @Override // androidx.fragment.app.Fragment
    public void X(String str, String str2) {
        n.f(str, "categoryId");
        n.f(str2, "categoryName");
        D1().B(str);
        final String str5 = null;
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new TrickListScreen(new TrickItem_TrickCategory(str, str2), str5, 2, str5));
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: a, reason: from kotlin metadata */
    public void onComingSoonItemSelect(Article item) {
        n.f(item, "article");
        D1().u(item.getArticleId());
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new ArticleDetailsScreen(item, "library", false));
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: b, reason: from kotlin metadata */
    public void onProgramSelected(ProgramDescriptionItem item) {
        n.f(item, "item");
        D1().w(item.getId());
        androidx.fragment.app.e requireActivity = requireActivity();
        n.e(requireActivity, "requireActivity()");
        app.dogo.com.dogo_android.util.extensionfunction.f1.d0(requireActivity, 2131887129);
    }

    @Override // androidx.fragment.app.Fragment
    public void c() {
        D1().D();
        app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), SessionViewModel.H(getSharedViewModel(), "library", loadNextAppScreenAfterResultIfRequested().getTag(), false, null, 12, null));
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: g, reason: from kotlin metadata */
    public void onRecommendedProgramSelected(ProgramDescriptionItem item) {
        n.f(item, "item");
        D1().y(item.getId());
        app.dogo.com.dogo_android.y.j specialProgramOverviewScreen = item.getSpecialProgramOverviewScreen("library");
        if (specialProgramOverviewScreen != null) {
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), specialProgramOverviewScreen);
        } else {
            onArticleSelected(item);
        }
    }

    @Override // androidx.fragment.app.Fragment
    /* renamed from: j, reason: from kotlin metadata */
    public void onTrickSelected(TrickItem trick) {
        n.f(trick, "trick");
        D1().E(trick.getId());
        if (trick.getLocked()) {
            boolean z = false;
            app.dogo.com.dogo_android.repository.domain.ProfilePreview profilePreview = null;
            int i = 12;
            Object obj = null;
            str = "library";
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), SessionViewModel.H(getSharedViewModel(), str, loadNextAppScreenAfterResultIfRequested().getTag(), z, profilePreview, i, obj));
        } else {
            app.dogo.com.dogo_android.util.extensionfunction.g1.n(getActivity(), new TrickDetailsScreen(new TrickDetailsPlan_LibraryPlan(trick), loadNextAppScreenAfterResultIfRequested().getTag(), loadNextAppScreenAfterResultIfRequested().getTag(), "library"));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        n.f(layoutInflater, "inflater");
        ud udVar = ud.T(layoutInflater, viewGroup, false);
        n.e(udVar, "inflate(inflater, container, false)");
        this.c = udVar;
        int i = 0;
        String str4 = "binding";
        if (udVar == null) {
            n.w(str4);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            udVar.V(this);
            if (this.c == null) {
                n.w(str4);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                this.c.W(D1());
                if (this.c == null) {
                    n.w(str4);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    this.c.M(getViewLifecycleOwner());
                    if (this.c == null) {
                        n.w(str4);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        View view = this.c.w();
                        n.e(view, "binding.root");
                        return view;
                    }
                }
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) throws h.c {
        androidx.fragment.app.e activity;
        n.f(view, "view");
        super.onViewCreated(view, bundle);
        int i = 0;
        view = getActivity() instanceof Navigator ? (Navigator)this.getActivity() : i;
        if (activity != null) {
            activity.p0();
        }
        String str3 = "binding";
        if (this.c == null) {
            n.w(str3);
            /* Dexterity WARN: Type inference failed for thrown value */
            throw (Throwable) i;
        } else {
            udVar.S.R.w().setOnClickListener(new kotlinx.coroutines.c(this));
            if (this.c == null) {
                n.w(str3);
                /* Dexterity WARN: Type inference failed for thrown value */
                throw (Throwable) i;
            } else {
                udVar2.S.Q.w().setOnClickListener(new kotlinx.coroutines.d(this));
                if (this.c == null) {
                    n.w(str3);
                    /* Dexterity WARN: Type inference failed for thrown value */
                    throw (Throwable) i;
                } else {
                    udVar3.S.P.w().setOnClickListener(new kotlinx.coroutines.b(this));
                    if (this.c == null) {
                        n.w(str3);
                        /* Dexterity WARN: Type inference failed for thrown value */
                        throw (Throwable) i;
                    } else {
                        udVar4.S.O.w().setOnClickListener(new kotlinx.coroutines.e(this));
                        androidx.lifecycle.q viewLifecycleOwner = getViewLifecycleOwner();
                        String str2 = "viewLifecycleOwner";
                        n.e(viewLifecycleOwner, str2);
                        D1().q().observe(viewLifecycleOwner, new kotlinx.coroutines.h.b(this));
                        androidx.lifecycle.q viewLifecycleOwner2 = getViewLifecycleOwner();
                        n.e(viewLifecycleOwner2, str2);
                        D1().s().observe(viewLifecycleOwner2, new kotlinx.coroutines.h.c(this));
                        J1();
                        D1().t();
                        return;
                    }
                }
            }
        }
    }


    /* renamed from: F1, reason: from kotlin metadata */
    public static /* synthetic */ void onTrickListSelected(h categoryId, View categoryName) {
        LibraryFragment.M1(categoryId, categoryName);
    }

    /* renamed from: G1, reason: from kotlin metadata */
    public static /* synthetic */ void onViewCreated(h view, View savedInstanceState) {
        LibraryFragment.K1(view, savedInstanceState);
    }

    public static /* synthetic */ void H1(h hVar, View view) {
        LibraryFragment.L1(hVar, view);
    }

    public static /* synthetic */ void I1(h hVar, View view) {
        LibraryFragment.N1(hVar, view);
    }
}
