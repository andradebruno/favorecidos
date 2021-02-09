package itau.favorecidos.application

import itau.favorecidos.application.request.CreateRequest
import itau.favorecidos.application.response.FavoriteAccountResponse

interface CreateFavoriteUseCase {
    fun execute(request: CreateRequest): FavoriteAccountResponse
}