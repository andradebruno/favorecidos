package itau.favorecidos.application.request


import br.com.caelum.stella.format.CNPJFormatter
import br.com.caelum.stella.format.CPFFormatter
import br.com.caelum.stella.validation.CNPJValidator
import br.com.caelum.stella.validation.CPFValidator
import br.com.caelum.stella.validation.InvalidStateException
import itau.favorecidos.domain.FavoriteAccount


data class CreateRequest(
    val idCustomer: Long = 0,
    val bankAccount: String = "",
    val codAgency: Int = 0,
    var document: String = "",
    val namePerson: String = ""
) {
    fun isDocumentValid(): Boolean {
        return try {
            if (CPFValidator(CPFFormatter().isFormatted(document)).isEligible(document)) {
                document = CPFFormatter().unformat(document)
                CPFValidator().assertValid(document)
            } else if (CNPJValidator(CNPJFormatter().isFormatted(document)).isEligible(document)){
                document = CNPJFormatter().unformat(document)
                CNPJValidator().assertValid(document)
            }
            true
        } catch (e: InvalidStateException) {
            false
        }
    }

    fun toDomain(): FavoriteAccount {
        return FavoriteAccount(0, idCustomer, bankAccount, codAgency, document, namePerson)
    }

}
