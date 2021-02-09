package itau.favorecidos.application.impl

import itau.favorecidos.application.CreateFavoriteUseCase
import itau.favorecidos.application.exception.InvalidDocumentException
import itau.favorecidos.application.request.CreateRequest
import itau.favorecidos.application.response.FavoriteAccountResponse
import itau.favorecidos.domain.repository.FavoriteAccountRepository
import itau.favorecidos.shared.vocabulary.annotation.UseCase

@UseCase
class CreateFavoriteUseCaseImpl(private val favoriteRepository: FavoriteAccountRepository) : CreateFavoriteUseCase {
    override fun execute(request: CreateRequest): FavoriteAccountResponse {
        if(request.isDocumentValid()) {
            val favoriteAccount = request.toDomain()
            return FavoriteAccountResponse().from(favoriteRepository.create(favoriteAccount))
        } else {
            throw InvalidDocumentException()
        }
    }
}