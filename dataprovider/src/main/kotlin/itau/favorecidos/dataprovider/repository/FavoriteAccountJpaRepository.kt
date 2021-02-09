package itau.favorecidos.dataprovider.repository

import itau.favorecidos.dataprovider.entity.FavoriteAccountEntity
import org.springframework.data.repository.CrudRepository

interface FavoriteAccountJpaRepository : CrudRepository<FavoriteAccountEntity, Long> {
    fun findByIdFavoriteAccount(idFavoriteAccount: Long): FavoriteAccountEntity?
    fun findByIdCustomer(idCustomer: Long): List<FavoriteAccountEntity>
}