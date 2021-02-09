package itau.favorecidos.domain

data class FavoriteAccount(
    val idFavoriteAccount: Long = 0,
    val idCustomer: Long = 0,
    var bankAccount: String = "",
    var codAgency: Int = 0,
    val document: String = "",
    val namePerson: String = ""
)
