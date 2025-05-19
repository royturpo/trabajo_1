package pe.edu.upeu.sysventasjpc.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import pe.edu.upeu.sysventasjpc.data.local.DbDataSource
import pe.edu.upeu.sysventasjpc.data.local.dao.MarcaDao
import pe.edu.upeu.sysventasjpc.data.remote.RestCategoria
import pe.edu.upeu.sysventasjpc.data.remote.RestMarca
import pe.edu.upeu.sysventasjpc.data.remote.RestProducto
import pe.edu.upeu.sysventasjpc.data.remote.RestUnidadMedida
import pe.edu.upeu.sysventasjpc.data.remote.RestUsuario
import pe.edu.upeu.sysventasjpc.utils.TokenUtils
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {
    var retrofit: Retrofit?=null

    @Singleton
    @Provides
    @Named("BaseUrl")
    fun provideBaseUrl()=TokenUtils.API_URL

    @Singleton
    @Provides
    fun provideRetrofit(@Named("BaseUrl") baseUrl:String): Retrofit {
        val okHttpClient= OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()
        if (retrofit==null){
            retrofit= Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .baseUrl(baseUrl).build()
        }
        return retrofit!!
    }



    @Singleton
    @Provides
    fun restUsuario(retrofit: Retrofit):RestUsuario{
        return retrofit.create(RestUsuario::class.java)
    }

    @Singleton
    @Provides
    fun restProducto(retrofit: Retrofit): RestProducto{
        return retrofit.create(RestProducto::class.java)
    }
    @Singleton
    @Provides
    fun restMarca(retrofit: Retrofit): RestMarca{
        return retrofit.create(RestMarca::class.java)
    }
    @Singleton
    @Provides
    fun restCategoria(retrofit: Retrofit): RestCategoria{
        return retrofit.create(RestCategoria::class.java)
    }
    @Singleton
    @Provides
    fun restUnidadMedida(retrofit: Retrofit): RestUnidadMedida{
        return retrofit.create(RestUnidadMedida::class.java)
    }


    //Configuracion BD Local
    @Singleton
    @Provides
    fun dbDataSource(@ApplicationContext context: Context):
            DbDataSource{
        return Room.databaseBuilder(context,
                DbDataSource::class.java,
            "almacen_db")
            .build()
    }

    @Singleton
    @Provides
    fun actividadDao(db:DbDataSource): MarcaDao{
        return db.marcaDao()
    }


}