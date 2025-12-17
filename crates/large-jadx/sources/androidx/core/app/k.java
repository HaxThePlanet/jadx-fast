package androidx.core.app;

import android.app.Notification;
import android.app.Notification.Action.Builder;
import android.app.Notification.Builder;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.content.b;
import androidx.core.graphics.drawable.IconCompat;
import d.e.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes.dex */
class k implements androidx.core.app.i {

    private final Context a;
    private final Notification.Builder b;
    private final androidx.core.app.j.e c;
    private RemoteViews d;
    private RemoteViews e;
    private final List<Bundle> f;
    private final Bundle g;
    private int h;
    private RemoteViews i;
    k(androidx.core.app.j.e j$e) {
        boolean z;
        Object str2;
        int sDK_INT4;
        int sDK_INT2;
        Object iterator;
        Bundle bundle;
        int sDK_INT5;
        int sDK_INT3;
        int sDK_INT;
        Notification.Builder builder;
        Object notification;
        Context context;
        Object publicVersion;
        int i6;
        int i4;
        String str;
        int i9;
        int i2;
        int i8;
        int i5;
        int i3;
        int next;
        int i10;
        int lights;
        int next3;
        boolean next2;
        int i;
        int defaults;
        boolean z2;
        int i11;
        int audioAttributes;
        boolean audioStreamType;
        int i7;
        String string;
        Bundle bundle2;
        boolean obj14;
        super();
        ArrayList arrayList = new ArrayList();
        this.f = arrayList;
        Bundle bundle3 = new Bundle();
        this.g = bundle3;
        this.c = e;
        this.a = e.a;
        sDK_INT2 = Build.VERSION.SDK_INT;
        final int i12 = 26;
        if (sDK_INT2 >= i12) {
            builder = new Notification.Builder(e.a, e.K);
            this.b = builder;
        } else {
            builder = new Notification.Builder(e.a);
            this.b = builder;
        }
        notification = e.S;
        int i18 = 2;
        int i19 = 1;
        lights = 0;
        i9 = flags &= i18 != 0 ? i19 : lights;
        i2 = flags2 &= 8 != 0 ? i19 : lights;
        next2 = 16;
        i8 = flags3 &= next2 != 0 ? i19 : lights;
        i11 = flags4 &= 128 != 0 ? i19 : lights;
        this.b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, e.i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing(i9).setOnlyAlertOnce(i2).setAutoCancel(i8).setDefaults(notification.defaults).setContentTitle(e.e).setContentText(e.f).setContentInfo(e.k).setContentIntent(e.g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(e.h, i11).setLargeIcon(e.j).setNumber(e.l).setProgress(e.t, e.u, e.v);
        publicVersion = 21;
        if (sDK_INT2 < publicVersion) {
            this.b.setSound(notification.sound, notification.audioStreamType);
        }
        i3 = 20;
        if (sDK_INT2 >= next2) {
            this.b.setSubText(e.q).setUsesChronometer(e.o).setPriority(e.m);
            Iterator iterator2 = e.b.iterator();
            for (j.a next3 : iterator2) {
                b(next3);
            }
            Bundle bundle4 = e.D;
            if (bundle4 != null) {
                this.g.putAll(bundle4);
            }
            if (Build.VERSION.SDK_INT < i3 && e.z) {
                if (e.z) {
                    this.g.putBoolean("android.support.localOnly", i19);
                }
                str2 = e.w;
                if (str2 != null) {
                    this.g.putString("android.support.groupKey", str2);
                    if (e.x) {
                        this.g.putBoolean("android.support.isGroupSummary", i19);
                    } else {
                        this.g.putBoolean("android.support.useSideChannel", i19);
                    }
                }
                sDK_INT4 = e.y;
                if (sDK_INT4 != null) {
                    this.g.putString("android.support.sortKey", sDK_INT4);
                }
            }
            this.d = e.H;
            this.e = e.I;
        }
        sDK_INT5 = Build.VERSION.SDK_INT;
        if (sDK_INT5 >= 17) {
            this.b.setShowWhen(e.n);
        }
        defaults = k.e(k.g(e.c), e.V);
        if (sDK_INT5 >= 19 && sDK_INT5 < publicVersion && defaults != null && !defaults.isEmpty()) {
            if (sDK_INT5 < publicVersion) {
                defaults = k.e(k.g(e.c), e.V);
                if (defaults != null) {
                    if (!defaults.isEmpty()) {
                        this.g.putStringArray("android.people", (String[])defaults.toArray(new String[defaults.size()]));
                    }
                }
            }
        }
        if (sDK_INT5 >= i3) {
            this.b.setLocalOnly(e.z).setGroup(e.w).setGroupSummary(e.x).setSortKey(e.y);
            this.h = e.P;
        }
        next = 28;
        if (sDK_INT5 >= publicVersion) {
            this.b.setCategory(e.C).setColor(e.E).setVisibility(e.F).setPublicVersion(e.G).setSound(notification.sound, notification.audioAttributes);
            if (sDK_INT5 < next) {
                iterator = k.e(k.g(e.c), e.V);
            } else {
                iterator = e.V;
            }
            if (iterator != null && !iterator.isEmpty()) {
                if (!iterator.isEmpty()) {
                    iterator = iterator.iterator();
                    for (String publicVersion : iterator) {
                        this.b.addPerson(publicVersion);
                    }
                }
            }
            this.i = e.J;
            publicVersion = "android.car.EXTENSIONS";
            if (e.d.size() > 0 && e.d().getBundle(publicVersion) == null) {
                publicVersion = "android.car.EXTENSIONS";
                if (e.d().getBundle(publicVersion) == null) {
                    bundle = new Bundle();
                }
                defaults = new Bundle(bundle);
                Bundle bundle8 = new Bundle();
                i7 = lights;
                while (i7 < e.d.size()) {
                    bundle8.putBundle(Integer.toString(i7), l.b((j.a)e.d.get(i7)));
                    i7++;
                }
                audioStreamType = "invisible_actions";
                bundle.putBundle(audioStreamType, bundle8);
                defaults.putBundle(audioStreamType, bundle8);
                e.d().putBundle(publicVersion, bundle);
                this.g.putBundle(publicVersion, defaults);
            }
        }
        sDK_INT3 = Build.VERSION.SDK_INT;
        i6 = e.U;
        if (sDK_INT3 >= 23 && i6 != null) {
            i6 = e.U;
            if (i6 != null) {
                this.b.setSmallIcon(i6);
            }
        }
        this.b.setExtras(e.D).setRemoteInputHistory(e.s);
        RemoteViews view3 = e.H;
        if (sDK_INT3 >= 24 && view3 != null) {
            this.b.setExtras(e.D).setRemoteInputHistory(e.s);
            view3 = e.H;
            if (view3 != null) {
                this.b.setCustomContentView(view3);
            }
            RemoteViews view4 = e.I;
            if (view4 != null) {
                this.b.setCustomBigContentView(view4);
            }
            i4 = e.J;
            if (i4 != null) {
                this.b.setCustomHeadsUpContentView(i4);
            }
        }
        int i13 = 0;
        this.b.setBadgeIconType(e.L).setSettingsText(e.r).setShortcutId(e.M).setTimeoutAfter(e.O).setGroupAlertBehavior(e.P);
        if (sDK_INT3 >= i12 && e.B) {
            this.b.setBadgeIconType(e.L).setSettingsText(e.r).setShortcutId(e.M).setTimeoutAfter(e.O).setGroupAlertBehavior(e.P);
            if (e.B) {
                this.b.setColorized(e.A);
            }
            if (!TextUtils.isEmpty(e.K)) {
                this.b.setSound(i13).setDefaults(lights).setLights(lights, lights, lights).setVibrate(i13);
            }
        }
        if (sDK_INT3 >= next) {
            sDK_INT3 = e.c.iterator();
            for (n next4 : sDK_INT3) {
                this.b.addPerson(next4.h());
            }
        }
        sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 29) {
            this.b.setAllowSystemGeneratedContextualActions(e.Q);
            this.b.setBubbleMetadata(j.d.c(e.R));
            i10 = e.N;
            if (i10 != null) {
            } else {
            }
            i10.a();
            throw i13;
        }
        if (e.T) {
            if (obj14.x) {
                this.h = i18;
            } else {
                this.h = i19;
            }
            this.b.setVibrate(i13);
            this.b.setSound(i13);
            obj14 &= -2;
            notification.defaults = obj14;
            obj14 &= -3;
            notification.defaults = obj14;
            this.b.setDefaults(obj14);
            if (sDK_INT >= i12 && TextUtils.isEmpty(obj14.w)) {
                if (TextUtils.isEmpty(obj14.w)) {
                    this.b.setGroup("silent");
                }
                this.b.setGroupAlertBehavior(this.h);
            }
        }
    }

