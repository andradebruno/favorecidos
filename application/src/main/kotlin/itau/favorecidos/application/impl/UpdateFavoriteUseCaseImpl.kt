package itau.favorecidos.application.impl

import itau.favorecidos.application.UpdateFavoriteUseCase
import itau.favorecidos.application.exception.NotFoundException
import itau.favorecidos.application.request.UpdateRequest
import itau.favorecidos.application.response.FavoriteAccountResponse
import itau.favorecidos.domain.repository.FavoriteAccountRepository
import itau.favorecidos.shared.vocabulary.annotation.UseCase

@UseCase
class UpdateFavoriteUseCaseImpl(private val favoriteRepository: FavoriteAccountRepository) : UpdateFavoriteUseCase {
    override fun execute(idFavoriteAccount: Long, request: UpdateRequest): FavoriteAccountResponse {
        return FavoriteAccountResponse().from(favoriteRepository.findByIdFavorite(idFavoriteAccount)
            ?.let {
                it.bankAccount = request.bankAccount
                it.codAgency = request.codAgency
                favoriteRepository.update(it)
            } ?: throw NotFoundException())
    }
}