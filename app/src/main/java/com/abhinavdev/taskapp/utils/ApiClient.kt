package com.abhinavdev.taskapp.utils

import android.annotation.SuppressLint
import com.localebro.okhttpprofiler.OkHttpProfilerInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.cert.CertificateException
import java.security.cert.X509Certificate
import java.util.concurrent.TimeUnit
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSession
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

object ApiClient {
    private var retrofit: Retrofit? = null
    val client: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl("http://admin.t3al.net/api/v2/")
                    .client(
                        unsafeOkHttpClient
                    )
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit
        }

    // Create a trust manager that does not validate certificate chains
    private val unsafeOkHttpClient: OkHttpClient
        get() = try {
            // Create a trust manager that does not validate certificate chains
            val trustAllCerts = arrayOf<TrustManager>(@SuppressLint("CustomX509TrustManager")
            object : X509TrustManager {
                @Throws(CertificateException::class)
                override fun checkClientTrusted(
                    chain: Array<X509Certificate>,
                    authType: String
                ) {
                }

                @Throws(CertificateException::class)
                override fun checkServerTrusted(
                    chain: Array<X509Certificate>,
                    authType: String
                ) {
                }

                override fun getAcceptedIssuers(): Array<X509Certificate> {
                    return arrayOf()
                }
            })

            // Create a new SSL context with the default trust manager
            val sslContext = SSLContext.getInstance("TLS")
            sslContext.init(null, trustAllCerts, null)

            // Create a new SSL socket factory with the updated SSL context
            val sslSocketFactory = sslContext.socketFactory

            // Create a new HostnameVerifier that allows all hostnames
            val hostnameVerifier = HostnameVerifier { _: String?, _: SSLSession? -> true }
            val interceptor = OkHttpProfilerInterceptor()

            val builder = OkHttpClient.Builder()

            builder.addInterceptor(interceptor)

            builder.connectTimeout(200, TimeUnit.SECONDS)
                .writeTimeout(400, TimeUnit.SECONDS)
                .readTimeout(200, TimeUnit.SECONDS)
                .sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
                .hostnameVerifier(hostnameVerifier)

            builder.build()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
}