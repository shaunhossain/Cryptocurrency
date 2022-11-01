package com.shaunhossain.cryptocurrency.di

import com.shaunhossain.cryptocurrency.common.Constants
import com.shaunhossain.cryptocurrency.data.remote.CoinPaprikaApi
import com.shaunhossain.cryptocurrency.data.repository.CoinRepositoryImpl
import com.shaunhossain.cryptocurrency.domain.repository.CoinRepository
import com.shaunhossain.cryptocurrency.domain.use_case.get_coin.GetCoinUseCase
import com.shaunhossain.cryptocurrency.domain.use_case.get_coins.GetCoinsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePaprikaApi(): CoinPaprikaApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CoinPaprikaApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCoinRepository(api: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetCoinUseCase(repository: CoinRepository): GetCoinUseCase {
        return GetCoinUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideGetCoinsUseCase(repository: CoinRepository): GetCoinsUseCase {
        return GetCoinsUseCase(repository)
    }


}