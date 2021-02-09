package itau.favorecidos.dataprovider.mapper

import itau.favorecidos.dataprovider.entity.FavoriteAccountEntity
import itau.favorecidos.domain.FavoriteAccount

fun FavoriteAccount.toEntity() = FavoriteAccountEntity(idFavoriteAccount, idCustomer, bankAccount, codAgency, document, namePerson)
fun FavoriteAccountEntity.toFavoriteAccount() = FavoriteAccount(idFavoriteAccount, idCustomer, bankAccount, codAgency, document, namePerson)