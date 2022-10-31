package com.shaunhossain.cryptocurrency.data.repository

import com.shaunhossain.cryptocurrency.data.remote.CoinPaprikaApi
import com.shaunhossain.cryptocurrency.data.remote.dto.CoinDetailDto
import com.shaunhossain.cryptocurrency.data.remote.dto.CoinDto
import com.shaunhossain.cryptocurrency.domain.repository.CoinRepository
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinPaprikaApi
): CoinRepository{
    override suspend fun getCoins(): List<CoinDto> {
        return getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return getCoinById(coinId)
    }
}