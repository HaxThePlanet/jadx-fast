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
import app.dogo.com.dogo_android.h.ud;
import app.dogo.com.dogo_android.n.k.l;
import app.dogo.com.dogo_android.n.k.p;
import app.dogo.com.dogo_android.n.m.n;
import app.dogo.com.dogo_android.n.m.n.a;
import app.dogo.com.dogo_android.n.m.q;
import app.dogo.com.dogo_android.n.m.u.m;
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
import app.dogo.com.dogo_android.view.dailytraining.l;
import app.dogo.com.dogo_android.view.n;
import app.dogo.com.dogo_android.view.q;
import app.dogo.com.dogo_android.y.j;
import app.dogo.com.dogo_android.y.n.i;
import app.dogo.com.dogo_android.y.o.s;
import app.dogo.com.dogo_android.y.o.w;
import app.dogo.com.dogo_android.y.s.k;
import app.dogo.com.dogo_android.y.w.n;
import app.dogo.com.dogo_android.y.y.g;
import app.dogo.com.dogo_android.y.z.f;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.d0.c.a;
import kotlin.d0.d.c0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.h;
import kotlin.j;
import kotlin.k0.l;
import kotlin.m;
import m.a.b.a.d.a.a;
import m.a.b.a.d.a.b;
import m.a.c.j.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0010\u000e\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0008\u0010\u001b\u001a\u00020\u0016H\u0002J\u0008\u0010\u001c\u001a\u00020\u0016H\u0016J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"H\u0016J$\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0008\u0010'\u001a\u0004\u0018\u00010(2\u0008\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0008\u0010+\u001a\u00020\u0016H\u0016J\u0010\u0010,\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010-\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"H\u0016J\u0008\u0010.\u001a\u00020\u0016H\u0016J\u0018\u0010/\u001a\u00020\u00162\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u000201H\u0016J\u0010\u00103\u001a\u00020\u00162\u0006\u00104\u001a\u000205H\u0016J\u001a\u00106\u001a\u00020\u00162\u0006\u00107\u001a\u00020$2\u0008\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u00108\u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"H\u0002J\u0008\u00109\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\u0008\u0008\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u000e\u0010\u000f\u001a\u0004\u0008\u000c\u0010\rR\u001b\u0010\u0010\u001a\u00020\u00118BX\u0082\u0084\u0002¢\u0006\u000c\n\u0004\u0008\u0014\u0010\u000f\u001a\u0004\u0008\u0012\u0010\u0013¨\u0006:", d2 = {"Lapp/dogo/com/dogo_android/library/LibraryFragment;", "Landroidx/fragment/app/Fragment;", "Lapp/dogo/com/dogo_android/library/LibraryCallback$Callback;", "()V", "binding", "Lapp/dogo/com/dogo_android/databinding/FragmentLibraryBinding;", "screenKey", "Lapp/dogo/com/dogo_android/library/LibraryScreen;", "getScreenKey", "()Lapp/dogo/com/dogo_android/library/LibraryScreen;", "sharedViewModel", "Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "getSharedViewModel", "()Lapp/dogo/com/dogo_android/view/dailytraining/SessionViewModel;", "sharedViewModel$delegate", "Lkotlin/Lazy;", "viewModel", "Lapp/dogo/com/dogo_android/library/LibraryViewModel;", "getViewModel", "()Lapp/dogo/com/dogo_android/library/LibraryViewModel;", "viewModel$delegate", "handleDestinationScreens", "", "destination", "Lapp/dogo/com/dogo_android/trainingprogram/AppScreen;", "library", "Lapp/dogo/com/dogo_android/repository/domain/Library;", "loadNextAppScreenAfterResultIfRequested", "onArticleListSelected", "onArticleSelected", "article", "Lapp/dogo/com/dogo_android/repository/domain/Article;", "onComingSoonItemSelect", "item", "Lapp/dogo/com/dogo_android/repository/domain/ProgramDescriptionItem;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onProgramListSelected", "onProgramSelected", "onRecommendedProgramSelected", "onSubscriptionSelected", "onTrickListSelected", "categoryId", "", "categoryName", "onTrickSelected", "trick", "Lapp/dogo/com/dogo_android/repository/domain/TrickItem;", "onViewCreated", "view", "openProgram", "removeDestinationFromKey", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class h extends Fragment implements app.dogo.com.dogo_android.n.g {

    private final h a;
    private final h b;
    private ud c;

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class a implements y<T> {

        final app.dogo.com.dogo_android.n.h a;
        final j b;
        public a(app.dogo.com.dogo_android.n.h h, j j2) {
            this.a = h;
            this.b = j2;
            super();
        }

        public final void onChanged(T t) {
            boolean z;
            j jVar;
            Object obj3;
            if (t instanceof y.c) {
                h.B1(this.a, this.b, (Library)(y.c)(y)t.a());
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class b implements y<T> {

        final app.dogo.com.dogo_android.n.h a;
        public b(app.dogo.com.dogo_android.n.h h) {
            this.a = h;
            super();
        }

        public final void onChanged(T t) {
            androidx.fragment.app.e activity;
            n nVar;
            String obj3;
            if ((q2.a)t == null) {
            } else {
                activity = this.a.getActivity();
                if (activity == null) {
                } else {
                    nVar = new n((q2.a)t.getTag());
                    g1.X(activity, nVar);
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\u0008\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 5, 1})
    public static final class c implements y<T> {

        final app.dogo.com.dogo_android.n.h a;
        public c(app.dogo.com.dogo_android.n.h h) {
            this.a = h;
            super();
        }

        public final void onChanged(T t) {
            androidx.fragment.app.e activity;
            q qVar;
            String obj3;
            if ((q2.a)t == null) {
            } else {
                activity = this.a.getActivity();
                if (activity == null) {
                } else {
                    qVar = new q((q2.a)t.getTag());
                    g1.X(activity, qVar);
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\n\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0002H\u0001\"\n\u0008\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¨\u0006\u0003", d2 = {"<anonymous>", "T", "Landroidx/lifecycle/ViewModel;", "org/koin/androidx/viewmodel/ext/android/SharedViewModelExtKt$sharedViewModel$1"}, k = 3, mv = {1, 5, 1}, xi = 48)
    public static final class d extends p implements a<l> {

        final a $parameters;
        final a $qualifier;
        final Fragment $this_sharedViewModel;
        public d(Fragment fragment, a a2, a a3) {
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
    public static final class e extends p implements a<app.dogo.com.dogo_android.n.j> {

        final a $parameters;
        final a $qualifier;
        final j0 $this_viewModel;
        public e(j0 j0, a a2, a a3) {
            this.$this_viewModel = j0;
            this.$qualifier = a2;
            this.$parameters = a3;
            super(0);
        }

        public final app.dogo.com.dogo_android.n.j invoke() {
            return b.a(this.$this_viewModel, this.$qualifier, c0.b(j.class), this.$parameters);
        }

        @Override // kotlin.d0.d.p
        public Object invoke() {
            return invoke();
        }
    }
    static {
    }

    public h() {
        super();
        final int i = 0;
        h.d dVar = new h.d(this, i, i);
        this.a = j.a(m.NONE, dVar);
        h.e eVar = new h.e(this, i, i);
        this.b = j.a(m.SYNCHRONIZED, eVar);
    }

    public static final void B1(app.dogo.com.dogo_android.n.h h, j j2, Library library3) {
        h.E1(j2, library3);
    }

    private final app.dogo.com.dogo_android.n.i C1() {
        return (i)k1.a(this);
    }

    private final app.dogo.com.dogo_android.n.j D1() {
        return (j)this.b.getValue();
    }

    private final void E1(j j, Library library2) {
        String lVar;
        Object trickItem;
        String mVar;
        String fALSE;
        boolean copy$default;
        String str;
        int trickCategory;
        int string;
        int tag;
        String articleId;
        int tag4;
        String tag3;
        int i2;
        int tag2;
        int i4;
        int i3;
        int i;
        final Object obj = this;
        lVar = j;
        mVar = getSharedViewModel().I();
        copy$default = "library";
        str = 0;
        if (lVar instanceof m) {
            trickItem = (m)lVar.b().a();
            mVar = "";
            if (trickItem == null) {
            } else {
                trickItem = trickItem.getId();
                if (trickItem == null) {
                } else {
                    mVar = trickItem;
                }
            }
            lVar = library2.getTricks();
            if (lVar == null) {
            } else {
                lVar = lVar.iterator();
                while (lVar.hasNext()) {
                    fALSE = lVar.next();
                    if (n.b((TrickItem)fALSE.getId(), mVar)) {
                        break;
                    } else {
                    }
                }
                if ((TrickItem)str == 0) {
                } else {
                    fALSE = new n.a((TrickItem)str);
                    mVar = new m(fALSE, C1().getTag(), C1().getTag(), copy$default);
                    g1.n(getActivity(), mVar);
                }
            }
        } else {
            string = 1;
            if (lVar instanceof q) {
                mVar = (q)lVar.a().getId();
                fALSE = mVar.hashCode();
                str = "getString(R.string.tricks)";
                tag = 2131887623;
                if (fALSE != -808875034) {
                    if (fALSE != -773789916) {
                        if (fALSE != -314563939) {
                            fALSE = lVar.b();
                            if (fALSE != null) {
                                if (l.z(fALSE)) {
                                    trickCategory = string;
                                }
                            } else {
                            }
                            if (trickCategory == 0) {
                                string = obj.getString(tag);
                                n.e(string, str);
                                trickCategory = new TrickItem.TrickCategory(mVar, string);
                                copy$default = new q(trickCategory, lVar.b());
                                g1.n(getActivity(), copy$default);
                            }
                        } else {
                            fALSE = "id_games";
                            if (!mVar.equals(fALSE)) {
                            } else {
                                lVar = obj.getString(2131886667);
                                n.e(lVar, "getString(R.string.games_title)");
                                obj.X(fALSE, lVar);
                            }
                        }
                    } else {
                        fALSE = "id_tricks";
                        if (!mVar.equals(fALSE)) {
                        } else {
                            lVar = obj.getString(tag);
                            n.e(lVar, str);
                            obj.X(fALSE, lVar);
                        }
                    }
                } else {
                    fALSE = "id_skills";
                    if (!mVar.equals(fALSE)) {
                    } else {
                        lVar = obj.getString(2131886727);
                        n.e(lVar, "getString(R.string.good_manners)");
                        obj.X(fALSE, lVar);
                    }
                }
            } else {
                if (lVar instanceof p) {
                    fALSE = new p((p)lVar.a());
                    g1.n(getActivity(), fALSE);
                } else {
                    if (lVar instanceof l) {
                        fALSE = library2.getArticles();
                        if (fALSE == null) {
                        } else {
                            fALSE = fALSE.iterator();
                            while (fALSE.hasNext()) {
                                string = fALSE.next();
                                if (n.b((Article)string.getArticleId(), (l)lVar.a().getArticleId())) {
                                    break;
                                } else {
                                }
                            }
                        }
                        if (str == null) {
                            str = (l)lVar.a();
                        }
                        lVar = new l(str, copy$default, 0);
                        g1.n(getActivity(), lVar);
                    } else {
                        if (lVar instanceof g) {
                            g1.n(getActivity(), (g)lVar.a(C1().getTag(), string));
                        } else {
                            if (lVar instanceof n) {
                                g1.n(getActivity(), n.b((n)lVar, true, 0, false, false, C1().getTag(), 14, 0));
                            } else {
                                if (lVar instanceof i) {
                                    if (mVar != null) {
                                        string = 0;
                                        tag = 0;
                                        articleId = 0;
                                        i2 = 0;
                                        g1.n(getActivity(), lVar.a(ProgramExamSummary.copy$default((i)lVar.c(), ProgramSaveInfo.copy$default(lVar.c().getProgramSaveInfo(), string, tag, articleId, mVar.getId(), 7, i2), 0, string, tag, articleId, 0, 0, i2, 0, 0, 1022, 0), mVar.getName(), C1().getTag(), C1().getTag()));
                                    }
                                } else {
                                    if (lVar instanceof k) {
                                        tag = lVar;
                                        if (mVar != null && (k)tag.f() != null) {
                                            tag = lVar;
                                            if ((k)tag.f() != null) {
                                                g1.n(getActivity(), k.b(tag, 0, 0, C1().getTag(), false, false, 27, 0));
                                            }
                                        }
                                    } else {
                                        if (lVar instanceof w) {
                                            tag = lVar;
                                            if (mVar != null && z2 ^= string != null) {
                                                tag = lVar;
                                                if (z2 ^= string != null) {
                                                    g1.n(getActivity(), w.b(tag, ProgramSaveInfo.copy$default(tag.d(), 0, 0, 0, mVar.getId(), 7, 0), C1().getTag(), C1().getTag(), false, 8, 0));
                                                }
                                            }
                                        } else {
                                            if (lVar instanceof s) {
                                                tag = lVar;
                                                if (mVar != null && z ^= string != null) {
                                                    tag = lVar;
                                                    if (z ^= string != null) {
                                                        tag4 = 0;
                                                        tag3 = 0;
                                                        i3 = 0;
                                                        g1.n(getActivity(), s.b(tag, ProgramSaveInfo.copy$default(tag.c(), tag4, tag3, 0, mVar.getId(), 7, i3), tag4, tag3, n.b(library2.isDogPremiumContentLocked(), Boolean.FALSE), C1().getTag(), 6, i3));
                                                    }
                                                }
                                            } else {
                                                if (lVar instanceof m) {
                                                    g1.n(getActivity(), lVar);
                                                } else {
                                                    if (lVar instanceof o) {
                                                        g1.n(getActivity(), lVar);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static void F1(app.dogo.com.dogo_android.n.h h, View view2) {
        h.M1(h, view2);
    }

    public static void G1(app.dogo.com.dogo_android.n.h h, View view2) {
        h.K1(h, view2);
    }

    public static void H1(app.dogo.com.dogo_android.n.h h, View view2) {
        h.L1(h, view2);
    }

    public static void I1(app.dogo.com.dogo_android.n.h h, View view2) {
        h.N1(h, view2);
    }

    private final void J1() {
        LiveData liveData;
        androidx.lifecycle.q viewLifecycleOwner;
        app.dogo.com.dogo_android.n.h.a aVar;
        j jVar = C1().b();
        if (jVar != null) {
            viewLifecycleOwner = getViewLifecycleOwner();
            n.e(viewLifecycleOwner, "viewLifecycleOwner");
            aVar = new h.a(this, jVar);
            D1().r().observe(viewLifecycleOwner, aVar);
            P1();
        }
    }

    private static final void K1(app.dogo.com.dogo_android.n.h h, View view2) {
        n.f(h, "this$0");
        h.D1().F();
        String obj2 = h.getString(2131887623);
        n.e(obj2, "getString(R.string.tricks)");
        h.X("id_tricks", obj2);
    }

    private static final void L1(app.dogo.com.dogo_android.n.h h, View view2) {
        n.f(h, "this$0");
        h.D1().x();
        String obj2 = h.getString(2131886667);
        n.e(obj2, "getString(R.string.games_title)");
        h.X("id_games", obj2);
    }

    private static final void M1(app.dogo.com.dogo_android.n.h h, View view2) {
        n.f(h, "this$0");
        h.D1().C();
        String obj2 = h.getString(2131886727);
        n.e(obj2, "getString(R.string.good_manners)");
        h.X("id_skills", obj2);
    }

    private static final void N1(app.dogo.com.dogo_android.n.h h, View view2) {
        n.f(h, "this$0");
        h.D1().v();
        h.E0();
    }

    private final void O1(ProgramDescriptionItem programDescriptionItem) {
        j nVar;
        n nVar2;
        int i5;
        ProgramDescriptionItem.State programState;
        int i7;
        ProgramDescriptionItem.State rECOMMENDED_BIG;
        String str3;
        int i8;
        int i9;
        String tag2;
        int i4;
        int i2;
        f fVar;
        String str;
        String cardBackgroundColor;
        app.dogo.com.dogo_android.repository.domain.ProgramOverview overviewItem;
        int i;
        int i3;
        String tag;
        String str2;
        int i6;
        int i10;
        if (!programDescriptionItem.getShouldOpenProgramOverview()) {
            if (programDescriptionItem.getProgramState() != ProgramDescriptionItem.State.NOT_STARTED && programDescriptionItem.getProgramState() != ProgramDescriptionItem.State.RECOMMENDED) {
                if (programDescriptionItem.getProgramState() != ProgramDescriptionItem.State.RECOMMENDED) {
                    if (programDescriptionItem.getProgramState() == ProgramDescriptionItem.State.RECOMMENDED_BIG) {
                        i5 = 1;
                    } else {
                        i5 = 0;
                    }
                } else {
                }
            } else {
            }
            super(i5, programDescriptionItem.getId(), 1, 0, C1().getTag(), 8, 0);
        } else {
            super(programDescriptionItem.getId(), programDescriptionItem.getCardBackgroundColor(), programDescriptionItem.getOverviewItem(), 1, 0, C1().getTag(), "library", 16, 0);
        }
        g1.n(getActivity(), nVar);
    }

    private final void P1() {
        app.dogo.com.dogo_android.n.i iVar;
        String str;
        final Bundle arguments = getArguments();
        if (arguments == null) {
        } else {
            arguments.putParcelable("SCREEN_KEY", C1().a(0));
        }
    }

    private final l getSharedViewModel() {
        return (l)this.a.getValue();
    }

    @Override // androidx.fragment.app.Fragment
    public void E0() {
        D1().z();
        final int i = 0;
        p pVar = new p(i, 1, i);
        g1.n(getActivity(), pVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void Q() {
        D1().A();
        g gVar = new g(C1().getTag(), 1);
        g1.n(getActivity(), gVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void X(String string, String string2) {
        n.f(string, "categoryId");
        n.f(string2, "categoryName");
        D1().B(string);
        TrickItem.TrickCategory trickCategory = new TrickItem.TrickCategory(string, string2);
        final int obj4 = 0;
        q qVar = new q(trickCategory, obj4, 2, obj4);
        g1.n(getActivity(), qVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void a(Article article) {
        n.f(article, "article");
        D1().u(article.getArticleId());
        l lVar = new l(article, "library", 0);
        g1.n(getActivity(), lVar);
    }

    @Override // androidx.fragment.app.Fragment
    public void b(ProgramDescriptionItem programDescriptionItem) {
        n.f(programDescriptionItem, "item");
        D1().w(programDescriptionItem.getId());
        androidx.fragment.app.e obj2 = requireActivity();
        n.e(obj2, "requireActivity()");
        f1.d0(obj2, 2131887129);
    }

    @Override // androidx.fragment.app.Fragment
    public void c() {
        D1().D();
        g1.n(getActivity(), l.H(getSharedViewModel(), "library", C1().getTag(), false, 0, 12, 0));
    }

    @Override // androidx.fragment.app.Fragment
    public void g(ProgramDescriptionItem programDescriptionItem) {
        Object obj3;
        n.f(programDescriptionItem, "item");
        D1().y(programDescriptionItem.getId());
        j specialProgramOverviewScreen = programDescriptionItem.getSpecialProgramOverviewScreen("library");
        if (specialProgramOverviewScreen != null) {
            g1.n(getActivity(), specialProgramOverviewScreen);
        } else {
            O1(programDescriptionItem);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void j(TrickItem trickItem) {
        androidx.fragment.app.e activity;
        Object sharedViewModel;
        Object aVar;
        String tag;
        int str;
        int i;
        int i2;
        int i3;
        Object obj9;
        n.f(trickItem, "trick");
        D1().E(trickItem.getId());
        if (trickItem.getLocked()) {
            g1.n(getActivity(), l.H(getSharedViewModel(), "library", C1().getTag(), false, 0, 12, 0));
        } else {
            aVar = new n.a(trickItem);
            sharedViewModel = new m(aVar, C1().getTag(), C1().getTag(), "library");
            g1.n(getActivity(), sharedViewModel);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup2, Bundle bundle3) {
        n.f(layoutInflater, "inflater");
        ud obj2 = ud.T(layoutInflater, viewGroup2, false);
        n.e(obj2, "inflate(inflater, container, false)");
        this.c = obj2;
        int obj3 = 0;
        String obj4 = "binding";
        if (obj2 == null) {
        } else {
            obj2.V(this);
            obj2 = this.c;
            if (obj2 == null) {
            } else {
                obj2.W(D1());
                obj2 = this.c;
                if (obj2 == null) {
                } else {
                    obj2.M(getViewLifecycleOwner());
                    obj2 = this.c;
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

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle2) {
        androidx.fragment.app.e obj3;
        n.f(view, "view");
        super.onViewCreated(view, bundle2);
        int i = 0;
        if (obj3 instanceof a0) {
        } else {
            obj3 = i;
        }
        if (obj3 == null) {
        } else {
            obj3.p0();
        }
        obj3 = this.c;
        String obj4 = "binding";
        if (obj3 == null) {
        } else {
            c cVar2 = new c(this);
            obj3.R.w().setOnClickListener(cVar2);
            obj3 = this.c;
            if (obj3 == null) {
            } else {
                d dVar = new d(this);
                obj3.Q.w().setOnClickListener(dVar);
                obj3 = this.c;
                if (obj3 == null) {
                } else {
                    b bVar = new b(this);
                    obj3.P.w().setOnClickListener(bVar);
                    obj3 = this.c;
                    if (obj3 == null) {
                    } else {
                        obj4 = new e(this);
                        obj3.O.w().setOnClickListener(obj4);
                        obj4 = getViewLifecycleOwner();
                        String str2 = "viewLifecycleOwner";
                        n.e(obj4, str2);
                        h.b bVar2 = new h.b(this);
                        D1().q().observe(obj4, bVar2);
                        obj4 = getViewLifecycleOwner();
                        n.e(obj4, str2);
                        h.c cVar = new h.c(this);
                        D1().s().observe(obj4, cVar);
                        J1();
                        D1().t();
                    }
                    n.w(obj4);
                    throw i;
                }
                n.w(obj4);
                throw i;
            }
            n.w(obj4);
            throw i;
        }
        n.w(obj4);
        throw i;
    }
}
