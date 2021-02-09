package itau.favorecidos.dataprovider

import itau.favorecidos.dataprovider.mapper.toEntity
import itau.favorecidos.dataprovider.mapper.toFavoriteAccount
import itau.favorecidos.dataprovider.repository.FavoriteAccountJpaRepository
import itau.favorecidos.domain.FavoriteAccount
import itau.favorecidos.domain.repository.FavoriteAccountRepository

class FavoriteAccountRepositoryImpl(private val jpaRepository: FavoriteAccountJpaRepository) :
    FavoriteAccountRepository {
    override fun create(favoriteAccount: FavoriteAccount): FavoriteAccount {
        return jpaRepository.save(favoriteAccount.toEntity()).toFavoriteAccount()
    }

    override fun delete(favoriteAccount: FavoriteAccount) {
        jpaRepository.delete(favoriteAccount.toEntity())
    }

    override fun findByIdFavorite(idFavoriteAccount: Long): FavoriteAccount? {
        return jpaRepository.findByIdFavoriteAccount(idFavoriteAccount)?.toFavoriteAccount()
    }

    override fun findByIdCustomer(idCustomer: Long): List<FavoriteAccount> {
        return jpaRepository.findByIdCustomer(idCustomer).map { it.toFavoriteAccount() }
    }

    override fun update(favoriteAccount: FavoriteAccount): FavoriteAccount {
        return jpaRepository.save(favoriteAccount.toEntity()).toFavoriteAccount()
     }
}