    private void b(androidx.core.app.j.a j$a) {
        Notification.Action.Builder builder;
        android.app.Notification.Action sDK_INT;
        int i5;
        androidx.core.app.o[] objArr;
        Bundle bundle;
        java.lang.CharSequence length;
        int sDK_INT2;
        String str2;
        int i4;
        int i;
        int i2;
        int i3;
        android.app.PendingIntent intent;
        String str;
        Object obj6;
        sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 20) {
            IconCompat iconCompat = a.e();
            if (sDK_INT >= 23) {
                if (iconCompat != null) {
                    i5 = iconCompat.p();
                } else {
                    i5 = 0;
                }
                builder = new Notification.Action.Builder(i5, a.i(), a.a());
            } else {
                if (iconCompat != null) {
                    i5 = iconCompat.e();
                } else {
                    i5 = i4;
                }
                builder = new Notification.Action.Builder(i5, a.i(), a.a());
            }
            if (a.f() != null) {
                objArr = o.b(a.f());
                while (i4 < objArr.length) {
                    builder.addRemoteInput(objArr[i4]);
                    i4++;
                }
            }
            if (a.d() != null) {
                bundle = new Bundle(a.d());
            } else {
                bundle = new Bundle();
            }
            bundle.putBoolean("android.support.allowGeneratedReplies", a.b());
            sDK_INT2 = Build.VERSION.SDK_INT;
            if (sDK_INT2 >= 24) {
                builder.setAllowGeneratedReplies(a.b());
            }
            bundle.putInt("android.support.action.semanticAction", a.g());
            if (sDK_INT2 >= 28) {
                builder.setSemanticAction(a.g());
            }
            if (sDK_INT2 >= 29) {
                builder.setContextual(a.j());
            }
            bundle.putBoolean("android.support.action.showsUserInterface", a.h());
            builder.addExtras(bundle);
            this.b.addAction(builder.build());
        } else {
            if (sDK_INT >= 16) {
                this.f.add(l.f(this.b, a));
            }
        }
    }

    private static List<String> e(List<String> list, List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        b bVar = new b(size += size2);
        bVar.addAll(list);
        bVar.addAll(list2);
        ArrayList obj3 = new ArrayList(bVar);
        return obj3;
    }

    private static List<String> g(List<androidx.core.app.n> list) {
        int size;
        if (list == null) {
            return 0;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator obj2 = list.iterator();
        for (n next2 : obj2) {
            arrayList.add(next2.g());
        }
        return arrayList;
    }

    private void h(Notification notification) {
        int i = 0;
        notification.sound = i;
        notification.vibrate = i;
        defaults &= -2;
        notification.defaults = i2;
        notification.defaults = i2 &= -3;
    }

    @Override // androidx.core.app.i
    public Notification.Builder a() {
        return this.b;
    }

    @Override // androidx.core.app.i
    public Notification c() {
        RemoteViews view;
        int sDK_INT;
        RemoteViews view2;
        int i;
        androidx.core.app.j.f fVar = eVar.p;
        if (fVar != null) {
            fVar.b(this);
        }
        if (fVar != null) {
            view = fVar.e(this);
        } else {
            view = 0;
        }
        final Notification notification = d();
        if (view != null) {
            notification.contentView = view;
        } else {
            view = eVar2.H;
            if (view != null) {
                notification.contentView = view;
            }
        }
        sDK_INT = Build.VERSION.SDK_INT;
        final int i2 = 16;
        view2 = fVar.d(this);
        if (sDK_INT >= i2 && fVar != null && view2 != null) {
            if (fVar != null) {
                view2 = fVar.d(this);
                if (view2 != null) {
                    notification.bigContentView = view2;
                }
            }
        }
        i = eVar3.p.f(this);
        if (sDK_INT >= 21 && fVar != null && i != null) {
            if (fVar != null) {
                i = eVar3.p.f(this);
                if (i != null) {
                    notification.headsUpContentView = i;
                }
            }
        }
        sDK_INT = j.a(notification);
        if (sDK_INT >= i2 && fVar != null && sDK_INT != null) {
            if (fVar != null) {
                sDK_INT = j.a(notification);
                if (sDK_INT != null) {
                    fVar.a(sDK_INT);
                }
            }
        }
        return notification;
    }

    @Override // androidx.core.app.i
    protected Notification d() {
        int group;
        String group2;
        int group5;
        String group3;
        int i;
        int group6;
        String group4;
        Bundle bundle;
        Object next;
        boolean key;
        int sDK_INT = Build.VERSION.SDK_INT;
        if (sDK_INT >= 26) {
            return this.b.build();
        }
        int i7 = 1;
        int i8 = 2;
        Notification build = this.b.build();
        if (sDK_INT >= 24 && this.h != 0 && build.getGroup() != null && flags &= 512 != 0 && this.h == i8) {
            build = this.b.build();
            if (this.h != 0) {
                if (build.getGroup() != null) {
                    if (flags &= 512 != 0) {
                        if (this.h == i8) {
                            h(build);
                        }
                    }
                }
                if (build.getGroup() != null && flags2 &= 512 == 0 && this.h == i7) {
                    if (flags2 &= 512 == 0) {
                        if (this.h == i7) {
                            h(build);
                        }
                    }
                }
            }
            return build;
        }
        this.b.setExtras(this.g);
        Notification build5 = this.b.build();
        RemoteViews view7 = this.d;
        if (sDK_INT >= 21 && view7 != null) {
            this.b.setExtras(this.g);
            build5 = this.b.build();
            view7 = this.d;
            if (view7 != null) {
                build5.contentView = view7;
            }
            RemoteViews view8 = this.e;
            if (view8 != null) {
                build5.bigContentView = view8;
            }
            RemoteViews view9 = this.i;
            if (view9 != null) {
                build5.headsUpContentView = view9;
            }
            if (this.h != 0 && build5.getGroup() != null && flags6 &= 512 != 0 && this.h == i8) {
                if (build5.getGroup() != null) {
                    if (flags6 &= 512 != 0) {
                        if (this.h == i8) {
                            h(build5);
                        }
                    }
                }
                if (build5.getGroup() != null && flags5 &= 512 == 0 && this.h == i7) {
                    if (flags5 &= 512 == 0) {
                        if (this.h == i7) {
                            h(build5);
                        }
                    }
                }
            }
            return build5;
        }
        this.b.setExtras(this.g);
        Notification build2 = this.b.build();
        RemoteViews view = this.d;
        if (sDK_INT >= 20 && view != null) {
            this.b.setExtras(this.g);
            build2 = this.b.build();
            view = this.d;
            if (view != null) {
                build2.contentView = view;
            }
            RemoteViews view2 = this.e;
            if (view2 != null) {
                build2.bigContentView = view2;
            }
            if (this.h != 0 && build2.getGroup() != null && flags3 &= 512 != 0 && this.h == i8) {
                if (build2.getGroup() != null) {
                    if (flags3 &= 512 != 0) {
                        if (this.h == i8) {
                            h(build2);
                        }
                    }
                }
                if (build2.getGroup() != null && flags4 &= 512 == 0 && this.h == i7) {
                    if (flags4 &= 512 == 0) {
                        if (this.h == i7) {
                            h(build2);
                        }
                    }
                }
            }
            return build2;
        }
        String str = "android.support.actionExtras";
        android.util.SparseArray sparseArray = l.a(this.f);
        if (sDK_INT >= 19 && sparseArray != null) {
            sparseArray = l.a(this.f);
            if (sparseArray != null) {
                this.g.putSparseParcelableArray(str, sparseArray);
            }
            this.b.setExtras(this.g);
            Notification build4 = this.b.build();
            RemoteViews view5 = this.d;
            if (view5 != null) {
                build4.contentView = view5;
            }
            RemoteViews view6 = this.e;
            if (view6 != null) {
                build4.bigContentView = view6;
            }
            return build4;
        }
        if (sDK_INT >= 16) {
            Notification build3 = this.b.build();
            Bundle bundle3 = j.a(build3);
            bundle = new Bundle(this.g);
            Iterator iterator = this.g.keySet().iterator();
            while (iterator.hasNext()) {
                next = iterator.next();
                if (bundle3.containsKey((String)next)) {
                }
                bundle.remove(next);
            }
            bundle3.putAll(bundle);
            android.util.SparseArray sparseArray2 = l.a(this.f);
            if (sparseArray2 != null) {
                j.a(build3).putSparseParcelableArray(str, sparseArray2);
            }
            RemoteViews view3 = this.d;
            if (view3 != null) {
                build3.contentView = view3;
            }
            RemoteViews view4 = this.e;
            if (view4 != null) {
                build3.bigContentView = view4;
            }
            return build3;
        }
        return this.b.getNotification();
    }

    @Override // androidx.core.app.i
    Context f() {
        return this.a;
    }
}
