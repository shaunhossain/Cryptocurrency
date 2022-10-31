package com.shaunhossain.cryptocurrency.domain.use_case.get_coins

import com.shaunhossain.cryptocurrency.common.Resource
import com.shaunhossain.cryptocurrency.data.remote.dto.toCoin
import com.shaunhossain.cryptocurrency.domain.model.Coin
import com.shaunhossain.cryptocurrency.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor(
    private  val repository: CoinRepository
) {
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            emit(Resource.Loading())
            val  coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success(coins))
        }catch (e: HttpException){
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurs"))
        }catch (e: IOException){
            emit(Resource.Error("Couldn't reach server , check your internet connection"))
        }
    }
}