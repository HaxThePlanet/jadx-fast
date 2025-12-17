package app.dogo.com.dogo_android.q;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.a;
import androidx.core.content.e.f;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.recyclerview.widget.l;
import androidx.viewpager2.widget.ViewPager2;
import app.dogo.com.dogo_android.dogcreation.j.i;
import app.dogo.com.dogo_android.dogcreation.j.i.b;
import app.dogo.com.dogo_android.h.in;
import app.dogo.com.dogo_android.h.yl;
import app.dogo.com.dogo_android.k.d;
import app.dogo.com.dogo_android.q.p.g0;
import app.dogo.com.dogo_android.q.p.v;
import app.dogo.com.dogo_android.q.q.f;
import app.dogo.com.dogo_android.q.q.f.a;
import app.dogo.com.dogo_android.q.s.b;
import app.dogo.com.dogo_android.q.s.b.b;
import app.dogo.com.dogo_android.q.s.e;
import app.dogo.com.dogo_android.repository.domain.DogBreed;
import app.dogo.com.dogo_android.repository.domain.DogOwnerInvitation;
import app.dogo.com.dogo_android.repository.domain.DogParentUIState;
import app.dogo.com.dogo_android.repository.domain.DogParentUIState.DogParent;
import app.dogo.com.dogo_android.repository.domain.DogProfile;
import app.dogo.com.dogo_android.repository.domain.DogSelectData;
import app.dogo.com.dogo_android.repository.domain.ProfilePreview;
import app.dogo.com.dogo_android.util.MyAppGlideModule;
import app.dogo.com.dogo_android.util.e0.y;
import app.dogo.com.dogo_android.util.e0.y.c;
import app.dogo.com.dogo_android.util.f0.m;
import app.dogo.com.dogo_android.util.f0.n;
import app.dogo.com.dogo_android.util.h0.i1;
import app.dogo.com.dogo_android.util.h0.j1;
import app.dogo.com.dogo_android.util.k0.e;
import app.dogo.com.dogo_android.util.n0.m;
import app.dogo.com.dogo_android.y.y.i;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.g;
import com.google.android.material.tabs.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.c.p;
import kotlin.d0.d.f0;
import kotlin.d0.d.n;
import kotlin.d0.d.p;
import kotlin.k0.l;
import kotlin.w;
import kotlin.y.p;

