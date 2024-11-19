package org.sid.inventoryservice.security;

public class JWTUtil {
    public static final String SECRET = "mySecret1234";
    public static final String AUTH_HEADER = "Authorization";
    public static final String PREFIX = "Bearer ";
    public static final long EXPIRE_ACCESS_TOKEN = 60 * 60 * 1000; //5 minute
    public static final long EXPIRE_REFRESH_TOKEN = 480 * 60 * 1000;//15 minute
}
