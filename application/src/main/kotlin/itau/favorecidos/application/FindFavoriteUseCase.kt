package itau.favorecidos.application

import itau.favorecidos.application.response.FavoriteAccountResponse

interface FindFavoriteUseCase {
    fun execute(idCustomer: Long): List<FavoriteAccountResponse>
}