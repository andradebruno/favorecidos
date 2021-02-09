package itau.favorecidos.application

import itau.favorecidos.application.request.UpdateRequest
import itau.favorecidos.application.response.FavoriteAccountResponse

interface UpdateFavoriteUseCase {
    fun execute(idFavoriteAccount: Long, request: UpdateRequest): FavoriteAccountResponse
}