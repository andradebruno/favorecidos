package itau.favorecidos.application.impl

import itau.favorecidos.application.DeleteFavoriteUseCase
import itau.favorecidos.application.exception.NotFoundException
import itau.favorecidos.domain.repository.FavoriteAccountRepository
import itau.favorecidos.shared.vocabulary.annotation.UseCase

@UseCase
class DeleteFavoriteUseCaseImpl(private val favoriteRepository: FavoriteAccountRepository) : DeleteFavoriteUseCase {
    override fun execute(idFavoriteAccount: Long) {
        favoriteRepository.findByIdFavorite(idFavoriteAccount)
            ?.let { favoriteRepository.delete(it) } ?: throw NotFoundException()
    }
}

