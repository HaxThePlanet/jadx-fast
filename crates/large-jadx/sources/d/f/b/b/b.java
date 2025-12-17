package d.f.b.b;

import android.util.Pair;
import java.util.HashMap;

/* loaded from: classes.dex */
public class b {

    static final HashMap<Pair<Integer, Integer>, String> a;
    static final HashMap<String, String> b;
    static {
        HashMap hashMap = new HashMap();
        b.a = hashMap;
        HashMap hashMap2 = new HashMap();
        b.b = hashMap2;
        Integer valueOf = 4;
        final String str11 = "layout_constraintBottom_toBottomOf";
        hashMap.put(Pair.create(valueOf, valueOf), str11);
        Integer valueOf5 = 3;
        final String str13 = "layout_constraintBottom_toTopOf";
        hashMap.put(Pair.create(valueOf, valueOf5), str13);
        String str12 = "layout_constraintTop_toBottomOf";
        hashMap.put(Pair.create(valueOf5, valueOf), str12);
        String str10 = "layout_constraintTop_toTopOf";
        hashMap.put(Pair.create(valueOf5, valueOf5), str10);
        Integer valueOf2 = 6;
        final String str15 = "layout_constraintStart_toStartOf";
        hashMap.put(Pair.create(valueOf2, valueOf2), str15);
        Integer valueOf6 = 7;
        final String str17 = "layout_constraintStart_toEndOf";
        hashMap.put(Pair.create(valueOf2, valueOf6), str17);
        String str16 = "layout_constraintEnd_toStartOf";
        hashMap.put(Pair.create(valueOf6, valueOf2), str16);
        String str14 = "layout_constraintEnd_toEndOf";
        hashMap.put(Pair.create(valueOf6, valueOf6), str14);
        Integer valueOf3 = 1;
        final String str19 = "layout_constraintLeft_toLeftOf";
        hashMap.put(Pair.create(valueOf3, valueOf3), str19);
        Integer valueOf7 = 2;
        final String str21 = "layout_constraintLeft_toRightOf";
        hashMap.put(Pair.create(valueOf3, valueOf7), str21);
        final String str22 = "layout_constraintRight_toRightOf";
        hashMap.put(Pair.create(valueOf7, valueOf7), str22);
        String str18 = "layout_constraintRight_toLeftOf";
        hashMap.put(Pair.create(valueOf7, valueOf3), str18);
        Integer valueOf4 = 5;
        hashMap.put(Pair.create(valueOf4, valueOf4), "layout_constraintBaseline_toBaselineOf");
        String str = "layout_marginBottom";
        hashMap2.put(str11, str);
        hashMap2.put(str13, str);
        String str2 = "layout_marginTop";
        hashMap2.put(str12, str2);
        hashMap2.put(str10, str2);
        String str3 = "layout_marginStart";
        hashMap2.put(str15, str3);
        hashMap2.put(str17, str3);
        hashMap2.put(str16, "layout_marginEnd");
        hashMap2.put(str14, "layout_marginEnd");
        hashMap2.put(str19, "layout_marginLeft");
        hashMap2.put(str21, "layout_marginLeft");
        hashMap2.put(str22, "layout_marginRight");
        hashMap2.put(str18, "layout_marginRight");
    }

    public b(d.f.b.b.j j) {
        super();
    }
}
