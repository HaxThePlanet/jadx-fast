package app.dogo.com.dogo_android.welcome_v2;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.core.content.e.f;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.u;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2.i;
import app.dogo.com.dogo_android.repository.domain.SurveyQuestion;
import app.dogo.com.dogo_android.repository.domain.WelcomeSlide;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.l0.b;
import app.dogo.com.dogo_android.util.m;
import app.dogo.com.dogo_android.util.o;
import app.dogo.com.dogo_android.util.p;
import com.bumptech.glide.j;
import com.bumptech.glide.load.n.e.d;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.g;
import com.google.android.material.tabs.d;
import com.google.android.material.textfield.TextInputEditText;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.a;
import com.yuyakaido.android.cardstackview.b;
import com.yuyakaido.android.cardstackview.c;
import com.yuyakaido.android.cardstackview.f;
import com.yuyakaido.android.cardstackview.g.b;
import com.yuyakaido.android.cardstackview.h;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.h0.g;
import kotlin.w;
import kotlin.y.p;
import n.a.a;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0002J\u0014\u0010\t\u001a\u00020\u0004*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0007J>\u0010\r\u001a\u00020\u0004*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007J<\u0010\u0019\u001a\u00020\u0004*\u00020\u00082\u0014\u0010\u001a\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u0017\u0018\u00010\u001b2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0007¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingBindingAdapters;", "", "()V", "simpleCardSwipe", "", "direction", "Lcom/yuyakaido/android/cardstackview/Direction;", "cardStackView", "Lcom/yuyakaido/android/cardstackview/CardStackView;", "setDogNameButtonAlpha", "Lcom/google/android/material/textfield/TextInputEditText;", "button", "Landroid/widget/Button;", "setOnboardingDetailsTab", "Landroidx/viewpager2/widget/ViewPager2;", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "callback", "Lapp/dogo/com/dogo_android/util/listeners/ViewPagerListener;", "backgroundTopImageView", "Landroid/widget/ImageView;", "backgroundBottomImageView", "onboardingSlides", "", "Lapp/dogo/com/dogo_android/repository/domain/WelcomeSlide;", "setOnboardingSurveyAdapter", "result", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/SurveyQuestion;", "Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$AnswerSelectCallback;", "coverView", "Landroid/view/View;", "placeHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class d0 {

    public static final app.dogo.com.dogo_android.welcome_v2.d0 a;

    @Metadata(d1 = "\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\nH\u0016¨\u0006\u000e", d2 = {"app/dogo/com/dogo_android/welcome_v2/OnboardingBindingAdapters$setDogNameButtonAlpha$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "text", "Landroid/text/Editable;", "beforeTextChanged", "p0", "", "p1", "", "p2", "p3", "onTextChanged", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a implements TextWatcher {

        final Button a;
        a(Button button) {
            this.a = button;
            super();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            int i;
            int obj4;
            i = 1;
            final int i2 = 0;
            if (editable == 0) {
                i = i2;
            } else {
            }
            obj4 = i != 0 ? 1056964608 : 1065353216;
            this.a.setAlpha(obj4);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(java.lang.CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(java.lang.CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    @Metadata(d1 = "\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0003H\u0016R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0004¨\u0006\n", d2 = {"app/dogo/com/dogo_android/welcome_v2/OnboardingBindingAdapters$setOnboardingDetailsTab$1", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "fromPosition", "", "Ljava/lang/Integer;", "onPageScrollStateChanged", "", "state", "onPageSelected", "position", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends ViewPager2.i {

        private Integer a;
        final List<WelcomeSlide> b;
        final b c;
        final ViewPager2 d;
        final ImageView e;
        final ImageView f;
        b(List<WelcomeSlide> list, b b2, ViewPager2 viewPager23, ImageView imageView4, ImageView imageView5) {
            this.b = list;
            this.c = b2;
            this.d = viewPager23;
            this.e = imageView4;
            this.f = imageView5;
            super();
        }

        public static void a(Integer integer, ViewPager2 viewPager22, List list3, ImageView imageView4, int i5, ImageView imageView6) {
            d0.b.b(integer, viewPager22, list3, imageView4, i5, imageView6);
        }

        private static final void b(Integer integer, ViewPager2 viewPager22, List list3, ImageView imageView4, int i5, ImageView imageView6) {
            android.content.res.Resources resources;
            Object obj2;
            n.f(viewPager22, "$this_setOnboardingDetailsTab");
            n.f(imageView4, "$backgroundBottomImageView");
            n.f(imageView6, "$backgroundTopImageView");
            int i = 0;
            if (integer != null) {
                imageView4.setImageDrawable(f.f(viewPager22.getResources(), (WelcomeSlide)list3.get(integer.intValue()).getImageRes(), i));
            }
            m.a(viewPager22.getContext()).z(f.f(viewPager22.getResources(), (WelcomeSlide)list3.get(i5).getImageRes(), i)).y1(d.h()).C0(imageView6);
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageScrollStateChanged(int i) {
            int i2;
            int obj2;
            super.onPageScrollStateChanged(i);
            if (i == 0 && this.d.getCurrentItem() > p.i(this.b)) {
                if (this.d.getCurrentItem() > p.i(this.b)) {
                    this.c.p();
                }
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageSelected(int i) {
            int size;
            app.dogo.com.dogo_android.welcome_v2.i iVar;
            int i3;
            Integer num;
            ViewPager2 view3;
            List list;
            ImageView view2;
            int i2;
            ImageView view;
            super.onPageSelected(i);
            if (i < this.b.size()) {
                this.c.s1((WelcomeSlide)this.b.get(i).getTrackingTag());
                num = this.a;
                this.a = Integer.valueOf(g.e(i, this.b.size()));
                size = this.d;
                super(num, size, this.b, this.e, i, this.f);
                size.postDelayed(iVar, 100);
            }
        }
    }

    @Metadata(d1 = "\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0003*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0008\u0010\u0008\u001a\u00020\u0003H\u0016J\u001a\u0010\t\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0008\u0010\u000f\u001a\u00020\u0003H\u0016J\u0012\u0010\u0010\u001a\u00020\u00032\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0016¨\u0006\u0011", d2 = {"app/dogo/com/dogo_android/welcome_v2/OnboardingBindingAdapters$setOnboardingSurveyAdapter$1$1", "Lcom/yuyakaido/android/cardstackview/CardStackListener;", "onCardAppeared", "", "view", "Landroid/view/View;", "position", "", "onCardCanceled", "onCardDisappeared", "onCardDragging", "direction", "Lcom/yuyakaido/android/cardstackview/Direction;", "ratio", "", "onCardRewound", "onCardSwiped", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c implements a {

        final List<SurveyQuestion> b;
        final View c;
        c(List<SurveyQuestion> list, View view2) {
            this.b = list;
            this.c = view2;
            super();
        }

        @Override // com.yuyakaido.android.cardstackview.a
        public void a(View view, int i2) {
            View obj1;
            int obj2;
            if (i2 >= obj1 += -3) {
                this.c.setVisibility(8);
            } else {
                this.c.setVisibility(0);
            }
        }

        @Override // com.yuyakaido.android.cardstackview.a
        public void b() {
        }

        @Override // com.yuyakaido.android.cardstackview.a
        public void c(b b) {
        }

        @Override // com.yuyakaido.android.cardstackview.a
        public void d(b b, float f2) {
        }

        @Override // com.yuyakaido.android.cardstackview.a
        public void e(View view, int i2) {
        }

        @Override // com.yuyakaido.android.cardstackview.a
        public void f() {
        }
    }

    @Metadata(d1 = "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0008", d2 = {"app/dogo/com/dogo_android/welcome_v2/OnboardingBindingAdapters$setOnboardingSurveyAdapter$1$3", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d extends RecyclerView.u {

        final View a;
        d(View view) {
            this.a = view;
            super();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$u
        public void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            View obj2;
            int obj3;
            n.f(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0) {
                this.a.setVisibility(8);
            } else {
                this.a.setVisibility(0);
            }
        }
    }

    @Metadata(d1 = "\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016J\u0008\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005", d2 = {"app/dogo/com/dogo_android/welcome_v2/OnboardingBindingAdapters$setOnboardingSurveyAdapter$1$swipeCallback$1", "Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$SwipeCallback;", "swipeCardLeft", "", "swipeCardRight", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class e implements app.dogo.com.dogo_android.welcome_v2.c0.e {

        final CardStackView a;
        e(CardStackView cardStackView) {
            this.a = cardStackView;
            super();
        }

        @Override // app.dogo.com.dogo_android.welcome_v2.c0$e
        public void a() {
            d0.a(d0.a, b.Left, this.a);
        }

        @Override // app.dogo.com.dogo_android.welcome_v2.c0$e
        public void b() {
            d0.a(d0.a, b.Right, this.a);
        }
    }
    static {
        d0 d0Var = new d0();
        d0.a = d0Var;
    }

    public static final void a(app.dogo.com.dogo_android.welcome_v2.d0 d0, b b2, CardStackView cardStackView3) {
        d0.i(b2, cardStackView3);
    }

    public static void b(ViewPager2 viewPager2, List list2) {
        d0.g(viewPager2, list2);
    }

    public static void c(TabLayout.g tabLayout$g, int i2) {
        d0.f(g, i2);
    }

    public static final void d(TextInputEditText textInputEditText, Button button2) {
        int i2;
        int i;
        n.f(textInputEditText, "<this>");
        n.f(button2, "button");
        i2 = String.valueOf(textInputEditText.getText()).length() == 0 ? 1 : 0;
        if (i2 != 0) {
            button2.setAlpha(1056964608);
        } else {
            button2.setAlpha(1065353216);
        }
        d0.a aVar = new d0.a(button2);
        textInputEditText.addTextChangedListener(aVar);
    }

    public static final void e(ViewPager2 viewPager2, TabLayout tabLayout2, b b3, ImageView imageView4, ImageView imageView5, List<WelcomeSlide> list6) {
        Object dVar;
        app.dogo.com.dogo_android.welcome_v2.h hVar;
        app.dogo.com.dogo_android.welcome_v2.d0.b bVar2;
        List list;
        b bVar;
        Object obj3;
        Object obj2;
        Object obj;
        Object obj9;
        b obj10;
        n.f(viewPager2, "<this>");
        n.f(tabLayout2, "tabLayout");
        n.f(imageView4, "backgroundTopImageView");
        n.f(imageView5, "backgroundBottomImageView");
        if (b3 != null && list6 != null && viewPager2.getAdapter() == null) {
            if (list6 != null) {
                if (viewPager2.getAdapter() == null) {
                    h0 h0Var = new h0(list6, b3);
                    viewPager2.setAdapter(h0Var);
                    dVar = new d(tabLayout2, viewPager2, h.a);
                    dVar.a();
                    super(list6, b3, viewPager2, imageView5, imageView4);
                    viewPager2.h(obj9);
                    obj9 = new g(viewPager2, list6);
                    viewPager2.postDelayed(obj9, 50);
                }
            }
        }
    }

    private static final void f(TabLayout.g tabLayout$g, int i2) {
        n.f(g, "$noName_0");
    }

    private static final void g(ViewPager2 viewPager2, List list2) {
        n.f(viewPager2, "$this_setOnboardingDetailsTab");
        viewPager2.setCurrentItem(g.e(viewPager2.getCurrentItem(), p.i(list2)));
    }

    public static final void h(CardStackView cardStackView, y<? extends List<SurveyQuestion>> y2, app.dogo.com.dogo_android.welcome_v2.c0.a c0$a3, View view4, View view5) {
        boolean eVar;
        CardStackLayoutManager cardStackLayoutManager;
        android.content.Context context;
        app.dogo.com.dogo_android.welcome_v2.d0.c cVar;
        int obj5;
        Object obj7;
        Object obj8;
        n.f(cardStackView, "<this>");
        n.f(view4, "coverView");
        n.f(view5, "placeHolder");
        if (y2 instanceof y.c) {
        } else {
            obj5 = 0;
        }
        if (obj5 == null) {
        } else {
            obj5 = obj5.a();
            if ((List)obj5 == null) {
            } else {
                if (a3 != null) {
                    eVar = new d0.e(cardStackView);
                    cVar = new d0.c((List)obj5, view5);
                    cardStackLayoutManager = new CardStackLayoutManager(cardStackView.getContext(), cVar);
                    cardStackLayoutManager.v2(f.Top);
                    cardStackLayoutManager.A2(3);
                    cardStackLayoutManager.t2(b.HORIZONTAL);
                    cardStackLayoutManager.u2(1063675494);
                    cardStackLayoutManager.z2(1092616192);
                    cardStackLayoutManager.x2(h.Automatic);
                    obj8 = w.a;
                    cardStackView.setLayoutManager(cardStackLayoutManager);
                    obj8 = new d0.d(view4);
                    cardStackView.l(obj8);
                    obj7 = new c0(obj5, eVar, a3);
                    cardStackView.setAdapter(obj7);
                }
            }
        }
    }

    private final void i(b b, CardStackView cardStackView2) {
        g.b bVar = new g.b();
        bVar.b(b);
        bVar.c(obj3.duration);
        AccelerateInterpolator obj3 = new AccelerateInterpolator();
        bVar.d(obj3);
        androidx.recyclerview.widget.RecyclerView.p layoutManager = cardStackView2.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type com.yuyakaido.android.cardstackview.CardStackLayoutManager");
        (CardStackLayoutManager)layoutManager.w2(bVar.a());
        cardStackView2.I1();
    }
}
