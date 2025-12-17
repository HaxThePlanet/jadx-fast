package androidx.core.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class o {

    private final String a;
    private final java.lang.CharSequence b;
    private final java.lang.CharSequence[] c;
    private final boolean d;
    private final int e;
    private final Bundle f;
    private final Set<String> g;

    public static final class a {

        private final String a;
        private final Set<String> b;
        private final Bundle c;
        private java.lang.CharSequence d;
        private java.lang.CharSequence[] e;
        private boolean f = true;
        private int g = 0;
        public a(String string) {
            super();
            HashSet hashSet = new HashSet();
            this.b = hashSet;
            Bundle bundle = new Bundle();
            this.c = bundle;
            int i = 1;
            int i2 = 0;
            if (string == null) {
            } else {
                this.a = string;
            }
            IllegalArgumentException obj2 = new IllegalArgumentException("Result key can't be null");
            throw obj2;
        }

        public androidx.core.app.o a() {
            super(this.a, this.d, this.e, this.f, this.g, this.c, this.b);
            return oVar2;
        }

        public androidx.core.app.o.a b(java.lang.CharSequence charSequence) {
            this.d = charSequence;
            return this;
        }
    }
    o(String string, java.lang.CharSequence charSequence2, java.lang.CharSequence[] charSequence3Arr3, boolean z4, int i5, Bundle bundle6, Set<String> set7) {
        int obj1;
        super();
        this.a = string;
        this.b = charSequence2;
        this.c = charSequence3Arr3;
        this.d = z4;
        this.e = i5;
        this.f = bundle6;
        this.g = set7;
        if (g() == 2) {
            if (!c()) {
            } else {
            }
            obj1 = new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
            throw obj1;
        }
    }

    static RemoteInput a(androidx.core.app.o o) {
        int sDK_INT;
        int next;
        int i;
        int obj4;
        RemoteInput.Builder builder = new RemoteInput.Builder(o.j());
        RemoteInput.Builder extras = builder.setLabel(o.i()).setChoices(o.e()).setAllowFreeFormInput(o.c()).addExtras(o.h());
        sDK_INT = o.d();
        if (Build.VERSION.SDK_INT >= 26 && sDK_INT != null) {
            sDK_INT = o.d();
            if (sDK_INT != null) {
                sDK_INT = sDK_INT.iterator();
                for (String next : sDK_INT) {
                    extras.setAllowDataType(next, true);
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 29) {
            extras.setEditChoicesBeforeSending(o.g());
        }
        return extras.build();
    }

    static RemoteInput[] b(androidx.core.app.o[] oArr) {
        int i;
        RemoteInput remoteInput;
        if (oArr == null) {
            return null;
        }
        RemoteInput[] arr = new RemoteInput[oArr.length];
        i = 0;
        for (Object obj : oArr) {
            arr[i] = o.a(obj);
        }
        return arr;
    }

    private static Intent f(Intent intent) {
        ClipData obj3 = intent.getClipData();
        int i = 0;
        if (obj3 == null) {
            return i;
        }
        ClipDescription description = obj3.getDescription();
        if (!description.hasMimeType("text/vnd.android.intent")) {
            return i;
        }
        if (!description.getLabel().toString().contentEquals("android.remoteinput.results")) {
            return i;
        }
        return obj3.getItemAt(0).getIntent();
    }

    public static Bundle k(Intent intent) {
        int sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 20) {
            return RemoteInput.getResultsFromIntent(intent);
        }
        final int i3 = 0;
        Intent obj3 = o.f(intent);
        if (sDK_INT >= 16 && obj3 == null) {
            obj3 = o.f(intent);
            if (obj3 == null) {
                return i3;
            }
            return (Bundle)obj3.getExtras().getParcelable("android.remoteinput.resultsData");
        }
        return i3;
    }

    public boolean c() {
        return this.d;
    }

    public Set<String> d() {
        return this.g;
    }

    public java.lang.CharSequence[] e() {
        return this.c;
    }

    public int g() {
        return this.e;
    }

    public Bundle h() {
        return this.f;
    }

    public java.lang.CharSequence i() {
        return this.b;
    }

    public String j() {
        return this.a;
    }

    public boolean l() {
        int i;
        boolean length;
        if (!c()) {
            if (e() != null) {
                if (objArr.length == 0 && d() != null && !d().isEmpty()) {
                    if (d() != null) {
                        i = !d().isEmpty() ? 1 : 0;
                    } else {
                    }
                } else {
                }
            } else {
            }
        } else {
        }
        return i;
    }
}
