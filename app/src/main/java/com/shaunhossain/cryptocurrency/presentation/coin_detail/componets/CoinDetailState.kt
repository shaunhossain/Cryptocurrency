package com.shaunhossain.cryptocurrency.presentation.coin_detail.componets

import com.shaunhossain.cryptocurrency.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