/* loaded from: classes.dex */
@Metadata(d1 = "\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u0008H\u0002J\u0018\u0010\t\u001a\u00020\u00082\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u00082\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0002J>\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0014\u0010\u0014\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0001\u0010\u001a\u001a\u00020\u001bH\u0007J\u001c\u0010\u001c\u001a\u00020\u0012*\u00020\u001d2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0015H\u0007J\u0016\u0010 \u001a\u00020\u0012*\u00020!2\u0008\u0010\"\u001a\u0004\u0018\u00010\u001fH\u0007J\u001c\u0010#\u001a\u00020\u0012*\u00020!2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0015H\u0007J\u001c\u0010$\u001a\u00020\u0012*\u00020!2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0015H\u0007J\u0014\u0010%\u001a\u00020\u0012*\u00020!2\u0006\u0010&\u001a\u00020'H\u0007J&\u0010(\u001a\u00020\u0012*\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010*H\u0007J \u0010+\u001a\u00020\u0012*\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010,2\u0008\u0010\u0016\u001a\u0004\u0018\u00010-H\u0007J.\u0010.\u001a\u00020\u0012*\u00020/2\u0006\u00100\u001a\u0002012\u0008\u0010\u0016\u001a\u0004\u0018\u0001022\u000e\u00103\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u0015H\u0007J\u0014\u00105\u001a\u00020\u0012*\u00020!2\u0006\u00106\u001a\u000207H\u0007J&\u00108\u001a\u00020\u0012*\u0002092\u000e\u0010:\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010-H\u0007J&\u00108\u001a\u00020\u0012*\u00020\u001d2\u000e\u00103\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u000102H\u0007J0\u0010<\u001a\u00020\u0012*\u0002092\u0008\u0010=\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010>\u001a\u00020!2\u0006\u0010?\u001a\u00020!H\u0007J&\u0010@\u001a\u00020\u0012*\u00020\u001d2\u000e\u00103\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u000102H\u0007JV\u0010A\u001a\u00020\u0012*\u00020B2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00152\u0006\u0010C\u001a\u00020!2\u0006\u0010D\u001a\u00020\u001d2\u0008\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020\u001d2\u0006\u0010H\u001a\u0002092\u0006\u0010I\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020\u001dH\u0007J\u0016\u0010K\u001a\u00020\u0012*\u00020\u001d2\u0008\u0010L\u001a\u0004\u0018\u00010MH\u0007J.\u0010N\u001a\u00020\u0012*\u0002092\u000e\u00103\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u00152\u0006\u0010O\u001a\u00020P2\u0008\u0010\u0016\u001a\u0004\u0018\u000102H\u0007J>\u0010Q\u001a\u00020\u0012*\u0002092\u0006\u00103\u001a\u0002042\u0006\u0010R\u001a\u00020S2\u0006\u0010?\u001a\u00020S2\u0006\u0010T\u001a\u00020S2\u0006\u0010\u000c\u001a\u00020S2\u0008\u0010\u0016\u001a\u0004\u0018\u000102H\u0007J\u001c\u0010U\u001a\u00020\u0012*\u00020!2\u000e\u00103\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u0015H\u0007J\u0014\u0010V\u001a\u00020\u0012*\u00020W2\u0006\u0010X\u001a\u00020;H\u0007¨\u0006Y", d2 = {"Lapp/dogo/com/dogo_android/profile/DogProfileBindingAdapters;", "", "()V", "dogBreedFilter", "", "Lapp/dogo/com/dogo_android/repository/domain/DogBreed;", "list", "filterText", "", "getDogGenderString", "context", "Landroid/content/Context;", "gender", "Lapp/dogo/com/dogo_android/enums/DogGender;", "getTitleName", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "setBreadSearchAdapter", "", "Landroidx/recyclerview/widget/RecyclerView;", "result", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "callback", "Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter$Callbacks;", "searchBox", "Landroid/widget/EditText;", "headerViewRes", "", "setDogInviteAvatar", "Landroid/widget/ImageView;", "dogInviteResults", "Lapp/dogo/com/dogo_android/repository/domain/DogOwnerInvitation;", "setDogInviteLoginText", "Landroid/widget/TextView;", "dogInvite", "setDogInviteName", "setDogInviteText", "setDogParentName", "dogParent", "Lapp/dogo/com/dogo_android/repository/domain/DogParentUIState$DogParent;", "setDogParents", "Lapp/dogo/com/dogo_android/repository/domain/DogParentUIState;", "Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsAdapter$DogParentsCallback;", "setDogSelectAdapter", "Lapp/dogo/com/dogo_android/repository/domain/DogSelectData;", "Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectAdapter$DogSelectCallback;", "setTabLayoutAdapter", "Landroidx/viewpager2/widget/ViewPager2;", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewCallback;", "dogProfileResults", "Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "setTrainingTime", "totalTrainingTimeSeconds", "", "setupAddNewDogCallback", "Landroid/view/View;", "userPremium", "", "setupDogProfile", "dogBreed", "title", "breed", "setupDogProfileAvatar", "setupDogProfileBar", "Landroidx/constraintlayout/widget/ConstraintLayout;", "dogNameTextView", "dogAvatarImageView", "dogBarCallback", "Lapp/dogo/com/dogo_android/util/interfaces/DogProfileBarCallback;", "clickerButton", "dogNameClickArea", "notificationButton", "contactUsButton", "setupDogProfileCreationAvatar", "avatarUri", "Landroid/net/Uri;", "setupDogProfileParticipate", "banner", "Lapp/dogo/com/dogo_android/databinding/LayoutWelcomeChallengeParticipationBinding;", "setupDogProfileProperties", "name", "Lapp/dogo/com/dogo_android/databinding/LayoutProfileDataRowBinding;", "birthday", "setupDogProfileToolbarName", "setupGenderPicker", "Landroid/widget/NumberPicker;", "fillerVariable", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class o {

    public static final app.dogo.com.dogo_android.q.o a;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final int[] a;
        static {
            int[] iArr = new int[values.length];
            iArr[d.MALE.ordinal()] = 1;
            iArr[d.FEMALE.ordinal()] = 2;
            iArr[d.OTHER.ordinal()] = 3;
            o.a.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0010", d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", "start", "", "count", "after", "onTextChanged", "before", "core-ktx_release", "androidx/core/widget/TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b implements TextWatcher {

        final RecyclerView a;
        final y b;
        public b(RecyclerView recyclerView, y y2) {
            this.a = recyclerView;
            this.b = y2;
            super();
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(java.lang.CharSequence charSequence, int i2, int i3, int i4) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(java.lang.CharSequence charSequence, int i2, int i3, int i4) {
            String str;
            List obj2;
            int obj3;
            app.dogo.com.dogo_android.q.o obj4;
            Object obj5;
            if (charSequence != null) {
                this.a.q1(0);
                if (obj3 instanceof i) {
                } else {
                    obj3 = 0;
                }
                if (obj3 == null) {
                } else {
                    obj2 = charSequence.toString();
                    Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.CharSequence");
                    obj3.j(o.a(o.a, (List)(y.c)this.b.a(), l.a1(obj2).toString()));
                }
            }
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "position", "", "<anonymous parameter 1>"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends p implements p<Integer, Integer, w> {

        final b $mAdapter;
        c(b b) {
            this.$mAdapter = b;
            super(2);
        }

        @Override // kotlin.d0.d.p
        public final void a(int i, int i2) {
            b obj2;
            if (this.$mAdapter.g(i).isCreator()) {
                this.$mAdapter.notifyItemChanged(i);
            } else {
                this.$mAdapter.removeItem(i);
            }
        }

        @Override // kotlin.d0.d.p
        public Object invoke(Object object, Object object2) {
            a((Number)object.intValue(), (Number)object2.intValue());
            return w.a;
        }
    }
    static {
        o oVar = new o();
        o.a = oVar;
    }

    private static final void A(List list, TabLayout.g tabLayout$g2, int i3) {
        n.f(list, "$tabNamesList");
        n.f(g2, "tab");
        g2.r((CharSequence)list.get(i3));
    }

    public static final void B(TextView textView, long l2) {
        n.f(textView, "<this>");
        TimeUnit sECONDS = TimeUnit.SECONDS;
        long l = (long)i5;
        f0 f0Var = f0.a;
        int i = 3;
        Object[] arr = new Object[i];
        arr[0] = Long.valueOf(sECONDS.toHours(l2));
        arr[1] = Long.valueOf(minutes %= l);
        arr[2] = Long.valueOf(obj8 %= l);
        String obj8 = String.format("%02d:%02d:%02d", Arrays.copyOf(arr, i));
        n.e(obj8, "java.lang.String.format(format, *args)");
        textView.setText(obj8);
    }

    public static final void C(View view, y<Boolean> y2, f.a f$a3) {
        app.dogo.com.dogo_android.q.a aVar;
        int obj2;
        n.f(view, "<this>");
        if (y2 instanceof y.c) {
        } else {
            obj2 = 0;
        }
        if (obj2 == null) {
        } else {
            obj2 = obj2.a();
            if ((Boolean)obj2 == null) {
            } else {
                aVar = new a(a3, (Boolean)obj2.booleanValue());
                view.setOnClickListener(aVar);
            }
        }
    }

    public static final void D(ImageView imageView, y<ProfilePreview> y2, v v3) {
        app.dogo.com.dogo_android.q.k kVar;
        int obj2;
        n.f(imageView, "<this>");
        if (y2 instanceof y.c) {
        } else {
            obj2 = 0;
        }
        if (obj2 == null) {
        } else {
            obj2 = obj2.a();
            if ((ProfilePreview)obj2 == null) {
            } else {
                kVar = new k(v3, (ProfilePreview)obj2);
                imageView.setOnClickListener(kVar);
            }
        }
    }

    private static final void E(f.a f$a, boolean z2, View view3) {
        if (a == null) {
        } else {
            a.U0(z2);
        }
    }

    private static final void F(v v, ProfilePreview profilePreview2, View view3) {
        n.f(profilePreview2, "$results");
        if (v == null) {
        } else {
            v.c0(profilePreview2);
        }
    }

    public static final void G(View view, DogBreed dogBreed2, DogProfile dogProfile3, TextView textView4, TextView textView5) {
        String str;
        String obj3;
        String obj5;
        n.f(view, "<this>");
        n.f(textView4, "title");
        n.f(textView5, "breed");
        Object[] arr = new Object[1];
        if (dogProfile3 == null) {
            obj5 = str;
        } else {
        }
        textView4.setText(view.getResources().getString(2131886455, obj5));
        if (dogBreed2 == null) {
        } else {
            obj3 = dogBreed2.getName();
            if (obj3 == null) {
            } else {
                str = obj3;
            }
        }
        textView5.setText(str);
    }

    public static final void H(ImageView imageView, y<ProfilePreview> y2, v v3) {
        int context;
        String str;
        int obj4;
        n.f(imageView, "<this>");
        final int i = 0;
        if (y2 instanceof y.c) {
        } else {
            obj4 = i;
        }
        if (obj4 == null) {
        } else {
            obj4 = obj4.a();
            if ((ProfilePreview)obj4 == null) {
            } else {
                context = imageView.getContext();
                n.e(context, "context");
                obj4 = i1.d(context, (ProfilePreview)obj4.getDogProfile().getId(), "avatar.jpg");
                if (obj4 != null) {
                    MyAppGlideModule.e(obj4, imageView);
                } else {
                    imageView.setImageDrawable(f.f(imageView.getResources(), 2131231265, i));
                }
                obj4 = new f(v3);
                imageView.setOnClickListener(obj4);
            }
        }
    }

    private static final void I(v v, View view2) {
        if (v == null) {
        } else {
            v.z();
        }
    }

    public static final void J(ConstraintLayout constraintLayout, y<DogProfile> y2, TextView textView3, ImageView imageView4, e e5, ImageView imageView6, View view7, ImageView imageView8, ImageView imageView9) {
        app.dogo.com.dogo_android.q.o oVar;
        String str3;
        String str2;
        String str;
        Object obj4;
        int obj5;
        n.f(constraintLayout, "<this>");
        n.f(textView3, "dogNameTextView");
        n.f(imageView4, "dogAvatarImageView");
        n.f(imageView6, "clickerButton");
        n.f(view7, "dogNameClickArea");
        n.f(imageView8, "notificationButton");
        n.f(imageView9, "contactUsButton");
        if (y2 instanceof y.c) {
        } else {
            obj5 = 0;
        }
        if (obj5 == null) {
        } else {
            obj5 = obj5.a();
            if ((DogProfile)obj5 == null) {
            } else {
                Context context = constraintLayout.getContext();
                str3 = "context";
                n.e(context, str3);
                m.a(imageView4, i1.d(context, (DogProfile)obj5.getId(), "avatar.jpg"));
                obj4 = constraintLayout.getContext();
                n.e(obj4, str3);
                textView3.setText(o.a.d(obj5, obj4));
                obj4 = new g(obj5, e5);
                imageView4.setOnClickListener(obj4);
                obj4 = new j(obj5, e5);
                view7.setOnClickListener(obj4);
                obj4 = new n(e5);
                imageView6.setOnClickListener(obj4);
                obj4 = new d(e5);
                imageView9.setOnClickListener(obj4);
                obj4 = new c(e5);
                imageView8.setOnClickListener(obj4);
            }
        }
    }

    private static final void K(DogProfile dogProfile, e e2, View view3) {
        n.f(dogProfile, "$dog");
        if (dogProfile.dogOnlyHasName() != null) {
            if (e2 == null) {
            } else {
                e2.o(dogProfile);
            }
        } else {
            if (e2 == null) {
            } else {
                e2.B0(dogProfile);
            }
        }
    }

    private static final void L(DogProfile dogProfile, e e2, View view3) {
        n.f(dogProfile, "$dog");
        if (l.z(dogProfile.getName()) != null) {
            if (e2 == null) {
            } else {
                e2.r0(dogProfile);
            }
        } else {
            if (e2 == null) {
            } else {
                e2.b0();
            }
        }
    }

    private static final void M(e e, View view2) {
        if (e == null) {
        } else {
            e.V0();
        }
    }

    private static final void N(e e, View view2) {
        if (e == null) {
        } else {
            e.g0();
        }
    }

    private static final void O(e e, View view2) {
        if (e == null) {
        } else {
            e.s();
        }
    }

    public static final void P(ImageView imageView, Uri uri2) {
        String str;
        int i;
        Object obj3;
        n.f(imageView, "<this>");
        if (uri2 != null) {
            MyAppGlideModule.e(uri2, imageView);
        } else {
            imageView.setImageDrawable(f.f(imageView.getResources(), 2131231265, 0));
        }
    }

    public static final void Q(View view, y<ProfilePreview> y2, in in3, v v4) {
        int i;
        View view2;
        Object obj2;
        Object obj3;
        Object obj4;
        n.f(view, "<this>");
        n.f(in3, "banner");
        if (y2 instanceof y.c) {
            if ((ProfilePreview)y2.a().isParticipateBannerVisible() != null) {
                i = 0;
            }
            in3.w().setVisibility(i);
            obj4 = new h(v4, (ProfilePreview)(y.c)y2.a().getDogProfile());
            in3.O.setOnClickListener(obj4);
        } else {
            in3.w().setVisibility(8);
        }
    }

    private static final void R(v v, DogProfile dogProfile2, View view3) {
        n.f(dogProfile2, "$dogProfile");
        if (v == null) {
        } else {
            v.t1(dogProfile2);
        }
    }

    public static final void S(View view, ProfilePreview profilePreview2, yl yl3, yl yl4, yl yl5, yl yl6, v v7) {
        n.f(view, "<this>");
        n.f(profilePreview2, "dogProfileResults");
        n.f(yl3, "name");
        n.f(yl4, "breed");
        n.f(yl5, "birthday");
        n.f(yl6, "gender");
        final DogProfile obj4 = profilePreview2.getDogProfile();
        final Resources resources = view.getResources();
        n.e(resources, "resources");
        yl3.T(j1.W0(obj4.getName(), resources));
        b bVar = new b(v7, obj4);
        yl3.w().setOnClickListener(bVar);
        yl4.T(j1.w(obj4));
        m obj6 = new m(v7, obj4);
        yl4.w().setOnClickListener(obj6);
        yl5.T(j1.v(obj4));
        obj6 = new i(v7, obj4);
        yl5.w().setOnClickListener(obj6);
        Context obj3 = view.getContext();
        n.e(obj3, "context");
        yl6.T(o.a.c(obj3, obj4.getGender()));
        e obj5 = new e(v7, obj4);
        yl6.w().setOnClickListener(obj5);
    }

    private static final void T(v v, DogProfile dogProfile2, View view3) {
        n.f(dogProfile2, "$dogProfile");
        if (v == null) {
        } else {
            v.D0(dogProfile2);
        }
    }

    private static final void U(v v, DogProfile dogProfile2, View view3) {
        n.f(dogProfile2, "$dogProfile");
        if (v == null) {
        } else {
            v.I0(dogProfile2);
        }
    }

    private static final void V(v v, DogProfile dogProfile2, View view3) {
        n.f(dogProfile2, "$dogProfile");
        if (v == null) {
        } else {
            v.J(dogProfile2);
        }
    }

    private static final void W(v v, DogProfile dogProfile2, View view3) {
        n.f(dogProfile2, "$dogProfile");
        if (v == null) {
        } else {
            v.Z0(dogProfile2);
        }
    }

    public static final void X(TextView textView, y<ProfilePreview> y2) {
        Resources resources;
        String str;
        int obj3;
        n.f(textView, "<this>");
        if (y2 instanceof y.c) {
        } else {
            obj3 = 0;
        }
        if (obj3 == null) {
        } else {
            obj3 = obj3.a();
            if ((ProfilePreview)obj3 == null) {
            } else {
                resources = textView.getResources();
                n.e(resources, "resources");
                textView.setText(j1.W0((ProfilePreview)obj3.getDogProfile().getName(), resources));
            }
        }
    }

    public static final void Y(NumberPicker numberPicker, boolean z2) {
        int length;
        int i;
        String str2;
        app.dogo.com.dogo_android.q.o oVar;
        Context context;
        String str;
        n.f(numberPicker, "<this>");
        d[] obj9 = d.values();
        ArrayList arrayList = new ArrayList(obj9.length);
        final int i3 = 0;
        i = i3;
        while (i < obj9.length) {
            context = numberPicker.getContext();
            n.e(context, "context");
            arrayList.add(o.a.c(context, obj9[i]));
            i++;
        }
        obj9 = new ArrayList();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            length = iterator.next();
            if (z ^= 1 != 0) {
            }
            obj9.add(length);
        }
        numberPicker.setMaxValue(size--);
        numberPicker.setMinValue(i3);
        obj9 = obj9.toArray(new String[i3]);
        Objects.requireNonNull(obj9, "null cannot be cast to non-null type kotlin.Array<T>");
        numberPicker.setDisplayedValues((String[])obj9);
    }

    public static final List a(app.dogo.com.dogo_android.q.o o, List list2, String string3) {
        return o.b(list2, string3);
    }

    private final List<DogBreed> b(List<DogBreed> list, String string2) {
        int arrayList;
        int next;
        boolean z;
        String lowerCase;
        String str;
        List obj7;
        final int i = 1;
        arrayList = string2.length() == 0 ? i : 0;
        if (arrayList != null) {
        } else {
            arrayList = new ArrayList();
            obj7 = list.iterator();
            while (obj7.hasNext()) {
                next = obj7.next();
                String name = (DogBreed)next.getName();
                String str2 = "null cannot be cast to non-null type java.lang.String";
                Objects.requireNonNull(name, str2);
                String lowerCase2 = name.toLowerCase();
                str = "(this as java.lang.String).toLowerCase()";
                n.e(lowerCase2, str);
                Objects.requireNonNull(string2, str2);
                lowerCase = string2.toLowerCase();
                n.e(lowerCase, str);
                if (l.K(lowerCase2, lowerCase, i)) {
                }
                arrayList.add(next);
            }
            obj7 = new DogBreed(0, string2, i);
            obj7 = p.t0(p.b(obj7), arrayList);
        }
        return obj7;
    }

    private final String c(Context context, d d2) {
        int i;
        String obj2;
        String obj3;
        obj3 = o.a.a[d2.ordinal()];
        if (obj3 != 1) {
            if (obj3 != 2) {
                if (obj3 != 3) {
                    obj2 = "";
                } else {
                    n.e(context.getResources().getString(2131886671), "context.resources.getString(R.string.gender_other)");
                }
            } else {
                n.e(context.getResources().getString(2131886669), "context.resources.getString(R.string.gender_female)");
            }
        } else {
            n.e(context.getResources().getString(2131886670), "context.resources.getString(R.string.gender_male)");
        }
        return obj2;
    }

    private final String d(DogProfile dogProfile, Context context2) {
        String obj2;
        Object obj3;
        if (z ^= 1 != 0) {
            obj2 = j1.V0(dogProfile.getName(), context2);
        } else {
            n.e(context2.getString(2131886464), "context.getString(R.string.dog_edit_what_is_your_dog_name)");
        }
        return obj2;
    }

    public static void e(f.a f$a, boolean z2, View view3) {
        o.E(a, z2, view3);
    }

    public static void f(v v, DogProfile dogProfile2, View view3) {
        o.T(v, dogProfile2, view3);
    }

    public static void g(e e, View view2) {
        o.O(e, view2);
    }

    public static void h(e e, View view2) {
        o.N(e, view2);
    }

    public static void i(v v, DogProfile dogProfile2, View view3) {
        o.W(v, dogProfile2, view3);
    }

    public static void j(v v, View view2) {
        o.I(v, view2);
    }

    public static void k(DogProfile dogProfile, e e2, View view3) {
        o.K(dogProfile, e2, view3);
    }

    public static void l(v v, DogProfile dogProfile2, View view3) {
        o.R(v, dogProfile2, view3);
    }

    public static void m(v v, DogProfile dogProfile2, View view3) {
        o.V(v, dogProfile2, view3);
    }

    public static void n(DogProfile dogProfile, e e2, View view3) {
        o.L(dogProfile, e2, view3);
    }

    public static void o(v v, ProfilePreview profilePreview2, View view3) {
        o.F(v, profilePreview2, view3);
    }

    public static void p(List list, TabLayout.g tabLayout$g2, int i3) {
        o.A(list, g2, i3);
    }

    public static void q(v v, DogProfile dogProfile2, View view3) {
        o.U(v, dogProfile2, view3);
    }

    public static void r(e e, View view2) {
        o.M(e, view2);
    }

    public static final void s(RecyclerView recyclerView, y<? extends List<DogBreed>> y2, i.b i$b3, EditText editText4, int i5) {
        int iVar;
        Object obj;
        android.view.animation.Animation obj3;
        Object obj4;
        boolean obj5;
        int obj6;
        n.f(recyclerView, "<this>");
        n.f(editText4, "searchBox");
        if (y2 instanceof y.c) {
            obj6 = editText4.getText().toString();
            Objects.requireNonNull(obj6, "null cannot be cast to non-null type kotlin.CharSequence");
            iVar = new i(b3);
            iVar.j(o.a.b((List)(y.c)y2.a(), l.a1(obj6).toString()));
            obj4 = w.a;
            recyclerView.setAdapter(iVar);
            obj4 = new o.b(recyclerView, y2);
            editText4.addTextChangedListener(obj4);
        } else {
            iVar = 0;
            if (y2 instanceof y.a) {
                obj3 = new i(b3);
                obj3.j(p.g());
                obj4 = w.a;
                recyclerView.setAdapter(obj3);
                obj3 = new i(i5);
                recyclerView.i(obj3, iVar);
                obj3 = AnimationUtils.loadAnimation(recyclerView.getContext(), 2130772024);
                n.e(obj3, "loadAnimation(context, R.anim.shake)");
                recyclerView.startAnimation(obj3);
            } else {
                if (y2 instanceof y.b && recyclerView.getItemDecorationCount() > 0) {
                    if (recyclerView.getItemDecorationCount() > 0) {
                        recyclerView.e1(iVar);
                    }
                }
            }
        }
    }

    public static final void t(ImageView imageView, y<DogOwnerInvitation> y2) {
        android.graphics.drawable.Drawable str;
        int i;
        int i2;
        Object obj4;
        n.f(imageView, "<this>");
        if (y2 == null) {
            imageView.setImageDrawable(MyAppGlideModule.d(imageView.getContext()));
        } else {
            i = 0;
            if (y2 instanceof y.c) {
            } else {
                obj4 = i;
            }
            if (obj4 == null) {
            } else {
                obj4 = obj4.a();
                if ((DogOwnerInvitation)obj4 == null) {
                } else {
                    n.m0(imageView, (DogOwnerInvitation)obj4.getDogAvatar(), f.f(imageView.getResources(), 2131231085, i));
                }
            }
        }
    }

    public static final void u(TextView textView, DogOwnerInvitation dogOwnerInvitation2) {
        int i3;
        String userName;
        int i2;
        int i4;
        String resources;
        int str;
        int i;
        Object[] arr;
        String obj7;
        n.f(textView, "<this>");
        if (dogOwnerInvitation2 != null) {
            i2 = 1;
            i4 = 0;
            i3 = dogOwnerInvitation2.getUserName().length() > 0 ? i2 : i4;
            if (i3 != 0) {
                userName = dogOwnerInvitation2.getUserName();
            } else {
                n.e(textView.getResources().getString(2131886675), "resources.getString(R.string.general_anonymous)");
            }
            str = dogOwnerInvitation2.getDogName().length() > 0 ? i2 : i4;
            if (str != null) {
                obj7 = dogOwnerInvitation2.getDogName();
            } else {
                n.e(textView.getResources().getString(2131886954), "resources.getString(R.string.no_name)");
            }
            arr = new Object[2];
            arr[i4] = userName;
            arr[i2] = obj7;
            obj7 = textView.getResources().getString(2131886787, arr);
        } else {
            obj7 = textView.getResources().getString(2131886167);
        }
        textView.setText(obj7);
    }

    public static final void v(TextView textView, y<DogOwnerInvitation> y2) {
        boolean spannableString;
        int i3;
        String userName;
        int i5;
        int i;
        Object foregroundColorSpan;
        int str;
        String string;
        String str2;
        int i6;
        int i2;
        int i4;
        int i7;
        Object obj11;
        n.f(textView, "<this>");
        if (y2 instanceof y.c) {
        } else {
            obj11 = 0;
        }
        if (obj11 == null) {
        } else {
            obj11 = obj11.a();
            if ((DogOwnerInvitation)obj11 == null) {
            } else {
                int i8 = 1;
                int i9 = 0;
                i3 = (DogOwnerInvitation)obj11.getUserName().length() > 0 ? i8 : i9;
                if (i3 != 0) {
                    userName = obj11.getUserName();
                } else {
                    n.e(textView.getResources().getString(2131886675), "resources.getString(R.string.general_anonymous)");
                }
                str = obj11.getDogName().length() > 0 ? i8 : i9;
                if (str != null) {
                    obj11 = obj11.getDogName();
                } else {
                    n.e(textView.getResources().getString(2131886954), "resources.getString(R.string.no_name)");
                }
                Object[] arr = new Object[2];
                arr[i9] = userName;
                arr[i8] = obj11;
                string = textView.getResources().getString(2131886787, arr);
                n.e(string, "resources.getString(R.string.invite_owner_screen_text, parentName, dogName)");
                spannableString = new SpannableString(string);
                i5 = l.j0(string, obj11, 0, false, 6, 0);
                foregroundColorSpan = new ForegroundColorSpan(a.d(textView.getContext(), 2131100352));
                spannableString.setSpan(foregroundColorSpan, i5, obj11 += i5, 33);
                textView.setText(spannableString);
            }
        }
    }

    public static final void w(TextView textView, DogParentUIState.DogParent dogParentUIState$DogParent2) {
        int i;
        String obj2;
        n.f(textView, "<this>");
        n.f(dogParent2, "dogParent");
        i = dogParent2.getName().length() == 0 ? 1 : 0;
        if (i != 0) {
            obj2 = textView.getResources().getString(2131886954);
        } else {
            obj2 = dogParent2.getName();
        }
        textView.setText(obj2);
    }

    public static final void x(RecyclerView recyclerView, y<DogParentUIState> y2, b.b b$b3) {
        int itemDecorationCount;
        RecyclerView.h bVar;
        Object cVar;
        m mVar;
        Context context;
        RecyclerView.h obj4;
        Object obj5;
        Object obj6;
        n.f(recyclerView, "<this>");
        cVar = "context";
        if (y2 instanceof y.c && b3 != null && recyclerView.getItemDecorationCount() == 0) {
            if (b3 != null) {
                cVar = "context";
                if (recyclerView.getItemDecorationCount() == 0) {
                    context = recyclerView.getContext();
                    n.e(context, cVar);
                    mVar = new m(context, (int)dimension);
                    recyclerView.h(mVar);
                }
                if (recyclerView.getAdapter() == null) {
                    bVar = new b(b3);
                    recyclerView.setAdapter(bVar);
                    context = recyclerView.getContext();
                    n.e(context, cVar);
                    cVar = new o.c(bVar);
                    mVar = new e(context, cVar);
                    obj6 = new l(mVar);
                    obj6.g(recyclerView);
                }
                if (obj4 instanceof b) {
                } else {
                    obj4 = 0;
                }
                if (obj4 == null) {
                } else {
                    obj4.j((DogParentUIState)(y.c)y2.a().getParents());
                }
            }
        }
    }

    public static final void y(RecyclerView recyclerView, DogSelectData dogSelectData2, f.a f$a3) {
        int itemDecorationCount;
        Object fVar;
        m dogList;
        Context currentDogPosition;
        String str;
        int obj5;
        n.f(recyclerView, "<this>");
        if (dogSelectData2 != 0 && a3 != null && recyclerView.getItemDecorationCount() == 0) {
            if (a3 != null) {
                if (recyclerView.getItemDecorationCount() == 0) {
                    currentDogPosition = recyclerView.getContext();
                    n.e(currentDogPosition, "context");
                    dogList = new m(currentDogPosition, (int)dimension);
                    recyclerView.h(dogList);
                }
                fVar = new f(dogSelectData2.getDogList(), dogSelectData2.getCurrentDogPosition(), a3);
                recyclerView.setAdapter(fVar);
                recyclerView.q1(dogSelectData2.getCurrentDogPosition());
            }
        }
    }

    public static final void z(ViewPager2 viewPager2, TabLayout tabLayout2, v v3, y<ProfilePreview> y4) {
        Object obj;
        int i2;
        Object adapter;
        g0 g0Var;
        String string;
        int i;
        Object obj6;
        Object obj7;
        Object obj8;
        Object obj9;
        n.f(viewPager2, "<this>");
        n.f(tabLayout2, "tabLayout");
        if (y4 instanceof y.c) {
            obj = y4;
        } else {
            obj = i2;
        }
        if (obj == null) {
        } else {
            obj = obj.a();
            if ((ProfilePreview)obj == null) {
            } else {
                if (v3 != null && viewPager2.getAdapter() == null) {
                    if (viewPager2.getAdapter() == null) {
                        String[] strArr = new String[2];
                        g0Var = new g0(v3, (ProfilePreview)(y.c)y4.a());
                        viewPager2.setAdapter(g0Var);
                        obj9 = new l(p.j(viewPager2.getResources().getString(2131887112), viewPager2.getResources().getString(2131887125)));
                        obj8 = new d(tabLayout2, viewPager2, obj9);
                        obj8.a();
                    }
                }
                obj6 = viewPager2.getAdapter();
                if (obj6 instanceof g0) {
                    i2 = obj6;
                }
                if (i2 == 0) {
                } else {
                    i2.h((ProfilePreview)obj);
                }
            }
        }
    }
}
