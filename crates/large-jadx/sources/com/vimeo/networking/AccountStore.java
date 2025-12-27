package com.vimeo.networking;

import com.vimeo.networking.model.VimeoAccount;

/* compiled from: AccountStore.java */
/* loaded from: classes2.dex */
public interface AccountStore {
    void deleteAccount(VimeoAccount vimeoAccount);

    VimeoAccount loadAccount();

    void saveAccount(VimeoAccount vimeoAccount, String str);

    @Deprecated
    void saveAccount(VimeoAccount vimeoAccount, String str, String str2);
}
