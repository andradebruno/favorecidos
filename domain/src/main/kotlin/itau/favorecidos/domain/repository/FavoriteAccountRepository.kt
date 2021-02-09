package itau.favorecidos.domain.repository

import itau.favorecidos.domain.FavoriteAccount

interface FavoriteAccountRepository {
    fun create(favoriteAccount: FavoriteAccount): FavoriteAccount
    fun delete(favoriteAccount: FavoriteAccount)
    fun findByIdFavorite(idFavoriteAccount: Long): FavoriteAccount?
    fun findByIdCustomer(idCustomer: Long): List<FavoriteAccount>
    fun update(favoriteAccount: FavoriteAccount): FavoriteAccount
}