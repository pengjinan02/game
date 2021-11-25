package cn.pja.starter.model.DO;

import java.io.Serializable;

public class UserWithBLOBs extends User implements Serializable {
    /**
     * 
     */
    private byte[] sslCipher;

    /**
     * 
     */
    private byte[] x509Issuer;

    /**
     * 
     */
    private byte[] x509Subject;

    /**
     * 
     */
    private String authenticationString;

    /**
     * user
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     * @return ssl_cipher 
     */
    public byte[] getSslCipher() {
        return sslCipher;
    }

    /**
     * 
     * @param sslCipher 
     */
    public void setSslCipher(byte[] sslCipher) {
        this.sslCipher = sslCipher;
    }

    /**
     * 
     * @return x509_issuer 
     */
    public byte[] getX509Issuer() {
        return x509Issuer;
    }

    /**
     * 
     * @param x509Issuer 
     */
    public void setX509Issuer(byte[] x509Issuer) {
        this.x509Issuer = x509Issuer;
    }

    /**
     * 
     * @return x509_subject 
     */
    public byte[] getX509Subject() {
        return x509Subject;
    }

    /**
     * 
     * @param x509Subject 
     */
    public void setX509Subject(byte[] x509Subject) {
        this.x509Subject = x509Subject;
    }

    /**
     * 
     * @return authentication_string 
     */
    public String getAuthenticationString() {
        return authenticationString;
    }

    /**
     * 
     * @param authenticationString 
     */
    public void setAuthenticationString(String authenticationString) {
        this.authenticationString = authenticationString == null ? null : authenticationString.trim();
    }
}