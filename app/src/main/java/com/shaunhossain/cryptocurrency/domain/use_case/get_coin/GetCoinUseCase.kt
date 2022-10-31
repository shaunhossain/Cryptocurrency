package com.shaunhossain.cryptocurrency.domain.use_case.get_coin

import com.shaunhossain.cryptocurrency.common.Resource
import com.shaunhossain.cryptocurrency.data.remote.dto.toCoin
import com.shaunhossain.cryptocurrency.data.remote.dto.toCoinDetail
import com.shaunhossain.cryptocurrency.domain.model.Coin
import com.shaunhossain.cryptocurrency.domain.model.CoinDetail
import com.shaunhossain.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor(
    private  val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetail>> = flow {
        try {
            emit(Resource.Loading())
            val  coin = repository.getCoinById(coinId).toCoinDetail()
            emit(Resource.Success(coin))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurs"))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server , check your internet connection"))
        }
    }
}