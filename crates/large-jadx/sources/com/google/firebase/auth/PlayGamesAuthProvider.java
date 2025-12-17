package com.google.firebase.auth;

/* loaded from: classes2.dex */
public class PlayGamesAuthProvider {

    public static final String PLAY_GAMES_SIGN_IN_METHOD = "playgames.google.com";
    public static final String PROVIDER_ID = "playgames.google.com";
    public static com.google.firebase.auth.AuthCredential getCredential(String string) {
        PlayGamesAuthCredential playGamesAuthCredential = new PlayGamesAuthCredential(string);
        return playGamesAuthCredential;
    }
}
