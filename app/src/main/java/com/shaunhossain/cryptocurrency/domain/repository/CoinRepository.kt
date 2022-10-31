package com.shaunhossain.cryptocurrency.domain.repository

import com.shaunhossain.cryptocurrency.data.remote.dto.CoinDetailDto
import com.shaunhossain.cryptocurrency.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}