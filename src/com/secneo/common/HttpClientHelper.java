/*
 * Copyright (c) 2013. Kevin Lee (www.buybal.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.secneo.common;

import android.content.Context;
import android.webkit.WebView;

import org.apache.http.HttpVersion;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;

import java.io.IOException;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * Created with IntelliJ IDEA.
 * User: Kevin
 * Date: 13-11-7
 * Time: 下午7:34
 * To change this template use File | Settings | File Templates.
 */
public class HttpClientHelper {
    /**
     * http请求�?��并发连接�?
     */
    private static final int DEFAULT_MAX_CONNECTIONS = 100;
    private static int maxConnections = DEFAULT_MAX_CONNECTIONS;
    /**
     * 超时时间，默�?0�?
     */
    private static final int DEFAULT_SOCKET_TIMEOUT = 30 * 1000;
    private static int socketTimeout = DEFAULT_SOCKET_TIMEOUT;
    /**
     * 默认的套接字缓冲区大�?
     */
    private static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;
    private static DefaultHttpClient httpClient;

    private HttpClientHelper() {
    }

    public static synchronized DefaultHttpClient getHttpClient() {
        if (null == httpClient) {
            // 初始化工�?
            try {
                KeyStore trustStore = KeyStore.getInstance(KeyStore
                        .getDefaultType());
                trustStore.load(null, null);
                BasicHttpParams httpParams = new BasicHttpParams();
                ConnManagerParams.setTimeout(httpParams, socketTimeout);
                ConnManagerParams.setMaxConnectionsPerRoute(httpParams,
                        new ConnPerRouteBean(maxConnections));
                ConnManagerParams.setMaxTotalConnections(httpParams,
                        DEFAULT_MAX_CONNECTIONS);

                HttpConnectionParams.setSoTimeout(httpParams, socketTimeout);
                HttpConnectionParams.setConnectionTimeout(httpParams,
                        socketTimeout);
                HttpConnectionParams.setTcpNoDelay(httpParams, true);
                HttpConnectionParams.setSocketBufferSize(httpParams,
                        DEFAULT_SOCKET_BUFFER_SIZE);

                HttpProtocolParams.setVersion(httpParams, HttpVersion.HTTP_1_1);

//                HttpProtocolParams.setUserAgent(httpParams, String
//                        .format("KevinLee/%s (http://www.qdcf.com)",
//                                VERSION));


//                HttpProtocolParams.setUserAgent(httpParams, "Mozilla/5.0(Linux;U;Android 2.2.1;en-us;Nexus One Build.FRG83) \"\n" +
//                        "+ \"AppleWebKit/553.1(KHTML,like Gecko) Version/4.0 Mobile Safari/533.1");
                // 设置 https支持
                SSLSocketFactory sf = new SSLSocketFactoryEx(trustStore);
                sf.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER); // 允许�?��主机的验�?
                SchemeRegistry schReg = new SchemeRegistry();
                schReg.register(new Scheme("http", PlainSocketFactory
                        .getSocketFactory(), 80));
                schReg.register(new Scheme("https", sf, 443));
                ClientConnectionManager conManager = new ThreadSafeClientConnManager(
                        httpParams, schReg);
                httpClient = new DefaultHttpClient(conManager, httpParams);
            } catch (Exception e) {
                e.printStackTrace();
                return new DefaultHttpClient();
            }
        }
        return httpClient;
    }

    @SuppressWarnings("unused")
    private String getCurrentUserAgent(Context context) {
        return new WebView(context).getSettings().getUserAgentString();
    }
}

class SSLSocketFactoryEx extends SSLSocketFactory {
    SSLContext sslContext = SSLContext.getInstance("TLS");

    public SSLSocketFactoryEx(KeyStore truststore)
            throws NoSuchAlgorithmException, KeyManagementException,
            KeyStoreException, UnrecoverableKeyException {
        super(truststore);
        TrustManager tm = new X509TrustManager() {
            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            @Override
            public void checkClientTrusted(
                    java.security.cert.X509Certificate[] chain, String authType)
                    throws java.security.cert.CertificateException {

            }

            @Override
            public void checkServerTrusted(
                    java.security.cert.X509Certificate[] chain, String authType)
                    throws java.security.cert.CertificateException {

            }
        };

        sslContext.init(null, new TrustManager[]{tm}, null);
    }

    @Override
    public Socket createSocket(Socket socket, String host, int port,
                               boolean autoClose) throws IOException {
        return sslContext.getSocketFactory().createSocket(socket, host, port, autoClose);
    }

    @Override
    public Socket createSocket() throws IOException {
        return sslContext.getSocketFactory().createSocket();
    }
}
