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
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.u;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2.i;
import app.dogo.com.dogo_android.repository.domain.SurveyQuestion;
import app.dogo.com.dogo_android.repository.domain.WelcomeSlide;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.m;
import app.dogo.com.dogo_android.util.o;
import com.bumptech.glide.j;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.g;
import com.google.android.material.textfield.TextInputEditText;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.c;
import com.yuyakaido.android.cardstackview.g.b;
import com.yuyakaido.android.cardstackview.h;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.d0.d.n;
import kotlin.h0.g;
import kotlin.w;

/* compiled from: OnboardingBindingAdapters.kt */
@Metadata(d1 = "\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0008H\u0002J\u0014\u0010\t\u001a\u00020\u0004*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u000cH\u0007J>\u0010\r\u001a\u00020\u0004*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0017H\u0007J<\u0010\u0019\u001a\u00020\u0004*\u00020\u00082\u0014\u0010\u001a\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u001c0\u0017\u0018\u00010\u001b2\u0008\u0010\u0011\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0007¨\u0006!", d2 = {"Lapp/dogo/com/dogo_android/welcome_v2/OnboardingBindingAdapters;", "", "()V", "simpleCardSwipe", "", "direction", "Lcom/yuyakaido/android/cardstackview/Direction;", "cardStackView", "Lcom/yuyakaido/android/cardstackview/CardStackView;", "setDogNameButtonAlpha", "Lcom/google/android/material/textfield/TextInputEditText;", "button", "Landroid/widget/Button;", "setOnboardingDetailsTab", "Landroidx/viewpager2/widget/ViewPager2;", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "callback", "Lapp/dogo/com/dogo_android/util/listeners/ViewPagerListener;", "backgroundTopImageView", "Landroid/widget/ImageView;", "backgroundBottomImageView", "onboardingSlides", "", "Lapp/dogo/com/dogo_android/repository/domain/WelcomeSlide;", "setOnboardingSurveyAdapter", "result", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "Lapp/dogo/com/dogo_android/repository/domain/SurveyQuestion;", "Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$AnswerSelectCallback;", "coverView", "Landroid/view/View;", "placeHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: d0, reason: from kotlin metadata */
public final class OnboardingBindingAdapters {

    public static final d0 a = new d0();

    @Metadata(d1 = "\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\nH\u0016¨\u0006\u000e", d2 = {"app/dogo/com/dogo_android/welcome_v2/OnboardingBindingAdapters$setDogNameButtonAlpha$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "text", "Landroid/text/Editable;", "beforeTextChanged", "p0", "", "p1", "", "p2", "p3", "onTextChanged", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class a implements TextWatcher {

        final /* synthetic */ Button a;
        a(Button button) {
            this.a = button;
            super();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable text) {
            int i = 1;
            int i2 = 1056964608;
            i = 1;
            i = 0;
            int r1 = i;
            text = i != 0 ? 1056964608 : 1065353216;
            this.a.setAlpha((i != 0 ? 1056964608 : 1065353216));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(java.lang.CharSequence p0, int p1, int p2, int p3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(java.lang.CharSequence p0, int p1, int p2, int p3) {
        }
    }

    @Metadata(d1 = "\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0002\n\u0002\u0010\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0003H\u0016J\u0010\u0010\u0008\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0003H\u0016R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0004¨\u0006\n", d2 = {"app/dogo/com/dogo_android/welcome_v2/OnboardingBindingAdapters$setOnboardingDetailsTab$1", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "fromPosition", "", "Ljava/lang/Integer;", "onPageScrollStateChanged", "", "state", "onPageSelected", "position", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b extends ViewPager2.i {

        /* renamed from: a, reason: from kotlin metadata */
        private Integer fromPosition;
        final /* synthetic */ List<WelcomeSlide> b;
        final /* synthetic */ app.dogo.com.dogo_android.util.l0.b c;
        final /* synthetic */ ViewPager2 d;
        final /* synthetic */ ImageView e;
        final /* synthetic */ ImageView f;
        b(List<WelcomeSlide> list, app.dogo.com.dogo_android.util.l0.b bVar, ViewPager2 viewPager2, ImageView imageView, ImageView imageView2) {
            this.b = list;
            this.c = bVar;
            this.d = viewPager2;
            this.e = imageView;
            this.f = imageView2;
            super();
        }

        private static final void b(Integer integer, ViewPager2 viewPager2, List list, ImageView imageView, int i, ImageView imageView2) {
            n.f(viewPager2, "$this_setOnboardingDetailsTab");
            n.f(imageView, "$backgroundBottomImageView");
            n.f(imageView2, "$backgroundTopImageView");
            android.content.res.Resources.Theme theme = null;
            if (integer != null) {
                try {
                    imageView.setImageDrawable(f.f(viewPager2.getResources(), (WelcomeSlide)list.get(integer.intValue()).getImageRes(), theme));
                    m.a(viewPager2.getContext()).z(f.f(viewPager2.getResources(), (WelcomeSlide)list.get(i).getImageRes(), theme)).y1(d.h()).C0(imageView2);
                } catch (Exception e) {
                    a.d(e);
                }
                return;
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageScrollStateChanged(int state) {
            super.onPageScrollStateChanged(state);
            if (state == 0) {
                if (this.d.getCurrentItem() > p.i(this.b)) {
                    this.c.p();
                }
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2$i
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            if (position < this.b.size()) {
                this.c.s1((WelcomeSlide)this.b.get(position).getTrackingTag());
                this.fromPosition = Integer.valueOf(g.e(position, this.b.size()));
                kotlinx.coroutines.i iVar = new kotlinx.coroutines.i(fromPosition2, viewPager2, this.b, this.e, position, this.f);
                long l = 100L;
                this.d.postDelayed(iVar, l);
            }
        }

        public static /* synthetic */ void a(Integer integer, ViewPager2 viewPager2, List list, ImageView imageView, int i, ImageView imageView2) {
            OnboardingBindingAdapters_setOnboardingDetailsTab_1.b(integer, viewPager2, list, imageView, i, imageView2);
        }
    }

    @Metadata(d1 = "\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\u0008\u0003*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0008\u0010\u0008\u001a\u00020\u0003H\u0016J\u001a\u0010\t\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\n\u001a\u00020\u00032\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000c2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0008\u0010\u000f\u001a\u00020\u0003H\u0016J\u0012\u0010\u0010\u001a\u00020\u00032\u0008\u0010\u000b\u001a\u0004\u0018\u00010\u000cH\u0016¨\u0006\u0011", d2 = {"app/dogo/com/dogo_android/welcome_v2/OnboardingBindingAdapters$setOnboardingSurveyAdapter$1$1", "Lcom/yuyakaido/android/cardstackview/CardStackListener;", "onCardAppeared", "", "view", "Landroid/view/View;", "position", "", "onCardCanceled", "onCardDisappeared", "onCardDragging", "direction", "Lcom/yuyakaido/android/cardstackview/Direction;", "ratio", "", "onCardRewound", "onCardSwiped", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c implements com.yuyakaido.android.cardstackview.a {

        final /* synthetic */ List<SurveyQuestion> b;
        final /* synthetic */ View c;
        c(List<SurveyQuestion> list, View view) {
            this.b = list;
            this.c = view;
            super();
        }

        /* renamed from: a, reason: from kotlin metadata */
        public void onCardAppeared(View view, int position) {
            if (position >= this.b.size() - 3) {
                int i = 8;
                this.c.setVisibility(i);
            } else {
                i = 0;
                this.c.setVisibility(i);
            }
        }

        /* renamed from: b, reason: from kotlin metadata */
        public void onCardCanceled() {
        }

        /* renamed from: c, reason: from kotlin metadata */
        public void onCardSwiped(com.yuyakaido.android.cardstackview.b direction) {
        }

        /* renamed from: d, reason: from kotlin metadata */
        public void onCardDisappeared(com.yuyakaido.android.cardstackview.b view, float position) {
        }

        /* renamed from: e, reason: from kotlin metadata */
        public void onCardDragging(View direction, int ratio) {
        }

        public void f() {
        }
    }

    @Metadata(d1 = "\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\u0008", d2 = {"app/dogo/com/dogo_android/welcome_v2/OnboardingBindingAdapters$setOnboardingSurveyAdapter$1$3", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class d extends RecyclerView.u {

        final /* synthetic */ View a;
        d(View view) {
            this.a = view;
            super();
        }

        @Override // androidx.recyclerview.widget.RecyclerView$u
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            n.f(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                int i = 8;
                this.a.setVisibility(i);
            } else {
                i = 0;
                this.a.setVisibility(i);
            }
        }
    }

    @Metadata(d1 = "\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0008\u0002*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0008\u0010\u0002\u001a\u00020\u0003H\u0016J\u0008\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005", d2 = {"app/dogo/com/dogo_android/welcome_v2/OnboardingBindingAdapters$setOnboardingSurveyAdapter$1$swipeCallback$1", "Lapp/dogo/com/dogo_android/welcome_v2/CardStackAdapter$SwipeCallback;", "swipeCardLeft", "", "swipeCardRight", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class e implements c0.e {

        final /* synthetic */ CardStackView a;
        e(CardStackView cardStackView) {
            this.a = cardStackView;
            super();
        }

        /* renamed from: a, reason: from kotlin metadata */
        public void swipeCardLeft() {
            OnboardingBindingAdapters.a.i(b.Left, this.a);
        }

        public void b() {
            OnboardingBindingAdapters.a.i(b.Right, this.a);
        }
    }
    private d0() {
        super();
    }

    public static final /* synthetic */ void a(d0 d0Var, com.yuyakaido.android.cardstackview.b bVar, CardStackView cardStackView) {
        d0Var.i(bVar, cardStackView);
    }

    public static final void d(TextInputEditText textInputEditText, Button button) {
        int i = 1;
        n.f(textInputEditText, "<this>");
        n.f(button, "button");
        int r0 = String.valueOf(textInputEditText.getText()).length() == 0 ? 1 : 0;
        if (i != 0) {
            float f = 0.5f;
            button.setAlpha(f);
        } else {
            f = 1f;
            button.setAlpha(f);
        }
        textInputEditText.addTextChangedListener(new OnboardingBindingAdapters_setDogNameButtonAlpha_1(button));
    }

    public static final void e(ViewPager2 viewPager2, TabLayout tabLayout, app.dogo.com.dogo_android.util.l0.b bVar, ImageView imageView, ImageView imageView2, List<WelcomeSlide> list) {
        n.f(viewPager2, "<this>");
        n.f(tabLayout, "tabLayout");
        n.f(imageView, "backgroundTopImageView");
        str = "backgroundBottomImageView";
        n.f(imageView2, str);
        if (bVar != null && list != null && viewPager2.getAdapter() == null) {
            viewPager2.setAdapter(new OnboardingPagerAdapter(list, bVar));
            new d(tabLayout, viewPager2, kotlinx.coroutines.h.a).a();
            OnboardingBindingAdapters_setOnboardingDetailsTab_1 tabLayout22 = new OnboardingBindingAdapters_setOnboardingDetailsTab_1(list, bVar, viewPager2, imageView2, imageView);
            viewPager2.h(tabLayout22);
            long l = 50L;
            viewPager2.postDelayed(new kotlinx.coroutines.g(viewPager2, list), l);
        }
    }

    private static final void g(ViewPager2 viewPager2, List list) {
        n.f(viewPager2, "$this_setOnboardingDetailsTab");
        viewPager2.setCurrentItem(g.e(viewPager2.getCurrentItem(), p.i(list)));
    }

    /* renamed from: h, reason: from kotlin metadata */
    public static final void setOnboardingDetailsTab(CardStackView tabLayout, y<? extends List<SurveyQuestion>> callback, c0.a backgroundTopImageView, View backgroundBottomImageView, View onboardingSlides) {
        int i = 0;
        n.f(tabLayout, "<this>");
        n.f(backgroundBottomImageView, "coverView");
        n.f(onboardingSlides, "placeHolder");
        z = callback instanceof LoadResult_Success;
        callback = callback instanceof oadResult_Success ? (oadResult_Success)callback : 0;
        if (i != 0) {
            Object component1 = i.component1();
            if (component1 != null) {
                if (backgroundTopImageView != null) {
                    CardStackLayoutManager cardStackLayoutManager = new CardStackLayoutManager(tabLayout.getContext(), new OnboardingBindingAdapters_setOnboardingSurveyAdapter_1_1(component1, onboardingSlides));
                    cardStackLayoutManager.v2(f.Top);
                    cardStackLayoutManager.A2(3);
                    cardStackLayoutManager.t2(b.HORIZONTAL);
                    cardStackLayoutManager.u2(0.9f);
                    cardStackLayoutManager.z2(10f);
                    cardStackLayoutManager.x2(h.Automatic);
                    tabLayout.setLayoutManager(cardStackLayoutManager);
                    tabLayout.l(new OnboardingBindingAdapters_setOnboardingSurveyAdapter_1_3(backgroundBottomImageView));
                    tabLayout.setAdapter(new CardStackAdapter(component1, new OnboardingBindingAdapters_setOnboardingSurveyAdapter_1_swipeCallback_1(tabLayout), backgroundTopImageView));
                }
            }
        }
    }

    private final void i(com.yuyakaido.android.cardstackview.b bVar, CardStackView cardStackView) {
        g.b bVar2 = new g.b();
        bVar2.b(bVar);
        bVar2.c(c.Slow.duration);
        bVar2.d(new AccelerateInterpolator());
        androidx.recyclerview.widget.RecyclerView.p layoutManager = cardStackView.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type com.yuyakaido.android.cardstackview.CardStackLayoutManager");
        layoutManager.w2(bVar2.a());
        cardStackView.I1();
    }


    /* renamed from: b, reason: from kotlin metadata */
    public static /* synthetic */ void simpleCardSwipe(ViewPager2 direction, List cardStackView) {
        OnboardingBindingAdapters.g(direction, cardStackView);
    }

    public static /* synthetic */ void c(TabLayout.g gVar, int i) {
        OnboardingBindingAdapters.f(gVar, i);
    }

    private static final void f(TabLayout.g gVar, int i) {
        n.f(gVar, "$noName_0");
    }
}
