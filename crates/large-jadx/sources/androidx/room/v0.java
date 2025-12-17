package androidx.room;

/* loaded from: classes.dex */
public class v0 {
    public static String a(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '");
        stringBuilder.append(string);
        stringBuilder.append("')");
        return stringBuilder.toString();
    }
}
