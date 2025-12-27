package app.dogo.com.dogo_android.i;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.e0;
import androidx.recyclerview.widget.RecyclerView.h;
import app.dogo.com.dogo_android.h.c7;
import app.dogo.com.dogo_android.h.e7;
import app.dogo.com.dogo_android.h.g7;
import app.dogo.com.dogo_android.util.d0.a.a;
import app.dogo.com.dogo_android.util.h0.j1;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.d0.d.c0;
import kotlin.d0.d.g;
import kotlin.d0.d.n;
import kotlin.d0.d.t;
import kotlin.f0.b;
import kotlin.f0.c;
import kotlin.i0.l;

/* compiled from: DebugFeatureListAdapter.kt */
@Metadata(d1 = "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0008\u0008\n\u0002\u0010\u0008\n\u0002\u0008\u0003\n\u0002\u0010\u0002\n\u0002\u0008\u0003\n\u0002\u0018\u0002\n\u0002\u0008\u000b\u0018\u0000 \u001e2\u0008\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\t\u001c\u001d\u001e\u001f !\"#$B\u0011\u0012\n\u0008\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0008\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\u0018\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R7\u0010\n\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00082\u000c\u0010\u0007\u001a\u0008\u0012\u0004\u0012\u00020\t0\u00088F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\u0008\u000f\u0010\u0010\u001a\u0004\u0008\u000b\u0010\u000c\"\u0004\u0008\r\u0010\u000e¨\u0006%", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$Holder;", "Lapp/dogo/com/dogo_android/util/adapter/AutoUpdatableAdapter;", "callbacks", "Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$Callbacks;", "(Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$Callbacks;)V", "<set-?>", "", "Lapp/dogo/com/dogo_android/debug/DebugFeatureItem;", "list", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "list$delegate", "Lkotlin/properties/ReadWriteProperty;", "getItemCount", "", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "BooleanHolder", "Callbacks", "Companion", "DoubleHolder", "Holder", "ItemTypes", "JsonArrayHolder", "LongHolder", "StringHolder", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
/* renamed from: n0, reason: from kotlin metadata */
public final class DebugFeatureListAdapter extends RecyclerView.h<n0.e> implements app.dogo.com.dogo_android.util.d0.a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final n0.c INSTANCE = new n0$c(0);
    static final /* synthetic */ l<Object>[] c;
    /* renamed from: a, reason: from kotlin metadata */
    private final n0.b callbacks;
    private final c b;

    @Metadata(d1 = "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\u0008\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\u0008\u0002\u0008f\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u0008\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\tH&J\u0008\u0010\n\u001a\u00020\u0003H&J\u001e\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u000c\u0010\u000c\u001a\u0008\u0012\u0004\u0012\u00020\u00050\rH&J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000fH&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&¨\u0006\u0011", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$Callbacks;", "", "onBooleanUpdate", "", "key", "", "value", "", "onDoubleUpdate", "", "onInvalidValue", "onJsonArrayTap", "selectionList", "", "onLongUpdate", "", "onStringUpdate", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface b {
        /* renamed from: I, reason: from kotlin metadata */
        void onInvalidValue();

        /* renamed from: K0, reason: from kotlin metadata */
        void onBooleanUpdate(String key, String value);

        /* renamed from: S, reason: from kotlin metadata */
        void onDoubleUpdate(String key, double value);

        /* renamed from: d1, reason: from kotlin metadata */
        void onJsonArrayTap(String key, List<String> selectionList);

        /* renamed from: r1, reason: from kotlin metadata */
        void onLongUpdate(String key, boolean value);

        /* renamed from: v0, reason: from kotlin metadata */
        void onStringUpdate(String key, long value);
    }

    @Metadata(d1 = "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0008\u0002\n\u0002\u0010\u0008\n\u0002\u0008\u0005\u0008\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\u0008\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0008\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$Companion;", "", "()V", "INSTANCE_OF_BOOLEAN_ITEM", "", "INSTANCE_OF_DOUBLE_ITEM", "INSTANCE_OF_JSON_ARRAY_ITEM", "INSTANCE_OF_LONG_ITEM", "INSTANCE_OF_STRING_ITEM", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class c {
        private c() {
            super();
        }

        public /* synthetic */ c(g gVar) {
            this();
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0008\n\u0002\u0008\n\u0008\u0086\u0001\u0018\u0000 \u000c2\u0008\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000cB\u000f\u0008\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006j\u0002\u0008\u0007j\u0002\u0008\u0008j\u0002\u0008\tj\u0002\u0008\nj\u0002\u0008\u000b¨\u0006\r", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$ItemTypes;", "", "typeId", "", "(Ljava/lang/String;II)V", "getTypeId", "()I", "BOOLEAN", "LONG", "DOUBLE", "STRING", "JSON_ARRAY", "Companion", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public enum f {

        BOOLEAN,
        DOUBLE,
        JSON_ARRAY,
        LONG,
        STRING;

        private final int typeId;
        @Override // java.lang.Enum
        public final int getTypeId() {
            return this.typeId;
        }

        private static final /* synthetic */ n0.f[] $values() {
            app.dogo.com.dogo_android.i.n0.f[] arr = new n0.f[5];
            return new n0.f[] { DebugFeatureListAdapter_ItemTypes.BOOLEAN, DebugFeatureListAdapter_ItemTypes.LONG, DebugFeatureListAdapter_ItemTypes.DOUBLE, DebugFeatureListAdapter_ItemTypes.STRING, DebugFeatureListAdapter_ItemTypes.JSON_ARRAY };
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public class j {

        public static final /* synthetic */ int[] a;
        static {
            int[] iArr = new int[DebugFeatureListAdapter_ItemTypes.values().length];
            iArr[DebugFeatureListAdapter_ItemTypes.BOOLEAN.ordinal()] = 1;
            iArr[DebugFeatureListAdapter_ItemTypes.DOUBLE.ordinal()] = 2;
            iArr[DebugFeatureListAdapter_ItemTypes.STRING.ordinal()] = 3;
            iArr[DebugFeatureListAdapter_ItemTypes.LONG.ordinal()] = 4;
            iArr[DebugFeatureListAdapter_ItemTypes.JSON_ARRAY.ordinal()] = 5;
            app.dogo.com.dogo_android.debug.n0.j.a = iArr;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "bind", "Landroidx/databinding/ViewDataBinding;", "(Landroidx/databinding/ViewDataBinding;)V", "getBind", "()Landroidx/databinding/ViewDataBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static class e extends RecyclerView.e0 {

        /* renamed from: a, reason: from kotlin metadata */
        private final ViewDataBinding bind;
        public e(ViewDataBinding viewDataBinding) {
            n.f(viewDataBinding, "bind");
            super(viewDataBinding.w());
            this.bind = viewDataBinding;
        }

        @Override // androidx.recyclerview.widget.RecyclerView$e0
        public final ViewDataBinding a() {
            return this.bind;
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$BooleanHolder;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellSimpleToogleSwitchBinding;", "(Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter;Lapp/dogo/com/dogo_android/databinding/CellSimpleToogleSwitchBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellSimpleToogleSwitchBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class a extends n0.e {

        private final g7 b;
        final /* synthetic */ n0 c;
        public a(g7 g7Var) {
            n.f(n0Var, "this$0");
            n.f(g7Var, "binding");
            this.c = n0Var;
            super(g7Var);
            this.b = g7Var;
            g7Var.P.setOnCheckedChangeListener(new app.dogo.com.dogo_android.debug.y(n0Var, this));
        }

        private static final void b(n0 n0Var, n0.a aVar, CompoundButton compoundButton, boolean z) {
            n.f(n0Var, "this$0");
            n.f(aVar, "this$1");
            Object item = n0Var.getItemCount().get(aVar.getBindingAdapterPosition());
            item.equals(z);
            aVar.c().V(item);
            final app.dogo.com.dogo_android.i.n0.b itemViewType = n0Var.callbacks;
            if (itemViewType != null) {
                itemViewType.onLongUpdate(item.component1(), z);
            }
        }

        @Override // app.dogo.com.dogo_android.i.n0$e
        public final g7 c() {
            return this.b;
        }

        public static /* synthetic */ void d(n0 n0Var, n0.a aVar, CompoundButton compoundButton, boolean z) {
            DebugFeatureListAdapter_BooleanHolder.b(n0Var, aVar, compoundButton, z);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$DoubleHolder;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellSimpleTextInputBinding;", "(Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter;Lapp/dogo/com/dogo_android/databinding/CellSimpleTextInputBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellSimpleTextInputBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class d extends n0.e {

        private final c7 b;
        final /* synthetic */ n0 c;
        public d(c7 c7Var) {
            n.f(n0Var, "this$0");
            n.f(c7Var, "binding");
            this.c = n0Var;
            super(c7Var);
            this.b = c7Var;
            c7Var.R.setOnClickListener(new app.dogo.com.dogo_android.debug.z(n0Var, this));
        }

        private static final void b(n0 n0Var, n0.d dVar, View view) {
            String str;
            double value;
            n.f(n0Var, "this$0");
            n.f(dVar, "this$1");
            Object item = n0Var.getItemCount().get(dVar.getBindingAdapterPosition());
            str = "binding.inputBox";
            n.e(editText, str);
            Double refreshIdToken = app.dogo.com.dogo_android.util.extensionfunction.j1.refreshIdToken(editText);
            if (refreshIdToken != null) {
                app.dogo.com.dogo_android.i.n0.b itemViewType2 = n0Var.callbacks;
                if (itemViewType2 != null) {
                    itemViewType2.onDoubleUpdate(item.component1(), refreshIdToken.doubleValue());
                }
                dVar.c().V(item);
            } else {
                app.dogo.com.dogo_android.i.n0.b itemViewType = n0Var.callbacks;
                if (itemViewType != null) {
                    itemViewType.onInvalidValue();
                }
            }
        }

        @Override // app.dogo.com.dogo_android.i.n0$e
        public final c7 c() {
            return this.b;
        }

        public static /* synthetic */ void d(n0 n0Var, n0.d dVar, View view) {
            DebugFeatureListAdapter_DoubleHolder.b(n0Var, dVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$JsonArrayHolder;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellSimpleTextRoundedBinding;", "(Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter;Lapp/dogo/com/dogo_android/databinding/CellSimpleTextRoundedBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellSimpleTextRoundedBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class g extends n0.e {

        private final e7 b;
        final /* synthetic */ n0 c;
        public g(e7 e7Var) {
            n.f(n0Var, "this$0");
            n.f(e7Var, "binding");
            this.c = n0Var;
            super(e7Var);
            this.b = e7Var;
            e7Var.w().setOnClickListener(new app.dogo.com.dogo_android.debug.a0(n0Var, this));
        }

        private static final void b(n0 n0Var, n0.g gVar, View view) {
            n.f(n0Var, "this$0");
            n.f(gVar, "this$1");
            Object item = n0Var.getItemCount().get(gVar.getBindingAdapterPosition());
            final app.dogo.com.dogo_android.i.n0.b itemViewType = n0Var.callbacks;
            if (itemViewType != null) {
                itemViewType.onJsonArrayTap(item.component1(), item.d());
            }
        }

        @Override // app.dogo.com.dogo_android.i.n0$e
        public final e7 c() {
            return this.b;
        }

        public static /* synthetic */ void d(n0 n0Var, n0.g gVar, View view) {
            DebugFeatureListAdapter_JsonArrayHolder.b(n0Var, gVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$LongHolder;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellSimpleTextInputBinding;", "(Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter;Lapp/dogo/com/dogo_android/databinding/CellSimpleTextInputBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellSimpleTextInputBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class h extends n0.e {

        private final c7 b;
        final /* synthetic */ n0 c;
        public h(c7 c7Var) {
            n.f(n0Var, "this$0");
            n.f(c7Var, "binding");
            this.c = n0Var;
            super(c7Var);
            this.b = c7Var;
            c7Var.R.setOnClickListener(new app.dogo.com.dogo_android.debug.b0(n0Var, this));
        }

        private static final void b(n0 n0Var, n0.h hVar, View view) {
            String str;
            long value;
            n.f(n0Var, "this$0");
            n.f(hVar, "this$1");
            Object item = n0Var.getItemCount().get(hVar.getBindingAdapterPosition());
            str = "binding.inputBox";
            n.e(editText, str);
            Long upOnbaordingConfetti = app.dogo.com.dogo_android.util.extensionfunction.j1.setUpOnbaordingConfetti(editText);
            if (upOnbaordingConfetti != null) {
                item.equals(upOnbaordingConfetti.longValue());
                app.dogo.com.dogo_android.i.n0.b itemViewType2 = n0Var.callbacks;
                if (itemViewType2 != null) {
                    itemViewType2.onStringUpdate(item.component1(), upOnbaordingConfetti.longValue());
                }
                hVar.c().V(item);
            } else {
                app.dogo.com.dogo_android.i.n0.b itemViewType = n0Var.callbacks;
                if (itemViewType != null) {
                    itemViewType.onInvalidValue();
                }
            }
        }

        @Override // app.dogo.com.dogo_android.i.n0$e
        public final c7 c() {
            return this.b;
        }

        public static /* synthetic */ void d(n0 n0Var, n0.h hVar, View view) {
            DebugFeatureListAdapter_LongHolder.b(n0Var, hVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004\u0008\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\u0008\n\u0000\u001a\u0004\u0008\u0005\u0010\u0006¨\u0006\u0007", d2 = {"Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$StringHolder;", "Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter$Holder;", "binding", "Lapp/dogo/com/dogo_android/databinding/CellSimpleTextInputBinding;", "(Lapp/dogo/com/dogo_android/debug/DebugFeatureListAdapter;Lapp/dogo/com/dogo_android/databinding/CellSimpleTextInputBinding;)V", "getBinding", "()Lapp/dogo/com/dogo_android/databinding/CellSimpleTextInputBinding;", "app_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class i extends n0.e {

        private final c7 b;
        final /* synthetic */ n0 c;
        public i(c7 c7Var) {
            n.f(n0Var, "this$0");
            n.f(c7Var, "binding");
            this.c = n0Var;
            super(c7Var);
            this.b = c7Var;
            c7Var.R.setOnClickListener(new app.dogo.com.dogo_android.debug.c0(n0Var, this));
        }

        private static final void b(n0 n0Var, n0.i iVar, View view) {
            n.f(n0Var, "this$0");
            n.f(iVar, "this$1");
            Object item = n0Var.getItemCount().get(iVar.getBindingAdapterPosition());
            String object = iVar.c().P.getText().toString();
            item.equals(object);
            app.dogo.com.dogo_android.i.n0.b itemViewType = n0Var.callbacks;
            if (itemViewType != null) {
                itemViewType.onBooleanUpdate(item.component1(), object);
            }
            iVar.c().V(item);
        }

        @Override // app.dogo.com.dogo_android.i.n0$e
        public final c7 c() {
            return this.b;
        }

        public static /* synthetic */ void d(n0 n0Var, n0.i iVar, View view) {
            DebugFeatureListAdapter_StringHolder.b(n0Var, iVar, view);
        }
    }

    @Metadata(d1 = "\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0008\u0004*\u0001\u0000\u0008\n\u0018\u00002\u0008\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\u0008\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\u0008¨\u0006\t¸\u0006\u0000", d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    public static final class l extends b<List<? extends m0>> {

        final /* synthetic */ Object a;
        final /* synthetic */ n0 b;
        public l(Object object, Object object2, n0 n0Var) {
            this.a = object;
            this.b = n0Var;
            super(object2);
        }

        @Override // kotlin.f0.b
        protected void afterChange(l<?> property, List<? extends m0> oldValue, List<? extends m0> newValue) {
            n.f(property, "property");
            this.b.autoNotify(this.b, oldValue, newValue, app.dogo.com.dogo_android.debug.n0.k.a);
        }
    }

    @Metadata(d1 = "\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\n", d2 = {"<anonymous>", "", "o", "Lapp/dogo/com/dogo_android/debug/DebugFeatureItem;", "n"}, k = 3, mv = {1, 5, 1}, xi = 48)
    static final class k extends kotlin.d0.d.p implements kotlin.d0.c.p<m0, m0, Boolean> {

        public static final n0.k a = new n0$k();
        @Override // kotlin.d0.d.p
        public final boolean a(m0 m0Var, m0 m0Var2) {
            n.f(m0Var, "o");
            n.f(m0Var2, "n");
            return n.b(m0Var.a(), m0Var2.a());
        }


        k() {
            super(2);
        }
    }
    static {
        l[] arr = new l[1];
        DebugFeatureListAdapter.c = new l[] { c0.f(new t(c0.b(DebugFeatureListAdapter.class), "list", "getList()Ljava/util/List;")) };
    }

    public /* synthetic */ n0(n0.b bVar, int i, g gVar) {
        app.dogo.com.dogo_android.i.n0.b bVar2 = null;
        i = i & 1 != 0 ? 0 : i;
        this(bVar2);
    }

    /* renamed from: f, reason: from kotlin metadata */
    public static final /* synthetic */ n0.b getItemViewType(n0 position) {
        return position.callbacks;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public <T> void autoNotify(RecyclerView.h<?> hVar, List<? extends T> list, List<? extends T> list2, kotlin.d0.c.p<? super T, ? super T, Boolean> pVar) {
        app.dogo.com.dogo_android.util.adapter.a.a.a(this, hVar, list, list2, pVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: g, reason: from kotlin metadata */
    public final List<m0> getItemCount() {
        return (List)this.b.getValue(this, DebugFeatureListAdapter.c[0]);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemCount() {
        return getItemCount().size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public int getItemViewType(int i) throws NoWhenBranchMatchedException {
        int typeId;
        Object item = getItemCount().get(i);
        z = item instanceof DebugFeatureItem_BooleanDebugFeatureItem;
        if (item instanceof DebugFeatureItem_BooleanDebugFeatureItem) {
            typeId = DebugFeatureListAdapter_ItemTypes.BOOLEAN.getTypeId();
            return typeId;
        } else {
            z = item instanceof DebugFeatureItem_DoubleDebugFeatureItem;
            if (item instanceof DebugFeatureItem_DoubleDebugFeatureItem) {
                typeId = DebugFeatureListAdapter_ItemTypes.DOUBLE.getTypeId();
            } else {
                z = item instanceof DebugFeatureItem_LongDebugFeatureItem;
                if (item instanceof DebugFeatureItem_LongDebugFeatureItem) {
                    typeId = DebugFeatureListAdapter_ItemTypes.LONG.getTypeId();
                } else {
                    z = item instanceof DebugFeatureItem_StringDebugFeatureItem;
                    if (item instanceof DebugFeatureItem_StringDebugFeatureItem) {
                        typeId = DebugFeatureListAdapter_ItemTypes.STRING.getTypeId();
                    } else {
                        if (item instanceof DebugFeatureItem_JsonArrayDebugFeatureItem) {
                            typeId = DebugFeatureListAdapter_ItemTypes.JSON_ARRAY.getTypeId();
                        }
                    }
                }
            }
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: h, reason: from kotlin metadata */
    public void onBindViewHolder(n0.e holder, int position) {
        n.f(holder, "holder");
        if (holder instanceof DebugFeatureListAdapter_BooleanHolder) {
            (DebugFeatureListAdapter_BooleanHolder)holder.c().V((DebugFeatureItem_BooleanDebugFeatureItem)getItemCount().get(position));
        } else {
            if (holder instanceof DebugFeatureListAdapter_StringHolder) {
                (DebugFeatureListAdapter_StringHolder)holder.c().V((DebugFeatureItem_StringDebugFeatureItem)getItemCount().get(position));
            } else {
                if (holder instanceof DebugFeatureListAdapter_DoubleHolder) {
                    (DebugFeatureListAdapter_DoubleHolder)holder.c().V((DebugFeatureItem_DoubleDebugFeatureItem)getItemCount().get(position));
                } else {
                    if (holder instanceof DebugFeatureListAdapter_LongHolder) {
                        (DebugFeatureListAdapter_LongHolder)holder.c().V((DebugFeatureItem_LongDebugFeatureItem)getItemCount().get(position));
                    } else {
                        if (holder instanceof DebugFeatureListAdapter_JsonArrayHolder) {
                            (DebugFeatureListAdapter_JsonArrayHolder)holder.c().V((DebugFeatureItem_JsonArrayDebugFeatureItem)getItemCount().get(position));
                        }
                    }
                }
            }
        }
        holder.a().p();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    /* renamed from: i, reason: from kotlin metadata */
    public n0.e onCreateViewHolder(ViewGroup parent, int viewType) throws NoWhenBranchMatchedException {
        app.dogo.com.dogo_android.i.n0.a debugFeatureListAdapter_BooleanHolder;
        n.f(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        int i2 = app.dogo.com.dogo_android.debug.n0.j.a[DebugFeatureListAdapter_ItemTypes.INSTANCE.a(viewType).ordinal()];
        int i = 1;
        final String str2 = "inflate(inflater, parent, false)";
        final boolean z = false;
        if (i2 != 1) {
            i = 2;
            if (i2 != 2) {
                i = 3;
                if (i2 != 3) {
                    i = 4;
                    if (i2 != 4) {
                        i = 5;
                        if (i2 != 5) {
                            throw new NoWhenBranchMatchedException();
                        } else {
                            e7 e7Var = e7.T(from, parent, z);
                            n.e(e7Var, str2);
                            app.dogo.com.dogo_android.i.n0.g debugFeatureListAdapter_JsonArrayHolder = new DebugFeatureListAdapter_JsonArrayHolder(this, e7Var);
                        }
                    }
                    c7 c7Var = c7.T(from, parent, z);
                    n.e(c7Var, str2);
                    app.dogo.com.dogo_android.i.n0.h debugFeatureListAdapter_LongHolder = new DebugFeatureListAdapter_LongHolder(this, c7Var);
                } else {
                    c7 c7Var2 = c7.T(from, parent, z);
                    n.e(c7Var2, str2);
                    app.dogo.com.dogo_android.i.n0.i debugFeatureListAdapter_StringHolder = new DebugFeatureListAdapter_StringHolder(this, c7Var2);
                }
            } else {
                c7 c7Var3 = c7.T(from, parent, z);
                n.e(c7Var3, str2);
                app.dogo.com.dogo_android.i.n0.d debugFeatureListAdapter_DoubleHolder = new DebugFeatureListAdapter_DoubleHolder(this, c7Var3);
            }
        } else {
            g7 g7Var = g7.T(from, parent, z);
            n.e(g7Var, str2);
            debugFeatureListAdapter_BooleanHolder = new DebugFeatureListAdapter_BooleanHolder(this, g7Var);
        }
        return debugFeatureListAdapter_BooleanHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$h
    public final void j(List<? extends m0> list) {
        n.f(list, "<set-?>");
        this.b.setValue(this, DebugFeatureListAdapter.c[0], list);
    }

    public n0(n0.b bVar) {
        super();
        this.callbacks = bVar;
        List list = p.g();
        this.b = new Delegates_observable_1(list, list, this);
    }

    public n0() {
        final app.dogo.com.dogo_android.i.n0.b bVar = null;
        this(bVar, 1, bVar);
    }
}
