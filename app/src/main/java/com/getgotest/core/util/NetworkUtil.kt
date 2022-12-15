package com.getgotest.core.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import android.util.Log
import android.widget.Toast
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.getgotest.BuildConfig
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.ToNumberPolicy
import okhttp3.CertificatePinner
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.lang.reflect.Type
import java.net.Inet4Address
import java.net.InetAddress
import java.net.NetworkInterface
import java.security.SecureRandom
import java.security.cert.X509Certificate
import java.util.*
import java.util.concurrent.TimeUnit

object NetworkUtil {

    const val baseURL = "https://rickandmortyapi.com/api/"

    fun provideRetrofit(
        okHttpClient: OkHttpClient, baseUrl: String,
        adapterPairs:List<Pair<Type, Any>>?=null
    ): Retrofit {

        val gsonBuilder = GsonBuilder()
            .setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
            .setLenient()

        adapterPairs?.forEach{
            gsonBuilder.registerTypeAdapter(it.first, it.second)
        }

        val gson = gsonBuilder.create()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    fun provideRetrofitScalar(
        okHttpClient: OkHttpClient,
        baseUrl: String
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()
    }

    fun provideOkHttpClient(
        context: Context,
        interceptors: List<Interceptor>
    ): OkHttpClient {
        val builder = OkHttpClient().newBuilder()
        for (items in interceptors) {
            builder.addInterceptor(items)
        }
        return builder
            .connectTimeout(30, TimeUnit.SECONDS)
            .callTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(ChuckerInterceptor(context))
            .addLoggingInterceptor()
            .build()
    }

    private fun OkHttpClient.Builder.addLoggingInterceptor(): OkHttpClient.Builder {
        if (BuildConfig.DEBUG) {
            val interceptor = HttpLoggingInterceptor { message ->
                Log.d(this@NetworkUtil::class.java.simpleName, message)
            }
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            addInterceptor(interceptor)
        }
        return this
    }

    fun hasNetwork(context: Context): Boolean {
        var isConnected = false // Initial Value
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnected)
            isConnected = true
        return isConnected
    }

    fun getCellNetworkIp(context: Context): String? {
        return try {
            val enumerationNetworkInterface: Enumeration<NetworkInterface> =
                NetworkInterface.getNetworkInterfaces()
            while (enumerationNetworkInterface.hasMoreElements()) {
                val networkInterface: NetworkInterface = enumerationNetworkInterface.nextElement()
                val enumerationInetAddress: Enumeration<InetAddress> =
                    networkInterface.inetAddresses
                while (enumerationInetAddress.hasMoreElements()) {
                    val inetAddress = enumerationInetAddress.nextElement()
                    val ipAddress = inetAddress.address
                    if (!inetAddress.isLoopbackAddress && inetAddress is Inet4Address){
                        val numericAddress = InetAddress.getByAddress(ipAddress)
                        return numericAddress.hostAddress
                    }
                }
            }
            null
        } catch (e: java.lang.Exception) {
            Toast.makeText(context, "$e", Toast.LENGTH_SHORT).show()
            null
        }
    }

    fun checkConnectivity (
        context: Context,
        onUsingWifi: (() -> Unit)? = null,
        onUsingCellular: (() -> Unit)? = null,
        onUsingEthernet: (() -> Unit)? = null,
    ): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork) ?: return false
            return when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    onUsingWifi?.invoke()
                    true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                    onUsingEthernet?.invoke()
                    true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    onUsingCellular?.invoke()
                    true
                }
                else -> false
            }
        }
        else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            val netInfo = connectivityManager.activeNetworkInfo
            return if (netInfo != null && netInfo.isConnected && netInfo.type == ConnectivityManager.TYPE_WIFI) {
                onUsingWifi?.invoke()
                true
            } else if (netInfo != null && netInfo.isConnected && netInfo.type == ConnectivityManager.TYPE_MOBILE) {
                onUsingCellular?.invoke()
                true
            } else if (netInfo != null && netInfo.isConnected && netInfo.type == ConnectivityManager.TYPE_ETHERNET) {
                onUsingEthernet?.invoke()
                true
            } else false
        }
        return false
    }
}