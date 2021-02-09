package itau.favorecidos.application.response

import itau.favorecidos.domain.FavoriteAccount

data class FavoriteAccountResponse(
    val idFavoriteAccount: Long = 0,
    val idCustomer: Long = 0,
    val bankAccount: String = "",
    val codAgency: Int = 0,
    val document: String = "",
    val namePerson: String = ""
) {
    fun from(favoriteAccount: FavoriteAccount): FavoriteAccountResponse {
        return FavoriteAccountResponse(
            favoriteAccount.idFavoriteAccount,
            favoriteAccount.idCustomer,
            favoriteAccount.bankAccount,
            favoriteAccount.codAgency,
            favoriteAccount.document,
            favoriteAccount.namePerson
        )
    }
}
