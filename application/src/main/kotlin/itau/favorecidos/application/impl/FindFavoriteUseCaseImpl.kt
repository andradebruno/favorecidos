package itau.favorecidos.application.impl

import itau.favorecidos.application.FindFavoriteUseCase
import itau.favorecidos.application.exception.NotFoundException
import itau.favorecidos.application.response.FavoriteAccountResponse
import itau.favorecidos.domain.repository.FavoriteAccountRepository
import itau.favorecidos.shared.vocabulary.annotation.UseCase

@UseCase
class FindFavoriteUseCaseImpl(private val favoriteRepository: FavoriteAccountRepository) : FindFavoriteUseCase {
    override fun execute(idCustomer: Long): List<FavoriteAccountResponse> {
        return favoriteRepository.findByIdCustomer(idCustomer).map { FavoriteAccountResponse().from(it) }
            .ifEmpty { throw NotFoundException() }
    }
}