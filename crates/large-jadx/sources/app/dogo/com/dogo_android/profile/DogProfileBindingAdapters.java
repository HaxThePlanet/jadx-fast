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
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.h;
import androidx.viewpager2.widget.ViewPager2;
import app.dogo.com.dogo_android.dogcreation.j.i.b;
import app.dogo.com.dogo_android.h.in;
import app.dogo.com.dogo_android.h.yl;
import app.dogo.com.dogo_android.q.p.g0;
import app.dogo.com.dogo_android.q.p.v;
import app.dogo.com.dogo_android.q.q.f.a;
import app.dogo.com.dogo_android.q.s.b;
import app.dogo.com.dogo_android.q.s.b.b;
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
import app.dogo.com.dogo_android.util.h0.i1;
import app.dogo.com.dogo_android.util.h0.j1;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.d0.d.f0;
import kotlin.w;

/* compiled from: DogProfileBindingAdapters.kt */
@Metadata(d1 = "\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\u000e\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0006\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0018\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u0002\u0008Æ\u0002\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u000c\u0010\u0006\u001a\u0008\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\u0008H\u0002J\u0018\u0010\t\u001a\u00020\u00082\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000c\u001a\u00020\rH\u0002J\u0018\u0010\u000e\u001a\u00020\u00082\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0002J>\u0010\u0011\u001a\u00020\u0012*\u00020\u00132\u0014\u0010\u0014\u001a\u0010\u0012\n\u0012\u0008\u0012\u0004\u0012\u00020\u00050\u0004\u0018\u00010\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0008\u0008\u0001\u0010\u001a\u001a\u00020\u001bH\u0007J\u001c\u0010\u001c\u001a\u00020\u0012*\u00020\u001d2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0015H\u0007J\u0016\u0010 \u001a\u00020\u0012*\u00020!2\u0008\u0010\"\u001a\u0004\u0018\u00010\u001fH\u0007J\u001c\u0010#\u001a\u00020\u0012*\u00020!2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0015H\u0007J\u001c\u0010$\u001a\u00020\u0012*\u00020!2\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u0015H\u0007J\u0014\u0010%\u001a\u00020\u0012*\u00020!2\u0006\u0010&\u001a\u00020'H\u0007J&\u0010(\u001a\u00020\u0012*\u00020\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010*H\u0007J \u0010+\u001a\u00020\u0012*\u00020\u00132\u0008\u0010\u0014\u001a\u0004\u0018\u00010,2\u0008\u0010\u0016\u001a\u0004\u0018\u00010-H\u0007J.\u0010.\u001a\u00020\u0012*\u00020/2\u0006\u00100\u001a\u0002012\u0008\u0010\u0016\u001a\u0004\u0018\u0001022\u000e\u00103\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u0015H\u0007J\u0014\u00105\u001a\u00020\u0012*\u00020!2\u0006\u00106\u001a\u000207H\u0007J&\u00108\u001a\u00020\u0012*\u0002092\u000e\u0010:\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u00010-H\u0007J&\u00108\u001a\u00020\u0012*\u00020\u001d2\u000e\u00103\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u000102H\u0007J0\u0010<\u001a\u00020\u0012*\u0002092\u0008\u0010=\u001a\u0004\u0018\u00010\u00052\u0008\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010>\u001a\u00020!2\u0006\u0010?\u001a\u00020!H\u0007J&\u0010@\u001a\u00020\u0012*\u00020\u001d2\u000e\u00103\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u00152\u0008\u0010\u0016\u001a\u0004\u0018\u000102H\u0007JV\u0010A\u001a\u00020\u0012*\u00020B2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00152\u0006\u0010C\u001a\u00020!2\u0006\u0010D\u001a\u00020\u001d2\u0008\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010G\u001a\u00020\u001d2\u0006\u0010H\u001a\u0002092\u0006\u0010I\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020\u001dH\u0007J\u0016\u0010K\u001a\u00020\u0012*\u00020\u001d2\u0008\u0010L\u001a\u0004\u0018\u00010MH\u0007J.\u0010N\u001a\u00020\u0012*\u0002092\u000e\u00103\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u00152\u0006\u0010O\u001a\u00020P2\u0008\u0010\u0016\u001a\u0004\u0018\u000102H\u0007J>\u0010Q\u001a\u00020\u0012*\u0002092\u0006\u00103\u001a\u0002042\u0006\u0010R\u001a\u00020S2\u0006\u0010?\u001a\u00020S2\u0006\u0010T\u001a\u00020S2\u0006\u0010\u000c\u001a\u00020S2\u0008\u0010\u0016\u001a\u0004\u0018\u000102H\u0007J\u001c\u0010U\u001a\u00020\u0012*\u00020!2\u000e\u00103\u001a\n\u0012\u0004\u0012\u000204\u0018\u00010\u0015H\u0007J\u0014\u0010V\u001a\u00020\u0012*\u00020W2\u0006\u0010X\u001a\u00020;H\u0007¨\u0006Y", d2 = {"Lapp/dogo/com/dogo_android/profile/DogProfileBindingAdapters;", "", "()V", "dogBreedFilter", "", "Lapp/dogo/com/dogo_android/repository/domain/DogBreed;", "list", "filterText", "", "getDogGenderString", "context", "Landroid/content/Context;", "gender", "Lapp/dogo/com/dogo_android/enums/DogGender;", "getTitleName", "dogProfile", "Lapp/dogo/com/dogo_android/repository/domain/DogProfile;", "setBreadSearchAdapter", "", "Landroidx/recyclerview/widget/RecyclerView;", "result", "Lapp/dogo/com/dogo_android/util/base_classes/LoadResult;", "callback", "Lapp/dogo/com/dogo_android/dogcreation/breed/BreedSearchListAdapter$Callbacks;", "searchBox", "Landroid/widget/EditText;", "headerViewRes", "", "setDogInviteAvatar", "Landroid/widget/ImageView;", "dogInviteResults", "Lapp/dogo/com/dogo_android/repository/domain/DogOwnerInvitation;", "setDogInviteLoginText", "Landroid/widget/TextView;", "dogInvite", "setDogInviteName", "setDogInviteText", "setDogParentName", "dogParent", "Lapp/dogo/com/dogo_android/repository/domain/DogParentUIState$DogParent;", "setDogParents", "Lapp/dogo/com/dogo_android/repository/domain/DogParentUIState;", "Lapp/dogo/com/dogo_android/profile/ownerList/DogParentsAdapter$DogParentsCallback;", "setDogSelectAdapter", "Lapp/dogo/com/dogo_android/repository/domain/DogSelectData;", "Lapp/dogo/com/dogo_android/profile/dogselect/DogSelectAdapter$DogSelectCallback;", "setTabLayoutAdapter", "Landroidx/viewpager2/widget/ViewPager2;", "tabLayout", "Lcom/google/android/material/tabs/TabLayout;", "Lapp/dogo/com/dogo_android/profile/dogprofile/DogPreviewCallback;", "dogProfileResults", "Lapp/dogo/com/dogo_android/repository/domain/ProfilePreview;", "setTrainingTime", "totalTrainingTimeSeconds", "", "setupAddNewDogCallback", "Landroid/view/View;", "userPremium", "", "setupDogProfile", "dogBreed", "title", "breed", "setupDogProfileAvatar", "setupDogProfileBar", "Landroidx/constraintlayout/widget/ConstraintLayout;", "dogNameTextView", "dogAvatarImageView", "dogBarCallback", "Lapp/dogo/com/dogo_android/util/interfaces/DogProfileBarCallback;", "clickerButton", "dogNameClickArea", "notificationButton", "contactUsButton", "setupDogProfileCreationAvatar", "avatarUri", "Landroid/net/Uri;", "setupDogProfileParticipate", "banner", "Lapp/dogo/com/dogo_android/databinding/LayoutWelcomeChallengeParticipationBinding;", "setupDogProfileProperties", "name", "Lapp/dogo/com/dogo_android/databinding/LayoutProfileDataRowBinding;", "birthday", "setupDogProfileToolbarName", "setupGenderPicker", "Landroid/widget/NumberPicker;", "fillerVariable", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: o, reason: from kotlin metadata */
public final class DogProfileBindingAdapters {

    public static final o a = new o();

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class a {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[DogGender.values().length];
            iArr[DogGender.MALE.ordinal()] = 1;
            iArr[DogGender.FEMALE.ordinal()] = 2;
            iArr[DogGender.OTHER.ordinal()] = 3;
            app.dogo.com.dogo_android.profile.o.a.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\u0006*\u0001\u0000\u0008\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\u0008\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000c\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\u0008\u0010\u0007\u001a\u0004\u0018\u00010\u00082\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0010", d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", "start", "", "count", "after", "onTextChanged", "before", "core-ktx_release", "androidx/core/widget/TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class b implements TextWatcher {

        final /* synthetic */ RecyclerView a;
        final /* synthetic */ y b;
        public b(RecyclerView recyclerView, y yVar) {
            this.a = recyclerView;
            this.b = yVar;
            super();
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(java.lang.CharSequence text, int start, int before, int count) {
            int i = 0;
            if (text != null) {
                this.a.q1(0);
                start = this.a.getAdapter() instanceof BreedSearchListAdapter ? (BreedSearchListAdapter)this.a.getAdapter() : 0;
                if (this.a != 0) {
                    String object = text.toString();
                    str = "null cannot be cast to non-null type kotlin.CharSequence";
                    Objects.requireNonNull(object, str);
                    i.j(DogProfileBindingAdapters.a.b((List)(LoadResult_Success)this.b.component1(), l.a1(object).toString()));
                }
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(java.lang.CharSequence text, int start, int count, int after) {
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0008\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "position", "", "<anonymous parameter 1>"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class c extends kotlin.d0.d.p implements kotlin.d0.c.p<Integer, Integer, w> {

        final /* synthetic */ b $mAdapter;
        @Override // kotlin.d0.d.p
        public final void a(int i, int i2) {
            if (this.$mAdapter.getItem(i).isCreator()) {
                this.$mAdapter.notifyItemChanged(i);
            } else {
                this.$mAdapter.removeItem(i);
            }
        }

        c(b bVar) {
            this.$mAdapter = bVar;
            super(2);
        }
    }
    private o() {
        super();
    }

    /* renamed from: A, reason: from kotlin metadata */
    private static final void setTabLayoutAdapter(List tabLayout, TabLayout.g callback, int dogProfileResults) {
        n.f(tabLayout, "$tabNamesList");
        n.f(callback, "tab");
        callback.r((CharSequence)tabLayout.get(dogProfileResults));
    }

    /* renamed from: B, reason: from kotlin metadata */
    public static final void dogBreedFilter(TextView list, long filterText) {
        n.f(list, "<this>");
        TimeUnit sECONDS2 = TimeUnit.SECONDS;
        long l4 = (long)60;
        int i = 3;
        Object[] arr = new Object[i];
        arr[0] = Long.valueOf(sECONDS2.toHours(filterText));
        arr[1] = Long.valueOf(sECONDS2.toMinutes(filterText) % l4);
        arr[2] = Long.valueOf(sECONDS2.toSeconds(filterText) % l4);
        String formatted = String.format("%02d:%02d:%02d", Arrays.copyOf(arr, i));
        n.e(formatted, "java.lang.String.format(format, *args)");
        list.setText(formatted);
    }

    /* renamed from: C, reason: from kotlin metadata */
    public static final void setupDogProfileParticipate(View dogProfileResults, y<Boolean> banner, f.a callback) {
        int i = 0;
        n.f(dogProfileResults, "<this>");
        banner = banner instanceof LoadResult_Success ? (oadResult_Success)banner : 0;
        if (i != 0) {
            Object component1 = i.component1();
            if (component1 != null) {
                dogProfileResults.setOnClickListener(new app.dogo.com.dogo_android.profile.a(callback, component1.booleanValue()));
            }
        }
    }

    public static final void D(ImageView imageView, y<ProfilePreview> yVar, v vVar) {
        int i = 0;
        n.f(imageView, "<this>");
        yVar = yVar instanceof LoadResult_Success ? (oadResult_Success)yVar : 0;
        if (i != 0) {
            Object component1 = i.component1();
            if (component1 != null) {
                imageView.setOnClickListener(new app.dogo.com.dogo_android.profile.k(vVar, component1));
            }
        }
    }

    private static final void E(f.a aVar, boolean z, View view) {
        if (aVar != null) {
            aVar.onItemClick(z);
        }
    }

    private static final void F(v vVar, ProfilePreview profilePreview, View view) {
        n.f(profilePreview, "$results");
        if (vVar != null) {
            vVar.c0(profilePreview);
        }
    }

    public static final void G(View view, DogBreed dogBreed, DogProfile dogProfile, TextView textView, TextView textView2) throws android.content.res.Resources.NotFoundException {
        Object obj;
        String name;
        n.f(view, "<this>");
        n.f(textView, "title");
        n.f(textView2, "breed");
        Object[] arr = new Object[1];
        dogProfile = dogProfile == null ? "" : name;
        textView.setText(view.getResources().getString(R.string.dog.creation.breed.question, arr));
        if (dogBreed != null) {
            String view2 = dogBreed.getName();
            if (view2 != null) {
            }
        }
        textView2.setText(obj);
    }

    public static final void H(ImageView imageView, y<ProfilePreview> yVar, v vVar) {
        int i = 2131231265;
        int i2;
        n.f(imageView, "<this>");
        final android.content.res.Resources.Theme theme = null;
        yVar = yVar instanceof LoadResult_Success ? (oadResult_Success)yVar : theme;
        if (i2 != 0) {
            Object component1 = i2.component1();
            if (component1 != null) {
                Context context = imageView.getContext();
                n.e(context, "context");
                str = "avatar.jpg";
                Uri uri = app.dogo.com.dogo_android.util.extensionfunction.i1.d(context, component1.getDogProfile().getId(), str);
                if (uri != null) {
                    MyAppGlideModule.e(uri, imageView);
                } else {
                    i = 2131231265;
                    imageView.setImageDrawable(f.f(imageView.getResources(), i, theme));
                }
                imageView.setOnClickListener(new app.dogo.com.dogo_android.profile.f(vVar));
            }
        }
    }

    /* renamed from: I, reason: from kotlin metadata */
    private static final void getDogGenderString(v context, View gender) {
        if (context != null) {
            context.z();
        }
    }

    public static final void J(ConstraintLayout constraintLayout, y<DogProfile> yVar, TextView textView, ImageView imageView, app.dogo.com.dogo_android.util.k0.e eVar, ImageView imageView2, View view, ImageView imageView3, ImageView imageView4) {
        int i = 0;
        n.f(constraintLayout, "<this>");
        n.f(textView, "dogNameTextView");
        n.f(imageView, "dogAvatarImageView");
        n.f(imageView2, "clickerButton");
        n.f(view, "dogNameClickArea");
        n.f(imageView3, "notificationButton");
        n.f(imageView4, "contactUsButton");
        yVar = yVar instanceof LoadResult_Success ? (oadResult_Success)yVar : 0;
        if (i != 0) {
            Object component1 = i.component1();
            if (component1 != null) {
                Context context = constraintLayout.getContext();
                str = "context";
                n.e(context, str);
                str3 = "avatar.jpg";
                app.dogo.com.dogo_android.util.binding.m.a(imageView, app.dogo.com.dogo_android.util.extensionfunction.i1.d(context, component1.getId(), str3));
                Context context2 = constraintLayout.getContext();
                n.e(context2, str);
                textView.setText(DogProfileBindingAdapters.a.d(component1, context2));
                imageView.setOnClickListener(new app.dogo.com.dogo_android.profile.g(component1, eVar));
                view.setOnClickListener(new app.dogo.com.dogo_android.profile.j(component1, eVar));
                imageView2.setOnClickListener(new app.dogo.com.dogo_android.profile.n(eVar));
                imageView4.setOnClickListener(new app.dogo.com.dogo_android.profile.d(eVar));
                imageView3.setOnClickListener(new app.dogo.com.dogo_android.profile.c(eVar));
            }
        }
    }

    private static final void K(DogProfile dogProfile, app.dogo.com.dogo_android.util.k0.e eVar, View view) {
        n.f(dogProfile, "$dog");
        if (dogProfile.dogOnlyHasName() != null) {
            if (eVar != null) {
                eVar.goToDogProfilePreview(dogProfile);
            }
        } else {
            if (eVar != null) {
                eVar.createNewDogProfile(dogProfile);
            }
        }
    }

    private static final void L(DogProfile dogProfile, app.dogo.com.dogo_android.util.k0.e eVar, View view) {
        n.f(dogProfile, "$dog");
        if (l.z(dogProfile.getName()) != null) {
            if (eVar != null) {
                eVar.updateDogProfile(dogProfile);
            }
        } else {
            if (eVar != null) {
                eVar.b0();
            }
        }
    }

    /* renamed from: M, reason: from kotlin metadata */
    private static final void getTitleName(app.dogo.com.dogo_android.util.k0.e dogProfile, View context) {
        if (dogProfile != null) {
            dogProfile.goToClicker();
        }
    }

    /* renamed from: N, reason: from kotlin metadata */
    private static final void setDogParents(app.dogo.com.dogo_android.util.k0.e result, View callback) {
        if (result != null) {
            result.g0();
        }
    }

    /* renamed from: O, reason: from kotlin metadata */
    private static final void setDogSelectAdapter(app.dogo.com.dogo_android.util.k0.e result, View callback) {
        if (result != null) {
            result.s();
        }
    }

    /* renamed from: P, reason: from kotlin metadata */
    public static final void setupAddNewDogCallback(ImageView userPremium, Uri callback) {
        str = "<this>";
        n.f(userPremium, str);
        if (callback != null) {
            MyAppGlideModule.e(callback, userPremium);
        } else {
            android.content.res.Resources.Theme theme = null;
            userPremium.setImageDrawable(f.f(userPremium.getResources(), 2131231265, theme));
        }
    }

    /* renamed from: Q, reason: from kotlin metadata */
    public static final void setBreadSearchAdapter(View result, y<ProfilePreview> callback, in searchBox, v headerViewRes) {
        int i = 8;
        n.f(result, "<this>");
        n.f(searchBox, "banner");
        i = 8;
        if (callback instanceof LoadResult_Success) {
            if ((ProfilePreview)callback.component1().isParticipateBannerVisible()) {
                i = 0;
            }
            searchBox.w().setVisibility(i);
            searchBox.O.setOnClickListener(new app.dogo.com.dogo_android.profile.h(headerViewRes, (ProfilePreview)callback.component1().getDogProfile()));
        } else {
            searchBox.w().setVisibility(8);
        }
    }

    private static final void R(v vVar, DogProfile dogProfile, View view) {
        n.f(dogProfile, "$dogProfile");
        if (vVar != null) {
            vVar.t1(dogProfile);
        }
    }

    public static final void S(View view, ProfilePreview profilePreview, yl ylVar, yl ylVar2, yl ylVar3, yl ylVar4, v vVar) {
        n.f(view, "<this>");
        n.f(profilePreview, "dogProfileResults");
        n.f(ylVar, "name");
        n.f(ylVar2, "breed");
        n.f(ylVar3, "birthday");
        n.f(ylVar4, "gender");
        final DogProfile dogProfile = profilePreview.getDogProfile();
        final Resources resources = view.getResources();
        n.e(resources, "resources");
        ylVar.T(app.dogo.com.dogo_android.util.extensionfunction.j1.W0(dogProfile.getName(), resources));
        ylVar.w().setOnClickListener(new app.dogo.com.dogo_android.profile.b(vVar, dogProfile));
        ylVar2.T(app.dogo.com.dogo_android.util.extensionfunction.j1.w(dogProfile));
        ylVar2.w().setOnClickListener(new app.dogo.com.dogo_android.profile.m(vVar, dogProfile));
        ylVar3.T(app.dogo.com.dogo_android.util.extensionfunction.j1.v(dogProfile));
        ylVar3.w().setOnClickListener(new app.dogo.com.dogo_android.profile.i(vVar, dogProfile));
        Context context = view.getContext();
        n.e(context, "context");
        ylVar4.T(DogProfileBindingAdapters.a.c(context, dogProfile.getGender()));
        ylVar4.w().setOnClickListener(new app.dogo.com.dogo_android.profile.e(vVar, dogProfile));
    }

    private static final void T(v vVar, DogProfile dogProfile, View view) {
        n.f(dogProfile, "$dogProfile");
        if (vVar != null) {
            vVar.D0(dogProfile);
        }
    }

    private static final void U(v vVar, DogProfile dogProfile, View view) {
        n.f(dogProfile, "$dogProfile");
        if (vVar != null) {
            vVar.I0(dogProfile);
        }
    }

    private static final void V(v vVar, DogProfile dogProfile, View view) {
        n.f(dogProfile, "$dogProfile");
        if (vVar != null) {
            vVar.J(dogProfile);
        }
    }

    private static final void W(v vVar, DogProfile dogProfile, View view) {
        n.f(dogProfile, "$dogProfile");
        if (vVar != null) {
            vVar.onDeleteDogClick(dogProfile);
        }
    }

    /* renamed from: X, reason: from kotlin metadata */
    public static final void setupAddNewDogCallback(TextView dogProfileResults, y<ProfilePreview> callback) {
        int i = 0;
        n.f(dogProfileResults, "<this>");
        callback = callback instanceof LoadResult_Success ? (oadResult_Success)callback : 0;
        if (i != 0) {
            Object component1 = i.component1();
            if (component1 != null) {
                Resources resources = dogProfileResults.getResources();
                str = "resources";
                n.e(resources, str);
                dogProfileResults.setText(app.dogo.com.dogo_android.util.extensionfunction.j1.W0(component1.getDogProfile().getName(), resources));
            }
        }
    }

    /* renamed from: Y, reason: from kotlin metadata */
    public static final void setupDogProfileAvatar(NumberPicker dogProfileResults, boolean callback) {
        int i;
        n.f(dogProfileResults, "<this>");
        app.dogo.com.dogo_android.k.d[] values = DogGender.values();
        ArrayList arrayList = new ArrayList(values.length);
        length = values.length;
        i = 0;
        for (app.dogo.com.dogo_android.k.d dVar : values) {
            Context context = dogProfileResults.getContext();
            str2 = "context";
            n.e(context, str2);
            arrayList.add(DogProfileBindingAdapters.a.c(context, dVar));
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object item = it.next();
            i = !l.z((String)item);
        }
        dogProfileResults.setMaxValue(arrayList2.size() - 1);
        dogProfileResults.setMinValue(i);
        Object[] array = arrayList2.toArray(new String[i]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        dogProfileResults.setDisplayedValues(array);
    }

    public static final /* synthetic */ List a(o oVar, List list, String str) {
        return oVar.b(list, str);
    }

    private final List<DogBreed> b(List<DogBreed> list, String str) {
        int i = 0;
        boolean z;
        String str3;
        String str4;
        List list2;
        final boolean z2 = true;
        boolean r0 = str.length() == 0 ? z2 : 0;
        if (i == 0) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Object item = it.next();
                String name = (DogBreed)item.getName();
                String str6 = "null cannot be cast to non-null type java.lang.String";
                Objects.requireNonNull(name, str6);
                String str5 = name.toLowerCase();
                str4 = "(this as java.lang.String).toLowerCase()";
                n.e(str5, str4);
                Objects.requireNonNull(str, str6);
                str3 = str.toLowerCase();
                n.e(str3, str4);
            }
            str = null;
            list2 = p.t0(p.b(new DogBreed(str, str, z2)), arrayList);
        }
        return list2;
    }

    private final String c(Context context, app.dogo.com.dogo_android.k.d dVar) throws android.content.res.Resources.NotFoundException {
        String string;
        int i2 = app.dogo.com.dogo_android.profile.o.a.a[dVar.ordinal()];
        int i = 1;
        if (i2 == 1) {
            str = "context.resources.getString(R.string.gender_male)";
            n.e(context.getResources().getString(2131886670), str);
        } else {
            i = 2;
            if (i2 == 2) {
                str = "context.resources.getString(R.string.gender_female)";
                n.e(context.getResources().getString(2131886669), str);
            } else {
                i = 3;
                if (i2 != 3) {
                    string = "";
                } else {
                    str = "context.resources.getString(R.string.gender_other)";
                    n.e(context.getResources().getString(2131886671), str);
                }
            }
        }
        return string;
    }

    private final String d(DogProfile dogProfile, Context context) {
        String string;
        if (!l.z(dogProfile.getName()) != null) {
            string = app.dogo.com.dogo_android.util.extensionfunction.j1.V0(dogProfile.getName(), context);
        } else {
            str = "context.getString(R.string.dog_edit_what_is_your_dog_name)";
            n.e(context.getString(2131886464), str);
        }
        return string;
    }

    public static final void s(RecyclerView recyclerView, y<? extends List<DogBreed>> yVar, i.b bVar, EditText editText, int i) throws android.content.res.Resources.NotFoundException {
        n.f(recyclerView, "<this>");
        n.f(editText, "searchBox");
        if (yVar instanceof LoadResult_Success) {
            String object = editText.getText().toString();
            Objects.requireNonNull(object, "null cannot be cast to non-null type kotlin.CharSequence");
            app.dogo.com.dogo_android.dogcreation.j.i breedSearchListAdapter = new BreedSearchListAdapter(bVar);
            breedSearchListAdapter.j(DogProfileBindingAdapters.a.b((List)(LoadResult_Success)yVar.component1(), l.a1(object).toString()));
            recyclerView.setAdapter(breedSearchListAdapter);
            editText.addTextChangedListener(new TextViewKt_addTextChangedListener_textWatcher_1(recyclerView, yVar));
        } else {
            z = yVar instanceof LoadResult_Error;
            i = 0;
            if (yVar instanceof oadResult_Error) {
                app.dogo.com.dogo_android.dogcreation.j.i breedSearchListAdapter2 = new BreedSearchListAdapter(bVar);
                breedSearchListAdapter2.j(p.g());
                recyclerView.setAdapter(breedSearchListAdapter2);
                recyclerView.i(new ZeroStateDecoration(i), i);
                android.view.animation.Animation animation = AnimationUtils.loadAnimation(recyclerView.getContext(), 2130772024);
                str = "loadAnimation(context, R.anim.shake)";
                n.e(animation, str);
                recyclerView.startAnimation(animation);
            } else {
                if (yVar instanceof LoadResult_Loading && recyclerView.getItemDecorationCount() > 0) {
                    recyclerView.e1(i);
                }
            }
        }
    }

    public static final void t(ImageView imageView, y<DogOwnerInvitation> yVar) {
        int i2;
        n.f(imageView, "<this>");
        if (yVar == null) {
            imageView.setImageDrawable(MyAppGlideModule.d(imageView.getContext()));
        } else {
            android.content.res.Resources.Theme theme = null;
            yVar = yVar instanceof LoadResult_Success ? (oadResult_Success)yVar : theme;
            if (i2 != 0) {
                Object component1 = i2.component1();
                if (component1 != null) {
                    int i = 2131231085;
                    BindingAdapters.m0(imageView, component1.getDogAvatar(), f.f(imageView.getResources(), i, theme));
                }
            }
        }
    }

    public static final void u(TextView textView, DogOwnerInvitation dogOwnerInvitation) throws android.content.res.Resources.NotFoundException {
        int i2;
        String userName;
        String dogName;
        Object obj;
        n.f(textView, "<this>");
        if (dogOwnerInvitation != null) {
            i2 = 1;
            i2 = 0;
            int r0 = i2;
            if (i2 != 0) {
                userName = dogOwnerInvitation.getUserName();
            } else {
                str = "resources.getString(R.string.general_anonymous)";
                n.e(textView.getResources().getString(2131886675), str);
            }
            int r3 = i2;
            if (i2 != 0) {
                dogName = dogOwnerInvitation.getDogName();
            } else {
                n.e(textView.getResources().getString(2131886954), "resources.getString(R.string.no_name)");
            }
            int i3 = 2131886787;
            Object[] arr = new Object[2];
            String string2 = textView.getResources().getString(i3, new Object[] { userName, dogName });
        } else {
            int i = 2131886167;
            String string = textView.getResources().getString(i);
        }
        textView.setText(obj);
    }

    public static final void v(TextView textView, y<DogOwnerInvitation> yVar) throws android.content.res.Resources.NotFoundException {
        int i;
        String userName;
        int i6 = 0;
        String yVar22;
        n.f(textView, "<this>");
        z = yVar instanceof LoadResult_Success;
        yVar = yVar instanceof oadResult_Success ? (oadResult_Success)yVar : 0;
        if (i6 != 0) {
            Object component1 = i6.component1();
            if (component1 != null) {
                i = 1;
                i = 0;
                int r0 = i;
                if (i != 0) {
                    userName = component1.getUserName();
                } else {
                    str = "resources.getString(R.string.general_anonymous)";
                    n.e(textView.getResources().getString(2131886675), str);
                }
                int r3 = i;
                if (i != 0) {
                    yVar22 = component1.getDogName();
                } else {
                    n.e(textView.getResources().getString(2131886954), "resources.getString(R.string.no_name)");
                }
                Object[] arr = new Object[2];
                String string = textView.getResources().getString(2131886787, new Object[] { userName, yVar22 });
                n.e(string, "resources.getString(R.string.invite_owner_screen_text, parentName, dogName)");
                SpannableString spannableString = new SpannableString(string);
                int i4 = 0;
                boolean z2 = false;
                int i5 = 6;
                Object obj = null;
                int i2 = l.j0(string, yVar22, i4, z2, i5, obj);
                i6 = yVar22.length() + i2;
                int i3 = 33;
                spannableString.setSpan(new ForegroundColorSpan(a.d(textView.getContext(), 2131100352)), i2, i6, i3);
                textView.setText(spannableString);
            }
        }
    }

    public static final void w(TextView textView, DogParentUIState.DogParent dogParent) throws android.content.res.Resources.NotFoundException {
        int i = 1;
        Object obj;
        n.f(textView, "<this>");
        n.f(dogParent, "dogParent");
        int r0 = dogParent.getName().length() == 0 ? 1 : 0;
        if (i != 0) {
            i = 2131886954;
            String string = textView.getResources().getString(i);
        } else {
            String name2 = dogParent.getName();
        }
        textView.setText(obj);
    }

    public static final void x(RecyclerView recyclerView, y<DogParentUIState> yVar, b.b bVar) throws android.content.res.Resources.NotFoundException {
        RecyclerView.h adapter;
        String str;
        app.dogo.com.dogo_android.util.n0.m genericInBetweenItemDivider;
        Context context;
        RecyclerView.h adapter2 = null;
        n.f(recyclerView, "<this>");
        z = yVar instanceof LoadResult_Success;
        if (yVar instanceof oadResult_Success && bVar != null) {
            str = "context";
            if (recyclerView.getItemDecorationCount() == 0) {
                itemDecorationCount = (int)recyclerView.getContext().getResources().getDimension(2131165626);
                context = recyclerView.getContext();
                n.e(context, str);
                recyclerView.h(new GenericInBetweenItemDivider(context, itemDecorationCount));
            }
            if (recyclerView.getAdapter() == null) {
                b dogParentsAdapter = new DogParentsAdapter(bVar);
                recyclerView.setAdapter(dogParentsAdapter);
                context = recyclerView.getContext();
                n.e(context, str);
                new l(new DogParentsTouchHelperCallback(context, new app.dogo.com.dogo_android.profile.o.c(dogParentsAdapter))).g(recyclerView);
            }
            z2 = recyclerView.getAdapter() instanceof DogParentsAdapter;
            recyclerView = recyclerView.getAdapter() instanceof DogParentsAdapter ? (DogParentsAdapter)recyclerView.getAdapter() : 0;
            if (adapter2 != null) {
                adapter2.removeItem((DogParentUIState)yVar.component1().getParents());
            }
        }
    }

    public static final void y(RecyclerView recyclerView, DogSelectData dogSelectData, f.a aVar) throws android.content.res.Resources.NotFoundException {
        String str2;
        str = "<this>";
        n.f(recyclerView, str);
        if (dogSelectData != null && aVar != null && recyclerView.getItemDecorationCount() == 0) {
            itemDecorationCount = (int)recyclerView.getContext().getResources().getDimension(2131165626);
            Context context = recyclerView.getContext();
            str2 = "context";
            n.e(context, str2);
            recyclerView.h(new GenericInBetweenItemDivider(context, itemDecorationCount));
            recyclerView.setAdapter(new DogSelectAdapter(dogSelectData.getDogList(), dogSelectData.getCurrentDogPosition(), aVar));
            recyclerView.q1(dogSelectData.getCurrentDogPosition());
        }
    }

    /* renamed from: z, reason: from kotlin metadata */
    public static final void setupDogProfile(ViewPager2 dogBreed, TabLayout dogProfile, v title, y<ProfilePreview> breed) throws android.content.res.Resources.NotFoundException {
        Object breed2;
        int i = 0;
        RecyclerView.h adapter;
        g0 dogPreviewTabLayoutAdapter;
        String string;
        int i2 = 2131887125;
        com.google.android.material.tabs.d dVar;
        app.dogo.com.dogo_android.q.l lVar;
        n.f(dogBreed, "<this>");
        n.f(dogProfile, "tabLayout");
        i = 0;
        breed2 = breed instanceof LoadResult_Success ? (LoadResult_Success)breed2 : i;
        if (breed2 != null) {
            breed2 = breed2.component1();
            if (breed2 != null) {
                if (title != null && dogBreed.getAdapter() == null) {
                    String[] strArr = new String[2];
                    i2 = 2131887125;
                    dogBreed.setAdapter(new DogPreviewTabLayoutAdapter(title, (ProfilePreview)breed.component1()));
                    new d(dogProfile, dogBreed, new app.dogo.com.dogo_android.profile.l(p.j(new String[] { dogBreed.getResources().getString(2131887112), dogBreed.getResources().getString(i2) }))).a();
                }
                RecyclerView.h dogBreed2 = dogBreed.getAdapter();
                z = dogBreed2 instanceof DogPreviewTabLayoutAdapter;
                if (dogBreed2 instanceof DogPreviewTabLayoutAdapter) {
                }
                if (i != 0) {
                    i.updateData(breed2);
                }
            }
        }
    }


    public static /* synthetic */ void e(f.a aVar, boolean z, View view) {
        DogProfileBindingAdapters.E(aVar, z, view);
    }

    public static /* synthetic */ void f(v vVar, DogProfile dogProfile, View view) {
        DogProfileBindingAdapters.T(vVar, dogProfile, view);
    }

    public static /* synthetic */ void g(app.dogo.com.dogo_android.util.k0.e eVar, View view) {
        DogProfileBindingAdapters.setDogSelectAdapter(eVar, view);
    }

    public static /* synthetic */ void h(app.dogo.com.dogo_android.util.k0.e eVar, View view) {
        DogProfileBindingAdapters.setDogParents(eVar, view);
    }

    public static /* synthetic */ void i(v vVar, DogProfile dogProfile, View view) {
        DogProfileBindingAdapters.W(vVar, dogProfile, view);
    }

    public static /* synthetic */ void j(v vVar, View view) {
        DogProfileBindingAdapters.getDogGenderString(vVar, view);
    }

    public static /* synthetic */ void k(DogProfile dogProfile, app.dogo.com.dogo_android.util.k0.e eVar, View view) {
        DogProfileBindingAdapters.K(dogProfile, eVar, view);
    }

    public static /* synthetic */ void l(v vVar, DogProfile dogProfile, View view) {
        DogProfileBindingAdapters.R(vVar, dogProfile, view);
    }

    public static /* synthetic */ void m(v vVar, DogProfile dogProfile, View view) {
        DogProfileBindingAdapters.V(vVar, dogProfile, view);
    }

    public static /* synthetic */ void n(DogProfile dogProfile, app.dogo.com.dogo_android.util.k0.e eVar, View view) {
        DogProfileBindingAdapters.L(dogProfile, eVar, view);
    }

    public static /* synthetic */ void o(v vVar, ProfilePreview profilePreview, View view) {
        DogProfileBindingAdapters.F(vVar, profilePreview, view);
    }

    public static /* synthetic */ void p(List list, TabLayout.g gVar, int i) {
        DogProfileBindingAdapters.setTabLayoutAdapter(list, gVar, i);
    }

    public static /* synthetic */ void q(v vVar, DogProfile dogProfile, View view) {
        DogProfileBindingAdapters.U(vVar, dogProfile, view);
    }

    public static /* synthetic */ void r(app.dogo.com.dogo_android.util.k0.e eVar, View view) {
        DogProfileBindingAdapters.getTitleName(eVar, view);
    }
}
